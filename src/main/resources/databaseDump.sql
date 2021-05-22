--
-- PostgreSQL database dump
--

-- Dumped from database version 11.9 (Debian 11.9-1.pgdg90+1)
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-22 16:52:17 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 33422)
-- Name: thermoconnect; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA thermoconnect;


--
-- TOC entry 197 (class 1259 OID 33423)
-- Name: animal; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect.animal (
    "id_animal" integer NOT NULL,
    "id_terrarium" integer NOT NULL,
    "id_species" character varying(32) NOT NULL,
    "name_animal" character varying(32) NOT NULL,
    sex boolean,
    "date_of_birth" date,
    description text,
    food text,
    "url_picture" character varying(256)
);


--
-- TOC entry 198 (class 1259 OID 33429)
-- Name: animal_data; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect."animal_data" (
    "id_animal" integer NOT NULL,
    "date_animal_data" date NOT NULL,
    weight double precision NOT NULL
);


--
-- TOC entry 199 (class 1259 OID 33432)
-- Name: animal_picture; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect."animal_picture" (
    "id_animal" integer NOT NULL,
    url character varying(256) NOT NULL,
    "name_picture" character varying(32) NOT NULL
);


--
-- TOC entry 200 (class 1259 OID 33435)
-- Name: animal_id_animal_seq; Type: SEQUENCE; Schema: thermoconnect; Owner: -
--

CREATE SEQUENCE thermoconnect."animal_id_animal_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2921 (class 0 OID 0)
-- Dependencies: 200
-- Name: animal_id_animal_seq; Type: SEQUENCE OWNED BY; Schema: thermoconnect; Owner: -
--

ALTER SEQUENCE thermoconnect."animal_id_animal_seq" OWNED BY thermoconnect.animal."id_animal";


--
-- TOC entry 201 (class 1259 OID 33437)
-- Name: species; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect.species (
    "species_name" character varying(32) NOT NULL,
    description text
);


--
-- TOC entry 202 (class 1259 OID 33443)
-- Name: terrarium; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect.terrarium (
    "username" character varying(32) NOT NULL,
    "name_terrarium" character varying(32) NOT NULL,
    "id_terrarium" integer NOT NULL,
    "size_terrarium" character varying(32) NOT NULL,
    "start_light_time" time without time zone,
    "stop_light_time" time without time zone,
    "temperature_max" double precision,
    "temperature_min" double precision
);


--
-- TOC entry 203 (class 1259 OID 33446)
-- Name: terrarium_data; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect."terrarium_data" (
    "id_terrarium" integer NOT NULL,
    "time" timestamp without time zone NOT NULL,
    temperature double precision NOT NULL,
    humidity double precision NOT NULL
);


--
-- TOC entry 204 (class 1259 OID 33449)
-- Name: terrarium_id_terrarium_seq; Type: SEQUENCE; Schema: thermoconnect; Owner: -
--

CREATE SEQUENCE thermoconnect."terrarium_id_terrarium_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2922 (class 0 OID 0)
-- Dependencies: 204
-- Name: terrarium_id_terrarium_seq; Type: SEQUENCE OWNED BY; Schema: thermoconnect; Owner: -
--

ALTER SEQUENCE thermoconnect."terrarium_id_terrarium_seq" OWNED BY thermoconnect.terrarium."id_terrarium";


--
-- TOC entry 205 (class 1259 OID 33451)
-- Name: user; Type: TABLE; Schema: thermoconnect; Owner: -
--

CREATE TABLE thermoconnect."user" (
    username character varying(32) NOT NULL,
    password character varying(256) NOT NULL
);


--
-- TOC entry 2770 (class 2604 OID 33454)
-- Name: animal id_animal; Type: DEFAULT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.animal ALTER COLUMN "id_animal" SET DEFAULT nextval('thermoconnect."animal_id_animal_seq"'::regclass);


