delete from t_roles, t_sub_categories, t_categories;

insert into t_roles (role_code, libelle, is_default) values 
	('ADMIN', 'Administrateur', 0), ('MMBER', 'Member', 1);

insert into t_categories (category_code, libelle) values
	('ECRJP', 'Ecriture de la langue japonaise'), ('GRAJP', 'La grammaire japonaise');

insert into t_sub_categories (id_category, sub_category_code, libelle) values 
	((select id from t_categories c where c.category_code = 'ECRJP'), 'PREGE', 'Présentations générales'), 
	((select id from t_categories c where c.category_code = 'ECRJP'), '4RUKA', 'Les quatre règles d''utilisation des kana'), 
	((select id from t_categories c where c.category_code = 'ECRJP'), 'KATAE', 'Ecrire en katakana les mots étrangers'), 
	((select id from t_categories c where c.category_code = 'ECRJP'), 'KANJI', 'Etude des kanji'),
	((select id from t_categories c where c.category_code = 'GRAJP'), 'FOPHR', 'La formation d''une phrase japonaise'),
	((select id from t_categories c where c.category_code = 'GRAJP'), 'SPEJP', 'Les spécificités de la langue japonaise');