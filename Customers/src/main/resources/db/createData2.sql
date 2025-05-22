delete from Customer;
insert into Customer (id, name, surname,gender, age)values
                                                        (NEXT VALUE FOR customer_seq, 'Mario', 'Rossi','Male', 24),
                                                        (NEXT VALUE FOR customer_seq, 'Guido', 'Bianchi', 'Male',34),
                                                        (NEXT VALUE FOR customer_seq, 'Gino', 'Verdi', 'Female',57);
