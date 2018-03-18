DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` (`username`, `email`, `password`) VALUES ("admin", "admin@toy4codes.com", "admin");
INSERT INTO `users` (`username`, `email`, `password`) VALUES ("user", "user@toy4codes.com", "user");