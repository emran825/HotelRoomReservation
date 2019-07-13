-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema roomreservation
--

CREATE DATABASE IF NOT EXISTS roomreservation;
USE roomreservation;

--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `catid` varchar(45) NOT NULL default '',
  `roomtypeid` int(10) unsigned NOT NULL,
  `catname` varchar(45) NOT NULL,
  PRIMARY KEY  (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`catid`,`roomtypeid`,`catname`) VALUES 
 ('1',1,'Double Deluxe'),
 ('2',1,'Single Deluxe'),
 ('3',1,'Honeymoon Suit'),
 ('4',1,'Economy Double'),
 ('5',1,'Economy Single'),
 ('6',2,'Economy Single'),
 ('7',2,'Economy Double'),
 ('8',2,' Double Deluxe');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `customerinfo`
--

DROP TABLE IF EXISTS `customerinfo`;
CREATE TABLE `customerinfo` (
  `custid` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `emailid` varchar(45) NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `nid` varchar(45) NOT NULL,
  PRIMARY KEY  (`custid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerinfo`
--

/*!40000 ALTER TABLE `customerinfo` DISABLE KEYS */;
INSERT INTO `customerinfo` (`custid`,`username`,`emailid`,`nationality`,`phone`,`nid`) VALUES 
 (1,'Emran Hossan','ehossan825@gmail.com','Bangladesh','+8801846921763','201458793'),
 (2,'Emran Hossan','ehossan825@gmail.com',' Bangladesh','+8801846921763','201458793'),
 (3,'Emran','ehossan@gmail.com','Bangladesh','+880125855656','01895423254'),
 (4,'Md. Ibrahim','ibrahim@gmail.com','Bangladesh','+8801626547621','1245879630');
/*!40000 ALTER TABLE `customerinfo` ENABLE KEYS */;


--
-- Definition of table `customerservice`
--

DROP TABLE IF EXISTS `customerservice`;
CREATE TABLE `customerservice` (
  `serid` int(10) unsigned NOT NULL auto_increment,
  `facilityid` varchar(45) NOT NULL,
  `custid` int(10) unsigned NOT NULL,
  `bookingid` int(10) unsigned default NULL,
  PRIMARY KEY  (`serid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerservice`
--

/*!40000 ALTER TABLE `customerservice` DISABLE KEYS */;
INSERT INTO `customerservice` (`serid`,`facilityid`,`custid`,`bookingid`) VALUES 
 (1,'4',4,1),
 (2,'2',4,1);
/*!40000 ALTER TABLE `customerservice` ENABLE KEYS */;


--
-- Definition of table `facility`
--

DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility` (
  `facilityid` int(10) unsigned NOT NULL auto_increment,
  `facilityname` varchar(45) NOT NULL,
  `facilitycost` int(11) NOT NULL,
  PRIMARY KEY  (`facilityid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facility`
--

/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
INSERT INTO `facility` (`facilityid`,`facilityname`,`facilitycost`) VALUES 
 (1,'Restaurant',2000),
 (2,'Sports Club',1000),
 (3,'Swimming Pool',1000),
 (4,'Gymnesium',2000),
 (5,'Bar',5000);
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentid` int(10) unsigned NOT NULL auto_increment,
  `bookingid` int(11) NOT NULL,
  `paymenttype` varchar(45) NOT NULL,
  `bookingamount` double NOT NULL,
  `totalamount` double NOT NULL,
  `paymentdate` date NOT NULL,
  PRIMARY KEY  (`paymentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`paymentid`,`bookingid`,`paymenttype`,`bookingamount`,`totalamount`,`paymentdate`) VALUES 
 (1,1,'Card',6000,15000,'2019-07-13'),
 (2,2,'Card',2000,2000,'2019-07-13');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `paymentdetails`
--

DROP TABLE IF EXISTS `paymentdetails`;
CREATE TABLE `paymentdetails` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `paymentid` int(11) NOT NULL,
  `bookingid` int(11) NOT NULL,
  `facilityid` int(11) NOT NULL,
  `facilitycost` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentdetails`
--

/*!40000 ALTER TABLE `paymentdetails` DISABLE KEYS */;
INSERT INTO `paymentdetails` (`id`,`paymentid`,`bookingid`,`facilityid`,`facilitycost`) VALUES 
 (1,1,1,4,2000),
 (2,1,1,2,1000);
/*!40000 ALTER TABLE `paymentdetails` ENABLE KEYS */;


--
-- Definition of table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomid` int(10) unsigned NOT NULL auto_increment,
  `roomtypeid` varchar(45) NOT NULL,
  `catid` varchar(45) NOT NULL,
  `roomnumber` varchar(45) NOT NULL,
  `roomrent` double NOT NULL,
  `catname` varchar(45) NOT NULL,
  `roomtype` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY  (`roomid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`roomid`,`roomtypeid`,`catid`,`roomnumber`,`roomrent`,`catname`,`roomtype`,`status`) VALUES 
 (1,'1','1','A-1',2000,'Double Deluxe','AC','Empty'),
 (2,'2','1','A-2',2500,'Double Deluxe','Non-AC','Empty'),
 (3,'1','2','A-9',2000,'Single Deluxe','AC','Empty'),
 (4,'2','2','A-3',1500,'Single Deluxe','Non-AC','Empty');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Definition of table `roombooking`
--

DROP TABLE IF EXISTS `roombooking`;
CREATE TABLE `roombooking` (
  `bookingid` int(10) unsigned NOT NULL auto_increment,
  `roomid` int(10) unsigned NOT NULL,
  `roomtypeid` int(10) unsigned NOT NULL,
  `custid` int(10) unsigned NOT NULL,
  `startdate` date NOT NULL default '0000-00-00',
  `enddate` date NOT NULL default '0000-00-00',
  `emailid` varchar(45) NOT NULL,
  PRIMARY KEY  (`bookingid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roombooking`
--

/*!40000 ALTER TABLE `roombooking` DISABLE KEYS */;
INSERT INTO `roombooking` (`bookingid`,`roomid`,`roomtypeid`,`custid`,`startdate`,`enddate`,`emailid`) VALUES 
 (1,1,1,4,'2019-07-14','2019-07-17','ibrahim@gmail.com'),
 (2,3,1,1,'2019-07-29','2019-07-30','ehossan825@gmail.com');
/*!40000 ALTER TABLE `roombooking` ENABLE KEYS */;


--
-- Definition of table `roomtype`
--

DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `roomtypeid` int(10) unsigned NOT NULL auto_increment,
  `roomtype` varchar(45) NOT NULL,
  PRIMARY KEY  (`roomtypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roomtype`
--

/*!40000 ALTER TABLE `roomtype` DISABLE KEYS */;
INSERT INTO `roomtype` (`roomtypeid`,`roomtype`) VALUES 
 (1,'AC'),
 (2,'Non-AC');
/*!40000 ALTER TABLE `roomtype` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `emailid` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`emailid`,`phone`,`username`) VALUES 
 ('ehossan25@gmail.com','+885656565','Emran'),
 ('ehossan825@gmail.com','+8801846921763','Emran Hossan'),
 ('ehossan@gmail.com','+880125855656','Emran'),
 ('ibrahim@gmail.com','+8801626547621','Md. Ibrahim');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `emailid` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrole`
--

/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`emailid`,`password`,`role`,`status`) VALUES 
 ('ehossan25@gmail.com','123','ROLE_ADMIN','True'),
 ('ehossan825@gmail.com','123','ROLE_USER','True'),
 ('ehossan@gmail.com','123','ROLE_USER','True'),
 ('ibrahim@gmail.com','123','ROLE_USER','True');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
