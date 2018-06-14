package BookOnline;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseData {
    private Statement st;
    public DatabaseData() {
        
    }
    public DatabaseData(Statement st) {
        this.st = st;
    }
    
    public ResultSet getData(String str) {
        try {
            String query = "select * from KRITZER." + str;
            System.out.println(query);
            ResultSet rs = st.executeQuery(query);
            
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public ResultSet getPassword(String str) {
        try {
            String query = "select * from KRITZER.account,KRITZER.customer  WHERE username = '"+str+"' AND account.cus_id = customer.cus_id";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
    public boolean deleteBookData(String id) throws SQLException {
        boolean i = st.execute("DELETE FROM KRITZER.book WHERE book_id = " + id);
        return i;
    }
    
    public boolean insertBookData(String id, String name) throws SQLException { 

        int i = st.executeUpdate("insert into book VALUES('')"); 
        if (i > -1) {return true;} 
        else {return false;} 
    }
}