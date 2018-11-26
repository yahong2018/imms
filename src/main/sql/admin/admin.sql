CREATE TABLE system_user
(
  user_id         VARCHAR(20)  NOT NULL,
  user_name       VARCHAR(50)  NOT NULL,
  pwd             VARCHAR(50)  NOT NULL,
  user_status     INT          NOT NULL,           -- 0.正常  1.已禁用
  email           VARCHAR(255) NOT NULL,
  online          BIT          NOT NULL DEFAULT 0, -- 0.离线  1.在线
  last_login_time DATETIME     NULL ,              -- 最后登录时间
  PRIMARY KEY (user_id)
);

CREATE TABLE system_role
(
  role_id   VARCHAR(20) NOT NULL,
  role_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (role_id)
);


CREATE TABLE role_user
(
  role_user_id INT AUTO_INCREMENT NOT NULL,
  role_id      VARCHAR(20)        NOT NULL,
  user_id      VARCHAR(20)        NOT NULL,
  PRIMARY KEY (role_user_id)
);


CREATE TABLE role_privilege
(
  role_privilege_id    INT AUTO_INCREMENT NOT NULL,
  program_privilege_id INT                NOT NULL,
  role_id              VARCHAR(20)        NOT NULL,
  program_id           VARCHAR(50)        NOT NULL,
  privilege_id         VARCHAR(50)        NOT NULL,
  PRIMARY KEY (role_privilege_id)
);


CREATE TABLE system_program
(
  program_id   VARCHAR(50)  NOT NULL,
  program_name VARCHAR(120) NOT NULL,
  url          VARCHAR(255) NOT NULL,
  glyph        VARCHAR(100) NULL,
  show_order   INT          NOT NULL,
  parameters   VARCHAR(255) NOT NULL,
  progress     INT          NOT NULL,
  parent       VARCHAR(50)  NOT NULL,
  PRIMARY KEY (program_id)
);

CREATE TABLE program_privilege
(
  program_privilege_id INT AUTO_INCREMENT NOT NULL,
  program_id           VARCHAR(50)        NOT NULL,
  privilege_id         VARCHAR(50)        NOT NULL,
  privilege_name       VARCHAR(120)       NOT NULL,
  PRIMARY KEY (program_privilege_id)
);





