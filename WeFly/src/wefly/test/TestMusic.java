package wefly.test;

import wefly.entity.Music;

public class TestMusic {

	public static void main(String[] args) {
		Music music = new Music();
		
		System.out.println(music.getId());
		System.out.println(music.getArtistzw());
		System.out.println(music.getArtisteng());
		System.out.println(music.getSongzw());
		System.out.println(music.getLyricslanguage());
		System.out.println(music.getSongeng());
		System.out.println(music.getYturl());
		System.out.println(music.getDuration());
		
	
		music.setId(1);
		music.setArtisteng("Billie Eilish");
		music.setLyricslanguage("英文");
		music.setSongeng("bad guy");
		music.setYturl("https://www.youtube.com/embed/DyDfgMOUjCI");
		
		System.out.println(music);
	}

} //結尾大括號
