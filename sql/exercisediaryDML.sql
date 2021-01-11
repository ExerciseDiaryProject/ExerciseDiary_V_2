-- purpose insert
insert into purpose values ('다이어트');
insert into purpose values ('근육량 증가');
insert into purpose values ('체형관리');

-- youtube insert
insert into youtube values ('Dano TV','Dano');
insert into youtube values ('에이핏 afit', '라희');
insert into youtube values ('말왕TV', '말왕');
insert into youtube values ('지피티', '지피티');
insert into youtube values ('힙으뜸', '심으뜸');
insert into youtube values ('피지컬갤러리', '김계란');

-- user insert
insert into users values ('user111','user1234','최지수','F','27','160','55','근육량 증가');

-- video insert
insert into video values ('v_1','올인원 운동/급찐급빠/유산소/앉아서하는운동','3T8W2vGyRZQ','Dano TV','다이어트');
insert into video values ('v_2','전신/하체/상체/비키니','_4m9Z8wLKxM','Dano TV','다이어트');
insert into video values ('v_3','스트레칭/하체/뱃살/전신운동','mJFvIVqRXv0','Dano TV','다이어트');
insert into video values ('v_4','타바타운동','AvM_n0KbKUQ','에이핏 afit','다이어트');
insert into video values ('v_5','댄스 유산소','E6u3LepPOvk','에이핏 afit','다이어트');
insert into video values ('v_6','고강도 인터벌 트레이닝','XepPtIoQgwY','에이핏 afit','다이어트');
insert into video values ('v_7','말왕의 믿고보는 운동강의','WaWxwZl-U9Q','말왕TV','근육량 증가');
insert into video values ('v_8','여성 헬스 가이드','Lp2hUiUCX0s','말왕TV','근육량 증가');
insert into video values ('v_9','세상에 나쁜 뚱뚱이는 없다','SijOw49WZ7I','말왕TV','근육량 증가');
insert into video values ('v_10','헬창커플','zoUe1m8BFd8','지피티','근육량 증가');
insert into video values ('v_11','멸치탈출 프로젝트','TEbMvgx50Ak','지피티','근육량 증가');
insert into video values ('v_12','운동강의','ZikQin-HS6M','지피티','근육량 증가');
insert into video values ('v_13','운동의 정석','vQNFiMi0m9M','힙으뜸','체형관리');
insert into video values ('v_14','집에서 필라테스','RWcCaSzueB4','힙으뜸','체형관리');
insert into video values ('v_15','홈트레이닝','RWcCaSzueB4','힙으뜸','체형관리');
insert into video values ('v_16','체형교정 루틴','qMtyhDDmJ-U','피지컬갤러리','체형관리');
insert into video values ('v_17','스트레칭 꿀팁/루틴','_RXjbRdiFBs','피지컬갤러리','체형관리');
insert into video values ('v_18','재활운동/스트레칭/꿀팁','qMtyhDDmJ-U','피지컬갤러리','체형관리');

-- diary insert
insert into diary values (1,'오늘부터 운동시작!','ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ...이하생략','2020-12-28','59','user111','다이어트','v_3');

commit;
