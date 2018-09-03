package com.gloomyfox.rule;

import com.gloomyfox.dao.DummyUserLogDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleCTests {

    private static final int BOUNDARY_VALUE = 3;
    private static final int LOWER_VALUE = 0;
    private static final int HIGHER_VALUE = 100;

    private RuleC rule;

    @Before
    public void setUp() {
        this.rule = new RuleC(new DummyUserLogDAO());
    }

    @Test
    public void BoundaryValueTest() {
        Assert.assertTrue(rule.verify(BOUNDARY_VALUE));
    }

    @Test
    public void LowerValueTest() {
        Assert.assertFalse(rule.verify(LOWER_VALUE));
    }

    @Test
    public void HigherValueTest() {
        Assert.assertTrue(rule.verify(HIGHER_VALUE));
    }
}
