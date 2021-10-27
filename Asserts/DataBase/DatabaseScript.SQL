CREATE TABLE Customer(
    CustomerID NUMERIC(9)   NOT NULL,
    Name VARCHAR(50)   NOT NULL,
    UserName VARCHAR(50)   NOT NULL,
    Passwd VARCHAR(50)   NOT NULL,
    Rol NUMERIC(2)   NOT NULL,
    Email VARCHAR(50)   NOT NULL,
    IsActive BOOL   NOT NULL,
    CONSTRAINT "pk_Customer" PRIMARY KEY (
        CustomerID
     )

);

CREATE TABLE Categoria (
    id NUMERIC(9)   NOT NULL,
    nombre VARCHAR(50)   NOT NULL,
    descripcion VARCHAR(50)   NOT NULL,
    fechacreacion DATE   NOT NULL,
    estado BOOL NOT NULL,
    fechamodificacion DATE  NOT NULL,
    CONSTRAINT "pk_id" PRIMARY KEY (
        id
     ),
     CONSTRAINT "UK_nombreCategoria" UNIQUE (
         nombre
     )
);

