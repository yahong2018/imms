
set @user_id='ab081181-0b07-11e9-a12a-d481d7fe257a';
INSERT INTO system_user (record_id,user_code, user_name, pwd, user_status, email, last_login_time)
VALUES (@user_id, 'C00001', '刘永红', 'e10adc3949ba59abbe56e057f20f883e', 'ENABLED', 'liuyonghong@zhxh.com', NULL);

set @role_id = 'ab09582b-0b07-11e9-a12a-d481d7fe257a';
INSERT INTO system_role (record_id, role_code, role_name) VALUES (@role_id,'admin', '系统管理员');

set @role_user_id='ab0a167d-0b07-11e9-a12a-d481d7fe257a';
INSERT INTO role_user (record_id, role_id, user_id) VALUES (@role_user_id, @role_id, @user_id);

INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters,  parent, glyph) VALUES ('SYS01','SYS01', '系统管理', '', 0, '', 'SYS01', '0xf013');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters,  parent, glyph) VALUES ('SYS01_01','SYS01_01', '用户管理', 'app.view.admin.systemUser.SystemUser', 0, '', 'SYS01', '0xf007');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)  VALUES ('SYS01_02','SYS01_02', '角色管理', 'app.view.admin.systemRole.SystemRole', 1, '', 'SYS01', '0xf233');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)  VALUES ('SYS01_03','SYS01_03', '系统参数', 'app.view.admin.systemParameter.SystemParameter', 2, '','SYS01', '0xf085');

INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'STOP_USER', '暂停账户');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'START_USER', '启用账户');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'RESET_PASSWORD', '重设密码');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_01', 'ASSIGN_ROLE', '授权');

INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_02', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_02', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_02', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_02', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_02', 'ASSIGN_ROLE', '授权');

INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_03', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_03', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_03', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS01_03', 'DELETE', '删除');

-- ----------------------------------------------------------------------------------------------------------------------

INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)VALUES ('SYS02','SYS02', '工厂', '', 1, '', 'SYS02', '0xf1ad');
INSERT INTO program_privilege (record_id,program_code, privilege_code, privilege_name) VALUES (UUID(),'SYS02', 'PROGRAM_RUN', '系统运行');

INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph) VALUES ('SYS02_01', 'SYS02_01', '编码', '', 0, '',  'SYS02', '0xf029');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph) VALUES ('SYS02_01_01', 'SYS02_01_01', '尺码', 'app.view.imms.code.size.Size', 3, '', 'SYS02_01', '0xf0c9');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph) VALUES ('SYS02_01_02', 'SYS02_01_02', '缺陷代码', 'app.view.imms.code.defectCode.DefectCode',2, '', 'SYS02_01', '0xf002');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph) VALUES ('SYS02_01_03', 'SYS02_01_03', '设备类型', 'app.view.imms.code.machineType.MachineType', 3, '', 'SYS02_01', '0xf239');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph) VALUES ('SYS02_01_04', 'SYS02_01_04', '物料类型', 'app.view.imms.code.materialType.MaterialType', 4, '', 'SYS02_01', '0xf00b');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph) VALUES ('SYS02_01_05', 'SYS02_01_05', '物料单位', 'app.view.imms.code.uom.Uom', 5, '', 'SYS02_01', '0xf039');

INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_01', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_01', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_01', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_02', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_02', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_02', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_02', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_03', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_03', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_03', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_03', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_04', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_04', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_04', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_04', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_05', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_05', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_05', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_01_05', 'DELETE', '删除');

INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)VALUES ('SYS02_02','SYS02_02', '物料', '', 0, '',  'SYS02', '0xf187');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)VALUES ('SYS02_02_01','SYS02_02_01', '物料', 'app.view.imms.material.material.Material', 1, '', 'SYS02_02', '0xf187');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)VALUES ('SYS02_02_02','SYS02_02_02', 'BOM 单', 'app.view.imms.material.bomOrder.BomOrder', 2, '',  'SYS02_02', '0xf0e8');
INSERT INTO system_program (record_id,program_code, program_name, url, show_order, parameters, parent, glyph)VALUES ('SYS02_02_03','SYS02_02_03', 'BOM 项', 'app.view.imms.material.bom.Bom', 3, '', 'SYS02_02', '0xf2a1');

INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_01', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_01', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_01', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_01', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_02', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_02', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_02', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_02', 'DELETE', '删除');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_03', 'PROGRAM_RUN', '系统运行');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_03', 'INSERT', '新增');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_03', 'UPDATE', '修改');
INSERT INTO program_privilege (record_id,program_id, privilege_code, privilege_name) VALUES (UUID(),'SYS02_02_03', 'DELETE', '删除');

-- --------------------------------------------------------------------------------------------------------------------

set @role_id = 'ab09582b-0b07-11e9-a12a-d481d7fe257a';
INSERT INTO role_privilege (record_id, role_id, program_privilege_id, program_id, privilege_code)
  SELECT
    UUID(),
    @role_id,
    prv.record_id,
    prv.program_id,
    prv.privilege_code
  FROM program_privilege prv
  WHERE record_id NOT IN (
    SELECT record_id  FROM role_privilege
  )

-- --------------------------------------------------------------------------------------------------------------------

