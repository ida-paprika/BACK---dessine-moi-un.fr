/*
 * Command lines from 'ddl' folder:
 * psql -h localhost -p 5432 -U postgres -d dessine_moi_un
 * \i data.dml.sql
 * \q
 */

INSERT INTO art_mediums (id, label , minimum_price)
	VALUES 
	(1, 'aquarelle', 15),
	(2, 'acrylique', 20),
	(3, 'gouache', 12),
	(4, 'fusain', 5),
	(5, 'feutres à alcool', 7),
	(6, 'encre de Chine', 8),
	(7, 'pastels secs', 10);

INSERT INTO art_formats (id, label , minimum_price, multiplier)
	VALUES 
	(1, 'A5', 30, 1),
	(2, 'A4', 40, 2),
	(3, 'A3', 100, 3),
	(4, 'A2', 200, 4),
	(5, 'Raisin', 60, 1.5),
	(6, 'Double Raisin', 90, 2.5);

INSERT INTO progress_status (id, status)
	VALUES 
	(1, 'En attente'),
	(2, 'En cours'),
	(3, 'Terminé');

INSERT INTO profiles (id, uuid, email)
	VALUES 
	(911, '9ebc1fd9-f72f-46c8-9255-1e29b8f20ab9', 'artist1@mail.com'),
	(912, '6c44d264-1a04-49a3-b541-7579ece3e8a1', 'orderer1@mail.com'),
	(913, 'fe48b8f7-fb89-4934-bac5-e616af56df53', 'james.jean@mail.com'),
	(914, 'f41d4ee5-c1ec-4f0d-93ed-c7b58f2d3074', 'dulk@mail.com'),
	(915, '25e0dc24-95e3-466f-a93d-2cee1c4a0169', 'joe.fenton@mail.com');

INSERT INTO artists (id, artist_name, instagram_url, available, profile_id)
	VALUES 
	(811, 'Marbleck', null, false, 911),
	(812, 'James Jean', 'https://www.instagram.com/jamesjeanart/', true, 913),
	(813, 'Dulk', 'https://www.instagram.com/dulk1/', true, 914),
	(814, 'Joe Fenton', 'https://www.instagram.com/jfentonart/', true, 915);

INSERT INTO artworks (id, file_name, cover, artist_id)
	VALUES 
	(1, 'marbleck_0.jpg', true, 811),
	(2, 'marbleck_1.jpg', false, 811),
	(3, 'marbleck_2.jpg', false, 811),
	(4, 'james_jean_0.jpg', true, 812),
	(5, 'dulk_0.png', true, 813),
	(6, 'joe_fenton_0.jpeg', true, 814);

INSERT INTO artists_art_mediums (artist_id, art_medium_id)
	VALUES 
	(811, 1), (811, 2), (811, 3), 
	(812, 1), (812, 2), (812, 3),
	(813, 1), (813, 2), (813, 3),
	(814, 1), (814, 2), (814, 3);

INSERT INTO artists_art_formats (artist_id, art_format_id)
	VALUES 
	(811, 1), (811, 2), (811, 3), 
	(812, 1), (812, 2), (812, 3),
	(813, 1), (813, 2), (813, 3),
	(814, 1), (814, 2), (814, 3);

INSERT INTO projects (id, description, deadline, artist_id, 
	profile_id, art_medium_id, art_format_id, progress_status_id)
	VALUES 
	(1,'Une licorne à réaction','2023-12-01', 811, 912, 1, 1, 1);





