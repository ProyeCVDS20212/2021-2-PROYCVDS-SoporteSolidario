# Proyecto-SoporteSolidario

## Escuela Colombiana de Ingenieria Julio Garavito (ECI)

## Proyecto final de Ciclos del Desarrollo de Software

### Enlace a la app en Heroku

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://proyecvdssolidaria.herokuapp.com/app/login.xhtml)

### Enlace a Codacy

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/4467872301c7452ab97f76063e7a5523)](https://app.codacy.com/gh/ProyeCVDS20212/Proyecto?utm_source=github.com&utm_medium=referral&utm_content=ProyeCVDS20212/Proyecto&utm_campaign=Badge_Grade_Settings)

### Integrantes

- LEON BALLEN DIEGO ALEJANDRO
- OSPINA CALDERON JUAN SEBASTIAN
- MONROY SIERRA JUAN FELIPE

### Profesor

+ OSPINA RODRIGUEZ OSCAR DAVID (Product Owner)

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

### Descripción Sprint1

![Sprint1](img/Otras%20imagenes/Sprint1.png)

### Descripción Sprint2

![Sprint2](img/Otras%20imagenes/Sprint2.png)




