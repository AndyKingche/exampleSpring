INSERT INTO `profesor` (`id`, `nombre`, `apellido`,`cedula`, `fechaNacimiento`,
`edad`,`direccion`,`telefono`,`titulo`)

VALUES (1, 'Eduardo', 'Lopez','1005298563','ene',26,'quito y atahualpa',
'0985632144','Educacion Basica');

INSERT INTO `profesor` (`id`, `nombre`, `apellido`,`cedula`, `fechaNacimiento`,
`edad`,`direccion`,`telefono`,`titulo`)

VALUES (2, 'Maria', 'Delagado','1009865236','marzo',28,'ibarra y oviedo',
'0986525631','Educacion Fisica');

INSERT INTO `profesor` (`id`, `nombre`, `apellido`,`cedula`, `fechaNacimiento`,
`edad`,`direccion`,`telefono`,`titulo`)

VALUES (3, 'Henry', 'Montalvo','1009652129','abril',29,'jose flores y sanchez',
'0956320362','Fisico Matematico');

ALTER TABLE `profesor` ADD PRIMARY KEY (`id`);
ALTER TABLE `profesor` MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;