
package BookOnline;


public class BookOnline {
    static DatabaseConnection db = new DatabaseConnection();
    static DatabaseData my;
    public static void main(String[] args) {
        db.connectDB();
        my = new DatabaseData(db.getSt());
        new login().setVisible(true);
    }
    public static boolean StringToBoolean (Object ob){
        try{
            ob.toString();
        }
        catch(NullPointerException exc){
            return false;
            
        }
        return true;
    }
    public static String convertDate(String st){
        //2018-06-17
        String[] arr = st.split("-");
        
        return arr[2] + arr[1] + arr[0].substring(2);
    }
}
