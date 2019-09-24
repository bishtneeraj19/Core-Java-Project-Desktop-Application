-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.18-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema demand_management_system
--

CREATE DATABASE IF NOT EXISTS demand_management_system;
USE demand_management_system;

--
-- Definition of table `assigndriver`
--

DROP TABLE IF EXISTS `assigndriver`;
CREATE TABLE `assigndriver` (
  `AssignId` int(10) unsigned NOT NULL auto_increment,
  `DriverId` varchar(30) NOT NULL,
  `ClientId` varchar(30) NOT NULL,
  `Date` date NOT NULL,
  `Duration` int(10) unsigned NOT NULL,
  `TotalCharges` float NOT NULL,
  PRIMARY KEY  (`AssignId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `assigndriver`
--

/*!40000 ALTER TABLE `assigndriver` DISABLE KEYS */;
INSERT INTO `assigndriver` (`AssignId`,`DriverId`,`ClientId`,`Date`,`Duration`,`TotalCharges`) VALUES 
 (1,'d01','c01','2019-07-22',4,3000),
 (2,'d02','c01','2019-07-22',4,3000),
 (3,'d03','c01','2019-07-25',5,3000),
 (4,'d01','c01','2019-07-26',3,2222),
 (5,'d01','c01','2019-07-25',6,2000),
 (6,'d01','c001','2019-07-25',4,2000),
 (7,'d02','c01','2019-07-25',4,2000);
/*!40000 ALTER TABLE `assigndriver` ENABLE KEYS */;


--
-- Definition of table `clientdetails`
--

DROP TABLE IF EXISTS `clientdetails`;
CREATE TABLE `clientdetails` (
  `ClientId` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Address` varchar(50) NOT NULL,
  PRIMARY KEY  (`ClientId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `clientdetails`
--

/*!40000 ALTER TABLE `clientdetails` DISABLE KEYS */;
INSERT INTO `clientdetails` (`ClientId`,`Name`,`Email`,`PhoneNo`,`Address`) VALUES 
 ('c01','neeraj','n@gmail.com','4578961236','lko');
/*!40000 ALTER TABLE `clientdetails` ENABLE KEYS */;


--
-- Definition of table `driverdetails`
--

DROP TABLE IF EXISTS `driverdetails`;
CREATE TABLE `driverdetails` (
  `DriverId` varchar(30) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `PhoneNo` varchar(10) NOT NULL,
  `Age` int(10) unsigned NOT NULL,
  `Gender` varchar(30) NOT NULL,
  `Address` varchar(50) NOT NULL,
  PRIMARY KEY  (`DriverId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driverdetails`
--

/*!40000 ALTER TABLE `driverdetails` DISABLE KEYS */;
INSERT INTO `driverdetails` (`DriverId`,`Name`,`Email`,`PhoneNo`,`Age`,`Gender`,`Address`) VALUES 
 ('d01','neeraj','neeraj@gmail.com','8578961236',30,'male','lko'),
 ('d02','kausal','k@gmail.com','5559966332',26,'male','lko'),
 ('d03','sudhansu','s@gmail.com','7458691236',34,'male','lko');
/*!40000 ALTER TABLE `driverdetails` ENABLE KEYS */;


--
-- Definition of table `feedbackinfo`
--

DROP TABLE IF EXISTS `feedbackinfo`;
CREATE TABLE `feedbackinfo` (
  `Fid` varchar(30) NOT NULL,
  `DriverId` varchar(30) NOT NULL,
  `ClientId` varchar(30) NOT NULL,
  `Date` date NOT NULL,
  `Text` varchar(255) NOT NULL,
  PRIMARY KEY  (`Fid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedbackinfo`
--

/*!40000 ALTER TABLE `feedbackinfo` DISABLE KEYS */;
INSERT INTO `feedbackinfo` (`Fid`,`DriverId`,`ClientId`,`Date`,`Text`) VALUES 
 ('f001','d01','c01','2019-07-20','nice'),
 ('f01','d01','c01','2019-07-23','good driver');
/*!40000 ALTER TABLE `feedbackinfo` ENABLE KEYS */;


--
-- Definition of table `requestdriver`
--

DROP TABLE IF EXISTS `requestdriver`;
CREATE TABLE `requestdriver` (
  `RequestId` int(10) unsigned NOT NULL auto_increment,
  `BookingDate` date NOT NULL,
  `Duration` int(10) unsigned NOT NULL,
  `RequestDate` date NOT NULL,
  `ClientId` varchar(30) NOT NULL,
  PRIMARY KEY  (`RequestId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `requestdriver`
--

/*!40000 ALTER TABLE `requestdriver` DISABLE KEYS */;
INSERT INTO `requestdriver` (`RequestId`,`BookingDate`,`Duration`,`RequestDate`,`ClientId`) VALUES 
 (1,'2019-07-18',4,'2019-07-22','c01'),
 (2,'2019-07-19',4,'2019-07-22','c01'),
 (3,'2019-07-19',5,'2019-07-25','c01'),
 (4,'2019-07-19',3,'2019-07-26','c01'),
 (5,'2019-07-19',6,'2019-07-25','c01');
/*!40000 ALTER TABLE `requestdriver` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
