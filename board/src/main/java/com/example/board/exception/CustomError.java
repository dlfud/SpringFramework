package com.example.board.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


// 잘 안됬는데... 이유는 서버 module에 등록한 /ex02때문에... /로만 바꾸니 괜춘해 졌음
@Controller
public class CustomError {
	@GetMapping("/error")
	public String goErrorPage() {
		return "error/error";
	}
}
