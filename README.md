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
