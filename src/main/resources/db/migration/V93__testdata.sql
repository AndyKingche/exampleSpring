INSERT INTO `matircula` (`id`, `fK_idmateria`, `fK_idalumnos`) 
VALUES (1, 1, 1);

INSERT INTO `matircula` (`id`, `fK_idmateria`, `fK_idalumnos`) 
VALUES (2, 3, 1);



INSERT INTO `matircula` (`id`, `fK_idmateria`, `fK_idalumnos`) 
VALUES (3, 2, 1);


ALTER TABLE `matricula` ADD PRIMARY KEY (`id`);
ALTER TABLE `matricula` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;