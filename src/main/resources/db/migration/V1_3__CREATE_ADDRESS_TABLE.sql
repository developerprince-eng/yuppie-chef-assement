CREATE TABLE IF NOT EXISTS address (
    id bigint NOT NULL,
    street character varying(196) NOT NULL ,
    address_unit character varying(16) NOT NULL,
    zip_code character varying(8),
    CONSTRAINT address_pkey PRIMARY KEY (id)
);
