![img](https://user-images.githubusercontent.com/85613861/182782684-385fce94-b961-4e53-9d63-7bb35d3062cb.png)

## 💸티끌💸 항해 99 7기 나를가조(5조) 실전프로젝트

- [티끌 사이트 바로가기](https://www.tikkeeul.com/)
- main 브랜치: 최신 브랜치

----

## 기획의도
결제일에 둘러본 카드 내역서에는 출처가 불분명한 지불 내역이 많고, 잔인하게도 통장을 텅장으로 만들어버린다
이런 좀좀따리 돈을 한 트럭 씩 쓰니 당연히 커질 수 밖에 없는데….
우리 조는 이렇게 놓치는 돈이 너무 아깝다는 생각이 들었고, 조금 더 계획있게 ‘내가 필요한 곳’, ‘내가 더 쓰고싶었던 곳’에 잘 쓸 수 있었으면 하는 바람으로 이번 프로젝트를 기획했다.
아낀 돈(티끌)을 기록하여 모으고, 목표(태산)를 설정하여 동기부여를 하는,
티끌 모아 태산을 만드는 서비스, ‘티끌'이다.

## 🕒 제작기간

### 2022년 6월 24일 ~ 2022년 8월 5일

## 🛠 서비스 아키텍처
![img_1](https://user-images.githubusercontent.com/85613861/182782799-9a580349-a764-4dce-adf0-b07144d002f2.png)

## 🗃 ERD 설계
<img width="1634" alt="image-20220625-081827" src="https://user-images.githubusercontent.com/85613861/183277869-99617586-3f6f-40f7-827c-383b7b0f045d.png">

## 🎥 최종 발표영상
[티끌 최종 발표영상 보러가기](https://www.youtube.com/watch?v=ynoW_pirnYM)

## ✨ Developers

- **Front-end**

    - 이보람 [Github](https://github.com/epppo)
    - 김은진 [Github](https://github.com/Eunjin09)
    - 이재엽 [Github](https://github.com/yupja)
      <br/>
      <br/>

- **Back-end** : [Back-end repo](https://github.com/uncounted/final-backend)

    - 최호양 [Github](https://github.com/uncounted)
    - 김민지 [Github](https://github.com/Java-kokyu)
    - 신제민 [Github](https://github.com/shinjemin)
    - 홍예준 [Github](https://github.com/WalGoo)
  

- **Designer** 

    - 김연아

## 협업 기록
[항해99 7기 나를가조 Confluence 바로가기](https://hanghae0705-product.atlassian.net/wiki/spaces/FP/pages/164154/01.+Team+Rule)


## 💸티끌 핵심 서비스

| 기획배경                   |       기능 목적        |    게시판명 |
|:-----------------------|:------------------:|--------:|
| 내가 아낀 내역 저장해야하니까!      |      아낀 내역 저장      |   티끌 등록 |
| 목표를 설정하면 동기부여가 되니까!    |       목표 저장        |   태산 등록 |
| 내가 아낀 거 자랑하고 싶으니까!     |      커뮤니티 게시판      |   티끌 자랑 |
| 충동적인 지금! 누군가 말려줘야 하니까! |       찬반 채팅방       |  쓸까?말까? |
| 얼마나 아꼈는지 궁금하니까!        | 일별/월별 & 횟수별/금액별 랭킹 |      랭킹 |

## 💸티끌 시연 영상

<table>
  <tr>
    <td align="center"><strong>태산</strong></td>
    <td align="center"><strong>티끌</strong></td>
    <td align="center"><strong>랭킹</strong></td>
  <tr>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183251005-23ebbfd2-5255-4658-876e-91f4c12825c1.gif" width="200px"/></td>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183251115-8af021d8-485b-4631-86ff-c4f4b8b19e4c.gif" width="200px" /></td>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183250901-4f516c17-1b48-4e01-9ed6-62fd76490bbe.gif" width="200px"></a></td>
  </tr>
  <tr>
      <td align="center"><b>커뮤니티</b></td>
      <td align="center"><b>타이머 채팅방 만들기</b></td>
      <td align="center"><b>실시간 채팅방</b></td>
  <tr>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183251006-fc81981c-4f81-44ca-95a0-ba0fe4810002.gif" width="200px"/></a></td>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183250931-3b9e616e-6c94-4740-97c1-c15520245242.gif" width="200px" /></a></td>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183250926-196c2bc6-ab2e-4c6c-acbe-668e0193fca8.gif" width="200px"></a></td>
  </tr>
  <tr>
      <td align="center"><b>종료된 채팅방</b></td>
      <td align="center"><b>마이페이지</b></td>
      <td align="center"><b></b></td>
  <tr>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183250917-c33e6bca-b13d-4a94-8a92-8c2c6c843276.png" width="200px"/></a></td>
    <td align="center"><img src="https://user-images.githubusercontent.com/93433413/183250903-adc4e6c3-c8dd-4c8f-b32a-5220b8190234.gif" width="200px"/></a></td>
  </tr>

</table>


<br>

## 📈부하 테스트


- 한 페이지를 로딩하는데 2-3가지 API를 호출하는 페이지를 기준으로 응답속도를 비교 후, 응답 속도가 느린 순으로 정리 후 개선하고자 함.
- 


**1. 채팅방 API 요청**
![image](https://user-images.githubusercontent.com/85613861/182802971-4172c44e-e5aa-4e98-a778-c88afac8c6ad.png)
<br/>

**2. 데일리 티끌 등록 API 요청**
![image](https://user-images.githubusercontent.com/85613861/182804489-385151b4-403e-49be-8479-427a3ac1f10d.png)


## 🕹기술스택

**1. 기술스택**

|   Part   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        Tech⚒️                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
|:--------:|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| 📱Front  |                                                                                                                                                                                                                                                                                                                    <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=python&logoColor=white"/><img src="https://img.shields.io/badge/Redux-764ABC?style=for-the-badge&logo=Redux&logoColor=white"/><img src="https://img.shields.io/badge/StyledComponents-DB7093?style=for-the-badge&logo=styled-components&logoColor=white"/><img src="https://img.shields.io/badge/Axios-56347C?style=for-the-badge&logo=ReactOs&logoColor=white"/><img src="https://img.shields.io/badge/Router-CA4245?style=for-the-badge&logo=ReactRouter&logoColor=white"/><img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/><img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white"/><img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white"/><img src="https://img.shields.io/badge/LightHouse-F44B21?style=for-the-badge&logo=LightHouse&logoColor=white"/>                                                                                                                                                                                                                                                                                                                   |
| ️⚙ Back  | <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"/><img src="https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/><img src="https://camo.githubusercontent.com/553dbe4fe2d5d12bb859180ad6f4a1310b95195d1d174ae47ee61b264d0217ca/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f4a556e6974352d3235413136323f7374796c653d666f722d7468652d6261646765266c6f676f3d4a556e697435266c6f676f436f6c6f723d7768697465"><img src="https://img.shields.io/badge/SpringSecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"/><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"/><img src="https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white"/><img src="https://img.shields.io/badge/SSL-003A70?style=for-the-badge&logo=let's encrypt&logoColor=white"/><img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white"/><img src="https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white"/><img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white"/><img src="https://img.shields.io/badge/GitHub Actions-2088FF?style=for-the-badge&logo=GitHubActions&logoColor=white"/><img src="https://camo.githubusercontent.com/37c2ca20efb65870e35ae26dc07974f87abbe9bc2c760cc3289476bfb79c2862/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f417061636865204a4d657465722d4432323132383f7374796c653d666f722d7468652d6261646765266c6f676f3d417061636865204a4d65746572266c6f676f436f6c6f723d7768697465"> |
| ️🛠 Tool |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=github&logoColor=white"/><img src="https://img.shields.io/badge/Confluence-172B4D?style=for-the-badge&logo=confluence&logoColor=white"/><img src="https://img.shields.io/badge/jira-0052CC?style=for-the-badge&logo=jira&logoColor=white"/><img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
|  🐍AWS   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               <img src="https://img.shields.io/badge/AwsEC2-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white"/><img src="https://img.shields.io/badge/AwsRDS-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white"/><img src="https://img.shields.io/badge/AwsS3-232F3E?style=for-the-badge&logo=AmazonS3&logoColor=white"/><img src="https://img.shields.io/badge/AwsRoute53-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white"/><img src="https://img.shields.io/badge/AwsAmplify-232F3E?style=for-the-badge&logo=AwsAmplify&logoColor=white"/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
|   🐧OS   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     <img src="https://img.shields.io/badge/Ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white"/><img src="https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=white"/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |  

**2. 기술적 의사결정**

| 사용기술 | 기술설명 |
|:-----------------------|:------------------------------------------------------------:|
| WebSocket, Sock.js, Stomp | 채팅 기능 구현을 위해 커넥션이 유지되는 양방향 통신 기술이 필요해 사용했다. Data 전송이 빠르고 부담이 적으며, Spring에 주로 활용되는 웹소켓을 채택했다. 웹소켓을 지원하지 않는 브라우저가 있을 수 있으니 sock.js를 추가 도입하였다. 또한, 구독/발행 모델을 가지고 있어 방별로 메시징 처리가 용이한 Stomp를 도입하였다.
| Redis | 채팅방 정보(방 번호, 조회수, 제한시간), 채팅메시지 임시저장을 위해 사용하였다. 정형화된 스키마가 필요없고 각 데이터 간 연관관계가 불필요하며, 메모리 DB이기 때문에 채팅 시 매번 DB I/O가 발생하여 부하가 생기는 일을 없게 하기 위해 도입하였다. |
| MySQL | 회원정보, 카테고리, 아이템 저장 등을 위한 기본 데이터베이스로 사용했다. 각각의 데이터가 정형화되어 있고, 테이블 간 서로 연관관계가 필요하기 때문에 관계형 DB를 선택하였다. 단, 시간제한이 있는 채팅방 구현을 위해, 채팅방이 종료된 후에는 더이상 레디스 캐시에 채팅 내용을 쌓아둘 필요가 없으므로 레디스에서는 삭제하고, MySQL에 이관하여 저장하였다.
| QueryDSL | 통계 데이터 저장을 위해 사용하였다. 집계함수의 처리를 위해 JPA Repository보다 복잡한 Query문 작성이 필요해졌고, SQL문 그 자체로 활용할 수 있기 때문에 JPQL보다 강점을 가지고 있다고 판단하여 도입하였다. |
| Spring Scheduler | 통계 데이터 연산을 위해 사용하였다. 통계 데이터를 수시로 연산하는 것은 부하를 가져올 수 있어, 특정 시간에 연산을 하여 저장하고자 사용하였다. |
| Mail Sender | 비밀번호 변경 링크를 발송하기 위해 사용하였다. 간단한 메일 내용이라 SimpleMailMessage를 활용하였다. 
| github actions, Docker | 백엔드 CI/CD를 위해 도입하였다. github action은 이미 github을 사용하고 있어 연동이 편리하고 서버 설치가 필요없다는 장점이 있어 도입하였다. MySQL, Ubuntu, 코드 등 현재 우리가 사용하고 있는 서버 환경에 대한 설정을 저장하고 필요한 모든 것을 담고 있어, 빠르게 빌드 배포할 수 있어 사용하였다. |
| Spring Boot | 백엔드 프레임워크로 Spring Boot를 도입했다. Spring에 비해 복잡한 환경설정이 없고 탐캣이 내장되어 있으며 디펜던시 관리가 용이한 등 다양한 장점이 있어 선택하였다. |
| Spring Security | 인증과 권한을 관리하는 데 있어 강력한 기능을 제공하고 있어 도입했다. 모든 접근에 대해 가로채서 인증과 권한을 검사하며, 내장된 모듈을 통해 유저 정보에 접근하기 용이하다. |
| JWT Token, Refresh Token | 세션 방식이 서버에 정보를 저장하는 데 반해, 토큰 방식은 한 번 발급하면 서버의 자원을 사용하지 않기 때문에 도입했다. 단 토큰이 탈취당할 경우를 대비해 액세스 토큰 시간을 짧게 설정하고 만료 시 리프레시 토큰을 확인하여 토큰과 리프레시 토큰을 함께 발급해주는 방식을 채택했다. |


## 고객 피드백 및 대응

<img width="1728" alt="image" src="https://user-images.githubusercontent.com/19637185/183239323-03c0dd60-151c-4d15-a3b6-5b26772031d3.png">
