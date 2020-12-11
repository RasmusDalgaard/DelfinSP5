create database delfinsp5;
create table members(
memberID int not null primary key auto_increment,
memberName varchar(255) not null,
age int not null,
category varchar(255) not null,
membershipStatus boolean not null,
competitive boolean not null,
price double not null
);

/* Insert statements */
INSERT INTO members (memberID,memberName,age,category,membershipStatus,competitive,price) VALUES (?,?,?,?,?,?,?);

/*Select Statements */
SELECT * FROM members;