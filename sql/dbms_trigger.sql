/*EVERYTHING CAN BE EXECUTED AS ONE APART FROM THE TRIGGERS CREATE,INSERT & DELETE............................................*/
DROP TABLE REVIEW;
DROP TABLE TRACK;
DROP TABLE ORDERITEM;
DROP TABLE THEALBUMS;
DROP TABLE NEWRELEASES;
DROP TABLE THEBAND;
DROP TABLE THEORDER;
DROP TABLE CUSTOMER;
DROP TABLE TICKET;
DROP TABLE THEUSER;
DROP TABLE MYADMIN;
DROP TABLE MESSAGE;
DROP TRIGGER INSERT_MESSAGE;


CREATE TABLE CUSTOMER(
    CUSTOMERID 		  INTEGER(11) NOT NULL AUTO_INCREMENT,
    FIRSTNAME 		  VARCHAR(50) NOT NULL,
    LASTNAME 		  VARCHAR(50) NOT NULL,
    ADDRESS1 	  	  VARCHAR(50) NOT NULL,
	ADDRESS2 		  VARCHAR(50) NOT NULL,
	CITY 		  	  VARCHAR(20) NOT NULL,
	COUNTY 		  	  VARCHAR(20) NOT NULL,
	COUNTRY 		  VARCHAR(20) NOT NULL,
	ZIP 		  	  VARCHAR(20) NOT NULL,
	PHONE 		  	  VARCHAR(20) NOT NULL,
	CARDTYPE 		  VARCHAR(20) NOT NULL,
	CARDNUMBER 		  VARCHAR(20) NOT NULL,
	CARDIDNUMBER 	  VARCHAR(20) NOT NULL,
	VALIDUNTIL 		  VARCHAR(20) NOT NULL,
	CONSTRAINT pk_custid PRIMARY KEY (CUSTOMERID)
);

							 
CREATE TABLE THEORDER (
    ORDERID 					INTEGER(11) NOT NULL AUTO_INCREMENT,
    CUSTOMERID 					INTEGER NOT NULL,
    ORDERDATE  				    date,
    CONSTRAINT pk_orderid PRIMARY KEY (ORDERID),
    CONSTRAINT fk_custid FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER (CUSTOMERID)
);	


CREATE TABLE THEBAND(
    SUPPLIERID 				INTEGER(11) NOT NULL AUTO_INCREMENT,
    SUPPLIER_NAME			VARCHAR(40) NOT NULL,
	SUPPLIER_ADDRESS 		VARCHAR(30) NOT NULL,
	SUPPLIER_TELNO 		    VARCHAR(20) NOT NULL,
	CONSTRAINT pk_supplierid PRIMARY KEY (SUPPLIERID)
);

CREATE TABLE NEWRELEASES(
    PRODUCTID 				INTEGER(11) NOT NULL AUTO_INCREMENT,
	SUPPLIERID 				INTEGER NOT NULL,
	ALBUM_COVER				VARCHAR(100)NOT NULL,
	PRODUCTCODE				VARCHAR(30)NOT NULL,
    PRODUCT_NAME			VARCHAR(30)NOT NULL,
    PRODUCT_GENRE			VARCHAR(30)NOT NULL,
    PRODUCT_DESC 			VARCHAR(5000) NOT NULL,
    PRODUCT_PRICE 			DOUBLE(7,2) NOT NULL,
    CONSTRAINT pk_productid2 PRIMARY KEY (PRODUCTID),
	CONSTRAINT fk_supplierid2 FOREIGN KEY (SUPPLIERID) REFERENCES THEBAND (SUPPLIERID)
);
						 
CREATE TABLE THEALBUMS(
    PRODUCTID 				INTEGER(11) NOT NULL AUTO_INCREMENT,
	SUPPLIERID 				INTEGER NOT NULL,
	ALBUM_COVER				VARCHAR(100)NOT NULL,
	PRODUCTCODE				VARCHAR(30)NOT NULL,
    PRODUCT_NAME			VARCHAR(30)NOT NULL,
    PRODUCT_GENRE			VARCHAR(30)NOT NULL,
    PRODUCT_DESC 			VARCHAR(5000) NOT NULL,
    PRODUCT_PRICE 			DOUBLE(7,2) NOT NULL,
    CONSTRAINT pk_productid PRIMARY KEY (PRODUCTID),
	CONSTRAINT fk_supplierid FOREIGN KEY (SUPPLIERID) REFERENCES THEBAND (SUPPLIERID)
);


