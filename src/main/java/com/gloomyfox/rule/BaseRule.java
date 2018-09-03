package com.gloomyfox.rule;

public abstract class BaseRule {

    private String ruleName;

    protected void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleName() {
        return ruleName;
    }

    public abstract boolean isFraud(long userId);
}
