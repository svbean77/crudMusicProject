--
-- 테이블 생성
--
drop sequence seq_music;
drop sequence seq_user;
drop sequence seq_playlist;
drop table playlist;
drop table userlist;
drop table music;

create sequence seq_music;
create sequence seq_user;
create sequence seq_playlist;

create table music
(music_no number constraint music_no_pk primary key, 
music_name varchar2(50) not null, 
singer varchar2(30) not null,
release_date date not null);

create table userlist
(user_no number constraint user_no_pk primary key,
user_id varchar2(20) constraint user_id_uk unique not null,
user_pw varchar2(20) not null,
user_name varchar2(30) not null,
user_day date not null,
user_email varchar2(30) constraint user_email_uk unique not null,
user_gender char(1) constraint user_gender_check check(user_gender in ('M', 'W')) not null);

create table playlist
(list_no number constraint playlist_no_pk primary key,
music_no number references music(music_no) on delete cascade not null,
user_no number references userlist(user_no) on delete cascade not null,
constraint playlist_uk unique (music_no, user_no));

--
-- 음악 데이터 삽입
--
-- 2010
insert into music values(seq_music.nextval, 'Bad Girl Good Girl', '미쓰에이', to_date(100701));
insert into music values(seq_music.nextval, '잔소리', '아이유', to_date(100603));
insert into music values(seq_music.nextval, 'Oh!', '소녀시대', to_date(100128));
insert into music values(seq_music.nextval, '2 Different Tears', '원더걸스', to_date(100516));
insert into music values(seq_music.nextval, '너 때문에 미쳐', '티아라', to_date(100223));
insert into music values(seq_music.nextval, 'Go Away', '2NE1', to_date(100909));
insert into music values(seq_music.nextval, '루팡', '카라', to_date(100217));
insert into music values(seq_music.nextval, '외톨이야', 'CNBLUE', to_date(100114));
insert into music values(seq_music.nextval, '고백', '뜨거운 감자', to_date(100330));
insert into music values(seq_music.nextval, '좋은 날', '아이유', to_date(101209));
insert into music values(seq_music.nextval, 'Love', 'CNBLUE', to_date(100519));
-- 2011
insert into music values(seq_music.nextval, 'Roly Poly', '티아라', to_date(110629));
insert into music values(seq_music.nextval, '바람났어', 'GG', to_date(110702));
insert into music values(seq_music.nextval, '내가 제일 잘 나가', '2NE1', to_date(110624));
insert into music values(seq_music.nextval, '비가 오는 날엔', '비스트', to_date(110512));
insert into music values(seq_music.nextval, 'So Cool', '씨스타', to_date(110809));
insert into music values(seq_music.nextval, '안녕이라고 말하지마', '다비치', to_date(110829));
insert into music values(seq_music.nextval, '그리워 그리워', '노을', to_date(111026));
insert into music values(seq_music.nextval, 'Hello', '허각', to_date(110916));
insert into music values(seq_music.nextval, 'Hands Up', '2PM', to_date(110620));
insert into music values(seq_music.nextval, '별빛달빛', '시크릿', to_date(110601));
-- 2012
insert into music values(seq_music.nextval, '강남스타일', '싸이', to_date(120715));
insert into music values(seq_music.nextval, '나혼자', '씨스타', to_date(120412));
insert into music values(seq_music.nextval, '벚꽃 엔딩', '버스커버스커', to_date(120329));
insert into music values(seq_music.nextval, 'Loving U', '씨스타', to_date(120628));
insert into music values(seq_music.nextval, 'I Love You', '2NE1', to_date(120705));
insert into music values(seq_music.nextval, 'Heaven', '에일리', to_date(120209));
insert into music values(seq_music.nextval, '하루 끝', '아이유', to_date(120511));
insert into music values(seq_music.nextval, 'Lovey Dovey', '티아라', to_date(120103));
insert into music values(seq_music.nextval, 'Twinkle', '소녀시대-태티서', to_date(120430));
insert into music values(seq_music.nextval, '바람기억', '나얼', to_date(120920));
-- 2013
insert into music values(seq_music.nextval, '자니', '프라이머리', to_date(120307));
insert into music values(seq_music.nextval, '눈물', '리쌍', to_date(130125));
insert into music values(seq_music.nextval, 'No No No', '에이핑크', to_date(130705));
insert into music values(seq_music.nextval, '눈물샤워', '배치기', to_date(130114));
insert into music values(seq_music.nextval, 'Give It To Me', '씨스타', to_date(130611));
insert into music values(seq_music.nextval, '이름이 뭐예요?', '포미닛', to_date(130426));
insert into music values(seq_music.nextval, '있다 없으니까', '씨스타19', to_date(130131));
insert into music values(seq_music.nextval, '으르렁', 'EXO', to_date(130805));
insert into music values(seq_music.nextval, '거북이', '다비치', to_date(130304));
insert into music values(seq_music.nextval, '빠빠빠', '크레용팝', to_date(130620));
-- 2014
insert into music values(seq_music.nextval, '야생화', '박효신', to_date(140328));
insert into music values(seq_music.nextval, '눈, 코, 입', '태양', to_date(140603));
insert into music values(seq_music.nextval, '금요일에 만나요', '아이유', to_date(131220));
insert into music values(seq_music.nextval, 'Mr. Chu', '에이핑크', to_date(140331));
insert into music values(seq_music.nextval, '너의 의미', '아이유', to_date(140516));
insert into music values(seq_music.nextval, 'Something', '걸스데이', to_date(140103));
insert into music values(seq_music.nextval, '200%', 'AKMU', to_date(140407));
insert into music values(seq_music.nextval, '그대가 분다', '엠씨더맥스', to_date(140102));
insert into music values(seq_music.nextval, 'Come Back Home', '2NE1', to_date(140227));
insert into music values(seq_music.nextval, '너의 모든 순간', '성시경', to_date(140212));
-- 2015
insert into music values(seq_music.nextval, '뱅뱅뱅', 'BIGBANG', to_date(150601));
insert into music values(seq_music.nextval, '같은 시간 속의 너', '나얼', to_date(150205));
insert into music values(seq_music.nextval, '이럴거면 그러지말지', '백아연', to_date(150520));
insert into music values(seq_music.nextval, '위잉위잉', '혁오', to_date(140918));
insert into music values(seq_music.nextval, '또 다시 사랑', '임창정', to_date(150922));
insert into music values(seq_music.nextval, '레옹', '이유 갓지 않은 이유', to_date(150822));
insert into music values(seq_music.nextval, '와리가리', '혁오', to_date(150528));
insert into music values(seq_music.nextval, '위아래', 'EXID', to_date(150827));
insert into music values(seq_music.nextval, '심쿵해', 'AOA', to_date(150622));
insert into music values(seq_music.nextval, '다른 남자 말고 너', '미쓰에이', to_date(150330));
insert into music values(seq_music.nextval, '두사랑', '다비치', to_date(150318));
insert into music values(seq_music.nextval, 'Boys And Girls', '지코', to_date(151103));
insert into music values(seq_music.nextval, '오늘부터 우리는', '여자친구', to_date(150723));
insert into music values(seq_music.nextval, '걱정말아요 그대', '이적', to_date(151107));
-- 2016
insert into music values(seq_music.nextval, 'Cheer Up', 'TWICE', to_date(160425));
insert into music values(seq_music.nextval, '시간을 달려서', '여자친구', to_date(160125));
insert into music values(seq_music.nextval, '어디에도', '엠씨더맥스', to_date(160128));
insert into music values(seq_music.nextval, '널 사랑하지 않아', '어반자카파', to_date(160527));
insert into music values(seq_music.nextval, '이 사랑', '다비치', to_date(160303));
insert into music values(seq_music.nextval, '너는 나 나는 너', '지코', to_date(160125));
insert into music values(seq_music.nextval, 'You Are My Everything', '거미', to_date(160310));
insert into music values(seq_music.nextval, '내가 저지른 사랑', '임창정', to_date(160906));
insert into music values(seq_music.nextval, '우주를 줄게', '볼빨간사춘기', to_date(160829));
insert into music values(seq_music.nextval, 'Why So Lonely', '원더걸스', to_date(160705));
-- 2017
insert into music values(seq_music.nextval, '첫눈처럼 너에게 가겠다', '에일리', to_date(170107));
insert into music values(seq_music.nextval, '밤편지', '아이유', to_date(170324));
insert into music values(seq_music.nextval, '좋니', '윤종신', to_date(170622));
insert into music values(seq_music.nextval, '좋다고 말해', '볼빨간사춘기', to_date(161221));
insert into music values(seq_music.nextval, '비도 오고 그래서', '헤이즈', to_date(170626));
insert into music values(seq_music.nextval, '팔레트', '아이유', to_date(170421));
insert into music values(seq_music.nextval, '봄날', '방탄소년단', to_date(170213));
insert into music values(seq_music.nextval, '오랜 날 오랜 밤', 'AKMU', to_date(170103));
insert into music values(seq_music.nextval, '선물', '멜로망스', to_date(170710));
insert into music values(seq_music.nextval, '마지막처럼', '블랙핑크', to_date(170622));
insert into music values(seq_music.nextval, '빨간 맛', '레드벨벳', to_date(170709));
-- 2018
insert into music values(seq_music.nextval, '모든 날, 모든 순간', '폴킴', to_date(180320));
insert into music values(seq_music.nextval, '뿜뿜', '모모랜드', to_date(180103));
insert into music values(seq_music.nextval, '뚜두뚜두', '블랙핑크', to_date(180615));
insert into music values(seq_music.nextval, '여행', '볼빨간사춘기', to_date(180524));
insert into music values(seq_music.nextval, 'You', '멜로망스', to_date(180122));
insert into music values(seq_music.nextval, '별이 빛나는 밤', '마마무', to_date(180307));
insert into music values(seq_music.nextval, 'Roller Coaster', '청하', to_date(180117));
insert into music values(seq_music.nextval, 'Dance The Night Away', 'TWICE', to_date(180709));
insert into music values(seq_music.nextval, '꽃 길', 'BIGBANG', to_date(180313));
insert into music values(seq_music.nextval, 'Forever Young', '블랙핑크', to_date(180615));
insert into music values(seq_music.nextval, 'Bad Boy', '레드벨벳', to_date(180129));
insert into music values(seq_music.nextval, '밤', '여자친구', to_date(180430));
insert into music values(seq_music.nextval, '너를 만나', '폴킴', to_date(181029));
-- 2019
insert into music values(seq_music.nextval, '작은 것들을 위한 시', '방탄소년단', to_date(190412));
insert into music values(seq_music.nextval, '넘쳐흘러', '엠씨더맥스', to_date(190102));
insert into music values(seq_music.nextval, '사계', '태연', to_date(190324));
insert into music values(seq_music.nextval, '주저하는 연인들을 위해', '잔나비', to_date(190313));
insert into music values(seq_music.nextval, '벌써 12시', '청하', to_date(190102));
insert into music values(seq_music.nextval, '옥탑방', '엔플라잉', to_date(190102));
insert into music values(seq_music.nextval, '달라달라', 'ITZY', to_date(190212));
insert into music values(seq_music.nextval, '나만, 봄', '볼빨간사춘기', to_date(190402));
insert into music values(seq_music.nextval, '사계', '엠씨더맥스', to_date(190102));
insert into music values(seq_music.nextval, 'Psycho', '레드벨벳', to_date(191223));
insert into music values(seq_music.nextval, '안녕', '폴킴', to_date(190812));
-- 2020
insert into music values(seq_music.nextval, '아무노래', '지코', to_date(200113));
insert into music values(seq_music.nextval, '아로하', '조정석', to_date(200327));
insert into music values(seq_music.nextval, '에잇', '아이유', to_date(200506));
insert into music values(seq_music.nextval, 'Dynamite', '방탄소년단', to_date(200821));
insert into music values(seq_music.nextval, '마음을 드려요', '아이유', to_date(200215));
insert into music values(seq_music.nextval, '처음처럼', '엠씨더맥스', to_date(200325));
insert into music values(seq_music.nextval, 'How You Like That', '블랙핑크', to_date(200626));
insert into music values(seq_music.nextval, '살짝 설렜어', '오마이걸', to_date(200427));
insert into music values(seq_music.nextval, '마리아', '화사', to_date(200629));
insert into music values(seq_music.nextval, '다시 여기 바닷가', '싹쓰리', to_date(200718));
insert into music values(seq_music.nextval, 'Dolphin', '오마이걸', to_date(200427));
-- 2021
insert into music values(seq_music.nextval, 'Celebrity', '아이유', to_date(210325));
insert into music values(seq_music.nextval, 'Next Level', '에스파', to_date(210517));
insert into music values(seq_music.nextval, '라일락', '아이유', to_date(210325));
insert into music values(seq_music.nextval, '신호등', '이무진', to_date(210514));
insert into music values(seq_music.nextval, 'Butter', '방탄소년단', to_date(210521));
insert into music values(seq_music.nextval, '헤픈 우연', '헤이즈', to_date(210520));
insert into music values(seq_music.nextval, 'Dun Dun Dance', '오마이걸', to_date(210510));
insert into music values(seq_music.nextval, 'Weekend', '태연', to_date(210706));
insert into music values(seq_music.nextval, '낙하', 'AKMU', to_date(210726));
insert into music values(seq_music.nextval, '바라만 본다', 'MSG워너비', to_date(210626));
-- 2022
insert into music values(seq_music.nextval, '사랑인가 봐', '멜로망스', to_date(220218));
insert into music values(seq_music.nextval, 'Love Dive', 'IVE', to_date(220405));
insert into music values(seq_music.nextval, '봄여름가을겨울', 'BIGBANG', to_date(220405));
insert into music values(seq_music.nextval, 'That That', '싸이', to_date(220429));
insert into music values(seq_music.nextval, 'Feel My Rhythm', '레드벨벳', to_date(220321));
insert into music values(seq_music.nextval, 'Hype Boy', '뉴진스', to_date(220801));
insert into music values(seq_music.nextval, 'Attention', '뉴진스', to_date(220801));
insert into music values(seq_music.nextval, '듣고 싶을까', 'MSG워너비', to_date(220226));
insert into music values(seq_music.nextval, 'Pink Venom', '블랙핑크', to_date(220916));
insert into music values(seq_music.nextval, '새삥', '지코', to_date(220906));
-- 2023
insert into music values(seq_music.nextval, 'Ditto', '뉴진스', to_date(230102));
insert into music values(seq_music.nextval, '파이팅 해야지', '부석순', to_date(230206));
insert into music values(seq_music.nextval, 'Sugar Rush Ride', '투모로우바이투게더', to_date(230127));
commit;

