CREATE TABLE IF NOT EXISTS store_user (
      store_id bigint NOT NULL,
      user_id bigint NOT NULL ,
      CONSTRAINT store_user_pkey PRIMARY KEY (store_id, user_id)
);
