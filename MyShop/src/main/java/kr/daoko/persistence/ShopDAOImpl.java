package kr.daoko.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.domain.CartListVO;
import kr.daoko.domain.CartVO;
import kr.daoko.domain.GoodsViewVO;
import kr.daoko.domain.OrderDetailVO;
import kr.daoko.domain.OrderListVO;
import kr.daoko.domain.OrderVO;
import kr.daoko.domain.ReplyListVO;
import kr.daoko.domain.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {
	@Inject
	private SqlSession sql;
	
	// 매퍼
	private static String namespace = "kr.daoko.mappers.shopMapper";
	
	// 카테고리별 상품 리스트: 1차 분류
	@Override
	public List<GoodsViewVO> list(String cateCode, String cateCodeRef) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);
		
		return sql.selectList(namespace + ".list_1", map);
	}

	// 카테고리별 상품 리스트: 2차 분류
	@Override
	public List<GoodsViewVO> list(String cateCode) throws Exception {
		return sql.selectList(namespace + ".list_2", cateCode);
	}

	// 상품 조회
	@Override
	public GoodsViewVO goodsView(String gdsCode) throws Exception {
		return sql.selectOne(namespace + ".goodsView", gdsCode);
	}

	// 상품 소감(댓글) 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}

	// 상품 소감(댓글) 리스트
	@Override
	public List<ReplyListVO> replyList(String gdsCode) throws Exception {
		return sql.selectList(namespace + ".replyList", gdsCode);
	}

	// 상품 소감(댓글) 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}
	
	// 상품 소감(댓글) 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}

	// 소감(댓글) 작성자 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	// 카트 추가
	@Override
	public void addCart(CartVO cart) throws Exception {
		sql.insert(namespace + ".addCart", cart);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return sql.selectList(namespace + ".cartList", userId);
	}

	// 카트 삭제
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		sql.delete(namespace + ".deleteCart", cart);
	}

	// 주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert(namespace + ".orderInfo", order);
	}

	// 주문 상세 정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
	}

	// 카트 비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace + ".cartAllDelete", userId);
	}

	// 주문 목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderList", order);
	}

	// 특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderView", order);
	}
}
