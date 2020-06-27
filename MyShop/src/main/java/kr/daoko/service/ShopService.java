package kr.daoko.service;

import java.util.List;

import kr.daoko.domain.GoodsViewVO;

public interface ShopService {
	// 카테고리별 상품 리스트
	public List<GoodsViewVO> list(String cateCode, int level) throws Exception;
	
	// 상품 조회
	public GoodsViewVO goodsView(String gdsCode) throws Exception;
}