CREATE TABLE ORDERITEM(
    ORDERID 		INTEGER NOT NULL,
    PRODUCTID 		INTEGER NOT NULL,
    CONSTRAINT pk_orderitemid PRIMARY KEY (ORDERID, PRODUCTID),
    CONSTRAINT fk_orderid FOREIGN KEY (ORDERID) REFERENCES THEORDER (ORDERID),
	CONSTRAINT fk_productid FOREIGN KEY (PRODUCTID) REFERENCES THEALBUMS (PRODUCTID)
);

CREATE TABLE TRACK(
	TRACKID					INTEGER(11) NOT NULL AUTO_INCREMENT,
	PRODUCTID				INTEGER NOT NULL,
	TRACK_NAME				VARCHAR(100) NOT NULL,
	TRACK_DURATION			VARCHAR(11) NOT NULL,
	CONSTRAINT pk_trackid PRIMARY KEY (TRACKID),
	CONSTRAINT fk_trackproductid FOREIGN KEY (PRODUCTID) REFERENCES THEALBUMS (PRODUCTID)
);

CREATE TABLE REVIEW(
REVIEWID			INTEGER(11) NOT NULL AUTO_INCREMENT,
PRODUCTID			INTEGER NOT NULL,
MESSAGE				VARCHAR(500) NOT NULL,
REVIEWDATE  		date,
CONSTRAINT pk_reviewid PRIMARY KEY (REVIEWID),
CONSTRAINT fk_reviewalbumid FOREIGN KEY (PRODUCTID) REFERENCES THEALBUMS (PRODUCTID)
);

CREATE TABLE TICKET(
TICKETID			INTEGER(11) NOT NULL AUTO_INCREMENT,
EVENT_NAME			VARCHAR(50) NOT NULL,
EVENT_LOCATION		VARCHAR(50) NOT NULL,
EVENT_STARTTIME		VARCHAR(50) NOT NULL,
EVENT_DATE			VARCHAR(50) NOT NULL,
EVENT_PRICE			VARCHAR(50) NOT NULL,
QUANTITY_IN_STOCK	VARCHAR(30) NOT NULL,
CONSTRAINT pk_ticketid PRIMARY KEY (TICKETID)
);

CREATE TABLE THEUSER (
    USERID 		  	  INTEGER(11) NOT NULL AUTO_INCREMENT,
    FIRSTNAME 		  VARCHAR(50) NOT NULL,
    LASTNAME 		  VARCHAR(50) NOT NULL,
    EMAILADDRESS 	  VARCHAR(50) NOT NULL,
	USERNAME 		  VARCHAR(50) NOT NULL,
	PASSWORD 		  VARCHAR(50) NOT NULL,
	CONSTRAINT pk_userid PRIMARY KEY (USERID)
);

CREATE TABLE MESSAGE(
	MESSAGEID	 integer not null,
	MESSAGE 	 VARCHAR(50),
	FNAME	 VARCHAR(30),
	LNAME	 VARCHAR(30),
	MESSAGE_TIME TIMESTAMP,
	CONSTRAINT pk_messageid PRIMARY KEY (MESSAGEID)
);

CREATE TABLE MYADMIN(
	ADMINID 		  	  INTEGER(11) NOT NULL AUTO_INCREMENT,
	ADMINUSERNAME 		  VARCHAR(20) NOT NULL,
	ADMINPASSWORD 		  VARCHAR(20) NOT NULL,
	CONSTRAINT pk_adminid PRIMARY KEY (ADMINID)
);


