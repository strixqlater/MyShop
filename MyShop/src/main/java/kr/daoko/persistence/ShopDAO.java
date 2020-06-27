package kr.daoko.persistence;

import java.util.List;

import kr.daoko.domain.GoodsViewVO;

public interface ShopDAO {
	// 카테고리별 상품 리스트: 1차 분류
	public List<GoodsViewVO> list(String cateCode, String cateCodeRef) throws Exception;
	
	// 카테고리별 상품 리스트: 2차 분류
	public List<GoodsViewVO> list(String cateCode) throws Exception;
}
