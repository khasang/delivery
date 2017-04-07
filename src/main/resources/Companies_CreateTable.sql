DROP TABLE IF EXISTS public.companies CASCADE;

CREATE TABLE public.companies
(
    id BIGSERIAL NOT NULL,
    name character varying(255) NOT NULL,
    CONSTRAINT companies_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.companies
    OWNER to root;