CREATE TABLE ugddb.tests.user_auth_type_spr(
  auth_type varchar(30) NOT NULL,
  auth_name varchar(200) NOT NULL,
  json_data jsonb,
  CONSTRAINT "AUTH_TYPE_SPR_PK" PRIMARY KEY (auth_type)

);
-- ddl-end --
COMMENT ON TABLE ugddb.tests.user_auth_type_spr IS 'Типы авторизации';
-- ddl-end --
ALTER TABLE ugddb.tests.user_auth_type_spr OWNER TO ugddb_user;
-- ddl-end --


CREATE UNIQUE INDEX auth_type_spr_pk_idx ON ugddb.tests.user_auth_type_spr
USING btree
(
  auth_type ASC NULLS LAST
);
-- ddl-end --
