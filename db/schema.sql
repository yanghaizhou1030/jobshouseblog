
--
-- Create A Database
--

DROP DATABASE IF EXISTS `jobshouse_blog`;
CREATE DATABASE `jobshouse_blog`;
USE `jobshouse_blog`;


--
-- Table structure for table "users"
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `username` varchar(100) NOT NULL UNIQUE,
    `password` varchar(20) NOT NULL,
    `userrole` varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
) AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


--
-- Add initial users
--

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1, 'NickYang', '123', 'admin'),(2, 'JobsHang', '123', 'admin');
UNLOCK TABLES;


--
-- Table structure for table "posts"
--

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `creator` varchar(100) NOT NULL,
    `title` varchar(20) NOT NULL,
    `content` text NOT NULL,
    `create_time` datetime NOT NULL,
    `modify_time` datetime NOT NULL,
    `read_times` int(11) NOT NULL,
    `like_times` int(11) NOT NULL,
    PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

