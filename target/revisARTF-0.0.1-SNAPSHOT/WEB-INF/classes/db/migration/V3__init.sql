CREATE TABLE `cantones` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
   `fk_id` bigint(20),
   FOREIGN KEY (`fk_id`) REFERENCES provincia(`id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;