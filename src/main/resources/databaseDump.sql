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
    "species_name" character varying(32) NOT NULL,
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
-- Name: animal_picture; Type: TABLE; Schema: thermoconnect; Owner: 
--

CREATE TABLE thermoconnect."animal_picture" (
    "id_animal" integer NOT NULL,
    url character varying(256) NOT NULL,
    "name_picture" character varying(128) NOT NULL
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
    description text,
    "humidity_species" double precision,
    "temperature_min_species" double precision,
    "temperature_max_species" double precision
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
    "temperature_min" double precision,
    "humidity_terrarium" double precision
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
-- Name: animal animal_species_name_fkey; Type: FK CONSTRAINT; Schema: thermoconnect; Owner: -
--

ALTER TABLE ONLY thermoconnect.animal
    ADD CONSTRAINT "animal_species_name_fkey" FOREIGN KEY ("species_name") REFERENCES thermoconnect.species("species_name");


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


insert into thermoconnect.species (species_name, description)  values

('Boa constricteur ',	'Le Boa constrictor se reconna??t ?? sa large t??te presque triangulaire, qui se r??tr??cit brusquement vers l???avant. Une ligne claire va du front au museau du serpent g??ant. Leur peau a en r??gle g??n??rale une couleur de base blanche cr??me ?? grise-brune. Les ocelles dorsales sont de couleur brun??tre et ont des inclusions blanches sur les flancs. Les taches sur la queue brillent souvent d???un rouge vif. Il existe de nombreuses esp??ces diff??rentes, en fonction du territoire d???origine, et elles diff??rent consid??rablement par leur taille et leur couleur. '	)	,	
('Ceratophys cranwelli ',	'Les Ceratophrys sont des grenouilles massives. Le m??le est g??n??ralement plus petit que la femelle (environ 10??cm chez le m??le contre 15??cm chez la femelle),. Les m??les poss??dent un sac vocal au niveau de la gorge leur permettant de coasser. Chez le m??le adulte la gorge est plus fonc??e que chez la femelle. Les grenouilles cornues poss??dent un appendice de peau au-dessus de l ??il, ce qui leur a valu leur nom, dont la taille varie d une esp??ce ?? l autre. Les plus grandes cornes ??tant observ??es chez Ceratophrys cornuta. '	)		,
('Chat', 'Roger sort ton chat du terrarium et arr??te de boire'			),
('Gecko L??opard  ',	'Le gecko l??opard est un reptile, de l???ordre des squamates, et plus pr??cis??ment du sous-ordre des l??zards. On le trouve ?? l?????tat sauvage en Asie, du sud de l???Afghanistan au nord de l???Inde. C???est un animal du d??sert qui est insectivore.
Le gecko l??opard est un animal nocturne, c???est ?? dire qu???il vit principalement au cr??puscule, la nuit et ?? l???aube.
Physiquement, c???est un petit l??zard qui mesure entre 17 et 20cm pour les m??les, et entre 20 et 25cm pour les femelles. Il est dot?? de petites griffes sur l???extr??mit?? de ses doigts, qui lui permettent de monter sur des racines ou des parois quasi verticales. '		)	,
('Morelia Veridis ', 'Le python vert (Morelia viridis et Morelia azurea), est un serpent mythique pour nombre de terrariophiles. Ce python ne ressemble ?? aucun autre et poss??de nombre de particularit??s physiques et comportementales. Par exemple les juv??niles peuvent na??tre jaunes ou rouge et changent de couleur entre 6 mois et un an pour devenir vert, une fois adulte. C???est le changement ontog??nique. Strictement arboricole, ce python reste la plupart du temps camoufl?? sur les branches sans bouger dans une position typique. Les adultes vivent plut??t en haut des arbres parfois ?? 20 m??tres de hauteur et descendent la nuit vers le sol pour chasser des rongeurs et non des oiseaux comme on le pensait ?? l?????poque. Les juv??niles Morelia viridis sont plut??t en lisi??re de for??ts dans des buissons bas et chasse plut??t des l??zards et des amphibiens. '	)	,	
('Pantherophis guttatus ', 'Cette esp??ce est end??mique des ??tats-Unis2. Elle se rencontre en Louisiane, en Arkansas, au Mississippi, en Alabama, en Floride, en G??orgie, en Caroline du Sud, en Caroline du Nord, au Tennessee, au Kentucky, en Virginie, en Virginie-Occidentale, au Maryland, au Delaware, au New Jersey et en Pennsylvanie.
Elle a ??t?? introduite aux Antilles, aux ??les Ca??mans, aux ??les Vierges, ?? Anguilla, ?? Antigua et ?? Saint-Barth??lemy '			),
('Pogona viticeps  ', 'Il s agit d un l??zard ?? l allure massive, aplati dorso-ventralement, poss??dant de fortes griffes et des paupi??res mobiles. Le type sauvage est brun-gris??tre, avec des marbrures plus claires, nettement transversales sur les pattes et la queue. Mais les animaleries proposent d??sormais de nombreuses vari??t??s mutantes pr??sentant des couleurs vari??es2. Les sp??cimens adultes mesurent 50??cm de long au maximum2, la queue prenant plus de la moiti?? de la longueur totale du corps. Les femelles sont g??n??ralement plus petites que les m??les. Ces derniers poss??dent des pores f??moraux ?? l int??rieur des cuisses, ainsi que des renflements h??mip??niens ?? la base de la queue, visibles chez les adultes et subadultes. '		)	,
('Python Curtus ', 'Pendant tr??s longtemps, l esp??ce??Python curtus????tait compos??e 3 sous esp??ces : Python curtus brongersmai (pr??sent en Malaisie, sur Sumatra, et certaines ??les avoisinantes comme Banka), Python curtus breitensteini (pr??sent sur Borneo), et Python curtus curtus (sur Sumatra),. En 2001, Keogh, Barker et Shine ont d??termin?? un nombre de diff??rences suffisantes pour les ??lever au rang d esp??ce. Aujourd hui, ils sont donc devenus : Python brongersmai, Python breitensteini et Python curtus. Nous??utilisons ??galement le nom commun anglais Blood pythons pour d??signer ce groupe, les noms communs fran??ais ??tant tr??s long et moins g??n??riques. '			),
('Python regius ', 'Le python royal (Python regius), est devenu le serpent de la famille des bo??d??s le plus populaire au monde. Il est originaire d Afrique de l ouest, notamment du Ghana, du Togo et du Benin. C est un python magnifique, au corps trapu mais d une taille raisonnable puisque les pythons royaux adultes mesure 130 ??150cm de long en moyenne pour un poids de 2kg. La femelle est parfois plus grosse que le m??le.?? Son petit gabarit et son caract??re calme et craintif font de lui un serpent facile ?? manipuler m??me si on n a pas beaucoup d exp??rience. S il se sent menac??, le Python regius aura le r??flexe de se mettre en boule au lieu de se d??fendre en mordant. Cette attitude lui a valu son nom commun anglais Ball python.???? '		)	,
('Varans des savanes ', 'Esp??ce diurne principalement terrestre, aime beaucoup creuser, si on leur en donne les possibilit??s, ils grimpent pas mal aussi. '	)		
;

