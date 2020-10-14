CREATE TABLE `alumnos` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
   `cedula` varchar(15) DEFAULT NULL,
  `fechanacimiento` varchar(255) DEFAULT NULL,
  `edad` integer,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `grado` varchar(255) DEFAULT NULL,
 `numeromatricula` integer,

   `fK_idprovincia` bigint(20),
   FOREIGN KEY (`fK_idprovincia`) REFERENCES provincia(`id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
