<%@page import="java.util.List"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" type="text/css" href="/Volumes/Transcend/WeFly_Web/WebContent/wefly.css"> -->
<title>註冊 - WeFly</title>


<script src="https://code.jquery.com/jquery-3.5.1.js" 
		integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" 
		crossorigin="anonymous">
</script>

<script>
	function refreshCaptcha (){
		//alert("refreshCaptcha");
		var catpchaImg = document.getElementById("captchaImg");
		catpchaImg.src = "images/register_captcha.jpeg?refresh="+new Date();	
	}
	
	<% if("POST".equalsIgnoreCase(request.getMethod())) { %>
	
	$(()=>{
			//alert("fieldRepopulate");	/*	前面是抓id的值、後面是抓name */
			$("#email").val("<%= request.getParameter("email") %>");
			$("#password").val("<%= request.getParameter("password") %>");
			$("#nickname").val("<%= request.getParameter("nickname") %>");
			$("#birthday").val("<%= request.getParameter("birthday") %>");
			$("#<%= request.getParameter("gender")%>").prop("checked",true); 
	});
	<% } %>
</script>

<style>
body, main{
	margin: 0px;
	font-family: "微軟正黑體", "Microsoft JhengHei", Arial, "文泉驛正黑", "WenQuanYi Zen Hei", "儷黑 Pro", "LiHei Pro",
	"標楷體", DFKai-SB, sans-serif;
}

.header_LogoContainer{
	width:350px;
	height: 160px;
}

h2 {
	font-size: 20px;
}

.sentence {
	margin-top: 20px;
	line-height: 36px;
}

input {
	box-shadow: rgb(189, 189, 189) 0px 0px 0px 1px inset;
	margin-top: 1px;
	margin-right: 0px;
	margin-left: 0px;
	border-radius: 5px;
	padding-bottom: 10px;
	padding-top: 10px;
	width: 100%;
	border-style: none;
}
/* 
	不確定是否有作用的屬性：
    border-width: initial;
    border-color: initial;
    border-image: initial;
*/

.facebook_ButtonContainer {
	margin-bottom: 18px;
	width: 100%;
}

.register_div {
	margin-top: 60px;
	width: 100%;
}

.facebook_Button, .register_Button {
	cursor: default;
	display: inline-block;
	font-size: 11px;
	letter-spacing: 3px;
	line-height: 1;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
	touch-action: manipulation;
	transition-duration: 33ms;
	transition-property: background-color, border-color, color, box-shadow,
		filter, transform;
	background-color: rgb(58, 88, 151);
	color: rgb(255, 255, 255);
	border-radius: 500px;
	padding: 13px 102px;
}

.register_Button {
	background-color: rgb(29, 185, 84);
	padding: 13px 160px;
}

.form_DividerLine {
	display: table;
	font-size: 16px;
	line-height: 24px;
	letter-spacing: 2px;
	color: rgb(117, 117, 117);
	position: relative;
	text-align: center;
	width: 80%;
	margin: 0px auto 1em;
	margin-top: 0px;
	margin-right: auto;
	margin-bottom: 1em;
	margin-left: auto;
}

.form_DividerLine::before, .form_DividerLine::after {
	content: "";
	display: table-cell;
	position: relative;
	top: 0.8em;
	width: 42%;
	border-top: 1px solid rgb(189, 189, 189);
}

.register_TitleEmail {
	font-size: 16px;
	margin: 0px;
	padding-bottom: 15px;
}

.register_WholeBlock {
	margin-right: auto;
	margin-left: auto;
	padding-left: 24px;
	padding-right: 24px;
	padding-bottom: 130px;
	max-width: 350px;
	font-family: circular-spotify-ui, Helvetica Neue, Helvetica, Arial,
		sans-serif, "微軟正黑體", "Microsoft JhengHei", Arial, "文泉驛正黑", "WenQuanYi Zen Hei", "儷黑 Pro", "LiHei Pro",
	"標楷體", DFKai-SB, sans-serif;
	
	text-align: center;
	
}

