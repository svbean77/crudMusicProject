## 신한DS 금융SW아카데미 1차 개인 프로젝트

### 테이블 구조
<img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/00_%ED%85%8C%EC%9D%B4%EB%B8%94.PNG?raw=true" width="80%" height="80%">
<br>

### 프로그램 로직
<img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/00_%EA%B5%AC%EC%A1%B0_%EC%B5%9C%EC%A2%85.png?raw=true" width="60%" height="60%">
<br>

### 메인 및 카테고리
<table>
  <tr>
    <td>메인 화면</td>
    <td>
    <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_00_%EB%A9%94%EC%9D%B8.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>인기 차트</td>
    <td>
    <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_00_01_%EC%9D%B8%EA%B8%B0%EC%B0%A8%ED%8A%B8.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>노래 검색</td>
    <td>
    <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_00_02_%EB%85%B8%EB%9E%98%EA%B2%80%EC%83%89.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>로그인&회원가입</td>
    <td>
    <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_00_03_%EB%A1%9C%EA%B7%B8%EC%9D%B8.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>플레이 리스트</td>
    <td>
    <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_00_04_%ED%94%8C%EB%A0%88%EC%9D%B4%EB%A6%AC%EC%8A%A4%ED%8A%B8.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>마이 페이지</td>
    <td>
    <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_00_05_%EB%A7%88%EC%9D%B4%ED%8E%98%EC%9D%B4%EC%A7%80.png?raw=true" width="60%">
    </td>
  </tr>
</table>
<br>

### 인기 차트
- 인기 차트는 회원의 플레이 리스트에 담긴 횟수를 기준으로 한다.
- 등수의 범위(5\~50, 3\~10)를 벗어나는 입력을 하면 차트가 출력되지 않는다.
- 연도의 범위(2010~2023)를 벗어나는 입력을 하면 차트가 출력되지 않는다.
<table>
  <tr>
    <td>전체 인기 차트</td>
    <td>
      <img      src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_01_%EC%A0%84%EC%B2%B4%EB%9E%AD%ED%82%B9_%EB%9E%AD%ED%82%B9%EB%B2%84%EB%B2%85.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>연도별 인기 차트</td>
    <td>
      <img      src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_02_%EC%97%B0%EB%8F%84%EB%9E%AD%ED%82%B9_%EC%97%B0%EB%8F%84%EB%B2%84%EB%B2%85.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>남성 인기 차트</td>
    <td>
      <img      src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_03_%EB%82%A8%EC%9E%90%EB%9E%AD%ED%82%B9.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>여성 인기 차트</td>
    <td>
      <img      src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/01_04_%EC%97%AC%EC%9E%90%EB%9E%AD%ED%82%B9.png?raw=true" width="60%">
    </td>
  </tr>
</table>
<br>

### 노래 검색
<table>
  <tr>
    <td>가수로 검색</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/02_01_%EA%B0%80%EC%88%98%EA%B2%80%EC%83%89.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>제목으로 검색</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/02_02_%EC%A0%9C%EB%AA%A9%EA%B2%80%EC%83%89.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>연도로 검색</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/02_03_%EC%97%B0%EB%8F%84%EA%B2%80%EC%83%89.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>가수+제목으로 검색</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/02_04_%EC%A0%95%ED%99%95%EA%B2%80%EC%83%89.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>전체 노래 조회</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/02_05_%EC%A0%84%EC%B2%B4%EA%B2%80%EC%83%89_%EB%A8%B8%EB%A6%AC.png?raw=true" width="60%">
    </td>
  </tr>
</table>
<br>

