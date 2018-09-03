package com.gloomyfox.rule;

import com.gloomyfox.dao.UserLogDAO;
import com.gloomyfox.domain.dto.RuleADTO;

public class RuleA extends BaseRule {

    private static final int COUNT_BOUNDARY_VALUE = 1;
    private static final long BALANCE_BOUNDARY_VALUE = 1000;

    private UserLogDAO userLogDAO;

    public RuleA(UserLogDAO userLogDAO) {
        super.setRuleName("RuleA");
        this.userLogDAO = userLogDAO;
    }

    @Override
    public boolean isFraud(long userId) {
        RuleADTO dto = userLogDAO.selectRuleAData(userId);

        return !(dto.getCount() < COUNT_BOUNDARY_VALUE) && !(dto.getBalance() > BALANCE_BOUNDARY_VALUE);
    }
}
