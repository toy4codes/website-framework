DROP TABLE IF EXISTS `pm2.5`;

CREATE TABLE `pm2.5` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `day` int(11) DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `pm2.5` int(11) DEFAULT NULL,
  `dew_point` int(11) DEFAULT NULL,
  `temperature` int(11) DEFAULT NULL,
  `pressure` int(11) DEFAULT NULL,
  `combined_wind_direction` varchar(45) DEFAULT NULL,
  `cumulated_wind_speed` float DEFAULT NULL,
  `cumnlated_hours_of_snow` int(11) DEFAULT NULL,
  `cumulated_hours_of_rain` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOAD DATA INFILE 'pm2.5_data_2010.1.1-2014.12.31.csv' INTO TABLE `pm2.5`
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES;
  
