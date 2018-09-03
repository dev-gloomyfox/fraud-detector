package com.gloomyfox.rule;

import java.util.List;
import java.util.stream.Collectors;

/**
 * RuleEngine은 검사할 Rule들의 List를 생성자로 받아서, 등록된 Rule들을 검사하고 검출된 룰들만을 반환하는 역할을 합니다.
 * 해당 방법으로 룰의 추가 또는 삭제를 쉽게하려고 했습니다.
 */
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