### 로그인&회원가입
- 생일, 이메일, 성별은 정해진 형식에 맞게 입력해야 한다.
- 아이디, 이메일을 중복된 값을 가질 수 없다.
- 비밀번호 찾기는 입력한 정보와 일치하는 직원을 찾은 후 비밀번호를 변경할 수 있도록 한다.
<table>
  <tr>
    <td rowspan="2">회원가입</td>
    <td>
      형식 오류
    </td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_02_%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85_%EC%96%91%EC%8B%9D%EC%A7%80%EC%BC%9C.png?raw=true" width="60%">
    </td>
    <td>
      아이디 중복
    </td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_02_%EC%95%84%EC%9D%B4%EB%94%94%EC%A4%91%EB%B3%B5.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>이메일 중복</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_02_%EC%9D%B4%EB%A9%94%EC%9D%BC%EC%A4%91%EB%B3%B5.png?raw=true" width="60%">
    </td>
    <td>
      성공
    </td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_02_%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>비밀번호변경</td>
    <td>
      일치 회원 X
    </td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_03_%EB%B9%84%EB%B2%88%EC%B0%BE%EA%B8%B0_%EC%97%86%EB%8A%94%ED%9A%8C%EC%9B%90.png?raw=true" width="60%">
    </td>
    <td>변경 성공</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_03_%EB%B9%84%EB%B2%88%EC%B0%BE%EA%B8%B0.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>로그인</td>
    <td colspan="4">
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/03_01_%EB%A1%9C%EA%B7%B8%EC%9D%B8(03_03_%EC%9D%B4%ED%9B%84%EC%97%90_%EB%84%A3%EA%B8%B0).png?raw=true" width="60%">
    </td>
  </tr>
</table>
<br>

### 플레이 리스트
- 플레이 리스트는 중복 곡을 추가할 수 없다.
<table border="1">
  	<tr rowspan="2">
	  	<td rowspan="2">플리추가</td>
  		<td rowspan="2">성공</td>
  		<td rowspan="2"><img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/04_02_%ED%94%8C%EB%A6%AC%EC%B6%94%EA%B0%80.png?raw=true" width="60%"></td>
  		<td>존재X</td>
  		<td><img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/04_02_%ED%94%8C%EB%A6%AC%EC%B6%94%EA%B0%80_%EC%97%86%EB%8A%94%EA%B3%A1.png?raw=true" width="60%"></td>
 	</tr>
 	<tr>
 		<td>플리O</td>
		<td><img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/04_02_%ED%94%8C%EB%A6%AC%EC%B6%94%EA%B0%80_%EC%A4%91%EB%B3%B5%EA%B3%A1.png?raw=true" width="60%"></td>
 	</tr>
 	<tr rowspan="2">
		<td rowspan="2">플리삭제</td>
		<td rowspan="2">성공</td>
		<td rowspan="2"><img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/04_03_%ED%94%8C%EB%A6%AC%EC%82%AD%EC%A0%9C.png?raw=true" width="60%"></td>
		<td>존재X</td>
		<td><img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/04_03_%ED%94%8C%EB%A6%AC%EC%82%AD%EC%A0%9C_%EC%97%86%EB%8A%94%EA%B3%A1.png?raw=true" width="60%"></td>
 	</tr>
 	<tr>
 		<td>플리X</td>
		<td><img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/04_03_%ED%94%8C%EB%A6%AC%EC%82%AD%EC%A0%9C_%EB%A6%AC%EC%8A%A4%ED%8A%B8%EC%97%90%EC%97%86%EB%8A%94%EA%B3%A1.png?raw=true" width="60%"></td>
 	</tr>
</table>
  
### 마이 페이지
<table>
  <tr>
    <td>정보수정</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/05_02_%EC%A0%95%EB%B3%B4%EC%88%98%EC%A0%95.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>로그아웃</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/05_03_%EB%A1%9C%EA%B7%B8%EC%95%84%EC%9B%83.png?raw=true" width="60%">
    </td>
  </tr>
  <tr>
    <td>회원탈퇴</td>
    <td>
      <img src="https://github.com/svbean77/Image_for_Velog/blob/master/SW%EC%95%84%EC%B9%B4%EB%8D%B0%EB%AF%B8/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B81_CRUD/05_04_%ED%9A%8C%EC%9B%90%ED%83%88%ED%87%B4.png?raw=true" width="60%">
    </td>
  </tr>
</table>
<br>
