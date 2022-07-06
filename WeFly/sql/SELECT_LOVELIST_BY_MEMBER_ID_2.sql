SELECT id, Email, Name, artist,
	lyricslanguage, song, yturl, duration
	FROM wefly.members
	join lovelist on Email=member_id
	join selectmusic m on music_id=m.id
	where Email= 'k870020@yahoo.com.tw';