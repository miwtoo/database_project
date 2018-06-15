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
            System.out.println(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    

    public boolean insertBookData(String bookname, String booktype, Double price, int isbn,String writename, String tranname, String componame, String pubadd,String pubname) throws SQLException { 

        int i = st.executeUpdate("INSERT ALL  INTO BOOK_ONLINE.book VALUES(BOOK_ONLINE.book_seq.nextval ,'"+bookname+"', '"+booktype+"', "+price+", "+isbn+" )  INTO BOOK_ONLINE.writer VALUES(BOOK_ONLINE.write_seq.nextval , '"+writename+"' , '"+tranname+"' , '"+componame+"')  INTO BOOK_ONLINE.Publisher VALUES(BOOK_ONLINE.book_seq.nextval ,'"+pubadd+"','"+pubname+"',BOOK_ONLINE.book_seq.nextval)  INTO BOOK_ONLINE.write VALUES(BOOK_ONLINE.write_seq.nextval,BOOK_ONLINE.book_seq.nextval)  SELECT * FROM dual"); 
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
        int i = st.executeUpdate(q); 
        if (i > -1) {return true;}
        else {return false;}
        
    }
    
    
    public ResultSet getBook() throws SQLIntegrityConstraintViolationException{
        try {
            String query = "select * from BOOK_ONLINE.view_booka";
            ResultSet rs = st.executeQuery(query);
            System.out.println(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    

}

