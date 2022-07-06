<%@page import="wefly.service.MusicService"%>
<%@page import="wefly.entity.Music"%>
<%@page import="wefly.entity.Member"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" type="text/css" href="/Volumes/Transcend/WeFly_Web/WebContent/wefly.css"> -->
<title>We Fly - 搜尋</title>
</head>
<style>
body {
	margin: 0px;
	height: 100%;
	font-family: "微軟正黑體", "Microsoft JhengHei", Arial, "文泉驛正黑",
		"WenQuanYi Zen Hei", "儷黑 Pro", "LiHei Pro", "標楷體", DFKai-SB, sans-serif;
	color: white;
	font-size: 16px;
}

h4 {
	text-align: justify; 
	margin-top: 38px;
	margin-bottom: 15px;
	margin-left: 5px;
	padding-left: 30px;
}

.root_topBar {
	background-color: #697b97;
	width: 100%;
	height: 10%;
	min-height: 100px;
	margin-top: 12px ;
    margin-right: 150px;
    display: flex;
    float: right;
	/*position: fixed;
	top: 0px;
	left: 0px;*/
}

.login {
    color: #eea02a;
    background-color: white;
  /*  position: fixed;
	top: 8px;
	left: 510px; /*322px*/
}

.register {
	color: #fff;
	background-color: transparent;
	/*position: fixed;
	top: 8px;
	left: 360px; 220px*/
}

.register, .login {
	font-family: "微軟正黑體"; font-size: 14px; font-weight: 700;
	text-transform: uppercase; text-align: center;
    border: 2px solid transparent; border-radius: 500px;
    transition: all 33ms cubic-bezier(.3,0,0,1);
    line-height: 18px;
    padding: 8px 34px; margin: 17px 0px;
    letter-spacing: 1.76px;
    will-change: transform;
    white-space: nowrap;
    display: inline-block;
    cursor: pointer; 
    float: right;
}

.searchplace {
	font-family: "微軟正黑體"; font-size: 14px; font-weight: 700;
	text-transform: uppercase; text-align: center;
    border: 2px solid transparent; border-radius: 500px;
    transition: all 33ms cubic-bezier(.3,0,0,1);
    line-height: 18px;
    padding: 1px 15px;
    padding-left: 15px;
    margin: 17px 0px;
    letter-spacing: 1.76px;
    will-change: transform;
    white-space: nowrap;
    display: inline-block;
    cursor: pointer; 
    float: right;
    background-color: white;
}

.searchplaceword {
	font-family: "微軟正黑體";
	font-weight: 700;
	text-align: left;
	padding: 7px 10px;
    border: 2px solid transparent;
    background-color: white;
    line-height: 18px;
    letter-spacing: 1.76px;
}


.searchbutton {
	font-family: "微軟正黑體"; font-size: 14px; font-weight: 700;
	text-transform: uppercase; text-align: center;
    border: 2px solid transparent; border-radius: 200px;
    line-height: 18px;
    padding: 5px 8px;
 	margin: 17px 0px;
    letter-spacing: 1.76px;
    display: inline-block;
    cursor: pointer; 
    background-color: white;
    float: right;
}

.searchbuttonword {
	font-family: "微軟正黑體"; font-size: 14px; font-weight: 700;
	text-align: center;
    border: 2px solid transparent; border-radius: 200px;
    transition: all 33ms cubic-bezier(.3,0,0,1);
    line-height: 18px;
    padding: 7px 10px;
    letter-spacing: 1.76px;
    will-change: transform;
    white-space: nowrap;
    display: inline-block;
    cursor: pointer; 
    background-color: white;
    color: lightgray;
}

.searchbar {
	margin-top: 12px;
	float: left;
	/* margin-left: 150px; 要殺掉*/
	margin-left: 5%;
}


.home, .search, .musiclib,
.leftBar_createlist, .leftBar_heartlist {
/*  display: block; */ 
	clear: both;
	border: transparent;
	background-color: transparent;
	cursor: pointer;
}

.create, .heart {
	cursor: pointer;
}

.leftBar_createlist, .leftBar_heartlist {
	font-family: "微軟正黑體";
	padding-left: 30px;
}

.root_leftBar {
	background-color: #697b97;
	height: 90%;
	float: left;
	padding-top: 21px;
	position: fixed;
	top: 0px;
	left: 0px;
	min-width: 180px;
}

.leftBar_logo {
	background: #697b97;
	width: 124px;
	height: 40px;
	float: left;
    flex-shrink: 0;
    flex-direction: row;
    justify-content: space-between;
    padding-left: 35px;
    padding-bottom: 20px;
}

.left_logo {
	width: 124px;
	height: 40px;
}

.leftBar_listbox {
    padding-inline-start: 20px;
    padding-left: 30px;
    list-style: none;
    width: 200px;
    margin-right: 20px;
}

