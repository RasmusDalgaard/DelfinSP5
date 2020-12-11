create database delfinsp5;

/* Create table statements */
drop table members;
create table members(
memberID int not null primary key auto_increment,
memberName varchar(255) not null,
age int not null,
membershipStatus boolean not null,
price double not null,
competitive boolean not null
);

create table results(
resultID int not null primary key auto_increment,
memberID int not null,
compName varchar(255) not null,
competitionDate timestamp not null,
placement int not null,
timeRes int not null,
discipline varchar(255) not null
);

/* Insert statements */
INSERT INTO members (memberID,memberName,age,membershipStatus,price,competitive) VALUES (?,?,?,?,?,?);

/*Select Statements */
SELECT * FROM members;
SELECT * FROM results;