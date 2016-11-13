package cn.studyjams.s1.sj52.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.studyjams.s1.sj52.myapplication.database.DishDatabase;
import cn.studyjams.s1.sj52.myapplication.database.Order;

/**
 * Created by Apc on 2016/7/24.
 */
public class ItemAdapter extends RecyclerView.Adapter {
    public TabbedMenuActivity tabbedMenuActivity;


    public  class ViewHold extends RecyclerView.ViewHolder{

        public ViewHold(View itemView) {
            super(itemView);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_1, parent, false);
        ViewHold viewhHold = new ViewHold(view);
        return viewhHold;
    }


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        String key = "["+ CategoryAdapter.selected+"]"+"["+position+"]";
        final DishDatabase dishDatabase = DishDatabase.getMenuData().get(key);
        holder.itemView.findViewById(R.id.image_dish).setBackgroundResource(dishDatabase.dish_pic);
        ((TextView) holder.itemView.findViewById(R.id.rv1_txt1)).setText(dishDatabase.dish_name1);
        ((TextView) holder.itemView.findViewById(R.id.rv1_txt2)).setText(dishDatabase.main_material1);
        ((TextView) holder.itemView.findViewById(R.id.rv1_txt3)).setText(""+dishDatabase.price1);
        Button orderBtn = (Button) holder.itemView.findViewById(R.id.order);
        orderBtn.setOnClickListener(new View.OnClickListener() {// 设置“点菜”监听器
            @Override
            public void onClick(View v) {
                //总点单 的List 加载

                boolean find = false;
                for (Order order : Order.ordersList) {
                    if (dishDatabase.dish_name1.equals(order.dishName)) {
                        order.dishQuantity ++;
                        find = true;
                        CheckOutActivity.reset();
                        break;
                    }
                }
                if (!find) {
                    Order.ordersList.add(new Order(dishDatabase.dish_name1,dishDatabase.price1, 1 ));
                }

                Intent intent = new Intent(tabbedMenuActivity,CheckOutActivity.class);
                tabbedMenuActivity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return DishDatabase.dish_name[CategoryAdapter.selected].length;
    }
}
