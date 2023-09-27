-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: macnss
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin@gmail.com','92668751');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `agent`
--

DROP TABLE IF EXISTS `agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agent` (
  `agent_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agent`
--

LOCK TABLES `agent` WRITE;
/*!40000 ALTER TABLE `agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cnss_form`
--

DROP TABLE IF EXISTS `cnss_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cnss_form` (
  `cnss_form_id` int NOT NULL AUTO_INCREMENT,
  `total_price` float NOT NULL,
  `attachements_number` int NOT NULL,
  `status` enum('Approved','Rejected','Pending') DEFAULT 'Pending',
  `patient_number` int NOT NULL,
  PRIMARY KEY (`cnss_form_id`),
  KEY `fk_patient_registration_number` (`patient_number`),
  CONSTRAINT `fk_patient_registration_number` FOREIGN KEY (`patient_number`) REFERENCES `patient` (`registration_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cnss_form`
--

LOCK TABLES `cnss_form` WRITE;
/*!40000 ALTER TABLE `cnss_form` DISABLE KEYS */;
/*!40000 ALTER TABLE `cnss_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `ean_code` varchar(13) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `reimbursable_price` decimal(10,2) NOT NULL,
  `ReimbursementPercentage` int NOT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'GLUCOR ACARBOSE','6118000170143',49.70,34.79,70),(2,'GLUCOR ACARBOSE','6118000170167',92.00,64.40,70),(3,'SECTRAL ACEBUTOLOL','6118000060154',37.80,26.46,70),(4,'SECTRAL ACEBUTOLOL','6118000060598',104.20,72.94,70),(5,'AIRTAL ACECLOFENAC','6118000080060',54.20,37.94,70),(6,'RANTUDIL RETARD ACEMETACINE','6118000170259',58.90,41.23,70),(7,'RANTUDIL FORT ACEMETACINE','6118000170242',37.80,26.46,70),(8,'SINTROM ACENOCOUMAROL','6118000220145',17.90,12.53,70),(9,'DIAMOX ACETAZOLAMIDE','6118000012337',19.00,13.30,70),(10,'ZOVIRAX ACICLOVIR','6118001141562',171.40,119.98,70),(11,'CICLOVIRAL ACICLOVIR','6118001250165',672.00,470.40,70),(12,'CUSIVIRAL ACICLOVIR','6118001250264',85.30,59.71,70),(13,'ZOVIRAX ACICLOVIR','6118001141579',85.30,59.71,70),(14,'CICLOVIRAL ACICLOVIR','6118000071310',265.00,185.50,70),(15,'HERPEVIR ACICLOVIR','6118000230281',171.00,119.70,70),(16,'CICLOVIRAL ACICLOVIR','6118000070313',209.00,146.30,70),(17,'ZOVIRAX ACICLOVIR','6118001141531',232.00,146.30,70),(18,'CICLOVIRAL ACICLOVIR','6118000071303',270.00,189.00,70),(19,'CICLOVIRAL ACICLOVIR','6118000071327',502.00,351.40,70),(20,'REVOCIR ACICLOVIR','6118000241324',577.00,403.90,70),(21,'HERPEVIR ACICLOVIR','6118000230298',736.00,515.20,70),(22,'ASPEGIC AD ACIDE ACETYLSALICYLIQUE','6118001080922',81.60,57.12,70),(23,'ASPEGIC ACIDE ACETYLSALICYLIQUE','6118001080939',57.00,39.90,70);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `registration_number` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(255) NOT NULL,
  `cin` varchar(8) NOT NULL,
  `address` varchar(255) NOT NULL,
  `birth_date` date NOT NULL,
  PRIMARY KEY (`registration_number`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'John Smith','ABC12345','123 Main Street, Casablanca','1990-05-15'),(2,'Fatima Ahmed','DEF67890','456 Elm Avenue, Marrakech','1985-08-22'),(3,'Mohamed Hassan','GHI54321','789 Oak Road, Rabat','1993-02-10'),(4,'Amina Zouhir','JKL67890','101 Cedar Lane, Fez','1980-11-05'),(5,'Karim Amrani','MNO12345','222 Pine Street, Tangier','1975-09-30'),(6,'Nadia El Haddad','PQR54321','333 Birch Avenue, Agadir','1998-04-18'),(7,'Ahmed Bouazza','STU67890','444 Willow Road, Oujda','1987-07-12'),(8,'Hassan Fathi','VWX12345','555 Maple Lane, Essaouira','1995-01-25'),(9,'Sara Mansouri','YZA54321','666 Oak Street, Tetouan','1983-06-08'),(10,'Laila El Kadi','BCD67890','777 Cedar Avenue, Chefchaouen','1991-03-03');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-23 14:48:15
