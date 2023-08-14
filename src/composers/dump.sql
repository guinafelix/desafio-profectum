--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3 (Debian 15.3-1.pgdg120+1)
-- Dumped by pg_dump version 15.3 (Debian 15.3-1.pgdg120+1)

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: oferta_disciplina; Type: TABLE; Schema: public; Owner: guinafelix
--

CREATE TABLE public.oferta_disciplina (
    oferta_id bigint NOT NULL,
    disciplina_id bigint NOT NULL
);


ALTER TABLE public.oferta_disciplina OWNER TO guinafelix;

--
-- Name: tb_curso; Type: TABLE; Schema: public; Owner: guinafelix
--

CREATE TABLE public.tb_curso (
    id bigint NOT NULL,
    duracao_em_semestres integer NOT NULL,
    nome character varying(255)
);


ALTER TABLE public.tb_curso OWNER TO guinafelix;

--
-- Name: tb_curso_seq; Type: SEQUENCE; Schema: public; Owner: guinafelix
--

CREATE SEQUENCE public.tb_curso_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_curso_seq OWNER TO guinafelix;

--
-- Name: tb_disciplina; Type: TABLE; Schema: public; Owner: guinafelix
--

CREATE TABLE public.tb_disciplina (
    id bigint NOT NULL,
    carga_horaria integer NOT NULL,
    nome character varying(255)
);


ALTER TABLE public.tb_disciplina OWNER TO guinafelix;

--
-- Name: tb_disciplina_seq; Type: SEQUENCE; Schema: public; Owner: guinafelix
--

CREATE SEQUENCE public.tb_disciplina_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_disciplina_seq OWNER TO guinafelix;

--
-- Name: tb_oferta; Type: TABLE; Schema: public; Owner: guinafelix
--

CREATE TABLE public.tb_oferta (
    id bigint NOT NULL,
    semestre integer NOT NULL,
    curso_id bigint
);


ALTER TABLE public.tb_oferta OWNER TO guinafelix;

--
-- Name: tb_oferta_seq; Type: SEQUENCE; Schema: public; Owner: guinafelix
--

CREATE SEQUENCE public.tb_oferta_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_oferta_seq OWNER TO guinafelix;

--
-- Name: tb_perfil; Type: TABLE; Schema: public; Owner: guinafelix
--

CREATE TABLE public.tb_perfil (
    id bigint NOT NULL,
    nome character varying(255)
);


ALTER TABLE public.tb_perfil OWNER TO guinafelix;

--
-- Name: tb_perfil_seq; Type: SEQUENCE; Schema: public; Owner: guinafelix
--

CREATE SEQUENCE public.tb_perfil_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_perfil_seq OWNER TO guinafelix;

--
-- Name: tb_produto_seq; Type: SEQUENCE; Schema: public; Owner: guinafelix
--

CREATE SEQUENCE public.tb_produto_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_produto_seq OWNER TO guinafelix;

--
-- Name: tb_usuario; Type: TABLE; Schema: public; Owner: guinafelix
--

CREATE TABLE public.tb_usuario (
    id bigint NOT NULL,
    matricula character varying(255),
    nome character varying(255),
    senha character varying(255),
    curso_id bigint,
    perfil_id bigint
);


ALTER TABLE public.tb_usuario OWNER TO guinafelix;

--
-- Name: tb_usuario_seq; Type: SEQUENCE; Schema: public; Owner: guinafelix
--

CREATE SEQUENCE public.tb_usuario_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_usuario_seq OWNER TO guinafelix;

--
-- Data for Name: oferta_disciplina; Type: TABLE DATA; Schema: public; Owner: guinafelix
--

COPY public.oferta_disciplina (oferta_id, disciplina_id) FROM stdin;
1002	353
1002	352
1003	402
1052	352
1053	402
\.


--
-- Data for Name: tb_curso; Type: TABLE DATA; Schema: public; Owner: guinafelix
--

COPY public.tb_curso (id, duracao_em_semestres, nome) FROM stdin;
352	8	ciencia da computacao
402	10	engenharia civil
\.


--
-- Data for Name: tb_disciplina; Type: TABLE DATA; Schema: public; Owner: guinafelix
--

COPY public.tb_disciplina (id, carga_horaria, nome) FROM stdin;
352	80	Fisica 1
353	80	Fisica 3
402	80	Grafos
452	80	Análise de Algoritmos
502	80	Redes de Computadores I
552	40	Educação Física
553	80	Matemática Discreta
\.


--
-- Data for Name: tb_oferta; Type: TABLE DATA; Schema: public; Owner: guinafelix
--

COPY public.tb_oferta (id, semestre, curso_id) FROM stdin;
853	4	\N
854	4	\N
902	2	\N
952	7	\N
1002	7	352
1003	5	352
1052	1	402
1053	2	402
\.


--
-- Data for Name: tb_perfil; Type: TABLE DATA; Schema: public; Owner: guinafelix
--

