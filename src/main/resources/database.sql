
/**/
/*DROP TABLE IF EXISTS `category_`;*/
CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/**/

CREATE TABLE `account` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`name` varchar(255) NOT NULL,
  	`password` varchar(255) NOT NULL DEFAULT '',
  	`createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

CREATE TABLE `role` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`name` varchar(50) NOT NULL DEFAULT '',
  	`desc` varchar(255) NOT NULL DEFAULT '',
  	`createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 ; 

CREATE TABLE `accountrole` (
  	accountid int(11) NOT NULL,
  	roleid int(11) NOT NULL,
  	PRIMARY KEY (`accountid`,`roleid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

CREATE TABLE `systemlog` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
  	`name` varchar(255) NOT NULL DEFAULT'',
  	`detail`text,
  	`createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
