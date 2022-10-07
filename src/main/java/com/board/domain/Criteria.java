package com.board.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	private int pageNum; 	// 페이지 수
	private int amount;		// 페이지당 보여줄 데이터

	public Criteria() {
		this(1,10);		//초기값 : 한 페이지 당 10개의 데이터 리스트를 보여준다.
	}
	
	public Criteria(int pageNum, int amount){
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
