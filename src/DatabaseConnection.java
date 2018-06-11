import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DatabaseConnection {
    private Connection myDBCon;
    private Statement st;
    public DatabaseConnection() {}
    
    public Statement getSt(){
        return st;
    }
    
    public void setSt(Statement st){
        this.st = st;
    }
    
    public Connection getMyDBCon(){
        return myDBCon;
    }
    
    public void setMyDBCon(Connection myDBCon){
        this.myDBCon = myDBCon;
    }
    
    public void connectDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find class oracle.jdbc.driver.OracleDriver");
            System.exit(1);
        }
        try {
        myDBCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "1234");
            st = myDBCon.createStatement();
            System.out.println("Connected success");
        } catch (Exception e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }
    
}
