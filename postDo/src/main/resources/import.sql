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

INSERT INTO messages (message_content, message_date_time, mesage_subject, message_account, message_folder, contact_id, tag_id) VALUES ('Some content', 'date', 'Matematika 1', 1, 1, 1, 1);
INSERT INTO messages (message_content, message_date_time, mesage_subject, message_account, message_folder, contact_id, tag_id) VALUES ('More content', '2019-02-13 09:50:00', 'Osnove programiranja', 3, 2, 2, 3);
INSERT INTO messages (message_content, message_date_time, mesage_subject, message_account, message_folder, contact_id, tag_id) VALUES ('Stuffs...', '2019-02-13 09:50:00', 'Sistemski softver',2, 3, 2, 4);
INSERT INTO messages (message_content, message_date_time, mesage_subject, message_account, message_folder, contact_id, tag_id) VALUES ('Some more content', '2019-02-13 09:50:00', 'Matematika 2', 4, 4, 3, 4);

INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data1', 'base64', 'attachment1');
INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data2', 'base64', 'attachment2');
INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data3', 'base64', 'attachment3');
INSERT INTO attachments (attachment_data, attachment_type, attachment_name) VALUES ('data4', 'base64', 'attachment4');

--INSERT INTO admins (username, pasword) VALUES ('admin', 'admin');
--
--INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (NULL, 'Racunari', 'Razni racunari');
--INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (1, 'Laptop', 'Prenosni racunari');
--INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (1, 'Desktop', 'Prenosni ali teski racunari');
--INSERT INTO categories (parent_cat_id, cat_name, cat_desc) VALUES (1, 'Server', 'Tesko prenosni racunari');
--
--INSERT INTO suppliers (sup_name, sup_address) VALUES ('Zika trade', 'Bul. oslobodjenja 1');
--INSERT INTO suppliers (sup_name, sup_address) VALUES ('Zika computers', 'Bul. oslobodjenja 2');
--INSERT INTO suppliers (sup_name, sup_address) VALUES ('Zika soft', 'Bul. oslobodjenja 3');
--
--INSERT INTO products (category_id, supplier_id, prod_name, vendor, description, price) VALUES (2, 1, 'ThinkPad T61', 'IBM', 'opis', 1000);
--INSERT INTO products (category_id, supplier_id, prod_name, vendor, description, price) VALUES (2, 1, 'Compaq nx9010', 'HP', 'opis', 1200);
--INSERT INTO products (category_id, supplier_id, prod_name, vendor, description, price) VALUES (2, 1, 'Tecra S5', 'Toshiba', 'opis', 1100);
--
--INSERT INTO users (username, pasword, first_name, last_name, user_address, email, receive_news) VALUES ('chenejac', 'chenejac', 'Dragan', 'Ivanovic', 'Fruskogorska 11', 'chenejac@uns.ac.rs', FALSE);
--INSERT INTO users (username, pasword, first_name, last_name, user_address, email, receive_news) VALUES ('minja', 'minja', 'Milan', 'Vidakovic', 'Fruskogorska 11', 'minja@uns.ac.rs', FALSE);