CREATE TABLE ugddb.tests.users
(
  user_id    VARCHAR(40) NOT NULL
    CONSTRAINT user_pk
    PRIMARY KEY,
  user_type  VARCHAR(2)  NOT NULL,
  dep_id     SMALLINT,
  family     VARCHAR(100),
  name       VARCHAR(100),
  patronymic VARCHAR(100),
  json_data  JSONB
);

CREATE UNIQUE INDEX users_pk_idx
  ON ugddb.tests.users (user_id);

COMMENT ON TABLE ugddb.tests.users IS 'Пользователи системы';

COMMENT ON COLUMN ugddb.tests.users.user_type IS 'Тип пользователя';

