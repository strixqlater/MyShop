package kr.daoko.service;

import java.util.List;

import kr.daoko.domain.CartListVO;
import kr.daoko.domain.CartVO;
import kr.daoko.domain.GoodsViewVO;
import kr.daoko.domain.OrderDetailVO;
import kr.daoko.domain.OrderListVO;
import kr.daoko.domain.OrderVO;
import kr.daoko.domain.ReplyListVO;
import kr.daoko.domain.ReplyVO;

public interface ShopService {
	// 카테고리별 상품 리스트
	public List<GoodsViewVO> list(String cateCode, int level) throws Exception;
	
	// 상품 조회
	public GoodsViewVO goodsView(String gdsCode) throws Exception;
	
	// 상품 소감(댓글) 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	// 상품 소감(댓글) 리스트
	public List<ReplyListVO> replyList(String gdsCode) throws Exception;
	
	// 상품 소감(댓글) 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	// 상품 소감(댓글) 수정
	public void modifyReply(ReplyVO reply) throws Exception;
	
	// 소감(댓글) 작성자 체크
	public String idCheck(int repNum) throws Exception;
	
	// 카트 담기
	public void addCart(CartVO cart) throws Exception;
	
	// 카트 리스트
	public List<CartListVO> cartList(String userId) throws Exception;
	
	// 카트 삭제
	public void deleteCart(CartVO cart) throws Exception;
	
	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;
	
	// 주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
	
	// 카트 비우기
	public void cartAllDelete(String userId) throws Exception;
	
	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
}
