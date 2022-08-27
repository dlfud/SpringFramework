package com.example.board.mapper;

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
public class ReplyMapperTests {
	private Long[] arBno = {10301L, 10298L, 10297L, 10296L, 10295L};
	
	@Autowired
	ReplyMapper replyMapper;
	
	@Test
	public void mapperTest() {
		log.info(replyMapper);
	}
	
//	@Test
//	public void insertTest() {
//		//5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(1, 10).forEach(i -> {
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i % 5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("작성자" + i);
//			
//			replyMapper.insert(replyVO);
//		});
//	}
	
//	@Test
//	public void selectTest() {
//		log.info(replyMapper.select(10L));
//	}
	
//	@Test
//	public void deleteTest() {
//		log.info(replyMapper.delete(10L));
//	}
	
//	@Test
//	public void deleteAllTest() {
//		log.info(replyMapper.deleteAll(10295L));
//	}
	
//	@Test
//	public void updateTest() {
//		ReplyVO replyVO = replyMapper.select(300L);
//		if(replyVO != null) {
//			replyVO.setReply("수정된 댓글 내용");			
//		}
//		
//		log.info("=====================");
//		log.info(replyVO == null ? "없는 댓글 번호 입니다." : replyMapper.update(replyVO) + "건 수정되었습니다.");
//		log.info("=====================");
//	}
	
	@Test
	public void selectAllTest() {
		replyMapper.selectAll(10297L).forEach(log::info);
	}
}