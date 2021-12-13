ALTER TABLE product
    ADD COLUMN store_id BIGINT,
    ADD CONSTRAINT prodcut_store_fk FOREIGN KEY (store_id)
    REFERENCES store(id) MATCH SIMPLE;