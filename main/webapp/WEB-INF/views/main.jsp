<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>
<body>
<h1>Main</h1>
<hr>
<div>
1. 목록보기&nbsp;&nbsp;<button id="btn">실행</button>
	<ol id="demo">
		
	</ol>
</div>
<hr>
<div>
2. 개별조회
mno 입력 : <input type="text" name="mno" id="txt_mno">
<button id="btn2">조회</button>
<div id="demo2"></div>
</div>
<hr>
<div>
3. 멤버 등록<br>
<form id="frm">
이름 : <input type="text" name="name" ><br>
id : <input type="text" name="id"><br>
pw : <input type="text" name="pw"><br>
<input type="button" id="btn3" value="등록"	>
</form>
<div id="demo3"></div>
</div>
<hr>
<div>
4. 멤버 수정<br>

<form id="frm2">
mno : <input type="text" name="mno" ><br>
pw : <input type="text" name="pw2"><br>
<input type="button" id="btn4" value="수정"	>
</form>
<div id="demo4"></div>
</div>
<hr>
<div>
5. 멤버 삭제<br>
mno 입력 : <input type="text" name="mno" id="txt_mno2">
<button id="btn5">삭제</button>
<div id="demo5"></div>
</div>
<script>
	//목록보기(GET)
	$("#btn").click(function(){
		$.ajax({
			url: "http://localhost:8081/api/members",
			type: "GET",
			/* success: function(data){
				console.log(data);
				
			}, */
			success: function(data){
				alert(data);
				let list = JSON.parse(data);
				console.log(list);
				for(let i = 0; i < list.length; i++){
					$("#demo").append("<li>" + list[i].name + "</li>");
				}
			},
			error: function(error){
				alert("error : " + error);
			}
		});
	});
	//개별조회(GET)
	$("#btn2").click(function(){
		$.ajax({
			url: "http://localhost:8081/api/member/" + $('#txt_mno').val(),
			type: "GET",
			success: function(data){
				console.log(data);
				alert("good");
				$("#demo2").text(data.mno + ", " + data.name + ", " + data.id + ", " + data.pw);
			},
			error: function(error){
				alert("error : " + error);
			}
		});
	});
	//등록(POST)
	$("#btn3").click(function(){
		//const formData = new FormData(frm);
		//const sendData = $("#frm").serialize();
		let sendData = {
				name: $("input[name='name']").val(),
				id: $("input[name='id']").val(),
				pw: $("input[name='pw']").val()
		}
		alert(sendData);
		$.ajax({
			url: "http://localhost:8081/api/member",
			type: "POST",
			data: JSON.stringify(sendData),
			contentType: "application/json",
			success: function(data){
				$("#demo3").html(data);
			},
			error: function(error){
				$("#demo3").html(error);
			}
		});
	});
	//수정(PUT)
	$("#btn4").click(function(){
		
		let sendData = {
				mno: $("input[name='mno']").val(),
				pw: $("input[name='pw2']").val()
		}
		alert(sendData.mno);
		$.ajax({
			url: "http://localhost:8081/api/member",
			type: "PUT",
			data: JSON.stringify(sendData),
			contentType: "application/json",
			success: function(data){
				$("#demo4").html(data);
			},
			error: function(error){
				$("#demo4").html(error);
			}
		});
	});
	//5. 삭제
	$("#btn5").click(function(){
		$.ajax({
			url: "http://localhost:8081/api/member/" + $('#txt_mno2').val(),
			type: "DELETE",
			success: function(data){
				alert(data);
				$("#demo5").html(data);
			}
		});
	});
</script>
</body>
</html>