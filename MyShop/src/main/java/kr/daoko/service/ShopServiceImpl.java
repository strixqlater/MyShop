package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.domain.GoodsViewVO;
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
}
