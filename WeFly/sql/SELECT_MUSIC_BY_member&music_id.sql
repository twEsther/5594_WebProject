SELECT Email, Name,artist, lyricslanguage, song, yturl, duration
FROM wefly.members
left join recently_listen on Email=member_email 
left join selectmusic m on music_id=m.id
where Email='hebetien@yahoo.com.tw';

/* 這裡是查[最愛歌單]裡有什麼歌 where條件是該會員的email*/

/* 這裡說要寫在JAVA的哪?? 還是只是測試用 *//* lovelist 之後要改 加歌單的其他table */