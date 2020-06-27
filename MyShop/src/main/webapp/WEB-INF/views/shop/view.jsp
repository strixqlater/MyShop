<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My#</title>

<script src="/resources/jquery/jquery-3.5.1.min.js"></script>

<style>
	body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }
	a { color:#05f; text-decoration:none; }
	a:hover { text-decoration:underline; }

	h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
	ul, lo, li { margin:0; padding:0; list-style:none; }
	
	div#root { width:900px; margin:0 auto; }
	header#header { }
	nav#nav { }
	section#container { }
	section#content { float:right; width:700px; }
	aside#aside { float:left; width:180px; }
	section#container::after { content:""; display:block; clear:both; } 
	footer#footer { background:#eee; padding:20px; }

	header#header div#header_box { text-align:center; padding:30px 0; }
	header#header div#header_box h1 { font-size:50px; }
	header#header div#header_box h1 a { color:#000; }
	 
	nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }
	nav#nav div#nav_box li { display:inline-block; margin:0 10px; }
	nav#nav div#nav_box li a { color:#333; }
	
	section#container { }

	aside#aside h3 { font-size:22px; margin-bottom:20px; text-align:center; }
	aside#aside li { font-size:16px; text-align:center; }
	aside#aside li a { color:#000; display:block; padding:10px 0; }
	aside#aside li a:hover { text-decoration:none; background:#eee; }
	
	aside#aside li { position:relative; }
	aside#aside li:hover { background:#eee; }
	aside#aside li > ul.low { display:none; position:absolute; top:0; left:180px;  }
	aside#aside li:hover > ul.low { display:block; }
	aside#aside li:hover > ul.low li a { background:#eee; border:1px solid #eee; }
	aside#aside li:hover > ul.low li a:hover { background:#fff;}
	aside#aside li > ul.low li { width:180px; }

	footer#footer { margin-top:100px; border-radius:50px 50px 0 0; }
	footer#footer div#footer_box { padding:0 20px; }
</style>

<style>
	div.goods div.goodsImg { float:left; width:350px; }
	div.goods div.goodsImg img { width:350px; height:auto; }
	
	div.goods div.goodsInfo { float:right; width:330px; font-size:22px; }
	div.goods div.goodsInfo p { margin:0 0 20px 0; }
	div.goods div.goodsInfo p span { display:inline-block; width:100px; margin-right:15px; }
	
	div.goods div.goodsInfo p.cartStock input { font-size:22px; width:50px; padding:5px; margin:0; border:1px solid #eee; }
	div.goods div.goodsInfo p.cartStock button { font-size:26px; border:none; background:none; }
	div.goods div.goodsInfo p.addToCart { text-align:right; }
	div.goods div.goodsInfo p.addToCart button { font-size:22px; padding:5px 10px; border:1px solid #eee; background:#eee;}
	div.goods div.gdsDesc { font-size:18px; clear:both; padding-top:30px; }
</style>

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
	
	<aside id="aside">
		<%@ include file="../include/aside.jsp" %>
	</aside>
	
	<section id="container">
		<div id="container_box">
			<section id="content">
				<form role="form" method="post">
					<input type="hidden" name="gdsCode" value="${view.gdsCode}" />
				</form>
				
				<div class="goods">
					<div class="goodsImg">
						<img src="${view.gdsImg}" />
					</div>
					
					<div class="goodsInfo">
						<p class="gdsName"><span>상품명</span>${view.gdsName}</p>
						<p class="cateName"><span>카테고리</span>${view.cateName}</p>
						<p class="gdsPrice">
							<span>가격</span><fmt:formatNumber value="${view.gdsPrice}" pattern="###,###,###" />
						</p>
						<p class="cartStock">
							<span>구입 수량</span>
							<button type="button" class="plus">+</button>
							<input type="number" class="numBox" min="1" max="" value="1" readonly="readonly" />
							<button type="button" class="minus">-</button>
							
							<script>
								$(".plus").click(function() {
									var num = $(".numBox").val();
									var plusNum = Number(num) + 1;
									
									/*
									if(plusNum >= ) {
										$(".numBox").val(num);
									}
									
									else {
										$(".numBox").val(plusNum);
									}
									*/
									
									$(".numBox").val(plusNum);
								});
								
								$(".minus").click(function() {
									var num = $(".numBox").val();
									var minusNum = Number(num) - 1;
									
									if(minusNum <= 0) {
										$(".numBox").val(num);
									}
									
									else {
										$(".numBox").val(minusNum);
									}
								});
							</script>
						</p>
						<p class="addToCart">
							<button type="button">카트에 담기</button>
						</p>
					</div>
					
					<div class="gdsDesc">${view.gdsDesc}</div>
				</div>
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