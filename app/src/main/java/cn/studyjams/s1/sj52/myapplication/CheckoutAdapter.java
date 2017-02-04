package cn.studyjams.s1.sj52.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import org.w3c.dom.Text;

import java.util.List;

import cn.studyjams.s1.sj52.myapplication.database.Order;

/**
 * Created by Apc on 2016/8/7.
 */
public class CheckoutAdapter extends RecyclerView.Adapter {  //结账界面列表的适配器
    SimpleDraweeView increBtn; //增加数量
    SimpleDraweeView decreBtn;//减少数量
    TextView quantity;
    TextView dishName;
    TextView dishPrice;
    TextView dishNum;
    TextView dishSum;
    static int dishesSum;  //合计：金额数


    public class CheckoutViewHold extends RecyclerView.ViewHolder{

        public CheckoutViewHold(View itemView) {
            super(itemView);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_recyclerview,parent,false);
        return new CheckoutViewHold(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        increBtn = (SimpleDraweeView) holder.itemView.findViewById(R.id.increase);
        decreBtn = (SimpleDraweeView) holder.itemView.findViewById(R.id.decrease);
        quantity = ((TextView) holder.itemView.findViewById(R.id.checkout_quantity));
        dishName = (TextView) holder.itemView.findViewById(R.id.checkout_dishName);
        dishPrice = (TextView) holder.itemView.findViewById(R.id.checkout_price);
        dishNum = (TextView) holder.itemView.findViewById(R.id.checkout_Num);
        dishSum = (TextView) holder.itemView.findViewById(R.id.checkout_sum);

        final Order order = Order.ordersList.get(position);

        dishNum.setText(""+(position + 1));
        dishName.setText(order.dishName);
        dishPrice.setText(""+order.dishPrice);
        quantity.setText(""+order.dishQuantity);

        dishesSum = order.dishPrice*order.dishQuantity;
        dishSum.setText(""+dishesSum);


        increBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order.dishQuantity += 1;
                CheckOutActivity.reset();
                notifyDataSetChanged();

            }
        });

        decreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (order.dishQuantity>= 2) {
                    order.dishQuantity -= 1;
                    CheckOutActivity.reset();
                    notifyDataSetChanged();

                } else if (order.dishQuantity == 1) {
                  Order.ordersList.remove(Order.ordersList.get(position));
                    CheckOutActivity.reset();
                    notifyDataSetChanged();

                }
            }  });

   }

    @Override
    public int getItemCount() {
        return Order.ordersList.size();
    }


}
