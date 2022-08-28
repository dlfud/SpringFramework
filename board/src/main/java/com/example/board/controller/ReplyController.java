package com.example.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequiredArgsConstructor
@Log4j
@RequestMapping("/replies/*")
public class ReplyController {
	private final ReplyService replyService;
	
	//헤더에 담겨서 오면 @ReauestBody
	//url 에 담겨서 오면 @PathVariable
	
	//댓글 등록
	//consumes : 외부에서 전달받을 데이터 타입
	//@RequestBody : json으로 전달받은 데이터를 필드에 매핑해줌, json에 key값과 필드의 이름이 같아야 매핑이 됨
	//produces : 결과 리턴할 타입
	//ResponseEntity<String> : String 은 리턴할 타입(produces에 있는 타입)
	@PostMapping(value="/new", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) {
		log.info("create... : " + replyVO);
		return replyService.register(replyVO) ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//게시글 댓글 전체 조회
	//@PathVariable("bno") : 경로에 bno라는게 있으면 뒤에 변수에 넣어라
	//xml, json으로 데이터 전송 가능
	//replyService.findAllByBNO(bno)이 값을 produces에 있는 xml타입으로 보내겠다
	@GetMapping(value="/{bno}/{page}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") Long bno, @PathVariable("page") int page) {
		log.info("getList... : " + bno);
		return new ResponseEntity<>(replyService.findAllByBNO(bno), HttpStatus.OK);
	}
	
	
	//댓글 1개 조회
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ReplyVO getReply(@PathVariable("rno") Long rno) {
		log.info("getReply... : " + rno);
		return replyService.findByRNO(rno);
	}
	
	
	//댓글 삭제
	//delete로 하는 이유는 구분점을 지어주기 위해서
	@DeleteMapping(value="/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String remove(@PathVariable("rno") Long rno) {
		log.info("remove... : " + rno);
		return replyService.remove(rno) ? "success" : "fail";
	}
	
	
	//댓글 수정
	//그냥 구분해 놓은 방식, 보통 post로 씀
	//PUT : 자원의 전체 수정, 자원 내 모든 필드를 전달해야 함 -> 디폴터 설정해 놓은게 없어서 무조건 다 전달 안하면 오류남
	//PATCH : 자원의 일부 수정, 수정할 필드만 전송 -> 많은 필드중 하나만 전달해도 나머지 필드는 알고리즘으로 설정된 디폴트값으로 넣어줌
	@PutMapping(value="/{rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public String modify(@PathVariable("rno") Long rno, @RequestBody ReplyVO replyVO) {
		replyVO.setRno(rno);
		return replyService.modify(replyVO) ? "success" : "fail";
	}
}