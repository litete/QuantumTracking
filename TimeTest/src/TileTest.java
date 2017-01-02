import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lite on 2016/12/31.
 */
public class TileTest {
    public static void main(String[] args){
        TileTest test=new TileTest();
        test.timetest();
    }
    public void timetest(){
        String string = "20140317";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;

        try {
            date = sdf.parse(string);
            System.out.println( "asdasd");

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(date);
            List list1=new ArrayList();
            List<DateandString> dateandStringList=new ArrayList<DateandString>();
        for (int i=0;i<30;i++){
            calendar.add(calendar.DATE,i);//把日期往后增加i天.整数往后推,负数往前移动
            date=calendar.getTime();//这个时间就是日期往后推i天的结果

            list1.add(date);
        }

            for (int i=0;i<list1.size();i++){
                String putDate = sdf.format(list1.get(i));
                DateandString dateandstring=new DateandString();
                dateandstring.setDate(putDate);
                dateandStringList.add(dateandstring);
                //System.out.println("putDate"+putDate);
            }
            for (int i = 0; i <dateandStringList.size() ; i++) {
                DateandString da=dateandStringList.get(i);
                System.out.println("Date:"+da.getDate());
                System.out.println("String"+da.getString()+"sss");
            }
            System.out.println("大小为:"+list1.size());
           // System.out.println("dateStr"+dateStr);
           // String putDate = sdf.format(date);
            //System.out.println(putDate);


        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private class DateandString{
        private String date;
        private String string=" ";

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }
}
