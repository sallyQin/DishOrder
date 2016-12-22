package cn.studyjams.s1.sj52.myapplication.database;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by 1 on 2016/11/29.
 */

public class VipCardDatabase {
    public String vipCard_num;
    public String code;
    public String balance;

    public  VipCardDatabase(String vipCard_num ,String code,String balance){
        this.vipCard_num = vipCard_num;
        this.code = code;
        this.balance = balance;
    }


    public static Map<Integer, VipCardDatabase> getDemoVIPNum(){  //设定的几组卡号和密码：
        Map<Integer,VipCardDatabase> demoVIPNum = new HashMap<>();
        demoVIPNum.put(1,new VipCardDatabase("AB11111111","111111","102元。"));
        demoVIPNum.put(2,new VipCardDatabase("AB22222222","222222","306元。"));
        demoVIPNum.put(3,new VipCardDatabase("AB33333333","333333","1000元。"));
        demoVIPNum.put(4,new VipCardDatabase("AB44444444","444444","55元。"));
        demoVIPNum.put(5,new VipCardDatabase("AB55555555","555555","105元。"));
        demoVIPNum.put(6,new VipCardDatabase("AB66666666","666666","32元。"));
        return  demoVIPNum;
    }

}
