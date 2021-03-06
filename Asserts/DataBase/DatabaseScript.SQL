CREATE TABLE ROLES (
	id NUMERIC(2) NOT NULL,
	nombre VARCHAR(15) NOT NULL,
    LimiteSolicitudes NUMERIC(2),
    LimiteOfertas numeric(2),
	CONSTRAINT "pk_ROLES" PRIMARY KEY (
	id),
	CONSTRAINT "uk_roles" UNIQUE (
	nombre)
);


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
     ),
     CONSTRAINT "fk_customerRoles" FOREIGN KEY(
         ROL
         ) REFERENCES ROLES(ID)

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

CREATE TABLE  NECESIDADES(
	id NUMERIC(7) NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	descripcion VARCHAR(250) NOT NULL,
    urgencia NUMERIC(1) NOT NULL,
	estado VARCHAR(1) NOT NULL,
	fechacreacion DATE NOT NULL,
	fechamodificacion DATE NOT NULL,
	categoriaId NUMERIC(9) NOT NULL,
    solicitante NUMERIC(9) NOT NULL,
    CONSTRAINT "pk_idNecesidades" PRIMARY KEY (
        id
     ),
     CONSTRAINT "fk_necesidadesCategoria" FOREIGN KEY(
         categoriaId
     ) REFERENCES Categoria(id),
     CONSTRAINT "fk_necesidadesCustome" FOREIGN KEY(
         solicitante
     ) REFERENCES Customer(CustomerID)
);

CREATE TABLE OFERTAS (
	id NUMERIC(7) NOT NULL,
	nombre VARCHAR(15) NOT NULL,
    descripcion VARCHAR(250),
    Estado VARCHAR(1) NOT NULL,
    fechacreacion DATE NOT NULL,
	fechamodificacion DATE NOT NULL,
    categoriaId NUMERIC(9) NOT NULL,
    solicitanteid numeric(9) NOT NULL,
	CONSTRAINT "pk_OFERTAS" PRIMARY KEY (
	id),
     CONSTRAINT "fk_ofertasCategoria" FOREIGN KEY(
         categoriaId
     ) REFERENCES Categoria(id),
          CONSTRAINT "fk_ofertassolicitante" FOREIGN KEY(
         solicitanteid
     ) REFERENCES Customer(CustomerID)
);

CREATE TABLE RESPUESTAS (
    id numeric(7) NOT NULL,
    nombre VARCHAR(15) NOT NULL,
    COMENTARIO VARCHAR(250),
    fechacreacion DATE NOT NULL,
    OFERTAID NUMERIC(7),
    NECESIDADID NUMERIC(7),
    remitente NUMERIC(9) not null,
    CONSTRAINT "fk_RESPUESTASOFERTA" FOREIGN KEY(
         OFERTAID
     ) REFERENCES OFERTAS(id),
          CONSTRAINT "fk_RESPUESTAcustomer" FOREIGN KEY(
         remitente
     ) REFERENCES Customer(CustomerID),
            CONSTRAINT "fk_RESPUESTANECESIDAD" FOREIGN KEY(
         NECESIDADID
     ) REFERENCES NECESIDADES(id)
);

Create or REPLACE FUNCTION autorespuesta() RETURNS trigger AS '
Declare
	autoid NUMERIC;
BEGIN
	select COUNT(*) into autoid from RESPUESTAS;
	NEW.id := autoid + 1;
    NEW.fechacreacion := current_date;
	RETURN NEW;
END;
' LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER bi_respuesta
BEFORE INSERT ON RESPUESTAS
FOR EACH ROW EXECUTE FUNCTION autorespuesta();

Create or REPLACE FUNCTION autoOfertas() RETURNS trigger AS '
Declare
	autoid NUMERIC;
BEGIN
	select COUNT(*) into autoid from ofertas;
	NEW.id := autoid + 1;
    NEW.fechacreacion := current_date;
    NEW.fechamodificacion := current_date;
	RETURN NEW;
END;
' LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER bi_ofertas
BEFORE INSERT ON ofertas
FOR EACH ROW EXECUTE FUNCTION autoOfertas();

Create or REPLACE FUNCTION autoCategoria() RETURNS trigger AS '
Declare
	autoid NUMERIC;
BEGIN
	select COUNT(*) into autoid from categoria;
	NEW.id := autoid + 1;
    NEW.fechacreacion := current_date;
    NEW.fechamodificacion := current_date;
    NEW.estado := true;
	RETURN NEW;
END;
' LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER bi_categoria
BEFORE INSERT ON categoria
FOR EACH ROW EXECUTE FUNCTION autoCategoria();

Create or REPLACE FUNCTION autoCustomer() RETURNS trigger AS '
Declare
	autoid NUMERIC;
BEGIN
	select COUNT(*) into autoid from Customer;
	NEW.CustomerID := autoid + 1;
	RETURN NEW;
END;
' LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER bi_customer
BEFORE INSERT ON customer
FOR EACH ROW EXECUTE FUNCTION autoCustomer();

Create or REPLACE FUNCTION autoNecesidades() RETURNS trigger AS '
Declare
	autoid NUMERIC;
BEGIN
	select COUNT(*) into autoid from NECESIDADES;
	NEW.id := autoid + 1;
    NEW.fechacreacion := current_date;
    NEW.fechamodificacion := current_date;
	RETURN NEW;
END;
' LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER bi_necesidades
BEFORE INSERT ON necesidades
FOR EACH ROW EXECUTE FUNCTION autoNecesidades();

insert into ROLES (ID,nombre,LimiteSolicitudes,LimiteOfertas) VALUES ( 1,'Administrador',10,10);
insert into ROLES (ID,nombre,LimiteSolicitudes,LimiteOfertas) VALUES ( 2,'Estudiante',10,10);
insert into ROLES (ID,nombre,LimiteSolicitudes,LimiteOfertas) VALUES ( 3,'Profesor',10,10);
insert into ROLES (ID,nombre,LimiteSolicitudes,LimiteOfertas) VALUES ( 4,'Egresado',10,10);
insert into ROLES (ID,nombre,LimiteSolicitudes,LimiteOfertas) VALUES ( 4,'Administrativo',10,10);