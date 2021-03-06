PGDMP         "                w           profile_storage    9.6.4    10.4     Y           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            Z           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            [           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            \           1262    24985    profile_storage    DATABASE     �   CREATE DATABASE profile_storage WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Ukraine.1251' LC_CTYPE = 'Russian_Ukraine.1251';
    DROP DATABASE profile_storage;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ]           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            ^           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24991    profile_access_info_seq    SEQUENCE     �   CREATE SEQUENCE public.profile_access_info_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.profile_access_info_seq;
       public       postgres    false    3            �            1259    25017    profiles_access_info    TABLE     A  CREATE TABLE public.profiles_access_info (
    id bigint DEFAULT nextval('public.profile_access_info_seq'::regclass) NOT NULL,
    nickname character varying(65),
    access_key character varying(257) NOT NULL,
    global_access_flag smallint NOT NULL,
    edit_flag boolean NOT NULL,
    remove_flag boolean NOT NULL
);
 (   DROP TABLE public.profiles_access_info;
       public         postgres    false    185    3            �            1259    24999    profiles_table_seq    SEQUENCE     {   CREATE SEQUENCE public.profiles_table_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.profiles_table_seq;
       public       postgres    false    3            �            1259    25011    profiles_table    TABLE     G  CREATE TABLE public.profiles_table (
    id bigint DEFAULT nextval('public.profiles_table_seq'::regclass) NOT NULL,
    access_info bigint NOT NULL,
    username character varying(32),
    surname character varying(32),
    patronymic character varying(32),
    email character varying(32),
    age integer,
    photo bytea
);
 "   DROP TABLE public.profiles_table;
       public         postgres    false    186    3            V          0    25017    profiles_access_info 
   TABLE DATA               t   COPY public.profiles_access_info (id, nickname, access_key, global_access_flag, edit_flag, remove_flag) FROM stdin;
    public       postgres    false    188   	       U          0    25011    profiles_table 
   TABLE DATA               k   COPY public.profiles_table (id, access_info, username, surname, patronymic, email, age, photo) FROM stdin;
    public       postgres    false    187   >       _           0    0    profile_access_info_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.profile_access_info_seq', 4, true);
            public       postgres    false    185            `           0    0    profiles_table_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.profiles_table_seq', 4, true);
            public       postgres    false    186            �           2606    25022 .   profiles_access_info profiles_access_info_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.profiles_access_info
    ADD CONSTRAINT profiles_access_info_pkey PRIMARY KEY (id);
 X   ALTER TABLE ONLY public.profiles_access_info DROP CONSTRAINT profiles_access_info_pkey;
       public         postgres    false    188            �           2606    25016 "   profiles_table profiles_table_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.profiles_table
    ADD CONSTRAINT profiles_table_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.profiles_table DROP CONSTRAINT profiles_table_pkey;
       public         postgres    false    187            V   %  x���vB`  ���:�8D1oIT��P��f�҇|��t�{Q6�Y>S������4�Wdx�d#��~'%�7|�L�<�;�z]1���U,[�pYc��}jl�s����&����7�1�P�5��{�_�Qc0dmN5.�n�l]�ܺRu_�~B:K��k�a֦�Z!�6�w��=�,����>��_`�_3W�L �2�z��U������陊%���"*�LVN+�hp�f���5�%>�";��ybF�y�~�.||u�.I$�'h�������1�	ũ��D �C�(�̣^�      U   B   x�3�4�,I-.	-N-�K�Ms�K�Ē������d0�5713���K��崴�������� �#E     