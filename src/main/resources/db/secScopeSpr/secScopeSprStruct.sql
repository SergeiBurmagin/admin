CREATE TABLE ugddb.tests.sec_scope_spr(
  scope_id varchar(60) NOT NULL,
  scope_name varchar(100) NOT NULL,
  CONSTRAINT sec_scope_pk PRIMARY KEY (scope_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.sec_scope_spr OWNER TO ugddb_user;
-- ddl-end --


CREATE UNIQUE INDEX sec_scope_pk_idx ON ugddb.tests.sec_scope_spr
USING btree
(
  scope_id ASC NULLS LAST
);
-- ddl-end --
