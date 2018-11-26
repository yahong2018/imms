/*
UPDATE SystemUsers
SET pwd = 'e10adc3949ba59abbe56e057f20f883e'
*/

INSERT INTO system_user (user_id, user_name, pwd, user_status, email, last_login_time)
VALUES ('C00001', '刘永红', 'e10adc3949ba59abbe56e057f20f883e', 0, 'liuyonghong@zhxh.com', NULL);

INSERT INTO system_role (role_id, role_name) VALUES ('admin', '系统管理员');
INSERT INTO role_user (role_id, user_id) VALUES ('admin', 'C00001');

INSERT INTO system_program (program_id, program_name, url, show_order, parameters, progress, parent, glyph)
VALUES ('SYS01', '系统管理', '', 0, '', 0, 'SYS01', '0xf0c0');
INSERT INTO system_program (program_id, program_name, url, show_order, parameters, progress, parent, glyph)
VALUES ('SYS01_01', '用户管理', 'app.view.admin.systemUser.SystemUser', 0, '', 0, 'SYS01', '0xf007');
INSERT INTO system_program (program_id, program_name, url, show_order, parameters, progress, parent, glyph)
VALUES ('SYS01_02', '角色管理', 'app.view.admin.systemRole.SystemRole', 1, '', 0, 'SYS01', '0xf233');
INSERT INTO system_program (program_id, program_name, url, show_order, parameters, progress, parent, glyph)
VALUES ('SYS01_03', '系统参数', '/admin/systemParameters', 2, '', 0, 'SYS01', '');

INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'INSERT', '新增');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'UPDATE', '修改');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'DELETE', '删除');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'STOP_USER', '暂停账户');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'START_USER', '启用账户');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'RESET_PASSWORD', '重设密码');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_01', 'ASSIGN_ROLE', '授权');

INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_02', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_02', 'INSERT', '新增');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_02', 'UPDATE', '修改');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_02', 'DELETE', '删除');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_02', 'ASSIGN_ROLE', '授权');

INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_03', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_03', 'INSERT', '新增');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_03', 'UPDATE', '修改');
INSERT INTO program_privilege (program_id, privilege_id, privilege_name) VALUES ('SYS01_03', 'DELETE', '删除');
------------------------------------------------------------------------------------------------------------------------

INSERT INTO role_privilege (role_id, program_privilege_id, program_id, privilege_id)
  SELECT
    'admin' AS role_id,
    program_privilege_id,
    program_id,
    privilege_id
  FROM program_privilege
  WHERE program_privilege_id NOT IN (
    SELECT program_privilege_id
    FROM role_privilege
  )


