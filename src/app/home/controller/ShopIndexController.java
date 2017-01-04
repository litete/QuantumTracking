package app.home.controller;

import app.home.model.*;
import app.home.service.ShopIndexService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.sql.Date;
import java.util.*;

/**
 * Created by Administrator on 2016/12/29.
 */
@Controller
@RequestMapping("/shopIndex")
public class ShopIndexController extends BaseController {
    private ShopIndexService thisService;

    public ShopIndexService getThisService() {
        return thisService;
    }

    @Autowired
    public void setThisService(ShopIndexService thisService) {
        this.thisService = thisService;
    }

    @RequestMapping("/selectIndex")
    @ResponseBody
    public String selectIndexByCondition(String data) {
        java.util.Date date1=null;
        System.out.println("data:" + data);
        AcceptJson acceptJson=new AcceptJson();
        ObjectMapper obj = new ObjectMapper();
        try {
            acceptJson = obj.readValue(data, AcceptJson.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("acceptJson" + acceptJson);
        //查出bar数据
        List<BrandIndex> brandIndexList = thisService.selectFocusIndex(acceptJson);

        System.out.println("brandIndexList:" + brandIndexList.size());
        List<Integer> brandIdList=new ArrayList();
        for (int i = 0; i < brandIndexList.size(); i++) {
            BrandIndex brandIndex = brandIndexList.get(i);
            date1=brandIndex.getDate();
            brandIdList.add(brandIndex.getBrand_id());
            System.out.println("brandIndexList1是：" + brandIndex.getBrand_id() + "+"
                    + brandIndex.getBrand_name()+"+"+brandIndex.getFocus_index()+"+"
                    +brandIndex.getPolularity_index()+"+"+brandIndex.getPurchase_index()+"+"
                    +brandIndex.getDevice_type()+"+"+brandIndex.getDate());
        }

//        for (int i = 0; i < fewTJdShopIndexBar.size(); i++) {
//            FewTJdShopIndex fewTJdShopIndex = fewTJdShopIndexBar.get(i);
//            System.out.println("fewTJdShopIndex是：" + fewTJdShopIndex.getDevice_type() + "+" + fewTJdShopIndex.getProduct_brand() +
//                    "+" + fewTJdShopIndex.getFocus_index());
//        }
        //将bar处理成要返回的初级格式
        List<ResultTJdBar> resultTJdBarsList = processResultTJdBar(brandIndexList);
        //将bar排序也就是将fewTJdShopIndexBar排序
        Collections.sort(resultTJdBarsList, new Comparator<ResultTJdBar>() {
            @Override
            public int compare(ResultTJdBar o1, ResultTJdBar o2) {
                if ((o1.getMobile() + o1.getPC()) == (o2.getMobile() + o2.getPC())) {
                    return 0;
                } else if ((o1.getMobile() + o1.getPC()) > (o2.getMobile() + o2.getPC())) {
                    return 1;
                } else {
                    return -1;
                }

            }

        });
        for (int i = 0; i < resultTJdBarsList.size(); i++) {
            ResultTJdBar res = resultTJdBarsList.get(i);
            System.out.println("bar要返回的格式为：" + res.getProduct_brand() + "+" + res.getMobile() + "+" + res.getPC());
        }

        //做数据处理
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
        java.util.Date date2=null;
        calendar.add(calendar.DATE,-30);
        date2= calendar.getTime();

        List<LittleTjdShopIndex> littleTjdShopIndexList=new ArrayList<LittleTjdShopIndex>();
        System.out.println("brandIdList.size():"+brandIdList.size());
        //        java.util.Date utilDate=new Date();
//        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        java.sql.Date date11=new java.sql.Date(date1.getTime());
        java.sql.Date date22=new java.sql.Date(date2.getTime());
        System.out.println(date22+" asd sd"+date11);
        AcceptJsonSelect acceptJsonSelect=new AcceptJsonSelect();
        acceptJsonSelect.setFirst_catalog(acceptJson.getFirst_catalog());
        acceptJsonSelect.setSecond_catalog(acceptJson.getSecond_catalog());
        acceptJsonSelect.setThird_catalog(acceptJson.getThird_catalog());
        acceptJsonSelect.setDate1(date11);
        acceptJsonSelect.setDate2(date22);
        for (int i = 0; i <brandIdList.size() ; i++) {
            System.out.println("brandIdList.get(i):"+brandIdList.get(i));

         acceptJsonSelect.setBrand_id( brandIdList.get(i));
         //查询line
         List<LittleTjdShopIndex> littleTjdShopIndexeLine = thisService.selectFocusIndexAddDateId(acceptJsonSelect);
            System.out.println("littleTjdShopIndexeLine:"+littleTjdShopIndexeLine.size());
            System.out.println("1111");
            for (int j = 0; j < littleTjdShopIndexeLine.size(); j++) {
                System.out.println("22222");
                LittleTjdShopIndex littleTJdShopIndex=littleTjdShopIndexeLine.get(i);
                System.out.println("littleTJdShopIndex:"+littleTJdShopIndex);
                littleTjdShopIndexList.add(littleTJdShopIndex);
            }
        }
        System.out.println("littleTjdShopIndexList:"+littleTjdShopIndexList.size());
          //处理littleTjdShopIndexeLine，将没有值的指数复制为150.00
        List<LittleTjdShopIndex> littleIndexlist = doLittleTjdShopIndex(littleTjdShopIndexList, date11);
        System.out.println("天数：" + littleIndexlist.size());
//        for (int i = 0; i < littleIndexlist.size(); i++) {
//            LittleTjdShopIndex index = littleIndexlist.get(i);
//            System.out.println("品牌" + index.getProduct_brand() + " 形式为" + index.getDevice_type()
//                    + " 日期为" + index.getDate_id() + " 指数Wie" + index.getFocus_index());
//        }
        //将line处理成要返回的初级形式
        List<ResultTjdLine> resultTjdLinesList = processResultTjdLine(littleIndexlist);
        for (int i = 0; i < resultTjdLinesList.size(); i++) {
            ResultTjdLine res = resultTjdLinesList.get(i);
            System.out.println("要返回的line的格式为：" + res.getProduct_brand() + "+" + res.getDate()
                    + "+" + res.getPC() + "+" + res.getMobile() + "+" + res.getAverage());
        }
        //做hashmap处理
        HashMap<String, FocusIndex> hashMap = doHashMap(resultTJdBarsList, resultTjdLinesList);
        //做返回json处理
        String json = null;
        try {

            json = obj.writeValueAsString(hashMap);
            System.out.println("json为" + json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    //将line处理成要返回的初级形式
    private List<ResultTjdLine> processResultTjdLine(List<LittleTjdShopIndex> littleIndexlist) {
        List<ResultTjdLine> resultTjdLineList = new ArrayList<ResultTjdLine>();
        for (int i = 0; i < littleIndexlist.size(); i++) {
            LittleTjdShopIndex little1List = littleIndexlist.get(i);
            ResultTjdLine resultTjdLine = new ResultTjdLine();
            resultTjdLine.setProduct_brand(little1List.getBrand_name());
            resultTjdLine.setDate(little1List.getDate());
            resultTjdLine.setPC(120.00);
            resultTjdLine.setMobile(120.00);

            resultTjdLine.setAverage((resultTjdLine.getPC() + resultTjdLine.getMobile()) / 2);
            for (int j = 1; j < littleIndexlist.size(); j++) {
                LittleTjdShopIndex little2List = littleIndexlist.get(j);
                if (little1List.getDevice_type()==1) {
                    resultTjdLine.setPC(little1List.getFocus_index());
                    if (little2List.getDevice_type()==2) {
                        resultTjdLine.setMobile(little2List.getFocus_index());
                        resultTjdLine.setAverage((resultTjdLine.getPC() + resultTjdLine.getMobile()) / 2);
                    } else {
                        resultTjdLine.setAverage((resultTjdLine.getPC() + resultTjdLine.getMobile()) / 2);
                    }
                } else if (little1List.getDevice_type()==1) {
                    resultTjdLine.setMobile(little1List.getFocus_index());
                    if (little2List.getDevice_type()==2) {
                        resultTjdLine.setPC(little2List.getFocus_index());
                        resultTjdLine.setAverage((resultTjdLine.getPC() + resultTjdLine.getMobile()) / 2);
                    } else {
                        resultTjdLine.setAverage((resultTjdLine.getPC() + resultTjdLine.getMobile()) / 2);
                    }
                }
            }
            resultTjdLineList.add(resultTjdLine);
        }
        return resultTjdLineList;
    }

    //做hashmap处理
    private HashMap<String, FocusIndex> doHashMap(List<ResultTJdBar> resultTJdBarsList, List<ResultTjdLine> resultTjdLinesList) {
        //bar处理
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();
        for (int i = 0; i < resultTJdBarsList.size(); i++) {
            ResultTJdBar resultTJdBar = resultTJdBarsList.get(i);
            String product_brand = resultTJdBar.getProduct_brand();
            list1.add(product_brand);
            double pc = resultTJdBar.getPC();
            list2.add(pc);
            double mobile = resultTJdBar.getMobile();
            list3.add(mobile);
        }
        Bar bar = new Bar();
        bar.setBrand(list1);
        bar.setPC(list2);
        bar.setMobile(list3);
        //Line处理
        List product_brandList=new ArrayList();
        List date_idList=new ArrayList();
        List pcList=new ArrayList();
        List mobileList=new ArrayList();
        List averageList=new ArrayList();
        for (int i = 0; i < resultTjdLinesList.size(); i++) {
          ResultTjdLine resultTjdLine=resultTjdLinesList.get(i);
            String product_brand = resultTjdLine.getProduct_brand();
            Date date_id = resultTjdLine.getDate();
            double pc = resultTjdLine.getPC();
            double mobile = resultTjdLine.getMobile();
            double average = resultTjdLine.getAverage();
            product_brandList.add(product_brand);
            date_idList.add(date_id);
            pcList.add(pc);
            mobileList.add(mobile);
            averageList.add(average);
        }
        Line line=new Line();
        line.setProduct_brand(product_brandList);
        line.setDate(date_idList);
        line.setPC(pcList);
        line.setMobile(mobileList);
        line.setAverage(averageList);
        FocusIndex focusIndex=new FocusIndex();
        focusIndex.setBar(bar);
        focusIndex.setLine(line);
        HashMap<String,FocusIndex> hashMap=new HashMap();
        hashMap.put("focus_index",focusIndex);
        return hashMap;


    }

    //将bar处理成要返回的格式
    private List<ResultTJdBar> processResultTJdBar( List<BrandIndex> brandIndexList) {
        List<ResultTJdBar> resultTJdBarsList = new ArrayList<ResultTJdBar>();
        for (int i = 0; i < brandIndexList.size(); i++) {
            BrandIndex brandIndex1 = brandIndexList.get(i);
            ResultTJdBar resultTJdBar = new ResultTJdBar();
            resultTJdBar.setProduct_brand(brandIndex1.getBrand_name());
            resultTJdBar.setPC(120.00);
            resultTJdBar.setMobile(120.00);
            for (int j = 1; j < brandIndexList.size(); j++) {
               BrandIndex brandIndex2  = brandIndexList.get(j);
                if (brandIndex1.getDevice_type()==1) {
                    resultTJdBar.setPC(brandIndex1.getFocus_index());
                    if (brandIndex2.getDevice_type()==2) {
                        resultTJdBar.setMobile(brandIndex2.getFocus_index());
                    }
                } else if (brandIndex1.getDevice_type()==2) {
                    resultTJdBar.setMobile(brandIndex1.getFocus_index());
                    if (brandIndex2.getDevice_type()==1) {
                        resultTJdBar.setPC(brandIndex2.getFocus_index());
                    }
                }
            }
            resultTJdBarsList.add(resultTJdBar);
        }
        return resultTJdBarsList;
    }

    //处理littleTjdShopIndexeLine，将没有值的指数复制为150.00
    private List<LittleTjdShopIndex> doLittleTjdShopIndex(List<LittleTjdShopIndex> littleTjdShopIndexList, java.sql.Date date) {
        //将没有值得日期的指数复制为150.00
        List<DateandString> dateandStringList = getShopIndex(littleTjdShopIndexList, date);
        //打印专用============================================================
        for (int i = 0; i < dateandStringList.size(); i++) {
            DateandString sd = dateandStringList.get(i);
            // System.out.println("日期是" + sd.getDate() + "指数是" + sd.getDou());
        }
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++`
        List<LittleTjdShopIndex> list = new ArrayList<LittleTjdShopIndex>();
        for (int i = 0; i < dateandStringList.size(); i++) {
            LittleTjdShopIndex littleTjdShopIndex = new LittleTjdShopIndex();
            for (int j = 0; j < littleTjdShopIndexList.size(); j++) {
                littleTjdShopIndex.setBrand_name(littleTjdShopIndexList.get(j).getBrand_name());
                littleTjdShopIndex.setDevice_type(littleTjdShopIndexList.get(j).getDevice_type());
                if (littleTjdShopIndexList.get(j).getDate().equals(dateandStringList.get(i).getDate())) {
                    littleTjdShopIndex.setDate(littleTjdShopIndexList.get(j).getDate());
                    littleTjdShopIndex.setFocus_index(littleTjdShopIndexList.get(j).getFocus_index());
                } else {
                    littleTjdShopIndex.setDate(dateandStringList.get(i).getDate());
                    littleTjdShopIndex.setFocus_index(dateandStringList.get(i).getDou());
                }
            }
            list.add(littleTjdShopIndex);
        }
        System.out.println("listSize是:" + list.size());
        return list;
    }

    //将没有值得日期的指数复制为150.00
    private List<DateandString> getShopIndex(List<LittleTjdShopIndex> list, java.sql.Date date) {
        //得到查询出的日期和的list
        //    List<DateandString> listDate = new ArrayList();
        List<DateandString> list2 = new ArrayList<DateandString>();//赋值的list
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

            Calendar calendar = new GregorianCalendar();

            calendar.setTime(date);
            List list1 = new ArrayList();
            List<DateandString> dateandStringList = new ArrayList<DateandString>();
            for (int i = 0; i < 30; i++) {
                calendar.add(calendar.DATE, -1);
                java.util.Date time = calendar.getTime();
                //把日期往后增加i天.整数往后推,负数往前移动
                date = new java.sql.Date(time.getTime());//这个时间就是日期往后推i天的结果
                list1.add(date);
            }
            //把日期和值都放入list
            for (int i = 0; i < list1.size(); i++) {
                DateandString dateandstring = new DateandString();
                dateandstring.setDate(date);
                dateandStringList.add(dateandstring);
            }
            //开始赋值
            //System.out.println("开始赋值");

            for (int i = 0; i < dateandStringList.size(); i++) {
                DateandString dateandString1 = new DateandString();
                dateandString1.setDate(dateandStringList.get(i).getDate());
                dateandString1.setDou(dateandStringList.get(i).getDou());
                for (int j = 0; j < list.size(); j++) {
                    if (dateandStringList.get(i).getDate().equals(list.get(j).getDate())) {
                        //dateandStringList.get(i).getString()=listDate.get(j).getString();
                        //list2.add(listDate.get(j));
                        dateandString1.setDate(list.get(j).getDate());
                        dateandString1.setDou(list.get(j).getFocus_index());
                        //System.out.println("11111111111111111");
                    } else {
                        //list2.add(dateandStringList.get(i));
                        //list2.add(dateandString1);
                        //System.out.println("222222222222222222222222222");
                    }
                    //list2.add(dateandString1);
                }
                list2.add(dateandString1);
            }

        return list2;
    }

    //时间和对应的值得字符串
    private class DateandString {
        private Date date;
        private double dou = 150.00;

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public double getDou() {
            return dou;
        }

        public void setDou(double dou) {
            this.dou = dou;
        }
    }

    //bar的实体类
    private class Bar {
        private List brand;
        private List PC;
        private List mobile;

        public List getBrand() {
            return brand;
        }

        public void setBrand(List brand) {
            this.brand = brand;
        }

        public List getPC() {
            return PC;
        }

        public void setPC(List PC) {
            this.PC = PC;
        }

        public List getMobile() {
            return mobile;
        }

        public void setMobile(List mobile) {
            this.mobile = mobile;
        }
    }

    //line的实体类
    private class Line {
        private List product_brand;

        public List getProduct_brand() {
            return product_brand;
        }

        public void setProduct_brand(List product_brand) {
            this.product_brand = product_brand;
        }

        private List date;
        private List PC;
        private List mobile;
        private List average;

        public List getDate() {
            return date;
        }

        public void setDate(List date) {
            this.date = date;
        }

        public List getPC() {
            return PC;
        }

        public void setPC(List PC) {
            this.PC = PC;
        }

        public List getMobile() {
            return mobile;
        }

        public void setMobile(List mobile) {
            this.mobile = mobile;
        }

        public List getAverage() {
            return average;
        }

        public void setAverage(List average) {
            this.average = average;
        }
    }
//focusindex实体类
    private class FocusIndex{
    private Bar bar;
    private Line line;

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }
}

}
