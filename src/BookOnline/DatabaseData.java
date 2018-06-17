package BookOnline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class DatabaseData {
    
    private Statement st;
    

    public DatabaseData(Statement st) {
        this.st = st;
    }

    public ResultSet getData(String str) {
        try {
            String query = "select * from BOOK_ONLINE." + str;
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public ResultSet getPassword(String str) {
        try {
            String query = "select * from BOOK_ONLINE.account,BOOK_ONLINE.customer  WHERE username = '" + str + "' AND account.cus_id = customer.cus_id";
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public boolean deleteBookData(String id) throws SQLException {
        boolean i = st.execute("DELETE FROM BOOK_ONLINE.book WHERE book_id = " + id);
        return i;
    }

    public ResultSet getBasket(int cid) {
        try {
            String query = "select * from BOOK_ONLINE.book, BOOK_ONLINE.basket WHERE book.book_id = basket.book_id and cus_id = '"+cid+"' and status = 'in process'";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    

    public boolean insertBookData(String bookname, String booktype, Double price, String isbn,String writename, String tranname, String componame, String pubadd,String pubname) throws SQLException { 

        int i = st.executeUpdate("INSERT ALL  INTO BOOK_ONLINE.book VALUES(BOOK_ONLINE.book_seq.nextval ,'"+bookname+"', '"+booktype+"', "+price+", '"+isbn+"' )  INTO BOOK_ONLINE.writer VALUES(BOOK_ONLINE.write_seq.nextval , '"+writename+"' , '"+tranname+"' , '"+componame+"')  INTO BOOK_ONLINE.Publisher VALUES(BOOK_ONLINE.book_seq.nextval ,'"+pubadd+"','"+pubname+"',BOOK_ONLINE.book_seq.nextval)  INTO BOOK_ONLINE.write VALUES(BOOK_ONLINE.write_seq.nextval,BOOK_ONLINE.book_seq.nextval)  SELECT * FROM dual"); 
        if (i > -1) {return true;}
        else {return false;} 
    }
    public boolean updateStatus(int cid) throws SQLException {
        int i = st.executeUpdate("update BOOK_ONLINE.basket set status = 'success' where cus_id = '"+cid+"'");
        if (i > -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean insertBasket(int id, int bookid) throws SQLException { 
        String q = "insert into BOOK_ONLINE.basket values("+id+","+bookid+",'in process')";
        System.out.println(q);
        boolean i = st.execute(q);
        return i;
        
    }
    
    public boolean DelBasket(int id, int bookid) throws SQLException { 
        String q = "delete from BOOK_ONLINE.basket WHERE cus_id = "+id+" AND book_id = "+bookid+" AND status = 'in process'";
        int i = st.executeUpdate(q); 
        if (i > -1) {return true;}
        else {return false;}
        
    }
    
    public ResultSet getBook(String name,int id){
        try {
            String query = "select book.book_id,book.book_name,publisher.pub_name,writer.writer_name,writer.translater,book.isbn,book.price_book "
                    + "from BOOK_ONLINE.book,BOOK_ONLINE.write,BOOK_ONLINE.writer,BOOK_ONLINE.publisher "
                    + "where book.book_id = publisher.book_id and book.book_id = write.book_id and book.book_id = publisher.book_id and write.writer_id = writer.writer_id and book_name LIKE '%"+name+"%'";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public ResultSet getBookByName(String name){
        try {
            String query = "select * from BOOK_ONLINE.view_booka where book_name LIKE '%"+name+"%'";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public ResultSet getHistory(int cid){
        try {
            String query = "SELECT customer.cus_id, book.book_id ,book_name , status FROM BOOK_ONLINE.book,BOOK_ONLINE.basket,BOOK_ONLINE.customer WHERE book.book_id = basket.book_id AND customer.cus_id = basket.cus_id AND customer.cus_id = "+cid+" AND status = 'success'";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public boolean insertRegister(String user, String pass, String add, String birth, String sex, String ccn, String cvv, String exp,String name) throws SQLException {
       
       String q ="INSERT ALL INTO BOOK_ONLINE.customer VALUES( BOOK_ONLINE.cus_seq.nextval ,'"+ name +"','"+ add +"',to_date('"+ birth +"','DDMMYY'),'"+ sex +"',"+ ccn +","+ cvv +",to_date('"+ exp +"','DDMMYY'),0) INTO BOOK_ONLINE.account VALUES('"+ user +"','"+ pass +"',BOOK_ONLINE.cus_seq.nextval ) SELECT * FROM dual";
         System.out.println(q);
         boolean i = st.execute(q);
         
   
        
        return i ;
   }

}

