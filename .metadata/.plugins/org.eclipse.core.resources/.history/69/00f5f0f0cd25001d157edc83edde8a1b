package com.example.board.domain.vo;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
public class Criteria {
	private int pageNum;
	private int amount;
	private String type;
	private String keyword;
	
	public Criteria() {
		//만약에 아무것도 전달을 안하면 한 페이지당 10개씩 현재 1페이지를 보여줘라 
		this(1, 10);
	}
	
	

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String getParams() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("").queryParam("pageNum", this.pageNum);
		return builder.toUriString();
	}



	public Criteria(int pageNum, int amount, String type, String keyword) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.type = type;
		this.keyword = keyword;
	}
	
	
	public String[] getTypes() {
//		"ABC".split("") -> 3칸 배열([A][B][C])
		return type == null? new String[] {} : type.split("");
	}
}
