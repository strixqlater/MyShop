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
					
					<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
					
					<c:if test="${msg == false}">
						<p style="color: #f00;">로그인에 실패했습니다.</p>
					</c:if>
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