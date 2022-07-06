-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: wefly
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `music`
--

DROP TABLE IF EXISTS `music`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `music` (
  `id` int NOT NULL,
  `artistzw` varchar(15) DEFAULT NULL,
  `artisteng` varchar(80) DEFAULT NULL,
  `songzw` varchar(45) DEFAULT NULL,
  `lyricslanguage` varchar(10) DEFAULT NULL,
  `songeng` varchar(80) DEFAULT NULL,
  `yturl` varchar(50) DEFAULT NULL,
  `duration` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `music`
--

LOCK TABLES `music` WRITE;
/*!40000 ALTER TABLE `music` DISABLE KEYS */;
INSERT INTO `music` VALUES (1,NULL,'Billie Eilish',NULL,'英文','bad guy','https://www.youtube.com/embed/DyDfgMOUjCI','03:25:00'),(2,NULL,'Lauv',NULL,'英文','Modern Loneliness','https://www.youtube.com/embed/bDidwMxir4o','04:07:00'),(3,NULL,'Liam Payne ft. Quavo',NULL,'英文','Strip That Down','https://www.youtube.com/embed/vSW2M-BB1NE','03:41:00'),(4,NULL,'Martin Garrix & David Guetta ft. Jamie Scott',NULL,'英文','So Far Away','https://www.youtube.com/embed/o7iL2KzDh38','03:04:00'),(5,NULL,'Halsey',NULL,'英文','You should be sad','https://www.youtube.com/embed/8nBFqZppIF0','03:38:00'),(6,'魚丁糸',NULL,'沙發裡有沙發Radio','中文',NULL,'https://www.youtube.com/embed/2HwQQwDWO2s','03:30:00'),(7,'告五人',NULL,'愛在夏天','中文',NULL,'https://www.youtube.com/embed/_zv8Y94eLYI','06:37:00'),(8,'樂童音樂家',NULL,'어떻게 이별까지 사랑하겠어, 널 사랑하는 거지','韓文','How can I love the heartbreak, you\'re the one I love','https://www.youtube.com/embed/m3DZsBw5bnE','04:56:00'),(9,NULL,'NELL','기억을 걷는 시간','韓文','Time Walking On Memory','https://www.youtube.com/embed/HW5HU6o1eMA','05:53:00'),(10,'朴孝信','박효신','야생화','韓文','Wild Flower','https://www.youtube.com/embed/OxgiiyLp5pk','05:39:00'),(11,NULL,'Monday Kiz & Punch',NULL,'韓文','Another Day','https://www.youtube.com/embed/CGnc553-ttg','03:51:00'),(12,'金鐘鉉','JONGHYUN','하루의 끝','韓文','End of a day','https://www.youtube.com/embed/wGP-gfCWXYI','05:06:00'),(13,'太妍','TAEYEON','11:11','韓文','11:11','https://www.youtube.com/embed/ulr0muQKjk0','03:50:00'),(14,'李遐怡','LEE HI','한숨','韓文','BREATHE','https://www.youtube.com/embed/5iSlfF8TQ9k','04:54:00'),(15,'愛繆','Aimyon','知道天空有多藍的人啊','日文','空の青さを知る人よ','https://www.youtube.com/embed/eFEPTEab4sQ','05:08:00'),(16,'四堅情',NULL,'速食愛情','中文',NULL,'https://www.youtube.com/embed/rbs76CPrZD8','03:49:00');
/*!40000 ALTER TABLE `music` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-03 20:41:30
