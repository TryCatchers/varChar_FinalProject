<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="try"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Var茶 | 회원가입</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- 파비콘 태그 -->
    <try:favicon/>
    <!-- 링크 부분 헤더 -->
	<try:link/>     
    <style type="text/css">
    	span {
    		color: red;
    	}
    </style>
  </head>
  <body class="goto-here">
    <!-- 헤더 부분 태그 -->
    <try:nav/>

	<!-- 페이지 제목 div -->
    <div class="hero-wrap hero-bread" style="background-image: url('images/bg_1.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
          	<p class="breadcrumbs"><span class="mr-2"><a href="main.do">Home</a></span> <span>Sign Up</span></p>
            <h1 class="mb-0 bread">회원가입</h1>
          </div>
        </div>
      </div>
    </div>
	<!-- 페이지 제목 div 끝 -->

	<!-- 회원가입 섹션 -->
	<section class="ftco-section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 ftco-animate">
          	<!-- 회원가입 폼 태그 -->
			<form action="signup.do" method="post" class="billing-form" onsubmit="return test();">
	          	<h3 class="mb-4 billing-heading" style="padding-bottom: 25px; border-bottom: 1px solid #e1e1e1">회원가입</h3>
	          	<div class="row align-items-end">
	          		<div class="col-md-6" style="margin-top: 30px;">
	                <div class="form-group">
	                	<label for="firstname" >아이디<span>*</span></label>
	                  <input type="text" class="form-control" placeholder="아이디를 입력하세요." required>
	                </div>
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                	<label for="lastname">이름 <span>*</span></label>
	                  <input type="text" class="form-control" placeholder="이름을 입력하세요." required>
	                </div>
                </div>
                <div class="w-100"></div>
                <div class="col-md-6">
	                <div class="form-group">
	                	<label for="firstname" >비밀번호<span>*</span></label>
	                  <input type="password" id="pw" class="form-control" placeholder="새 비밀번호를 입력하세요.(최소 8글자 이상)" required style="width: 210%;">
	                </div>
	              </div>
                <div class="w-100"></div>
	          		<div class="col-md-6">
	                <div class="form-group">
	                	<label for="firstname" >비밀번호 확인<span>*</span></label>
	                  <input type="password" id="pw2" class="form-control" placeholder="비밀번호를 한번 더 입력하세요."required style="width: 210%;">
	                </div>
	              </div>
                <div class="w-100"></div>
				<div class="col-md-6">
	                <div class="form-group">
	                	<label for="lastname">연락처</label>
	                  	<input type="text" id="memberPhone" class="form-control" placeholder="하이픈(-), 공백없이 기입해주세요. ex) 00012345678" style="width: 210%;">
	                </div>
                </div>
                <div class="w-100"></div>
				<div class="col-md-6">
	                <div class="form-group">
	                	<label for="lastname">이메일</label>
	                  <input type="text" class="form-control" value="${ mdata.memberEmail }" placeholder="@포함 이메일 형식에 맞춰서 기입해주세요. ex) aaa@xxx.com" style="width: 210%;">
	                </div>
                </div>
                <div class="w-100"></div>
                <div class="col-md-6">
	                <div class="form-group" style="margin-bottom: 150px;">
	                	<label for="lastname">주소 </label>
	                  <!-- 주소 API 적용 -->
	                  <try:addressAPI/>
	                </div>
                </div>
	            </div>
				<div style="margin:auto; text-align:center;">
					<p><input type="submit" class="btn btn-primary py-3 px-4" value="  가입하기  "style="vertical-align:middle; display:inline-block;"></p>
				</div>
	          </form>
          	  <!-- 회원가입 폼 태그 끝 -->
			</div>
          </div> <!-- .col-md-8 -->
        </div>
    </section>
	<!-- 회원가입 섹션 끝-->


	<!-- 커스텀 태그 적용하기 -->
	<try:footer/>	
	<!-- 채팅 API -->
	<try:chatAPI/>
  <!-- loader -->
    <try:loader/>
  <script>
		$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
	</script>
	
	 <script type="text/javascript">
	 	// 전화번호, 이메일 유효성 검사
    	function checkPh() {
 	  		var ph = document.getElementById('memberPhone').value;
 	  	    var mail = document.getElementById('memberEmail').value;
 	        const test= "@";    		
       		if((ph.length == 11 && mail == '') || (ph == '' && mail == '') || (ph == '' && mail.indexOf(test) !== -1) || (ph.length == 11 && mail.indexOf(test) !== -1)){
       			return true;
       		}
       		else if(ph.length !== 11){
   			alert('전화번호는 하이픈(-) 공백없이 11자리 입력해주세요.');
       		return false;
       		}
       		else if(mail.indexOf(test) == -1){
       		alert('이메일은 @포함 정확하게 입력하세요');
            return false;
       		}            			
      	}
    </script>
    
    <script type="text/javascript">

    	// 비밀번호, 이메일 정규식 유효성 검사
		function test() { // 회원가입 버튼에서 실행될 함수 (버튼을 submit으로 설정 X)
    		var p1 = document.getElementById('pw').value; 
    		// MemberVO의 패스워드 멤버변수 memberPw와 동일한 name을 갖춰서 보내야할 인풋값
    		var p2 = document.getElementById('pw2').value; 
    		// 단순 2차 비번 확인용
    		var ph = document.getElementById('memberPhone').value; // 연락처
    		var mail = document.getElementById('memberEmail').value; // 이메일
    		const test = "@"; // 이메일
    
    		if (p1 !== p2) { // 비번이 일치하지 않을 경우
        		alert("비밀번호가 일치하지 않아서 회원가입을 완료할 수 없습니다.");
    		}
    		else if (p1.length < 8) { // 비번 일치여부와는 관계없이 8글자 미만일경우
        		alert("비밀번호는 8글자 이상으로 설정해야 합니다.");
    		}
    		else {
        		// 연락처와 이메일 유효성 검사
        		const phoneRegex = /^\d{11}$/; // 11자리의 숫자만 허용 (하이픈 없음)
        		const emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 정규표현식을 통한 이메일 유효성 검사
        		const isPhoneValid = ph.length === 0 || ph.match(phoneRegex);
       			const isEmailValid = mail.length === 0 || mail.match(emailRegex);

        		if (isPhoneValid && isEmailValid) {
            		// 연락처와 이메일 모두 유효성 검사를 통과한 경우
           		 	return true;
        		}
        		else if (!isPhoneValid && !isEmailValid) {
            		// 둘 다 입력되지 않은 경우 유효성 검사를 제외하고 회원가입 진행
            		return true;
        		}
        		else {
            		// 유효성 검사를 통과하지 못한 경우
            		if (!isPhoneValid) {
                		alert('연락처를 11자리 숫자로 입력해주세요.');
            		}
            		if (!isEmailValid) {
                		alert('이메일을 정확하게 입력하세요.');
            		}
        		}
    		}
    		return false;
		}

	</script>
    
  </body>
</html>