CREATE TABLE BASKET(
    cus_id          number          not null,
    Book_id         number          not null,
    status          varchar(20)     null,
    PRIMARY KEY(cus_id,book_id),
    FOREIGN KEY (book_id) REFERENCES BOOK(book_id),
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id)
);

create table buy(
    cus_id          number          not null,
    book_id	        number          not null,
    PRIMARY KEY(cus_id,book_id),
    FOREIGN KEY (book_id) REFERENCES book(book_id),
    FOREIGN KEY (cus_id) REFERENCES customer(cus_id)
);

insert into basket values(1,1,'in process');
insert into basket values(1,2,'in process');
insert into basket values(2,4,'success');
insert into basket values(2,3,'success');
insert into basket values(2,5,'success');
insert into basket values(3,1,'in process');
insert into basket values(3,5,'in process');