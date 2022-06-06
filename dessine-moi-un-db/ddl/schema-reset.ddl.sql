/*
 * Command lines from 'ddl' folder:
 * psql -h localhost -p 5432 -U postgres -d dessine_moi_un
 * \i schema-reset.ddl.sql
 * \q
 */
ALTER TABLE artists DROP CONSTRAINT fk_artists_profile;

ALTER TABLE artworks DROP CONSTRAINT fk_artworks_artist;

ALTER TABLE projects DROP CONSTRAINT fk_projects_artist;
ALTER TABLE projects DROP CONSTRAINT fk_projects_profile;
ALTER TABLE projects DROP CONSTRAINT fk_projects_art_medium;
ALTER TABLE projects DROP CONSTRAINT fk_projects_art_format;
ALTER TABLE projects DROP CONSTRAINT fk_projects_progress_status;

ALTER TABLE artists_art_mediums DROP CONSTRAINT fk_artists_art_mediums_artist;
ALTER TABLE artists_art_mediums DROP CONSTRAINT fk_artists_art_mediums_medium;

ALTER TABLE artists_art_formats DROP CONSTRAINT fk_artists_art_formats_artist;
ALTER TABLE artists_art_formats DROP CONSTRAINT fk_artists_art_formats_format;


DROP TABLE IF EXISTS artists_art_mediums;
DROP TABLE IF EXISTS artists_art_formats;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS progress_status;
DROP TABLE IF EXISTS art_mediums;
DROP TABLE IF EXISTS art_formats;
DROP TABLE IF EXISTS artworks;
DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS profiles;