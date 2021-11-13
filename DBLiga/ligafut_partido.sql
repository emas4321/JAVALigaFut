CREATE DATABASE  IF NOT EXISTS `ligafut` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ligafut`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ligafut
-- ------------------------------------------------------
-- Server version	8.0.25

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
  `resultado` varchar(9) DEFAULT NULL,
  `incidencias` varchar(45) DEFAULT NULL,
  `idEquipo1` int DEFAULT NULL,
  `idEquipo2` int DEFAULT NULL,
  `dniArbitro` int DEFAULT NULL,
  `numCancha` int DEFAULT NULL,
  PRIMARY KEY (`fecha`,`hora`),
  KEY `fk_equipo1_idx` (`idEquipo1`),
  KEY `fk_equipo2_idx` (`idEquipo2`),
  KEY `fk_cancha_idx` (`numCancha`),
  KEY `fk_arbtro_idx` (`dniArbitro`),
  CONSTRAINT `fk_arbtro` FOREIGN KEY (`dniArbitro`) REFERENCES `arbitro` (`dniArbitro`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_cancha` FOREIGN KEY (`numCancha`) REFERENCES `cancha` (`numCancha`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo1` FOREIGN KEY (`idEquipo1`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_equipo2` FOREIGN KEY (`idEquipo2`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partido`
--

LOCK TABLES `partido` WRITE;
/*!40000 ALTER TABLE `partido` DISABLE KEYS */;
INSERT INTO `partido` VALUES ('2020-05-06','18:30:00','2-1',NULL,1,4,1111111,2),('2020-05-06','19:10:00','0-3',NULL,3,4,4444444,3),('2020-05-07','14:30:00','2-2',NULL,2,5,2222222,2),('2020-05-10','15:30:00','2-0',NULL,1,5,3333333,1),('2020-05-11','16:45:00','1-1',NULL,2,3,4444444,4),('2020-05-11','20:30:00','0-2',NULL,4,5,1111111,5);
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

-- Dump completed on 2021-11-13  0:07:39
