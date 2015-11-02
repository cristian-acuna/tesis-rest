#import.sql file

insert into provincia (id, descripcion) values (1, 'Capital Federal');
insert into provincia (id, descripcion) values (2, 'Buenos Aires');
insert into provincia (id, descripcion) values (3, 'Catamarca');
insert into provincia (id, descripcion) values (4, 'Chaco');
insert into provincia (id, descripcion) values (5, 'Chubut');
insert into provincia (id, descripcion) values (6, 'Cordoba');
insert into provincia (id, descripcion) values (7, 'Corrientes');
insert into provincia (id, descripcion) values (8, 'Entre Rios');
insert into provincia (id, descripcion) values (9, 'Formosa');
insert into provincia (id, descripcion) values (10, 'Jujuy');
insert into provincia (id, descripcion) values (11, 'La Pampa');
insert into provincia (id, descripcion) values (12, 'La Rioja');
insert into provincia (id, descripcion) values (13, 'Mendoza');
insert into provincia (id, descripcion) values (14, 'Misiones');
insert into provincia (id, descripcion) values (15, 'Neuquen');
insert into provincia (id, descripcion) values (16, 'Rio Negro');
insert into provincia (id, descripcion) values (17, 'Salta');
insert into provincia (id, descripcion) values (18, 'San Juan');
insert into provincia (id, descripcion) values (19, 'Santa Cruz');
insert into provincia (id, descripcion) values (20, 'Santa Fe');
insert into provincia (id, descripcion) values (21, 'Santiago del Estero');
insert into provincia (id, descripcion) values (22, 'Tierra del Fuego');
insert into provincia (id, descripcion) values (23, 'Tucuman');
insert into provincia (id, descripcion) values (24, 'San Luis');

insert into residencia (id, ciudad, cod_provincia, pais) values ('1', 'Santa Rosa',1, 'Argentina');
insert into residencia (id, ciudad, cod_provincia, pais) values ('2', 'San Luis',2, 'Argentina');
insert into residencia (id, ciudad, cod_provincia, pais) values ('3', 'Carlos Paz',3, 'Argentina');
insert into residencia (id, ciudad, cod_provincia, pais) values ('4', 'Cura Brochero',4, 'Argentina');
insert into bodega (id, anio, descripcion, link, nombre, cod_residencia) values ('1', '1900', 'Bodega SEPTIMA, ubicada en la fantastica provincia de Mendoza, Argentina, con sus fincas en la zona de Agrelo, al pie de la Cordillera de los Andes, propone una amplia variedad de vinos y espumosos argentinos. Su arquitectura, el estilo de la construccion, los materiales empleados y la disposicion de los espacios hacen del lugar un referente indiscutido entre las bodegas mendocinas de la ultima etapa de la vitivinicultura argentina. La bodega ocupa un area de 5500 m2 y cuenta con una capacidad de 3.000.000 de botellas. La construccion se inspiro en el sistema constructivo ancestral de la pirca, tecnica muy utilizada por los huarpes para levantar muros, que consiste en apilar piedras naturales. Bodega Septima, con mas de 150 ha plantadas y con equilibrados niveles de produccion, ofrece una amplia gama de productos para el amante del buen vino y de los exquisitos espumosos.','http://www.bodegaseptima.com/home.php','Septima', 1);
insert into bodega (id, anio, descripcion, link, nombre, cod_residencia) values ('2', '1950', 'La bodega, disenada para la produccion de vinos de alta gama, fue construida en 2004 en Perdriel, Lujan de Cuyo, al pie de la Cordillera de Los Andes. Es una fusion de modernidad y clasicismo: lineas rectas bien definidas con muros de inspiracion toscana entregan una estetica muy atractiva. Renacer cuenta con tecnologia italiana de vanguardia, una capacidad total de almacenamiento de 1.647.000 litros repartidos en 417.900 litros en tanques de acero inoxidable y 1.229.100 litros en piletas de concreto, seguimiento computarizado de temperaturas, trazabilidad de todos los procesos y equipos de ultima generacion. La bodega es tambien pionera en desarrollar viticultura de precision; plantas de alta densidad y poco rendimiento por planta, 8 toneladas por hectarea, produciendo asi uvas excepcionales que se convertiran en vinos unicos, magnificos.','http://www.bodegarenacer.com.ar/','Renacer', 2);
insert into bodega (id, anio, descripcion, link, nombre, cod_residencia) values ('3', '1897', 'Lagarde conserva su bodega original construida en 1897. La misma es un fiel reflejo de la imagen que queremos transmitir a traves de nuestros vinos: el balance armonico entre el pasado y la innovacion. Alli, al mismo tiempo que preservamos nuestra cultura e identidad, tambien invertimos en tecnologia de ultima generacion para asegurar la mejor calidad en la elaboracion de cada uno de nuestros vinos.','http://www.lagarde.com.ar/','Lagarde', 3);
insert into bodega (id, anio, descripcion, link, nombre, cod_residencia) values ('4', '1888', 'Fieles a la calidad de nuestros vinos y a la importancia de nuestro terroir, Nieto Senetiner cuenta con 400 hectareas de vinedos entre nuestras 3 Fincas, todas ubicadas en la zona de Lujan de Cuyo, pero en distintos valles con diferentes caracteristicas. En estas Fincas se produce uva de gran calidad dando lugar a vinos excepcionales. En nuestras bodegas damos continuidad al proceso que nace en el vinedo. Ponemos especial cuidado en el tratamiento de las uvas y trabajamos en la permanente mejora continua de los procesos, acompanada de tecnologia y de artesanalidad que nos permiten la elaboracion de nuestros grandes vinos optimizando la calidad.','http://www.nietosenetiner.com.ar/','Nieto Senetiner', 2);

