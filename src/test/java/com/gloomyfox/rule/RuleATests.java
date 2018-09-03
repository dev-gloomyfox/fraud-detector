package com.gloomyfox.rule;

import com.gloomyfox.dao.UserLogDAO;
import com.gloomyfox.domain.dto.RuleADTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RuleATests {

    private static final long MOCK_USER_ID = 0;

    private static final int COUNT_BOUNDARY_VALUE = 1;
    private static final int COUNT_LOWER_VALUE = 0;
    private static final int COUNT_HIGHER_VALUE = 2;

    private static final long BALANCE_BOUNDARY_VALUE = 1000L;
    private static final long BALANCE_LOWER_VALUE = 0L;
    private static final long BALANCE_HIGHER_VALUE = 10000L;

    private RuleA rule;
    private UserLogDAO userLogDAO;

    @Before
    public void setUp() {
        this.userLogDAO = Mockito.mock(UserLogDAO.class);
        this.rule = new RuleA(userLogDAO);
    }

    @Test
    public void isFraudAllBoundaryValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_BOUNDARY_VALUE, BALANCE_BOUNDARY_VALUE));
        Assert.assertTrue(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountLowerBalanceLowerValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_LOWER_VALUE, BALANCE_LOWER_VALUE));
        Assert.assertFalse(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountLowerBalanceBoundaryValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_LOWER_VALUE, BALANCE_BOUNDARY_VALUE));
        Assert.assertFalse(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountLowerBalanceHigherValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_LOWER_VALUE, BALANCE_HIGHER_VALUE));
        Assert.assertFalse(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountBoundaryBalanceLowerValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_BOUNDARY_VALUE, BALANCE_LOWER_VALUE));
        Assert.assertTrue(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountBoundaryBalanceHigherValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_BOUNDARY_VALUE, BALANCE_HIGHER_VALUE));
        Assert.assertFalse(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountHigherBalanceLowerValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_HIGHER_VALUE, BALANCE_LOWER_VALUE));
        Assert.assertTrue(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountHigherBalanceBoundaryValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_HIGHER_VALUE, BALANCE_BOUNDARY_VALUE));
        Assert.assertTrue(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudCountHigherBalanceHigherValueTest() {
        Mockito.when(userLogDAO.selectRuleAData(MOCK_USER_ID))
                .thenReturn(new RuleADTO(COUNT_HIGHER_VALUE, BALANCE_HIGHER_VALUE));
        Assert.assertFalse(rule.isFraud(MOCK_USER_ID));
    }
}
