# Exercise Diary Project_V_2

-------------

## :running: 운동 일기장

요즘 밖에 나가긴 무섭고 집에만 있자니 답답하시죠? 

운동 일기장을 통해 목적을 이루고 스트레스를 날리세요!

-------------

## :information_desk_person: 프로젝트 소개
* :mag: **회원가입**을 통해 **원하는 운동 선택**이 가능합니다.
* :mag: 로그인을 성공하면 **모든 운동 프로그램**을 볼 수 있습니다.
* :mag: **모든 운동 프로그램**에서 원하는 목적을 선택해서 그 영상 중 하나를 선택하여 볼 수 있습니다.
* :mag: 자신이 **원하는 운동을 선택**하여 운동한 후 바로**운동 일기장을 작성 가능**합니다. 
* :mag: **운동 일기장 목록**에서 과거의 일기 삭제가 가능합니다. 
* :mag: 운동 목적이 변하여 **다른 목적을 통해 운동**하고 싶다면 **마이 페이지에서 변경** 가능합니다.

-------------

## 	:rocket: V_1 에서 UPDATE된 부분

* **VERSION1**에서는 링크를 타고 들어가야 원하는 운동 동영상을 볼 수 있었지만 **VERSION2**에서는 원하는 **PLAYLIST**를 누르면 바로 동영상을 재생해서 볼 수 있도록 수정하였습니다.

* **LOGOUT**을 추가하여 로직의 견고함을 추구하였습니다.

* **VIDEO LIST**에 비동기 처리를 **axios**를 이용하여 구현하였습니다.


--------------

## :couple: 운동 일기장 프로젝트 관계도 설정

