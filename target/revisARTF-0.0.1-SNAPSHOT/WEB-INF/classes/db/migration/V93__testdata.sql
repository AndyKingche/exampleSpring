INSERT INTO `matricula` (`id`, `fK_idmateria`, `fK_idalumnos`) 
VALUES (1, 1, 1);





ALTER TABLE `matricula` ADD PRIMARY KEY (`id`);
ALTER TABLE `matricula` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;