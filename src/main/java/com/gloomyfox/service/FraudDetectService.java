package com.gloomyfox.service;

public interface FraudDetectService {

    /**
     * 해당 userId의 유저가 이상 거래를 하는지를 탐지하여 결과를 문자열로 반환합니다.
     * @param userId 이상 거래를 판별할 유저의 ID
     * @return 이상 거래 내용에 대한 문자열 결과 값
     */
    String detect(long userId);
}
