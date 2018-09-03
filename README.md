# Fraud Detector

해당 저장소는 카카오페이 공개 채용의 데이터 서비스 개발 과제에 대한 저장소입니다.
해당 프로젝트는 Java 8 버전 이상이 필요하고, Gradle 기반, Spring Boot를 사용하였습니다.


## API
GET /v1/fraud/{user_id} : 해당 유저에 대한 이상을 감지하여 반환합니다.
- REQUEST PARAM: user_id(long, 필수)
- RESPONSE BODY: 
JSON {"user_id": 요청한 user_id(long), "is_fraud": 이상 감지 여부(boolean), "rule": "감지된 룰의 종류(String)"}

## Dummy User Log
해당 프로젝트의 default profile은 Dummy User Log를 사용하게 만들어졌습니다.
Dummy User의 정보는 다음과 같습니다.

user_id: 정의 순으로 나열합니다.

- 0: 모든 룰에 검출 X
- 1: A 룰에 검출
- 2: B 룰에 검출
- 3: C 룰에 검출
- 4: A, B 룰에 검출
- 5: A, C 룰에 검출
- 6: B, C 룰에 검출
- 7: A, B, C 룰에 검출
- 8: 모든 룰에 검출 X
- 9: 생성되지 않은 유저(500 Error 발생)

## Instructions
프로젝트 경로에서 터미널을 사용합니다.

- BUILD: ./gradlew build
- EXECUTE: java -jar build/libs/fraud-detector-1.0.0.jar
- BUILD & EXECUTE: ./gradlew build && java -jar build/libs/fraud-detector-1.0.0.jar

## Code Explanation
- FraudDetectorController.java: Controller에 해당하는 코드입니다. RestController를 사용하였습니다.
- UserLogDAO.java: User Log에 접근하기 위한 Data Access Object의 인터페이스입니다.
- DummyUserLogDAO.java: Dummy로 구현한 UserLogDAO의 구현체입니다.
- RuleADTO.java: RuleA에 필요한 데이터를 가지고 있는 Data Transfer Object입니다.
- DetectFraudRequest.java: API Request에 해당하는 Object 입니다.
- DetectFraudResponse.java: API Response에 해당하는 Object 입니다.
- DummyData.java: DummyData를 저장하기 위해 사용한 Object 입니다. 내부는 DAO에 매핑되는 static Map Object들이 있습니다.
- BaseRule.java: Rule들의 공통적인 동작과 속성을 정의해둔 추상 클래스입니다. 
Rule Object 자체에 Rule의 동작을 위임하기 위해 이상 검출을 하는 추상 메소드가 포함되어 있고 Rule의 이름을 가지고 있습니다. 
- RuleA.java: RuleA 조건을 검사하는 구현체입니다.
- RuleB.java: RuleB 조건을 검사하는 구현체입니다.
- RuleC.java: RuleC 조건을 검사하는 구현체입니다.
- RuleEngine.java: Rule들을 등록하고 룰들에 대한 검사를 실행하는 Object 입니다. 
세부적인 Rule의 동작 자체는 BaseRule을 상속한 Object들에게 맡깁니다.
생성자에 검사할 Rule의 리스트를 넣어서 Rule의 추가/삭제를 쉽게하려고 했습니다.
- FraudDetectService.java: Fraud Detection을 수행하는 서비스 인터페이스입니다. 
인터페이스에는 userId를 입력으로하여 검출된 룰을 문자열로 반환하는 함수가 있습니다.
- RuleEngineFraudDetectService.java: FraudDetectService를 RuleEngine 기반으로 구현한 구현체입니다.
해당 구현체에서는 검출된 Rule들을 원하는 형태의 문자열로 바꿔주고, 잘못들어온 user_id를 걸러주는 역할을 구현했습니다.
- FraudDetectorApplication.java: SpringBoot Application을 수행하기 위한 클래스입니다.