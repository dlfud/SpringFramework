package com.example.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.service.BoardService;

import lombok.extern.log4j.Log4j;

/*
 * Task		URL					Method		Parameter		Form			URL이동
 * 
 * 전체 등록	/board/list			GET								입력화면 필요	이동	
 * 등록 처리	/board/register	POST			모든 항목			
 * 조회		/board/read		GET			bno				입력화면 필요	이동
 * 삭제 처리	/board/remove	GET			bno				입력화면 필요	이동
 * 수정 처리	/board/modify		POST			모든 항목
 */

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {
		log.info("list...");
		model.addAttribute("boardList", boardService.getList(criteria));
	}
	
	//redirect : 클라이언트의 요청에 의해 서버의 DB에 변화가 생기는 작업
	//forward : 특정 URL에 대해 외부에 공개되지 말아야 하는 부분을 가리는데 사용하거나 조회를 위해 사용
	
	//등록 완료 버튼 눌렀을 떄 
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("register : " + boardVO);
		boardService.register(boardVO);
		
//		데이터 전송방법 -> redirect방식으로 하면 데이터가 초기화됨
//		1. 세션 사용 -> 세션에 담아놨다가 불러옴
//		2. 쿼리스트링 -> URL에 데이터가 담겨 있음
		
//		Flash라는 영역은 Session에 생기고, redirect로 전송할 때 request영역이 초기화 된다.
//		초기화 되기 전에 Flash영역에 데이터를 저장해 놓고, 초기화 된 후 Flash영역에서 데이터를 가지고 온다.
//		데이터를 가져왔다면, Flash 영역에 있던 데이터는 없어진다.
		rttr.addAttribute("bno", boardVO.getBno());//세션에 담아 놓음
//		redirect로 전송할 때는 경로 앞에 "redirect:"을 붙여준다. 
		return "redirect:/board/list";
	}
	
	//get 방식 modify : 수정완료 버튼이 아닌 수정하기 버튼을 눌렀을 때
	@GetMapping({"/read", "/modify"})
	public void read(Long bno, HttpServletRequest request, Model model) {
		String url = request.getRequestURI();
		
		log.info(url.substring(url.lastIndexOf("/")) + " : " + bno);
		model.addAttribute("board", boardService.get(bno));
	}
	
	@GetMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("/remove : " + bno);
		
		if(boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		//삭제후 목록으로 돌아가야 함
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr) {
		log.info("/modify : " + boardVO);
		if(boardService.modify(boardVO)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
}
