package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.domain.CategoryVO;
import kr.daoko.domain.GoodsVO;
import kr.daoko.domain.GoodsViewVO;
import kr.daoko.domain.OrderListVO;
import kr.daoko.domain.OrderVO;
import kr.daoko.domain.ReplyListVO;
import kr.daoko.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	@Inject
	private AdminDAO dao;

	
	// 카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

	// 상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
	}

	// 상품 목록
	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		return dao.goodslist();
	}

	// 상품 조회
	@Override
	public GoodsViewVO goodsView(String gdsCode) throws Exception {
		return dao.goodsView(gdsCode);
	}

	// 상품 수정
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
	}

	// 상품 삭제
	@Override
	public void goodsDelete(String gdsCode) throws Exception {
			dao.goodsDelete(gdsCode);
	}
	
	// 주문 목록
	@Override
	public List<OrderVO> orderList() throws Exception {
		return 	dao.orderList();
	}

	// 특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return dao.orderView(order);
	}

	// 모든 소감(댓글)
	@Override
	public List<ReplyListVO> allReply() throws Exception {
		return dao.allReply();
	}

	// 소감(댓글) 삭제
	@Override
	public void deleteReply(int repNum) throws Exception {
		dao.deleteReply(repNum);
	}
}
