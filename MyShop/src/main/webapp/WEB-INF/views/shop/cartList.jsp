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
	section#content ul li { margin:10px 0; padding:10px 0; border-bottom:1px solid #999; }
	section#content ul li img { width:250px; height:250px; }
	section#content ul li::after { content:""; display:block; clear:both; }
	section#content div.thumb { float:left; width:250px; }
	section#content div.gdsInfo { float:right; width:calc(100% - 320px); }
	section#content div.gdsInfo { font-size:20px; line-height:2; }
	section#content div.gdsInfo span { display:inline-block; width:100px; font-weight:bold; margin-right:10px; }
	section#content div.gdsInfo .delete { text-align:right; }
	section#content div.gdsInfo .delete button { font-size:18px; padding:5px 10px; border:1px solid #eee; background:#eee;}
	
	.allCheck { float:left; width:200px; }
	.allCheck input { width:16px; height:16px; }
	.allCheck label { margin-left:10px; }
	.delBtn { float:right; width:300px; text-align:right; }
	.delBtn button { font-size:18px; padding:5px 10px; border:1px solid #eee; background:#eee;}
	
	.checkBox { float:left; width:30px; }
	.checkBox input { width:16px; height:16px; }
	
	.listResult { padding:20px; background:#eee; }
	.listResult .sum { float:left; width:45%; font-size:22px; }
	
	.listResult .orderOpne { float:right; width:45%; text-align:right; }
	.listResult .orderOpne button { font-size:18px; padding:5px 10px; border:1px solid #999; background:#fff;}
	.listResult::after { content:""; display:block; clear:both; }
	
	.orderInfo { border:5px solid #eee; padding:20px; display:none; }
	.orderInfo .inputArea { margin:10px 0; }
	.orderInfo .inputArea label { display:inline-block; width:120px; margin-right:10px; }
	.orderInfo .inputArea input { font-size:14px; padding:5px; }
	#userAddr1, #userAddr2 { width:250px; }
	
	.orderInfo .inputArea:last-child { margin-top:30px; }
	.orderInfo .inputArea button { font-size:20px; border:2px solid #ccc; padding:5px 10px; background:#fff; margin-right:20px;}
	
	.orderInfo .inputArea #sample2_address { width:230px; }
	.orderInfo .inputArea #sample2_detailAddress { width:280px; }
	.orderInfo .inputArea #sample2_extraAddress { display:none; }
	
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
				<ul>
					<li>
						<div class="allCheck">
							<input type="checkbox" name="allCheck" id="allCheck" /><label for="allCheck">모두 선택</label>
							
							<script>
								$("#allCheck").click(function(){
									var chk = $("#allCheck").prop("checked");
									
									if(chk) {
										$(".chBox").prop("checked", true);
									}
									
									else {
										$(".chBox").prop("checked", false);
									}
								});
							</script>
						</div>
						
						<div class="delBtn">
							<button type="button" class="selectDelete_btn">선택 삭제</button>
							
							<script>
								$(".selectDelete_btn").click(function() {
									var confirm_val = confirm("정말 삭제하시겠습니까?");
									
									if(confirm_val) {
										var checkArr = new Array();
										
										$("input[class='chBox']:checked").each(function() {
											checkArr.push($(this).attr("data-cartNum"));
										});
										
										$.ajax({
											url: "/shop/deleteCart",
											type: "post",
											data: { chbox: checkArr },
											success: function(result) {
												if(result == 1) {
													location.href ="/shop/cartList";
												}
												
												else {
													alert("삭제 실패");
												}
											}
										});
									}
								});
							</script>
							
						</div>
					</li>
					
					<c:set var="sum" value="0" />
					
					<c:forEach items="${cartList}" var="cartList">
						<li>
							<div class="checkBox">
								<input type="checkbox" name="chBox" class="chBox" data-cartNum="${cartList.cartNum}" />
								
								<script>
									$(".chBox").click(function(){
										$("#allCheck").prop("checked", false);
									});
								</script>
								
							</div>
							<div class="thumb">
								<img src="${cartList.gdsThumbImg}" />
							</div>
							<div class="gdsInfo">
								<p>
									<span>상품명: </span>${cartList.gdsName}<br />
									<span>가격: </span><fmt:formatNumber value="${cartList.gdsPrice}" pattern="###,###,###" /> 원<br />
									<span>수량: </span>${cartList.cartStock} 개<br />
									<span>합계: </span><fmt:formatNumber value="${cartList.gdsPrice * cartList.cartStock}" pattern="###,###,###" /> 원
								</p>
								
								<div class="delete">
									<button type="button" class="delete_${cartList.cartNum}_btn" data-cartNum="${cartList.cartNum}">삭제</button>
									
									<script>
										$(".delete_${cartList.cartNum}_btn").click(function() {
											var confirm_val = confirm("정말 삭제하시겠습니까?");
											
											if(confirm_val) {
												var checkArr = new Array();
												
												checkArr.push($(this).attr("data-cartNum"));
												
												$.ajax({
													url: "/shop/deleteCart",
													type: "post",
													data: { chbox: checkArr },
													success: function(result) {
														if(result == 1) {
															location.href = "/shop/cartList";
														}
														
														else {
															alert("삭제 실패");
														}
													}
												});
											}
										});
									</script>
									
								</div>
							</div>
						</li>
						
						<c:set var="sum" value="${sum + (cartList.gdsPrice * cartList.cartStock)}" />
						
					</c:forEach>
				</ul>
				
				<div class="listResult">
					<div class="sum">
 						주문 금액: <fmt:formatNumber pattern="###,###,###" value="${sum}" />원
 					</div>
					<div class="orderOpne">
  						<button type="button" class="orderOpne_btn">주문 정보 입력</button>
  						
  						<script>
  							$(".orderOpne_btn").click(function() {
  								$(".orderInfo").slideDown();
  								$(".orderOpen_btn").slideUp();
  							});
  						</script>
					</div>
				</div>
				
				<div class="orderInfo">
					<form role="form" method="post" autocomplete="off">
						<input type="hidden" name="amount" value="${sum}" />
  
						<div class="inputArea">
							<label for="">수령인</label>
							<input type="text" name="orderRecv" id="orderRecv" required="required" />
						</div>

						<div class="inputArea">
							<label for="orderTel">수령인 연락처</label>
							<input type="text" name="orderTel" id="orderTel" required="required" />
						</div>

						<div class="inputArea">
							<label for="userZipcode">우편번호</label>
							<input type="text" name="userZipcode" id="userZipcode" required="required" />
						</div>

						<div class="inputArea">
							<label for="userAddr1">주소</label>
							<input type="text" name="userAddr1" id="userAddr1" required="required" />
						</div>
						
						<div class="inputArea">
							<label for="userAddr2">상세 주소</label>
							<input type="text" name="userAddr2" id="userAddr2" required="required" />
						</div>
						
						<div class="inputArea">
							<button type="submit" class="order_btn">주문</button>
							<button type="button" class="cancel_btn">취소</button>
							
							<script>
								$(".cancel_btn").click(function() {
									$(".orderInfo").slideUp();
									$(".orderOpne").slideDown();
								})
							</script>
						</div>
 
					</form> 
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