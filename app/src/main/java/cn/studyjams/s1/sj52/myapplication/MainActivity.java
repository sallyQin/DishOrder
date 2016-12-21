package cn.studyjams.s1.sj52.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;



public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    ViewPager viewPager;
    View view1, view2, view3;
    ImageView iv;
    LinearLayout viewPager_dot;
    LinearLayout VipBalance;
    private Timer timer;
    private int page = 0;
    static int index;
    TextView searchText;
    public static final int SEARCHCONTENT_REQUESTCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_main);

        /**
         * gif animated swing
         * */
        iv=(ImageView)findViewById(R.id.swing);
        TranslateAnimation alphaAnimation = new TranslateAnimation(-6, 6,6 , -6);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        iv = (ImageView) findViewById(R.id.swing);
        if (iv != null) {
            iv.setAnimation(alphaAnimation);
        }
        alphaAnimation.start();


        /**
         * to add viewPager
         * */
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        view1 = getLayoutInflater().inflate(R.layout.viewpager1, null);
        view2 = getLayoutInflater().inflate(R.layout.viewpager2, null);
        view3 = getLayoutInflater().inflate(R.layout.viewpager3, null);

        // 将要分页显示的View,装入数组中
        final List<View> pager = new ArrayList(3);
        pager.add(view1);
        pager.add(view2);
        pager.add(view3);

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override           //viewpager中的组件数量
            public int getCount() {

                return pager.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override  //每次滑动的时候生成的组件
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(pager.get(position));
                return pager.get(position);
            }

            @Override  //滑动切换的时候将当前的view移除

            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(pager.get(position));
            }

        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);
        //增加圆点到viewPager中。
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), android.R.drawable.radiobutton_off_background);

        for (int i = 0; i < pager.size(); i++) {
            Button bt = new Button(this);
            bt.setLayoutParams(new ViewGroup.LayoutParams(39, 39));      // （设置子view在父view的高宽）
            bt.setBackgroundResource(android.R.drawable.radiobutton_off_background);
            viewPager_dot = (LinearLayout) findViewById(R.id.viewPager_dot);
            if (viewPager_dot != null) {
                viewPager_dot.addView(bt);
            }

            onPageSelected(0);   //初始时，首图底部圆点为深灰

        }

        pageSwitcher(3);


        /**
         * set clickListener and jump to check VIP card's balance
         * */
        VipBalance = (LinearLayout) findViewById(R.id.line);
        VipBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VipCardCheckActivity.class);
                startActivity(intent);
            }
        });


        /**
         *  to search the dishes or keywords
        * */

        searchText = (TextView) findViewById(R.id.search);
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchContentActivity.class);
                startActivity(intent);
            }
        });
}


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < viewPager_dot.getChildCount(); i++) {
            Button b = (Button) viewPager_dot.getChildAt(i);
            if (i == position) {
                b.setBackgroundResource(android.R.drawable.radiobutton_on_background);
            } else {
                b.setBackgroundResource(android.R.drawable.radiobutton_off_background);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * pageSwitcher（）设定计时器的间隙时间。
     * */
    public void pageSwitcher(int seconds) {
        timer = new Timer(); // 在守护线程中，创建开启一个计时器
        timer.scheduleAtFixedRate(new RemindTask(),1000, seconds * 1000); // 设定循环的固定计时间隙（毫秒）
    }


    // this is an inner class...
    class RemindTask extends TimerTask {


        @Override
        public void run() {

            // As the TimerTask run on a separate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {//把更新ui的代码创建在Runnable中,然后在需要更新ui时,把这个Runnable对象传给Activity
                public void run() {
                    /**
                     * 设置viewpager页面无限循环
                     * */
                    if (page> viewPager.getChildCount()-1) { // In my case the number of pages are 3,so can change as---if (page>2)
                        page = 0;

                    } else { viewPager.setCurrentItem(page++,true);//setCurrentItem(int index)方法主要用来制定初始化的页面。例如加入3个页面通过setCurrentItem(0)制定第一个页面为当前页面
                    }
                }
            });

        }
    }



    public void specialsClick(View view) {

        Intent intent = new Intent(this,TabbedMenuActivity.class);
        startActivity(intent);
        switch ( view.getId()){
            case R.id.specials:
                index = 0;
                break;
            case R.id.offer_today:
                index = 1;
                break;
            case R.id.hot_dish:
                index = 2;
                break;
            case R.id.cold_dish:
                index = 3;
                break;
            case R.id.soup:
                index = 4;
                break;
            case R.id.dessert:
                index = 5;
                break;
            case R.id.staple_food:
                index = 6;
                break;
            case R.id.drinks:
                index = 7;
                break;
        }
    }




}



