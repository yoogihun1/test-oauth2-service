# Oauth2 AuthorizationServer(인증서버)

### 개요
- SpringBoot에서 제공하는 Oauth2 인증서버 구축 방법에 대한 예제 
- 소스 Github 등록
  - https://github.com/ddeuda-dev-team/test-oauth2-service.git


### Oauth2 Authorize Code 방식 요청 Url
- http://localhost:8081/oauth/authorize?client_id=testClientId&redirect_uri=http://localhost:8081/oauth2/callback&response_type=code&scope=read

### 토큰 발급
curl -X POST 
'http://localhost:8080/oauth/token' 
-H 'Authorization:Basic base64(${clientId:clientSecret})' 
-d 'grant_type=authorization_code' 
-d 'code=${발급된 코드}' 
-d 'redirect_uri=http://localhost:8080/oauth2/callback'

### 테스트용 클라이언트 등록 
insert into oauth_client_details(client_id, resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,additional_information,autoapprove) values('testClientId',null,'{bcrypt}$2a$10$H2oQgFY7qCRHWqkvAV4P6ONy2v74wfr3fQv.xERw3BJYSqh/Gcgrq','read,write','authorization_code,refresh_token','http://localhost:8081/oauth2/callback','ROLE_USER',36000,50000,null,null);
       