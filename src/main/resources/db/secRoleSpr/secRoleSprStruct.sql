CREATE TABLE ugddb.tests.sec_role_spr(
  role_id varchar(60) NOT NULL,
  role_name varchar(200) NOT NULL,
  CONSTRAINT sec_role_spr_pk PRIMARY KEY (role_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.sec_role_spr OWNER TO ugddb_user;
-- ddl-end --


CREATE UNIQUE INDEX sec_role_spr_pk_idx ON ugddb.tests.sec_role_spr
USING btree
(
  role_id ASC NULLS LAST
);
-- ddl-end --
