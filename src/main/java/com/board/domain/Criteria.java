package com.board.domain;

import org.springframework.web.util.UriComponentsBuilder;

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
	
	//여러 파라미터들을 연결하여 URL형태로 만들어주는 설정
	//UriComponentsBuilder을 사용하면 CRUD 페이지에서 유지하는 파라미터값들을 일일이 유지해줄 필요가 없다. controller에서 호출해서쓰기만하면 됨 
	public String getListLink(){
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
				
	}
	
}
