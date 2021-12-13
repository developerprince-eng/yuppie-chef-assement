ALTER TABLE review
    ADD COLUMN store_id BIGINT,
    ADD CONSTRAINT review_store_fk FOREIGN KEY (store_id)
        REFERENCES store(id) MATCH SIMPLE;