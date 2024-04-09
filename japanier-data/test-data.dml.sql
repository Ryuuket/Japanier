delete from t_users_roles;
delete from t_users_exercises;
delete from t_video_lessons_exercises;
delete from t_video_lessons;
delete from t_exercises;
delete from t_users;

	
insert into t_users (email, "password") values 
	('julien.fontanier@gmail.com', '$2a$12$Ya5Ah0.3BSj809H14XuUtu1gsQup2u3bLCWzk1fSfMf765WuzWWla'),
	('axel.galvier@hotmail.fr', '$2a$12$p0mND/dx4jLtE0aRIT6bnuPb.HtmhTfVOJQKdHuN/jbAnJZAoTzkO'),
    ('jf@gm.com', '$2a$12$Ttgja0AjK.KWDi5iKh2e2euZ1iwczY1xEzlVkNVrU1a88b/rpoGM6');

insert into t_video_lessons (id_sub_category, title, link, video_description) values
	((select id from t_sub_categories s where s.sub_category_code = 'PREGE'), 'Présentation des hiragana', 'https://youtu.be/_PCJnq_-oT8', 
	'Dans ce cours, nous allons voir ce que sont les hiragana, comment et pourquoi les utiliser.'),
	((select id from t_sub_categories s where s.sub_category_code = '4RUKA'), 'Les accents', 'https://youtu.be/LlyGGMlEydM', 
	'Dans ce cours, nous allons voir ce que sont les accents et comment ils changent la prononciation.'),
	((select id from t_sub_categories s where s.sub_category_code = 'KATAE'), 'Les règles de katakanisation', 'https://youtu.be/dxIGeBFBNkM', 
	'Dans ce cours, nous allons apprendre à transformer les mots étrangers pour les inclure à la langue japonaise : c''est la katakanisation.'),
	((select id from t_sub_categories s where s.sub_category_code = 'KANJI'), 'Les deux lectures des kanji', 'https://youtu.be/YD4RT6JYJ98', 
	'Dans ce cours, nous allons voir pourquoi les kanji ont plusieurs lectures.'),
	((select id from t_sub_categories s where s.sub_category_code = 'FOPHR'), 'La particule の', 'https://youtu.be/LDevjw4zit0', 
	'Dans ce cours, nous allons voir comment et dans quelles situations utiliser la particule の.'),
	((select id from t_sub_categories s where s.sub_category_code = 'SPEJP'), 'Les pronoms personnels japonais', 'https://youtu.be/2oa3zrHyopo', 
	'Dans ce cours, nous allons apprendre à utiliser les nombreux pronoms personnels utilisés au Japon.');

