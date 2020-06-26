<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My#</title>
</head>
<body>
<div id="root">
	<header id="header">
		<div id="header_box">
			<%@ include file="../include/header.jsp" %>
		</div>
	</header>
	
	<nav id="nav">
		<div id="nav_box">
			<%@ include file="../include/nav.jsp" %>
		</div>
	</nav>
	
	<section id="container">
		<div id="container_box">
			
			<section id="content">
				<form role="form" method="post" autocomplete="off">
					<div class="input_area">
						<label for="userId">아이디</label>
						<input type="email" id="userId" name="userId" placeholder="example@domain.com" required="required" />
					</div>
					
					<div class="input_area">
						<label for="userPw">비밀번호</label>
						<input type="password" id="userPw" name="userPw" required="required" />
					</div>
					
					<div class="input_area">
						<label for="userName">이름</label>
						<input type="text" id="userName" name="userName" placeholder="이름을 입력해주세요" required="required" />
					</div>
					
					<div class="input_area">
						<label for="userTel">연락처</label>
						<input type="tel" id="userTel" name="userTel" placeholder="ex.) 01000000000" required="required" />
					</div>
					
					<button type="submit" id="signup_btn" name="signup_btn">회원가입</button>
				</form>
			</section>

		</div>
	</section>
	
	<footer id="footer">
		<div id="footer_box">
			<%@ include file="../include/footer.jsp" %>
		</div>
	</footer>
</div>
</body>
</html>