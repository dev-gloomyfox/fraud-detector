package com.gloomyfox.rule;

import com.gloomyfox.dao.DummyUserLogDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleATests {

    private static final int LOAD_MONEY_COUNT_BOUNDARY_VALUE = 1;
    private static final int LOAD_MONEY_COUNT_LOWER_VALUE = 0;
    private static final int LOAD_MONEY_COUNT_HIGHER_VALUE = 2;

    private static final long BALANCE_BOUNDARY_VALUE = 1000L;
    private static final long BALANCE_LOWER_VALUE = 0L;
    private static final long BALANCE_HIGHER_VALUE = 10000L;

    private RuleA rule;

    @Before
    public void setUp() {
        this.rule = new RuleA(new DummyUserLogDAO());
    }

    @Test
    public void verifyLoadMoneyCountBoundaryValueTest() {
        Assert.assertTrue(rule.verifyLoadMoneyCount(LOAD_MONEY_COUNT_BOUNDARY_VALUE));
    }

    @Test
    public void verifyLoadMoneyCountLowerValueTest() {
        Assert.assertFalse(rule.verifyLoadMoneyCount(LOAD_MONEY_COUNT_LOWER_VALUE));
    }

    @Test
    public void verifyLoadMoneyCountHigherValueTest() {
        Assert.assertTrue(rule.verifyLoadMoneyCount(LOAD_MONEY_COUNT_HIGHER_VALUE));
    }

    @Test
    public void verifyBalanceBoundaryValueTest() {
        Assert.assertTrue(rule.verifyBalance(BALANCE_BOUNDARY_VALUE));
    }

    @Test
    public void verifyBalanceLowerValueTest() {

    }

    @Test
    public void verifyBalanceHigherValueTest() {

    }
}
