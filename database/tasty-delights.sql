create database tasty_delights;
use tasty_delights;

CREATE TABLE customer (
    id INT NOT NULL AUTO_INCREMENT,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50),
    age int,
    email VARCHAR(50) NOT NULL,
    contact VARCHAR(10),
    address VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE cart (
    id INT NOT NULL AUTO_INCREMENT,
    cusid int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cusid) REFERENCES customer(id)
);

CREATE TABLE cart_item (
    id INT NOT NULL AUTO_INCREMENT,
    cartid int NOT NULL,
    iname VARCHAR(50) NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (cartid) REFERENCES cart(id)
);

create table delivery_person(
    id int auto_increment primary key,
    name varchar(20),
    age int,
    email varchar(30),
    contact varchar(20),
    password varchar(300)
);

create table delivery_order(
    id int auto_increment primary key,
    order_id int,
    status varchar(30)
);

create table item(
    id int primary key,
    name varchar(50),
    des varchar(100),
    price int,
    category varchar(20)
);





INSERT INTO customer (fname, lname, age, email, contact, address) VALUES('John', 'Doe', 25, 'test@gmail.com' , '0719999999' ,  'gampaha');
INSERT INTO customer (fname, lname, age, email, contact, address) VALUES('gihan', 'kgrk', 25, 'yths@gmail.com' , '0719959999' ,  'ragama');
INSERT INTO customer (fname, lname, age, email, contact, address) VALUES('erick', 'Robert', 25, 'sddsd@gmail.com' , '0719999369' ,  'malabe');
INSERT INTO customer (fname, lname, age, email, contact, address) VALUES('Michael', 'Daniel', 25, 'sddsd@gmail.com' , '0719999369' ,  'colombo');
INSERT INTO customer (fname, lname, age, email, contact, address) VALUES('John', 'Thomas', 25, 'sddsd@gmail.com' , '0719944369' ,  'galle');

insert into delivery_person(name, age, email, contact) values('John', 25, 'john@gmail.com', 'john123');
insert into delivery_person(name, age, email, contact) values('Smith', 30, 'smith@gmail.com', 'smith123');
insert into delivery_person(name, age, email, contact) values('Peter', 28, 'peter@gmail.com', 'peter123');
insert into delivery_person(name, age, email, contact) values('Rahul', 35, 'rahul@gmail.com', 'rahul123');
insert into delivery_person(name, age, email, contact) values('Raj', 40, 'raj@gmail.com', 'raj123');


insert into delivery_order(order_id, status) values(1, 'delivering');
insert into delivery_order(order_id, status) values(2, 'completed');
insert into delivery_order(order_id, status) values(3, 'delivering');
insert into delivery_order(order_id, status) values(4, 'completed');
insert into delivery_order(order_id, status) values(4, 'completed');


insert into item values (1, 'Tomato Soup','butter bun with seasame',670,'starter' );
insert into item values (8 , 'Spicy Chicken Burger','with deep fried nuggets',490,'Burgher' );
insert into item values (5 , 'Coke','500ml',300,'Beverages' );
insert into item values (11, 'Potato chips','small portion',280,'Fries' );
insert into item values (19 , 'Crispy veg burger','Extra garlic gravy and onion rings',450,'Burger');

INSERT INTO cart ( cusid ) VALUES ( 1 );
INSERT INTO cart ( cusid ) VALUES ( 2 );
INSERT INTO cart ( cusid ) VALUES ( 3 );
INSERT INTO cart ( cusid ) VALUES ( 4 );
INSERT INTO cart ( cusid ) VALUES ( 5 );

INSERT INTO cart_item ( cartid , iname , quantity ) VALUES ( 1 , 'Burger' , 2 );
INSERT INTO cart_item ( cartid , iname , quantity ) VALUES ( 2 , 'Fries' , 3 );
INSERT INTO cart_item ( cartid , iname , quantity ) VALUES ( 3 , 'Coke' , 5 );
INSERT INTO cart_item ( cartid , iname , quantity ) VALUES ( 4 , 'Burger' , 6 );
INSERT INTO cart_item ( cartid , iname , quantity ) VALUES ( 5 , 'Fries' , 7 );
