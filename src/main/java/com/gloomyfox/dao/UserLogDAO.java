package com.gloomyfox.dao;

import com.gloomyfox.domain.dto.RuleADTO;

public interface UserLogDAO {

    /**
     * 해당 userId가 실제 생성된 유저인지 확인합니다.
     * @param userId 확인할 userId
     * @return 생성이 되어있을 시 true, 아닐 시 false를 반환
     */
    boolean checkCreatedUser(long userId);

    /**
     * 계좌 개설을 하고 1시간 이내, 20만원 충전 횟수, 충전 후 최저 잔액을 가져옵니다.
     * @param userId 검색할 userId
     * @return 계좌 개설 후 1시간 이내, 20만원 충전 횟수, 충전 후 최저 잔액을 가진 DTO
     */
    RuleADTO selectRuleAData(long userId);

    /**
     * 계좌 개설을 하고 7일 이내, 10만원 이상 금액을 받은 횟수를 가져옵니다.
     * @param userId 검색할 userId
     * @return 계좌 개설 후 7일 이내, 10만원 이상 금액을 받은 횟수
     */
    int selectRuleBCount(long userId);

    /**
     * 2시간 이내, 5만원 이상 금액을 받은 횟수를 가져옵니다.
     * @param userId 검색할 userId
     * @return 2시간 이내, 5만원 이상 금액을 받은 횟수
     */
    int selectRuleCCount(long userId);
}
