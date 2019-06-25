INSERT INTO photos(photo_path, photo_contact) VALUES ('bart.jpg', 1);
INSERT INTO photos(photo_path, photo_contact) VALUES ('mickeymouse.jpg', 2);
INSERT INTO photos(photo_path, photo_contact) VALUES ('pikachu.jpg', 3);
INSERT INTO photos(photo_path, photo_contact) VALUES ('spongebob.jpg', 4);

INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo, contact_user) VALUES ('Pera', 'Peric', 'pex', 'pexpex@gmail.com', 0, 1, 1);
INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo, contact_user) VALUES ('Djura', 'Dobric', 'djux', 'djux@gmail.com', 1, 2, 1);
INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo, contact_user) VALUES ('Srdjan', 'Nikolic', 'srki123', 'srki123@gmail.com', 1, 3, 2);
INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo, contact_user) VALUES ('Milos', 'Dostojic', 'knjaz223', 'knjaz223@gmail.com', 0, 4, 3);


INSERT INTO rules (rule_condition, rule_operation, rule_folder) VALUES (1, 0, 3);
INSERT INTO rules (rule_condition, rule_operation, rule_folder) VALUES (2, 1, 5);
INSERT INTO rules (rule_condition, rule_operation, rule_folder) VALUES (3, 2, 1);

INSERT INTO folders (folder_name, subfolder_id, folder_account) VALUES ('Drafts', NULL, 1);
INSERT INTO folders (folder_name, subfolder_id, folder_account) VALUES ('Trash', NULL, 2);
INSERT INTO folders (folder_name, subfolder_id, folder_account) VALUES ('Promotions', NULL, 3);
INSERT INTO folders (folder_name, subfolder_id, folder_account) VALUES ('Electronics', 3, 2);
INSERT INTO folders (folder_name, subfolder_id, folder_account) VALUES ('Recent promotions', 3, 3);

INSERT INTO accounts (acc_smtp_address, acc_smtp_port, acc_inserver_type, acc_inserver_address, acc_inserver_port, acc_username, acc_password, acc_displayname, acc_user) VALUES ('smpt1', 8080, 3, 'pop3', 3306, 'user', 'user', 'userWho', 1);
INSERT INTO accounts (acc_smtp_address, acc_smtp_port, acc_inserver_type, acc_inserver_address, acc_inserver_port, acc_username, acc_password, acc_displayname, acc_user) VALUES ('smpt1', 8083, 7, 'pop3', 3307, 'u', 'u', 'tarzan', 2);
INSERT INTO accounts (acc_smtp_address, acc_smtp_port, acc_inserver_type, acc_inserver_address, acc_inserver_port, acc_username, acc_password, acc_displayname, acc_user) VALUES ('smpt1', 8086, 2, 'pop3', 3308, 'macak', 'dzeri', 'dzeriTheMacak', 1);
INSERT INTO accounts (acc_smtp_address, acc_smtp_port, acc_inserver_type, acc_inserver_address, acc_inserver_port, acc_username, acc_password, acc_displayname, acc_user) VALUES ('smpt1', 8089, 3, 'pop3', 3309, 'vafl', 'dog', 'dogVafl', 3);


INSERT INTO attachments (attachment_data, attachment_type, attachment_name, attachment_message) VALUES ('data1', 'base64', 'attachment1', 1);
INSERT INTO attachments (attachment_data, attachment_type, attachment_name, attachment_message) VALUES ('data2', 'base64', 'attachment2', 2);
INSERT INTO attachments (attachment_data, attachment_type, attachment_name, attachment_message) VALUES ('data3', 'base64', 'attachment3', 2);
INSERT INTO attachments (attachment_data, attachment_type, attachment_name, attachment_message) VALUES ('data4', 'base64', 'attachment4', 3);

INSERT INTO users(username, password, firstname,lastname) VALUES ('user', 'user', 'miki', 'maus');
INSERT INTO users(username, password, firstname,lastname) VALUES ('aco', 'a', 'aco', 'budic');
INSERT INTO users(username, password, firstname,lastname) VALUES ('pikacu', 'p', 'pikacu', 'pika');

INSERT INTO messages (message_content, message_date_time, message_subject, message_read, message_account, message_folder, contact_id) VALUES ('Some content', '2019-02-06 22:50:00', 'Matematika 1', true, 1, 1, 1);
INSERT INTO messages (message_content, message_date_time, message_subject, message_read, message_account, message_folder, contact_id) VALUES ('More content', '2019-02-13 13:00:00', 'Osnove programiranja', false, 3, 2, 2);
INSERT INTO messages (message_content, message_date_time, message_subject, message_read, message_account, message_folder, contact_id) VALUES ('Stuffs...', '2019-12-23 08:50:00', 'Sistemski softver', false, 2, 3, 2);
INSERT INTO messages (message_content, message_date_time, message_subject, message_read,  message_account, message_folder, contact_id) VALUES ('Some more content', '2019-06-33 09:50:00', 'Matematika 2', true, 4, 4, 3);

INSERT INTO tags (tag_name, tag_user) VALUES ('#urgent', 2);
INSERT INTO tags (tag_name, tag_user) VALUES ('#important', 3);
INSERT INTO tags (tag_name, tag_user) VALUES ('#reminder', 1);
INSERT INTO tags (tag_name, tag_user) VALUES ('#dofast',1);

--INSERT INTO AUTHORITY (name) VALUES ('ROLE_USER');
--INSERT INTO AUTHORITY (name) VALUES ('ROLE_ADMIN');
--
--INSERT INTO USER_AUTHORITY (u_id, a_id) VALUES (1, 1);
--INSERT INTO USER_AUTHORITY (u_id, a_id) VALUES (2, 1);
--INSERT INTO USER_AUTHORITY (u_id, a_id) VALUES (2, 2);
