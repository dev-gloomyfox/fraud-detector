package com.gloomyfox.rule;

import com.gloomyfox.dao.UserLogDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RuleBTests {

    private static final long MOCK_USER_ID = 0;

    private static final int BOUNDARY_VALUE = 5;
    private static final int LOWER_VALUE = 0;
    private static final int HIGHER_VALUE = 100;

    private RuleB rule;
    private UserLogDAO userLogDAO;

    @Before
    public void setUp() {
        this.userLogDAO = Mockito.mock(UserLogDAO.class);
        this.rule = new RuleB(userLogDAO);
    }

    @Test
    public void isFraudBoundaryValueTest() {
        Mockito.when(userLogDAO.selectRuleBCount(MOCK_USER_ID)).thenReturn(BOUNDARY_VALUE);
        Assert.assertTrue(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudLowerValueTest() {
        Mockito.when(userLogDAO.selectRuleBCount(MOCK_USER_ID)).thenReturn(LOWER_VALUE);
        Assert.assertFalse(rule.isFraud(MOCK_USER_ID));
    }

    @Test
    public void isFraudHigherValueTest() {
        Mockito.when(userLogDAO.selectRuleBCount(MOCK_USER_ID)).thenReturn(HIGHER_VALUE);
        Assert.assertTrue(rule.isFraud(MOCK_USER_ID));
    }
}
