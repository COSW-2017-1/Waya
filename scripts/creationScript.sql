CREATE TABLE `BARES` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `logo` varchar(300) COLLATE latin1_general_ci NOT NULL,
  `descripcion` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `horario` varchar(45) COLLATE latin1_general_ci,
  `direccion` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `tipo` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `genero` varchar(45) COLLATE latin1_general_ci NOT NULL,
  `longitud` decimal(10,5)  NOT NULL,
  `latitud` decimal(10,5) NOT NULL,
  PRIMARY KEY (`id`)  
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `MULTIMEDIA`(
  `bar` int(11) NOT NULL,
  `numero` int(11)NOT NULL,
  `fechaYHora` date NOT NULL,
  `multimedia` BLOB  NOT NULL,
  PRIMARY KEY (`bar`,`numero`),
  KEY `fk_BARES_has_MULTIMEDIA` (`bar`),
  CONSTRAINT `fk_BARES_has_MULTIMEDIA` FOREIGN KEY (`bar`) REFERENCES `BARES` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

CREATE TABLE `PERSONS`(
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE latin1_general_ci,
  `password` varchar(45) COLLATE latin1_general_ci,
  `authority` varchar(45) COLLATE latin1_general_ci,
  `firstname` varchar(45) COLLATE latin1_general_ci,
  `lastname` varchar(45) COLLATE latin1_general_ci,
  `dateofbirth` timestamp,
  `phonenumber` int(11),
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;
--INSERTS ---
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("lA SANTA","https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1400097753/entity/image/file/056/000/5373cbd0820c65969e000056.jpg","La mejor Rumba en Modelia hasta las 3 pm","6:00 pm - 9 pm","Carrera 75 # 24C-08 - Piso 2","Normal","Crossover",4.6483228507399925,-74.10780699999998);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("LUX BY THEATRON","https://4.bp.blogspot.com/--O06kCIWTkE/V0nI2nykS2I/AAAAAAAAJ0o/ZSElkq6V2ogYDVqH9SvnTy16oeBmVHSPACLcB/s640/theatron5.jpg","13 ambientes con mas de trece años","9:00 pm a 04:30 am","Calle 58 # 10-322","Cover","Crossover",4.673534552758134,-74.06278209999999);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("GAIRA BAR","http://gairacafe.co/templates/gaira/images/confirmacionReserva.jpg","El templo de la música del mundo","12:00 pm a 03:00 am","Cra. 13 #96-11","Normal","Vallenato",4.6805644513002065,-74.04756954999999);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("IRISH PUB","http://irishpubcompany.com/wp-content/uploads/2014/12/nine-fine.jpg","El auténtico pub Irlandes","12:00 pm a 03:00 am","Cra. 12a #8348","Normal","Crossover",4.667427751296499,-74.05398530000002);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("TERRA BAR","http://sitios.claro.com.co/img/upload/dsc_0054-1416878981.jpg","Restaurante bar con música en vivo","12:00 pm a 03:00 am","Avenida Calle 53 #71a-39","Normal","Crossover",4.670011601297241,-74.10551370000002);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("OPERA","http://rumbabogota.com/media/photos/images/events/operafeb_0_maxs.jpg","La mejor Barra libre de Bogotá","12:00 pm a 03:00 am","Carrera 14 A # 83-57","Cover","Crossover",4.668577901296832,-74.05481959999997);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("VAQUERITOS","https://3.kekantoimg.com/yjNxkmLAWVdr6c3hdatBtkrR9MA=/fit-in/600x600/s3.amazonaws.com/kekanto_pics/pics/507/562507.jpg","Bar con tragos vaqueros","12:00 pm a 03:00 am","Calle 82 # 14-23","Normal","Crossover",4.667295951296482,-74.05565854999998);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("EL CACIQUE BAR","https://i.ytimg.com/vi/YroWPv-L2dA/maxresdefault.jpg","El BAR DEL CACIQUE","9:00 pm a 03:00 am","Cra. 12a #8348","Normal","Crossover",6.249577251739058,-75.58873440000002);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("El MOZO CLUB","http://guiagay.co/wp-content/uploads/2016/01/El-Mozo-1.jpg","Borrachera todos los viernes","12:00 pm a 03:00 am","Calle 85 #12-51","Normal","Crossover",4.668744151296872,-74.05308795000002);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Ozzy - Café Bar Rock","https://ciudadheavy.com/wp-content/uploads/2016/02/facebook_event_1317243828301042.jpg","Algo de Rock para tu sistema","9:00 pm a 03:00 am",": N° 64 -f, Av. Boyacá #12115, ","Normal","Rock",4.678114201299481,-74.1019728);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Malabar Shots","http://static.panoramio.com/photos/large/77056480.jpg","Algunos shots !!!","10:00 pm a 03:00 am","Calle 85 #11","Normal","Crossover",4.667860901296643,-74.05152909999998);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Hooters Calle 116","http://rumbabogota.com/media/photos/images/people/2-chicas_fullwidth.jpg","Pasa un rato agradable aquí","12:00 pm a 03:00 am"," Cl. 116 #18-96 ","Normal","Rock",4.6984129513051585,-74.04858345000002);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Amapola","http://goguiadelocio.com.co/wordpress/wp-content/uploads/2015/06/Rumba-Amapola-Bar.jpg","rumba tropical y bailable","7:00 pm a 03:00 am","Cra. 14a ","Normal","Crossover",4.699703626353182,-74.04241293465576);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Yumi Yumi ","http://3.bp.blogspot.com/-D028nBEkFV0/TdL4K1kOZtI/AAAAAAAAAEQ/WEf9dE1KZyU/s1600/DSC_0079_edited-1.JPG","Comida deliciosa","12:00 pm a 03:00 am"," Cra. 13 #83-83 ","Normal","Crossover",4.668473851296816,-74.05408285000004);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("El Mono Bandido Chapinero ","https://res.cloudinary.com/civico/image/upload/c_fill,f_auto,fl_lossy,h_250,q_auto,w_250/v1475013630/entity/image/file/201/000/57eaebfe2f41f3b239000201.jpg","El mono bándido","10:00 pm a 03:00 am"," Cra. 4 #54-85 ","Normal","Crossover",4.640320701288947,-74.06063454999997);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("SUNRISE","http://rumbabogota.com/media/photos/images/events/531283_387661054626649_809636614_n_maxs.jpeg","Hasta el amanecer","9:00 pm a 04:30 am","Cra. 14a #83-23","Normal","Crossover",4.640320701288947,-74.06063454999997);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Bogotá Beer Company","https://userscontent2.emaze.com/images/e8bcfe11-8043-4c0f-822b-532a27229709/5e4f9068283d83bf5b30d59e4a70b357.jpeg","La más grande De Bogota","9:00 pm a 03:00 am","Avenida Calle 26 # 68B-85","Normal","ROCK",4.655930701293316,-74.10571680000004);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Jackass Rock Bar","http://rumbabogota.com/media/photos/images/events/390622_2652370514627_1416711248_3073205_2134720030_n_maxs.jpg","ROCK lwl","12:00 pm a 03:00 am","Ac 53 #7041 ","Cover","ROCK",4.668669451296849,-74.10434240000001);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("ONCEONCE BAR","http://goguiadelocio.com.co/wordpress/wp-content/uploads/2014/03/1111.jpg","Rumba a toda  nota"," 8:0pm a 03:00 am"," Cl. 84 Bis #1386 ","Cover","Crossover",4.668920401296914,-74.05461694999997);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("The Rooms","https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1404339735/entity/image/file/059/000/53b48616b9dd5d26c8000059.jpg","Rooms Rooms","9:00 pm a 03:00 am","Carrera 14A # 83-49 ","Normal","Crossover",4.668744051296861,-74.0553162);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("Gato Negro","https://media-cdn.tripadvisor.com/media/photo-s/02/15/53/12/fachada-noche.jpg","ROCK :D","9:00 pm a 03:00 am","Cl. 93a #11A-47 ","Normal","Rock",4.674881951298589,-74.04877614999998);
INSERT INTO BARES (name, logo, descripcion,horario,direccion,tipo,genero,longitud,latitud)VALUES ("The Red Lion English pub","https://res.cloudinary.com/civico/image/upload/c_fit,f_auto,fl_lossy,h_1200,q_auto,w_1200/v1400275943/entity/image/file/002/000/537683e6b9dd5d6d6c000002.jpg","PUB !!","9:00 pm a 03:00 am","Cra. 12 #9354 ","Normal","Rock",4.675779051298865,-74.04876535000005);
