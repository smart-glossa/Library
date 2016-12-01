# Library

<h3>DETAILS OF DATABASE :</h3>

create database student;

use student;

TABLES:

CREATE TABLE `employee` (
  `Id` int(11) NOT NULL auto_increment,
  `Name` varchar(30) default NULL,
  `Gender` varchar(30) default NULL,
  `Mobileno` varchar(30) default NULL,
  `Address` varchar(30) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1

TABLE:2;
<H6>STUDENT DETAILS</H6>
CREATE TABLE `student` (
  `Rollno` int(11) NOT NULL auto_increment,
  `Name` varchar(50) default NULL,
  `class` varchar(50) default NULL,
  `Listofcards` varchar(50) default NULL,
  `Expirydate` varchar(50) default NULL,
  PRIMARY KEY  (`Rollno`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1

TABLE:
<H6>BOOK DETAILS</H6>

CREATE TABLE `book` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(100) default NULL,
  PRIMARY KEY  (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1
