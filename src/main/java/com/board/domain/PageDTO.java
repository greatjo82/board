package com.board.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
		
	private int startPage, endPage;
	private boolean prev, next;

	private int total;		//전채 데이터 수, 
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;		// 데이터의 총 개수 
	
		
		this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage = this.endPage - 9;		// 초기세팅에 끝페이지를 10페이지로 한다면 시작은 1페이지 부터 시작해야 하므로 10-9 1페이지 부터 시작
		
		//데이터를 10개씩(amount)씩 쪼개진 페이지로 구분
		//ex. 전체데이터(total)가 12개라면 12*1.0/10 -> 12.0/10 -> 1.2 -> 2페이지가 되므로 12개의 데이터는 2개의 페이지로 표현한다. 
		int realEnd = (int)(Math.ceil((total*1.0) / cri.getAmount()));	
		
		if(realEnd < this.endPage){		//현재 페이지가 끝페이지보다 작다
			this.endPage = realEnd;		//현재페이지가 마지막페이지가 되어야 함
		}
		
		this.prev = this.startPage > 1; //이전 페이지는 1페이지 보다 이상이어야 표시 가능(true)
		this.next = this.endPage < realEnd;	//현재 페이지는 정해놓은 끝페이지 보다 커야 다음 표시 가능(true)
		
		
	}
	
	
	
	
}
