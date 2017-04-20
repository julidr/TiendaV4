-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: tienda2
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `Album_id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_Album` date DEFAULT NULL,
  `Genero_Album` varchar(255) DEFAULT NULL,
  `Nombre_Album` varchar(255) DEFAULT NULL,
  `Artista_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Album_id`),
  KEY `FK_album_Artista_id` (`Artista_id`),
  CONSTRAINT `FK_album_Artista_id` FOREIGN KEY (`Artista_id`) REFERENCES `artista` (`Artista_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,NULL,NULL,'19',2),(2,NULL,NULL,'The Fame',4),(3,NULL,NULL,'Ugh',5),(4,NULL,NULL,'In the End',6),(5,NULL,NULL,'Lala',7),(6,NULL,NULL,'VenecoBoy',8),(7,NULL,NULL,'Yes',9),(8,NULL,NULL,'Final Fantasy XIII',10),(9,NULL,NULL,'2',11),(10,NULL,NULL,'3',12),(11,NULL,NULL,'4',15),(12,NULL,NULL,'5',16),(13,NULL,NULL,'6',17),(14,NULL,NULL,'7',18),(15,NULL,NULL,'8',19);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artista` (
  `Artista_id` int(11) NOT NULL AUTO_INCREMENT,
  `Edad_Artista` int(11) DEFAULT NULL,
  `Genero_Artista` varchar(255) DEFAULT NULL,
  `Nacionalidad_Artista` varchar(255) DEFAULT NULL,
  `Nombre_Artistico` varchar(255) DEFAULT NULL,
  `Nombre_Real` varchar(255) DEFAULT NULL,
  `Segundo_Artista` varchar(255) DEFAULT NULL,
  `Tipo_Artista` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Artista_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES (1,NULL,NULL,NULL,'Katy Perry',NULL,NULL,NULL),(2,NULL,NULL,NULL,'Adele',NULL,NULL,NULL),(3,NULL,NULL,NULL,'Lady Gaga',NULL,NULL,NULL),(4,NULL,NULL,NULL,'Lady Gaga',NULL,NULL,NULL),(5,NULL,NULL,NULL,'Nickie Minaj',NULL,NULL,NULL),(6,NULL,NULL,NULL,'Linkin Park',NULL,NULL,NULL),(7,NULL,NULL,NULL,'Steven',NULL,NULL,NULL),(8,NULL,NULL,NULL,'Felix Moreno',NULL,NULL,NULL),(9,NULL,NULL,NULL,'Lala',NULL,NULL,NULL),(10,NULL,NULL,NULL,'Lightning',NULL,NULL,NULL),(11,NULL,NULL,NULL,'pruebita2',NULL,NULL,NULL),(12,NULL,NULL,NULL,'pruebita3',NULL,NULL,NULL),(14,NULL,NULL,NULL,'pruebita4',NULL,NULL,NULL),(15,NULL,NULL,NULL,'pruebita4',NULL,NULL,NULL),(16,NULL,NULL,NULL,'pruebita5',NULL,NULL,NULL),(17,NULL,NULL,NULL,'pruebita6',NULL,NULL,NULL),(18,NULL,NULL,NULL,'Pruebita7',NULL,NULL,NULL),(19,NULL,NULL,NULL,'pruebita8',NULL,NULL,NULL);
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancion`
--

DROP TABLE IF EXISTS `cancion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cancion` (
  `Cancion_id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_Cancion` date DEFAULT NULL,
  `Genero_Cancion` varchar(255) DEFAULT NULL,
  `Nombre_Cancion` varchar(255) DEFAULT NULL,
  `Album_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Cancion_id`),
  KEY `FK_cancion_Album_id` (`Album_id`),
  CONSTRAINT `FK_cancion_Album_id` FOREIGN KEY (`Album_id`) REFERENCES `album` (`Album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancion`
--

LOCK TABLES `cancion` WRITE;
/*!40000 ALTER TABLE `cancion` DISABLE KEYS */;
INSERT INTO `cancion` VALUES (1,NULL,'Pop','Anaconda',3),(2,NULL,'Rock','In the End',4),(3,NULL,'Electronica','Lelo',5),(4,NULL,'pop','Chavez my love',6),(5,NULL,'Pop','One',7),(6,NULL,'Rock','Odin',8),(7,NULL,'pop','prueba2',9),(8,NULL,'Metal','prueba3',10),(9,NULL,'Pop','prueba4',11),(10,NULL,'Jazz','prueba5',12),(11,NULL,'Rock','prueba6',13),(12,NULL,'Metal','Prueba7',14),(13,NULL,'Pop','prueba8',15);
/*!40000 ALTER TABLE `cancion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `Cliente_id` int(11) NOT NULL AUTO_INCREMENT,
  `Correo_Cliente` varchar(255) DEFAULT NULL,
  `Direccion_Cliente` varchar(255) DEFAULT NULL,
  `Nombre_Cliente` varchar(255) DEFAULT NULL,
  `Telefono_Cliente` varchar(255) DEFAULT NULL,
  `Cedula_Cliente` varchar(100) NOT NULL,
  PRIMARY KEY (`Cliente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'juli.milena@hotmail.com','Carrera 69 A #25-35','Juliana ','3012090354','1026293165'),(2,'motherOfDragons@hotmail.com','Calle 16 A #40-124','Daenerys','6692199','1026293164'),(3,'ScarletGirlInArmor@gmail.com','Magnolia','Erza','6698545','1026293163');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `Compra_id` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha_Compra` date DEFAULT NULL,
  `Cancion_id` int(11) DEFAULT NULL,
  `Cliente_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Compra_id`),
  KEY `FK_compra_Cancion_id` (`Cancion_id`),
  KEY `FK_compra_Cliente_id` (`Cliente_id`),
  CONSTRAINT `FK_compra_Cancion_id` FOREIGN KEY (`Cancion_id`) REFERENCES `cancion` (`Cancion_id`),
  CONSTRAINT `FK_compra_Cliente_id` FOREIGN KEY (`Cliente_id`) REFERENCES `cliente` (`Cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'tienda2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-06 20:40:13
