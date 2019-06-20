INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo) VALUES ('Pera', 'Peric', 'pex', 'pexpex@gmail.com', 0, 1);
INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo) VALUES ('Djura', 'Dobric', 'djux', 'djux@gmail.com', 1, 2);
INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo) VALUES ('Srdjan', 'Nikolic', 'srki123', 'srki123@gmail.com', 1, 3);
INSERT INTO contacts (contact_firstname, contact_lastname, contact_display, contact_email, contact_format, contact_photo) VALUES ('Milos', 'Dostojic', 'knjaz223', 'knjaz223@gmail.com', 0, 4);

INSERT INTO tags (tag_name) VALUES ('First Tag');
INSERT INTO tags (tag_name) VALUES ('Second Tag');
INSERT INTO tags (tag_name) VALUES ('Third Tag');
INSERT INTO tags (tag_name) VALUES ('Fourth Tag');

INSERT INTO rules (rule_condition, rule_operation) VALUES (1, 0);
INSERT INTO rules (rule_condition, rule_operation) VALUES (2, 1);
INSERT INTO rules (rule_condition, rule_operation) VALUES (3, 2);

INSERT INTO folders (folder_name, folder_rule) VALUES ('Drafts', 1);
INSERT INTO folders (folder_name, folder_rule) VALUES ('Trash', 2);
INSERT INTO folders (folder_name, folder_rule) VALUES ('Promotions', 3);
INSERT INTO folders (folder_name, folder_rule) VALUES ('Electronics', 2);
INSERT INTO folders (folder_name, folder_rule) VALUES ('Recent promotions', 3);

INSERT INTO accounts (acc_smtp, acc_pop3_imap, acc_username, acc_password) VALUES ('smpt1', 'pop3', 'user', 'user');
INSERT INTO accounts (acc_smtp, acc_pop3_imap, acc_username, acc_password) VALUES ('smpt1', 'pop3', 'u', 'u');
INSERT INTO accounts (acc_smtp, acc_pop3_imap, acc_username, acc_password) VALUES ('smpt1', 'pop3', 'user', 'user');
INSERT INTO accounts (acc_smtp, acc_pop3_imap, acc_username, acc_password) VALUES ('smpt1', 'pop3', 'user', 'user');


INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data1', 'base64', 'attachment1');
INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data2', 'base64', 'attachment2');
INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data3', 'base64', 'attachment3');
INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data4', 'base64', 'attachment4');

INSERT INTO users(username, password, firstname, lastname) VALUES ('miki@gmail.com', 'm', 'miki', 'maus');
INSERT INTO users(username, password, firstname, lastname) VALUES ('aco@gmail.com', 'a', 'aco', 'budic');
INSERT INTO users(username, password, firstname, lastname) VALUES ('pikacu@gmail.com', 'p', 'pikacu', 'pika');

INSERT INTO messages (message_content, message_date_time, message_subject, message_account, message_folder, contact_id, tag_id) VALUES ('Some content', 'date', 'Matematika 1', 1, 1, 1, 1);
INSERT INTO messages (message_content, message_date_time, message_subject, message_account, message_folder, contact_id, tag_id) VALUES ('More content', '2019-02-13 09:50:00', 'Osnove programiranja', 3, 2, 2, 3);
INSERT INTO messages (message_content, message_date_time, message_subject, message_account, message_folder, contact_id, tag_id) VALUES ('Stuffs...', '2019-02-13 09:50:00', 'Sistemski softver',2, 3, 2, 4);
INSERT INTO messages (message_content, message_date_time, message_subject, message_account, message_folder, contact_id, tag_id) VALUES ('Some more content', '2019-02-13 09:50:00', 'Matematika 2', 4, 4, 3, 4);
