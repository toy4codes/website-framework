DROP TABLE IF EXISTS `wireshark_packet`;

CREATE TABLE `wireshark_packet` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `source` varchar(32) NOT NULL,
  `destination` varchar(32) NOT NULL,
  `protocol` varchar(8) NOT NULL,
  `length` smallint(6) unsigned DEFAULT NULL,
  `info` varchar(2048) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


