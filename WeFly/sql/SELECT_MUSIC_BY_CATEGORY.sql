SELECT id, IFNULL(artistzw, artisteng) AS artist, 
IFNULL(songzw, songeng) AS song,
member_id, music_id, category
FROM lovelist
JOIN  music on lovelist.music_id=music.id  /* 這個category要建FOREIGN KEY嗎*/
WHERE lovelist.member_id= 'k870020@yahoo.com.tw'
AND lovelist.category='情歌精選'; /*category也可以給空字串去查喔~~~*/


SELECT id, Email, Name, artist, 
lyricslanguage, song, yturl, duration 
FROM wefly.members 
join recently_listen on Email=member_id 
join selectmusic m on music_id=m.id 
where Email=? ;

/* 下面這個查不到 */
SELECT id, artist, lyricslanguage, song, yturl, duration
FROM `wefly`.`selectmusic`
left join `members` on Email
left join lovelist on category
where Email= 'ericstar@gmail.com' ;