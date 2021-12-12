CREATE TABLE IF NOT EXISTS review (
    id bigint NOT NULL,
    description TEXT ,
    rating SMALLINT,
    customer_id bigint,
    CONSTRAINT review_pk PRIMARY KEY (id),
    CONSTRAINT customer_review_fk FOREIGN KEY (customer_id)
        REFERENCES customer (id) MATCH SIMPLE
);
