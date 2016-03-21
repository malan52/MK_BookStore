/** bid: unique identifier of Book (like ISBN)
* title: title of Book
* price: unit price WHEN ordered
* author: name of authors
* category: as specified
*/
CREATE TABLE Book (
bid VARCHAR(20) NOT NULL,
title VARCHAR(60) NOT NULL,
price INT NOT NULL,
category VARCHAR(20) NOT NULL,
PRIMARY KEY(bid)
);

INSERT INTO Book (bid, title, price, category) VALUES ('b001', 'Little Prince', 20, 'Fiction');
INSERT INTO Book (bid, title, price, category) VALUES ('b002','Physics', 201, 'Science');
INSERT INTO Book (bid, title, price, category) VALUES ('b003','Mechanics' ,100,'Engineering');

/* Address
* id: address id
*
*/
DROP TABLE Address;

CREATE TABLE Address (
id VARCHAR(20)  NOT NULL,
street VARCHAR(100) NOT NULL,
province VARCHAR(20) NOT NULL,
country VARCHAR(20) NOT NULL,
zip VARCHAR(20) NOT NULL,
phone VARCHAR(20),
PRIMARY KEY(id),
FOREIGN KEY(id) REFERENCES Customer(username) ON DELETE CASCADE
);

INSERT INTO Address (id, street, province, country, zip, phone) VALUES ('Roger', '123 Yonge St', 'ON',
'Canada', 'K1E 6T5' ,'647-123-4567');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES ('Steven', '445 Avenue rd', 'ON',
'Canada', 'M1C 6K5' ,'416-123-8569');
INSERT INTO Address (id, street, province, country, zip, phone) VALUES ('Andy', '789 Keele St.', 'ON',
'Canada', 'K3C 9T5' ,'416-123-9568');

/* Purchase Order
* lname: last name
* fname: first name
* id: purchase order id
* status:status of purchase
*/
DROP TABLE PO;

CREATE TABLE PO (
id INT  NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
lname VARCHAR(20) NOT NULL,
fname VARCHAR(20) NOT NULL,
status VARCHAR(20) NOT NULL,
address VARCHAR(20)  NOT NULL,
PRIMARY KEY(id),
UNIQUE (address),
FOREIGN KEY (address) REFERENCES Address (id) ON DELETE CASCADE
);

INSERT INTO PO (lname, fname, status, address) VALUES ( 'John', 'White', 'PROCESSED', 'Roger');
INSERT INTO PO (lname, fname, status, address) VALUES ( 'Peter', 'Black', 'DENIED', 'Steven');
INSERT INTO PO (lname, fname, status, address) VALUES ( 'Andy', 'Green', 'ORDERED', 'Andy');

/* Items on order
* id : purchase order id
* bid: unique identifier of Book
* price: unit price
*/
DROP TABLE POItem;

CREATE TABLE POItem (
id INT  NOT NULL,
bid VARCHAR(20) NOT NULL,
price INT  NOT NULL,
PRIMARY KEY(id,bid),
UNIQUE (id),
FOREIGN KEY(id) REFERENCES PO(id) ON DELETE CASCADE,
UNIQUE (bid),
FOREIGN KEY(bid) REFERENCES Book(bid) ON DELETE CASCADE
);

INSERT INTO POItem (id, bid, price) VALUES (1, 'b001', 20);
INSERT INTO POItem (id, bid, price) VALUES (2, 'b002', 201);
INSERT INTO POItem (id, bid, price) VALUES (3, 'b003', 100);

/* visit to website
* day: date
* bid: unique identifier of Book
* eventtype: status of purchase
*/
CREATE TABLE VisitEvent (
day varchar(8) NOT NULL,
bid varchar(20) not null REFERENCES Book(bid),
eventtype varchar(20) NOT NULL,
FOREIGN KEY(bid) REFERENCES Book(bid)
);

INSERT INTO VisitEvent (day, bid, eventtype) VALUES ('12202015', 'b001', 'VIEW');
INSERT INTO VisitEvent (day, bid, eventtype) VALUES ('12242015', 'b001', 'CART');
INSERT INTO VisitEvent (day, bid, eventtype) VALUES ('12252015', 'b001', 'PURCHASE');

/* Customer register
* username: Username to sign in
* password: Password to sign in
*/
DROP TABLE CUSTOMER;

CREATE TABLE Customer (
username	VARCHAR(20) NOT NULL,
password	VARCHAR(20) NOT NULL,
PRIMARY KEY (username)
);

INSERT INTO Customer (username, password) VALUES ('Roger', 'roger123');
INSERT INTO Customer (username, password) VALUES ('Steven', 'steven123');
INSERT INTO Customer (username, password) VALUES ('Andy', 'Andy123');

SELECT username, password FROM Customer WHERE username = 'username';
UPDATE CUSTOMER SET "PASSWORD"='roger124' WHERE "USERNAME"='Roger';
DELETE FROM Customer WHERE username = 'Eva';

/* Customer profile
* username: Username to sign in, FK to CUSTOMER
* fname: first name
* lname: last name
* email: email address
*/
CREATE TABLE Profile (
username	VARCHAR(20) NOT NULL,
fname		VARCHAR(20),
lname		VARCHAR(20),
email		VARCHAR(40),
PRIMARY KEY (username),
FOREIGN KEY(username) REFERENCES Customer(username) ON DELETE CASCADE);

INSERT INTO Profile (username, fname, lname, email) VALUES ('Steven', 'Steven', 'Eric', 'steveneric@yorku.ca');
INSERT INTO Profile (username, email) VALUES ('Andy', 'andyabc@yorku.ca');

UPDATE PROFILE SET "FNAME"='Andy', "LNAME"='Tommy' WHERE "USERNAME"='Andy';

/* Credit Card payment information
* username: Username to sign in, FK to CUSTOMER
* cardType: card type
* cardHolder: card holder
* cardNumber: card number
* expireM: expire month
* expireY: expire year
*/
CREATE TABLE CreditInfo (
username	VARCHAR(20) NOT NULL,
cardType	INT NOT NULL,
cardHolder	VARCHAR(50) NOT NULL,
cardNumber	VARCHAR(20) NOT NULL,
expireM		INT NOT NULL,
expireY		INT NOT NULL,
PRIMARY KEY (username),
FOREIGN KEY (username) REFERENCES Customer(username) ON DELETE CASCADE
);

INSERT INTO CreditInfo (username, cardType, CardHolder, CardNumber, expireM, expireY) 
VALUES ('Roger', 1, 'Roger Sun', '1111 2222 3333 4444', 8, 17);

/*
 * Review comments on books
 * bid: Book ID
 * username: user's username
 * rating: rate from 1-5
 * review: paragraph of review
 */
CREATE TABLE Review(
bid 		VARCHAR(20) NOT NULL,
username	VARCHAR(20) NOT NULL,
rating		INT NOT NULL,
review		VARCHAR(500),
PRIMARY KEY(bid, username),
FOREIGN KEY(bid) REFERENCES Book(bid) ON DELETE CASCADE,
FOREIGN KEY(username) REFERENCES Customer(username) ON DELETE CASCADE
);

INSERT INTO Review (bid, username, rating, review) VALUES ('b001', 'Roger', 5, 'Very good book!');
INSERT INTO Review VALUES ('b002', 'Roger', 4, 'Good book!');