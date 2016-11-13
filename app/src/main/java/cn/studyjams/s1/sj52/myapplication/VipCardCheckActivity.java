package cn.studyjams.s1.sj52.myapplication;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class VipCardCheckActivity extends AppCompatActivity {

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
    View view1;
    Toast toast1;
    Toast toast;
    Button btnCheck;
    EditText etCheck;
    LinearLayout verification;
    String numStrTmp = "";
    String numStr = "";
    private int[] numArray = new int[4];
    private int[] colorArray = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vip_card_check);

        tvHideA = (TextView) findViewById(R.id.tvHideA);
        tvHideB = (TextView) findViewById(R.id.tvHideB);
        tvHideC = (TextView) findViewById(R.id.tvHideC);
        tvHideD = (TextView) findViewById(R.id.tvHideD);
        ivNumA = (ImageView) findViewById(R.id.ivNumA);
        ivNumB = (ImageView) findViewById(R.id.ivNumB);
        ivNumC = (ImageView) findViewById(R.id.ivNumC);
        ivNumD = (ImageView) findViewById(R.id.ivNumD);
        etCheck = (EditText) findViewById(R.id.etCheck);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        verification = (LinearLayout) findViewById(R.id.verification_code);


        setNum();

        verification.setOnClickListener(new View.OnClickListener() { //设置“验证码”的 监听器
            @Override
            public void onClick(View v) {
                setNum();
            }
        });

        btnCheck.setOnClickListener(new View.OnClickListener() {  //设置“查询”按钮的 监听器
            @Override
            public void onClick(View v) {

                if (etCheck.getText().toString().trim().length() > 0) {

                    if (numStr.equals(etCheck.getText().toString())) {//自定义toast字体。
                        inflater = LayoutInflater
                                .from(getApplicationContext());
                        view = inflater.inflate(R.layout.mytoast,(ViewGroup) findViewById(R.id.vip_pager),false);
                        toast = Toast.makeText(VipCardCheckActivity.this,"验证码输入正确！",Toast.LENGTH_LONG);
                        toast.setView(view);
                        toast.show();

                    } else {//自定义toast字体
                        view1 = inflater.inflate(R.layout.mytoast_1,(ViewGroup) findViewById(R.id.vip_pager),false);
                        toast1 = Toast.makeText(VipCardCheckActivity.this,"验证码输入有误，请重新输入！",Toast.LENGTH_LONG);
                        toast1.setView(view1);
                        toast1.show();

                    }
                } else {
                    Toast.makeText(VipCardCheckActivity.this,"请输入上述几项后，再点击-查询！",Toast.LENGTH_LONG).show();
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

        int randomColorId = new Random().nextInt(6);
        return colorArray[randomColorId];
    }

    /**
     * To set verification code
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
        Bitmap bmNumA = Bitmap.createBitmap(getBitmapFromView(tvHideA, 30, 80), 0, 0, 30, 80);
        ivNumA.setImageBitmap(bmNumA);

        // Num 2
        Bitmap bmNumB = Bitmap.createBitmap(getBitmapFromView(tvHideB, 30, 80), 0, 0, 30,80);
        ivNumB.setImageBitmap(bmNumB);

        // Num 3
        Bitmap bmNumC = Bitmap.createBitmap(getBitmapFromView(tvHideC, 30, 80), 0, 0, 30, 80);
        ivNumC.setImageBitmap(bmNumC);

        // Num 4
        Bitmap bmNumD = Bitmap.createBitmap(getBitmapFromView(tvHideD, 30, 80), 0, 0, 30, 80);
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