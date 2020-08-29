
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (1, 'Otavalo', 'b',1);
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (2, 'Imbarra', 'b',1);

ALTER TABLE `cantones` ADD PRIMARY KEY (`id`);
ALTER TABLE `cantones` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

