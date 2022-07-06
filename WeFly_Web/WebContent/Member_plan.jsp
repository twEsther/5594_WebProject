<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>We Fly - 成為專案會員</title>
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

.pay_WholeBolck {
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
	margin-top: 1em;
	margin-right: auto;
	margin-bottom: 3em;
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

.memberPay {
	margin-top: 30px;
	cursor: default;
	display: inline-block;
	font-size: 14px;
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
	padding: 18px 70px;
	float: right;
}

.pay_logo {
	width: 140px;
	height: 46px;
	margin-top: 35px;
}

.subname { /* 要補上外框的陰影 */
	height: 90px;
	background-color: white;
	box-shadow: rgb(189, 189, 189) 0px 0px 0px 1px inset;
	border-radius: 4px;
	padding-top: 12px;
	width: 100%;
	border-style: none;
	font-size: 18px;
}


</style>
<body>
	<div class="pay_WholeBolck">
			<div class="header_LogoContainer">			
				<a class="head_Logo" href="<%= request.getContextPath() %>/index.jsp">
				<img class="pay_logo" src="<%= request.getContextPath() %>/images/WeFly_Logo_yellowWord.png"/>
				</a>
				<h2 class="sentence">一個月只需要30元即可盡情聆聽音樂</h2>
			</div>
		
			<span class="form_DividerLine"></span>
		
			<div class="payBox">
				<div class="subname">
					<span>划算的價格，尊榮的享受</span><br>
					<span>暢聽音樂，不受廣告干擾</span><br>
					<span>專屬播放清單，隨選即播</span>
				</div>
				<form class="member" action="" method="POST">
						<div class="pay_div"></div> <!--  由這邊的submit button送到form表單指名的action位置，由後端接，也就是RegisterServlet -->
						<input class="memberPay" name="memberPay" type="submit" value="點此購買會員">
				</form>
			</div>
		
	</div>
</body>
</html>