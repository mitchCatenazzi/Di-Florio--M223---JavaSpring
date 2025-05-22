delete from Customer;
insert into Customer (id, name, surname,gender, age)values
                                                        (NEXT VALUE FOR customer_seq, 'Pascal', 'Rossi','Male', 24),
                                                        (NEXT VALUE FOR customer_seq, 'Piero', 'Bianchi', 'Male',34),
                                                        (NEXT VALUE FOR customer_seq, 'Paolo', 'Verdi', 'Female',57);