.group1_Email, .group2_Email, .group3_Password, .group4_NickName,
	.group5_Birthday, .group6_Gender, .group7_RegisterCaptcha {
	padding-bottom: 20px;
}

.label1_Email, .label2_EmailConfirm, .label3_Password, .label4_NickName,
	.label5_Birthday, .label6_Gender, .label7_Captcha {
	color: rgb(24, 24, 24);
	font-size: 14px;
	text-align: left;
}

#birthday {
    display: flex;
    flex-wrap: wrap;
}

.gender {
	align: left;
}

.captchaImg {
	float: left;
	width: 50%;
}

#captchaImg{
	float: right;
	cursor: pointer;
	margin-top: 6px;
}

.register_logo {
	width: 140px;
	height: 46px;
	margin-top: 35px;
}

</style>
</head>

<body>
	<main>
	<%
	List<String> errors = (List<String>)request.getAttribute("errors");
	%>
	<div class="errors"><% out.print(errors!=null?errors:""); %></div>
	
	
		<div class="register_WholeBlock">
			<div class="header_LogoContainer">
				<a class="head_Logo" href="<%= request.getContextPath() %>/index.jsp">
				<img class="register_logo" src="<%= request.getContextPath() %>/images/WeFly_Logo_yellowWord.png"/>
				</a>
				<h2 class="sentence">免費註冊即可開始收聽</h2>
			</div>

			<div class="facebook_ButtonContainer">
				<a href="" class="facebook_Button">以Facebook帳號註冊</a>
			</div>

			<span class="form_DividerLine">或</span>


			<form action="register.do" method="POST" class="register_Data">
			
				<h2 class="register_TitleEmail">以電子信箱註冊</h2>



				<div class="group1_Email">
					<div class="label1_Email">
						<label class="label1_Email">你的電子信箱是什麼？</label>
					</div>
					<input id="email" name="email" type="email" placeholder="請輸入你的電子信箱"
						required>
				</div>



				<div class="group2_Email">
					<div class="label2_EmailConfirm">
						<label class="label2_EmailConfirm">請確認你的電子信箱是否正確</label>
					</div>
					<input id="emailConfirm" name="emailcheck" type="email"
						placeholder="再次輸入你的電子信箱" required>
				</div>



				<div class="group3_Password">
					<div class="label3_Password">
						<label class="label3_Password">建立密碼</label>
					</div>
					<input id="password" pattern=".{8,}" name="password"
						type="password" placeholder="不限英數字，至少8字元" required>
				</div>
				<!-- 這個怪怪的？ autocomplete="new-password"  -->



				<div class="group4_NickName">
					<div class="label4_NickName">
						<label class="label4_NickName">請輸入姓名或暱稱</label>
					</div>
					<input id="nickname" name="nickname" type="text"
						placeholder="請輸入個人檔案的姓名或暱稱">
				</div>



				<div class="group5_Birthday">
					<div class="label5_Birthday">
						<label class="label5_Birthday">你的生日是？</label>
					</div>
					<input id="birthday" name="birthday" type="date" required>
				</div>



				<div class="group6_Gender" role="radiogroup">
					<div class="label6_Gender">
						<label class="label6_Gender">你的性別是？</label>
					</div>
					<input class="gender" name="gender" type="radio" value="M"
						required>男性
					<input class="gender" name="gender"
						type="radio" value="F" required>女性
				</div>



				<div class="group7_RegisterCaptcha">
					<div class="label7_Captcha">
						<label class="label7_Captcha">我不是機器人</label>
					</div>
					<div>
						<input class="captchaImg" type="text" name="captcha" required placeholder="請依據右圖輸入驗證碼">
						<img id="captchaImg" src="images/register_captcha.jpeg"
							onclick="refreshCaptcha()" alt="驗證碼" title="點選即可更新驗證碼">
					</div>
				</div>
				
				<div class="register_div"></div>
				<!--  由這邊的submit button送到form表單指名的action位置，由後端接，也就是RegisterServlet -->
					<input class="register_Button" name="register" type="submit" value="註冊">
				

				
			</form>
		</div>
	</main>
</body>