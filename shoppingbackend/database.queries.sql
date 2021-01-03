CREATE TABLE category (
	id int PRIMARY KEY AUTO_INCREMENT,
	code VARCHAR(50) unique,
	name varchar(50),
	description varchar(250),
	image_url varchar(100),
	is_active boolean
);

INSERT INTO category (name, code, description, image_url, is_active)VALUES("TV", "CATAZBFHIOPDERT", "TV Description", "tv.png", true);
INSERT INTO category (name, code, description, image_url, is_active)VALUES("Laptop", "CATAZJHGFMPETR", "Laptop Description", "Laptop.png", true);
INSERT INTO category (name, code, description, image_url, is_active)VALUES("Mobile", "CATAEDBNVCERRT", "Mobile Description", "Mobile.png", true);

CREATE TABLE user_detail (
	id int PRIMARY KEY AUTO_INCREMENT,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enable boolean,
	email VARCHAR(50),
	password VARCHAR(50),
	phone_number VARCHAR(50)
);

INSERT INTO user_detail(first_name, last_name, role, enable, email, password, phone_number) VALUES(
'Rachid', 'Assouani', 'ADMIN', true, 'rachid@gmail.com', '000', '0606060606');

INSERT INTO user_detail(first_name, last_name, role, enable, email, password, phone_number) VALUES(
'test', 'test', 'SUPPLIER', true, 'test@gmail.com', '000', '0606060606');

INSERT INTO user_detail(first_name, last_name, role, enable, email, password, phone_number) VALUES(
'test2', 'test2', 'SUPPLIER', true, 'test@gmail.com', '000', '0606060606');


CREATE TABLE product (
    id int PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(20),
    name VARCHAR(50),
    brand VARCHAR(50),
    description VARCHAR(255),
    price double,
    quantity int,
    is_active boolean,
    purchases int DEFAULT 0,
    views int DEFAULT 0,
    category_id int,
    supplier_id int,  

    CONSTRAINT fk_product_category FOREIGN KEY (category_id) REFERENCES category(id),
    CONSTRAINT fk_product_supplier FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
);

INSERT INTO product (code, name, brand, description, price, quantity, is_active, category_id, supplier_id ) VALUES(
'ABCKFKJHFKKF', 'iphone', 'apple', 'best phone ever', 1520, 20, true, 3, 2);

INSERT INTO product (code, name, brand, description, price, quantity, is_active, category_id, supplier_id ) VALUES(
'ABCKFKJHFK10', 'Mac Book', 'apple', 'best laptop ever', 15200000, 200, true, 2, 2);

INSERT INTO product (code, name, brand, description, price, quantity, is_active, category_id, supplier_id ) VALUES(
'ABCKFKJHFK11', 'DELL', 'DELL', 'best laptop ever', 15200000, 200, true, 3, 2);

INSERT INTO product (code, name, brand, description, price, quantity, is_active, category_id, supplier_id ) VALUES(
'ABCKFKJHFK12', 'SMART TV', 'Google', 'best TV ever', 15020, 15, true, 1, 2);

INSERT INTO product (code, name, brand, description, price, quantity, is_active, category_id, supplier_id ) VALUES(
'ABCKFKJHFK20', 'SAMSUNG A10', 'samsung', 'best phone ever', 15200, 10, true, 3, 2);

















