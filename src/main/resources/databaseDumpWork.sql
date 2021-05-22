--
-- PostgreSQL database dump
--

-- Dumped from database version 11.9 (Debian 11.9-1.pgdg90+1)
-- Dumped by pg_dump version 13.2

-- Started on 2021-05-20 11:56:15 UTC

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
-- TOC entry 8 (class 2615 OID 32972)
-- Name: thermoconnect; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA thermoconnect;


  

SET default_tablespace = '';

--
-- TOC entry 203 (class 1259 OID 33089)
-- Name: animal; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect.animal (
    "idAnimal" integer NOT NULL,
    "idTerrarium" integer NOT NULL,
    "idSpecies" varchar(32) NOT NULL,
    "nameAnimal" varchar(32) NOT NULL,
    sex boolean,
    "dateOfBirth" date,
    description text,
    food text,
    "urlPicture" varchar(256)
);


  

--
-- TOC entry 204 (class 1259 OID 33108)
-- Name: animalData; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect."animalData" (
    "idAnimal" integer NOT NULL,
    "dateAnimalData" date NOT NULL,
    weight double precision NOT NULL
);


  

--
-- TOC entry 205 (class 1259 OID 33118)
-- Name: animalPicture; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect."animalPicture" (
    "idAnimal" integer NOT NULL,
    url varchar(256) NOT NULL,
    "namePicture" varchar(32) NOT NULL
);


  

--
-- TOC entry 202 (class 1259 OID 33087)
-- Name: animal_idAnimal_seq; Type: SEQUENCE; Schema: thermoconnect; Owner: postgres
--

CREATE SEQUENCE thermoconnect."animal_idAnimal_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


  

--
-- TOC entry 2936 (class 0 OID 0)
-- Dependencies: 202
-- Name: animal_idAnimal_seq; Type: SEQUENCE OWNED BY; Schema: thermoconnect; Owner: postgres
--

ALTER SEQUENCE thermoconnect."animal_idAnimal_seq" OWNED BY thermoconnect.animal."idAnimal";


--
-- TOC entry 201 (class 1259 OID 33079)
-- Name: species; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect.species (
    "speciesName" varchar(32) NOT NULL,
    description text
);


  

--
-- TOC entry 198 (class 1259 OID 32981)
-- Name: terrarium; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect.terrarium (
    "user" varchar(32) NOT NULL,
    "nameTerrarium" varchar(32) NOT NULL,
    "idTerrarium" integer NOT NULL,
    "sizeTerrarium" varchar(32) NOT NULL,
    "startLightTime" time without time zone,
    "stopLightTime" time without time zone,
    "temperatureMax" double precision,
    "temperatureMin" double precision
);


  

--
-- TOC entry 200 (class 1259 OID 33068)
-- Name: terrariumData; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect."terrariumData" (
    "idTerrarium" integer NOT NULL,
    "time" timestamp without time zone NOT NULL,
    temperature double precision NOT NULL,
    humidity double precision NOT NULL
);


  

--
-- TOC entry 199 (class 1259 OID 33053)
-- Name: terrarium_idTerrarium_seq; Type: SEQUENCE; Schema: thermoconnect; Owner: postgres
--

CREATE SEQUENCE thermoconnect."terrarium_idTerrarium_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


  

--
-- TOC entry 2938 (class 0 OID 0)
-- Dependencies: 199
-- Name: terrarium_idTerrarium_seq; Type: SEQUENCE OWNED BY; Schema: thermoconnect; Owner: postgres
--

ALTER SEQUENCE thermoconnect."terrarium_idTerrarium_seq" OWNED BY thermoconnect.terrarium."idTerrarium";


--
-- TOC entry 197 (class 1259 OID 32973)
-- Name: user; Type: TABLE; Schema: thermoconnect; Owner: postgres
--

CREATE TABLE thermoconnect."user" (
    username varchar(32) NOT NULL,
    password varchar(256) NOT NULL
);


  

--
-- TOC entry 2774 (class 2604 OID 33092)
-- Name: animal idAnimal; Type: DEFAULT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.animal ALTER COLUMN "idAnimal" SET DEFAULT nextval('thermoconnect."animal_idAnimal_seq"'::regclass);


--
-- TOC entry 2773 (class 2604 OID 33055)
-- Name: terrarium idTerrarium; Type: DEFAULT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.terrarium ALTER COLUMN "idTerrarium" SET DEFAULT nextval('thermoconnect."terrarium_idTerrarium_seq"'::regclass);



