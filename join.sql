SELECT b.book_name, b.type, b.price_book, b.isbn, pub_name, pub_address, writer_name, translater, composer
FROM book b, publisher p, writer w, write wr 
WHERE p.book_id = b.book_id AND w.writer_id = wr.writer_id AND b.book_id = wr.book_id