--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

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
-- Name: javalesson11; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA javalesson11;


ALTER SCHEMA javalesson11 OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: person; Type: TABLE; Schema: javalesson11; Owner: postgres
--

CREATE TABLE javalesson11.person (
    id integer NOT NULL,
    name character varying
);


ALTER TABLE javalesson11.person OWNER TO postgres;

--
-- Name: person_id_seq; Type: SEQUENCE; Schema: javalesson11; Owner: postgres
--

CREATE SEQUENCE javalesson11.person_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE javalesson11.person_id_seq OWNER TO postgres;

--
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: javalesson11; Owner: postgres
--

ALTER SEQUENCE javalesson11.person_id_seq OWNED BY javalesson11.person.id;


--
-- Name: products; Type: TABLE; Schema: javalesson11; Owner: postgres
--

CREATE TABLE javalesson11.products (
    id integer NOT NULL,
    name character varying,
    price double precision
);


ALTER TABLE javalesson11.products OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: javalesson11; Owner: postgres
--

CREATE SEQUENCE javalesson11.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE javalesson11.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: javalesson11; Owner: postgres
--

ALTER SEQUENCE javalesson11.products_id_seq OWNED BY javalesson11.products.id;


--
-- Name: purchases; Type: TABLE; Schema: javalesson11; Owner: postgres
--

CREATE TABLE javalesson11.purchases (
    person_id bigint,
    product_id bigint,
    purchased timestamp without time zone,
    id integer NOT NULL,
    price double precision
);


ALTER TABLE javalesson11.purchases OWNER TO postgres;

--
-- Name: purchases_id_seq; Type: SEQUENCE; Schema: javalesson11; Owner: postgres
--

CREATE SEQUENCE javalesson11.purchases_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE javalesson11.purchases_id_seq OWNER TO postgres;

--
-- Name: purchases_id_seq; Type: SEQUENCE OWNED BY; Schema: javalesson11; Owner: postgres
--

ALTER SEQUENCE javalesson11.purchases_id_seq OWNED BY javalesson11.purchases.id;


--
-- Name: person id; Type: DEFAULT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.person ALTER COLUMN id SET DEFAULT nextval('javalesson11.person_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.products ALTER COLUMN id SET DEFAULT nextval('javalesson11.products_id_seq'::regclass);


--
-- Name: purchases id; Type: DEFAULT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.purchases ALTER COLUMN id SET DEFAULT nextval('javalesson11.purchases_id_seq'::regclass);


--
-- Data for Name: person; Type: TABLE DATA; Schema: javalesson11; Owner: postgres
--

COPY javalesson11.person (id, name) FROM stdin;
2	max
3	nikita
4	alexey
5	evgeniy
\.


--
-- Data for Name: products; Type: TABLE DATA; Schema: javalesson11; Owner: postgres
--

COPY javalesson11.products (id, name, price) FROM stdin;
3	pineapple	150
2	orange	100
5	apple	85
\.


--
-- Data for Name: purchases; Type: TABLE DATA; Schema: javalesson11; Owner: postgres
--

COPY javalesson11.purchases (person_id, product_id, purchased, id, price) FROM stdin;
5	5	2023-03-23 14:21:48.809366	6	75
5	5	2023-03-23 14:21:56.820702	7	75
5	5	2023-03-23 14:22:31.981266	8	85
\.


--
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: javalesson11; Owner: postgres
--

SELECT pg_catalog.setval('javalesson11.person_id_seq', 5, true);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: javalesson11; Owner: postgres
--

SELECT pg_catalog.setval('javalesson11.products_id_seq', 5, true);


--
-- Name: purchases_id_seq; Type: SEQUENCE SET; Schema: javalesson11; Owner: postgres
--

SELECT pg_catalog.setval('javalesson11.purchases_id_seq', 8, true);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: purchases purchases_pkey; Type: CONSTRAINT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.purchases
    ADD CONSTRAINT purchases_pkey PRIMARY KEY (id);


--
-- Name: purchases purchases_person_id_fkey; Type: FK CONSTRAINT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.purchases
    ADD CONSTRAINT purchases_person_id_fkey FOREIGN KEY (person_id) REFERENCES javalesson11.person(id);


--
-- Name: purchases purchases_product_id_fkey; Type: FK CONSTRAINT; Schema: javalesson11; Owner: postgres
--

ALTER TABLE ONLY javalesson11.purchases
    ADD CONSTRAINT purchases_product_id_fkey FOREIGN KEY (product_id) REFERENCES javalesson11.products(id);


--
-- PostgreSQL database dump complete
--