INSERT INTO CUSTOMER VALUES (null, 'Paul', 'Murphy', '1010 Main Street', 'Duleek', 'N/A', 'Meath', 'Ireland', 'EIRE', '1900-282820', 'Laser', UNHEX(MD5('1111-2222-3333-4444')), UNHEX(MD5('192')), '10/03/2012');
INSERT INTO CUSTOMER VALUES (null, 'Joe', 'Bloggs', '1111 Main Street', 'Duleek', 'N/A', 'Louth', 'Ireland', 'EIRE', '1800-282820', 'Master', UNHEX(MD5('2222-2222-3333-4444')), UNHEX(MD5('193')), '11/03/2015'); 
INSERT INTO CUSTOMER VALUES (null, 'John', 'Doe', '0101 Main Street', 'Duleek', 'N/A', 'Cork', 'Ireland', 'EIRE', '1700-282820', 'Credit', UNHEX(MD5('3333-2222-3333-4444')), UNHEX(MD5('194')), '19/03/2014');					 
INSERT INTO CUSTOMER VALUES (null, 'Ringo', 'Murphy', '1010 Main Street', 'Duleek', 'N/A', 'Meath', 'Ireland', 'EIRE', '1900-282820', 'Laser', UNHEX(MD5('1111-2222-3333-4444')), UNHEX(MD5('192')), '10/03/2012');
INSERT INTO CUSTOMER VALUES (null, 'Tom', 'Bloggs', '1111 Main Street', 'Duleek', 'N/A', 'Meath', 'Ireland', 'EIRE', '1800-282820', 'Master', UNHEX(MD5('2222-2222-3333-4444')), UNHEX(MD5('193')), '11/03/2015'); 
INSERT INTO CUSTOMER VALUES (null, 'Tim', 'Doe', '0101 Main Street', 'Duleek', 'N/A', 'Tipperary', 'Ireland', 'EIRE', '1700-282820', 'Credit', UNHEX(MD5('3333-2222-3333-4444')), UNHEX(MD5('194')), '19/03/2014');					 
INSERT INTO CUSTOMER VALUES (null, 'Pete', 'Murphy', '1010 Main Street', 'Duleek', 'N/A', 'Wexford', 'Ireland', 'EIRE', '1900-282820', 'Laser', UNHEX(MD5('1111-2222-3333-4444')), UNHEX(MD5('192')), '10/03/2012');
INSERT INTO CUSTOMER VALUES (null, 'Dan', 'Bloggs', '1111 Main Street', 'Duleek', 'N/A', 'Meath', 'Ireland', 'EIRE', '1800-282820', 'Master', UNHEX(MD5('2222-2222-3333-4444')), UNHEX(MD5('193')), '11/03/2015'); 
INSERT INTO CUSTOMER VALUES (null, 'Ivan', 'Doe', '0101 Main Street', 'Duleek', 'N/A', 'Donegal', 'Ireland', 'EIRE', '1700-282820', 'Credit', UNHEX(MD5('3333-2222-3333-4444')), UNHEX(MD5('194')), '19/03/2014');					 
			
INSERT INTO THEORDER VALUES (null, 1, '2012-01-12');
INSERT INTO THEORDER VALUES (null, 2, '2012-02-13');
INSERT INTO THEORDER VALUES (null, 3, '2012-12-12');
INSERT INTO THEORDER VALUES (null, 4, '2012-01-12');
INSERT INTO THEORDER VALUES (null, 5, '2012-02-13');
INSERT INTO THEORDER VALUES (null, 6, '2012-12-12');
INSERT INTO THEORDER VALUES (null, 7, '2012-01-12');
INSERT INTO THEORDER VALUES (null, 8, '2012-02-13');
INSERT INTO THEORDER VALUES (null, 9, '2012-12-12');

INSERT INTO THEBAND VALUES ( null,'The Boyz From The County Hell', '20 High St, Dundalk', '(048)12345');
INSERT INTO THEBAND VALUES ( null,'The Boyz From The County Hell', '20 High St, Dundalk', '(048)12345');
INSERT INTO THEBAND VALUES ( null,'The Boyz From The County Hell', '20 High St, Dundalk', '(048)12345');	

INSERT INTO THEALBUMS VALUES ( null, 1, 'images/cover1.jpg', '1010A', 'Unite', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 9.99);
INSERT INTO THEALBUMS VALUES ( null, 1, 'images/cover2.jpg', '1011B', 'Point of Know Return', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 14.99);
INSERT INTO THEALBUMS VALUES ( null, 1, 'images/cover3.jpeg', '1012C', 'Shock n Yall', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 5.99);	
INSERT INTO THEALBUMS VALUES ( null, 1, 'images/cover4.jpg', '1013D', 'Tutti Frutti', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 19.99);
INSERT INTO THEALBUMS VALUES ( null, 1, 'images/cover5.jpg', '1014E', 'Voice', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 18.99);

