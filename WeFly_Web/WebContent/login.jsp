<%@page import="java.util.List"%>
<%@page import="wefly.entity.Member"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	Member member = (Member)session.getAttribute("member");
	if(member!=null) {
		response.sendRedirect(request.getContextPath());
		return;
	}
%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" type="text/css" href="/Volumes/Transcend/WeFly_Web/WebContent/wefly.css"> -->
<title>登入 - WeFly</title>
</head>
<style>
body {
	margin: 0px;
	font-family: "微軟正黑體", "Microsoft JhengHei", Arial, "文泉驛正黑",
		"WenQuanYi Zen Hei", "儷黑 Pro", "LiHei Pro", "標楷體", DFKai-SB,
		sans-serif;
}

.header_LogoContainer{
	width: 350px;
	height: 150px;
}

.login_WholeBolck {
	margin-right: auto;
	margin-left: auto;
	padding-left: 24px;
	padding-right: 24px;
	padding-bottom: 130px;
	max-width: 350px;
	font-family: circular-spotify-ui, Helvetica Neue, Helvetica, Arial,
		sans-serif, "微軟正黑體", "Microsoft JhengHei", Arial, "文泉驛正黑",
		"WenQuanYi Zen Hei", "儷黑 Pro", "LiHei Pro", "標楷體", DFKai-SB,
		sans-serif;
	text-align: center;
}

h2 {
	font-size: 20px;
}

.sentence {
	margin-top: 25px;
	line-height: 36px;
}

.facebook_ButtonContainer, .login_div {
	margin-bottom: 18px;
	width: 100%;
}

.facebook_Button {
	margin-top: 16px;
	cursor: default;
	display: inline-block;
	font-size: 11px;
	font-weight: 700px;
	letter-spacing: 2px;
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
/* 不確定是否有作用的屬性：
    user-select: none;
    vertical-align: middle;
    transform: translate3d(0px, 0px, 0px);
    border-width: 0px;
    border-style: initial;
    border-color: initial;
    border-image: initial;     
*/
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

input {
	box-shadow: rgb(189, 189, 189) 0px 0px 0px 1px inset;
	margin-top: 5px;
	margin-right: 0px;
	margin-left: 0px;
	margin-bottom: 15px;
	border-radius: 4px;
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
.submit_Button {
	margin-top: 30px;
	cursor: default;
	display: inline-block;
	font-size: 11px;
	font-weight: 700px;
	letter-spacing: 2px;
	line-height: 1;
	text-align: center;
	text-decoration: none;
	text-transform: uppercase;
	touch-action: manipulation;
	transition-duration: 33ms;
	transition-property: background-color, border-color, color, box-shadow,
		filter, transform;
	background-color: #1db954;
	color: rgb(255, 255, 255);
	border-radius: 500px;
	padding: 13px 70px;
	float: right;
}

.rememberMe {
	float: left;
	width: inherit;
	position: relative;
	margin-top: 13px;
}

.register_logo {
	width: 140px;
	height: 46px;
	margin-top: 35px;
}

.remember {
	margin: 0px;
	font-size: 14px;
}

</style>
<body>

<% //讀取cookies: email, keepEmail
			Cookie[] cookies = request.getCookies(); //Java比較特別，一次要讀一整包		
			String email = "";
			String keepEmail = "";
			if(cookies!=null){
				for(int i=0; i<cookies.length; i++){
					Cookie theCookie = cookies[i];
					if(theCookie.getName().equals("email")) {
						email = theCookie.getValue();
					}else if(theCookie.getName().equals("keepEmail")){
						keepEmail = theCookie.getValue();						
					}
				}
			}
				
			List<String> errors = (List<String>)request.getAttribute("errors");
			
			%>
			<%= errors!=null?errors:"" %>

	<div class="login_WholeBolck">

		<div class="header_LogoContainer">			
			<a class="head_Logo" href="<%= request.getContextPath() %>/index.jsp">
			<img class="register_logo" src="<%= request.getContextPath() %>/images/WeFly_Logo_yellowWord.png"/>
			</a>
			<h2 class="sentence">若要繼續，請登入。</h2>
		</div>


		<div class="facebook_ButtonContainer">
			<a class="facebook_Button">使用Facebook帳號繼續</a>
		</div>

		<span class="form_DividerLine">或</span>

		<div class="loginBox">

			<form class="loginData" action="login.do" method="POST">
					<div>
						 <input id="email" name="email" type="email"
						 	value="<%="POST".equalsIgnoreCase(request.getMethod())?request.getParameter("email"):email%>"
							placeholder="請輸入電子信箱地址" required>
					</div>

					<div>
						 <input id="password" pattern=".{8,}"
							name="password" type="password" placeholder="請輸入密碼" required>
					</div>


					<div class="login_div"></div> <!--  由這邊的submit button送到form表單指名的action位置，由後端接，也就是RegisterServlet -->
					<input class="submit_Button" name="register" type="submit" value="登入">


					<div>
						<label class="rememberMe"><input class="remember"
							type="checkbox" name="keepEmail" <%=keepEmail%> >記住我</label>
					</div>
			</form>
		</div>
	</div>
</body>
</html>