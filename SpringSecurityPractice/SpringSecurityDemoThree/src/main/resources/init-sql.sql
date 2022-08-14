## mysql db init sql
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户是否可用',
  `roles` text CHARACTER SET utf8 COMMENT '用户角色，多个角色之间用逗号隔开',
  PRIMARY KEY (`id`),
  KEY `username` (`username`)
)

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(60) NOT NULL,
  CONSTRAINT fk_authorites_users FOREIGN KEY(`username`) REFERENCES users(`username`)
)

CREATE UNIQUE INDEX ix_auth_username on authorities(username , authority);