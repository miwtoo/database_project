CREATE TABLE customer(
    cus_id          number          not null,
    Cus_name        varchar2(30)    not null,
    cus_Address     varchar2(30)    null,
    BirthDay        date            null,
    Sex             char(1)         not null,
    creditcard      number          not null,
    cvv             number          not null,
    exp             date            not null,
    PERMISSION      number          not null,
PRIMARY KEY(cus_id)
);

CREATE TABLE account(
    username        varchar(20)     primary key,
    password        varchar(20)     not null,
    cus_id          number,
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id)
);
CREATE TABLE book(
    book_id	        number          not null,
    book_name       varchar(300)    null,
    type            varchar(100)    null,
    price_book      number          null,
    isbn            number          null,
    PRIMARY KEY (book_id)
);

CREATE TABLE writer(
    writer_id       number          PRIMARY KEY,
    writer_name     varchar2(100)   null,
    translater      varchar2(100)   null,
    composer        varchar2(100)   null
);

CREATE TABLE BASKET(
    cus_id          number          not null,
    Book_id         number          not null,
    status          varchar(20)     null,
    PRIMARY KEY(cus_id,book_id),
    FOREIGN KEY (book_id) REFERENCES BOOK(book_id) ON DELETE CASCADE,
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id)
);

CREATE TABLE Publisher(
    Pub_id          number          PRIMARY KEY,
    Pub_address     varchar2(100)   null,
    Pub_name        varchar2(100)   not null,
    Book_id         number          not null,
    FOREIGN KEY (book_id) REFERENCES BOOK(book_id) ON DELETE CASCADE
);

create table write(
    writer_id       number          not null,
    book_id	        number          not null,
    PRIMARY KEY(writer_id,book_id),
    FOREIGN KEY (book_id) REFERENCES book(book_id) ON DELETE CASCADE,
    FOREIGN KEY (writer_id) REFERENCES writer(writer_id) ON DELETE CASCADE
);

create sequence cus_seq;
create sequence book_seq;
create sequence write_seq;