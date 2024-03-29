# 자바 세미 프로젝트 : 오늘 점심 무엇?
### 개인 맞춤형 티켓 판매 프로그램

## 개요

### 프로젝트 소개
```
학원 주변 맛집을 데이터로 구성하여 티켓 판매기를 콘솔 기반으로 구현한 프로젝트
```


### 팀 소개
**쌍용강북교육센터 실무 프로젝트 기반 빅데이터 서비스 솔루션 개발자 양성과정** <br>
**(Java 기반 풀스택 개발자 양성과정) B강의장 4조**

| 유동현 | 김유림 | 한은영 | 임시연 | 박원석 |
| --------------- | --------------- | --------------- | --------------- | --------------- |
| ![leader](https://img.shields.io/badge/-Leader-ff69b4) ![Backend](https://img.shields.io/badge/-Backend-FFD133) | ![Backend](https://img.shields.io/badge/-Backend-FFD133) | ![Backend](https://img.shields.io/badge/-Backend-FFD133) | ![Backend](https://img.shields.io/badge/-Backend-FFD133) | ![Backend](https://img.shields.io/badge/-Backend-FFD133) |

### 개발 기간
2022.08.01 월 ~ 2022.08.28 월 (8일)

### 개발 일정
`2022-08-01` ~ `2022-08-03` : 주제 선정 및 기획안 작성 <br>
`2022-08-04` ~ `2022-08-07` : 기능 구현 <br>
`2022-08-07` ~ `2022-08-08` : 최종 코드 추합 및 발표자료 준비 <br>
`2022-08-08` : 발표 <br>



### 개발환경 및 언어
- **PlatForm** : Windows 10
- **IDE** : EditPlus
- **Language** : Java JDK 1.8
- **DB** : Excel File(RestInfo.csv) : 등록되어 있는 음식점들의 가게명/메뉴/가격/재고/소요시간/카테고리의 데이터 파일


### 프로젝트 목표
  메뉴 결정에 어려움을 겪는 수강생들의 음식 취향과, 거리에 맞는 메뉴 추천, 판매누적랭킹의 추천 기능을 제공하는 식권 판매 프로그램을 제작한다. 기존의 “배달의 민족”, “요기요”와 같은 배달 플랫폼과는 달리 대상에 맞는 분류와 선택지를 최소화하여 간편하게 결정할 수 있는 서비스를 만들어 본다. 해당 서비스의 판매 대상은 쌍용강북교육센터 수강생을 대상으로 한다.
최종적으로 Vending Machine(자판기) 라는 큰 틀의 주제를 가지고 식당 메뉴 추천 기능이 들어간 티켓 판매 프로그램을 자바 콘솔 프로젝트 형태로 진행한다.


## 👨‍👨‍👧‍👧 역할 분담
#### 유동현(팀장/전체 총괄)
> Manager + Machine 코드 통합, 리팩토링 <br>
> Machine : 티켓 발급, 결제 내역 최종 확인 <br>
> RestInfo.csv Write <br>

#### 박원석
> Manager 클래스 담당, Machine 클래스 보조 <br>
> Manager : 음식점 수정 보조, 잔고 채우기, 거스름돈 기능 구현 <br>
> 회의록 및 최종 보고서 보조 <br>

#### 한은영
> Manager 클래스 담당, Machine 클래스 보조 <br>
> Manager : 추가, 삭제, 수정, 조회 및 출력, 티켓 재고 추가 <br>
> Manager : 누적 매출 확인, RestInfo.csv 파일 읽기/쓰기 <br>
> Manager : 가게 정보를 담는 SetData 클래스 구조 및 속성 설계 <br>
> Machine : 음식점 누적판매 랭킹, 음식 메뉴 검색

#### 김유림
> Machine : 카테고리 별 추천 기능 구현 <br>
> 전체 UI 구조 출력 관리 <br>
> 발표 자료 제작 및 회의록 작성 <br>


#### 임시연
> Machine : 거리 별 추천 기능 구현 <br>
> 전체 UI 구조 출력 관리 <br>
> 발표 자료제작 및 회의록 작성 <br>

<br>

## 콘솔 기반 실행
<p align="center" width="100%">
<img width="24%" src="Console Capture/초기화면.png">
<img width="24%" src="Console Capture/티켓구매.png">
<img width="24%" src="Console Capture/카테고리.png">
<img width="24%" src="Console Capture/검색기능.png">
</p>

<p align="center" width="100%">
<img width="24%" src="Console Capture/재고소진.png">
<img width="24%" src="Console Capture/랭킹기능.png">
<img width="24%" src="Console Capture/결제기능.png">
<img width="24%" src="Console Capture/검색기능.png">
</p>




## 개인 소감

팀원들과 함께 프로젝트를 진행하면서 팀원들 5명이 머리 녹여가며 많은 회의를 거치고
꼬리에 꼬리를 무는 고민을 해결해나가며 여러 생각이 들었습니다.
확실히 무언가를 만들거나 이미 기존에 있는 것을 똑같이 구현 해보려 해도
별거 아닌 기능 같아도 정말 여러 상황이나 조건을 고려해야 됐습니다.
정말 세세한 부분까지 신경써야 제대로 된 매끄러운 서비스를 제공하겠구나 싶었습니다.

팀 활동은 잘 할 수 있을까도 걱정이 많았는데 팀원들 코드를 보면서 느리지만 계속 보다 보니 이해가 되어 다행이었습니다.
팀으로 해서 오래 걸릴 것 같아도 막상 다 같이 해결하려고 파고들면 오히려 더 척척 해치울 수 있는 것 같습니다.
그리고 이번 기회를 통해 팀원들에게나 프로젝트 과정에서 얻어갈 수 있는 배울 점들은 늘 있는 것 같아 좋았습니다.

계속해서 개발 일을 하게 되면서 이런 경험이 쌓이다 보면 좁은 시선을 넓힐 수 있을 것이라고 믿고 
앞으로 자바를 더 공부해서 좀 더 논리적이고 좋은 코드로 구현할 수 있거나 리팩토링 해볼 수 있도록 수련 해야 될 것 같습니다.
팀원들 전부 고생하셨습니다!

