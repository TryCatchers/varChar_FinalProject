# [ Var茶 ] Spring-Project
![메인](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/4df03a05-a49b-4a8b-86a8-15089f586e9b) <br><br>
Spring MVC 패턴을 이용한 차 구매 웹페이지

## 🖥️ 프로젝트 소개
- 기획 배경:  JAVA와 JSP, Spring 프레임워크를 적용한 MySQL/Oracle 기반의 MVC 패턴을 이용한 차 구매 웹페이지 구현
- 기획 목적:  홈페이지 개발을 통한 JSP / Spring 학습 및 Web에 대한 전반적인 이해도 향상
- 기대 효과:  전반적인 JAVA, JSP, Spring, MySQL/Oracle에 대한 심층적 이해 및 활용도 향상<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             JSP를 이용한 동적 웹사이트 구축 및 학습 극대화<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             MVC / JDBCTemplate 등 디자인패턴 학습 및 적용<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             기존의 JSP 프로젝트를 Spring 프레임워크 방식으로 이관<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             깃(Git)을 통한 팀원들의 업데이트 사항 실시간 반영 및 수정 용이
- 기능 요약: JAVA와 JSP, Spring 프레임워크를 적용한 MySQL/Oracle 기반의 MVC 패턴을 이용한 차 구매 웹페이지 구현

<br>

## 🕰️ 개발 기간
* 23.08.02일 - 23.10.13일

### 🧑‍🤝‍🧑 멤버구성

 - 팀장: 박준현
 - 팀원: 권지현
 - 팀원: 김지훈
 - 팀원: 류준원
 - 팀원: 정윤구
 - 팀원: 탄다미
#### 노션 - <a href="https://scratched-country-9d1.notion.site/TryCatchers-dedc520b97da420fb20ad5c32ad8287b?pvs=4" >팀 노션으로 이동</a>

### ⚙️ 개발 환경
- `Java(JDK 11)`
- `JavaScript` `HTML` `CSS`
- **Server** : Apache Tomcat 9.0
- **IDE** : STS 3
- **Framework** : Spring Framework 4.2.4
- **Database** : Oracle DB(11g Express)

## 🛠 설계 및 구조도
#### ERD
<img width="1696" alt="ERD_Figma" src="https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/c50820b9-13b4-4544-a59e-062fd88264db">

#### Flow Chart

#### Logic Process

#### Controller Mapping

## 📌 주요 기능
#### 회원 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Login)" >상세보기 - WIKI 이동</a>
![로그인](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/fba2d6b4-8366-4f8b-87fa-d554593d3003)
![구글로그인](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/fb91a4b9-e4b7-4ec3-83e1-7536b11a2a7f)
![회원가입](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/23eea30b-8a68-4131-8cce-85b42d0f2df3)
![비밀번호찾기](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/1443a6c8-dcec-4050-a97b-ec32fe166465)
<br>
- 회원가입(+ 가입 축하 메일 발송 / reCAPTCHA)
- 홈페이지 / SNS 로그인(Kakao, Naver, Google API)
- 회원정보 수정
- 비밀번호 변경
- 비밀번호 찾기(SMS API)
#### 상품 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>
![상품목록](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/ae4c30a1-1426-4d49-a243-fbf368626aa5)
![장바구니](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/d07dd5c3-3d1a-4c84-906b-3e9f4893e912)
![결제](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/bf24e3d2-4f74-40c7-a298-2f8a6ca8ddbe)
![다시담기](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/d73af131-6d10-4e0c-82d2-042433245f85)
![상세찜](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/8c66dd5a-3537-4409-b480-9f0d956ae6cd)
<br>
- 장바구니
- 구매(TossPay API)
- 찜
#### 후기 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(Member)" >상세보기 - WIKI 이동</a>
![후기작성](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/9aed777b-a51c-4c11-8e09-da32ad335dbb)
- 후기 작성/수정/삭제(+해시태그 / 이미지 등록)
#### 해시태그 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EC%98%81%ED%99%94-%EC%98%88%EB%A7%A4)" >상세보기 - WIKI 이동</a>
![상품해시태그](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/65eb2109-8b46-4643-99c6-0ff69833fe73)
![리뷰해시태그](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/5718da9b-3846-4b0b-b983-9185ae03b609)
<br>
- 상품 해시태그(+ 트리거)
- 후기 해시태그(+ 이벤트 스케줄러)
#### 관리자 - <a href="https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/wiki/%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5-%EC%86%8C%EA%B0%9C(%EB%A9%94%EC%9D%B8-Page)" >상세보기 - WIKI 이동</a>
![관리자메인](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/19a7d5d4-daba-47ca-8075-b8549f9678b9)
![상품관리](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/050e04fd-0b4d-48f9-8aa5-e59b4ce33570)
![카테고리관리](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/399198c1-6422-4e8d-b9bd-6464e4ccd859)
![리뷰해시태그관리](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/518f9d4d-97df-4008-a2c2-654c2453fea7)
<br>
- 상품 관리(추가, 삭제, 수정)
- 상품 카테고리 관리(추가, 삭제, 수정)
- 상품 해시태그 관리(추가, 삭제, 수정)
- 후기 해시태그 관리(삭제, 수정)
#### 기타 - <a href="" >상세보기 - WIKI 이동</a> 
![챗봇](https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/3cb97d19-0896-45b3-a8e5-3ea515e7a71d)
<img width="471" alt="map" src="https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/b4ba80c4-53ee-457a-af37-f36fd6c7b35f">
<img width="753" alt="길찾기" src="https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/70807401-fb07-4887-90a2-298657178dfc">
<img width="944" alt="500" src="https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/4fc81999-860f-4499-b2eb-93eb9d662bc4">
<img width="958" alt="404" src="https://github.com/TryCatchers/varChar_FinalProject/assets/80264075/4955dcdd-b918-4670-8d26-27d2a0d48e32">
<br>
- 상담 및 문의(ChannelTalk 채팅 API)
- 지점 위치(Kakao Map API)
- 에러페이지
