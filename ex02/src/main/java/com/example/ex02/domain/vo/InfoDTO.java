package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // Spring에 등록
@Data // getter, setter 자동만들어줌
public class InfoDTO {
	private String name;
	private int age;
}
