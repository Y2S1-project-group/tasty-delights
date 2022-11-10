-- drop schema tasty_delights;
-- create database tasty_delights; uncomment this to drop n get a fresh db
use tasty_delights;

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

create table orders(
					id INT NOT NULL AUTO_INCREMENT primary key,
					cusid INT NOT NULL,
					status varchar(20) default 'pending',
					tprice double, 
					orderedtime datetime default current_timestamp,
					FOREIGN KEY (cusid) REFERENCES customer(id)
);

create table order_item(
					id INT NOT NULL AUTO_INCREMENT primary key,
                    orderid INT,
					name varchar(40),
					quantity int,
					price double, 
					FOREIGN KEY (orderid) REFERENCES orders(id)
);

create table admin(
                      id int auto_increment primary key,
                      username varchar(20),
                      password varchar(300)
);

CREATE TABLE cart (
                      id INT auto_increment NOT NULL,
                      cusid int NOT NULL,
                      PRIMARY KEY (id, cusid),
                      FOREIGN KEY (cusid) REFERENCES customer(id),
                      FOREIGN KEY (id) REFERENCES orders(id)
);

CREATE TABLE cart_item (
    id INT NOT NULL AUTO_INCREMENT,
    cartid int NOT NULL,
    iname VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    price float NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cartid) REFERENCES cart(id)
);

create table delivery_person(
                                id int auto_increment primary key,
                                name varchar(20) not null,
                                age int,
                                email varchar(30),
                                contact varchar(20),
                                user_name varchar(30) not null,
                                password varchar(300) not null
);


create table delivery_order(
                               id int primary key auto_increment,
                               did int,
                               order_id int,
                               status varchar(30),
                               FOREIGN KEY (did) REFERENCES delivery_person(id),
                               FOREIGN KEY (order_id) REFERENCES orders(id)
);

CREATE TABLE `tasty_delights`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `des` VARCHAR(100) NULL,
  `price` DECIMAL(10,2) NULL,
  `category` VARCHAR(45) NULL,
  `image` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

/*------------test values-----------*/

insert into Admin(username, password) values('admin', 'admin123');

INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('John', 'Doe', 25, 'test@gmail.com' , '0719999999' ,  'gampaha', 'john123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('gihan', 'kgrk', 25, 'yths@gmail.com' , '0719959999' ,  'ragama', 'gihan123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('erick', 'Robert', 25, 'sddsd@gmail.com' , '0719999369' ,  'malabe', 'robert123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('Michael', 'Daniel', 25, 'sddsd@gmail.com' , '0719999369' ,  'colombo', 'daniel123');
INSERT INTO customer (fname, lname, age, email, contact, address, password) VALUES('John', 'Thomas', 25, 'sddsd@gmail.com' , '0719944369' ,  'galle', 'john123');

INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'pending' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'pending' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'pending' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'pending' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'pending' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'pending' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 2 , 'preparing' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 2 , 'preparing' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 2 , 'preparing' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 2 , 'preparing' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 3 , 'delivering' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 4 , 'delivering' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'completed' , 2 , now() );
INSERT INTO orders ( cusid , status , tprice , orderedtime ) VALUES ( 1 , 'completed' , 2 , now() );

insert into cart (id, cusid) values(1, 1);
insert into cart (id, cusid) values(2, 1);
insert into cart (id, cusid) values(3, 2);
insert into cart (id, cusid) values(4, 2);
insert into cart (id, cusid) values(5, 3);

INSERT INTO cart_item ( cartid , iname , quantity , price ) VALUES ( 1 , 'Burger' , 2 , 2000.00 );
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 1 , 'Fries' , 3 , 450.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 1 , 'Coke' , 5 , 560.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 1 , 'Burger' , 6 , 725.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 1 , 'ice-cream' , 6 , 425.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 2 , 'Fries' , 3 , 450.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 3 , 'Coke' , 5 , 560.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 4 , 'Burger' , 6 , 725.00);
INSERT INTO cart_item ( cartid , iname , quantity , price) VALUES ( 5 , 'Fries' , 7 ,600.00);


insert into delivery_order(order_id, status) values(2,'delivering');
insert into delivery_order(order_id, status) values(3, 'completed');
insert into delivery_order(order_id, status) values(4, 'delivering');
insert into delivery_order(order_id, status) values(5, 'completed');
insert into delivery_order(order_id, status) values(6, 'completed');



insert into delivery_person(name,age,email, contact, user_name, password) values('John', 25, 'john@gmail.com', '0776545321','john972','JoHn97');
insert into delivery_person(name,age,email, contact, user_name, password) values('Smith', 30, 'smith@gmail.com', '0776545321','smith920','SmiTh92');
insert into delivery_person(name,age,email, contact, user_name, password)  values('Peter', 28, 'peter@gmail.com', '0776545321','peter942','PeTer94');
insert into delivery_person(name,age,email, contact, user_name, password)  values('Rahul', 35, 'rahul@gmail.com', '0776545321','rahul870','raHul87');
insert into delivery_person(name,age,email, contact, user_name, password)  values('Raj',40, 'raj@gmail.com', '0776545321','raj823','rAj823');

insert into delivery_order(did, order_id, status) values(1,1,'delivering');
insert into delivery_order(did, order_id, status) values(2,1, 'completed');
insert into delivery_order(did, order_id, status) values(3,1, 'delivering');
insert into delivery_order(did, order_id, status) values(4,1, 'completed');
insert into delivery_order(did, order_id, status) values(4,1, 'completed');

INSERT INTO item (name, price, category, des , image) VALUES ('Taco', 100.00, 'Mexican', 'Spicy and Tasty', 'taco.png');
INSERT INTO item (name, price, category, des , image) VALUES ('Pizza', 200.99, 'Main', '', 'pizza.png');
INSERT INTO item (name, price, category, des , image) VALUES ('Burger', 300.88, 'Fast Food', 'Tallest Ever', 'burger.png');
INSERT INTO item (name, price, category, des , image) VALUES ('Hotdog', 400.77, 'Fast Food', 'Hot and Dog', 'hotdog.png');
INSERT INTO item (name, price, category, des , image) VALUES ('Fries', 500.12, 'Fast Food', 'Crispy and Flling', 'fries.png');


INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 1 , 'Burger' , 3 , 450.00); 
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 1 , 'Burger' , 5 , 560.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 1 , 'fires' , 6 , 725.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 1 , 'Burger' , 6 , 425.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 2 , 'Burger' , 3 , 450.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 2 , 'Burger' , 3 , 450.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 3 , 'Burger' , 5 , 560.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 4 , 'fires' , 6 , 725.00);
INSERT INTO order_item ( orderid , name , quantity , price) VALUES ( 5 , 'Burger' , 7 ,600.00);


select * from admin;
select * from cart;
select * from cart_item;
select * from customer;
select * from delivery_order;
select * from delivery_person;
select * from item;
select * from orders;
select * from order_item;

insert into Admin values ("admin" , "192023a7bbd73250516f069df18b500");