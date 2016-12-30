import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/30.
 */
public class StringToData {
    public static void stringToData(){
        String d = "2008-10-13 15:20:25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
        try {
            Date date = sdf.parse("20080808");
            System.out.println(date+" sssas");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public  static void main(String[] args){
        stringToData();
    }
}
