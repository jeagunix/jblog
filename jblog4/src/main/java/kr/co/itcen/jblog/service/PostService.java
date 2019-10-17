package kr.co.itcen.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.jblog.repository.PostDao;
import kr.co.itcen.jblog.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;

	public void deletePostOfCategory(Long categoryNo) {
		postDao.deletePostOfCategory(categoryNo);
		
	}

	public void insertPost(PostVo postVo) {
		postDao.insertPost(postVo);
		
	}

	

	
}
