package kr.daoko.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.domain.GoodsViewVO;

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
}
