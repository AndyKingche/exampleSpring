CREATE TABLE `materias` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
 `horas` integer,

   `fK_idprofesor` bigint(20),
   FOREIGN KEY (`fK_idprofesor`) REFERENCES profesor(`id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;