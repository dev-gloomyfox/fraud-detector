package com.gloomyfox.rule;

import com.gloomyfox.dao.UserLogDAO;

public class RuleA extends BaseRule {

    private static final int LOAD_MONEY_BOUNDARY_VALUE = 1;
    private static final long BALANCE_BOUNDARY_VALUE = 1000;

    private UserLogDAO userLogDAO;

    public RuleA(UserLogDAO userLogDAO) {
        super.setRuleName("RuleA");
        this.userLogDAO = userLogDAO;
    }

    @Override
    public boolean isFraud(long userId) {
        if(verifyLoadMoneyCount(userLogDAO.selectRuleALoadMoneyCount(userId))) {
            return verifyBalance(userLogDAO.selectRuleABalance(userId));
        } else {
            return false;
        }
    }

    boolean verifyLoadMoneyCount(long loadMoney) {
        return !(loadMoney < LOAD_MONEY_BOUNDARY_VALUE);
    }

    boolean verifyBalance(long balance) {
        return !(balance > BALANCE_BOUNDARY_VALUE);
    }
}
