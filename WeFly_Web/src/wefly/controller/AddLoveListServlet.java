package wefly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wefly.entity.LoveList;
import wefly.entity.Member;
import wefly.entity.Music;
import wefly.entity.WeflyException;
import wefly.service.MemberService;
import wefly.service.MusicService;

/**
 * Servlet implementation class AddLoveListServlet
 */
@WebServlet("/member/add_list.do")
public class AddLoveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddLoveListServlet() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		//1.取得request的Form Data (抓name的值) 並檢查
		List<String> errors = new ArrayList<>();
		
		Member m = (Member)session.getAttribute("member");
		String musicId = (String)request.getParameter("musicId");
		
		//String songList = (String)request.getParameter("songList");
		String love = (String)request.getParameter("love");
		
		String redirectURL=request.getContextPath()+"/member/";

		//String recently = (String)request.getParameter(request.getContextPath()+"/member/recently_listen.jsp"); //兜字串 for 跳轉網頁
		String recently = (String)request.getParameter(redirectURL + "最近常聽");
		String loveSong = (String)request.getParameter(redirectURL + "情歌精選");
		String west = (String)request.getParameter(redirectURL + "西洋派對");

		
		//2.執行商業邏輯
		//因為同一個form裡面有要傳兩個資料，所以寫在同一個Servlet要判斷
		//MemberService service = new MemberService(); //要先去查會員
		//String redirectURL=request.getContextPath()+"/member/music_list.jsp";
		//String redirectURL=request.getContextPath()+"/member/";
		//String redirectURL=request.getContextPath();
		try {
				MusicService service = new MusicService();

//		如果不是null表示有這個會員，就去session查
			service.insertLoveListMusic(m.getEmail(), Integer.parseInt(musicId), love);
			//跳轉的網頁網址要寫在裡面，才知道要跳去哪裡。
			if("按讚".equals(love)) {
				
				redirectURL=request.getContextPath()+"music_love.jsp";
			}
				
//			if("最近常聽".equals(recently)) {
//				service.insertRecentlyListentMusic(m.getEmail(), Integer.parseInt(musicId), love);
//				//redirectURL+="music_list.jsp?love=最近常聽";
//				redirectURL+="/member/recently_listen.jsp";
//			}
			
			if("情歌精選".equals(loveSong)) {	
				//redirectURL+="music_list.jsp?love=情歌精選";
				redirectURL+="/member/love_song.jsp";
			}
			
			if("'西洋派對".equals(west)) {
				//redirectURL+="music_list.jsp?love='西洋派對";
				redirectURL+="/member/west_party.jsp";
			}
			

			//按讚or加歌單，都是在if區塊裡判斷完之後 出來再return
			//response.sendRedirect(redirectURL);
			response.sendRedirect(redirectURL+"music_list.jsp");
			return;
			
		} catch (WeflyException e) {
			this.log("加入清單失敗", e);
		} catch (Exception ex) {
			this.log("加入清單發生非預期的錯！", ex);
			errors.add("加入清單發生非預期的錯" + ex);
		}
		System.out.println(errors);	
		response.sendRedirect(request.getContextPath());		
		//response.sendRedirect(redirectURL);
	}

} //這裡是類別class結尾的大括號
