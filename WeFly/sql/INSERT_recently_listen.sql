/*INSERT INTO `wefly`.`recently_listen` (`member_email`, `music_id`) value('hebetien@yahoo.com.tw', '1');*/

/*SELECT m.id, IFNULL(artistzw, artisteng) AS artist,
			 IFNULL(songzw, songeng) AS song, lyricslanguage, yturl, duration FROM wefly.lovelist 
			 JOIN music m ON music_id = m.id;
             
			 WHERE member_Email ='hebetien@yahoo.com.tw' 	*/
             
             
			SELECT id,Email, Name,artist, lyricslanguage, song, yturl, duration  
			FROM wefly.members  
			left join recently_listen on Email=member_id
			left join selectmusic m on music_id=m.id  	
			where Email='hebetien@yahoo.com.tw';
            
            SELECT id,Email, Name,artist, lyricslanguage, song, yturl, duration  
			FROM wefly.members  
			left join lovelist on Email=member_id
			left join selectmusic m on music_id=m.id  	
			where Email='hebetien@yahoo.com.tw';