CREATE TABLE ugddb.tests.sec_user_2_scope_map(
  user_id varchar(40) NOT NULL,
  scope_id varchar(60) NOT NULL,
  CONSTRAINT sec_user_2_scope_map_pk PRIMARY KEY (user_id,scope_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.sec_user_2_scope_map OWNER TO ugddb_user;
-- ddl-end --

-- object: sec_user_2_scope_map_pk_idx | type: INDEX --
-- DROP INDEX IF EXISTS users.sec_user_2_scope_map_pk_idx CASCADE;
CREATE UNIQUE INDEX sec_user_2_scope_map_pk_idx ON ugddb.tests.sec_user_2_scope_map
USING btree
(
  user_id ASC NULLS LAST,
  scope_id ASC NULLS LAST
);
-- ddl-end --
