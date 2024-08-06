# BASE2

Proyecto para el manejo de fichas veterinarias destinado principalmente a animales de lecheria
individualizados por un arete numerado, conocido como DIIO.

El API contempla el uso de documentación swagger, contiene pruebas unitarias en capas de controlador
persistencia y servicio.

Se implementó una busqueda paginada, además de un endpoint para el envio de mail que usa un servidor 
smtp de google. Para lo cual se debe configurar una contraseña de aplicación en la cuenta de google.

Se utiliza una base de datos relacional Mysql, un api/rest desarrollado en java con el framework
SpringBoot3 y la parte front desarrollada con angular 16.

Se utiliza JPA/HIBERNATE como orm para el manejo de sql a nivel de servicio.

No es necesario incluir script de base de datos ya que el ORM crea el esquema
de bases de datos autimaticamente y se incluye la directiva createDatabaseIfNotExist=true
para que el framework cree la Base de datos automaticamente al primer inicio de la aplicación.

El front está alojado en localhost con puerto 4200

El api/rest está alojado en en localhost con puerto 8001

La base de datos está alojada en localhost con puerto 3306.

