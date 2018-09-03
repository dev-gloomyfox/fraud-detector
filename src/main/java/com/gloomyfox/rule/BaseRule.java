package com.gloomyfox.rule;

/**
 * 룰 자체에 룰 검사에 대한 동작을 맡겨 룰의 책임을 다른데로 옮기지 않게 의도했습니다.
 *
 */
public abstract class BaseRule {

    private String ruleName;

    protected void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleName() {
        return ruleName;
    }

    /**
     * Rule 검사를 위한 메소드입니다. 해당 메소드에 이상 감지에 관한 내용을 구현해야 합니다.
     * @param userId 이상 감지할 userId
     * @return 이상 감지 여부
     */
    public abstract boolean isFraud(long userId);
}
