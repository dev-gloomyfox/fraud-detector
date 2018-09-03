package com.gloomyfox.dao;

import com.gloomyfox.domain.dto.RuleADTO;
import com.gloomyfox.dummy.DummyData;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("default")
@Repository
public class DummyUserLogDAO implements UserLogDAO {

    @Override
    public boolean checkCreatedUser(long userId) {
        return DummyData.CREATED_USER_DUMMY.get(userId) != null;
   }

   @Override
    public RuleADTO selectRuleAData(long userId) {
        return DummyData.RULE_A_DTO_DUMMY.get(userId) == null ?
                new RuleADTO(0, 0) : DummyData.RULE_A_DTO_DUMMY.get(userId);
    }

    @Override
    public int selectRuleBCount(long userId) {
        return DummyData.RULE_B_COUNT_DUMMY.get(userId) == null ?
                0 : DummyData.RULE_B_COUNT_DUMMY.get(userId);
    }

    @Override
    public int selectRuleCCount(long userId) {
        return DummyData.RULE_C_COUNT_DUMMY.get(userId) == null ?
                0 : DummyData.RULE_C_COUNT_DUMMY.get(userId);
    }
}
