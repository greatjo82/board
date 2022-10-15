package com.board.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.board.domain.BoardVO;
import com.board.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
	public void testGetList(){

		mapper.getList().forEach(board -> log.info(board));
	
	}
	
//	@Test
	public void testPaging(){
		Criteria cri = new Criteria();
	
		// 테스트 값 사용 pageNum : 현재 페이지  , amount : 현재 페이지에 보여줄 리스트(페이지당 보여 줄 데이터) 
		cri.setPageNum(3);
		cri.setAmount(10);
	
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		list.forEach(board -> log.info(board));
		
	}
	
	@Test
	public void testSearch(){
	
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
	
	
//	@Test
	public void testInsertSelectKey(){
		
		BoardVO board = new BoardVO();
		board.setTitle("새로작성하는 글 selectKey");
		board.setContent("새로작성하는 내용 selectKey");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
//	@Test
	public void testRead(){
		
		BoardVO board = mapper.read(5L);
	
		log.info(board);
	}
	
//	@Test
	public void testDelete(){
		
		log.info("DELETE COUNT: " + mapper.delete(3L));
	}
	
//	@Test
	public void testUpdate(){
		
		BoardVO board = new BoardVO();
		
		board.setBno(5L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("updateUser00");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
		
	}
	
}
