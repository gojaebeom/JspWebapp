## chepter 01
- index.html 파일 생성 
- src에 com.example.web.ServletTest 클래스 생성 : HttpServlet 클래스를 상속 받아 클라이언트와 통신하기 위한 클래스
- WEB-INF/web.xml에서 위 클래스를 매핑해줌 
- servlet 출력도구인 HttpServletReponse 사용하여 클라이언트로 출력하기

## chepter 02
- web.xml에서 매핑했던 servlet 파일을 어노테이션을 사용하여 매핑함
- 조건으로 web.xml의 root element인 metadata-complete의 값을 false로 바꿔주어야 함 
- true : servlet 관련 설정을 web.xml파일 내부에서 처리
- false : servlet 관련 설정이 web.xml 파일 내부에 존재하지 않으면 다른 곳도 찾음