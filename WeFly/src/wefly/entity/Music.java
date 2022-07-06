package wefly.entity;

import java.time.LocalTime;

public class Music {
	
	private int id;
	private String artistzw;
	private String artisteng;
	private String songzw;
	private String lyricslanguage;
	private String songeng;
	private String yturl;
	private LocalTime duration;
	
	private String artist;
	private String song;
	
	
	private String member_id;
	private int music_id;
	private String category;
	
	
	
	public Music() {
		super();
		System.out.println("正在建立音樂清單...");
	}
	
	
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getMusic_id() {
		return music_id;
	}
	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}



	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getArtistzw() {
		return artistzw;
	}
	public void setArtistzw(String artistzw) {
		this.artistzw = artistzw;
	}
	public String getArtisteng() {
		return artisteng;
	}
	public void setArtisteng(String artisteng) {
		this.artisteng = artisteng;
	}
	public String getSongzw() {
		return songzw;
	}
	public void setSongzw(String songzw) {
		this.songzw = songzw;
	}
	public String getLyricslanguage() {
		return lyricslanguage;
	}
	public void setLyricslanguage(String lyricslanguage) {
		this.lyricslanguage = lyricslanguage;
	}
	public String getSongeng() {
		return songeng;
	}
	public void setSongeng(String songeng) {
		this.songeng = songeng;
	}
	public String getYturl() {
		return yturl;
	}
	public void setYturl(String yturl) {
		this.yturl = yturl;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime string) {
		this.duration = string;
	}
	
	
	
	
	
	
	
	public Music(int id, String artisteng, String songeng) {
		this();
		this.id = id;
		this.artisteng = artisteng;
		this.songeng = songeng;
	}

	
	@Override
	public String toString() {
		return this.getClass().getName() +
				" \n【音樂 id = " + id
			  + ", \n 歌手 = " + artist + "　或是　" + artistzw + "　或是　" + artisteng
			  + ", \n 歌名 = " + song + "　或是　" + songzw + "　或是　" + songeng
			  + ", \n 語言 = " + lyricslanguage  
			  + ", \n 分類清單 = " + category + "】";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	

	
} //結尾大括號
