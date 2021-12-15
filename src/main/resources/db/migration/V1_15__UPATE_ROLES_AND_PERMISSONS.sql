insert INTO permission(id, name) VALUES (1, 'read');
insert INTO permission(id, name) VALUES (2, 'write');
insert INTO permission(id, name) VALUES (3, 'delete');
insert INTO permission(id, name) VALUES (4, 'update');

insert INTO user_role(id, name, permission_id) VALUES (1, 'manager', 1);
UPDATE user_role SET permission_id = 2 WHERE id = 1;
UPDATE user_role SET permission_id = 3 WHERE id = 1;
UPDATE user_role SET permission_id = 4 WHERE id = 1;
insert INTO user_role(id, name, permission_id) VALUES (2, 'sales_man', 2);
UPDATE user_role SET permission_id = 2 WHERE id = 2;
