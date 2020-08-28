
INSERT INTO `cantones` (`id`, `descripcion`, `habitantes`,`nombre`) VALUES (1, 'a',10000, 'b');
INSERT INTO `cantones` (`id`, `descripcion`, `habitantes`,`nombre`) VALUES (2, 'a',10000, 'b');

ALTER TABLE `cantones` ADD PRIMARY KEY (`id`);
ALTER TABLE `cantones` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

