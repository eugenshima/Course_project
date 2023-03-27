-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: kpbase
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `finalsalary`
--

DROP TABLE IF EXISTS `finalsalary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `finalsalary` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PersonID` int NOT NULL,
  `rolesID` int NOT NULL,
  `ReportCardID` int NOT NULL,
  `taxesID` int NOT NULL,
  `FinalSalary` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonID` (`PersonID`),
  KEY `ReportCardID` (`ReportCardID`),
  KEY `rolesID` (`rolesID`),
  KEY `taxesID` (`taxesID`),
  CONSTRAINT `finalsalary_ibfk_1` FOREIGN KEY (`PersonID`) REFERENCES `person` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `finalsalary_ibfk_2` FOREIGN KEY (`ReportCardID`) REFERENCES `reportcard` (`RCID`) ON DELETE CASCADE,
  CONSTRAINT `finalsalary_ibfk_3` FOREIGN KEY (`rolesID`) REFERENCES `roles` (`RID`) ON DELETE CASCADE,
  CONSTRAINT `finalsalary_ibfk_4` FOREIGN KEY (`taxesID`) REFERENCES `taxes` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `UserFName` varchar(20) NOT NULL,
  `UserLName` varchar(20) NOT NULL,
  `PhoneNumber` varchar(20) NOT NULL,
  `Email` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reportcard`
--

DROP TABLE IF EXISTS `reportcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reportcard` (
  `RCID` int NOT NULL AUTO_INCREMENT,
  `PersonID` int NOT NULL,
  `DaysWorked` int NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL,
  PRIMARY KEY (`RCID`),
  KEY `PersonID` (`PersonID`),
  CONSTRAINT `reportcard_ibfk_1` FOREIGN KEY (`PersonID`) REFERENCES `person` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `RID` int NOT NULL AUTO_INCREMENT,
  `PersonID` int NOT NULL,
  `URole` varchar(10) NOT NULL,
  PRIMARY KEY (`RID`),
  KEY `PersonID` (`PersonID`),
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`PersonID`) REFERENCES `person` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `staffing`
--

DROP TABLE IF EXISTS `staffing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staffing` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PersonID` int NOT NULL,
  `RoleID` int NOT NULL,
  `Casing` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonID` (`PersonID`),
  KEY `RoleID` (`RoleID`),
  CONSTRAINT `staffing_ibfk_1` FOREIGN KEY (`PersonID`) REFERENCES `person` (`ID`) ON DELETE CASCADE,
  CONSTRAINT `staffing_ibfk_2` FOREIGN KEY (`RoleID`) REFERENCES `roles` (`RID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `taxes`
--

DROP TABLE IF EXISTS `taxes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taxes` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `PersonID` int NOT NULL,
  `UserTaxes` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `PersonID` (`PersonID`),
  CONSTRAINT `taxes_ibfk_1` FOREIGN KEY (`PersonID`) REFERENCES `person` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `PersonID` int NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`UID`),
  KEY `PersonID` (`PersonID`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`PersonID`) REFERENCES `person` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-27 14:13:15
