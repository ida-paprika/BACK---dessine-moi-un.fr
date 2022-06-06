/*
 * Command lines from 'ddl' folder:
 * psql -h localhost -p 5432 -U postgres -d dessine_moi_un
 * \i data.dml.sql
 * \q
 */

DELETE FROM artists_art_mediums;
DELETE FROM artists_art_formats;
DELETE FROM projects;
DELETE FROM progress_status;
DELETE FROM artworks;
DELETE FROM art_mediums;
DELETE FROM art_formats;
DELETE FROM artists;
DELETE FROM profiles;

INSERT INTO art_mediums (label , minimum_price)
	VALUES 
	('aquarelle', 15),
	('acrylique', 20),
	('gouache', 12),
	('fusain', 5),
	('feutres à alcool', 7),
	('encre de Chine', 8),
	('pastels secs', 10);

INSERT INTO art_formats (label , minimum_price, multiplier)
	VALUES 
	('A5', 30, 1),
	('A4', 40, 2),
	('A3', 100, 3),
	('A2', 200, 4),
	('Raisin', 60, 1.5),
	('Double Raisin', 90, 2.5);

INSERT INTO progress_status (status)
	VALUES 
	('WAITING'),
	('IN_PROGRESS'),
	('DONE');

INSERT INTO profiles (uuid, email)
	VALUES 
	('9ebc1fd9-f72f-46c8-9255-1e29b8f20ab9', 'artist1@mail.com'),
	('6c44d264-1a04-49a3-b541-7579ece3e8a1', 'orderer1@mail.com'),
	('fe48b8f7-fb89-4934-bac5-e616af56df53', 'james.jean@mail.com'),
	('f41d4ee5-c1ec-4f0d-93ed-c7b58f2d3074', 'dulk@mail.com'),
	('25e0dc24-95e3-466f-a93d-2cee1c4a0169', 'joe.fenton@mail.com');

INSERT INTO artists (id, artist_name, instagram_url, available, profile_id)
	VALUES 
	('Marbleck', null, false, (SELECT id FROM profiles WHERE email = 'artist1@mail.com')),
	('James Jean', 'https://www.instagram.com/jamesjeanart/', true, (SELECT id FROM profiles WHERE email = 'james.jean@mail.com')),
	('Dulk', 'https://www.instagram.com/dulk1/', true, (SELECT id FROM profiles WHERE email = 'dulk@mail.com')),
	('Joe Fenton', 'https://www.instagram.com/jfentonart/', true, (SELECT id FROM profiles WHERE email = 'joe.fenton@mail.com'));

INSERT INTO artworks (id, file_name, cover, artist_id)
	VALUES 
	(1, 'marbleck_0.jpg', true, (SELECT id FROM profiles WHERE artist_name = 'Marbleck')),
	(2, 'marbleck_1.jpg', false, (SELECT id FROM profiles WHERE artist_name = 'Marbleck')),
	(3, 'marbleck_2.jpg', false, (SELECT id FROM profiles WHERE artist_name = 'Marbleck')),
	(4, 'james_jean_0.jpg', true, (SELECT id FROM profiles WHERE artist_name = 'James Jean')),
	(5, 'dulk_0.png', true, (SELECT id FROM profiles WHERE artist_name = 'Dulk')),
	(6, 'joe_fenton_0.jpeg', true, (SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'));

INSERT INTO artists_art_mediums (artist_id, art_medium_id)
	VALUES 
	((SELECT id FROM profiles WHERE artist_name = 'Marbleck'), (SELECT id FROM art_mediums WHERE label = 'aquarelle')), 
	((SELECT id FROM profiles WHERE artist_name = 'Marbleck'), (SELECT id FROM art_mediums WHERE label = 'acrylique')), 
	((SELECT id FROM profiles WHERE artist_name = 'Marbleck'), (SELECT id FROM art_mediums WHERE label = 'gouache')), 
	((SELECT id FROM profiles WHERE artist_name = 'James Jean'), (SELECT id FROM art_mediums WHERE label = 'aquarelle')), 
	((SELECT id FROM profiles WHERE artist_name = 'James Jean'), (SELECT id FROM art_mediums WHERE label = 'acrylique')), 
	((SELECT id FROM profiles WHERE artist_name = 'James Jean'), (SELECT id FROM art_mediums WHERE label = 'gouache')),
	((SELECT id FROM profiles WHERE artist_name = 'Dulk'), (SELECT id FROM art_mediums WHERE label = 'aquarelle')), 
	((SELECT id FROM profiles WHERE artist_name = 'Dulk'), (SELECT id FROM art_mediums WHERE label = 'acrylique')), 
	((SELECT id FROM profiles WHERE artist_name = 'Dulk'), (SELECT id FROM art_mediums WHERE label = 'gouache')),
	((SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'), (SELECT id FROM art_mediums WHERE label = 'aquarelle')), 
	((SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'), (SELECT id FROM art_mediums WHERE label = 'acrylique')), 
	((SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'), (SELECT id FROM art_mediums WHERE label = 'gouache'));

INSERT INTO artists_art_formats (artist_id, art_format_id)
	VALUES 
	((SELECT id FROM profiles WHERE artist_name = 'Marbleck'), (SELECT id FROM art_formats WHERE label = 'A5')), 
	((SELECT id FROM profiles WHERE artist_name = 'Marbleck'), (SELECT id FROM art_formats WHERE label = 'A4')), 
	((SELECT id FROM profiles WHERE artist_name = 'Marbleck'), (SELECT id FROM art_formats WHERE label = 'A3')), 
	((SELECT id FROM profiles WHERE artist_name = 'James Jean'), (SELECT id FROM art_formats WHERE label = 'A5')), 
	((SELECT id FROM profiles WHERE artist_name = 'James Jean'), (SELECT id FROM art_formats WHERE label = 'A4')), 
	((SELECT id FROM profiles WHERE artist_name = 'James Jean'), (SELECT id FROM art_formats WHERE label = 'A3')),
	((SELECT id FROM profiles WHERE artist_name = 'Dulk'), (SELECT id FROM art_formats WHERE label = 'A5')), 
	((SELECT id FROM profiles WHERE artist_name = 'Dulk'), (SELECT id FROM art_formats WHERE label = 'A4')), 
	((SELECT id FROM profiles WHERE artist_name = 'Dulk'), (SELECT id FROM art_formats WHERE label = 'A3')),
	((SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'), (SELECT id FROM art_formats WHERE label = 'A5')), 
	((SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'), (SELECT id FROM art_formats WHERE label = 'A4')), 
	((SELECT id FROM profiles WHERE artist_name = 'Joe Fenton'), (SELECT id FROM art_formats WHERE label = 'A3'));