COPY public.tb_perfil (id, nome) FROM stdin;
152	admin
202	aluno
252	professor
302	coordenador de curso
352	Diretor
\.


--
-- Data for Name: tb_usuario; Type: TABLE DATA; Schema: public; Owner: guinafelix
--

COPY public.tb_usuario (id, matricula, nome, senha, curso_id, perfil_id) FROM stdin;
252	\N	aluno2	$2a$10$tx4wY8Y31ut1YZYI3HNSRuIJ0yOU76dvJxFPRQCME4bkT37wKOD1C	\N	202
302	user3	user3	$2a$10$gTIdkIlaZrI3jE3NEaHUSekuT6KoG0VkMRD/N89zM3YY.rdzqLlcq	\N	252
303		user4	$2a$10$1AzKKBe6lBgqZIGRT4sXCem.QwvnbI8gDdZue0idPk8VqL53FsUxu	402	202
152	20	admin	$2a$10$Vj38PG4eivO6QN8.tr0iVu7MDKcTM0b6.yMylK6oJQ8IpUmS8vVS.	352	152
202	55	aluno 2023	$2a$10$ntbhq2qQVIDkaV7lCQd39ePkelgFL4rgNm8fkTB7KiwATm521ge5C	352	252
\.


--
-- Name: tb_curso_seq; Type: SEQUENCE SET; Schema: public; Owner: guinafelix
--

SELECT pg_catalog.setval('public.tb_curso_seq', 451, true);


--
-- Name: tb_disciplina_seq; Type: SEQUENCE SET; Schema: public; Owner: guinafelix
--

SELECT pg_catalog.setval('public.tb_disciplina_seq', 601, true);


--
-- Name: tb_oferta_seq; Type: SEQUENCE SET; Schema: public; Owner: guinafelix
--

SELECT pg_catalog.setval('public.tb_oferta_seq', 1101, true);


--
-- Name: tb_perfil_seq; Type: SEQUENCE SET; Schema: public; Owner: guinafelix
--

SELECT pg_catalog.setval('public.tb_perfil_seq', 401, true);


--
-- Name: tb_produto_seq; Type: SEQUENCE SET; Schema: public; Owner: guinafelix
--

SELECT pg_catalog.setval('public.tb_produto_seq', 1, false);


--
-- Name: tb_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: guinafelix
--

SELECT pg_catalog.setval('public.tb_usuario_seq', 351, true);


--
-- Name: tb_curso tb_curso_pkey; Type: CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_curso
    ADD CONSTRAINT tb_curso_pkey PRIMARY KEY (id);


--
-- Name: tb_disciplina tb_disciplina_pkey; Type: CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_disciplina
    ADD CONSTRAINT tb_disciplina_pkey PRIMARY KEY (id);


--
-- Name: tb_oferta tb_oferta_pkey; Type: CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_oferta
    ADD CONSTRAINT tb_oferta_pkey PRIMARY KEY (id);


--
-- Name: tb_perfil tb_perfil_pkey; Type: CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_perfil
    ADD CONSTRAINT tb_perfil_pkey PRIMARY KEY (id);


--
-- Name: tb_usuario tb_usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT tb_usuario_pkey PRIMARY KEY (id);


--
-- Name: oferta_disciplina fk2acaha03i33fn2ub4fjfmbqr7; Type: FK CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.oferta_disciplina
    ADD CONSTRAINT fk2acaha03i33fn2ub4fjfmbqr7 FOREIGN KEY (disciplina_id) REFERENCES public.tb_disciplina(id);


--
-- Name: tb_usuario fk49avuiu7e76c5xiivsek3yut4; Type: FK CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT fk49avuiu7e76c5xiivsek3yut4 FOREIGN KEY (perfil_id) REFERENCES public.tb_perfil(id);


--
-- Name: tb_usuario fkftxtll81i3kcpyo38a2oel6vv; Type: FK CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_usuario
    ADD CONSTRAINT fkftxtll81i3kcpyo38a2oel6vv FOREIGN KEY (curso_id) REFERENCES public.tb_curso(id);


--
-- Name: tb_oferta fkghio9phs4jdjvk02yvtigkf3l; Type: FK CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.tb_oferta
    ADD CONSTRAINT fkghio9phs4jdjvk02yvtigkf3l FOREIGN KEY (curso_id) REFERENCES public.tb_curso(id);


--
-- Name: oferta_disciplina fkjns9cu9d9yyuw8j96qcx6ivh2; Type: FK CONSTRAINT; Schema: public; Owner: guinafelix
--

ALTER TABLE ONLY public.oferta_disciplina
    ADD CONSTRAINT fkjns9cu9d9yyuw8j96qcx6ivh2 FOREIGN KEY (oferta_id) REFERENCES public.tb_oferta(id);


--
-- PostgreSQL database dump complete
--

