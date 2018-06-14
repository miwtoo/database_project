package BookOnline;

import java.sql.ResultSet;
import java.sql.SQLException;
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
            String query = "select * from BOOK_ONLINE.account,BOOK_ONLINE.customer  WHERE username = '"+str+"' AND account.cus_id = customer.cus_id";
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
    
    public boolean insertBookData(String id, String name) throws SQLException { 

        int i = st.executeUpdate("insert into book VALUES('')"); 
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
    public boolean insertBasket(int id, String bookid) throws SQLException { 
        
        int i = st.executeUpdate("insert into BOOK_ONLINE.basket values("+id+","+bookid+",'in process')"); 
        if (i > -1) {return true;}
        else {return false;}
        
    }
    
    
    public ResultSet getBook() {
        try {
            String query = "select * from BOOK_ONLINE.VIEW_BOOKA";
            ResultSet rs = st.executeQuery(query);
            System.out.println(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    

}
