CREATE TABLE ugddb.tests.user_departments(
  dep_id smallint NOT NULL,
  department_name varchar(200) NOT NULL,
  CONSTRAINT user_departments_pk PRIMARY KEY (dep_id)

);
-- ddl-end --
ALTER TABLE ugddb.tests.user_departments OWNER TO ugddb_user;
-- ddl-end --

CREATE UNIQUE INDEX user_departments_pk_idx ON ugddb.tests.user_departments
USING btree
(
  dep_id ASC NULLS LAST
);
-- ddl-end --
