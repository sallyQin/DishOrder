package cn.studyjams.s1.sj52.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import cn.studyjams.s1.sj52.myapplication.database.VipCardDatabase;

public class VipCardCheckActivity extends AppCompatActivity {  //Vip卡查询界面

    private TextView tvHideA;
    private TextView tvHideB;
    private TextView tvHideC;
    private TextView tvHideD;
    private ImageView ivNumA;
    private ImageView ivNumB;
    private ImageView ivNumC;
    private ImageView ivNumD;
    LayoutInflater inflater;
    View view;
    Toast toast;
    Button btnCheck;
    EditText etCheck;
    LinearLayout verification;
    String numStrTmp = "";
    String numStr = "";
    private int[] numArray = new int[4];
    private int[] colorArray = new int[7];
    EditText vipCard_num_ed;
    EditText code_ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_card_check);
        vipCard_num_ed = (EditText) findViewById(R.id.vipCard_num);
        code_ed = (EditText) findViewById(R.id.code);
        tvHideA = (TextView) findViewById(R.id.tvHideA);
        tvHideB = (TextView) findViewById(R.id.tvHideB);
        tvHideC = (TextView) findViewById(R.id.tvHideC);
        tvHideD = (TextView) findViewById(R.id.tvHideD);
        ivNumA = (ImageView) findViewById(R.id.ivNumA);
        ivNumB = (ImageView) findViewById(R.id.ivNumB);
        ivNumC = (ImageView) findViewById(R.id.ivNumC);
        ivNumD = (ImageView) findViewById(R.id.ivNumD);
        etCheck = (EditText) findViewById(R.id.verification_Check);  //用户输入的验证码
        btnCheck = (Button) findViewById(R.id.btnCheck);
        verification = (LinearLayout) findViewById(R.id.verification_code);  //系统随机给出的 验证码

        setNum(); //初始验证码

        /** 设置“验证码”的 监听器 **/
        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNum();
            }
        });

        /** 设置“查询”按钮的 监听器 **/
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String verification_Check_ed = etCheck.getText().toString(); //记录系统随机给出的 验证码
                String vipCard_num_edTxt = vipCard_num_ed.getText().toString();
                String code_edTxt = code_ed.getText().toString();

                if (verification_Check_ed.trim().length() > 0) {
                   String temp =  numStr;
                    if (numStr.equals(verification_Check_ed)) { //下列的Toast，都是自定义的字体和背景色。
                        if(!TextUtils.isEmpty(vipCard_num_edTxt) && !TextUtils.isEmpty(code_edTxt)){

                            boolean find = false;
                            for(int i = 1;i <= VipCardDatabase.getDemoVIPNum().size();i++){
                                if(VipCardDatabase.getDemoVIPNum().get(i).vipCard_num.equalsIgnoreCase(vipCard_num_edTxt) && VipCardDatabase.getDemoVIPNum().get(i).code.equals(code_edTxt)) {
                                    inflater = LayoutInflater.from(getApplicationContext());
                                    view = inflater.inflate(R.layout.my_toast,(ViewGroup) findViewById(R.id.vip_pager),false);
                                    toast = Toast.makeText(VipCardCheckActivity.this,"登录成功！",Toast.LENGTH_SHORT);
                                    toast.setView(view);
                                    toast.show();
                                    String toastBalance_str = "您的VIP卡余额为：" + VipCardDatabase.getDemoVIPNum().get(i).balance;
                                    Toast.makeText(VipCardCheckActivity.this,toastBalance_str,Toast.LENGTH_LONG).show();
                                    find = true;
                                    break;
                                }
                            }
                            if (!find) {
                                inflater = LayoutInflater.from(getApplicationContext());
                                view = inflater.inflate(R.layout.my_toast_1,(ViewGroup) findViewById(R.id.vip_pager),false);
                                toast = Toast.makeText(VipCardCheckActivity.this,"验证码正确！但卡号或密码不正确！",Toast.LENGTH_LONG);
                                toast.setView(view);
                                toast.show();
                            }
                        }else{
                            inflater = LayoutInflater.from(getApplicationContext());
                            view = inflater.inflate(R.layout.my_toast_3,(ViewGroup) findViewById(R.id.vip_pager),false);
                            toast = Toast.makeText(VipCardCheckActivity.this,"请输入卡号或密码！",Toast.LENGTH_LONG);
                            toast.setView(view);
                            toast.show();
                        }
                    } else {
                        if(!TextUtils.isEmpty(vipCard_num_edTxt) && !TextUtils.isEmpty(code_edTxt)){

                            boolean find = false;
                            for(int i = 1;i <= VipCardDatabase.getDemoVIPNum().size();i++){
                                if(VipCardDatabase.getDemoVIPNum().get(i).vipCard_num.equalsIgnoreCase(vipCard_num_edTxt) && VipCardDatabase.getDemoVIPNum().get(i).code.equals(code_edTxt)) {
                                    inflater = LayoutInflater.from(getApplicationContext());
                                    view = inflater.inflate(R.layout.my_toast_5,(ViewGroup) findViewById(R.id.vip_pager),false);
                                    toast = Toast.makeText(VipCardCheckActivity.this,"您输入验证码不正确，请重新输入！",Toast.LENGTH_LONG);
                                    toast.setView(view);
                                    toast.show();
                                    find = true;
                                    break;
                                }
                            }

                            if (!find) {
                                inflater = LayoutInflater.from(getApplicationContext());
                                view = inflater.inflate(R.layout.my_toast_2,(ViewGroup) findViewById(R.id.vip_pager),false);
                                toast = Toast.makeText(VipCardCheckActivity.this,"您输入的卡号、密码或验证码不正确，请重新输入！",Toast.LENGTH_LONG);
                                toast.setView(view);
                                toast.show();
                            }
                        }else{
                            inflater = LayoutInflater.from(getApplicationContext());
                            view = inflater.inflate(R.layout.my_toast_4,(ViewGroup) findViewById(R.id.vip_pager),false);
                            toast = Toast.makeText(VipCardCheckActivity.this,"请输入上述几项后，再点击-查询！",Toast.LENGTH_LONG);
                            toast.setView(view);
                            toast.show();
                        }
                    }
                } else {
                    inflater = LayoutInflater.from(getApplicationContext());
                    view = inflater.inflate(R.layout.my_toast_4,(ViewGroup) findViewById(R.id.vip_pager),false);
                    toast = Toast.makeText(VipCardCheckActivity.this,"请输入上述几项后，再点击-查询！",Toast.LENGTH_LONG);
                    toast.setView(view);
                    toast.show();
                }
            }
        });}


    public void initNum() {  //设置任意“数字”（验证码）
        numStr = "";
        numStrTmp = "";
        for (int i = 0; i < numArray.length; i++) {
            int numIntTmp = new Random().nextInt(10);//随机获取0-9范围内的一个数
            numStrTmp = String.valueOf(numIntTmp);
            numStr = numStr + numStrTmp;
            numArray[i] = numIntTmp;
        }
    }


    public int randomColor() {//设置任意“颜色”（验证码）
        colorArray[0] = 0xFF000000; // BLACK
        colorArray[1] = 0xFFFF00FF; // MAGENTA
        colorArray[2] = 0xFFFF0000; // RED
        colorArray[3] = 0xFF00FF00; // GREEN
        colorArray[4] = 0xFF0000FF; // BLUE
        colorArray[5] = 0xFF00FFFF; // CYAN
        colorArray[6] = 0xFFFF7F00; //ORANGE

        int randomColorId = new Random().nextInt(7);
        return colorArray[randomColorId];
    }

    /**
     * 设置随机的验证码
     * */
    public void setNum() {

        initNum();
        tvHideA.setText("" + numArray[0]);
        tvHideA.setTextColor(randomColor());
        tvHideB.setText("" + numArray[1]);
        tvHideB.setTextColor(randomColor());
        tvHideC.setText("" + numArray[2]);
        tvHideC.setTextColor(randomColor());
        tvHideD.setText("" + numArray[3]);
        tvHideD.setTextColor(randomColor());

        // Num 1
        Bitmap bmNumA = Bitmap.createBitmap(getBitmapFromView(tvHideA,60, 92), 0, 0, 60,92);
        ivNumA.setImageBitmap(bmNumA);

        // Num 2
        Bitmap bmNumB = Bitmap.createBitmap(getBitmapFromView(tvHideB,60, 92), 0, 0, 60,92);
        ivNumB.setImageBitmap(bmNumB);

        // Num 3
        Bitmap bmNumC = Bitmap.createBitmap(getBitmapFromView(tvHideC,60, 92), 0, 0, 60,92);
        ivNumC.setImageBitmap(bmNumC);

        // Num 4
        Bitmap bmNumD = Bitmap.createBitmap(getBitmapFromView(tvHideD,60, 92), 0, 0, 60,92);
        ivNumD.setImageBitmap(bmNumD);
    }


    public static Bitmap getBitmapFromView(View view, int width, int height) {
        int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        view.measure(widthSpec, heightSpec);
        view.layout(0, 0, width, height);
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        return bitmap;
    }
}