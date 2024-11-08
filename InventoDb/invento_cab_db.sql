-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: invento_cab_db
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `items_data`
--

DROP TABLE IF EXISTS `items_data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_data` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ItemID` varchar(250) DEFAULT NULL,
  `Title` varchar(250) DEFAULT NULL,
  `Location` varchar(250) DEFAULT NULL,
  `Category` varchar(250) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `Status` varchar(250) DEFAULT NULL,
  `Image` longblob,
  `DateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `DateUpdated` datetime DEFAULT NULL,
  `DateDeleted` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `id_UNIQUE` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_data`
--

LOCK TABLES `items_data` WRITE;
/*!40000 ALTER TABLE `items_data` DISABLE KEYS */;
INSERT INTO `items_data` VALUES (1,'test','dgfs','Item 1','Item 1',0,'Item 1',NULL,'2024-10-22 20:21:34',NULL,NULL),(2,'test','testing','Item 1','Item 1',0,'Item 1',NULL,'2024-10-22 20:45:00',NULL,NULL),(3,'test','test2','Item 1','Item 4',0,'Item 2',NULL,'2024-10-22 20:46:58',NULL,NULL),(4,'test','Rasberry pi 3','North ','Microcontroller Components',5,'Available',NULL,'2024-10-22 21:03:15',NULL,NULL),(5,'test','gdf','South','Resistor Components',4,'Unavailable',NULL,'2024-11-08 20:46:56',NULL,NULL);
/*!40000 ALTER TABLE `items_data` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-08 20:48:53
