package kr.co.itcen.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.jblog.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	private SqlSession sqlSession;

	public void deletePostOfCategory(Long categoryNo) {
		sqlSession.delete("deletePostOfCategory",categoryNo);
	}

	public void insertPost(PostVo postVo) {
		sqlSession.insert("insertPost", postVo);
		
	}

	
}