.homeimg, .searchimg, .musiclibimg,
.createimg, .heartimg {
	width: 25px;
	height: 25px;
	vertical-align: middle;
}

.create, .heart {
	border: transparent;
	background-color: transparent;
}

.root_mainView {
	background-color: #d9dbde;
	width: 89.7%;
	height: 80%;
	float: right;
    margin: auto;
    margin-right: 0;
    position: fixed;
	left: 200px;
	top: 10%;
	/* min-width: 1200px; */
}

.root_nowPlaying {
	background-color: #858da3;
	width: 100%;
	height: 10%;
    margin: auto;
    margin-right: 0;
    float: right;
    position: fixed;
    bottom: 0px;
    left: 0px;
}

span {
	font-size: 16px;
	color: #fff;
	font-weight: normal;
	margin-left: 5px;
	font-family: "微軟正黑體";
}

.leftBar_divider {
	border-style: solid;
	margin: 8px 20px;
    background-color: #282828;
    border: none;
    height: 1px;
    width: 155px;
}

.all_lists, .mainView {
	display: flex;
	list-style: none;
	margin-top: 40px;
	width: 100%;
}

.all_lists {
	margin-top: 60px;
}

.list1, .heartlist, .rankTaiwan, .rankGlobal {
	width: 140px;
	height: 160px;
	cursor: pointer;
	border: 2px solid transparent;
	border-radius: 8px;
	margin-right: 25px;
}

.listimg, .heartlistimg, .rankTaiwanimg, .rankGlobalimg {
	width: 110px;
	height: 100px;
	border: transparent;
	border: 2px solid transparent;
}

.listspan{
	font-family: "微軟正黑體";
	color: #666666;
	font-size: 14px;
}

#audioPlayer {
	margin: 20px;
	width: 500px;
	position: relative;
	left: 40%;
	right: 40%;
}

.hello, .logout {
	font-family: "微軟正黑體"; font-size: 14px; font-weight: 700;
	text-transform: uppercase; text-align: center;
    border: 2px solid transparent; border-radius: 500px;
    transition: all 33ms cubic-bezier(.3,0,0,1);
    line-height: 18px;
    padding: 8px 34px;
    margin: 17px 0px;
    letter-spacing: 1.76px;
    will-change: transform;
    white-space: nowrap;
    display: inline-block;
    cursor: pointer; 
}

.logout { color: #eea02a; }

#play {
	/*padding: 3% 0px 0px 28px;*/
}

#pause {
	/*padding: 3% 0px 0px 5px;*/
}

#controls {
	border: 2px solid transparent; 
	border-radius: 500px;
	background-color: lightgray;
	width: 250px;
	height: 40px;
	display: inline;
	float: left;
	margin: 1% 1%;
	position: fixed;
	left: 180px;
	padding-top: 10px;
	padding-bottom: 0px;
	padding-left: 28px;
}

.CurrentTime {
	float: right;
	margin: 2% 15px 0px;
}




</style>

<%
	Member member = (Member)session.getAttribute("member");

	String musicId = request.getParameter("musicId");
	Music music = null;
	if(musicId!=null){
		MusicService service = new MusicService();
		music = service.getMusic(musicId);
	}
%>

