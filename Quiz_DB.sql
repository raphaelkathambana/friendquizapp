CREATE DATABASE IF NOT EXISTS `Quizify`;
    
USE `Quizify`;
SELECT DATABASE();

DROP TABLE IF EXISTS `Result`;  
DROP TABLE IF EXISTS `Quiz`;  
DROP TABLE IF EXISTS `Student`;
DROP TABLE IF EXISTS `Teacher`;
DROP TABLE IF EXISTS `Subject`;


CREATE TABLE IF NOT EXISTS `Student` (
    `Student_ID` int(3) NOT NULL AUTO_INCREMENT,
    `Name` varchar(70),
    `Email` varchar(80),
    `Password` varchar(25),
    PRIMARY KEY (`Student_ID`)
);


CREATE TABLE IF NOT EXISTS `Teacher` (
    `Teacher_ID` int(3) NOT NULL AUTO_INCREMENT,
    `Name` varchar(70),
    `Email` varchar(80),
    `Password` varchar(25),
    PRIMARY KEY (`Teacher_ID`)
);


CREATE TABLE IF NOT EXISTS `Subject` (
    `Subject_ID` int(3) NOT NULL AUTO_INCREMENT,
    `Name` varchar(40),
    PRIMARY KEY (`Subject_ID`)
);


CREATE TABLE IF NOT EXISTS `Quiz` (
    `Quiz_ID` int(3) NOT NULL AUTO_INCREMENT,
    `Subject_ID` int(3),
    `Question` varchar(255),
    `Option-A` varchar(255),
    `Option-B` varchar(255),
    `Option-C` varchar(255),
    `Answer` varchar(255),
    
    PRIMARY KEY (`Quiz_ID`),
    
    CONSTRAINT FK_0
	FOREIGN KEY (`Subject_ID`)
	REFERENCES `Subject` (`Subject_ID`)
);


CREATE TABLE IF NOT EXISTS `Result` (
    `Result_ID` int(3) NOT NULL AUTO_INCREMENT,
    `Quiz_ID` int(3),
    `Student_ID` int(3),
    `Result` int(3),
    PRIMARY KEY (`Result_ID`),
    
    CONSTRAINT FK_1
	FOREIGN KEY (`Quiz_ID`)
	REFERENCES `Quiz` (`Quiz_ID`),
    
    CONSTRAINT FK_2
	FOREIGN KEY (`Student_ID`)
	REFERENCES `Student` (`Student_ID`)
);