-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 21, 2013 at 06:06 PM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `article`
--
CREATE DATABASE IF NOT EXISTS library;
USE library;

CREATE TABLE IF NOT EXISTS `article` (
  `itemID` int(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `magazine` varchar(50) NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `article`
--

INSERT INTO `article` (`itemID`, `title`, `author`, `magazine`) VALUES
(11, 'PlayBoy', 'Roman', 'Kokoting'),
(23, 'Get Shit Done', 'Martins', 'FEBE');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE IF NOT EXISTS `books` (
  `itemID` int(50) NOT NULL,
  `title` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `ISBN` int(50) NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`itemID`, `title`, `author`, `ISBN`) VALUES
(22, 'Ideja', 'Gatis', 123123123),
(333, 'asd', 'asd', 12333),
(444, '555555555', '123', 0),
(3333, 'LoL', 'Karlis', 134888788);

-- --------------------------------------------------------

--
-- Table structure for table `borroweditems`
--

CREATE TABLE IF NOT EXISTS `borroweditems` (
  `dateFrom` date NOT NULL,
  `dateTo` date NOT NULL,
  `itemID` int(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borroweditems`
--

INSERT INTO `borroweditems` (`dateFrom`, `dateTo`, `itemID`, `email`) VALUES
('2013-08-21', '2014-02-21', 22, 'tea');

-- --------------------------------------------------------

--
-- Table structure for table `borrower`
--

CREATE TABLE IF NOT EXISTS `borrower` (
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `borrower`
--

INSERT INTO `borrower` (`name`, `email`, `status`) VALUES
('ASD', 'asdsd', 'student'),
('Atis', 'atis.sirmais@gmail.com', 'student'),
('Ice', 'tea', 'student'),
('Roman', 'www.ffs.sk', 'Still Kokoting');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `itemID` int(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `notificationValue` int(1) NOT NULL,
  PRIMARY KEY (`itemID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `email` varchar(50) NOT NULL,
  `itemID` int(50) NOT NULL,
  `dateFrom` date NOT NULL,
  `reservationID` int(50) NOT NULL,
  PRIMARY KEY (`reservationID`),
  KEY `dateFrom` (`dateFrom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`email`, `itemID`, `dateFrom`, `reservationID`) VALUES
('rrrrrr', 444, '2015-12-12', 222),
('aaa', 999, '2013-08-21', 9990);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