<body>		
		<div class="root_leftBar" style="background-color:#646462;">

		<div class="leftBar_logo" style="background-color:#646462;">
			<a href="<%= request.getContextPath() %>/index.jsp">
			<img class="left_logo" src="<%= request.getContextPath() %>/images/WeFly_Logo_yellowWord.png"/>
			</a>
		</div>
		

		<ul class="leftBar_listbox">
			<li>
				<a href='<%= request.getContextPath() %>/index.jsp'><button class="home">
				<img class="homeimg" src="<%= request.getContextPath() %>/images/home64.png"/>
				<span>首頁</span>
				</button></a>
			</li>	
			<li>
				<a href="<%= request.getContextPath() %>/music_search.jsp"><button class="search">
				<img class="searchimg" src="<%= request.getContextPath() %>/images/search.png" />	
				<span>搜尋</span>
				</button></a>
			</li>
			<li>
				<button class="musiclib">
				<img style="vertical-align: -6px;" class="musiclibimg" src="<%= request.getContextPath() %>/images/musiclib.png" />	
				<span>你的音樂庫</span>
				</button>
			</li>		
		</ul>
		
		
		<div style="width: 200px;" class="leftBar_playlist">
			
		<h4 class="leftBar_listheader">播放清單</h4>
			<div class="leftBar_listcontent">	
				<div class="leftBar_createlist">
					<button type="button" class="create">
						<img class="createimg" src="<%= request.getContextPath() %>/images/add.png"/>
						<span class="createspan">建立播放清單</span>
					</button>
				</div>
					
				<div class="leftBar_heartlist">
					<a href="<%= request.getContextPath() %>/member/music_love.jsp"><button type="button" class="heart">
						<img class="heartimg" src="<%= request.getContextPath() %>/images/heart1.png"/>
						<span class="heartspan">已按讚的歌曲</span>
					</button></a>
				</div>
				
				<hr class="leftBar_divider">
				
			</div>
		</div>		
	</div>

	<div style="float:right; width:90%; background-color: #646462;">
	
		<form class="searchbar" action="<%= request.getContextPath() %>/member/music_list.jsp">
			<button class="searchbutton" type="submit"><!-- <input class="searchbuttonword">  -->
				<img style="width:25px; height:25px;" class="searchimgonbar" src="<%= request.getContextPath() %>/images/search.png" /></button>
			<div class="searchplace"><input class="searchplaceword" style="width:12em" type="search" name="search" placeholder="搜尋藝人或歌曲"></div>
		</form>
	
		<div class="root_topBar" style="float:right;width:8em; background-color: #646462;">
			<% if(member==null) { %>
					<a href='register.jsp'><button class="register" type="button">註冊</button></a>
					<a href='<%= request.getContextPath() %>/login.jsp'><button class="login" type="button">登入</button></a>			
			<%}else{ %>
					<sub class="hello"><%= member!=null?member.getName():"" %> 你好</sub>
					<a href='<%= request.getContextPath()%>/logout.do'><button class="logout" type="button">登出</button></a>
			<% } %>
		</div>
		
		<div class="root_mainView" style="background-color:#d8d8d7;">
			<section>
				<div>
					<ul class="mainView">
						<li class="mylist1_heart">
							<a href="<%= request.getContextPath() %>/member/music_love.jsp"><button type="button" class="heartlist">
								<img class="heartlistimg" src="<%= request.getContextPath() %>/images/liked-songs-300.png"/>
								<span class="listspan">已按讚的歌曲</span>
							</button></a>
						</li>	
	 					
						<li class="rankT">
							<button type="button" class="rankTaiwan">
								<img class="rankTaiwanimg" src="<%= request.getContextPath() %>/images/rankTaiwan-300.png"/>
								<span class="listspan">臺灣前20名</span>
							</button>
						</li>					
						
						<li class="rankG">
							<button type="button" class="rankGlobal">
								<img class="rankGlobalimg" src="<%= request.getContextPath() %>/images/rankGlobal-300.png"/>
								<span class="listspan">全球前20名</span>
							</button>
						</li>
					</ul>
					

	
					<ul class="all_lists">
						<li class="mylist">
							<a href="<%= request.getContextPath() %>/member/music_list.jsp"><button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/allmusic-300.png"/>
								<span class="listspan">所有歌曲</span>
							</button></a>
						</li>
									
						<li class="mylist">
							<form class="chinese" action="<%= request.getContextPath() %>/member/music_list.jsp">
							<a id="chinese" class="rank" href="<%= request.getContextPath() %>/member/music_list.jsp?lyricslanguage=中文">
							<button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/chinese-300.png"/>
								<span class="listspan">華語榜</span>
							</button></a></form>
						</li>
						
						<li class="mylist">
							<a id="west" class="rank" href="<%= request.getContextPath() %>/member/music_list.jsp?lyricslanguage=英文">
							<button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/WEST-300.png"/>
								<span class="listspan">西洋榜</span>
							</button></a>
						</li>	
						
						<li class="mylist">
							<a id="est" class="rank" href="<%= request.getContextPath() %>/member/music_list.jsp?lyricslanguage=日韓">
							<button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/JPKR-300.png"/>
								<span class="listspan">日韓榜</span>
							</button></a>
						</li>										
					</ul>
					
					
					<ul class="all_lists">
						<li class="mylist">
							<a id="est" class="rank" href="<%= request.getContextPath() %>/member/music_list.jsp?songList=加到歌單">
							<button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/list1.png"/>
								<span class="listspan">最近常聽</span>
							</button></a>
						</li>
									
						<li class="mylist">
							<button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/list2.png"/>
								<span class="listspan">情歌精選</span>
							</button>
						</li>
						
						<li class="mylist">
							<button type="button" class="list1">
								<img class="listimg" src="<%= request.getContextPath() %>/images/list3.png"/>
								<span class="listspan">西洋派對</span>
							</button>
						</li>	
										
					</ul>
	
					
				</div>
			</section>
		</div>
	</div>
	

	<div class="root_nowPlaying" style="background-color:#9f9f9e;">
    	<div id="controls">
    	  <input type="image" id="play" value="Play" width="28px" height="28px" src="<%= request.getContextPath() %>/images/play.png">
    	  <input type="image" id="pause" value="Pause" width="28px" height="28px" src="<%= request.getContextPath() %>/images/pause.png">
		  <span class="CurrentTime" >00:00 / 00:00</span>
	<!--  player.getDuration():Number
		  player.getCurrentTime():Number -->
    	</div>   
	</div>


</body>
</html>