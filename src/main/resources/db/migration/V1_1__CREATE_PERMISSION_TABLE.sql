CREATE TABLE IF NOT EXISTS permission (
      id bigint NOT NULL,
      name character varying(255),
      CONSTRAINT permission_pkey PRIMARY KEY (id)
);
