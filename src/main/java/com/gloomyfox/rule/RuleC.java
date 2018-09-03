package com.gloomyfox.rule;

import com.gloomyfox.dao.UserLogDAO;

public class RuleC extends BaseRule {

    private static final int COUNT_BOUNDARY_VALUE = 3;

    private UserLogDAO userLogDAO;

    public RuleC(UserLogDAO userLogDAO) {
        super.setRuleName("RuleC");
        this.userLogDAO = userLogDAO;
    }

    @Override
    public boolean isFraud(long userId) {
        return !(userLogDAO.selectRuleCCount(userId) < COUNT_BOUNDARY_VALUE);
    }
}