insert into tipo_vino (id, nombre, descripcion) values ('1', 'blanco', 'Es el obtenido a partir de uvas blancas. Aunque es poco frecuente, tambien puede ser obtenido a partir de uvas tintas de pulpa no coloreada a las que se les separa el hollejo (piel de la uva, parte externa, cubierta). Los vinos hechos de uvas blancas no son tan bien valorados por el publico general como son los provenientes de uvas rojas; valoraciun subjetiva que solo priva de grandes vinos a quienes la ejercen. Las personas piensan en los vinos blancos como caldos acidos y poco interesantes, pero estas mismas caracteristicas las podemos encontrar en los vinos tintos de baja calidad.');
insert into tipo_vino (id, nombre, descripcion) values ('2', 'rosado', 'Es el obtenido a partir de uvas tintas a las que no se les ha separado los hollejos.');
insert into tipo_vino (id, nombre, descripcion) values ('3', 'tinto', 'Es el obtenido a partir de uvas tintas a las que se les ha separado parcialmente los hollejos. Tambien puede provenir de mezcla de uvas blancas y tintas. Los vinos tintos gozan de una aceptacion casi unanime entre los aficionados del vino, y la prueba esta en la cantidad de variedad que ofrece el mercado en relacion a los vinos blancos o rosados que podemos comprar en cualquier tienda.');
insert into tipo_vino (id, nombre, descripcion) values ('4', 'clarete', 'El nombre proviene de la perversion e imitacion de "Claret", el vino palido tinto de origen Bordeaux. Comunmente son elaborados con uvas tintas y blancas, realizando la fermentacion con los hollejos. Su elaboracion esta justificada cuando se quiere producir vino con suficiente color rosado pero no se dispone de la cantidad necesaria de uvas tintas.');

