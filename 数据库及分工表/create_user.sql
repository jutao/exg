CREATE USER 'ryw'@'%' IDENTIFIED WITH mysql_native_password;
GRANT ALL PRIVILEGES ON *.* TO 'ryw'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
SET PASSWORD FOR 'ryw'@'%' = PASSWORD('admin');
CREATE DATABASE IF NOT EXISTS `ryw`;
GRANT ALL PRIVILEGES ON `ryw`.* TO 'ryw'@'%';

CREATE USER 'ryw'@'localhost' IDENTIFIED WITH mysql_native_password;
SET PASSWORD FOR 'ryw'@'localhost' = PASSWORD('admin');
GRANT ALL PRIVILEGES ON `ryw`.* TO 'ryw'@'localhost';

CREATE USER 'ryw'@'192.168.0.20' IDENTIFIED WITH mysql_native_password;
SET PASSWORD FOR 'ryw'@'192.168.0.20' = PASSWORD('admin');
REVOKE ALL PRIVILEGES ON *.* FROM 'ryw'@'192.168.0.20'; GRANT ALL PRIVILEGES ON *.* TO 'ryw'@'192.168.0.20' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;
GRANT ALL PRIVILEGES ON `ryw`.* TO 'ryw'@'192.168.0.20';

192.168.0.20

