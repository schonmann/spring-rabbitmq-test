package br.com.xuma.rabbittest.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvelopeDTO implements Serializable {

    @JsonProperty("from")
    public String from;
    
    @JsonProperty("body")
    public String body;

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
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
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
        return String.format("%d - %s: %s", timestamp, from, body);
    }
}