select * from music;

--
-- 유저 데이터 삽입
--
insert into userlist values (seq_user.nextval, 'user1', 'user1', '김철수', to_date(910101), 'user1@email', 'M');
insert into userlist values (seq_user.nextval, 'user2', 'user2', '김영희', to_date(920303), 'user2@email', 'W');
insert into userlist values (seq_user.nextval, 'user3', 'user3', '박철수', to_date(931104), 'user3@email', 'M');
insert into userlist values (seq_user.nextval, 'user4', 'user4', '박영희', to_date(940404), 'user4@email', 'W');
insert into userlist values (seq_user.nextval, 'user5', 'user5', '김길동', to_date(950505), 'user5@email', 'M');
insert into userlist values (seq_user.nextval, 'user6', 'user6', '김여자', to_date(960606), 'user6@email', 'W');
insert into userlist values (seq_user.nextval, 'user7', 'user7', '김남자', to_date(970707), 'user7@email', 'M');
insert into userlist values (seq_user.nextval, 'user8', 'user8', '박여자', to_date(980808), 'user8@email', 'W');
insert into userlist values (seq_user.nextval, 'user9', 'user9', '박길동', to_date(990909), 'user9@email', 'M');
insert into userlist values (seq_user.nextval, 'user10', 'user10', '이영희', to_date(20000909), 'user10@email', 'W');
insert into userlist values (seq_user.nextval, 'user11', 'user11', '이철수', to_date(20011020), 'user11@email', 'M');
insert into userlist values (seq_user.nextval, 'user12', 'user12', '최영희', to_date(20021119), 'user12@email', 'W');
insert into userlist values (seq_user.nextval, 'user13', 'user13', '최철수', to_date(20031209), 'user13@email', 'M');
insert into userlist values (seq_user.nextval, 'user14', 'user14', '한영희', to_date(20040111), 'user14@email', 'W');
insert into userlist values (seq_user.nextval, 'user15', 'user15', '한철수', to_date(20050909), 'user15@email', 'M');
insert into userlist values (seq_user.nextval, 'user16', 'user16', '김민지', to_date(20060422), 'user16@email', 'W');
insert into userlist values (seq_user.nextval, 'user17', 'user17', '김민수', to_date(20071127), 'user17@email', 'M');
insert into userlist values (seq_user.nextval, 'user18', 'user18', '최지수', to_date(20080222), 'user18@email', 'W');
insert into userlist values (seq_user.nextval, 'user19', 'user19', '최민수', to_date(20090909), 'user19@email', 'M');
commit;

