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

drop table results;
create table results(
resultID int not null primary key auto_increment,
memberID int not null,
compName varchar(255) not null,
competitionDate timestamp not null,
timeRes int not null,
discipline varchar(255) not null
);

/* Insert statements */
INSERT INTO members (memberID,memberName,age,membershipStatus,price,competitive) VALUES (?,?,?,?,?,?);
INSERT INTO results (memberID,compName,competitionDate,timeRes,discipline) VALUES (1,"LuffeCup",now(),82000,"Crawl"),
(2,"LuffeCup",now(),110000,"Crawl"),
(3,"LuffeCup",now(),93000,"Crawl"),
(4,"LuffeCup",now(),105000,"Crawl"),
(5,"LuffeCup",now(),99000,"Crawl"),
(6,"LuffeCup",now(),76000,"Crawl"),
(7,"LuffeCup",now(),82500,"Crawl"),
(8,"LuffeCup",now(),85750,"Crawl"),
(9,"LuffeCup",now(),79850,"Crawl"),
(10,"LuffeCup",now(),85000,"Crawl");

/*Select Statements */
SELECT * FROM members;
SELECT * FROM results;
SELECT * FROM members WHERE age < 18 AND competitive = true;
SELECT * FROM members WHERE age >= 18 AND competitive = true;
/* Junior results */
SELECT r.resultID, r.memberID, m.memberName, m.age, r.compName, r.competitionDate, r.timeRes, r.discipline 
FROM results r, members m
WHERE r.memberID = m.memberID
AND age < 18
ORDER BY timeRes;
/* Senior results */
SELECT r.resultID, r.memberID, m.memberName, m.age, r.compName, r.competitionDate, r.timeRes, r.discipline 
FROM results r, members m
WHERE r.memberID = m.memberID
AND age >= 18
ORDER BY timeRes;