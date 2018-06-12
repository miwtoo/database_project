
package BookOnline;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookOnline {
    static DatabaseConnection db = new DatabaseConnection();
    static DatabaseData my;
    public static void main(String[] args) {
        db.connectDB();
        my = new DatabaseData(db.getSt());
        new login().setVisible(true);
    }
}
