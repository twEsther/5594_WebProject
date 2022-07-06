package wefly.test;

import wefly.entity.WeflyException;
import wefly.service.MusicService;

public class TestMusicService_GetAllMusicById {

	public static void main(String[] args) {
		MusicService service = new MusicService();
		
		try {
			System.out.println(service.getMusic("9"));
		} catch (WeflyException e) {
			e.printStackTrace();
		}
	}
}
