CREATE TABLE "Customer" (
    "CustomerID" NUMERIC(9)   NOT NULL,
    "Name" VARCHAR(50)   NOT NULL,
    "UserName" VARCHAR(50)   NOT NULL,
    "Passwd" VARCHAR(50)   NOT NULL,
    "Rol" NUMERIC(2)   NOT NULL,
    "Email" VARCHAR(50)   NOT NULL,
    "IsActive" NUMERIC(1)   NOT NULL,
    CONSTRAINT "pk_Customer" PRIMARY KEY (
        "CustomerID"
     )
);
