/*
 * Command lines from 'admin' folder:
 * psql -h localhost -p 5432 -U postgres
 * \i database.sql
 * \q
 */
DROP DATABASE IF EXISTS dessine_moi_un;
CREATE DATABASE dessine_moi_un WITH OWNER 'postgres' ENCODING 'UTF8';