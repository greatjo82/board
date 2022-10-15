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

	private String type;	//검색 타입(글쓴이(W)/제목(T)/내용(C)) 
	private String keyword; //검색어
	
	public Criteria() {
		this(1,10);		//초기값 : 한 페이지 당 10개의 데이터 리스트를 보여준다.
	}
	
	public Criteria(int pageNum, int amount){
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr(){
		
		//변수 type에 값이 없으면 새로운 문자열 object 생성, 값이 있다(T/W/C)면 공백("") 기준으로 각 쪼갬(ex. TC -> T, C  TW -> T,W , TCW -> T,C,W) 
		return type == null? new String[]{} : type.split("");
	}
	
}
