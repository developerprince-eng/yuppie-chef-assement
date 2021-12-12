CREATE TABLE IF NOT EXISTS product (
    id bigint NOT NULL,
    name character varying(255) NOT NULL ,
    dimensions character varying(64),
    model_type character varying(196),
    image_url TEXT,
    weight character varying(32),
    color character varying(196),
    category_id bigint,
    review_id bigint,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT product_category_fk FOREIGN KEY (category_id)
        REFERENCES category (id) MATCH SIMPLE,
    CONSTRAINT review_product_fk FOREIGN KEY (review_id)
        REFERENCES review (id) MATCH SIMPLE
);
