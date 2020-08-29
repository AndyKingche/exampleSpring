INSERT INTO `materias` (`id`, `nombre`, `horas`,`fk_idprofesor`) 
VALUES (1, 'Computacion Movil', 5 ,1);

INSERT INTO `materias` (`id`, `nombre`, `horas`,`fk_idprofesor`) 
VALUES (2, 'Ciencias Naturales', 5 ,1);


INSERT INTO `materias` (`id`, `nombre`, `horas`,`fk_idprofesor`) 
VALUES (3, 'Cultura fisica', 5 ,1);

ALTER TABLE `materias` ADD PRIMARY KEY (`id`);
ALTER TABLE `materias` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;