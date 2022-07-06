package wefly.service;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import wefly.entity.Member;
import wefly.entity.Music;
import wefly.entity.WeflyException;

class MusicDAO {
	private static final String SELECT_ALL_MUSIC="SELECT id, IFNULL(artistzw, artisteng) AS artist, "
			+ "IFNULL(songzw, songeng) AS song, "
			+ "lyricslanguage, yturl, duration FROM music"
			+ " ORDER BY lyricslanguage";
	
	List<Music> selectAllMusic() throws WeflyException {
		List<Music> list = new ArrayList<>();
		
		try (
			Connection conn = RDBConnection.getConnection(); //1.2取得連線
			Statement stmt = conn.createStatement(); //3.建立指令

			//4.執行指令
			ResultSet rs = stmt.executeQuery(SELECT_ALL_MUSIC);
		
		){  //5.處理RS(這個專案暫時沒有需要處理RS的地方，但還是要查所以要加while)

			while (rs.next()) {
			Music music = new Music();
			music.setId(rs.getInt("id"));
			music.setArtist(rs.getString("artist"));
			//music.setArtisteng(rs.getString("artisteng"));
			music.setSong(rs.getString("song"));
			music.setLyricslanguage(rs.getString("lyricslanguage"));
			//music.setSongeng(rs.getString("songeng"));
			music.setYturl(rs.getString("yturl"));
			music.setDuration(LocalTime.parse(rs.getString("duration")));
			
			
			list.add(music);  
			//★★★ 正在建立音樂清單... [] 出現空集合
			//是因為沒有add進去清單，所以才會怪怪的！
			}
			
		} catch (SQLException e) {
			throw new WeflyException("查詢全部音樂失敗", e);
		}
		
		return list;
	}
	

	
	
	
	private static final String SELECT_MUSIC_BY_LANGUAGE = "SELECT id, artist, lyricslanguage, song, "
			+ "yturl, duration FROM selectmusic WHERE lyricslanguage=?";

