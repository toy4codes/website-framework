DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `age` int(11) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `marital` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `has_credit` varchar(45) DEFAULT NULL,
  `housing_loan` varchar(45) DEFAULT NULL,
  `personal_loan` varchar(45) DEFAULT NULL,
  `contact` varchar(45) DEFAULT NULL,
  `last_contact_month` varchar(45) DEFAULT NULL,
  `last_contact_day` varchar(45) DEFAULT NULL,
  `last_contact_duration` int(11) DEFAULT NULL,
  `campaign` int(11) DEFAULT NULL,
  `pdays` int(11) DEFAULT NULL,
  `previours` int(11) DEFAULT NULL,
  `poutcome` varchar(45) DEFAULT NULL,
  `employment_variation_rate` float DEFAULT NULL,
  `consumer_price` float DEFAULT NULL,
  `consumer_confidence` float DEFAULT NULL,
  `euribor3m` float DEFAULT NULL,
  `number_of_employees` int(11) DEFAULT NULL,
  `term_deposit` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOAD DATA INFILE 'bank_additional_full.csv' INTO TABLE `bank`
  FIELDS TERMINATED BY ',' ENCLOSED BY '"'
  LINES TERMINATED BY '\r\n'
  IGNORE 1 LINES;