insert into t_exercises (exercise_number, link) values
	(1, 'https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbmVjWjJYNUZTZ3JjTVdPdjlFbzZCNFI1R2pCZ3xBQ3Jtc0trcS1NRlIzZVVweUtGdkc2cW81Yk5VQWhDeFFJLVlEV2pPSEN3eDQ2OGI4MEJGUVlYNHdCWlpkZHl1N2JIUVR3UWFCQUtJTHFGN1JrdFgwTFhiQW1TVTZfYVVVb1l3Y0NrSkRHVkt4VDBWSWRkWHcyUQ&q=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1Rou8sgyccfiZT7-_Exyo_9P7jJe-dIhYNetn2X8sF_o%2Fedit%3Fusp%3Dsharing&v=_PCJnq_-oT8'), 
	(2, 'https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbFA3SnFHWUJDaEdDdGRFLURlaEJ4SGVaMnl4d3xBQ3Jtc0ttcDdYU3R0enZETTlLcmJjNFVGR1lfWHI3M20zUU1MQmZlajFiX2F2Mk5lYWwxNUdUdkJNOVN5T2FwMXJacmU5NHVtUlhGM1h6YnhvOUdjUGtaaVVnVXBkcGNWU21yQTB1V3hNQ1hqdGdTbVRvTDZpRQ&q=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1oJVjXGC8rXps8CC2oEDFZ3g9ol4zDYD1WUrpGW-FS3Y%2Fedit%3Fusp%3Dsharing&v=LlyGGMlEydM'), 
	(3, 'https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa0V5WDZIbzl1VlBwSUxjRWQ5YkNEZzVxazJMQXxBQ3Jtc0tsak9teUNacFFTWl83anNiamlfMWg5a1dGSTZGTXdiR2NycWVDZHd2WkZIS2JldzJpSHNfVGZUM3dHUTJXSVA0alZQU2NkQlFDQlVvRTgtQ2szMHZmNkRRNjE4NXRoYmxEV0dDYWlfWjgwOGJ6Wm1tVQ&q=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1yg4M7PvpfUVrQTAN6cuD1CALnfP06KQGiLfCsFCgG3Y%2Fedit%3Fusp%3Dsharing&v=dxIGeBFBNkM'), 
	(4, 'https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbjRKTmpDZVFJWFgzY3lZSGZOYV9HTTZQSDMxZ3xBQ3Jtc0tsWGNIbndNSDRBaXdJZzlucHJ4RlE0cTBmbmlKUktIMVFYZVZwOUtOMC16d3ZOTlBnOWVqdkw2U0hHdzljeWVwUmVpS2J2Zm5SdkJ3VnZoTTNTRXNFRlNhek5YQm0yZ3dCTXdnaV9RQmZMRGlueFpPQQ&q=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1yg4M7PvpfUVrQTAN6cuD1CALnfP06KQGiLfCsFCgG3Y%2Fedit%3Fusp%3Dsharing&v=dxIGeBFBNkM'), 
	(5, 'https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbUM0U3VZY1Q5SVdTbmhlTG1iQTBnMy1yZ25DZ3xBQ3Jtc0trZ3lCRjdGZlhCWUEtbDVxOWh4Rm1WelZXa0hqMjI2MXBsbV81a2N5NGl0dDhNYjNiZElRejlEMlB4Vko5T1pWekdiUFpLZGp4THVFeHVKMUhuZWozUFl6aDR1N2MzVzRHbFlkemtkUklwU1JOdTZPcw&q=https%3A%2F%2Fdocs.google.com%2Fdocument%2Fd%2F1QYNNMqLAR6m56igsrSljjc_WpMn2B6RX9bplVVK02vw%2Fedit%3Fusp%3Dsharing&v=LDevjw4zit0'), 
	(6, 'https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbmMxQTdMdWdxRHBSMGY2aGx5VXdteU1NZndZQXxBQ3Jtc0trNVNabmE4NEFvdWFLNEN3MlVDak9udV9DZzNYZWRiZWR6ZU5IblJoN2RjRnFWTEFtbmNSWjdSSUxCakJzS0xQRU5fUTRkdTlsZ3VZQXVuSkw2YW1DSHFaanN6UUdkY0FNVjF3aVJkZmxMcnRNR3Ywdw&q=https%3A%2F%2Fdrive.google.com%2Fopen%3Fid%3D1-FBpdAFzpkBWrNz4oemRQpfJzA8XTsBd4SuNr96WkKE&v=2oa3zrHyopo');

insert into t_users_roles (id_user, id_role) values
	((select id from t_users u where u.email = 'julien.fontanier@gmail.com'), 
	(select id from t_roles r where r.role_code = 'ADMIN')),
	((select id from t_users u where u.email = 'axel.galvier@hotmail.fr'), 
	(select id from t_roles r where r.role_code = 'MMBER')),
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_roles r where r.role_code = 'MODER'));

insert into t_users_exercises (id_user, id_exercise, assessment, realised_at) values
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_exercises e where e.exercise_number = 1), 100, '2008-08-27'),
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_exercises e where e.exercise_number = 2), 97, '2008-09-03'),
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_exercises e where e.exercise_number = 3), 98, '2008-12-14'),
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_exercises e where e.exercise_number = 4), 87, '2008-11-18'),
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_exercises e where e.exercise_number = 5), 91, '2008-04-17'),
	((select id from t_users u where u.email = 'jf@gm.com'), 
	(select id from t_exercises e where e.exercise_number = 6), 63, '2008-06-23'),
	((select id from t_users u where u.email = 'axel.galvier@hotmail.fr'), 
	(select id from t_exercises e where e.exercise_number = 1), 84, '2016-09-25'),
	((select id from t_users u where u.email = 'axel.galvier@hotmail.fr'), 
	(select id from t_exercises e where e.exercise_number = 2), 67, '2016-06-07');

insert into t_video_lessons_exercises (id_video_lesson, id_exercise) values
	((select id from t_video_lessons vl where vl.link = 'https://youtu.be/_PCJnq_-oT8'), 
	(select id from t_exercises e where e.exercise_number = 1)),
	((select id from t_video_lessons vl where vl.link = 'https://youtu.be/LlyGGMlEydM'), 
	(select id from t_exercises e where e.exercise_number = 2)),
	((select id from t_video_lessons vl where vl.link = 'https://youtu.be/dxIGeBFBNkM'), 
	(select id from t_exercises e where e.exercise_number = 3)),
	((select id from t_video_lessons vl where vl.link = 'https://youtu.be/YD4RT6JYJ98'), 
	(select id from t_exercises e where e.exercise_number = 4)),
	((select id from t_video_lessons vl where vl.link = 'https://youtu.be/LDevjw4zit0'), 
	(select id from t_exercises e where e.exercise_number = 5)),
	((select id from t_video_lessons vl where vl.link = 'https://youtu.be/2oa3zrHyopo'), 
	(select id from t_exercises e where e.exercise_number = 6));