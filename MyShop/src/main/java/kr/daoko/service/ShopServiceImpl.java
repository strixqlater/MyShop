package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.domain.CartListVO;
import kr.daoko.domain.CartVO;
import kr.daoko.domain.GoodsViewVO;
import kr.daoko.domain.OrderDetailVO;
import kr.daoko.domain.OrderListVO;
import kr.daoko.domain.OrderVO;
import kr.daoko.domain.ReplyListVO;
import kr.daoko.domain.ReplyVO;
import kr.daoko.persistence.ShopDAO;

@Service
public class ShopServiceImpl implements ShopService {
	@Inject
	private ShopDAO dao;

	// 카테고리별 상품 리스트
	@Override
	public List<GoodsViewVO> list(String cateCode, int level) throws Exception {
		String cateCodeRef = "0";
		
		if(level == 1) {
			cateCodeRef = cateCode;
			
			return dao.list(cateCode, cateCodeRef);
		}
		
		else {
			return dao.list(cateCode);
		}
	}

	// 상품 조회
	@Override
	public GoodsViewVO goodsView(String gdsCode) throws Exception {
		return dao.goodsView(gdsCode);
	}

	// 상품 소감(댓글) 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		dao.registReply(reply);
	}

	// 상품 소감(댓글) 리스트
	@Override
	public List<ReplyListVO> replyList(String gdsCode) throws Exception {
		return dao.replyList(gdsCode);
	}

	// 상품 소감(댓글) 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		dao.deleteReply(reply);
	}
	
	// 상품 소감(댓글) 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		dao.modifyReply(reply);
	}

	// 소감(댓글) 작성자 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return dao.idCheck(repNum);
	}

	// 카트 추가
	@Override
	public void addCart(CartVO cart) throws Exception {
		dao.addCart(cart);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return dao.cartList(userId);
	}

	// 카트 삭제
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		dao.deleteCart(cart);
	}

	// 주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		dao.orderInfo(order);
	}

	// 주문 상세 정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		dao.orderInfo_Details(orderDetail);
	}

	// 카트 비우
	@Override
	public void cartAllDelete(String userId) throws Exception {
		dao.cartAllDelete(userId);
	}

	// 주문 목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return dao.orderList(order);
	}

	// 특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return dao.orderView(order);
	}
}
