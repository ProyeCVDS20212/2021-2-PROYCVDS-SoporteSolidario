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
	estado BOOL NOT NULL,
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

CREATE TABLE ROLES (
	id NUMERIC(2) NOT NULL,
	NOMBRE VARCHAR(15) NOT NULL,
    LimiteSolicitudes NUMERIC(2),
	CONSTRAINT "	pk_ROLES" PRIMARY KEY (
	id),
	CONSTRAINT "uk_roles" UNIQUE (
	NOMBRE)
);

CREATE TABLE OFERTAS (
	id NUMERIC(7) NOT NULL,
	NOMBRE VARCHAR(15) NOT NULL,
    descripcion NUMERIC(2),
    Estado BOOL NOT NULL,
    fechacreacion DATE NOT NULL,
	fechamodificacion DATE NOT NULL,
    categoriaId NUMERIC(9) NOT NULL,
	CONSTRAINT "pk_OFERTAS" PRIMARY KEY (
	id),
     CONSTRAINT "fk_ofertasCategoria" FOREIGN KEY(
         categoriaId
     ) REFERENCES Categoria(id)
);

Create or REPLACE FUNCTION autoOfertas() RETURNS trigger AS '
Declare
	autoid NUMERIC;
BEGIN
	select COUNT(*) into autoid from ofertas;
	NEW.id := autoid + 1;
    NEW.fechacreacion := current_date;
    NEW.fechamodificacion := current_date;
    NEW.estado := true;
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
    NEW.estado := true;
	RETURN NEW;
END;
' LANGUAGE plpgsql VOLATILE;


CREATE TRIGGER bi_necesidades
BEFORE INSERT ON necesidades
FOR EACH ROW EXECUTE FUNCTION autoNecesidades();