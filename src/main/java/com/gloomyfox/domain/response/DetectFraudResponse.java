package com.gloomyfox.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetectFraudResponse {

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("is_fraud")
    private boolean isFraud;

    @JsonProperty("rule")
    private String rule;

    public DetectFraudResponse(long userId, String rule) {
        this.userId = userId;
        this.rule = rule;
        this.isFraud = !rule.isEmpty();
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getUserId() {
        return userId;
    }

    public void setIsFraud(boolean isFraud) {
        this.isFraud = isFraud;
    }
    public boolean getIsFraud() {
        return isFraud;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }
    public String getRule() {
        return rule;
    }
}
