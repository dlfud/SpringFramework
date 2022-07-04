package com.example.ex02.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// 잘 안됬는데... 이유는 서버 module에 등록한 /ex02때문에... /로만 바꾸니 괜춘해 졌음
@Controller
public class CustomError {
	@GetMapping("/error")
	public String goErrorPage(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status != null) {
			int statusCode = Integer.valueOf(status.toString());
			if(statusCode == HttpStatus.NOT_FOUND.value()) {
				return "error/404";
			}
		}
		return "error/500";
	}
}
