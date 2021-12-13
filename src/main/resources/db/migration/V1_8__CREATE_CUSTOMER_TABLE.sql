CREATE TABLE IF NOT EXISTS customer (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL ,
    last_name character varying(255) NOT NULL ,
    dob timestamp without time zone,
    address_id bigint,
    contact_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id),
    CONSTRAINT customer_address_fk FOREIGN KEY (address_id)
        REFERENCES address (id) MATCH SIMPLE,
    CONSTRAINT customer_contact_fk FOREIGN KEY (contact_id)
        REFERENCES contact (id) MATCH SIMPLE
);
