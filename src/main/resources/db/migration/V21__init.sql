CREATE TABLE `tipo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `categoria_id` bigint(20),
 FOREIGN KEY (`categoria_id`) REFERENCES categoria (`id`),
 PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

 