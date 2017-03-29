
CREATE TABLE `MULTIMEDIA`(
`bar` int(11) NOT NULL,
`numero` int(11)NOT NULL,
`fechaYHora` date NOT NULL,
`multimedia` BLOB  NOT NULL,
PRIMARY KEY (`bar`,`numero`)
	KEY `fk_BARES_has_MULTIMEDIA` (`bar`),
  CONSTRAINT `fk_BARES_has_MULTIMEDIA` FOREIGN KEY (`bar`) REFERENCES `BARES` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;


CREATE TABLE `BARES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `logo` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `descripcion` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `horario` varchar(45) COLLATE latin1_general_ci,
  `direccion` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `tipo` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `genero` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `longitud` DOUBLE(10,10)  NOT NULL,
  `latitud DOUBLE(10,10) NOT NULL,
  PRIMARY KEY (`id`),  
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;