insert into edad (id, nombre, descripcion) values ('1', 'Joven', 'Son los que no han tenido ningun tipo de crianza en madera o esta crianza ha sido minima. Son vinos que conservan mucho las caracteristicas varietales de las uvas de las que proceden y de consumo ideal en los 12-24 meses despues de la vendimia.');
insert into edad (id, nombre, descripcion) values ('2', 'Crianza', 'Minimo de seis meses en madera y hasta dos anos en botella. Crianza sera tanto el vino que tiene un ano en madera y otro en botella como el que tiene 18 meses en madera y 6 en botella.');
insert into edad (id, nombre, descripcion) values ('3', 'Reserva', 'Son vinos con tres anos de envejecimiento (2 anos los blancos y rosados), de los cuales al menos uno en barrica (6 meses los blancos y rosados).');
insert into edad (id, nombre, descripcion) values ('4', 'Gran Reserva', 'Son vinos con cinco anos de envejecimiento (4 anos los blancos y rosados), de los cuales al menos 18 meses en barrica (6 meses los blancos y rosados).');

insert into uva (id, nombre, descripcion) values ('1', 'Chenin', 'Originaria del valle del rio Loire, en Francia, de gran calidad, con ella se obtienen atractivos vinos blancos frutados, ligeros y frescos. Hay cantidad en Argentina, donde es mayormente utilizada para corte con otros vinos. Es asi mismo una variedad muy interesante para elaborar vinos dulces. Se la conoce tambien como pineau o pinot de la Loire.');
insert into uva (id, nombre, descripcion) values ('2', 'Chardonay', 'Considerada la reina de las uvas blancas, produce en la Borgona Francesa algunos de los mas renombrados y caros vinos blancos del mundo. Su cultivo se extendio exitosamente a muchos paises, obteniendose con ella vinos de aroma voluptuoso, aptos para la fermentacion y el estacionamiento en barriles de roble nuevo. Tambien muy usado para vinos de base de espumosos tipo Champagne.');
insert into uva (id, nombre, descripcion) values ('3', 'Riesling', 'Cepaje emblematico de la vitivinicultura alemana, el Riesling se utiliza en ese pais para vinos secos y dulces, donde aporta su particular y especiado perfume. Hay poco Riesling verdadero en Argentina.');
insert into uva (id, nombre, descripcion) values ('4', 'Semillon', 'Variedad de uva de la region de Bordeaux, en Francia, donde produce blancos secos y dulces, algunos muy famosos, como el licoroso Sauternes. En Argentina se desarrolla bastante bien en zonas frias, especialmente Tupungato, en Mendoza, y el Valle de Rio Negro.');
insert into uva (id, nombre, descripcion) values ('5', 'Torrontes', 'La uva Torrontes da origen al vino blanco mas tipico de la Argentina, ya que sus caracteristicas se consideran unicas en el mundo. De origen incierto, su parentesco mas probable esta asociado con los moscateles, con los que guarda un cierto parecido aromatico. Se lo cultiva en todas las regiones vinicolas Argentinas, aunque sus zonas preferenciales estan en Cafayate (Salta) y el Valle de Chilecito (La Rioja).');
insert into uva (id, nombre, descripcion) values ('6', 'Sauvignon Blanc', 'Otro cepaje del sudoeste de Francia, donde produce importantes vinos. Su difusion es muy ampliada en el mundo, destacandose especialmente en Nueva Zelanda y Chile. En Argentina se esta empezando a desarrollar muy bien, con vinos de aroma intenso y con matices herbaseos.');

