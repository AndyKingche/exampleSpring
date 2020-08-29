
CREATE TABLE `matricula` (
  `id` bigint(20) NOT NULL,
   `fK_idmateria` bigint(20) NOT NULL,
  `fK_idalumnos` bigint(20) NOT NULL,

   FOREIGN KEY (`fK_idmateria`) REFERENCES materias(`id`),
    FOREIGN KEY (`fK_idalumnos`) REFERENCES alumnos(`id`)
  
) ENGINE=InnoDB DEFAULT CHARSET=latin1;