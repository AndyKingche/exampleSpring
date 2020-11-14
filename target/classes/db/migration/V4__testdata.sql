INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (1, 'Ibarra', 'b',7);
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (2, 'Antonio Ante', 'b',7);
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (3, 'Cotacachi', 'b',7);
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (4, 'Otavalo', 'b',7);
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (5, 'Pimampiro', 'b',7);
INSERT INTO `cantones` (`id`, `nombre`, `descripcion`,`fk_id`) VALUES (6, 'Urcuqui', 'b',7);


ALTER TABLE `cantones` ADD PRIMARY KEY (`id`);
ALTER TABLE `cantones` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

