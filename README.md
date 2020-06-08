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

## chepter 04 : get, post
- index.html에서 form을 통해 get요청으로 count 값을 보내주면 그만큼 문구를 찍는 예제 작성(쿼리값이 없을 때 nullpoint 오류를 방지하기 위해 조건을 걸어줌)
- 쿼리스트링이 오는 방식은 다음과 같이 여러가지가 있다
    - ?count=3 -> 문자열 3 전달
    - ?count= -> 빈 문자열 전달
    - ? -> null 전달

- register.html에서 form을 통해 post요청으로 여러 값을 보낸다. 이때 입력받는 값에 대한 한글 인코딩 문제도 따로 설정해줌

## chepter 05 : filter 만들기
- filter 인터페이스를 구현 받는 클래스 정의
- web.xml을 통해 만드는 방법과 어노테이션을 이용하여 만드는 방법 

## chepter 06 : 서블릿context 사용
- 상태유지의 필요성 확인, 서블릿은 요청이오면 그에 대한 응답을 주고 메모리에서 사라지기 때문에 서블릿들 간의 연결이 불가능하다. 이에대해 서블릿 context를 사용해 상태유지를 배운다.
- 상태유지의 방법으로 application, session, cookie 등이 있다. 
- 각자 한번씩 사용해본다.