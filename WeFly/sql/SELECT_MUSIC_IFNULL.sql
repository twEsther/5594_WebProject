SELECT music.*, IFNULL(artistzw, artisteng) AS artist FROM wefly.lovelist 
JOIN music ON music_id = id
WHERE member_id ='ericstar@gmail.com';


/*

SELECT m.id, IFNULL(artistzw, artisteng) AS artist,  IFNULL(songzw, songeng) AS song, lyricslanguage, yturl, duration FROM wefly.lovelist 
JOIN music m ON music_id = id
WHERE member_id ='ericstar@gmail.com';

*/