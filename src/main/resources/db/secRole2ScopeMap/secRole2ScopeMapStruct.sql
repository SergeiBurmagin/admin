CREATE TABLE ugddb.tests.sec_role_2_scope_map(
  scope_id varchar(60) NOT NULL,
  role_id varchar(60) NOT NULL,
  CONSTRAINT sec_role_2_scope_map_pk PRIMARY KEY (scope_id,role_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.sec_role_2_scope_map OWNER TO ugddb_user;
-- ddl-end --


CREATE UNIQUE INDEX sec_role_2_scope_map_pk_idx ON ugddb.tests.sec_role_2_scope_map
USING btree
(
  scope_id ASC NULLS LAST,
  role_id ASC NULLS LAST
);
-- ddl-end --
