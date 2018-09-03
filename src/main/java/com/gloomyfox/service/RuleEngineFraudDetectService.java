package com.gloomyfox.service;

import com.gloomyfox.dao.UserLogDAO;
import com.gloomyfox.rule.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class RuleEngineFraudDetectService implements FraudDetectService {

    private UserLogDAO userLogDAO;
    private RuleEngine ruleEngine;

    @Autowired
    public RuleEngineFraudDetectService(UserLogDAO userLogDAO) {
        this.userLogDAO = userLogDAO;
        this.ruleEngine = new RuleEngine(Collections.unmodifiableList(
                Arrays.asList(new RuleA(userLogDAO), new RuleB(userLogDAO), new RuleC(userLogDAO))
        ));

    }

    @Override
    public String detect(long userId) {
        if(!userLogDAO.checkCreatedUser(userId)) {
            throw new NullPointerException("This user is not created");
        }

        return refineData(ruleEngine.detectFraud(userId));
    }

    String refineData(List<? extends BaseRule> ruleList) {
        if(ruleList.isEmpty()) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();

            Iterator<? extends BaseRule> ruleIter = ruleList.iterator();

            while(ruleIter.hasNext()) {
                builder.append(ruleIter.next().getRuleName());

                if(ruleIter.hasNext()) {
                    builder.append(", ");
                }
            }
            return builder.toString();
        }
    }
}
