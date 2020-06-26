package kr.daoko.persistence;

import java.util.List;

import kr.daoko.domain.CategoryVO;

public interface AdminDAO {
	// 카테고리
	public List<CategoryVO> category() throws Exception;
}