--
-- TOC entry 2939 (class 0 OID 0)
-- Dependencies: 202
-- Name: animal_idAnimal_seq; Type: SEQUENCE SET; Schema: thermoconnect; Owner: postgres
--

SELECT pg_catalog.setval('thermoconnect."animal_idAnimal_seq"', 1, false);


--
-- TOC entry 2940 (class 0 OID 0)
-- Dependencies: 199
-- Name: terrarium_idTerrarium_seq; Type: SEQUENCE SET; Schema: thermoconnect; Owner: postgres
--

SELECT pg_catalog.setval('thermoconnect."terrarium_idTerrarium_seq"', 1, false);


--
-- TOC entry 2789 (class 2606 OID 33112)
-- Name: animalData animalData_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."animalData"
    ADD CONSTRAINT "animalData_pkey" PRIMARY KEY ("idAnimal", "dateAnimalData");


--
-- TOC entry 2791 (class 2606 OID 33125)
-- Name: animalPicture animalPicture_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."animalPicture"
    ADD CONSTRAINT "animalPicture_pkey" PRIMARY KEY ("idAnimal", "namePicture");


--
-- TOC entry 2787 (class 2606 OID 33097)
-- Name: animal animal_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT animal_pkey PRIMARY KEY ("idAnimal");


--
-- TOC entry 2785 (class 2606 OID 33086)
-- Name: species species_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.species
    ADD CONSTRAINT species_pkey PRIMARY KEY ("speciesName");


--
-- TOC entry 2783 (class 2606 OID 33072)
-- Name: terrariumData terrariumData_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."terrariumData"
    ADD CONSTRAINT "terrariumData_pkey" PRIMARY KEY ("idTerrarium", "time");


--
-- TOC entry 2779 (class 2606 OID 33065)
-- Name: terrarium terrarium_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.terrarium
    ADD CONSTRAINT terrarium_pkey PRIMARY KEY ("idTerrarium");


--
-- TOC entry 2781 (class 2606 OID 33067)
-- Name: terrarium uniqueNameTerrarium; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.terrarium
    ADD CONSTRAINT "uniqueNameTerrarium" UNIQUE ("user", "nameTerrarium");


--
-- TOC entry 2776 (class 2606 OID 32980)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (username);


--
-- TOC entry 2777 (class 1259 OID 32994)
-- Name: fki_userTarrariumFK; Type: INDEX; Schema: thermoconnect; Owner: postgres
--

CREATE INDEX "fki_userTarrariumFK" ON thermoconnect.terrarium USING btree ("user");


--
-- TOC entry 2796 (class 2606 OID 33113)
-- Name: animalData animalData_idAnimal_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."animalData"
    ADD CONSTRAINT "animalData_idAnimal_fkey" FOREIGN KEY ("idAnimal") REFERENCES thermoconnect.animal("idAnimal") NOT VALID;


--
-- TOC entry 2797 (class 2606 OID 33126)
-- Name: animalPicture animalPicture_idAnimal_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."animalPicture"
    ADD CONSTRAINT "animalPicture_idAnimal_fkey" FOREIGN KEY ("idAnimal") REFERENCES thermoconnect.animal("idAnimal");


--
-- TOC entry 2795 (class 2606 OID 33103)
-- Name: animal animal_idSpecies_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT "animal_idSpecies_fkey" FOREIGN KEY ("idSpecies") REFERENCES thermoconnect.species("speciesName");


--
-- TOC entry 2794 (class 2606 OID 33098)
-- Name: animal animal_idTerrarium_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT "animal_idTerrarium_fkey" FOREIGN KEY ("idTerrarium") REFERENCES thermoconnect.terrarium("idTerrarium");


--
-- TOC entry 2793 (class 2606 OID 33073)
-- Name: terrariumData terrariumData_idTerrarium_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect."terrariumData"
    ADD CONSTRAINT "terrariumData_idTerrarium_fkey" FOREIGN KEY ("idTerrarium") REFERENCES thermoconnect.terrarium("idTerrarium");


--
-- TOC entry 2792 (class 2606 OID 32989)
-- Name: terrarium userTarrariumFK; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: postgres
--

ALTER TABLE ONLY thermoconnect.terrarium
    ADD CONSTRAINT "userTarrariumFK" FOREIGN KEY ("user") REFERENCES thermoconnect."user"(username) NOT VALID;