	List<Music> selectMusicByLanguage(String lyricslanguage) throws WeflyException {
		List<Music> list = new ArrayList<>();
	
		try (
				Connection conn = RDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_MUSIC_BY_LANGUAGE); //3.準備指令	
		){
			pstmt.setString(1, lyricslanguage);
			
			try(
				ResultSet rs = pstmt.executeQuery();//4.執行指令
			){
				while (rs.next()) {
					
					Music music = new Music();
					
					music.setId(rs.getInt("id"));
					music.setArtist(rs.getString("artist"));
					music.setSong(rs.getString("song"));
					music.setLyricslanguage(rs.getString("lyricslanguage"));
					music.setYturl(rs.getString("yturl"));
					music.setDuration(LocalTime.parse(rs.getString("duration")));
					
					list.add(music); 
					}
				}
			
		} catch (SQLException e) {
			throw new WeflyException("查無此分類。", e);
		}
		return list;
	}
		
	
	
	
	
	
	
	private static final String SELECT_MUSIC_BY_ID = "SELECT id, artistzw, artisteng, songzw, "
			+ "lyricslanguage, songeng, yturl, duration FROM music WHERE id=?";

	Music selectMusicById(String id) throws WeflyException {
		Music music = null;
	
		try (
				Connection conn = RDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(SELECT_MUSIC_BY_ID); //3.準備指令	
		){
			pstmt.setString(1, id);
			
			try(
				ResultSet rs = pstmt.executeQuery();//4.執行指令
			){
				while (rs.next()) {
					
					music = new Music();
					
					music.setId(rs.getInt("id"));
					music.setArtistzw(rs.getString("artistzw"));
					music.setArtisteng(rs.getString("artisteng"));
					music.setSongzw(rs.getString("songzw"));
					music.setLyricslanguage(rs.getString("lyricslanguage"));
					music.setSongeng(rs.getString("songeng"));
					music.setYturl(rs.getString("yturl"));
					music.setDuration(LocalTime.parse(rs.getString("duration")));
					
					}
				}
			
		} catch (SQLException e) {
			throw new WeflyException("查無此歌手或歌曲。(沒有這個唉滴！)", e);
		}
		return music;
	}
	

	
	
	
	
	private static final String SELECT_MUSIC_BY_ARTISTORSONG= "SELECT id, artist, lyricslanguage, "
			+ "song, yturl, duration FROM selectmusic WHERE artist LIKE ? OR song LIKE ?";
	
	List<Music> selectMusicByArtistOrSong(String search) throws WeflyException {
		List<Music> list = new ArrayList<>();
		
		try (
				Connection connection = RDBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(SELECT_MUSIC_BY_ARTISTORSONG);
		){
			pstmt.setString(1, '%'+search+'%');
			pstmt.setString(2, '%'+search+'%');
			
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				while(rs.next()) {
					Music music = new Music();
					music.setId(rs.getInt("id"));
					music.setArtist(rs.getString("artist"));
					music.setLyricslanguage(rs.getString("lyricslanguage"));
					music.setSong(rs.getString("song"));
					music.setYturl(rs.getString("yturl"));
					music.setDuration(LocalTime.parse(rs.getString("duration")));
					list.add(music);
				}
			}
			
		} catch (SQLException e) {
			throw new WeflyException("查無此藝人！失敗！", e);
		}
		return list;
	}
	
	
	
	
	
	
	
	private static final String SELECT_LOVE_LIST_BY_MEMBER_ID = "SELECT id, Email, Name, artist, "
			+ " lyricslanguage, song, yturl, duration "
			+ "	FROM wefly.members "
			+ "	 join lovelist on Email=member_id "
			+ "	 join selectmusic m on music_id=m.id "
			//+ "	left join lovelist on Email=member_id "
			//+ "	left join selectmusic m on music_id=m.id "  (200910解惑)
			+ "	  where Email=?";		
	
	private static final String SELECT_RECENTLY_LISTEN_BY_MEMBER_ID = 
			"SELECT id, Email, Name, artist, "
			+ " lyricslanguage, song, yturl, duration "
			+ "	FROM wefly.members "
			+ "	join recently_listen on Email=member_id "
			+ "	join selectmusic m on music_id=m.id "
			+ "	  where Email=?";
	
	
	 List<Music> selectLoveListByMemberId(String... id) throws WeflyException {
		List<Music> list = new ArrayList<>();
		
		String sql="";
		if("按讚".equals(id[1])) {sql=SELECT_LOVE_LIST_BY_MEMBER_ID;}
		if("最近常聽".equals(id[1])) {sql=SELECT_RECENTLY_LISTEN_BY_MEMBER_ID;}
		
		
		try (
				Connection conn = RDBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql); //3.準備指令	
		){
			pstmt.setString(1, id[0]);
			
			try(
				ResultSet rs = pstmt.executeQuery();//4.執行指令
			){
				while (rs.next()) {
					Integer idObj= rs.getInt("id");
						if(idObj!=null && idObj>0) {
							Music music = new Music();
							
							music.setId(rs.getInt("id"));
							music.setArtist(rs.getString("artist"));
							music.setSong(rs.getString("song"));
							music.setLyricslanguage(rs.getString("lyricslanguage"));
							music.setYturl(rs.getString("yturl"));
							music.setDuration(rs.getString("duration")==null?null:LocalTime.parse(rs.getString("duration")));
							
							list.add(music);  //不要再忘記加這行了！！！
							//不然測試程式都跑不出來!!!!!! 會有時候對有時候錯...
						}
					}
				}
			
		} catch (SQLException e) {
			throw new WeflyException("歌單內沒有此首歌", e);
		}
		return list;
	}

	 
	 
	 /* 查其他清單的 */
	 private static final String SELECT_MUSIC_BY_MEMBER_ID_AND_CATEGORY =
			 "SELECT id, IFNULL(artistzw, artisteng) AS artist, "
			+ "IFNULL(songzw, songeng) AS song, yturl,"
			+ "member_id, music_id, category "
			+ "FROM lovelist "
			+ "JOIN  music on lovelist.music_id=music.id "
			+ "WHERE lovelist.member_id=?"
			+ "AND lovelist.category=?";
	
	 List<Music> selectPlayListByMemberId(String id, String category) throws WeflyException {
		List<Music> list = new ArrayList<>();
		
		if("情歌精選".equals(category) || "西洋派對".equals(category)) {
		
			try (
					Connection conn = RDBConnection.getConnection();
					PreparedStatement pstmt = conn.prepareStatement(SELECT_MUSIC_BY_MEMBER_ID_AND_CATEGORY);
				){
				pstmt.setString(1, id);
				pstmt.setString(2, category);
				
				try(
					ResultSet rs = pstmt.executeQuery();	
				){
					while (rs.next()) {
							 
						Music music = new Music();						
						music.setId(rs.getInt("id"));
						music.setArtist(rs.getString("artist"));
						music.setYturl(rs.getString("yturl"));
						music.setSong(rs.getString("song"));
						music.setMember_id(rs.getString("member_id"));
						music.setMusic_id(rs.getInt("music_id"));
						music.setCategory(rs.getString("category"));
						
						list.add(music);
							
					}
				}
				}	catch (SQLException e) {
						throw new WeflyException("此分類無歌曲。", e);
				}	
			 }
		return list;
	 
	 }
	 
	/* 這邊是加到按讚歌單的DAO */
	 //private static final String INSERT_LOVE_LIST="insert into lovelist (member_id, music_id, category) value(?, ?, '')";
	 private static final String INSERT_LOVE_LIST="INSERT INTO lovelist (member_id, music_id) value(?, ?)";
	 //private static final String INSERT_RECENTLY_LISTEN="INSERT INTO recently_listen (member_id, music_id) value(?, ?)";
	 
	 void insertMusicToLoveListById(String email, int id, String args) throws WeflyException
	 {
//============================================
//		 String sql = ""; //為什麼要設空字串? 參考產品DAO：可變動參數
//    	 
//		 //if ("按讚".equals(args) || "情歌精選".equals(args) || "西洋派對".equals(args)) {
//		if ("按讚".equals(args)) {
//			sql=INSERT_LOVE_LIST;
//		} 
//		if ("最近常聽".equals(args)) {
//			sql=INSERT_RECENTLY_LISTEN;
//		}  //分號要在大括號裡面
//★ ★★ Caused by: java.sql.SQLException: SQL String cannot be empty (MusicDAO.java:322) ★★★
//============================================	
//    	String sql = null;
//		if ("按讚".equals(args)) {
//			sql = INSERT_LOVE_LIST;
//		}
//		if ("最近常聽".equals(args)) {
//			sql = "insert into recently_listen (member_email, music_id) "
//					 + "value(?, ?)" ;
//		}
//============================================
		
		try (
			Connection conn = RDBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_LOVE_LIST); //3.準備指令	
		){
				pstmt.setString(1, email);
				pstmt.setInt(2, id);
				//pstmt.setString(3, args);
				
				//4.執行指令
				pstmt.executeUpdate();
			}catch (SQLIntegrityConstraintViolationException e) {
				if(e.getMessage().indexOf("PRIMARY")>=0) { 	//(200909-22:00)
					System.out.println("ignore");
				}
			} catch (SQLException e) {
				throw new WeflyException("查無此歌手或歌曲。(沒有這個唉滴！)", e);
			}
		return ;	
	 }	 
	 
	 
	 
	 
	 
	 /* 這邊是加到「最近常聽」歌單的DAO */
	 private static final String INSERT_RECENTLY_LISTEN="INSERT INTO recently_listen (member_id, music_id) value(?, ?)";
	 
	 void insertMusicToRecentlyListenById(String email, int id, String args) throws WeflyException
	 {

		try (
			Connection conn = RDBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(INSERT_RECENTLY_LISTEN); //3.準備指令	
		){
				pstmt.setString(1, email);
				pstmt.setInt(2, id);
				//pstmt.setString(3, args);
				
				//4.執行指令
				pstmt.executeUpdate();
			}catch (SQLIntegrityConstraintViolationException e) {
				if(e.getMessage().indexOf("PRIMARY")>=0) {
					System.out.println("ignore");
				}
			} catch (SQLException e) {
				throw new WeflyException("查無此歌手或歌曲。(沒有這個唉滴！)", e);
			}
		return ;	
	 }	 
			 
} //結尾大括號
