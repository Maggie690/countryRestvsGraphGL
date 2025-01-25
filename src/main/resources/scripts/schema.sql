
CREATE  IF NOT EXIST USER 'root'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;


CREATE TABLE IF NOT EXISTS `country` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `code` varchar(2) NOT NULL,
    `name` varchar(100) NOT NULL,
    `phone` int(5) NOT NULL,
    `currency_symbol` varchar(10) DEFAULT NULL,
    `capital` varchar(80) DEFAULT NULL,
    `currency` varchar(3) DEFAULT NULL,
    `continent` varchar(30) DEFAULT NULL,
    `continent_code` varchar(2) DEFAULT NULL,
    `alpha_3` char(3) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF NOT EXISTS `continent` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `code` varchar(2) DEFAULT NULL,
    `name` varchar(30) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
