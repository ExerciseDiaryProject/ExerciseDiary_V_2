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

--------------

## :scroll: 이 프로젝트의 기술 구현 방식

1. SIGN UP
    * user information create
    * user information select
    * user exercise purpose update
    * user information delete
2. LOGIN
3. VIDEO 
    * all video list select
    * exercise purpose list select
4. DIARY 
    * DIARY
         * diary create
         * diary select
         * diary delete
5. DIARY DETAIL
    * diary detail select
    * diary delete
6. DIARY LIST
    * all diary select

-------------------

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

* :eyes: 각 팀원들의 느낀 점[VERSION 1]

    * :woman: jisoo : 타 프로젝트를 할 때보다 WEB에서 많은 에러가 나서 진행이 늦어졌고, 구현하려던 CRUD 를 부분적으로 완성시키지 못한 점이 아쉬웠다.

    * :woman: dayoung : 시간이 촉박하여 적어도 완성에 가까운 결과물을 내야한다는 부담감에 클린코드는 물론, 예외처리까지도 신경을 못쓴게 가장 아쉬웠습니다. 다음 프로젝트에서는 일의 우선순위를 정해놓고 조금 더 체계적으로, 효율적으로 해야겠다는 생각을 했습니다.

    * :man: minyoung : web이 아직 덜 이해되어있는 상태로 작업하다보니 뭐가뭔지 모르고 개인적으론 mvc패턴이 갑자기 헷갈리기 시작했습니다. web에 대해 공부를 더 해야할 것 같습니다.

* :eyes: 각 팀원들의 느낀 점[VERSION 2]

    * :woman: : jisoo : 비동기를 하는 과정에서 시행착오를 많이 겪으면서 axios의 편리성에 대해 알게 되었고, interface라는 함수를 사용해 보며 테이블 구조에 대해 확실한 이해를 하였습니다. 또한 html, jsp 문서를 controller에 연결시켜서 가능하도록 만드는 과정을 정확히 알게 되었습니다.

    * :woman: : dayoung : 

    * :man: : minyoung : 
    
------------------

## :bulb: References

* EXCEL DATA : https://docs.google.com/spreadsheets/d/1Wd1iWMgHv1M3Js6eivVqQLa8NnXEUmkDi_J6qhA7qHE/edit?usp=sharing 
* OVEN APP  : https://ovenapp.io/view/XRvSHiCrtm4xgrfSSyI10tSUa14wV0Lw/fV7Lz
* ERD CLOUD : https://www.erdcloud.com/d/ERGqnY8qjTShkzJcq
* GitHub Organizations : https://github.com/ExerciseDiaryProject