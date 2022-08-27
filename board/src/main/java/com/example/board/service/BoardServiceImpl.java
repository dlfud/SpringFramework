package com.example.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	//boardDAO주입
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public void register(BoardVO board) {
		boardDAO.register(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return boardDAO.get(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		//어차피 불린타입이 들어옴
		return boardDAO.modify(board);
	}

	@Override
	public boolean remove(Long bno) {
		return boardDAO.remove(bno);
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		return boardDAO.getList(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		return boardDAO.getTotal(criteria);
	}

}
