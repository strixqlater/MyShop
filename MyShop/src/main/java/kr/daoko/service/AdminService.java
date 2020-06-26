package kr.daoko.service;

import java.util.List;

import kr.daoko.domain.CategoryVO;

public interface AdminService {
	// 카테고리	
	public List<CategoryVO> category() throws Exception;
}
