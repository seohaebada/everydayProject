-- docker pull postgres
-- docker run -dp 5432:5432 --name postgresql -e POSTGRES_PASSWORD=1234 -v host-path:/var/lib/postgres/data postgres
-- docker exec -it postgresql /bin/bash
-- psql -U postgres
create database studyolledb;
create user everyuser with encrypted password '1234';
ALTER ROLE everyuser SUPERUSER;
-- grant all privileges on database everydaydb to everyuser;
GRANT ALL privileges ON SCHEMA public TO everyuser;