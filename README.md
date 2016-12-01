# Library

<h3>DETAILS OF DATABASE :<h3>;

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
