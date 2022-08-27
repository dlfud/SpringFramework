package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.ReplyVO;

@Mapper
public interface ReplyMapper {
	//insert, update, delete -> 건수가 반환됨
	public int insert(ReplyVO replyVO);//1일때 성공 0일때 실패
	public ReplyVO select(Long rno);//댓글 하나 가져올 것이므로 리턴 ReplyVO로 구분번호 rno 
	public int delete(Long rno);
	public int deleteAll(Long bno);
	public int update(ReplyVO replyVO);
	public List<ReplyVO> selectAll(Long bno);
}
