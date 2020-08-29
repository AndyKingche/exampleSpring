CREATE TABLE `profesor` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido` varchar(255) DEFAULT NULL,
   `cedula` varchar(15) DEFAULT NULL,
  `fechaNacimiento` varchar(255) DEFAULT NULL,
  `edad` integer,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

