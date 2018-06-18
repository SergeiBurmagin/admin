CREATE TABLE ugddb.tests.user_auth(
  user_id varchar(40) NOT NULL,
  auth_type varchar(30) NOT NULL,
  login varchar(200),
  password varchar(200),
  role varchar(100),
  enabled boolean DEFAULT true,
  ext_guid varchar(500),
  CONSTRAINT user_auth_pk PRIMARY KEY (user_id,auth_type)

);
-- ddl-end --
COMMENT ON TABLE ugddb.tests.user_auth IS 'Данные для авторизации';
-- ddl-end --
COMMENT ON COLUMN ugddb.tests.user_auth.login IS 'логин';
-- ddl-end --
COMMENT ON COLUMN ugddb.tests.user_auth.password IS 'пароль';
-- ddl-end --
COMMENT ON COLUMN ugddb.tests.user_auth.enabled IS 'Авторизация разрешена';
-- ddl-end --
ALTER TABLE ugddb.tests.user_auth OWNER TO ugddb_user;
-- ddl-end --

CREATE UNIQUE INDEX user_auth_pk_idx ON ugddb.tests.user_auth
USING btree
(
  user_id ASC NULLS LAST,
  auth_type ASC NULLS LAST
);
-- ddl-end --
