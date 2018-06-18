CREATE TABLE ugddb.tests.sec_user_2_role_map(
  user_id varchar(40) NOT NULL,
  role_id varchar(60) NOT NULL,
  CONSTRAINT sec_user_role_map_pk PRIMARY KEY (user_id,role_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.sec_user_2_role_map OWNER TO ugddb_user;
-- ddl-end --


CREATE UNIQUE INDEX sec_user_role_map_pk_idx ON ugddb.tests.sec_user_2_role_map
USING btree
(
  user_id ASC NULLS LAST,
  role_id ASC NULLS LAST
);
-- ddl-end --
