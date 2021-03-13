-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `authers`
--

DROP TABLE IF EXISTS `authers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `bookID` int DEFAULT NULL,
  `autherName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_authbookID` (`bookID`),
  CONSTRAINT `authers_ibfk_1` FOREIGN KEY (`bookID`) REFERENCES `books` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authers`
--

LOCK TABLES `authers` WRITE;
/*!40000 ALTER TABLE `authers` DISABLE KEYS */;
INSERT INTO `authers` VALUES (1,1,'Rudolf Ruskprick'),(2,2,'Kenny Surströmming'),(3,3,'Orvar Satorsson'),(4,4,'Sara Tryffelsten'),(5,5,'Inga Skoghorn'),(6,6,'Tore Tofs'),(7,7,'Oskar Rudenerg'),(8,8,'Benny Bläck');
/*!40000 ALTER TABLE `authers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `pages` int DEFAULT NULL,
  `classification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Den ensamma katten',123,'Hce'),(2,'Vägen till Väterås',244,'Hce'),(3,'Grisarnas julafton',198,'Hce'),(4,'Blomkålsmördaren',55,'uHce'),(5,'Min faster Ingeborg',763,'Hcf'),(6,'Askorbinsyra utan smör',199,'Hcf'),(7,'Lastbilens tankar',452,'uHce'),(8,'Benny Bläcks liv',111,'Hce');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `burrowers`
--

DROP TABLE IF EXISTS `burrowers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `burrowers` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phoneID` int DEFAULT NULL,
  `cardNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burrowers`
--

LOCK TABLES `burrowers` WRITE;
/*!40000 ALTER TABLE `burrowers` DISABLE KEYS */;
INSERT INTO `burrowers` VALUES (1,'Viggo Filtner','Vägen 1, Nollberga',1,'1234'),(2,'Pelle Pälsänger','Vägen 20, Nollberga',2,'4536'),(3,'Bosse Baron','Vägen 5, Nollberga',3,'3347'),(4,'Explorer Johansson','Vägen 123, Nollberga',4,'1111'),(5,'Elof Öman','Vägen 24, Nollberga',5,'2112');
/*!40000 ALTER TABLE `burrowers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `burrowersphone`
--

DROP TABLE IF EXISTS `burrowersphone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `burrowersphone` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `burrowerID` int DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `burrowersphone`
--

LOCK TABLES `burrowersphone` WRITE;
/*!40000 ALTER TABLE `burrowersphone` DISABLE KEYS */;
INSERT INTO `burrowersphone` VALUES (1,1,'11111'),(2,2,'2222'),(3,3,'3333'),(4,4,'44444'),(5,5,'5555');
/*!40000 ALTER TABLE `burrowersphone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employeephone`
--

DROP TABLE IF EXISTS `employeephone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employeephone` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `employeeID` int DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `phone2` varchar(100) DEFAULT NULL,
  `phone3` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `employeeID` (`employeeID`),
  CONSTRAINT `employeephone_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employees` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employeephone`
--

LOCK TABLES `employeephone` WRITE;
/*!40000 ALTER TABLE `employeephone` DISABLE KEYS */;
INSERT INTO `employeephone` VALUES (1,1,'13647','0','67869'),(2,2,'365868','6789',NULL),(3,3,'68686','0','0');
/*!40000 ALTER TABLE `employeephone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `daysOff` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'Asta Kask','Vägen 2, Nollberga',12000,'10'),(2,'Ebba Grön','Vägen 4, Nollberga',83000,'21'),(3,'Farbror Blå','Vägen 8 , Nollberga',7000,'30');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `magazine`
--

DROP TABLE IF EXISTS `magazine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `magazine` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `section` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `magazine`
--

LOCK TABLES `magazine` WRITE;
/*!40000 ALTER TABLE `magazine` DISABLE KEYS */;
INSERT INTO `magazine` VALUES (1,'Illustrerad Ångest','2020-12-12','Hylla A'),(2,'Illustrerad Ångest','1985-10-20','Hylla A'),(3,'Illustrerad Ångest','1985-10-11','Hylla A'),(4,'Veckans Tråkigaste','1998-01-01','Hylla A'),(5,'Veckans Tråkigaste','2012-11-05','Hylla A'),(6,'Dagens Tidning','2010-11-11','Hylla B'),(7,'Dagens Tidning','2010-11-10','Hylla B'),(8,'Dagens Tidning','2010-11-09','Hylla B'),(9,'Dagens Tidning','2012-04-05','Hylla B'),(10,'Dagens Tidning','2008-10-05','Hylla B'),(11,'Gårdagens Tidning','1988-10-10','Hylla C'),(12,'Gårdagens Tidning','1975-04-05','Hylla C'),(13,'Gårdagens Tidning','1992-10-10','Hylla C'),(14,'Gårdagens Tidning','1944-02-03','Hylla C'),(15,'Gårdagens Tidning','1957-11-24','Hylla C'),(16,'Gårdagens Tidning','1922-12-01','Hylla C'),(17,'Nyheter från Vattenpölen','2001-06-13','Hylla B'),(18,'Nyheter från Vattenpölen','2003-11-04','Hylla B'),(19,'Nyheter från Vattenpölen','2010-04-13','Hylla B'),(20,'Nyheter från Vattenpölen','2000-01-04','Hylla B'),(21,'Nyheter från Vattenpölen','2015-06-26','Hylla B'),(22,'Moderna trasor','2001-01-05','Hylla A'),(23,'Moderna trasor','2005-08-10','Hylla A'),(24,'Moderna trasor','2017-10-17','Hylla A'),(25,'Moderna trasor','2018-02-02','Hylla A'),(26,'Moderna trasor','2005-08-20','Hylla A'),(27,'Burksamlaren','2012-03-05','Hylla C'),(28,'Burksamlaren','2012-03-07','Hylla C'),(29,'Burksamlaren','2012-03-09','Hylla C');
/*!40000 ALTER TABLE `magazine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `onloan`
--

DROP TABLE IF EXISTS `onloan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `onloan` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `burrowerID` int DEFAULT NULL,
  `bookID` int DEFAULT NULL,
  `magazineID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `idx_burrowerID` (`burrowerID`),
  KEY `idx_bookID` (`bookID`),
  KEY `magazineID` (`magazineID`),
  CONSTRAINT `onloan_ibfk_1` FOREIGN KEY (`burrowerID`) REFERENCES `burrowers` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `onloan_ibfk_2` FOREIGN KEY (`bookID`) REFERENCES `books` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `onloan_ibfk_3` FOREIGN KEY (`magazineID`) REFERENCES `magazine` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `onloan`
--

LOCK TABLES `onloan` WRITE;
/*!40000 ALTER TABLE `onloan` DISABLE KEYS */;
INSERT INTO `onloan` VALUES (1,1,1,NULL),(2,1,4,NULL),(3,3,7,NULL),(4,4,8,NULL),(5,4,3,NULL),(15,5,2,NULL),(16,5,6,NULL);
/*!40000 ALTER TABLE `onloan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-14  0:16:10
