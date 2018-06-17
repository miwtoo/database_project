INSERT INTO book VALUES(1,'นาซ่าก็พาเธอกลับมาไม่ได้', 'ทั่วไป', 185.25, 9786161823269 );
INSERT INTO book VALUES(2, 'New English Grammar & Vocabulary Book 2', 'การศึกษา', 160.55,  9789744329707);
INSERT INTO book VALUES(3, 'The Sky So Near', 'วรรณกรรม', 560.50,  9786165101325 );
INSERT INTO book VALUES(4, 'A Piece of the Moon', 'วรรณกรรม', 284.05, 9786160621989);
INSERT INTO book VALUES(5, 'OS Online Station No.683', 'นิตยสาร', 28.05, 9772032683001);
INSERT INTO book VALUES(6,'วิธีบริหารเวลา ให้คุ้มค่าที่สุดในแต่ละวัน', 'ทั่วไป', 84.55 , 9786164440098 );
INSERT INTO book VALUES(7,'ไม่อยากเจ๊ง ต้องเก็งให้ถูก มองอสังหาฯ ด้วยสายตานักลงทุน (มืออาชีพ)', 'การเงินการลงทุน', 213.75 , 9786167913759  );
INSERT INTO book VALUES(8,'Pilot DNA จากฝันสู่ฟ้า', 'การจัดการการศึกษา', 288.00, 9786160831968 );
INSERT INTO book VALUES(9,'วิจัยไม่ใช่เรื่องยาก', 'การจัดการการศึกษา',114.00 ,  9786167398860);
INSERT INTO book VALUES(10,'ระเบียบวิธีวิจัย หลักการและแนวคิด เทคนิคการเขียนรายงานการวิจัย', 'คู่มือเรียน - สอบ'304.00  , 9789744142627);

INSERT INTO writer VALUES(1 , 'อิสญะ ตระกูลพุทธรักษา' , null , null);
INSERT INTO writer VALUES(2 , 'ุฑาธิป พึ่งละออ' , null , null);
INSERT INTO writer VALUES(3 , 'Pensri Kiengsiri' , null , null);
INSERT INTO writer VALUES(4 , 'Ha-Hyun' , 'Hyunmeen' , null);
INSERT INTO writer VALUES(5 , 'นิตยสารเกมออนไลน์' , null , null);


INSERT INTO Publisher VALUES(1,'Bangkok','springbooks',1);
INSERT INTO Publisher VALUES(2,'Bangkok','อิสญะ ตระกูลพุทธรักษา',2);
INSERT INTO Publisher VALUES(3,'Seoul','Woman publisher',3);
INSERT INTO Publisher VALUES(4,'Bangkok','แจ่มใส, สนพ.',4);
INSERT INTO Publisher VALUES(5,'Bangkok','ทรู มีเดีย โซลูชั่นส์, บจก.',5);

INSERT INTO customer VALUES (1,'m','a',to_date('010101','MMDDYY'),'aaaa',to_date('020908','MMDDYY'),0);
INSERT INTO customer VALUES (2,'m','b',to_date('020304','MMDDYY'),'bbbb',to_date('030908','MMDDYY'),1);
INSERT INTO customer VALUES (3,'w','c',to_date('120314','MMDDYY'),'cccc',to_date('032208','MMDDYY'),1);
INSERT INTO customer VALUES (4,'w','d',to_date('122314','MMDDYY'),'dddd',to_date('042408','MMDDYY'),1);
INSERT INTO customer VALUES (5,'m','e',to_date('100304','MMDDYY'),'eeee',to_date('051609','MMDDYY'),0);

INSERT INTO account VALUES('miwtoo','123456',1);
INSERT INTO account VALUES('erntle','000000',2);
INSERT INTO account VALUES('kritser','789456',3);
INSERT INTO account VALUES('tiwa','321654',4);
INSERT INTO account VALUES('toey','189986',5);

INSERT INTO write VALUES(1,1);
INSERT INTO write VALUES(2,2);
INSERT INTO write VALUES(3,3);
INSERT INTO write VALUES(4,4);
INSERT INTO write VALUES(5,5);


insert into basket values(1,1,'in process');
insert into basket values(1,2,'in process');
insert into basket values(2,4,'success');
insert into basket values(2,3,'success');
insert into basket values(2,5,'success');
insert into basket values(3,1,'in process');
insert into basket values(3,5,'in process');