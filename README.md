## chepter 01 : 자바 웹 프로젝트 생성
- index.html 파일 생성 
- src에 com.example.web.ServletTest 클래스 생성 : HttpServlet 클래스를 상속 받아 클라이언트와 통신하기 위한 클래스
- WEB-INF/web.xml에서 위 클래스를 매핑해줌 
- servlet 출력도구인 HttpServletReponse 사용하여 클라이언트로 출력하기

## chepter 02 : servlet 어노테이션 방식
- web.xml에서 매핑했던 servlet 파일을 어노테이션을 사용하여 매핑함
- 조건으로 web.xml의 root element인 metadata-complete의 값을 false로 바꿔주어야 함 
- true : servlet 관련 설정을 web.xml파일 내부에서 처리
- false : servlet 관련 설정이 web.xml 파일 내부에 존재하지 않으면 다른 곳도 찾음

## chepter 03 : 한글 인코딩
- 한글 인코딩 하기

## chepter 04 : 쿼리스트링
쿼리스트링이 오는 방식은 다음과 같이 여러가지가 있다
- ?count=3 -> 문자열 3 전달
- ?count= -> 빈 문자열 전달
- ? -> null 전달

index.html에서 form을 통해 get요청으로 count 값을 보내주면 그만큼 문구를 찍는 예제 작성(쿼리값이 없을 때 nullpoint 오류를 방지하기 위해 조건을 걸어줌)