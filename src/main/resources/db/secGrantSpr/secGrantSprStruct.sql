CREATE TABLE ugddb.tests.sec_grant_spr(
  grant_id smallint NOT NULL,
  grant_area_id varchar(100) NOT NULL,
  grant_name varchar(200),
  CONSTRAINT sec_grant_spr_pk PRIMARY KEY (grant_id)

);
-- ddl-end --
COMMENT ON COLUMN ugddb.tests.sec_grant_spr.grant_id IS 'ID гранта';
-- ddl-end --
ALTER TABLE ugddb.tests.sec_grant_spr OWNER TO ugddb_user;
-- ddl-end --


CREATE INDEX sec_grant_spr_pk_idx ON ugddb.tests.sec_grant_spr
USING btree
(
  grant_id ASC NULLS LAST
);
-- ddl-end --
