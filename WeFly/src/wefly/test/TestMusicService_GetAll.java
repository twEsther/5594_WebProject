package wefly.test;

import wefly.entity.WeflyException;
import wefly.service.MusicService;

public class TestMusicService_GetAll {

	public static void main(String[] args) {
		MusicService service = new MusicService();
		
		try {
			System.out.println(service.getAllMusic());
		} catch (WeflyException e) {
			e.printStackTrace();
		}
	}
}
