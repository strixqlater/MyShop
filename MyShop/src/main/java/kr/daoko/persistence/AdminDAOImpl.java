package kr.daoko.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.daoko.domain.CategoryVO;
import kr.daoko.domain.GoodsVO;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@Inject
	private SqlSession sql;
	
	// 매퍼
	private static String namespace = "kr.daoko.mappers.adminMapper";

	// 카테고리
	@Override
	public List<CategoryVO> category() throws Exception {
		return sql.selectList(namespace + ".category");
	}

	// 상품 등록
	@Override
	public void register(GoodsVO vo) throws Exception {
		sql.insert(namespace + ".register", vo);
	}
	
	
}
