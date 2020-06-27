package kr.daoko.persistence;

import java.util.List;

import kr.daoko.domain.CategoryVO;
import kr.daoko.domain.GoodsVO;

public interface AdminDAO {
	// 카테고리
	public List<CategoryVO> category() throws Exception;
	
	// 상품 등록
	public void register(GoodsVO vo) throws Exception;
	
	// 상품 목록
	public List<GoodsVO> goodslist() throws Exception;
	
	// 상품 조회
	public GoodsVO goodsView(String gdsCode) throws Exception;
}
