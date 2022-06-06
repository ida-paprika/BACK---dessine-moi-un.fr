/*
 * Command lines from 'ddl' folder:
 * psql -h localhost -p 5432 -U postgres -d dessine_moi_un
 * \i data-reset.dml.sql
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