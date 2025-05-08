delete from Customer;
insert into Customer (id, name, surname,gender, age)values
(NEXT VALUE FOR customer_log, 'Mario', 'Rossi','Male', 24),
(NEXT VALUE FOR customer_log, 'Guido', 'Bianchi', 'Male',34),
(NEXT VALUE FOR customer_log, 'Gino', 'Verdi', 'Female',57);
