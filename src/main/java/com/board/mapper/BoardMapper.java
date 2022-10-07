package com.board.mapper;

import java.util.List;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int getTotalCount(Criteria cri);
	
	public void insert(BoardVO board);

	//bno값을 먼저 확보후에 db에 insert하기 위함
	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
}
