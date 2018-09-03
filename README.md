# Fraud Detector

해당 저장소는 카카오페이 공개 채용의 데이터 서비스 개발 과제에 대한 저장소입니다.
해당 프로젝트는 Java 8 버전 이상이 필요하고, Gradle 기반입니다.


## API
GET /v1/fraud/{user_id} : 해당 유저에 대한 이상을 감지하여 반환합니다.
- REQUEST PARAM: user_id(long, 필수)
- RESPONSE BODY: JSON {"user_id": 요청한 user_id(long), "is_fraud": 이상 감지 여부(boolean), "rule": "감지된 룰의 종류(String)"}

## Dummy User Log
해당 프로젝트의 default profile은 Dummy User Log를 사용하게 만들어졌습니다.
Dummy User의 정보는 다음과 같습니다.

user_id: 정의 순으로 나열합니다.

0: 모든 룰에 검출 X
1: A 룰에 검출
2: B 룰에 검출
3: C 룰에 검출
4: A, B 룰에 검출
5: A, C 룰에 검출
6: B, C 룰에 검출
7: A, B, C 룰에 검출
8: 모든 룰에 검출 X
9: 생성되지 않은 유저(500 Error 발생)

## Instructions
프로젝트 경로에서 터미널을 사용합니다.

BUILD: ./gradlew build
EXECUTE: java -jar build/libs/fraud-detector-1.0.0.jar
BUILD & EXECUTE: ./gradlew build && java -jar build/libs/fraud-detector-1.0.0.jar