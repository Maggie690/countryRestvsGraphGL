
CREATE  IF NOT EXIST USER 'root'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;


CREATE TABLE `continent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(2) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `country` (
  `country_id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(2) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` int NOT NULL,
  `currency_symbol` varchar(10) DEFAULT NULL,
  `capital` varchar(80) DEFAULT NULL,
  `currency` varchar(3) DEFAULT NULL,
  `alpha_3` char(3) DEFAULT NULL,
  `continent_id` smallint unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
