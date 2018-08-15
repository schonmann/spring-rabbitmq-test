package br.com.xuma.rabbittest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvelopeDTO {

    @JsonProperty("from")
    public String from;

    @JsonProperty("timestamp")
    public Long timestamp;

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", timestamp, from);
    }
}