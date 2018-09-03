package com.gloomyfox.rule;

import com.gloomyfox.dao.DummyUserLogDAO;
import com.gloomyfox.dao.UserLogDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * RuleEngine에 대한 테스트로 Dummy를 활용합니다.
 * userId: 정의
 * 0: 모든 룰에 검출 X
 * 1: A 룰에 검출
 * 2: B 룰에 검출(A룰에 대해 20만을 충전한 적은 있으나, 최저 잔액이 1000원 초과인 경우)
 * 3: C 룰에 검출(A룰에 대해 20만을 충전한 적은 없으나, 최저 잔액이 1000원 이하인 경우)
 * 4: A, B 룰에 검출
 * 5: A, C 룰에 검출
 * 6: B, C 룰에 검출
 * 7: A, B, C 룰에 검출
 */
public class RuleEngineTests {

    private static final long RULE_A_USER = 1;
    private static final long RULE_B_USER = 2;
    private static final long RULE_C_USER = 3;
    private static final long RULE_A_B_USER = 4;
    private static final long RULE_A_C_USER = 5;
    private static final long RULE_B_C_USER = 6;
    private static final long RULE_A_B_C_USER = 7;
    private static final long RULE_NOTHING_USER = 0;

    private static final UserLogDAO DUMMY_USER_LOG_DAO = new DummyUserLogDAO();
    private static final BaseRule RULE_A = new RuleA(DUMMY_USER_LOG_DAO);
    private static final BaseRule RULE_B = new RuleB(DUMMY_USER_LOG_DAO);
    private static final BaseRule RULE_C = new RuleC(DUMMY_USER_LOG_DAO);

    private RuleEngine engine;

    @Before
    public void setUp() {
        this.engine = new RuleEngine(Collections.unmodifiableList(
                Arrays.asList(RULE_A, RULE_B, RULE_C)
        ));
    }

    @Test
    public void detectRuleATest() {
        Assert.assertEquals(Collections.singletonList(RULE_A), engine.detectFraud(RULE_A_USER));

    }

    @Test
    public void detectRuleBTest() {
        Assert.assertEquals(Collections.singletonList(RULE_B), engine.detectFraud(RULE_B_USER));
    }

    @Test
    public void detectRuleCTest() {
        Assert.assertEquals(Collections.singletonList(RULE_C), engine.detectFraud(RULE_C_USER));
    }

    @Test
    public void detectRuleARuleBTest() {
        Assert.assertEquals(Arrays.asList(RULE_A, RULE_B), engine.detectFraud(RULE_A_B_USER));
    }

    @Test
    public void detectRuleARuleCTest() {
        Assert.assertEquals(Arrays.asList(RULE_A, RULE_C), engine.detectFraud(RULE_A_C_USER));
    }

    @Test
    public void detectRuleBRuleCTest() {
        Assert.assertEquals(Arrays.asList(RULE_B, RULE_C), engine.detectFraud(RULE_B_C_USER));
    }

    @Test
    public void detectRuleARuleBRuleCTest() {
        Assert.assertEquals(Arrays.asList(RULE_A, RULE_B, RULE_C), engine.detectFraud(RULE_A_B_C_USER));
    }

    @Test
    public void detectNothingTest() {
        Assert.assertEquals(Collections.emptyList(), engine.detectFraud(RULE_NOTHING_USER));
    }
}
