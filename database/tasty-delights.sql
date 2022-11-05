CREATE TABLE customer (
                          id INT NOT NULL AUTO_INCREMENT,
                          fname VARCHAR(50) NOT NULL,
                          lname VARCHAR(50),
                          age int,
                          email VARCHAR(50) NOT NULL,
                          contact VARCHAR(10),
                          address VARCHAR(100),
                          password varchar(300),
                          PRIMARY KEY (id)
);

INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('John', 'Doe', 25, 'test@gmail.com' , '0719999999' ,  'gampaha', 'john123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('gihan', 'kgrk', 25, 'yths@gmail.com' , '0719959999' ,  'ragama', 'gihan123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('erick', 'Robert', 25, 'sddsd@gmail.com' , '0719999369' ,  'malabe', 'robert123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('Michael', 'Daniel', 25, 'sddsd@gmail.com' , '0719999369' ,  'colombo', 'daniel123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('John', 'Thomas', 25, 'sddsd@gmail.com' , '0719944369' ,  'galle', 'john123');

create table orders(
                       id INT NOT NULL AUTO_INCREMENT primary key,
                       cusid INT NOT NULL,
                       name varchar(20),
                       quantity int,
                       status varchar(20),
                       price double,
                       orderedtime datetime default current_timestamp,
                       FOREIGN KEY (cusid) REFERENCES customer(id)
);

insert into orders (cusid, name, quantity, status, price) values(1, 'burger', 2, 'pending', 200);
insert into orders(cusid, name, quantity, status, price) values(1, 'pizza', 2, 'preparing', 200);
insert into orders (cusid, name, quantity, status, price) values(2, 'burger', 2, 'delivering', 200);
insert into orders (cusid, name, quantity, status, price) values(2, 'pizza', 2, 'completed', 200);
insert into orders (cusid, name, quantity, status, price) values(3, 'burger', 2, 'pending', 200);
insert into orders (cusid, name, quantity, status, price) values(3, 'pizza', 2, 'preparing', 200);
insert into orders (cusid, name, quantity, status, price) values(4, 'burger', 2, 'completed', 200);
insert into orders (cusid, name, quantity, status, price) values(4, 'pizza', 2, 'pending', 200);
insert into orders (cusid, name, quantity, status, price) values(5, 'burger', 2, 'preparing', 200);
insert into orders (cusid, name, quantity, status, price) values(5, 'pizza', 2, 'delivering', 200);
insert into orders (cusid, name, quantity, status, price) values(5, 'burger', 2, 'completed', 200);
insert into orders (cusid, name, quantity, status, price) values(5, 'pizza', 2, 'pending', 200);
insert into orders (cusid, name, quantity, status, price) values(5, 'burger', 2, 'pending', 200);

CREATE TABLE cart (
                      id INT NOT NULL,
                      cusid int NOT NULL,
                      PRIMARY KEY (id, cusid),
                      FOREIGN KEY (cusid) REFERENCES customer(id),
                      FOREIGN KEY (id) REFERENCES orders(id)
);

insert into cart (id, cusid) values(1, 1);
insert into cart (id, cusid) values(2, 1);
insert into cart (id, cusid) values(3, 2);
insert into cart (id, cusid) values(4, 2);
insert into cart (id, cusid) values(5, 3);

CREATE TABLE cart_item (
                           id INT NOT NULL AUTO_INCREMENT,
                           cartid int NOT NULL,
                           iname VARCHAR(50) NOT NULL,
                           quantity INT NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (cartid) REFERENCES cart(id)
);

insert into cart_item (cartid, iname, quantity) values(1, 'burger', 2);
insert into cart_item (cartid, iname, quantity) values(1, 'pizza', 2);
insert into cart_item (cartid, iname, quantity) values(2, 'burger', 2);
insert into cart_item (cartid, iname, quantity) values(2, 'pizza', 2);
insert into cart_item (cartid, iname, quantity) values(3, 'burger', 2);
insert into cart_item (cartid, iname, quantity) values(3, 'pizza', 2);
insert into cart_item (cartid, iname, quantity) values(4, 'burger', 2);

create table delivery_person(
                                id int auto_increment primary key,
                                name varchar(20),
                                age int,
                                email varchar(30),
                                contact varchar(20),
                                password varchar(300)
);

insert into delivery_person(name, age, email, contact, password) values('John', 25, 'john@gmail.com', '0776545321', 'john123');
insert into delivery_person(name, age, email, contact, password) values('Smith', 30, 'smith@gmail.com', '0776545321', 'smith123');
insert into delivery_person(name, age, email, contact, password) values('Peter', 28, 'peter@gmail.com', '0776545321', 'peter123');
insert into delivery_person(name, age, email, contact, password) values('Rahul', 35, 'rahul@gmail.com', '0776545321', 'rahul123');
insert into delivery_person(name, age, email, contact, password) values('Raj', 40, 'raj@gmail.com', '0776545321', 'raj123');

create table delivery_order(
                               id int primary key auto_increment,
                               did int,
                               order_id int,
                               status varchar(30),
                               FOREIGN KEY (did) REFERENCES delivery_person(id),
                               FOREIGN KEY (order_id) REFERENCES orders(id)
);

insert into delivery_order(did, order_id, status) values(1,1,'delivering');
insert into delivery_order(did, order_id, status) values(2,1, 'completed');
insert into delivery_order(did, order_id, status) values(3,1, 'delivering');
insert into delivery_order(did, order_id, status) values(4,1, 'completed');
insert into delivery_order(did, order_id, status) values(4,1, 'completed');

create table admin(
                      id int auto_increment primary key,
                      username varchar(20),
                      password varchar(300)
);

insert into Admin(username, password) values('admin', 'admin123');

CREATE TABLE `tasty_delights`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `des` VARCHAR(100) NULL,
  `price` DECIMAL(10,2) NULL,
  `category` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
INSERT INTO item (name, price, category, des , image) VALUES ('Taco', 100.00, 'Mexican', 'Spicy and Tasty', 'taco.png');
INSERT INTO item (name, price, category, des , image) VALUES ('Pizza', 200.99, 'Main', '', 'pizza.png');
INSERT INTO item (name, price, category, des , image) VALUES ('Burger', 300.88, 'Fast Food', 'Tallest Ever', 'burger.jpg');
INSERT INTO item (name, price, category, des , image) VALUES ('Hotdog', 400.77, 'Fast Food', 'Hot and Dog', 'hotdog.jpg');
INSERT INTO item (name, price, category, des , image) VALUES ('Fries', 500.12, 'Fast Food', 'Crispy and Flling', 'fries.jpg');



  
  
  