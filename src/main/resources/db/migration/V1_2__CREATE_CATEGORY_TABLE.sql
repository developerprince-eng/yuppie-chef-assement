CREATE TABLE IF NOT EXISTS category (
    id bigint NOT NULL,
    name character varying(196) NOT NULL ,
    description TEXT,
    CONSTRAINT category_pkey PRIMARY KEY (id)
);
