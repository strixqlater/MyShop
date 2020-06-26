<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>
<c:if test="${member != null}">
	<li>
		<a href="/">돌아가기</a>
	</li>
	<li>
		${member.userName}님! 환영합니다!
	</li>
	<li>
		<a href="/member/signout">로그아웃</a>
	</li>
</c:if>
</ul>