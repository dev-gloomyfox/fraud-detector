package com.gloomyfox.dummy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DummyData {

    public static final Map<Long, Integer> CREATED_USER_DUMMY;
    static {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        map.put(1L, 1);
        map.put(2L, 1);
        map.put(3L, 1);
        map.put(4L, 1);
        map.put(5L, 1);
        map.put(6L, 1);
        map.put(7L, 1);
        map.put(8L, 1); // 유저는 있으나, 다른 데이터 정의가 없는 경우

        CREATED_USER_DUMMY = Collections.unmodifiableMap(map);
    }

    // 0: 모든 룰에 검출 X
    // 1: A 룰에 검출
    // 2: B 룰에 검출(A룰에 대해 20만을 충전한 적은 있으나, 최저 잔액이 1000원이 넘는 경우)
    // 3: C 룰에 검출(A룰에 대해 20만을 충전한 적은 없으나, 최저 잔액이 1000원 이하인 경우)
    // 4: A, B 룰에 검출
    // 5: A, C 룰에 검출
    // 6: B, C 룰에 검출
    // 7: A, B, C 룰에 검출

    public static final Map<Long, Integer> RULE_A_LOAD_MONEY_DUMMY;
    static {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        map.put(1L, 1);
        map.put(2L, 1);
        map.put(3L, 0);
        map.put(4L, 2);
        map.put(5L, 3);
        map.put(6L, 0);
        map.put(7L, 4);

        RULE_A_LOAD_MONEY_DUMMY = Collections.unmodifiableMap(map);
    }

    public static final Map<Long, Long> RULE_A_BALACE_DUMMY;
    static {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 0L);
        map.put(1L, 1000L);
        map.put(2L, 10000L);
        map.put(3L, 1000L);
        map.put(4L, 0L);
        map.put(5L, 1000L);
        map.put(6L, 0L);
        map.put(7L, 1000L);

        RULE_A_BALACE_DUMMY = Collections.unmodifiableMap(map);
    }

    public static final Map<Long, Integer> RULE_B_COUNT_DUMMY;
    static {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        map.put(1L, 4);
        map.put(2L, 5);
        map.put(3L, 3);
        map.put(4L, 5);
        map.put(5L, 2);
        map.put(6L, 5);
        map.put(7L, 5);

        RULE_B_COUNT_DUMMY = Collections.unmodifiableMap(map);
    }

    public static final Map<Long, Integer> RULE_C_COUNT_DUMMY;
    static {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 0);
        map.put(1L, 2);
        map.put(2L, 1);
        map.put(3L, 3);
        map.put(4L, 0);
        map.put(5L, 3);
        map.put(6L, 3);
        map.put(7L, 3);

        RULE_C_COUNT_DUMMY = Collections.unmodifiableMap(map);
    }
}
