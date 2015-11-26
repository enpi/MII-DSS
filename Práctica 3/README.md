##Práctica 3

### Servicios Web y encapsulación de la persistencia

Un  servicio web que llamaremos 'CRUD' (Create, Read, Update, Delete), que ha de ser RESTful y que nos permitirá mantener una lista de objetos de un determinado dominio de libre elección (reseñas bibliográficas, catálogo de coches, etc..), pero que ha de incorporar imágenes y sonidos, en nuestra aplicación Web a través de llamadas HTTP.

- Nos crearemos un modelo de datos y también una clase Singleton (no admite más de 1 instancia) que servirá como el proveedor de datos para el modelo.
- Utilizaremos una clase basada en enumeración para representar un "proveedor de contenidos".
- Nos crearemos los recursos
- Por último, el servicio REST que hemos programado ha de poder ser utilizado a través de formularios HTML.

El formulario permitirá hacer POST de nuevos datos en el servicio. Para lo cual nos crearemos una página (.html) en la carpeta  "WebContent" del proyecto Eclipse que se entregará.