![화면 캡처 2020-12-29 053422](https://user-images.githubusercontent.com/73863771/103255649-7382b000-49cd-11eb-874c-421c5ec6dc5b.png)

--------------

## :page_facing_up: 테이블 설명

### :point_right: user table
* **user_id(PK)**
* user_password
* user_name
* user_gender
* user_age
* user_height
* user_weight
* purpose


### :point_right: youtube table
* **channer(PK)**
* youtuber


### :point_right: diary table
* **diary_no(PK)**
* diary_title
* diary_content
* write_date
* today_weight
* user_id
* purpose
* program_no


### :point_right: video table
* **program_no(PK)**
* playlist
* youtube_url
* youtuber
* channel
* purpose

### :point_right: purpose table
* **purpose(PK)**

----------------

### :key: [Exercise Diary 회원가입 및 로그인 기능]

#### :book: 1. 메인 페이지 
    > Exercise Diary의 첫 화면

    > Log in을 바로 할 수 있는 화면과 Sign up을 할 수 있는 버튼 기능 구현(ID/PW 입력창, Log In 버튼, 회원가입 버튼 생성)

----------    
#### 2. 회원가입 페이지
    > Exercise Diary에 개인정보를 입력할 수 있는 화면

    > 가입하고자 하는 사람의 id, pw, name, gender, age, height, weight, purpose를 입력 가능

    > 가입 버튼과 취소 버튼을 생성하여 모든 정보 입력 후 가입 버튼 누르면 등록 완료가 되고, 취소 버튼을 누르면 이전 메인 페이지로 돌아가는 기능
-------------
#### 3. 모든 영상 페이지
    > Exercise Diary에서 제공하는 운동 영상을 모두 출력

    > 우측 위 화면에 My Page, Diary List, Log Out 버튼 생성

    > 플레이 리스트 열에 원하는 Video로 바로 갈 수 있는 링크 생성

    > 운동목적별 검색 기능
--------------------
#### 4. 영상 페이지
    > Exercise Diary에서 제공하는 영상 중 선택적으로 영상을 보여주는 페이지

    > 선택한 영상의 프로그램 번호와 PlayList명, Channel명, 운동 목적과 영상이 표로 출력

    > 다이어리 작성 버튼과 돌아가기 버튼 구현
---------------
#### 5. 다이어리 작성 페이지
    > 다이어리를 작성할 수 있는 페이지

    > 작성 목록에는 변하지 않는 값인 작성자 Id 존재

    > 운동 목적을 원하는 목적으로 선택할 수 있는 DROPDOWN으로 생성

    > 오늘의 체중, 영상 번호, 제목, 내용을 작성하는 기능

    > 글쓰기 등록 버튼과 다시 쓸 수 있는 기능

    > 글쓰기 목록 리스트로 돌아가기 버튼 기능
----------------
#### 6. 다이어리 목록 페이지
    > 다이어리 목록 리스트를 보여주는 페이지

    > 운동 목적, 제목, 작성일, 체중을 한번에 리스트로 보여주는 기능 

    > 제목 열의 각 제목을 클릭했을 때 작성한 일기 볼 수 있는 기능

    > 글쓰기 버튼 구현하여 글쓰기 버튼 클릭 시 새로운 일기 작성 기능

    > 돌아가기 버튼 구현하여 돌아가기 버튼 클릭 시 전체 운동 동영상 리스트 목록으로 돌아가는 기능
------------------
#### 7. 각각의 다이어리 페이지
    > 일기의 번호를 보여주는 기능

    > 작성자 Id 와 운동 목적, 작성일, 체중, 제목과 내용을 출력해주는 기능

    > 리스트로 돌아가기 버튼 구현하여 돌아가기 버튼 클릭 시 전체 다이어리 리스트 목록으로 돌아가는 기능

    > 삭제하기 버튼클릭 시 일기가 삭제되는 기능
-----------------
#### 8. 마이 페이지
    > 나의 개인정보를 보여주는 기능

    > id, name, gender, age, height, weight, purpose를 보여주는 기능

    > 수정과 탈퇴 버튼이 있고, 수정 버튼 클릭 시 운동 목적을 변경할 수 있는 기능

    > 탈퇴클릭 시 기존의 메인 페이지로 돌아가며 탈퇴 가능하게 구현
-------------------
#### 9. 로그아웃
    > 모든 동영상 리스트 페이지의 우측 위 버튼인 로그아웃 버튼을 클릭 시 경고창과 함께 로그아웃 하시겠습니까? 라는 문구가 뜨는 기능

    > 확인 버튼 누르면 메인 페이지로 돌아가게 되고 다시 로그인 할 수 있게 하는 기능
------------
## :two_women_holding_hands: CO - AUTHORS

* :woman: 최지수 [(JisooChoi)](https://github.com/choijisoo-94)
* :woman: 박다영 [(DayoungPark)](https://github.com/Da-0)
* :man: 박민영 [(MinyoungPark)](https://github.com/minyoung-park)


------------------
## :sparkles: Team Issues

* :eyes: 공통 이슈[VERSION 1]

	> 목적테이블을 만드는 부분에서 관계도 형성에 많은 고민을 했습니다.
	
	> ERD CLOUD 를 짜는 과정에서 ddl문에 의존하다가 시간을 소비한 점이 아쉬웠습니다.
	
	> entity 설계 시 joincoloum과 mappedby에 대해 고민해야 해서 많은 시간을 소요했습니다.
	
	> ID 와 PASSWORD 를 확인하는 과정이 어느 부분에 들어가야 하는지 고민하는 시간이 길었습니다.
	
	> ECLIPSE상의 오라클 XE 자동 생성 과정에서 알수없는 에러들이 많아서 오래 고민했습니다.


* :eyes: 공통 이슈[VERSION 2]
	
	> interface를 쓰는 과정에서 테이블 설계의 중요성에 대해 배웠습니다.
	
	> VERSION1 에서 시간이 부족해 만들지 못했던 DIARY 검색과 생성 부분을 구현했습니다.
	
	> logout 했을 때 session을 invalidate 해줘서 무효화 시켰음에도 불구하고 뒤로가기 버튼을 클릭했을 때, 이전 페이지로 이동되는 문제가 있었습니다. 이를 history를 제어해줌으로써 막을 수 있었습니다.
	
	> 공동 작업을 하기 위해 각자의 BRANCH를 생성하여 서로의 프로젝트에 충돌이 나는 것을 미연에 방지하였습니다.

	> YOUTUBE URL을 설정하는 과정에서 주소값만 가져오는 것이 아닌 각 동영상들의 일련번호(고유값)만을 DB에 저장하여 동영상을 재생시켰습니다.
-------------------

## :bulb: 각 팀원들의 느낀 점

* :eyes: 각 팀원들의 느낀 점[VERSION 2]

    * :woman: : jisoo : 비동기를 하는 과정에서 시행착오를 많이 겪으면서 axios의 편리성에 대해 알게 되었고, interface라는 함수를 사용해 보며 테이블 구조에 대해 확실한 이해를 하였습니다. 또한 html, jsp 문서를 controller에 연결시켜서 가능하도록 만드는 과정을 정확히 알게 되었습니다.

    * :woman: : dayoung : 개발환경에 문제가 생겨, 모든 설치와 환경설정을 새로 해줘야하는 번거로움이 있었지만 초기  설정을 되짚어볼 수 있어서 좋았습니다. 미완성으로 끝났던 프로젝트를 완성시키느라 비동기를 이용한 실습을 많이 못해본게 아쉬웠습니다.


    * :man: : minyoung : 지난 주보다는 스스로는 많이 발전한 것 같습니다. javascript를 한번 정도는 스스로 해볼 수 있어서 좋았습니다.

    
------------------

## :bulb: References

* EXCEL DATA : [(Excel data)](https://docs.google.com/spreadsheets/d/1Wd1iWMgHv1M3Js6eivVqQLa8NnXEUmkDi_J6qhA7qHE/edit?usp=sharing)
* OVEN APP  : [(Oven App)](https://ovenapp.io/view/XRvSHiCrtm4xgrfSSyI10tSUa14wV0Lw/fV7Lz)
* ERD CLOUD : [(ERD CLOUD)](https://www.erdcloud.com/d/ERGqnY8qjTShkzJcq)
* GitHub Organizations : [(GitHub Organizations)](https://github.com/ExerciseDiaryProject)