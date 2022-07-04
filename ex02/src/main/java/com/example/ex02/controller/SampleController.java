package com.example.ex02.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex02.domain.vo.InfoDTO;
import com.example.ex02.domain.vo.StudentVO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex/*") // ex로 시작하는 모든것은 여기로 들어옴
@Log4j
public class SampleController {
								//경로					GET인지 PSOT인지
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic(HttpServletRequest req) {
		log.info("basic..." + req.getMethod());
	}
	
	@RequestMapping // ex/를 때렸을때 실행됨
	public void basic2() {
		log.info("basic2...");
	}
	
	@GetMapping("/basicOnlyGet") // get방식으로 받아온것
	public void basic3() {
		log.info("basic3...only get");
	}
	
	
	
	//void 로 보내면 리턴값이 없기 때문에
	//내가 요청한 경로에 ViewResolver에서 .jsp와 앞에 prefix를 붙여줌
	//따라서 반드시 ex안에 ex01과 ex02 페이지를 만들어 놔야 함
	
	//외부에서 전달된 파라미터를 매개변수 필드명과 자동으로 매핑한다.
	@GetMapping("/ex01") // 매개변수에 넣으면 자동으로 들어감(String name, int age)
	public void ex01(InfoDTO infoDTO) { // 객체에 담아서 받는게 일반화 되있음, 알아서 매핑이 되어 들어감
		log.info("ex01..." + infoDTO.getName() + ", " + infoDTO.getAge());
	}
	
	//외부에서 전달된 파라미터의 이름과 매개변수가 다를경우 @RequestParam을 사용하여 어디로 전달받을 지 알려준다.
	@GetMapping("ex02")
	//파라미터명이 data1로 들어왔다면 name에 담을거야, data2로 들어왔다면 age에 담을거야
	public void ex02(@RequestParam("data1") String name, @RequestParam("data2") int age) {
		log.info("ex02..." + name + ", " + age);
	}
	
	
	
	//리턴값이 있기 때문에 리턴값에 ViewResolver에서 .jsp와 앞에 prefix를 붙여줌
	@GetMapping("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas) {
		log.info("datas : " + datas);
		return "ex03";
	}
	
	
	
	//만약 매개변수가 객체라면, 해당 클래스 타입의 앞글자만 소문자로 변경된 값이 화면에서 사용할 key값이다
	// 예) 매개변수의 타입이 InfoDTO 라면, 화면에서 사용 시 key값은 infoDTO가 된다.
	// 만약 key값을 수정하거나 매개변수가 많아진다면, 직접 requestScope에 담아서 전달해야 함
	// 이때 request객체를 직접 불러오지 않고, Model이라는 데이터 전달자를 사용하게 된다.
	// 하지만 화면쪽에 전달할 데이터가 여러개가 아니라면 @ModelAttribute()를 사용하여 화면에 전달해준다.
	// @ModelAttribute("화면에서 사용할 key")
	@GetMapping("/ex04")
	// InfoDTO에서 앞에만 소문자로 바뀐 infoDTO가 자동으로 key값이 됨(InfoDTO infoDTO)
	// key값을 다른걸로 쓰고 싶다면 @ModelAttribute()사용, 뒤에있는 애를 화면쪽에 어떤 key값으로 설정할건지 쓰는것
	public String ex04(@ModelAttribute("dto") InfoDTO infoDTO) {
		log.info("--------------------------------------");
		log.info("ex04...");
		log.info(infoDTO.toString());
		log.info("--------------------------------------");
		return "ex04";
	}
	
	
	
	@GetMapping("/ex05")
	// gender는 InfoDTO에 없는 파라미터
	// 2개일 경우, InfoDTO는 default값이 있음, String은 key는 정해줘야 함
	public void ex05(InfoDTO infoDTO, @ModelAttribute("gender") String gender) {
		log.info("ex05...");
		log.info(infoDTO.toString());
		log.info("gender : " + gender);
	}
	
	
	//Model객체는 파라미터로 request객체를 받는다
	//따라서 여러개의 데이터를 화면에 전달할때 
	// addAttribute(key, value)을 사용
	//화면에서는 model에 설정한 key로 value를 사용할 수 있다.
	@GetMapping("/ex06")
	public String ex06(InfoDTO infoDTO, String gender, Model model) {
		log.info("ex06...");
		log.info(infoDTO.toString());
		log.info("gender : " + gender);
		
		model.addAttribute("dto", infoDTO);
		model.addAttribute("gender", gender); // 직접 key value설정하는 걸로 씀
		
		return "ex/ex06";
	}
	
	
	
	
	@GetMapping("/ex07")
	//외부에서 학생의 번호, 국어, 영어, 수학점수를 모델 객체로 전달받는다.
	//파라미터명과 매개변수에 선언된 모델객체의 필드명이 동일하면 자동으로 매핑된다.
	//리턴시 알맞는 페이지로 이동이 되고, 모델객체는 직접 key를 지정하지 않아도
	//화면쪽에서는 앞글자만 소문자로 바뀐 값으로 해당 필드를 접근할 수 있다.
	public String ex07(StudentVO studentVO) {
		log.info("ex07...");
		log.info(studentVO.toString());
		return "ex/ex07";
	}
}
