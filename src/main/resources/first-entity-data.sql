-- ===========================================
-- DATABASE FOR ADVERTISERS SYSTEM
-- ===========================================
-- BEGIN
--    EXECUTE IMMEDIATE 'DROP TABLE first_entity' || first_entity;
-- EXCEPTION
--    WHEN OTHERS THEN
--       IF SQLCODE != -942 THEN
--          RAISE;
--       END IF;
-- END;

-- create table first_entity
-- (
--   ID NUMBER(19),
--   NAME VARCHAR(255),
--   Primary key (ID)
-- );

insert into first_entity (ID, NAME)
values (1, 'first_entity 1');

insert into first_entity (ID, NAME)
values (2, 'first_entity 2');

Commit;