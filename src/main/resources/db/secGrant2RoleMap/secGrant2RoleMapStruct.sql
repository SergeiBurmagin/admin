CREATE TABLE ugddb.tests.sec_grant_2_role_map(
  role_id varchar(60) NOT NULL,
  grant_id smallint NOT NULL,
  CONSTRAINT sec_grant_2_role_map_pk PRIMARY KEY (role_id,grant_id)

);
-- ddl-end --
COMMENT ON TABLE ugddb.tests.sec_grant_2_role_map IS 'Права (гранты) роли';
-- ddl-end --
ALTER TABLE ugddb.tests.sec_grant_2_role_map OWNER TO ugddb_user;
-- ddl-end --
