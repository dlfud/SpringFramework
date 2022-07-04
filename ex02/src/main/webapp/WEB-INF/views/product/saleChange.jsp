<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>          
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세일 항목 변경</title>
</head>
<body>
	<form action="/ex02/change" method="post">
		<!-- 보이지는 않지만 파라미터를 넘기기 위해서 -->
		<input type="hidden" name="productName"/>
		<input type="hidden" name="productPrice"/>
		<input type="hidden" name="discountRate"/>
		<table border="1" style="margin:0 auto">
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="1"/>
				</td>
				<td>오징어 땅콩</td>
				<td>3500</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="2"/>
				</td>
				<td>초코 우유</td>
				<td>1500</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="3"/>
				</td>
				<td>벌꿀 피자</td>
				<td>2800</td>
			</tr>
			<tr>
				<td>
					<input type="radio" name="productNumber" value="4"/>
				</td>
				<td>샌드위치</td>
				<td>4500</td>
			</tr>
		</table>
		<br>
		<div style="text-align:center">
			<!-- data함수에서 rate key값을 전달해 주면 value가 ""안에 있는 값이 됨 -->
			<button class="rate" type="button" data-rate="10">10%</button>
			<button class="rate" type="button" data-rate="30">30%</button>
			<button class="rate" type="button" data-rate="60">60%</button>
			<button class="rate" type="button" data-rate="90">90%</button>
			<button style="display:block; margin:10px auto; width:188px">적용</button>
		</div>
	</form>
</body>
<!-- jqury쓸려고 가져옴-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	let $temp;
	$("button.rate").click(function(e){
		if($temp){ // 이전에 바꾼게 없다면, undefined는 false
			$temp.css("color", "black");
		}
		$temp = $(this);
		$(this).css("color", "red");
		// input 태그의 value값을 this에 data함수에 rate key가 가르키는 value값을 넣음
		$("input[name='discountRate']").val($(this).data("rate"));
	});
	
	$("input[name='productNumber']").click(function(e) {
		//this는 input태그, 거기서 가장 가까운 tr태그(부모)를 찾아서 그 자식들을 변수에 넣음 
		const tdTags = $(this).closest("tr").children();
		// input태그의 value값을 tdTags의 1, 2번방 값으로 채움
		$("input[name='productName']").val($(tdTags[1]).text());
		$("input[name='productPrice']").val($(tdTags[2]).text());
	});
</script>
</html>