INSERT INTO NEWRELEASES VALUES ( null, 1, 'images/new1.jpg', '1010V', 'BLAH BLAH', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 9.99);
INSERT INTO NEWRELEASES VALUES ( null, 1, 'images/new2.jpg', '1011W', 'DKIT', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 14.99);
INSERT INTO NEWRELEASES VALUES ( null, 1, 'images/new3.jpg', '1012X', 'HIPPIDDY HOPP', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 5.99);	
INSERT INTO NEWRELEASES VALUES ( null, 1, 'images/new4.jpg', '1013Y', 'NAH NAH', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 19.99);
INSERT INTO NEWRELEASES VALUES ( null, 1, 'images/new5.jpg', '1014Z', 'SCHEDULE', 'Indie/Rock', 'Track 1 is Borneo by Firewater. Very neat shakin hips striding down the road drums a playin song. In your face great pseudo political lyrics and chorus. Love it. Usual Suspects by Ha Ha Tonka up next. Country Rock that rocks w/repeated song title chorus, cool band. Very nice. Harlem River Blues by Justin Townes Earle is track 3. This track was on the Bloodshot 2010 sampler, still sounds great, rock a billy-ish song bopping along. Next song is Intertwined by Maggie Bjorklund w/Mark Lanegan. Weird combination of 2 voices that do not seem to complement each other. Plodding bass behind voices. Eddie Spaghetti with Sundowner is next. Eddie races through speedy country number. I aint dancin this fast for any gurl.', 18.99);

INSERT INTO TRACK VALUES (NULL, 1, 'Go Your Own Way Remix Original', '4:12');
INSERT INTO TRACK VALUES (NULL, 1, 'Go Your Own Way Remix 1', '4:13');
INSERT INTO TRACK VALUES (NULL, 1, 'Dreams', '5:09');
INSERT INTO TRACK VALUES (NULL, 1, 'Gypsy', '3:57');
INSERT INTO TRACK VALUES (NULL, 1, 'Go Your Own Way Remix 2', '4:14');
INSERT INTO TRACK VALUES (NULL, 1, 'The Chain', '4:38');

INSERT INTO TRACK VALUES (NULL, 2, 'California Love', '4:12');
INSERT INTO TRACK VALUES (NULL, 2, 'All That She Wants', '4:13');
INSERT INTO TRACK VALUES (NULL, 2, 'Take On Me', '5:09');
INSERT INTO TRACK VALUES (NULL, 2, 'Crying At The Discoteque', '3:57');
INSERT INTO TRACK VALUES (NULL, 2, 'Left Outside Alone', '4:14');
INSERT INTO TRACK VALUES (NULL, 2, 'Love Story', '4:38');
INSERT INTO TRACK VALUES (NULL, 2, 'Bitter Sweat', '4:38');

INSERT INTO TRACK VALUES (NULL, 3, 'Barbie Girl', '4:12');
INSERT INTO TRACK VALUES (NULL, 3, 'The Tide Is High', '4:13');
INSERT INTO TRACK VALUES (NULL, 3, 'Intergalactic', '5:09');
INSERT INTO TRACK VALUES (NULL, 3, 'Rock Around The Clock', '3:57');
INSERT INTO TRACK VALUES (NULL, 3, 'Aint No Sunshine', '4:14');
INSERT INTO TRACK VALUES (NULL, 3, 'All Is Full Of Love', '4:38');
INSERT INTO TRACK VALUES (NULL, 3, 'Sorry Seems To Be The Hardest Word', '4:38');

INSERT INTO TRACK VALUES (NULL, 4, 'Bad Boyz', '4:12');
INSERT INTO TRACK VALUES (NULL, 4, 'Redemption Song', '4:13');
INSERT INTO TRACK VALUES (NULL, 4, 'Love Generation', '5:09');
INSERT INTO TRACK VALUES (NULL, 4, 'Daddy Cool', '3:57');
INSERT INTO TRACK VALUES (NULL, 4, 'The Rhythum Of The Night', '4:14');
INSERT INTO TRACK VALUES (NULL, 4, 'Bad Day', '4:38');
INSERT INTO TRACK VALUES (NULL, 4, 'The World Is Mine', '4:38');
INSERT INTO TRACK VALUES (NULL, 4, 'Sunrise', '4:13');
INSERT INTO TRACK VALUES (NULL, 4, 'Return To Innocence', '5:09');

