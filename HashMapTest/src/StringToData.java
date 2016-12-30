import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/30.
 */
public class StringToData {
    public static void stringToData(){
        String d = "2008-10-13 15:20:25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try {
            System.out.println(sdf.parse(d));
            System.out.println("1111");
        } catch (Exception e) {
        }
    }
    public  static void main(String[] args){
        stringToData();
    }
}