--
-- TOC entry 2771 (class 2604 OID 33455)
-- Name: terrarium id_terrarium; Type: DEFAULT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.terrarium ALTER COLUMN "id_terrarium" SET DEFAULT nextval('thermoconnect."terrarium_id_terrarium_seq"'::regclass);


--
-- TOC entry 2775 (class 2606 OID 33457)
-- Name: animal_data animal_data_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."animal_data"
    ADD CONSTRAINT "animal_data_pkey" PRIMARY KEY ("id_animal", "date_animal_data");


--
-- TOC entry 2777 (class 2606 OID 33459)
-- Name: animal_picture animal_picture_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."animal_picture"
    ADD CONSTRAINT "animal_picture_pkey" PRIMARY KEY ("id_animal", "name_picture");


--
-- TOC entry 2773 (class 2606 OID 33461)
-- Name: animal animal_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY ("id_animal");


--
-- TOC entry 2779 (class 2606 OID 33463)
-- Name: species species_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.species
    ADD CONSTRAINT species_pkey PRIMARY KEY ("species_name");


--
-- TOC entry 2786 (class 2606 OID 33465)
-- Name: terrarium_data terrarium_data_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."terrarium_data"
    ADD CONSTRAINT "terrarium_data_pkey" PRIMARY KEY ("id_terrarium", "time");


--
-- TOC entry 2782 (class 2606 OID 33467)
-- Name: terrarium terrarium_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.terrarium
    ADD CONSTRAINT terrarium_pkey PRIMARY KEY ("id_terrarium");


--
-- TOC entry 2784 (class 2606 OID 33469)
-- Name: terrarium uniqueNameTerrarium; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.terrarium
    ADD CONSTRAINT "uniqueNameTerrarium" UNIQUE ("username", "name_terrarium");


--
-- TOC entry 2788 (class 2606 OID 33471)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (username);


--
-- TOC entry 2780 (class 1259 OID 33472)
-- Name: fki_userTarrariumFK; Type: INDEX; Schema: thermoconnect; Owner: -
--

CREATE INDEX "fki_userTarrariumFK" ON thermoconnect.terrarium USING btree ("username");


--
-- TOC entry 2791 (class 2606 OID 33473)
-- Name: animal_data animal_data_id_animal_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."animal_data"
    ADD CONSTRAINT "animal_data_id_animal_fkey" FOREIGN KEY ("id_animal") REFERENCES thermoconnect.animal("id_animal") NOT VALID;


--
-- TOC entry 2792 (class 2606 OID 33478)
-- Name: animal_picture animal_picture_id_animal_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."animal_picture"
    ADD CONSTRAINT "animal_picture_id_animal_fkey" FOREIGN KEY ("id_animal") REFERENCES thermoconnect.animal("id_animal");


--
-- TOC entry 2789 (class 2606 OID 33483)
-- Name: animal animal_id_species_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT "animal_id_species_fkey" FOREIGN KEY ("id_species") REFERENCES thermoconnect.species("species_name");


--
-- TOC entry 2790 (class 2606 OID 33488)
-- Name: animal animal_id_terrarium_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT "animal_id_terrarium_fkey" FOREIGN KEY ("id_terrarium") REFERENCES thermoconnect.terrarium("id_terrarium");


--
-- TOC entry 2794 (class 2606 OID 33493)
-- Name: terrarium_data terrarium_data_id_terrarium_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect."terrarium_data"
    ADD CONSTRAINT "terrarium_data_id_terrarium_fkey" FOREIGN KEY ("id_terrarium") REFERENCES thermoconnect.terrarium("id_terrarium");


--
-- TOC entry 2793 (class 2606 OID 33498)
-- Name: terrarium userTarrariumFK; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.terrarium
    ADD CONSTRAINT "userTarrariumFK" FOREIGN KEY ("username") REFERENCES thermoconnect."user"(username) NOT VALID;


-- Completed on 2021-05-22 16:52:17 UTC

--
-- PostgreSQL database dump complete
--

