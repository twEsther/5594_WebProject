package wefly.service;

import java.util.List;

import wefly.entity.Music;
import wefly.entity.WeflyException;

public class MusicService {
	//這裡有幾支程式沒有測試~~~
	private MusicDAO dao = new MusicDAO();
	public List<Music> getAllMusic() throws WeflyException {
		return dao.selectAllMusic();
	}

	public Music getMusic(String id) throws WeflyException {
		return dao.selectMusicById(id);
	}

	
	public List<Music> getAllMusicByLanguage(String lyricslanguage) throws WeflyException {
		return dao.selectMusicByLanguage(lyricslanguage);
	}
	
	
	public List<Music> searchMusicByArtistOrSong(String search) throws WeflyException {
		return dao.selectMusicByArtistOrSong(search);
	}
	
	
//	public List<Music> getMember(String id) throws WeflyException {
//		return dao.selectLoveListByMemberId(id);
//	}
//	怕跟別支打架！先註解
	
	
	
	//查歌單(按讚、最近常聽)
	public List<Music> getMemberLoveList(String id, String songList) throws WeflyException {
		return dao.selectLoveListByMemberId(id, songList);
	}	

	
	//查歌單(情歌精選、西洋派對)
	public List<Music> getMemberPlayList(String id, String songList) throws WeflyException {
		return dao.selectPlayListByMemberId(id, songList);
	}
	
	
	//加到「按讚」
	public void insertLoveListMusic(String email, int id, String songList) throws WeflyException {
		dao.insertMusicToLoveListById(email, id, songList);
		return ;
	}
	
	
//	//加到「最近常聽」
//	public void insertRecentlyListentMusic(String email, int id, String songList) throws WeflyException {
//		dao.insertMusicToRecentlyListenById(email, id, songList);
//		return ;
//	}
	
	
	
	
//	public List<Music> searchProductsByName(String search)
//			throws WeflyException {
//		return dao.selectMusicByName(search);
//	
//	}
	
}
