INSERT INTO `alumnos` (`id`, `nombre`, `apellido`,`cedula`, `fechaNacimiento`,`edad`,`direccion`,`telefono`,`grado`,`numeroMatricula`,`fK_idprovincia`) 
VALUES (1, 'Andres', 'Quinche','1003866173','ene',26,'quito y atahualpa','0994501275','9 A',3,1);

INSERT INTO `alumnos` (`id`, `nombre`, `apellido`,`cedula`, `fechaNacimiento`,`edad`,`direccion`,`telefono`,`grado`,`numeroMatricula`,`fK_idprovincia`) 
VALUES (2, 'Christian', 'Quespaz','1003866173','ene',26,'quito y atahualpa','0994501275','9 A',3,1);

INSERT INTO `alumnos` (`id`, `nombre`, `apellido`,`cedula`, `fechaNacimiento`,`edad`,`direccion`,`telefono`,`grado`,`numeroMatricula`,`fK_idprovincia`) 
VALUES (3, 'Carlos', 'Tontaquimba','1003866173','ene',26,'quito y atahualpa','0994501275','9 A',3,1);

ALTER TABLE `alumnos` ADD PRIMARY KEY (`id`);
ALTER TABLE `alumnos` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;