select * from userlist;

-- 
-- 플레이리스트 데이터 삽입
--
-- user1
insert into playlist values (seq_playlist.nextval, 1, 1);
insert into playlist values (seq_playlist.nextval, 13, 1);
insert into playlist values (seq_playlist.nextval, 12, 1);
insert into playlist values (seq_playlist.nextval, 131, 1);
insert into playlist values (seq_playlist.nextval, 123, 1);
insert into playlist values (seq_playlist.nextval, 17, 1);
insert into playlist values (seq_playlist.nextval, 14, 1);
insert into playlist values (seq_playlist.nextval, 19, 1);
insert into playlist values (seq_playlist.nextval, 91, 1);
insert into playlist values (seq_playlist.nextval, 130, 1);
-- user2
insert into playlist values (seq_playlist.nextval, 12, 2);
insert into playlist values (seq_playlist.nextval, 27, 2);
insert into playlist values (seq_playlist.nextval, 92, 2);
insert into playlist values (seq_playlist.nextval, 112, 2);
insert into playlist values (seq_playlist.nextval, 32, 2);
insert into playlist values (seq_playlist.nextval, 62, 2);
insert into playlist values (seq_playlist.nextval, 77, 2);
insert into playlist values (seq_playlist.nextval, 142, 2);
insert into playlist values (seq_playlist.nextval, 122, 2);
insert into playlist values (seq_playlist.nextval, 82, 2);
-- user3
insert into playlist values (seq_playlist.nextval, 32, 3);
insert into playlist values (seq_playlist.nextval, 36, 3);
insert into playlist values (seq_playlist.nextval, 93, 3);
insert into playlist values (seq_playlist.nextval, 143, 3);
insert into playlist values (seq_playlist.nextval, 43, 3);
insert into playlist values (seq_playlist.nextval, 73, 3);
insert into playlist values (seq_playlist.nextval, 38, 3);
insert into playlist values (seq_playlist.nextval, 33, 3);
insert into playlist values (seq_playlist.nextval, 53, 3);
insert into playlist values (seq_playlist.nextval, 103, 3);
-- user4
insert into playlist values (seq_playlist.nextval, 43, 4);
insert into playlist values (seq_playlist.nextval, 45, 4);
insert into playlist values (seq_playlist.nextval, 94, 4);
insert into playlist values (seq_playlist.nextval, 104, 4);
insert into playlist values (seq_playlist.nextval, 114, 4);
insert into playlist values (seq_playlist.nextval, 54, 4);
insert into playlist values (seq_playlist.nextval, 84, 4);
insert into playlist values (seq_playlist.nextval, 34, 4);
insert into playlist values (seq_playlist.nextval, 74, 4);
insert into playlist values (seq_playlist.nextval, 124, 4);
-- user5
insert into playlist values (seq_playlist.nextval, 54, 5);
insert into playlist values (seq_playlist.nextval, 45, 5);
insert into playlist values (seq_playlist.nextval, 115, 5);
insert into playlist values (seq_playlist.nextval, 105, 5);
insert into playlist values (seq_playlist.nextval, 95, 5);
insert into playlist values (seq_playlist.nextval, 59, 5);
insert into playlist values (seq_playlist.nextval, 25, 5);
insert into playlist values (seq_playlist.nextval, 5, 5);
insert into playlist values (seq_playlist.nextval, 65, 5);
insert into playlist values (seq_playlist.nextval, 35, 5);
-- user6
insert into playlist values (seq_playlist.nextval, 65, 6);
insert into playlist values (seq_playlist.nextval, 6, 6);
insert into playlist values (seq_playlist.nextval, 116, 6);
insert into playlist values (seq_playlist.nextval, 69, 6);
insert into playlist values (seq_playlist.nextval, 126, 6);
insert into playlist values (seq_playlist.nextval, 66, 6);
insert into playlist values (seq_playlist.nextval, 86, 6);
insert into playlist values (seq_playlist.nextval, 26, 6);
insert into playlist values (seq_playlist.nextval, 96, 6);
insert into playlist values (seq_playlist.nextval, 46, 6);
-- user7
insert into playlist values (seq_playlist.nextval, 73, 7);
insert into playlist values (seq_playlist.nextval, 57, 7);
insert into playlist values (seq_playlist.nextval, 27, 7);
insert into playlist values (seq_playlist.nextval, 7, 7);
insert into playlist values (seq_playlist.nextval, 117, 7);
insert into playlist values (seq_playlist.nextval, 137, 7);
insert into playlist values (seq_playlist.nextval, 97, 7);
insert into playlist values (seq_playlist.nextval, 47, 7);
insert into playlist values (seq_playlist.nextval, 107, 7);
insert into playlist values (seq_playlist.nextval, 77, 7);
-- user8
insert into playlist values (seq_playlist.nextval, 38, 8);
insert into playlist values (seq_playlist.nextval, 82, 8);
insert into playlist values (seq_playlist.nextval, 8, 8);
insert into playlist values (seq_playlist.nextval, 28, 8);
insert into playlist values (seq_playlist.nextval, 138, 8);
insert into playlist values (seq_playlist.nextval, 108, 8);
insert into playlist values (seq_playlist.nextval, 78, 8);
insert into playlist values (seq_playlist.nextval, 58, 8);
insert into playlist values (seq_playlist.nextval, 80, 8);
insert into playlist values (seq_playlist.nextval, 85, 8);
-- user9
insert into playlist values (seq_playlist.nextval, 97, 9);
insert into playlist values (seq_playlist.nextval, 95, 9);
insert into playlist values (seq_playlist.nextval, 9, 9);
insert into playlist values (seq_playlist.nextval, 29, 9);
insert into playlist values (seq_playlist.nextval, 139, 9);
insert into playlist values (seq_playlist.nextval, 99, 9);
insert into playlist values (seq_playlist.nextval, 79, 9);
insert into playlist values (seq_playlist.nextval, 49, 9);
insert into playlist values (seq_playlist.nextval, 109, 9);
insert into playlist values (seq_playlist.nextval, 129, 9);
-- user10
insert into playlist values (seq_playlist.nextval, 138, 10);
insert into playlist values (seq_playlist.nextval, 108, 10);
insert into playlist values (seq_playlist.nextval, 78, 10);
insert into playlist values (seq_playlist.nextval, 19, 10);
insert into playlist values (seq_playlist.nextval, 91, 10);
insert into playlist values (seq_playlist.nextval, 86, 10);
insert into playlist values (seq_playlist.nextval, 26, 10);
insert into playlist values (seq_playlist.nextval, 114, 10);
insert into playlist values (seq_playlist.nextval, 54, 10);
insert into playlist values (seq_playlist.nextval, 84, 10);
-- user11
insert into playlist values (seq_playlist.nextval, 108, 11);
insert into playlist values (seq_playlist.nextval, 78, 11);
insert into playlist values (seq_playlist.nextval, 19, 11);
insert into playlist values (seq_playlist.nextval, 26, 11);
insert into playlist values (seq_playlist.nextval, 114, 11);
insert into playlist values (seq_playlist.nextval, 7, 11);
insert into playlist values (seq_playlist.nextval, 117, 11);
insert into playlist values (seq_playlist.nextval, 36, 11);
insert into playlist values (seq_playlist.nextval, 93, 11);
insert into playlist values (seq_playlist.nextval, 143, 11);
-- user12
insert into playlist values (seq_playlist.nextval, 78, 12);
insert into playlist values (seq_playlist.nextval, 19, 12);
insert into playlist values (seq_playlist.nextval, 54, 12);
insert into playlist values (seq_playlist.nextval, 84, 12);
insert into playlist values (seq_playlist.nextval, 59, 12);
insert into playlist values (seq_playlist.nextval, 25, 12);
insert into playlist values (seq_playlist.nextval, 5, 12);
insert into playlist values (seq_playlist.nextval, 92, 12);
insert into playlist values (seq_playlist.nextval, 112, 12);
insert into playlist values (seq_playlist.nextval, 32, 12);
-- user13
insert into playlist values (seq_playlist.nextval, 25, 13);
insert into playlist values (seq_playlist.nextval, 5, 13);
insert into playlist values (seq_playlist.nextval, 92, 13);
insert into playlist values (seq_playlist.nextval, 143, 13);
insert into playlist values (seq_playlist.nextval, 43, 13);
insert into playlist values (seq_playlist.nextval, 73, 13);
insert into playlist values (seq_playlist.nextval, 26, 13);
insert into playlist values (seq_playlist.nextval, 96, 13);
insert into playlist values (seq_playlist.nextval, 123, 13);
insert into playlist values (seq_playlist.nextval, 17, 13);
-- user14
insert into playlist values (seq_playlist.nextval, 143, 14);
insert into playlist values (seq_playlist.nextval, 43, 14);
insert into playlist values (seq_playlist.nextval, 73, 14);
insert into playlist values (seq_playlist.nextval, 108, 14);
insert into playlist values (seq_playlist.nextval, 78, 14);
insert into playlist values (seq_playlist.nextval, 92, 14);
insert into playlist values (seq_playlist.nextval, 27, 14);
insert into playlist values (seq_playlist.nextval, 49, 14);
insert into playlist values (seq_playlist.nextval, 109, 14);
insert into playlist values (seq_playlist.nextval, 27, 14);
-- user15
insert into playlist values (seq_playlist.nextval, 59, 15);
insert into playlist values (seq_playlist.nextval, 25, 15);
insert into playlist values (seq_playlist.nextval, 49, 15);
insert into playlist values (seq_playlist.nextval, 109, 15);
insert into playlist values (seq_playlist.nextval, 7, 15);
insert into playlist values (seq_playlist.nextval, 117, 15);
insert into playlist values (seq_playlist.nextval, 36, 15);
insert into playlist values (seq_playlist.nextval, 94, 15);
insert into playlist values (seq_playlist.nextval, 104, 15);
insert into playlist values (seq_playlist.nextval, 144, 15);
-- user16
insert into playlist values (seq_playlist.nextval, 109, 16);
insert into playlist values (seq_playlist.nextval, 7, 16);
insert into playlist values (seq_playlist.nextval, 117, 16);
insert into playlist values (seq_playlist.nextval, 79, 16);
insert into playlist values (seq_playlist.nextval, 49, 16);
insert into playlist values (seq_playlist.nextval, 123, 16);
insert into playlist values (seq_playlist.nextval, 17, 16);
insert into playlist values (seq_playlist.nextval, 28, 16);
insert into playlist values (seq_playlist.nextval, 138, 16);
insert into playlist values (seq_playlist.nextval, 108, 16);
-- user17
insert into playlist values (seq_playlist.nextval, 77, 17);
insert into playlist values (seq_playlist.nextval, 27, 17);
insert into playlist values (seq_playlist.nextval, 79, 17);
insert into playlist values (seq_playlist.nextval, 49, 17);
insert into playlist values (seq_playlist.nextval, 123, 17);
insert into playlist values (seq_playlist.nextval, 26, 17);
insert into playlist values (seq_playlist.nextval, 114, 17);
insert into playlist values (seq_playlist.nextval, 80, 17);
insert into playlist values (seq_playlist.nextval, 85, 17);
insert into playlist values (seq_playlist.nextval, 1, 17);
-- user18
insert into playlist values (seq_playlist.nextval, 43, 18);
insert into playlist values (seq_playlist.nextval, 73, 18);
insert into playlist values (seq_playlist.nextval, 26, 18);
insert into playlist values (seq_playlist.nextval, 92, 18);
insert into playlist values (seq_playlist.nextval, 112, 18);
insert into playlist values (seq_playlist.nextval, 32, 18);
insert into playlist values (seq_playlist.nextval, 47, 18);
insert into playlist values (seq_playlist.nextval, 107, 18);
insert into playlist values (seq_playlist.nextval, 84, 18);
insert into playlist values (seq_playlist.nextval, 34, 18);
-- user19
insert into playlist values (seq_playlist.nextval, 78, 19);
insert into playlist values (seq_playlist.nextval, 19, 19);
insert into playlist values (seq_playlist.nextval, 91, 19);
insert into playlist values (seq_playlist.nextval, 26, 19);
insert into playlist values (seq_playlist.nextval, 96, 19);
insert into playlist values (seq_playlist.nextval, 124, 19);
insert into playlist values (seq_playlist.nextval, 1, 19);
insert into playlist values (seq_playlist.nextval, 99, 19);
insert into playlist values (seq_playlist.nextval, 126, 19);
insert into playlist values (seq_playlist.nextval, 36, 19);
commit;
select * from playlist;