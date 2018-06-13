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
    
    public boolean insertBookData() throws SQLException { 

        int i = st.executeUpdate("INSERT ALL  INTO BOOK_ONLINE.book VALUES(BOOK_ONLINE.book_seq.nextval ,'นาซ่าก็พาเธอกลับมาไม่ได้', 'ทั่วไป', 185.25, 9786161823269 )  INTO BOOK_ONLINE.writer VALUES(BOOK_ONLINE.write_seq.nextval , 'อิสญะ ตระกูลพุทธรักษา' , null , null)  INTO BOOK_ONLINE.Publisher VALUES(BOOK_ONLINE.book_seq.nextval ,'Bangkok','springbooks',BOOK_ONLINE.book_seq.nextval)  INTO BOOK_ONLINE.write VALUES(BOOK_ONLINE.write_seq.nextval,BOOK_ONLINE.book_seq.nextval)  SELECT * FROM dual"); 
        if (i > -1) {return true;}
        else {return false;} 
    }
}