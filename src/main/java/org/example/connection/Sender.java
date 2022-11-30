package org.example.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.example.configuration.Config;
import org.example.entity.Measure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;


public class Sender {

    private static Config config = new Config();

    private static int decision = 0;

    private static ConnectionFactory createConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(config.getHostName());
        factory.setUsername(config.getUSERNAME());
        factory.setVirtualHost(config.getVirtualHostName());
        factory.setPassword(config.getPASSWORD());
        factory.setRequestedHeartbeat(30);
        factory.setConnectionTimeout(30000);
        return factory;

    }


    public static void sender() throws Exception {

        ConnectionFactory factory = createConnection();

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(config.getTaskQueueName(), true, false, false, null);

        BufferedReader csv = new BufferedReader(new FileReader("src/main/java/org/example/sensor.csv"));
        String line = null;

        while ((line = csv.readLine()) != null)
        {
            String message = line.split(",")[0];

            UUID id = null;
            if (decision % 2 == 0){
                id = config.getIdDevice1();
            }
            else {
                id = config.getIdDevice2();
            }

            decision++;

            Measure measure = new Measure(id,
                    Float.parseFloat(message),
                    Timestamp.from(Instant.now()));

            String object = new ObjectMapper().writeValueAsString(measure);

            channel.basicPublish("", config.getTaskQueueName(), null,
                    object.getBytes());

            System.out.println(" [x] Sent '" + object + "'");
            Thread.sleep(6000);
        }
    }

}