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
 * Created by Apc on 2016/8/14.
 */
class SearchResultAdapter extends RecyclerView.Adapter{  //搜索结果呈现的适配器
    SearchContentActivity searchResult;

    private class ViewHold extends RecyclerView.ViewHolder {
        ViewHold(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_recyclerview, parent, false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final DishDatabase dishSearchDatabase = SearchContentActivity.map_search.get(""+position);
        holder.itemView.findViewById(R.id.image_dish).setBackgroundResource(dishSearchDatabase.dish_pic);
        ((TextView) holder.itemView.findViewById(R.id.rv1_txt1)).setText(dishSearchDatabase.dish_name1);
        ((TextView) holder.itemView.findViewById(R.id.rv1_txt2)).setText(dishSearchDatabase.main_material1);
        ((TextView) holder.itemView.findViewById(R.id.rv1_txt3)).setText(""+dishSearchDatabase.price1);

        Button orderBtn = (Button) holder.itemView.findViewById(R.id.order);
        orderBtn.setOnClickListener(new View.OnClickListener() {  // 设置searchResult页面的“点菜”监听器
            @Override
            public void onClick(View v) {  //总点单 的List 加载
                Intent intent = new Intent(searchResult,CheckOutActivity.class);
                searchResult.startActivity(intent);
                boolean find = false;
                for (Order order : Order.ordersList) {
                    if (dishSearchDatabase.dish_name1.equals(order.dishName)) {
                        order.dishQuantity ++;
                        CheckOutActivity.reset();
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    Order.ordersList.add(new Order(dishSearchDatabase.dish_name1,dishSearchDatabase.price1, 1 ));
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return SearchContentActivity.map_search.size();
    }
}
