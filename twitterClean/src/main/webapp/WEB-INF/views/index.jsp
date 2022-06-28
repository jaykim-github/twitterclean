<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<head>
<meta charset="EUC-KR">
<title></title>
<script type="text/javascript">

$(document).ready(function(){
	$("#write").click(function(){
		$.ajax({
		    url: "/twit",
		    type: "POST",
		   // cache:false,
		  //  async:true, 
		    data:$("#writefrm").serialize(),
		    dataType:"json",
		    success: function(result) {
		    	console.log(result);
		    	console.log(result.value);
				if(result.value == 1){
					console.log("twit success");
					//alert("로그인 되었습니다.")
				}else {
					alert("서버를 확인해주세요.");
					return false;
				} 
			},error:function(request,status,error){             
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			}

	 	});
	});
	
});
/*
function twit(){
	$.ajax({
	    url: "/twit",
	    type: "POST",
	   // cache:false,
	  //  async:true, 
	    data:$("#writefrm").serialize(),
	    dataType:"json",
	    success: function(result) {
	    	console.log(result);
	    	console.log(result.value);
			if(result.value == 1){
				console.log("twit success");
				//alert("로그인 되었습니다.")
			}else {
				alert("서버를 확인해주세요.");
				return false;
			} 
		},error:function(request,status,error){             
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		}

 	});
}
*/
</script>
<title>입력페이지</title>
</head>
<body>
<div id="wrap" style="width:215px; padding : 50px;">
	<br>
	<br>
	<h3>키워드 입력</h3>
	<br>
	<form id ="writefrm" style="border:10px">
	 	키워드1 : <input type="text" name="keyword1" id ="keyword1"/>
		<br>
		<br>
		키워드2  : <input type="text" name="keyword2" id ="keyword2"/>
		<br>
		<br>
		키워드3  : <input type="text" name="keyword3" id ="keyword3"/>
		<br>
		<br>
		키워드4  : <input type="text" name="keyword4" id ="keyword4"/>
		<br>
		<br>
		키워드5  : <input type="text" name="keyword5" id ="keyword5"/>
		<br>
		<br>
		키워드6  : <input type="text" name="keyword6" id ="keyword6"/>
		<br>
		<br>
		키워드7  : <input type="text" name="keyword7" id ="keyword7"/>
		<br>
		<br>
		키워드8  : <input type="text" name="keyword8" id ="keyword8"/>
		<br>
		<br>
		키워드9  : <input type="text" name="keyword9" id ="keyword9"/>
		<br>
		<br>
		키워드10  : <input type="text" name="keyword10" id ="keyword10"/>
	<br>
	<br>
		대상  : <input type="text" name="person" id ="person"/>
	<br>
   </form>
	<div style="float:right">
   <button type="button" value="write" id="write">트윗하기</button> 
	</div>
   </div>
</body>
</html>