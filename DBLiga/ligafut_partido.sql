CREATE DATABASE  IF NOT EXISTS `ligafut` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ligafut`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: ligafut
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `partido`
--

DROP TABLE IF EXISTS `partido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partido` (
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `resultado` varchar(15) DEFAULT NULL,
  `incidencias` varchar(45) DEFAULT NULL,
  `idEquipo1` int DEFAULT NULL,
  `idEquipo2` int DEFAULT NULL,
  `numCancha` int NOT NULL,
  `dniArbitro` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`fecha`,`hora`,`numCancha`),
  KEY `fk_cancha_idx` (`numCancha`),
  KEY `fk_eq1_idx` (`idEquipo1`),
  KEY `fk_eq2_idx` (`idEquipo2`),
  KEY `fk_arbitro_idx` (`dniArbitro`),
  CONSTRAINT `fk_arbitro` FOREIGN KEY (`dniArbitro`) REFERENCES `arbitro` (`dniArbitro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cancha` FOREIGN KEY (`numCancha`) REFERENCES `cancha` (`numCancha`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eq1` FOREIGN KEY (`idEquipo1`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_eq2` FOREIGN KEY (`idEquipo2`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES ('2022-02-26','19:30:00','1-2',NULL,6,1,2,'1111111'),('2022-02-26','21:15:00','0-2',NULL,5,2,3,'3333333'),('2022-02-27','16:00:00','1-1',NULL,4,3,5,'2222222'),('2022-03-05','17:30:00',' ',NULL,2,1,1,NULL),('2022-03-05','20:45:00',' ',NULL,6,3,4,NULL),('2022-03-06','18:30:00',' ',NULL,5,4,6,NULL),('2022-03-12','18:30:00',' ',NULL,3,1,5,NULL),('2022-03-13','19:30:00',' ',NULL,6,5,1,NULL),('2022-03-13','21:15:00',' ',NULL,2,4,3,NULL),('2022-03-19','16:15:00',' ',NULL,4,1,2,NULL),('2022-03-19','18:45:00',' ',NULL,3,5,6,NULL),('2022-03-20','21:10:00',' ',NULL,2,6,5,NULL),('2022-03-26','18:15:00',' ',NULL,4,1,3,NULL),('2022-03-26','21:30:00',' ',NULL,4,6,4,NULL),('2022-03-27','20:00:00',' ',NULL,3,2,1,NULL);
/*!40000 ALTER TABLE `partido` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-28 18:21:14
