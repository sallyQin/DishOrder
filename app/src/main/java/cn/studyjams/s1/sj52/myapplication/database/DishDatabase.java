package cn.studyjams.s1.sj52.myapplication.database;

import android.annotation.SuppressLint;


import java.util.HashMap;
import java.util.Map;
import cn.studyjams.s1.sj52.myapplication.R;


/**
 * Created by Apc on 2016/7/25.
 */
public class DishDatabase { //所有菜肴数据data
    public int dish_pic;
    public String dish_name1;
    public String main_material1;
    public int price1;


    public static DishDatabase dishDatabase_search;

    public DishDatabase(int dish_pic,String dish_name,String main_material,int price){
        this.dish_pic = dish_pic;
        this.dish_name1 = dish_name;
        this.main_material1= main_material;
        this.price1= price;
    }

   public static Map<String,DishDatabase>getMenuData(){
       @SuppressLint("UseSparseArrays")

       Map<String,DishDatabase> map = new HashMap<>();

       map.put("[0][0]",new DishDatabase(R.drawable.specials_1,dish_name[0][0],main_material[0][0],price[0][0]));
       map.put("[0][1]",new DishDatabase(R.drawable.specials_2,dish_name[0][1],main_material[0][1],price[0][1]));
       map.put("[0][2]",new DishDatabase(R.drawable.specials_3,dish_name[0][2],main_material[0][2],price[0][2]));
       map.put("[0][3]",new DishDatabase(R.drawable.specials_4,dish_name[0][3],main_material[0][3],price[0][3]));
       map.put("[0][4]",new DishDatabase(R.drawable.specials_5,dish_name[0][4],main_material[0][4],price[0][4]));
       map.put("[0][5]",new DishDatabase(R.drawable.specials_6,dish_name[0][5],main_material[0][5],price[0][5]));
       map.put("[0][6]",new DishDatabase(R.drawable.specials_7,dish_name[0][6],main_material[0][6],price[0][6]));
       map.put("[0][7]",new DishDatabase(R.drawable.specials_8,dish_name[0][7],main_material[0][7],price[0][7]));
       map.put("[1][0]",new DishDatabase(R.drawable.offer_today_1,dish_name[1][0],main_material[1][0],price[1][0]));
       map.put("[1][1]",new DishDatabase(R.drawable.offer_today_2,dish_name[1][1],main_material[1][1],price[1][1]));
       map.put("[1][2]",new DishDatabase(R.drawable.offer_today_3,dish_name[1][2],main_material[1][2],price[1][2]));
       map.put("[1][3]",new DishDatabase(R.drawable.offer_today_4,dish_name[1][3],main_material[1][3],price[1][3]));
       map.put("[1][4]",new DishDatabase(R.drawable.offer_today_5,dish_name[1][4],main_material[1][4],price[1][4]));
       map.put("[2][0]",new DishDatabase(R.drawable.hot_dish1,dish_name[2][0],main_material[2][0],price[2][0]));
       map.put("[2][1]",new DishDatabase(R.drawable.hot_dish2,dish_name[2][1],main_material[2][1],price[2][1]));
       map.put("[2][2]",new DishDatabase(R.drawable.hot_dish3,dish_name[2][2],main_material[2][2],price[2][2]));
       map.put("[2][3]",new DishDatabase(R.drawable.hot_dish4,dish_name[2][3],main_material[2][3],price[2][3]));
       map.put("[2][4]",new DishDatabase(R.drawable.hot_dish5,dish_name[2][4],main_material[2][4],price[2][4]));
       map.put("[2][5]",new DishDatabase(R.drawable.hot_dish6,dish_name[2][5],main_material[2][5],price[2][5]));
       map.put("[2][6]",new DishDatabase(R.drawable.hot_dish7,dish_name[2][6],main_material[2][6],price[2][6]));
       map.put("[2][7]",new DishDatabase(R.drawable.hot_dish8,dish_name[2][7],main_material[2][7],price[2][7]));
       map.put("[2][8]",new DishDatabase(R.drawable.hot_dish9,dish_name[2][8],main_material[2][8],price[2][8]));
       map.put("[2][9]",new DishDatabase(R.drawable.hot_dish10,dish_name[2][9],main_material[2][9],price[2][9]));
       map.put("[2][10]",new DishDatabase(R.drawable.hot_dish11,dish_name[2][10],main_material[2][10],price[2][10]));
       map.put("[2][11]",new DishDatabase(R.drawable.hot_dish12,dish_name[2][11],main_material[2][11],price[2][11]));
       map.put("[2][12]",new DishDatabase(R.drawable.hot_dish13,dish_name[2][12],main_material[2][12],price[2][12]));
       map.put("[2][13]",new DishDatabase(R.drawable.hot_dish14,dish_name[2][13],main_material[2][13],price[2][13]));
       map.put("[2][14]",new DishDatabase(R.drawable.hot_dish15,dish_name[2][14],main_material[2][14],price[2][14]));
       map.put("[2][15]",new DishDatabase(R.drawable.hot_dish16,dish_name[2][15],main_material[2][15],price[2][15]));
       map.put("[2][16]",new DishDatabase(R.drawable.hot_dish17,dish_name[2][16],main_material[2][16],price[2][16]));
       map.put("[3][0]",new DishDatabase(R.drawable.cold_dish1,dish_name[3][0],main_material[3][0],price[3][0]));
       map.put("[3][1]",new DishDatabase(R.drawable.cold_dish2,dish_name[3][1],main_material[3][1],price[3][1]));
       map.put("[3][2]",new DishDatabase(R.drawable.cold_dish3,dish_name[3][2],main_material[3][2],price[3][2]));
       map.put("[3][3]",new DishDatabase(R.drawable.cold_dish4,dish_name[3][3],main_material[3][3],price[3][3]));
       map.put("[3][4]",new DishDatabase(R.drawable.cold_dish5,dish_name[3][4],main_material[3][4],price[3][4]));
       map.put("[3][5]",new DishDatabase(R.drawable.cold_dish6,dish_name[3][5],main_material[3][5],price[3][5]));
       map.put("[3][6]",new DishDatabase(R.drawable.cold_dish7,dish_name[3][6],main_material[3][6],price[3][6]));
       map.put("[3][7]",new DishDatabase(R.drawable.cold_dish8,dish_name[3][7],main_material[3][7],price[3][7]));
       map.put("[4][0]",new DishDatabase(R.drawable.soup1,dish_name[4][0],main_material[4][0],price[4][0]));
       map.put("[4][1]",new DishDatabase(R.drawable.soup2,dish_name[4][1],main_material[4][1],price[4][1]));
       map.put("[4][2]",new DishDatabase(R.drawable.soup3,dish_name[4][2],main_material[4][2],price[4][2]));
       map.put("[4][3]",new DishDatabase(R.drawable.soup4,dish_name[4][3],main_material[4][3],price[4][3]));
       map.put("[4][4]",new DishDatabase(R.drawable.soup5,dish_name[4][4],main_material[4][4],price[4][4]));
       map.put("[4][5]",new DishDatabase(R.drawable.soup6,dish_name[4][5],main_material[4][5],price[4][5]));
       map.put("[5][0]",new DishDatabase(R.drawable.dessert1,dish_name[5][0],main_material[5][0],price[5][0]));
       map.put("[5][1]",new DishDatabase(R.drawable.dessert2,dish_name[5][1],main_material[5][1],price[5][1]));
       map.put("[5][2]",new DishDatabase(R.drawable.dessert3,dish_name[5][2],main_material[5][2],price[5][2]));
       map.put("[5][3]",new DishDatabase(R.drawable.dessert4,dish_name[5][3],main_material[5][3],price[5][3]));
       map.put("[5][4]",new DishDatabase(R.drawable.dessert5,dish_name[5][4],main_material[5][4],price[5][4]));
       map.put("[5][5]",new DishDatabase(R.drawable.dessert6,dish_name[5][5],main_material[5][5],price[5][5]));
       map.put("[5][6]",new DishDatabase(R.drawable.dessert7,dish_name[5][6],main_material[5][6],price[5][6]));
       map.put("[5][7]",new DishDatabase(R.drawable.dessert8,dish_name[5][7],main_material[5][7],price[5][7]));
       map.put("[6][0]",new DishDatabase(R.drawable.main_staple1,dish_name[6][0],main_material[6][0],price[6][0]));
       map.put("[6][1]",new DishDatabase(R.drawable.main_staple2,dish_name[6][1],main_material[6][1],price[6][1]));
       map.put("[6][2]",new DishDatabase(R.drawable.main_staple3,dish_name[6][2],main_material[6][2],price[6][2]));
       map.put("[6][3]",new DishDatabase(R.drawable.main_staple4,dish_name[6][3],main_material[6][3],price[6][3]));
       map.put("[6][4]",new DishDatabase(R.drawable.main_staple5,dish_name[6][4],main_material[6][4],price[6][4]));
       map.put("[6][5]",new DishDatabase(R.drawable.main_staple6,dish_name[6][5],main_material[6][5],price[6][5]));
       map.put("[7][0]",new DishDatabase(R.drawable.drinks1,dish_name[7][0],main_material[7][0],price[7][0]));
       map.put("[7][1]",new DishDatabase(R.drawable.drinks2,dish_name[7][1],main_material[7][1],price[7][1]));
       map.put("[7][2]",new DishDatabase(R.drawable.drinks3,dish_name[7][2],main_material[7][2],price[7][2]));
       map.put("[7][3]",new DishDatabase(R.drawable.drinks4,dish_name[7][3],main_material[7][3],price[7][3]));
       map.put("[7][4]",new DishDatabase(R.drawable.drinks5,dish_name[7][4],main_material[7][4],price[7][4]));
       map.put("[7][5]",new DishDatabase(R.drawable.drinks6,dish_name[7][5],main_material[7][5],price[7][5]));
       map.put("[7][6]",new DishDatabase(R.drawable.drinks7,dish_name[7][6],main_material[7][6],price[7][6]));

        return map;
   }



