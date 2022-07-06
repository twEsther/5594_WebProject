package wefly.test;

import wefly.entity.LoveList;
import wefly.entity.Member;
import wefly.entity.Music;
import wefly.entity.WeflyException;
import wefly.service.MemberService;
import wefly.service.MusicService;

public class TestLoveList {

	public static void main(String[] args) {
		MusicService service =  new MusicService();
		
		try {
			
			LoveList list = new LoveList();
			Music music1 = service.getMusic("5");
			list.add(music1, 5);

			System.out.println("******************");
			
			Music music2 = service.getMusic("1");
			list.add(music2, 1);
			//老師改有改這行：list.add(music2);
			System.out.println(list);
			
			
		} catch (WeflyException e) {
			e.printStackTrace();
		}
	
	}
}//結尾大括號


