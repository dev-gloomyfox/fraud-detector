package com.gloomyfox.service;

import com.gloomyfox.dao.DummyUserLogDAO;
import com.gloomyfox.dao.UserLogDAO;
import com.gloomyfox.rule.RuleA;
import com.gloomyfox.rule.RuleB;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class RuleEngineFraudDetectServiceTests {

    private static final long DETECT_TEST_USER = 7;
    private static final long DETECT_NOT_CREATE_USER = 9;
    private static final String DETECT_EXPECTED_STRING = "RuleA, RuleB, RuleC";

    private static final String REFINE_EMPTY_EXPECTED_STRING = "";
    private static final String REFINE_ONE_EXPECTED_STRING = "RuleA";
    private static final String REFINE_MANY_EXPECTED_STRING = "RuleA, RuleB";

    private RuleEngineFraudDetectService fraudDetectService;

    @Before
    public void setUp() {
        this.fraudDetectService = new RuleEngineFraudDetectService(new DummyUserLogDAO());
    }

    @Test
    public void detectTest() {
        Assert.assertEquals(DETECT_EXPECTED_STRING, fraudDetectService.detect(DETECT_TEST_USER));
    }

    @Test(expected = NullPointerException.class)
    public void detectNotCreateUserTest() {
        fraudDetectService.detect(DETECT_NOT_CREATE_USER);
    }

    @Test
    public void refineDataEmptyListTest() {
        Assert.assertEquals(REFINE_EMPTY_EXPECTED_STRING, fraudDetectService.refineData(Collections.emptyList()));
    }

    @Test
    public void refineDataOneListTest() {
        UserLogDAO userLogDAO = Mockito.mock(UserLogDAO.class);
        Assert.assertEquals(REFINE_ONE_EXPECTED_STRING,
                fraudDetectService.refineData(Collections.singletonList(new RuleA(userLogDAO))));

    }

    @Test
    public void refineDataManyListTest() {
        UserLogDAO userLogDAO = Mockito.mock(UserLogDAO.class);
        Assert.assertEquals(REFINE_MANY_EXPECTED_STRING,
                fraudDetectService.refineData(Arrays.asList(new RuleA(userLogDAO), new RuleB(userLogDAO))));
    }
}
