-- ===========================================
-- DATABASE FOR ADVERTISERS SYSTEM
-- ===========================================
-- create table
create table first_entity
(
  ID NUMBER(19),
  NAME VARCHAR(255),
  Primary key (ID)
);

-- create data
insert into first_entity (ID, NAME)
values (1, 'first_entity 1');

insert into first_entity (ID, NAME)
values (2, 'first_entity 2');

-- create stored procedure
CREATE OR REPLACE PROCEDURE count_first_entity_by_id (
   id_to_count IN NUMBER,
   commentCount OUT NUMBER )
AS
BEGIN
    SELECT COUNT(*) INTO commentCount
    FROM first_entity
    WHERE id = id_to_count;
END;

Commit;