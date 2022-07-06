package wefly.test;

import java.util.List;

import wefly.entity.Music;
import wefly.entity.WeflyException;
import wefly.service.MusicService;

public class TestMusicService_SelectLoveListByMemberIdver3 {

	public static void main(String[] args) {
		MusicService service = new MusicService();
		try {
			//if ("加到歌單".equals()) {}
			//List<Music>lm= service.getMemberLoveList("k870020@yahoo.com.tw","按讚"); //成功
			List<Music>lm= service.getMemberPlayList("ericstar@gmail.com","西洋派對"); //失敗>成功
		
			System.out.println(lm);
		} catch (WeflyException e) {
			e.printStackTrace();
		}
	}
}

//hebetien@yahoo.com.tw
//ericstar@gmail.com
//k870020@yahoo.com.tw
//kimteayeon@yahoo.com.tw

//資料庫名字取太爛了，對不起大家QQ