package com.example.board.domain.dao;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.ReplyVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyDAOTests {
	
	private Long[] arBno = {10301L, 10298L, 10297L, 10296L, 10295L};
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Test
	public void mapperTest() {
		log.info(replyDAO);
	}
	
//	@Test
//	public void registerTest() {
//		//5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(11, 20).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i % 5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("작성자" + i);
//			
//			replyDAO.register(replyVO);
//		});
//	}
	
//	@Test
//	public void findByRNOTest() {
//		log.info(replyDAO.findByRNO(15L));
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(replyDAO.remove(15L));
//	}
	
//	@Test
//	public void removeAllByBNOTest() {
//		log.info(replyDAO.removeAllByBNO(10298L));
//	}
	
//	@Test
//	public void updateTest() {
//		ReplyVO replyVO = replyDAO.findByRNO(300L);
//		if(replyVO != null) {
//			replyVO.setReply("수정된 댓글 테스트 2");			
//		}
//		
//		log.info("=====================");
//		log.info(replyVO == null ? "없는 댓글 번호 입니다." : replyDAO.modify(replyVO) + "건 수정되었습니다.");
//		log.info("=====================");
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyDAO.findAllByBNO(10297L).forEach(log::info);
	}
}
