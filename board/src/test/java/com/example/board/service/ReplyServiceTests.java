package com.example.board.service;

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
public class ReplyServiceTests {
private Long[] arBno = {10301L, 10298L, 10297L, 10296L, 10295L};
	
	@Autowired
	private ReplyService replyService;
	
	@Test
	public void mapperTest() {
		log.info(replyService);
	}
	
//	@Test
//	public void registerTest() {
//		//5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(21, 30).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i % 5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("작성자" + i);
//			
//			replyService.register(replyVO);
//		});
//	}
	
//	@Test
//	public void findByRNOTest() {
//		log.info(replyService.findByRNO(30L));
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(replyService.remove(30L));
//	}
	
//	@Test
//	public void removeAllByBNOTest() {
//		log.info(replyService.removeAllByBNO(10295L));
//	}
	
//	@Test
//	public void updateTest() {
//		ReplyVO replyVO = replyService.findByRNO(28L);
//		if(replyVO != null) {
//			replyVO.setReply("수정된 댓글 테스트 2");			
//		}
//		
//		log.info("=====================");
//		log.info(replyVO == null ? "없는 댓글 번호 입니다." : replyService.modify(replyVO) + "건 수정되었습니다.");
//		log.info("=====================");
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyService.findAllByBNO(10297L).forEach(log::info);
	}
}