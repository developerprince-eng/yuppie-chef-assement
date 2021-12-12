CREATE TABLE IF NOT EXISTS user_store (
    id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    role_id bigint,
    address_id bigint,
    contact_id bigint,
    CONSTRAINT user_pkey PRIMARY KEY (id),
    CONSTRAINT user_role_fk FOREIGN KEY (role_id)
        REFERENCES user_role (id) MATCH SIMPLE,
    CONSTRAINT user_address_fk FOREIGN KEY (address_id)
        REFERENCES address (id) MATCH SIMPLE,
    CONSTRAINT user_contact_fk FOREIGN KEY (contact_id)
        REFERENCES contact (id) MATCH SIMPLE
);
