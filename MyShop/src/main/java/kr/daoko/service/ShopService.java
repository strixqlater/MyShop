package kr.daoko.service;

import java.util.List;

import kr.daoko.domain.GoodsViewVO;
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
}
