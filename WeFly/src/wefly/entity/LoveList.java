package wefly.entity;

import java.util.HashMap;
import java.util.Map;

public class LoveList {
	private Member member;
	private Map<Music, Integer> lovelist = new HashMap<>();
	
	
	public Member getmember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	Music music = new Music();
	
	//加歌單，先檢查歌單裡是否有重複歌曲
	public void add(Music music, int id) {
		if(music==null) {
			throw new IllegalArgumentException("加入按讚清單是時歌曲不得為null");
		}
//		Integer oldId =9 lovelist.get(music);
//		lovelist.put(music, music.getId());  老師寫的(200902)
		lovelist.put(music, id);
	}
	
	
	public Integer remove(Music music, Integer id) {
		return lovelist.remove(id);
	}
	
	
	@Override
	public String toString() {
		return getClass().getSimpleName() 
				+ "【" + "已登入會員： " + member 
				+ "\n按讚歌單： " + lovelist + "】";
	}
	
	
	
	
	
	
	
}//結尾大括號






















