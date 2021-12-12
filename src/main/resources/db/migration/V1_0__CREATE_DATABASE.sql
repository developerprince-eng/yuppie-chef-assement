SELECT 'CREATE DATABASE yuppie-chef-reviews'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'yuppie-chef-reviews');


