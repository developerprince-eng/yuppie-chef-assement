CREATE TABLE IF NOT EXISTS contact (
   id bigint NOT NULL,
   email_address character varying(255),
   mobile character varying(16),
   telephone character varying(16),
   CONSTRAINT contact_pkey PRIMARY KEY (id)
);
