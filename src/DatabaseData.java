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
    
    public boolean checkUser(String user, String pass) throws SQLException {
        boolean i = st.execute("SELECT password FROM account WHERE username = 'miwtoo';");
        return i;
    }
}