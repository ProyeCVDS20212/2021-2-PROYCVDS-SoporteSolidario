# Proyecto-SoporteSolidario

## Proyecto final de Ciclos del Desarrollo de Software 2021-2

## Escuela Colombiana de Ingenieria Julio Garavito (ECI)

### Enlace a la app en Heroku

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://proyecvdssolidaria.herokuapp.com/app/login.xhtml)

### Enlace a Codacy

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4467872301c7452ab97f76063e7a5523)](https://app.codacy.com/gh/ProyeCVDS20212/Proyecto?utm_source=github.com&utm_medium=referral&utm_content=ProyeCVDS20212/Proyecto&utm_campaign=Badge_Grade_Settings)

### Integrantes

- LEON BALLEN DIEGO ALEJANDRO (Desarrollo)
- OSPINA CALDERON JUAN SEBASTIAN (Desarrollo)
- MONROY SIERRA JUAN FELIPE (Desarrollo)

### Profesor

+ OSPINA RODRIGUEZ OSCAR DAVID (Dueño del producto)

#### Descripción general

Soporte solidario es una proyecto que busca que la comunidad estudiantil pueda expresar sus necesidades de manera
publica sobre ciertos elementos que requiere para alguna actividad, así, otros miembros de la comunidad tendrán
la oportunidad de brindar estos elementos que son puestos como necesidad. De igual forma los miembros que ayudan
a agregar los elementos, también pueden ofrecer categorías de interés hacia la comunidad que ellos crean que pueda ser
solicitado. La plataforma cuenta con reportes acerca de las categorías, necesidades y ofertas.

### Manual de Usuario
Ingresamos al enlace del Proyecto Solidario [enlace](https://proyecvdssolidaria.herokuapp.com/app/login.xhtml)
Con un usuario y una contraseña que se tienen creada, se puede iniciar sesión al diligenciar la siguiente
forma.

![Login](img/Manual/login.png)

Esta es la plataforma principal donde se tiene un menu que se puede usar para navegar entre la pagina
y un mensaje de bienvenida a los usuarios

![PaginaPrincipal](img/Manual/PaginaPrincipal.png)

En esta parte de la pagina se pueden crear las necesidades

![CrearNecesidad](img/Manual/CrearNecesidad.png)

En esta parte de la pagina se pueden actualizar las necesidades

![ActualizarNecesidad](img/Manual/ActualizarNecesidad.png)

En esta parte de la pagina se pueden crear las ofertas

![CrearOferta](img/Manual/CrearOferta.png)

En esta parte de la pagina se pueden crear las respuestas para las ofertas

![RespuestaOferta](img/Manual/RespuestaOferta.png)

En esta parte de la pagina se pueden crear las respuestas para las necesidades

![RespuestaNecesidad](img/Manual/RespuestaNecesidad.png)

### Usuarios
**Usuario, contraseña, rol**

1. Carlos, 123, Admin

2. Ospina, 12345678, Estudiante 

## Arquitectura y Diseño
### Modelo Entidad-Relación

![Entidad-Relacion](img/Otras%20imagenes/Diagramaer.png)

### Diagrama de clases

![Diagrama de clases](img/Otras%20imagenes/Diagramadeclases.jpg)

### Descripción de la arquitectura

La app esta dividida y formada por 3 capas:

### Capa de presentación 

En esta usamos varias fuentes y tecnologías como:

    * Primefaces(Biblioteca de componentes)
    * W3Schools(Sitio web con ejemplos de html, css, etc.)
   
### Capa de aplicación

En esta otra, usamos otras tecnologías como:
    
    * Java
    * Shiro
    * Google Guice

### Capa de persistencia

En esta capa fue necesario usar un motor de base de datos, en nuestro caso usamos PostgreSQL, 
DBeaver para tener una mejor visualización de estas, y myBatis para mapear sentencias SQL

### Descripción del proceso

Usamos **Java** para crear cada una de las clases que nos permitiria tener un back listo y con las
funciones pertinentes para que la aplicación funcione, usamos tambien **Postgresql** como motor de 
bases de datos, donde lo utilizamos para guardar toda la información de la app. usamos **xhtml**
como herramienta para el desarrollo front y hacer la interfaz, y usamos CSS para hacer esta interfaz
amigable al usuario. Se realizo tambien la conexion correspondiente entre Front y Back para que la
app funcione. 

### Descripción Sprint1


En el siguiente [enlace](https://tree.taiga.io/project/juanoyolo-solidaridad-escuela/taskboard/sprint-1-16929)
se muestran cuales fueron los issues que teniamos en el sprint1, tuvimos que acoplarnos a las nuevas tecnologias como taiga,
donde dividimos las historias de usuario y en cada una de ellas asignamos tareas para hacer un mejor trabajo de equipo, 
tuvimos ciertos inconvenientes con la actualización de la categoria, pero luego lo logramos solucionar con un
trabajo grupal durante toda la semana.
El mensaje al crear la categoria salia dos veces

![Sprint1](img/Otras%20imagenes/Sprint1.png)

### Descripción Sprint2

En el siguiente [enlace](https://tree.taiga.io/project/juanoyolo-solidaridad-escuela/taskboard/sprint-2-9441) se muestran
los issues del sprint2, donde ahora debemos realizar la implementación de las acciones que pueden realizar los usuarios
como el registro de oferta, la respuesta, la necesidad y la actualización de las mismas, mas el reporte
Tuvimops inconvenientes con la creación del reporte de las necesidades


![Sprint2](img/Otras%20imagenes/Sprint2.png)

### Descripción Sprint3

En el siguiente [enlace](https://tree.taiga.io/project/juanoyolo-solidaridad-escuela/taskboard/sprint-3-6363) se muestran
los issues del sprint3, donde ahora debemos crear los reportes de las ofertas respuestas y categorias, ademas teniamos que
gestionar las categorias no validas, aquí tuvimos que refactorizar la creación de la categoria para poder realizar lo de 
categorias no validas, creamos dos constructores y un super, ademas de dos atributos mas para agregarlos a la interfaz y 
que permita al admin crear y gestionar la validez de las categorias.
Tuvimos inconvenientes al gestionar la categoria no valida
Tuvimos que borrar la tabla categoria y volver a crearla
Tuvimos ciertos inconvenientes con la base de datos, pero al final se soluciono

![Sprint3](img/Otras%20imagenes/Sprint3.png)

### Sprint-Backlog

![Backlog](img/Otras%20imagenes/Backlog.png)




