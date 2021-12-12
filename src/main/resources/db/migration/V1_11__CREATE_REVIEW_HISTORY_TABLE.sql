CREATE TABLE IF NOT EXISTS review_history (
    customer_id bigint NOT NULL,
    review_id bigint NOT NULL ,
    reviewed_date timestamp without time zone ,
    CONSTRAINT review_history_pkey PRIMARY KEY (customer_id, review_id)
);
