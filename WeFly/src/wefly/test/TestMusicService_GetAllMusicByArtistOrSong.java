package wefly.test;

import wefly.entity.WeflyException;
import wefly.service.MusicService;

public class TestMusicService_GetAllMusicByArtistOrSong {

	public static void main(String[] args) {
		MusicService service = new MusicService();
		
		try {
			System.out.println(service.searchMusicByArtistOrSong("lauv"));
			System.out.println(service.searchMusicByArtistOrSong("far"));
		} catch (WeflyException e) {
			e.printStackTrace();
		}
	}
}