       public static String dish_name[][] = {
                {"辣响划水", "蜜汁东坡肉", "铁板芋头", "日式鳗鱼饭", "素香饼", "豌豆堡垒", "蟹黄银鱼", "铁板蜜牛肉"},
                {"肉夹馍", "叉烧芦篙", "香肉芹菜", "三鲜回锅肉", "辣炒鸡丁"},
                {"特制东坡肉", "混搭三鲜", "荷塘月色", "鲜色基围虾", "茄瓜塞肉", "香炸肋骨", "香芒鱼片", "香丝猴头菇", "香煎牛肉粒", "多味老豆腐", "清炒腰花", "鲜贝菌菇", "花式澳洲龙虾", "彩椒蘑菇","松子小鱿鱼", "鸡骨丁小盏", "酸甜山药"},
                {"油辣鸡", "酱肉肘子", "冰心萝卜&枣", "桂花糯米藕", "冰爽芥兰", "辣菠花生", "柠檬水晶肉", "皮蛋拌豆腐"},
                {"乾坤.玉米羹", "咸肉萝卜汤", "多味干丝羹", "三鲜咸肉汤", "清香鲫鱼汤", "红枣莲子羹"},
                {"抹茶蛋糕", "炸香蕉", "紫薯山药糕", "豆沙春卷", "冰糖芋头", "菠萝一口酥", "香草冰激凌", "芒果西米露"},
                {"甜味八宝饭", "夹心奶味馒头", "香煎小肉包", "香葱汤面", "双味饺子", "日式牛肉面"},
                {"西瓜汁", "芒果汁", "鲜橙汁", "啤酒", "玉米汁", "可乐", "红酒"}};


