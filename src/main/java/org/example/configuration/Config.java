package org.example.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public class Config {
    private static final String fileName = "src/main/resources/config.properties";
    private static String TASK_QUEUE_NAME;

    private static String HOST_NAME;

    private static String USERNAME;

    private static String VIRTUAL_HOST_NAME;

    private static String PASSWORD;

    private static UUID idDevice1;

    private static UUID idDevice2;

    public Config() {
        Properties properties = new Properties();

        try (FileInputStream file = new FileInputStream(fileName)) {
            properties.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.TASK_QUEUE_NAME = properties.getProperty("queue.queue_name");
        this.HOST_NAME = properties.getProperty("queue.host_name");
        this.USERNAME = properties.getProperty("queue.username");
        this.VIRTUAL_HOST_NAME = properties.getProperty("queue.virtual_host_name");
        this.PASSWORD = properties.getProperty("queue.password");
        System.out.println(properties.getProperty("device.id1"));
        this.idDevice1 = UUID.fromString(properties.getProperty("device.id1"));
        this.idDevice2 = UUID.fromString(properties.getProperty("device.id2"));

    }

    public  String getTaskQueueName() {
        return TASK_QUEUE_NAME;
    }

    public  String getHostName() {
        return HOST_NAME;
    }

    public  String getPASSWORD() {
        return PASSWORD;
    }

    public  String getUSERNAME() {
        return USERNAME;
    }

    public  String getVirtualHostName() {
        return VIRTUAL_HOST_NAME;
    }

    public static UUID getIdDevice1() {
        return idDevice1;
    }

    public static UUID getIdDevice2() {
        return idDevice2;
    }
}
