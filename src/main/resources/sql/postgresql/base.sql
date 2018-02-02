
-- Database: bixi

-- DROP DATABASE bixi;

CREATE DATABASE bixi
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

COMMENT ON DATABASE bixi
    IS 'BiXi Database';


-- SCHEMA: bschema

-- DROP SCHEMA bschema ;

CREATE SCHEMA bschema
    AUTHORIZATION postgres;

-- Table: bschema."Users"

-- DROP TABLE bschema."Users";

CREATE TABLE bschema."Users"
(
    user_id bigint NOT NULL,
    username character varying(128) COLLATE pg_catalog."default",
    password character varying(256) COLLATE pg_catalog."default",
    enabled boolean,
    CONSTRAINT "Users_pkey" PRIMARY KEY (user_id),
    CONSTRAINT "Users_username_key" UNIQUE (username)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE bschema."Users"
    OWNER to postgres;

-- Table: bschema.user_profile

-- DROP TABLE bschema.user_profile;

CREATE TABLE bschema.user_profile
(
    username character varying(60) COLLATE pg_catalog."default" NOT NULL,
    email character varying(70) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default",
    last_name character varying(100) COLLATE pg_catalog."default",
    dob date,
    phone numeric(15,0),
    address character varying(300) COLLATE pg_catalog."default",
    id bigint,
    created_on date,
    access_token character varying(500) COLLATE pg_catalog."default",
    CONSTRAINT user_profile_pkey PRIMARY KEY (username),
    CONSTRAINT uni_username UNIQUE (username, email)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE bschema.user_profile
    OWNER to postgres;

