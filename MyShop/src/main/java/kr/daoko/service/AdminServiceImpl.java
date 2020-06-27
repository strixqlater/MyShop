package kr.daoko.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.daoko.domain.CategoryVO;
import kr.daoko.domain.GoodsVO;
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
}
