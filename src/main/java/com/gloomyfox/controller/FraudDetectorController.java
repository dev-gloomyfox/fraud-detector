package com.gloomyfox.controller;

import com.gloomyfox.domain.request.DetectFraudRequest;
import com.gloomyfox.domain.response.DetectFraudResponse;
import com.gloomyfox.service.FraudDetectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FraudDetectorController {

    private FraudDetectService fraudDetectService;

    @Autowired
    public FraudDetectorController(FraudDetectService fraudDetectService) {
        this.fraudDetectService = fraudDetectService;
    }

    @GetMapping("/v1/fraud/{userId}")
    public DetectFraudResponse detectFraud(DetectFraudRequest request) {
        return new DetectFraudResponse(request.getUserId(), fraudDetectService.detect(request.getUserId()));
    }
}