       static String main_material[][] = {
                {"鱼尾，味中辣","东坡肉、海带、椰菜，味偏甜","芋头，味咸甜","鳗鱼、蛋卷，味香甜","韭菜、鸡蛋、木耳，口味咸","豌豆，味鲜咸","蟹黄、银鱼、蛋，味咸鲜","牛肉、甜椒，味咸甜"},
                {"猪肉、馒头，味中甜","叉烧肉、芦篙，味偏甜","芹菜、猪肉，味咸","回锅肉、多种素菜，味咸","鸡丁、韭篙，味中辣"},
                {"东坡肉，味甜","削肉、香菇、菠菜，味咸","荷兰豆、莲藕，味咸","虾、蔬菜，味鲜咸","苦瓜、肉糜、茄子，味咸","肋骨，味鲜咸","鱼片、芒果，味咸鲜","猴头菇、芦篙，味咸,",
                        "大块牛肉粒，味咸","老豆腐、肉末，味甜酸","腰花、百合，味咸","鲜贝、菌菇，味鲜咸","澳洲龙虾、虾球，味鲜咸","彩椒、蘑菇，味鲜咸","小鱿鱼、松子，味甜鲜",
                        "鸡肉丁、茭白、鲜菇，味鲜","山药，味酸甜"},
                {"鸡肉，味重辣","猪肉肘子、萝卜条，味咸","萝卜、枣、冰糖，味甜","糯米、藕，味香甜","芥兰，味咸爽","菠菜、花生，味中辣","水晶肉、柠檬，味咸酸","皮蛋、豆腐，味鲜咸"},
                {"玉米羹、菜末，味微甜","咸肉、萝卜，味偏甜","蛋羹、笋丝，味咸","咸肉、笋、山药，味鲜咸","鲫鱼、萝卜，口味咸","红枣、莲子，味甜"},
                {"抹茶味蛋糕","香蕉","紫薯、山药","红豆馅春卷","芋头仔","菠萝","冰激凌、草莓","芒果、西米露"},
                {"松子、糯米饭","玉米粉、牛奶","猪肉糜","光面","香菇、肉糜","牛肉块、日式粗面"},
                {"新鲜西瓜","鲜芒果","鲜柳橙","纯生牌","鲜熟玉米","百事可乐牌","张裕牌"}};

       static int price[][] = {
                {78,85,38,58,29,28,78,58},
                {20,38,23,26,29},
                {58,28,32,45,36,45,52,32,58,28,42,38,328,28,56,42,28},
                {38,42,29,26,29,23,32,23},
                {38,42,29,45,38,18},
                {28,32,38,20,28,32,32,28},
                {28,12,20,8,28,28},
                {28,28,28,12,58,5,128}};
    }


