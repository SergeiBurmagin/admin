CREATE TABLE ugddb.tests.user_type_spr(
  user_type varchar(2) NOT NULL,
  type_name varchar(100) NOT NULL,
  CONSTRAINT user_type_spr_pk PRIMARY KEY (user_type)

);
-- ddl-end --
COMMENT ON TABLE ugddb.tests.user_type_spr IS 'Типы пользователей';
-- ddl-end --
COMMENT ON CONSTRAINT user_type_spr_pk ON users.user_type_spr  IS 'тип пользователя';
-- ddl-end --
ALTER TABLE ugddb.tests.user_type_spr OWNER TO ugddb_user;
-- ddl-end --


