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
            String query = "select password,cus_id from BOOK_ONLINE.account WHERE username = '"+str+"'";
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }
    
}