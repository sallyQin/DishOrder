package cn.studyjams.s1.sj52.myapplication;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.studyjams.s1.sj52.myapplication.database.Order;


public class CheckOutActivity extends AppCompatActivity { //结账界面
    CheckoutAdapter CheckoutAdapter; //结账界面列表的adapter
    Button confirm_button;  //确认下单按钮
    static TextView total_sum_txt; //总消费金额数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        RecyclerView checkoutRecycler = (RecyclerView) findViewById(R.id.checkout_recycler);
        assert checkoutRecycler != null;
        CheckoutAdapter = new CheckoutAdapter();
        checkoutRecycler.setAdapter(CheckoutAdapter);

        final LinearLayout checkoutLayout = (LinearLayout) findViewById(R.id.checkout_layout);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        total_sum_txt = (TextView) findViewById(R.id.total_sum);
/**
 * 设置“确认菜单”按钮的监听器&设置弹出的dialog
 * */
        confirm_button = (Button) findViewById(R.id.confirm_order);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setTitle("提示");
                builder.setMessage("是否确认所选菜品?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Snackbar snackbar = Snackbar.make(checkoutLayout,"您 所 点 的 菜 品 已 下 单！",Snackbar.LENGTH_LONG);
                        snackbar.getView().setBackgroundColor(0xff7D9EC0);
                        snackbar.show();

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        reset();
    }


    public static void reset(){  //j结账总金额--重置
        total_sum_txt.setText(""+ Order.getOrdersList());
        Order.total = 0;
    }

}
