package com.gloomyfox.rule;

import java.util.List;
import java.util.stream.Collectors;

public class RuleEngine {

    private List<? extends BaseRule> ruleList;

    public RuleEngine(List<? extends BaseRule> ruleList) {
        this.ruleList = ruleList;
    }

    public List<? extends BaseRule> detectFraud(long userId) {
        return ruleList.stream()
                .filter(rule -> rule.isFraud(userId))
                .collect(Collectors.toList());
    }
}
