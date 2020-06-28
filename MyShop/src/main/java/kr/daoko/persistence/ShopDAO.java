package kr.daoko.persistence;

import java.util.List;

import kr.daoko.domain.GoodsViewVO;
import kr.daoko.domain.ReplyListVO;
import kr.daoko.domain.ReplyVO;

public interface ShopDAO {
	// 카테고리별 상품 리스트: 1차 분류
	public List<GoodsViewVO> list(String cateCode, String cateCodeRef) throws Exception;
	
	// 카테고리별 상품 리스트: 2차 분류
	public List<GoodsViewVO> list(String cateCode) throws Exception;
	
	// 상품 조회
	public GoodsViewVO goodsView(String gdsCode) throws Exception;
	
	// 상품 소감(댓글) 작성
	public void registReply(ReplyVO reply) throws Exception;
	
	// 상품 소감(댓글) 리스트
	public List<ReplyListVO> replyList(String gdsCode) throws Exception;
}
