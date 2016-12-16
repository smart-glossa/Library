# Library

<h3>DETAILS OF DATABASE :</h3>

create database student;

use student;

TABLES:

CREATE TABLE `employee` (
  `Id` int(11) NOT NULL,
  `Name` varchar(30) default NULL,
  `password` varchar(50) default NULL,
  `Gender` varchar(30) default NULL,
  `Mobileno` varchar(30) default NULL,
  `Address` varchar(30) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

TABLE:2;

<H6>STUDENT DETAILS</H6>

   CREATE TABLE `student` (
  `sid` int(11) NOT NULL,
  `Name` varchar(50) default NULL,
  `gender` varchar(50) default NULL,
  `dep` varchar(50) default NULL,
  `year` varchar(50) default NULL,
  `contact` varchar(50) default NULL,
  `email` varchar(100) default NULL,
  `rdate` varchar(100) default NULL,
  PRIMARY KEY  (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

TABLE:3

<H6>BOOK DETAILS</H6>

CREATE TABLE `book` (
  `bookid` int(11) NOT NULL,
  `bookname` varchar(100) default NULL,
  `authorname` varchar(45) default NULL,
  `cat` varchar(45) default NULL,
  PRIMARY KEY  (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

TABLE 4:

CREATE TABLE `borrow` (
  `bid` int(11) NOT NULL auto_increment,
  `sid` int(11) NOT NULL,
  `bookid` int(11) default NULL,
  `bempid` int(11) default NULL,
  `bdate` datetime default NULL,
  PRIMARY KEY  (`bid`),
  KEY `fk_borrow` (`sid`),
  KEY `fk_borrows` (`bempid`),
  CONSTRAINT `fk_borrow` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `fk_borrows` FOREIGN KEY (`bempid`) REFERENCES `employee` (`Id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1

TABLE 5:

CREATE TABLE `returnbook` (
  `sid` int(11) NOT NULL,
  `rempid` int(11) NOT NULL,
  `rdate` date default NULL,
  KEY `FOR_returnbooks` (`rempid`),
  KEY `FOR_returnbook` USING BTREE (`sid`),
  CONSTRAINT `FOR_returnbook` FOREIGN KEY (`sid`) REFERENCES `student` (`sid`),
  CONSTRAINT `FOR_returnbooks` FOREIGN KEY (`rempid`) REFERENCES `employee` (`Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1
