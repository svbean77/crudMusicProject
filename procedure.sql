-- 회원가입 프로시저로 작성
create or replace procedure p_signup(seq_user in number,
                          userid in userlist.user_id%type,
                          userpw in userlist.user_pw%type,
                          username in userlist.user_name%type,
                          userday in userlist.user_day%type,
                          useremail in userlist.user_email%type,
                          usergender in userlist.user_gender%type,
                          message out varchar2)
is
    exist char(1):='0';
begin
    select
    case when exists(select * from userlist where user_id=userid) then '1'
         when exists(select * from userlist where user_email=useremail) then '2'
    end
    into exist
    from dual;
    
    if(exist = '1')
        then message:='이미 존재하는 아이디입니다.';
    elsif(exist = '2')
        then message:='이미 존재하는 이메일입니다.';
    else
        insert into userlist
        values (seq_user, userid, userpw, username, userday, useremail, usergender);
        message:='회원가입이 완료되었습니다.';
    end if;
end;
/


-- 내 정보 수정
create or replace procedure p_editInfo(userid in userlist.user_id%type,
                          userpw in userlist.user_pw%type,
                          username in userlist.user_name%type,
                          userday in userlist.user_day%type,
                          useremail in userlist.user_email%type,
                          usergender in userlist.user_gender%type,
                          message out varchar2)
is
    exist char(1):='0';
begin
    select
    case when exists(select * from userlist where user_email=useremail) then '1'
    end
    into exist
    from dual;
    
    if(exist = '1')
        then message:='이미 존재하는 이메일입니다.';
    else
        update userlist
        set user_pw=userpw, user_name=username, user_day=userday, user_email=useremail, user_gender=usergender
        where user_id=userid;
        message:='회원 정보 수정이 완료되었습니다.';
    end if;
end;
/