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
INSERT INTO `music` VALUES (1,NULL,'Billie Eilish',NULL,'英文','bad guy','https://www.youtube.com/embed/DyDfgMOUjCI','03:25:00'),(2,NULL,'Lauv',NULL,'英文','Modern Loneliness','https://www.youtube.com/embed/bDidwMxir4o','04:07:00'),(3,NULL,'Liam Payne ft. Quavo',NULL,'英文','Strip That Down','https://www.youtube.com/embed/vSW2M-BB1NE','03:41:00'),(4,NULL,'Martin Garrix & David Guetta ft. Jamie Scott',NULL,'英文','So Far Away','https://www.youtube.com/embed/o7iL2KzDh38','03:04:00'),(5,NULL,'Halsey',NULL,'英文','You should be sad','https://www.youtube.com/embed/8nBFqZppIF0','03:38:00'),(6,'魚丁糸',NULL,'沙發裡有沙發Radio','中文',NULL,'https://www.youtube.com/embed/2HwQQwDWO2s','03:30:00'),(7,'告五人',NULL,'愛在夏天','中文',NULL,'https://www.youtube.com/embed/_zv8Y94eLYI','06:37:00'),(8,'樂童音樂家',NULL,'어떻게 이별까지 사랑하겠어, 널 사랑하는 거지','日韓','How can I love the heartbreak, you\'re the one I love','https://www.youtube.com/embed/m3DZsBw5bnE','04:56:00'),(9,NULL,'NELL','기억을 걷는 시간','日韓','Time Walking On Memory','https://www.youtube.com/embed/HW5HU6o1eMA','05:53:00'),(10,'周興哲',NULL,'你，好不好？','中文',NULL,'https://www.youtube.com/embed/wSBXfzgqHtE','04:48:00'),(11,NULL,'Monday Kiz & Punch',NULL,'日韓','Another Day','https://www.youtube.com/embed/CGnc553-ttg','03:51:00'),(12,'金鐘鉉',NULL,'End of a day','日韓',NULL,'https://www.youtube.com/embed/wGP-gfCWXYI','05:06:00'),(13,'太妍',NULL,'11:11','日韓',NULL,'https://www.youtube.com/embed/ulr0muQKjk0','03:50:00'),(14,NULL,'Travis Scott',NULL,'英文','BUTTERFLY EFFECT','https://www.youtube.com/embed/_EyZUTDAH0U','03:32:00'),(15,'愛繆',NULL,'知道天空有多藍的人啊','日韓',NULL,'https://www.youtube.com/embed/eFEPTEab4sQ','05:08:00'),(16,'四堅情',NULL,'速食愛情','中文',NULL,'https://www.youtube.com/embed/rbs76CPrZD8','03:49:00'),(17,'柏松',NULL,'世間美好與你環環相扣','中文',NULL,'https://www.youtube.com/embed/7HnliungRWI','03:12:00'),(18,'郁可唯',NULL,'路過人間','中文',NULL,'https://www.youtube.com/embed/FMl7GEaYwAE','04:03:00'),(19,'陳雪凝',NULL,'綠色','中文',NULL,'https://www.youtube.com/embed/WY6nQK7zbsk','04:30:00'),(20,'莫文蔚',NULL,'慢慢喜歡你','中文',NULL,'https://www.youtube.com/embed/-lEhWfucJMs','06:07:00'),(21,NULL,'Shallou',NULL,'英文','Fading','https://www.youtube.com/embed/BkLMqWXKGWs','04:43:00'),(22,NULL,'K-391, Alan Walker & Ahrix',NULL,'英文','End of Time','https://www.youtube.com/embed/Oj18EikZMuU','03:05:00'),(23,NULL,'Marshmello & Halsey',NULL,'英文','Be Kind','https://www.youtube.com/embed/ePao0cTGG-o','03:04:00'),(24,NULL,'Boy In Space',NULL,'英文','7UP','https://www.youtube.com/embed/cgyYXw7qLQg','03:21:00'),(25,NULL,'Lost Kings & Loren Gray',NULL,'英文','Anti-Everything','https://www.youtube.com/embed/f__DV1unimQ','03:05:00'),(26,NULL,'Bastille',NULL,'英文','Pompeii','https://www.youtube.com/embed/F90Cw4l-8NY','03:52:00'),(27,NULL,'Billie Eilish',NULL,'英文','everything i wanted','https://www.youtube.com/embed/EgBJmlPo8Xw','04:47:00'),(28,NULL,'Liam Payne',NULL,'英文','Stack It Up','https://www.youtube.com/embed/e1r62iOPkGw','02:52:00'),(29,NULL,'Shawn Mendes & Camila Cabello',NULL,'英文','Señorita','https://www.youtube.com/embed/Pkh8UtuejGw','03:25:00'),(30,NULL,'Martin Garrix & Dean Lewis',NULL,'英文','Used To Love','https://www.youtube.com/embed/LEh9F67Z5n8','03:57:00');
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

-- Dump completed on 2020-09-14 16:01:10
