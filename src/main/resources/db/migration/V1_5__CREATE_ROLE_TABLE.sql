CREATE TABLE IF NOT EXISTS user_role (
   id bigint NOT NULL,
   name character varying(196) NOT NULL ,
   permission_id bigint,
   CONSTRAINT user_role_pkey PRIMARY KEY (id),
   CONSTRAINT permission_role_fk FOREIGN KEY (permission_id)
       REFERENCES permission (id) MATCH SIMPLE
);
