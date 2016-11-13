package cn.studyjams.s1.sj52.myapplication.database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apc on 2016/8/7.
 */
public class Order {

    public String dishName;
    public int dishPrice;
    public int dishQuantity;
    public static int total;
    public static int perPrice =0;

    public Order(String dishName, int dishPrice,int dishQuantity) {
        this.dishPrice = dishPrice;
        this.dishName = dishName;
        this.dishQuantity = dishQuantity;
    }

    public static List<Order> ordersList = new ArrayList<>();

    public static int getOrdersList() {
        total = 0;
        if(ordersList.size() != 0){
           for(int i = 0;i<ordersList.size();i++){
               perPrice= (ordersList.get(i).dishQuantity )* (ordersList.get(i).dishPrice);
               total = perPrice +total;
       }return total;
    }else return 0;}
}
