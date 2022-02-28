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
-- Table structure for table `jugador`
--

DROP TABLE IF EXISTS `jugador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugador` (
  `dniJugador` varchar(10) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(25) DEFAULT NULL,
  `fechaNac` date DEFAULT NULL,
  `posicion` varchar(15) DEFAULT NULL,
  `goles` int DEFAULT NULL,
  `asistencias` int DEFAULT NULL,
  `amarillas` int DEFAULT NULL,
  `rojas` int DEFAULT NULL,
  `partJugados` int DEFAULT NULL,
  `idEquipo` int DEFAULT NULL,
  PRIMARY KEY (`dniJugador`),
  KEY `fk_eq_idx` (`idEquipo`),
  CONSTRAINT `fk_eq` FOREIGN KEY (`idEquipo`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugador`
--

LOCK TABLES `jugador` WRITE;
/*!40000 ALTER TABLE `jugador` DISABLE KEYS */;
INSERT INTO `jugador` VALUES ('11598789','Kasper','Schmeichel','1986-11-05','arquero',0,2,3,0,12,1),('12361296','Jamie','Vardy','1987-01-11','delantero',15,8,3,0,10,1),('15161665','Hugo','Lloris','1986-12-26','arquero',0,1,4,1,15,2),('15648753','Kevin','Strootman','1990-02-13','mediocampista',2,5,2,0,10,6),('15662196','Karim','Benzema','1987-12-19','delantero',12,5,1,0,20,3),('18112110','Marco','Benasi','1994-09-08','mediocampista',8,9,2,1,22,5),('18965221','Lorenzo','Venuti','1995-04-12','defensor',2,1,1,0,20,5),('20154196','Harry','Kane','1993-07-28','delantero',12,8,4,0,18,2),('21630123','Lucas','Torreira','1996-02-11','mediocampista',5,2,3,1,18,5),('22321496','Luka','Modric','1985-09-09','mediocampista',4,10,2,0,15,3),('25161296','Heung-min','Son','1992-08-07','delantero',10,7,3,1,15,2),('25661665','Thibaut','Courtois','1991-05-11','arquero',0,0,3,0,16,3),('26161628','Gareth','Bale','1989-07-16','delantero',8,9,2,1,22,3),('30961210','Dani','Carvajal','1992-01-11','defensor',5,2,3,1,18,3),('31961215','Davinson','Sanchez','1996-06-12','defensor',1,0,8,3,15,2),('34961296','Youri','Tielemans','1997-05-07','mediocampista',5,10,3,0,15,1),('35961296','Wesley','Fofana','2000-12-17','defensor',2,3,6,1,8,1),('36546921','Alberto','Grassi','1995-03-07','mediocampista',5,6,4,1,11,6),('38465892','Razvan','Marin','1996-05-23','delantero',10,4,3,0,10,6),('38961215','James','Maddison','1996-11-23','mediocampista',3,9,4,1,12,1),('39825647','Alessio','Cragno','1994-06-28','arquero',0,2,2,0,11,6),('42569874','Giorgio','Altare','1998-08-09','defensor',2,1,5,2,9,6),('43405894','Dusan','Vlahovic','2000-01-28','delantero',12,5,4,0,12,4),('46156812','Pietro','Terracciano','1990-03-08','arquero',0,0,3,0,16,5),('46521012','Giorgio','Chiellini','1984-08-14','defensor',1,0,3,0,16,4),('48749221','Álvaro','Morata','1992-10-23','delantero',9,6,2,0,15,4),('61212110','Wojciech','Szczesny','1990-04-18','arquero',0,2,2,1,22,4),('68984221','Leonardo','Bonucci','1987-05-01','defensor',3,2,1,0,20,4),('95130123','Rodrigo','Bentancur','1997-06-25','mediocampista',5,2,3,1,18,2),('97549221','Jose','Callejon','1987-02-11','delantero',7,4,2,0,15,5);
/*!40000 ALTER TABLE `jugador` ENABLE KEYS */;
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
