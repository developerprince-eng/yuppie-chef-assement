CREATE TABLE IF NOT EXISTS store (
    id bigint NOT NULL,
    name character varying(196) NOT NULL ,
    address_id bigint,
    CONSTRAINT store_pkey PRIMARY KEY (id),
    CONSTRAINT store_address_fk FOREIGN KEY (address_id)
        REFERENCES address (id) MATCH SIMPLE
);
