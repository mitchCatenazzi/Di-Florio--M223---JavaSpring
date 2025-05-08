create table if not exists Car(
    id            identity,
    color         varchar(50) not null,
    carMaker         varchar(100) not null,
    model        varchar(50) not null,
    horsePower       int not null,
    price        int not null,
    registrationDate date
    );
