package com.gloomyfox.dao;

public interface UserLogDAO {

    // 각 쿼리에 대한 간단한 힌트 정도를 써주면 좋을 것 같다.
    boolean checkCreatedUser(long userId);

    // RuleA 관련해서 Datasource에는 한 번만 접근하는게 좋지 않을까? 쿼리가 다소 복잡해지는 것은 있을 것 같다.
    // 한 시간 이내의 잔액 조회를 하는 부분이 Datasource에 많은 부담을 줄까?
    int selectRuleALoadMoneyCount(long userId);

    long selectRuleABalance(long userId);

    int selectRuleBCount(long userId);

    int selectRuleCCount(long userId);
}
