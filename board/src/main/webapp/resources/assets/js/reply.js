/**
 * javascript 모듈화
 * 
 * 함수들을 하나의 모듈처럼 묶음으로 구성하는 것을 의미한다.
 * 화면 내에서 Javascript를 처리하다 보면 이벤트 처리, DOM, Ajax처리등
 * 복잡하게 섞여서 유지보수가 힘들다. 따라서 Javascript코드를 여러 부품으로 분리하여 조립하는 형식으로 설계한다. 
 *
 * JS -> {key : value}
 * Json -> {"key" : value} : key값에 무조건 ""이 있어야 함
 *
 * JSON.stringify -> 자바스크립트데이터 전달 시 전체를 제이슨 형식으로 만들어줌
 * JSON.path -> 제이슨을 자바스크립트로 만들어줌 
 */
 
 console.log("Reply Module...");
 
 //함수 선언과 동시에 사용
 //리턴값이 자바스크립트 객체
 let replyService = (function(){
 	
 	//추가하기
 	//reply : 자바스크립트 오브젝트가 전달됨
 	function add(reply, callback){
 		console.log("add reply...");
 		$.ajax({
 			//해당 url로 넘어가서 실행
 			url: "/replies/new",
 			type: "post",
 			data: JSON.stringify(reply),
 			contentType: "application/json; charset=utf-8",
 			//성공하면 result에 리턴값 담겨있음
 			success: function(result){
 				if(callback){
 					callback(result);
 				}
 			}
 		})
 	}
 	
 	//			key : value -> value를 함수로 줌
 	return {add: add}
 })();