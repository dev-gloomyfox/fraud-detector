package com.gloomyfox.domain.request;

public class DetectFraudRequest {

    private long userId;

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public long getUserId() {
        return userId;
    }
}
