package com.gloomyfox.rule;

import com.gloomyfox.dao.UserLogDAO;

public class RuleB extends BaseRule {

    private static final int COUNT_BOUNDARY_VALUE = 5;

    private UserLogDAO userLogDAO;

    public RuleB(UserLogDAO userLogDAO) {
        super.setRuleName("RuleB");
        this.userLogDAO = userLogDAO;
    }

    @Override
    public boolean isFraud(long userId) {
        return !(userLogDAO.selectRuleBCount(userId) < COUNT_BOUNDARY_VALUE);
    }
}
