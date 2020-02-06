-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hotel_db
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endDate` datetime DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `customer_email` varchar(254) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  KEY `user_email` (`customer_email`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`customer_email`) REFERENCES `customer` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` VALUES (19,'2018-08-29 00:00:00','2018-08-28 00:00:00','','pryzyhlei@gmail.com',5),(20,'2018-09-25 00:00:00','2018-09-10 00:00:00','','k@gmail.com',3),(22,'2018-08-29 00:00:00','2018-08-28 00:00:00','','pupkin@gmail.com',1),(23,'2018-09-29 00:00:00','2018-09-17 00:00:00','','pupkin@gmail.com',5),(24,'2018-12-18 00:00:00','2018-10-21 00:00:00','','fuks@gmail.com',4),(25,'2018-09-26 00:00:00','2018-09-16 00:00:00','','asya@gmail.com',1),(26,'2018-12-04 00:00:00','2018-10-16 00:00:00','','pupkin@gmail.com',3),(27,'2018-10-30 00:00:00','2018-10-22 00:00:00','','pupkin@gmail.com',5),(28,'2018-09-12 00:00:00','2018-09-11 00:00:00','','sad',5),(29,'2019-02-18 00:00:00','2018-11-12 00:00:00','','max@gmail.com',5);
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `email` varchar(254) NOT NULL,
  `firstName` varchar(40) DEFAULT NULL,
  `lastName` varchar(40) DEFAULT NULL,
  `contactNumber` varchar(30) DEFAULT NULL,
  `user_email` varchar(254) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`email`),
  KEY `user_email` (`user_email`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`user_email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('','','asdsa','','pryzyhlei@gmail.com',''),('asdf','sdf','','','pryzyhlei@gmail.com',''),('asya@gmail.com','Asya','Asya','1234567','pryzyhlei@gmail.com','asya'),('fuks@gmail.com','Vova','Fuks','12345678','pryzyhlei@gmail.com','fuks'),('k@gmail.com','k','k','000','pryzyhlei@gmail.com','k'),('max@gmail.com','Max','Chornyi','0','pryzyhlei@gmail.com','123'),('pryzyhlei@gmail.com','123','Pryzyhlei','123','pryzyhlei@gmail.com','123'),('pupkin@gmail.com','Vasya','Pupkin','1234','pryzyhlei@gmail.com','pupkin'),('sad','asdf','asd','asd','pryzyhlei@gmail.com','asd'),('vasya@gmail.com','Vasya','Pupkin','79823942','chekin@gmail.com','vasya');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facility`
--

DROP TABLE IF EXISTS `facility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `room_id` int(11) DEFAULT NULL,
  `facility` varchar(255) DEFAULT NULL,
  `facilityCategory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `facility_ibfk_1` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facility`
--

LOCK TABLES `facility` WRITE;
/*!40000 ALTER TABLE `facility` DISABLE KEYS */;
/*!40000 ALTER TABLE `facility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotel` (
  `name` varchar(100) NOT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(80) DEFAULT NULL,
  `stars` int(1) NOT NULL,
  `street` varchar(150) DEFAULT NULL,
  `image` varchar(2083) DEFAULT NULL,
  `description` mediumtext,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('Brewery Gulch Inn, Mendocino','Mendocino','USA',5,'street','https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-image.travelandleisure.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F1600x1000%2Fpublic%2F1525475159%2F061-2-banyan-tree-cabo-marques-TOP100HOTELS0518.jpg%3Fitok%3D8WTdzN27&w=800&q=85',NULL),('Hotel Maria Cristina','San Sebastián','Spain',3,'Street','https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-image.travelandleisure.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F1600x1000%2Fpublic%2F1525476519%2F100-hotel-maria-cristina-TOP100HOTELS0518.jpg%3Fitok%3DFiSWsrXR&w=800&q=85',NULL),('hotelname','Lviv','Ukraine',4,'Zelena','',NULL),('Spectator Hotel','Charleston','USA',4,'street','https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-image.travelandleisure.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F1600x1000%2Fpublic%2F1525475159%2F061-2-banyan-tree-cabo-marques-TOP100HOTELS0518.jpg%3Fitok%3D8WTdzN27&w=800&q=85',NULL),('The Beekman, a Thompson Hotel','New York','USA',5,'street','https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-image.travelandleisure.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F1600x1000%2Fpublic%2F1525475159%2F061-2-banyan-tree-cabo-marques-TOP100HOTELS0518.jpg%3Fitok%3D8WTdzN27&w=800&q=85',NULL),('The Lanesborough','London','England',5,'street','https://imagesvc.timeincapp.com/v3/mm/image?url=https%3A%2F%2Fcdn-image.travelandleisure.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2F1600x1000%2Fpublic%2F1525475159%2F061-2-banyan-tree-cabo-marques-TOP100HOTELS0518.jpg%3Fitok%3D8WTdzN27&w=800&q=85',NULL);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numberOfpeople` tinyint(4) NOT NULL,
  `priceInDollars` int(11) DEFAULT NULL,
  `roomType` varchar(100) DEFAULT NULL,
  `roomnumber` smallint(4) NOT NULL,
  `hotel_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `hotel_name` (`hotel_name`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`hotel_name`) REFERENCES `hotel` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,3,455,'Classic',111,'Spectator Hotel'),(2,5,233,'Classic',112,'Spectator Hotel'),(3,2,4332,'Classic',232,'Spectator Hotel'),(4,3,5343,'Classic',432,'The Beekman, a Thompson Hotel'),(5,1,5343,'Classic',234,'The Beekman, a Thompson Hotel');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `email` varchar(254) NOT NULL,
  `firstName` varchar(40) DEFAULT NULL,
  `lastName` varchar(40) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `userRole` varchar(20) DEFAULT 'ROLE_USER',
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('123@gmail.com','123','123','123','ROLE_USER'),('chekin@gmail.com','Chekin','Chekin','chekin','ROLE_USER'),('h@gmail.com','h','h','h','ROLE_USER'),('max@gmail.com','Max','Max','123','ROLE_USER'),('pryzyhlei@gmail.com','Kostyantyn','Pryzyhlei','123','ROLE_ADMIN'),('vasy@gmail.com','Vasya','Vasya','123','ROLE_ADMIN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa`
--

DROP TABLE IF EXISTS `visa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `visa` (
  `visa_number` varchar(100) NOT NULL,
  `country` varchar(80) DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `customer_email` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`visa_number`),
  KEY `customer_email` (`customer_email`),
  CONSTRAINT `visa_ibfk_1` FOREIGN KEY (`customer_email`) REFERENCES `customer` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visa`
--

LOCK TABLES `visa` WRITE;
/*!40000 ALTER TABLE `visa` DISABLE KEYS */;
INSERT INTO `visa` VALUES ('1','Ukraine','2019-01-22 00:00:00','2018-09-09 00:00:00','k@gmail.com'),('123456','Ukraine','2018-09-18 00:00:00','2018-09-11 00:00:00','k@gmail.com'),('2','India','2018-08-15 00:00:00','2018-08-13 00:00:00','k@gmail.com'),('3','United States','2018-10-22 00:00:00','2018-09-16 00:00:00','k@gmail.com'),('visanumberdsf','Ukraine','2018-08-23 00:00:00','2018-08-15 00:00:00','pryzyhlei@gmail.com');
/*!40000 ALTER TABLE `visa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-06 23:44:23
