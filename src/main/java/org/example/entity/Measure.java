package org.example.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

public class Measure implements Serializable{
    private UUID id;
    private float consumption;
    private Timestamp timestamp;

    public Measure(UUID id, float consumption, Timestamp timestamp) {
        this.id = id;
        this.consumption = consumption;
        this.timestamp = timestamp;
    }

    public Measure() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public float getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
