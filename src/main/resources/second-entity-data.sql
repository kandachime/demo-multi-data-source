-- ===========================================
-- DATABASE FOR PUBLISHER SYSTEM
-- ===========================================
-- BEGIN
--    EXECUTE IMMEDIATE 'DROP TABLE second_entity' || second_entity;
-- EXCEPTION
--    WHEN OTHERS THEN
--       IF SQLCODE != -942 THEN
--          RAISE;
--       END IF;
-- END;

-- create table second_entity
-- (
--   ID NUMBER(19),
--   NAME VARCHAR(255),
--   Primary key (ID)
-- );

insert into second_entity (ID, NAME)
values (1, 'second_entity 1');

insert into second_entity (ID, NAME)
values (2, 'second_entity 2');

Commit;