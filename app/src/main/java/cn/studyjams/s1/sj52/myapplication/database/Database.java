package cn.studyjams.s1.sj52.myapplication.database;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apc on 2016/7/22.
 */
public class Database {
   public static String string[] = {"特色菜","特价菜","热菜.炒菜","冷菜","营养汤羹","甜点.冷饮","特色主食","酒水.饮料" };
   public static ArrayList arrayList = new ArrayList<String>();

   Uri dishPics1[];         /** 菜式图片*/
   String dishName1[] = {"辣响划水","蜜汁东坡肉","铁板芋头","日式鳗鱼饭","素香饼","豌豆堡垒","蟹黄银鱼","铁板蜜牛肉"};    /** 菜名*/
   String main_material1[] = {"鱼尾，味中辣","东坡肉、海带、椰菜，味偏甜","芋头，味咸甜","鳗鱼、蛋卷，味香甜","韭菜、鸡蛋、木耳，口味咸","豌豆，味鲜咸","蟹黄、银鱼、蛋，味咸鲜","牛肉、甜椒，味咸甜"}; /** 主要食材*/
   String price1[] = {"78","85","38","58","29","28","78","58"};            /** 价格*/

   Uri dishPics2[];         /** 菜式图片*/
   String dishName2[] = {"肉夹馍","叉烧芦篙","香肉芹菜","三鲜回锅肉","辣炒鸡丁"};    /** 菜名*/
   String main_material2[] = {"猪肉、馒头，味中甜","叉烧肉、芦篙，味偏甜","芹菜、猪肉，味咸","回锅肉、多种素菜，味咸","鸡丁、韭篙，味中辣"}; /** 主要食材*/
   String price2[] = {"20","38","23","26","29"};            /** 价格*/

   Uri dishPics3[];         /** 菜式图片*/
   String dishName3[] = {"蜜汁东坡肉","混搭三鲜","荷塘月色","鲜色基围虾","茄瓜塞肉","香炸肋骨","香芒鱼片","香丝猴头菇","香煎牛肉粒","多味老豆腐","清炒腰花","鲜贝菌菇","花式澳洲龙虾","彩椒蘑菇",
                         "松子小鱿鱼","鸡骨丁小盏","酸甜山药"};                 /** 菜名*/
   String main_material3[] = {"东坡肉，味甜","削肉、香菇、菠菜，味咸","荷兰豆、莲藕，味咸","虾、蔬菜，味鲜咸","苦瓜、肉糜、茄子，味咸","肋骨，味鲜咸","鱼片、芒果，味咸鲜","猴头菇、芦篙，味咸,",
                              "大块牛肉粒，味咸","老豆腐、肉末，味甜酸","腰花、百合，味咸","鲜贝、菌菇，味鲜咸","澳洲龙虾、虾球，味鲜咸","彩椒、蘑菇，味鲜咸","小鱿鱼、松子，味甜鲜",
                              "鸡肉丁、茭白、鲜菇，味鲜","山药，味酸甜"};      /** 主要食材*/
   String price3[] = {"58","28","32","45","36","45","52","32","58","28","42","38","328","28","56","42","28"};            /** 价格*/

   Uri dishPics4[];         /** 菜式图片*/
   String dishName4[] = {"油辣鸡","酱肉肘子","冰心萝卜&枣","桂花糯米藕","冰爽芥兰","辣菠花生","柠檬水晶肉","皮蛋拌豆腐"};      /** 菜名*/
   String main_material4[] = {"鸡肉，味重辣","猪肉肘子、萝卜条，味咸","萝卜、枣、冰糖，味甜","糯米、藕，味香甜","芥兰，味咸爽","菠菜、花生，味中辣","水晶肉、柠檬，味咸酸","皮蛋、豆腐，味鲜咸"}; /** 主要食材*/
   String price4[] = {"38","42","29","26","29","23","32","23"};               /** 价格*/

   Uri dishPics5[];         /** 菜式图片*/
   String dishName5[] = {"乾坤.玉米羹","咸肉萝卜汤","多味干丝羹","三鲜咸肉汤","清香鲫鱼汤","红枣莲子羹"};        /** 菜名*/
   String main_material5[] = {"玉米羹、菜末，味微甜","咸肉、萝卜，味偏甜","蛋羹、笋丝，味咸","咸肉、笋、山药，味鲜咸","鲫鱼、萝卜，口味咸","红枣、莲子，味甜"};       /** 主要食材*/
   String price5[] = {"38","42","29","45","38","18"};            /** 价格*/

   Uri dishPics6[];         /** 菜式图片*/
   String dishName6[] = {"抹茶蛋糕","炸香蕉","紫薯山药糕","豆沙春卷","冰糖芋头","菠萝一口酥","香草冰激凌","芒果西米露"};       /** 菜名*/
   String main_material6[] = {"抹茶味蛋糕","香蕉","紫薯、山药","红豆馅春卷","芋头仔","菠萝","冰激凌、草莓","芒果、西米露"};    /** 主要食材*/
   String price6[] = {"28","32","38","20","28","32","32","28"};            /** 价格*/

   Uri dishPics7[];         /** 菜式图片*/
   String dishName7[] = {"甜味八宝饭","夹心奶味馒头","香煎小肉包","香葱汤面","双味饺子","日式牛肉面"};        /** 菜名*/
   String main_material7[] = {"松子、糯米饭","玉米粉、牛奶","猪肉糜","光面","香菇、肉糜","牛肉块、日式粗面"};         /** 主要食材*/
   String price7[] = {"28","12","20","8","28","28"};            /** 价格*/

   Uri dishPics8[];         /** 菜式图片*/
   String dishName8[] = {"西瓜汁","芒果汁","鲜橙汁","啤酒","玉米汁","可乐","红酒"};                         /** 菜名*/
   String main_material8[] = {"新鲜西瓜","鲜芒果","鲜柳橙","纯生牌","鲜熟玉米","百事可乐牌","张裕牌"};     /** 主要食材*/
   String price8[] = {"28","28","28","12","58","5","128"};            /** 价格*/


   String specials[] = {"specials1","specials2","specials3","specials4", "specials5","specials6","specials7","specials8"};
   String offer_today[] = {"offer_today1","offer_today2","offer_today3","offer_today4","offer_today5","offer_today6","offer_today7","offer_today8"};
   String hot_dish[] = {"hot_dish1","hot_dish2","hot_dish3","hot_dish4","hot_dish5","hot_dish6","hot_dish7","hot_dish8"};
   String cold_dish[] = {"cold_dish1","cold_dish2","cold_dish3","cold_dish4","cold_dish5","cold_dish6","cold_dish7","cold_dish8"};
   String soup[ ] = {"soup1","soup2","soup3","soup4","soup5","soup6","soup7","soup8"};
   String dessert[] = {"dessert1","dessert2","dessert3","dessert4","dessert5","dessert6","dessert7","dessert8"};
   String main_staple[] ={"main_staple1","main_staple2","main_staple3","main_staple4","main_staple5","main_staple6","main_staple7","main_staple8"};

}
