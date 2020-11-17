CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
    PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;