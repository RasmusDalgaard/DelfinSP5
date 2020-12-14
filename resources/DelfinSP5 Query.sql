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

drop table payment;
create table payment(
memberID int not null,
hasPaid boolean default false
);

drop table coaches;
create table coaches(
coachID int not null primary key auto_increment,
coachName varchar(255) not null,
team varchar(255) default null
);

/* Insert statements */
INSERT INTO members (memberID,memberName,age,membershipStatus,price,competitive) VALUES (?,?,?,?,?,?);
INSERT INTO results (memberID,compName,competitionDate,timeRes,discipline) VALUES
(1,"LuffeCup",now(),82000,"Crawl"),
(2,"LuffeCup",now(),110000,"Crawl"),
(3,"LuffeCup",now(),93000,"Crawl"),
(4,"LuffeCup",now(),105000,"Crawl"),
(5,"LuffeCup",now(),99000,"Crawl"),
(6,"LuffeCup",now(),76000,"Crawl"),
(7,"LuffeCup",now(),82500,"Crawl"),
(8,"LuffeCup",now(),85750,"Crawl"),
(9,"LuffeCup",now(),79850,"Crawl"),
(10,"LuffeCup",now(),85000,"Crawl"),
(11,"LuffeCup",now(),97000,"Crawl"),
(1,"LuffeCup",now(),60000,"Butterfly"),
(2,"LuffeCup",now(),57000,"Butterfly"),
(3,"LuffeCup",now(),71000,"Butterfly"),
(4,"LuffeCup",now(),70000,"Butterfly"),
(6,"LuffeCup",now(),59000,"Butterfly"),
(8,"LuffeCup",now(),72500,"Butterfly"),
(9,"LuffeCup",now(),55000,"Butterfly"),
(11,"LuffeCup",now(),54000,"Butterfly"),
(1,"LuffeCup",now(),75000,"Backcrawl"),
(2,"LuffeCup",now(),61000,"Backcrawl"),
(3,"LuffeCup",now(),90000,"Backcrawl"),
(4,"LuffeCup",now(),100000,"Backcrawl"),
(5,"LuffeCup",now(),99000,"Backcrawl"),
(6,"LuffeCup",now(),76000,"Backcrawl"),
(7,"LuffeCup",now(),70000,"Backcrawl"),
(9,"LuffeCup",now(),89850,"Backcrawl"),
(10,"LuffeCup",now(),105000,"Backcrawl"),
(11,"LuffeCup",now(),97700,"Backcrawl"),
(1,"LuffeCup",now(),150000,"Breaststroke"),
(3,"LuffeCup",now(),163000,"Breaststroke"),
(4,"LuffeCup",now(),125000,"Breaststroke"),
(5,"LuffeCup",now(),145000,"Breaststroke"),
(7,"LuffeCup",now(),148500,"Breaststroke"),
(8,"LuffeCup",now(),142000,"Breaststroke"),
(9,"LuffeCup",now(),117000,"Breaststroke"),
(10,"LuffeCup",now(),135000,"Breaststroke"),
(11,"LuffeCup",now(),157500,"Breaststroke");
INSERT INTO payment (memberID,hasPaid) VALUES
(1,true),
(2,false),
(3,true),
(4,true),
(5,false),
(6,false),
(7,true),
(8,true),
(9,true),
(10,true),
(11,false),
(12,false);
INSERT INTO coaches(coachName,team) VALUES
("Jonathan Baywatch","Junior"),
("David Hasselhoff","Senior");

/*Select Statements */
SELECT * FROM members;
SELECT * FROM results ORDER by memberID;
SELECT * FROM payment;
SELECT * FROM coaches;
SELECT * FROM members WHERE age < 18 AND competitive = true;
SELECT * FROM members WHERE age >= 18 AND competitive = true;
/* Junior results */
SELECT r.resultID, r.memberID, m.memberName, m.age, r.compName, r.competitionDate, r.timeRes, r.discipline 
FROM results r, members m
WHERE r.memberID = m.memberID
AND age < 18
ORDER BY timeRes
LIMIT 5;
/* Senior results */
SELECT r.resultID, r.memberID, m.memberName, m.age, r.compName, r.competitionDate, r.timeRes, r.discipline 
FROM results r, members m
WHERE r.memberID = m.memberID
AND age >= 18
ORDER BY timeRes
LIMIT 5;
/* Missing payments */
SELECT p.memberID, m.memberName, p.hasPaid, m.price
FROM payment p, members m
WHERE p.memberID = m.memberID
AND p.hasPaid = false
order BY memberID;
