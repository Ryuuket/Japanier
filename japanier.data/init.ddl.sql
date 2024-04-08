drop table if exists t_users_roles, t_users_exercises, t_video_lessons_exercises, t_users, t_video_lessons, t_exercises, t_roles, t_categories, t_sub_categories;

create table t_users(
	id serial primary key,
	email varchar (100) unique not null,
	password char (60) not null
);

create table t_categories(
	id serial primary key,
	category_code char(5) unique not null,
	libelle varchar(50) not null
);

create table t_sub_categories(
	id serial primary key,
	id_category integer not null,
	sub_category_code char(5) unique not null,
	libelle varchar(50) not null,
	constraint t_id_category_fk foreign key (id_category) references t_categories(id)
);

create table t_video_lessons(
	id serial primary key,
	id_sub_category integer not null,
	title varchar (128) unique not null,
	link varchar (500) unique not null,
	video_description varchar (2048) not null,
	constraint t_id_sub_category_fk foreign key (id_sub_category) references t_sub_categories(id)
);

create table t_exercises(
	id serial primary key,
	exercise_number integer unique not null,
	link varchar (500) unique not null
);

create table t_roles(
	id serial primary key,
	role_code char (5) unique not null,
	libelle varchar (16) not null
);

create table t_users_roles(
	id_user integer not null,
	id_role integer not null,
	constraint t_users_roles_pkey primary key (id_user, id_role),
	constraint t_id_user_fk foreign key (id_user) references t_users(id),
	constraint t_id_role_fk foreign key (id_role) references t_roles(id)
);

create table t_users_exercises(
	id serial primary key,
	id_user integer not null,
	id_exercise integer not null,
	assessment integer,
	realised_at date,
	constraint t_id_user_fk foreign key (id_user) references t_users(id),
	constraint t_id_exercise_fk foreign key (id_exercise) references t_exercises(id)
);

create table t_video_lessons_exercises(
	id_video_lesson integer not null,
	id_exercise integer not null,
	constraint t_video_lessons_exercises_pkey primary key (id_video_lesson, id_exercise),
	constraint t_id_video_lesson_fk foreign key (id_video_lesson) references t_video_lessons(id),
	constraint t_id_exercise_fk foreign key (id_exercise) references t_exercises(id)
);