insert into uva (id, nombre, descripcion) values ('7', 'Cabernet Sauvignon', 'La Cabernet Sauvignon es la uva roja mas famosa del mundo, muy utilizada por su color intenso y su estabilidad. Los aromas mas tipicos nos recuerdan a violetas, bayas, frambuesa, moras y cafe sin tostar. Es comun encontrar notas a pimiento verde que muchos enologos (los mas) lo atribuyen a una mala maduracion del caldo y no a una caracteristica deseable. Su color es rojo intenso y es ideal para acompanar platos de carne y salsas espesas. Es consumida y cultivada en practicamente todos los paises donde se produce vino.');
insert into uva (id, nombre, descripcion) values ('8', 'Malbec', 'Otro cepaje originario del sudoeste de Francia, donde paulatinamente ha sido dejado de lado ya que alli no produce gran calidad. En Argentina encontro la tierra y el clima ideales para su desarrollo, dando excelentes vinos de buen color y cuerpo, de notable intensidad y concentracion. Por ello se lo considera el tinto argentino mas tipico. La Malbec se cultiva en todas las regiones vitivinicolas Argentinas, destacandose la zona de Lujan de Cuyo (Mendoza).');
insert into uva (id, nombre, descripcion) values ('9', 'Merlot', 'Tambien de Bordeaux, donde integra los cortes con el Cabernet Sauvignon. Los aromas y sabores de uno y otro son similares, pero en la boca el Merlot es mas debil que la del Cabernet, el Merlot es muy utilizado para cortes con otros vinos mas robustos. Pero sus varietales alcanzan gran calidad.');
insert into uva (id, nombre, descripcion) values ('10', 'Syrah', 'Uva de origen supuestamente persa, desde donde habria llegado al valle de rio Rodamo (Francia) por obra de los cruzados. Hoy esta en expansion en todo el mundo ya que produce vinos de buena calidad, color rojo intenso, aroma profundo y sabor recio. Madura muy bien en botella, donde adquiere matices especiados.');
insert into uva (id, nombre, descripcion) values ('11', 'Pinot Noir', 'cepaje que da origen a los famosos Borgonas Tintos franceses. A diferencia de otras variedades, no suele reproducir sus mejores virtudes fuera del terruno original. Por esa razonse lo cultiva es escasas regiones. Vinifcado en blanco, integra muchos de los vinos base para espumosos.');
insert into uva (id, nombre, descripcion) values ('12', 'Sangiovese', 'Variedad Italiana de la Toscana, es la base del afamado Chianti. En Argentina se la cultiva de hace largo tiempo, a veces bajo el erroneo nombre de Lambrusco. En los ultimos tiempos se lo elabora como varietal para la exportacion, o como componente de cortes diversos, donde aporta su agradable sabor frutado y floral, con ciertos matices violetas.');
insert into uva (id, nombre, descripcion) values ('13', 'Bonarda', 'Otra variedad Italiana, es este caso del Piemonte, que siempre conto en Argentina con una superficie de cultivo. Sin embargo, solo en los ultimos anos se la reconoce como apta para elaborar vinos de calidad. Tiene la especial cualidad de mejorar y equilibrar vinos de corte.');
insert into uva (id, nombre, descripcion) values ('14', 'Tempranillo', 'Es la uva mas famosa y la mas usada de Espana. Su origen la situa como una descendiente de la uva Pinot Noir francesa. Debido a su baja acidez y poca presencia de azucar es muy comun mezclarla con un pequeno porcentaje de otras cepas para lograr mejores caldos. Su color es rojo rubi y sus aromas mas representativos son los de frutos del bosque, bayas, ciruela y tabaco. Tiene una alta capacidad de envejecimiento, lo que la hace ideal para su maduracion en barricas. Tambien es usada en Portugal y algunos paises del Nuevo mundo.');

insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (1,2012,'Keep an eye out for this winery in coming years, as their chardonnays have reached the peak of perfection.',16,'Shafer Red Shoulder Ranch',2,2,2,1);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (2,2014,'For those who appreciate the simpler pleasures in life, this light pinot grigio will blend perfectly with a light meal or as an after dinner drink.',15,'Ponzi',3,2,2,3);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (3,2015,'Whether enjoying a fine cigar or a nicotine patch, dont pass up a taste of this hearty Rioja, both smooth and robust.',16,'Dinastia Vivanco',2,2,2,1);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (4,2012,'Breaking the mold of the classics, this offering will surprise and undoubtedly get tongues wagging with the hints of coffee and tobacco in perfect alignment with more traditional notes. Sure to please the late-night crowd with the slight jolt of adrenaline it brings.',14,'Les Morizottes',3,3,1,3);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (5,2011,'Though subtle in its complexities, this wine is sure to please a wide range of enthusiasts. Notes of pomegranate will delight as the nutty finish completes the picture of a fine sipping experience.',16,'Domaine Serenne',4,2,1,2);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (6,2011,'Though dense and chewy, this wine does not overpower with its finely balanced depth and structure. It is a truly luxurious experience for the senses.',15,'Chateau Le Doyenne',1,3,1,1);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (7,2010,'One cannot doubt that this will be the wine served at the Hollywood award shows, because it has undeniable star power. Be the first to catch the debut that everyone will be talking about tomorrow.',14,'Rex Hill',3,3,3,3);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (8,2015,'The cache of a fine Cabernet in ones wine cellar can now be replaced with a childishly playful wine bubbling over with tempting tastes of black cherry and licorice. This is a taste sure to transport you back in time.',14,'Margerum Sybarite',2,2,2,1);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (9,2015,'The aromas of fruit and spice give one a hint of the light drinkability of this lovely wine, which makes an excellent complement to fish dishes.',14,'Chateau de Sainte Cosme',1,1,2,2);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (10,2014,'Best served chilled with melon or a nice salty prosciutto, this sauvignon blanc is a staple in every Italian kitchen, if not on their wine list.  Request the best, and you just may get it.',15,'Momo Malborough',4,1,3,3);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (11,2014,'Legend has it the gods didn´t share their ambrosia with mere mortals.  This merlot may be the closest we´ve ever come to a taste of heaven.',15,'Waterbrook',4,2,1,1);
insert into vino (id, cosecha, descripcion, graduacion, nombre, cod_bodega, cod_edad, cod_tipo, cod_uva) values (12,2013,'Find a sommelier with a taste for chocolate and he´s guaranteed to have this cabernet on his must-have list.',16,'Chateau Caronne Ste Gemme',1,2,3,1);

insert into usuario (apellido, email, estado, nombre, password, cod_residencia) values ('Toranzo','test@test.com', 0, 'Natalia','1234',2);
insert into usuario (apellido, email, estado, nombre, password, cod_residencia) values ('Argento','test@invalid.com', 0, 'Pepe','fake',3);
insert into usuario (apellido, email, estado, nombre, password, cod_residencia) values ('Paredes','test@invalid2.com', 0, 'Armando','fake2',1);
insert into usuario (apellido, email, estado, nombre, password, cod_residencia) values ('Snow','test@invalid3.com', 0, 'Jon','fake3',1);


insert into comentario (id, comentario, fecha, cod_usuario, cod_vino) values ('1', 'Asqueroso, parecia avinagrado, me arrepiento de haberlo probado ... una porqueria, lo probamos con unos familiares y terminaron internados, uno de ellos exploto a la hora de haberlo probado, los otros siguen graves, incluso mi tio alcoholico dejo la bebida al probarlo.', '2015-09-22 14:30:22.50',1,2);
insert into comentario (id, comentario, fecha, cod_usuario, cod_vino) values ('2', 'Sabor agradable y tanices oscuros. Recomendable', '2015-08-12 14:31:22.50',2,3);
insert into comentario (id, comentario, fecha, cod_usuario, cod_vino) values ('3', 'Excelente relacion precio calidad, lo recomiendo a todo aquel que aprecie un buen malbec', '2015-08-12 14:30:22.50',1,4);
insert into comentario (id, comentario, fecha, cod_usuario, cod_vino) values ('4', 'Por el rango de precio podria ser mejor, safa.', '2015-08-12 14:30:22.50',3,2);
insert into comentario (id, comentario, fecha, cod_usuario, cod_vino) values ('5', 'Una excelente convinacion de el tradicional vino andaluz con nuestros viñedos norteños', '2015-06-11 14:30:22.50',4,2);
insert into comentario (id, comentario, fecha, cod_usuario, cod_vino) values ('6', 'El mejor Rosado que eh probado, muy recomendado aunque no es facil de conseguir en corrientes.', '2015-04-12 14:30:22.50',1,1);


