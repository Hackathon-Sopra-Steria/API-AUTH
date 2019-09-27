--
-- PostgreSQL create database Hackathon
--

ALTER USER postgres WITH PASSWORD 'root';

DROP DATABASE  Hackathon

CREATE DATABASE Hackathon
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;



CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';




CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;



COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';




CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;




SET default_tablespace = '';


SET default_with_oids = false;



-- TABLES


CREATE TABLE public.users (
    id SERIAL primary key NOT NULL,
    username character varying(100) NOT NULL,
    password character varying(100) NOT NULL,
    role_id SERIAL NOT NULL,
    email character varying(100) NOT NULL
);

ALTER TABLE public.users OWNER TO postgres;
INSERT INTO public.users (id,username,password,role_id,email) VALUES (1,'admin', encrypt(cast('admin' as bytea),'key_to_encrypt','aes'),1,'admin@admin.com');



CREATE TABLE public.roles (
    id SERIAL primary key NOT NULL,
    role character varying(100) NOT NULL
);

ALTER TABLE public.roles OWNER TO postgres;
INSERT INTO public.roles (id,role) VALUES (1,'ADMIN');
INSERT INTO public.roles (id,role) VALUES (2,'USER');

CREATE TABLE public.user_roles (
    user_id SERIAL NOT NULL,
    role_id SERIAL NOT NULL
);

ALTER TABLE public.user_roles OWNER TO postgres;
INSERT INTO public.user_roles (user_id,role_id) VALUES (1,1);


ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES public.roles(id);

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES public.roles(id);

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.users(id);
