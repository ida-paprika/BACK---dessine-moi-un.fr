/*
 * Command lines from 'ddl' folder:
 * psql -h localhost -p 5432 -U postgres -d dessine_moi_un
 * \i schema.ddl.sql
 * \q
 */
ALTER TABLE IF EXISTS artists DROP CONSTRAINT fk_artists_profile;
ALTER TABLE IF EXISTS artworks DROP CONSTRAINT fk_artworks_artist;
ALTER TABLE IF EXISTS projects DROP CONSTRAINT fk_projects_artist;
ALTER TABLE IF EXISTS projects DROP CONSTRAINT fk_projects_profile;
ALTER TABLE IF EXISTS projects DROP CONSTRAINT fk_projects_art_medium;
ALTER TABLE IF EXISTS projects DROP CONSTRAINT fk_projects_art_format;
ALTER TABLE IF EXISTS projects DROP CONSTRAINT fk_projects_progress_status;
ALTER TABLE IF EXISTS artists_art_mediums DROP CONSTRAINT fk_artists_art_mediums_artist;
ALTER TABLE IF EXISTS artists_art_mediums DROP CONSTRAINT fk_artists_art_mediums_medium;
ALTER TABLE IF EXISTS artists_art_formats DROP CONSTRAINT fk_artists_art_formats_artist;
ALTER TABLE IF EXISTS artists_art_formats DROP CONSTRAINT fk_artists_art_formats_format;

DROP TABLE IF EXISTS profiles;
CREATE TABLE profiles (
	id SERIAL PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL,
	email VARCHAR(255) UNIQUE NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(50)
);

DROP TABLE IF EXISTS artists;
CREATE TABLE artists (  
	id SERIAL PRIMARY KEY,
	artist_name VARCHAR(50) UNIQUE NOT NULL,
    instagram_url VARCHAR(150),
	available BOOLEAN NOT NULL,
    profile_id INTEGER
);

DROP TABLE IF EXISTS artworks;
CREATE TABLE artworks (
    id SERIAL PRIMARY KEY,
    file_name VARCHAR(255) UNIQUE NOT NULL,
    cover BOOLEAN NOT NULL,
    artist_id INTEGER
);

DROP TABLE IF EXISTS art_mediums;
CREATE TABLE art_mediums (  
	id SERIAL PRIMARY KEY,
	label VARCHAR(50) NOT NULL,
	minimum_price INTEGER NOT NULL
);

DROP TABLE IF EXISTS art_formats;
CREATE TABLE art_formats (  
	id SERIAL PRIMARY KEY,
	label VARCHAR(20) NOT NULL,
	minimum_price INTEGER NOT NULL,
    multiplier NUMERIC(2,1) NOT NULL
);

DROP TABLE IF EXISTS artists_art_mediums;
CREATE TABLE artists_art_mediums (
  artist_id INTEGER,
  art_medium_id INTEGER,
  PRIMARY KEY (artist_id, art_medium_id)
);

DROP TABLE IF EXISTS artists_art_formats;
CREATE TABLE artists_art_formats (
  artist_id INTEGER,
  art_format_id INTEGER,
  PRIMARY KEY (artist_id, art_format_id)
);

DROP TABLE IF EXISTS progress_status;
CREATE TABLE progress_status (  
	id SERIAL PRIMARY KEY,
	status VARCHAR(12) NOT NULL
);

DROP TABLE IF EXISTS projects;
CREATE TABLE projects (  
	id SERIAL PRIMARY KEY,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	description VARCHAR(255) NOT NULL,
    price INTEGER,
    deadline DATE,
    artist_id INTEGER,
    profile_id INTEGER,
    art_medium_id INTEGER,
    art_format_id INTEGER,
    progress_status_id INTEGER
);

ALTER TABLE artists ADD CONSTRAINT fk_artists_profile FOREIGN KEY (profile_id) REFERENCES profiles(id);

ALTER TABLE artworks ADD CONSTRAINT fk_artworks_artist FOREIGN KEY (artist_id) REFERENCES artists(id);

ALTER TABLE projects ADD CONSTRAINT fk_projects_artist FOREIGN KEY (artist_id) REFERENCES artists(id);
ALTER TABLE projects ADD CONSTRAINT fk_projects_profile FOREIGN KEY (profile_id) REFERENCES profiles(id);
ALTER TABLE projects ADD CONSTRAINT fk_projects_art_medium FOREIGN KEY (art_medium_id) REFERENCES art_mediums(id);
ALTER TABLE projects ADD CONSTRAINT fk_projects_art_format FOREIGN KEY (art_format_id) REFERENCES art_formats(id);
ALTER TABLE projects ADD CONSTRAINT fk_projects_progress_status FOREIGN KEY (progress_status_id) REFERENCES progress_status(id);

ALTER TABLE artists_art_mediums ADD CONSTRAINT fk_artists_art_mediums_artist FOREIGN KEY(artist_id) REFERENCES artists(id);
ALTER TABLE artists_art_mediums ADD CONSTRAINT fk_artists_art_mediums_medium FOREIGN KEY(art_medium_id) REFERENCES art_mediums(id);

ALTER TABLE artists_art_formats ADD CONSTRAINT fk_artists_art_formats_artist FOREIGN KEY(artist_id) REFERENCES artists(id);
ALTER TABLE artists_art_formats ADD CONSTRAINT fk_artists_art_formats_format FOREIGN KEY(art_format_id) REFERENCES art_formats(id);