INSERT INTO TRACK VALUES (NULL, 5, 'Best Of You', '5:09');
INSERT INTO TRACK VALUES (NULL, 5, 'Mad World', '3:57');
INSERT INTO TRACK VALUES (NULL, 5, 'Crazy', '4:14');
INSERT INTO TRACK VALUES (NULL, 5, 'Foxy Lady', '4:38');
INSERT INTO TRACK VALUES (NULL, 5, 'Lambada', '4:38');
INSERT INTO TRACK VALUES (NULL, 5, 'The Neverending Story', '4:13');
INSERT INTO TRACK VALUES (NULL, 5, 'Mambo', '5:09');

INSERT INTO REVIEW VALUES (NULL, 1, 'Greeeeat album thoroughly recommend it, lol...', '2012-01-12');
INSERT INTO REVIEW VALUES (NULL, 2, 'Big fan, loved it..', '2012-01-15');
INSERT INTO REVIEW VALUES (NULL, 1, 'Bought all your albums so far cant wait for the next', '2012-01-15');
INSERT INTO REVIEW VALUES (NULL, 3, 'Greeeeat album thoroughly recommend it, lol...', '2012-01-12');
INSERT INTO REVIEW VALUES (NULL, 4, 'Big fan, loved it..', '2012-01-15');
INSERT INTO REVIEW VALUES (NULL, 5, 'Bought all your albums so far cant wait for the next', '2012-01-15');

INSERT INTO ORDERITEM VALUES (1, 1);
INSERT INTO ORDERITEM VALUES (2, 3);
INSERT INTO ORDERITEM VALUES (3, 1);
INSERT INTO ORDERITEM VALUES (4, 5);
INSERT INTO ORDERITEM VALUES (5, 3);
INSERT INTO ORDERITEM VALUES (6, 4);
INSERT INTO ORDERITEM VALUES (7, 4);
INSERT INTO ORDERITEM VALUES (8, 2);
INSERT INTO ORDERITEM VALUES (9, 3);
				
INSERT INTO THEUSER VALUES (null, 'Paul', 'Murphy', 'mur3ph@gmail.com', 'pmurp09', UNHEX(MD5('p9823874m')));
INSERT INTO THEUSER VALUES (null, 'Joe', 'Bloggs', 'bloggsey@hotmail.com', 'jblog', UNHEX(MD5('password2'))); 
INSERT INTO THEUSER VALUES (null, 'John', 'Doe', 'jdoe@themorgue.com', 'jdoe', UNHEX(MD5('password3')));

INSERT INTO TICKET VALUES (NULL, 'Pitch Fork Music Festival 2012: 3 Day Pass', 'Room 1101 - DKIT', '3:30', 'Fri 13 - Sun 15', '110.00', 'Sold Out');
INSERT INTO TICKET VALUES (NULL, 'Pitch Fork Music Festival 2012: Friday', 'Room 1101 - DKIT', '3:30', 'Fri 13', '45.00', 'Sold Out');
INSERT INTO TICKET VALUES (NULL, 'Pitch Fork Music Festival 2012: Saturday', 'Room 1101 - DKIT', '3:30', 'Sat 14', '45.00', 'Sold Out');
INSERT INTO TICKET VALUES (NULL, 'Pitch Fork Music Festival 2012: Sunday', 'Room 1101 - DKIT', '3:30', 'Sun 15', '45.00', 'Sold Out');

INSERT INTO MYADMIN VALUES (null, 'adminuser1', UNHEX(MD5('adminpass1')));
INSERT INTO MYADMIN VALUES (null, 'adminuser2', UNHEX(MD5('adminpass2')));
INSERT INTO MYADMIN VALUES (null, 'adminuser3', UNHEX(MD5('adminpass3')));
								 
INSERT INTO MESSAGE VALUES ( 10,'This ID Updated Their Profile.. !!', 'Derek', 'Zoolander', '2012-03-10 06:00:00');
INSERT INTO MESSAGE VALUES ( 20,'This ID Deleted Their Profile.. !!', 'JohnJoe', 'MacDonagh', '2012-03-10 07:00:00');
INSERT INTO MESSAGE VALUES ( 30,'This ID Deleted Their Profile.. !!', 'Timmy', 'McLovin', '2012-03-10 08:00:00');

CREATE TRIGGER INSERT_MESSAGE
       BEFORE DELETE ON THEUSER
       FOR EACH ROW BEGIN
INSERT INTO MESSAGE VALUES (OLD.USERID,'Record Deleted', OLD.FIRSTNAME, OLD.LASTNAME, CURRENT_TIMESTAMP); 
END

