## OAuth 2.0 (Open Authorization 2.0)
- 인증을 위한 개방형 표준 프로토콜
- 이 프로토콜에서는 Third-Party 프로그램에게 리소스 소유자를 대신하여 리소스 서버에서 제공하는 자원에 대한 접근 권한을 위임하는 방식을 제공

| 용어             | 정리                                                                                          |
|:---------------|:--------------------------------------------------------------------------------------------|
| Authentication | 인증, 접근 자격이 있는지 검증하는 단계                                                                      |
| Authorization  | 인가, 자원에 접근할 권한을 부여하는 것. 인가가 완료되면 리소스 접근 권한이 담긴 Access Token이 클라이언트에게 부여된다.                  |
| Access Token   | 리소스 서버에게서 리소스 소유자의 보호된 자원을 획득할 때 사용되는 만료 기간이 있는 Token                                       |
| Refresh Token  | Access Token 만료 시 이를 갱신하기 위한 용도로 사용하는 Token. Refresh Token은 일반적으로 Access Token 보다 만료기간이 길다. |



> 자원 소유자 (Resource Owner)
- 자원 소유자 혹은 개인이 클라이언트에 접근중일 경우에는 사용자라 한다.
- 보호 자원에 대한 접근 권한을 가지고 있으며, 인증 정보를 제공해서 액세스 권한을 허용할 수 있다.

> 클라이언트 (Client)
- 클라이언트 혹은 자원 소유자가 사용중인 서비스나 애플리케이션 등으로 불린다.
- 보호 자원에 대한 접근 권한을 요청하여 발급받고, 발급받은 권한을 통해 자원 서버에 자원을 요청한다.

> 인가 서버 (Authorization Server)
- 인가 서버 혹은 권한 서버라고 불린다.
- 자원 소유자를 인증하는 과정을 통해 권한에 대한 유효성을 검증한다.
- 모든 검증이 올바르게 끝나면 최종적으로 자원 서버에 접근하여 자원 요청 권한을 가질 수 있는 토큰을 발급하여 클라이언트에게 응답한다.

> 자원 서버 (Resource Server)
- 자원 서버는 접근 권한이 있는 보호된 자원을 호스팅한다.
- 경우에 따라 인가 서버와 자원 서버는 같은 서버일 수 있다.

> 주요 API 파라미터

| 변수명                      | 설명                                                                                                                                                                                                                               |
|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| client_id, client_secret | 클라이언트 자격증명. 클라이언트가 권한 서버에 등록하면 발급받을 수 있으며, 권한 서버 연동 시 클라이언트의 검증에 사용된다.                                                                                                                                                           |
| redirect_url             | 권한 서버가 요청에 대한 응답을 보낼 url을 설정                                                                                                                                                                                                     |
| response_type            | 권한 부여 동의 요청 시 포함되는 값으로 권한 부여 방식에 대한 설정 <br/>- code : Authorization Code Grant / <br/>- token : Implicit Grant                                                                                                                    |
| state                    | CSRF 공격에 대비하기 위해 클라이언트가 권한 서버에 요청 시 포함하는 임의의 문자열. 필수 사항은 아니지만 클라이언트가 요청 시 state를 포함시켰다면 권한 서버는 동일한 값을 클라이언트에게 보내야 한다.                                                                                                            |
| grant_type               | Access Token 획득 요청 시 포함되는 값으로 권한 부여 방식에 대한 설정. 아래 중 한 개 값 사용 <br/>-authorication_code : Authorization Code Grant <br/>- password : Resource Owner Password Credentials Grant <br/>- client_credentials : Client Credentials Grant |
| code                     | Authorization Code Grant 방식에서 Access Token 요청 시 사용. 권한 서버에서 획득 한 Authorization Code를 입력|
| token_type               | 발행된 Token의 타입. 대표적으로 Bearer, MAC(Message Authentication Code)|
|expires_in|토큰 만료 시간 (단위: 초)|
|example_parameter| Token 타입에 따른 추가 파라미터|