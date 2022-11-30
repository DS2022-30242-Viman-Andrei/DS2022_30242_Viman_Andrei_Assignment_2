package org.example.configuration;

import java.util.UUID;

public class Config {
    private static final String TASK_QUEUE_NAME = "task_queue";

    private static final String HOST_NAME = "goose.rmq2.cloudamqp.com";

    private static final String USERNAME = "xobhpwib";

    private static final String VIRTUAL_HOST_NAME = "xobhpwib";

    private static final String PASSWORD = "8RHcJT0dX2MSYo8NALRPfnxzf7Aw6ab-";

    private static final UUID idDevice1 = UUID.fromString("3914cfb3-be8e-4aab-a0c4-f2e984a68be3");

    private static final UUID idDevice2 = UUID.fromString("c8cc7a39-b04f-4ef3-9cc9-3706f048e31b");

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
