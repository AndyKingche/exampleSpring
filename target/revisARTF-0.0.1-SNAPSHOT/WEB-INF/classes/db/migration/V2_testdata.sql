
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`) VALUES (1, 'Imbabura', 'b');
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`) VALUES (2, 'Pichincha', 'b');

ALTER TABLE `cantones` ADD PRIMARY KEY (`id`);
ALTER TABLE `cantones` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

