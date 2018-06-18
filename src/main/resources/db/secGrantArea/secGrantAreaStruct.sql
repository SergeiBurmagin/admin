-- object: users.sec_grant_area | type: TABLE --
-- DROP TABLE IF EXISTS users.sec_grant_area CASCADE;
CREATE TABLE ugddb.tests.sec_grant_area(
  grant_area_id varchar(100) NOT NULL,
  grant_area_name varchar(200) NOT NULL,
  CONSTRAINT sec_grant_area_pk PRIMARY KEY (grant_area_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.sec_grant_area OWNER TO ugddb_user;
-- ddl-end --

CREATE UNIQUE INDEX sec_grant_area_pk_idx ON ugddb.tests.sec_grant_area
USING btree
(
  grant_area_id ASC NULLS LAST
);
-- ddl-end --

