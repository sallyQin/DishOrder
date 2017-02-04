package cn.studyjams.s1.sj52.myapplication;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.studyjams.s1.sj52.myapplication.database.Database;

/**
 * Created by Apc on 2016/7/22.
 */
public class CategoryAdapter extends RecyclerView.Adapter {  //菜品种类选择的适配器

    public static int selected;

    public ItemAdapter bottomAdapter;



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    CategoryAdapter(int firstValue) {
        selected = firstValue;
    }


    @Override    // Create new views (invoked by the layout manager)
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view,set the view's size, margins, padding and layout parameters

        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_recyclerview, null);
        ViewHolder vh = new ViewHolder(item);
        return vh;
    }


    @Override   // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (position == selected) {
            holder.itemView.findViewById(R.id.rvtxt).setBackgroundColor(Color.parseColor("#FF3030"));
            ((TextView) holder.itemView.findViewById(R.id.rvtxt)).setTextColor(Color.parseColor("#FFFFFF"));

        } else {
            holder.itemView.findViewById(R.id.rvtxt).setBackgroundColor(Color.parseColor("#FFFFFF"));
            ((TextView) holder.itemView.findViewById(R.id.rvtxt)).setTextColor(Color.parseColor("#FF3030"));
        }
        // - get element from your data at this position
        // - replace the contents of the view with that element
        ((TextView) holder.itemView.findViewById(R.id.rvtxt)).setText(Database.string[position]);



        /**
         * 设置itemView的监听事件。
         * ***/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected != position){
                    selected = position;
                    notifyDataSetChanged();
                    bottomAdapter.notifyDataSetChanged();
                }


            }
        });


   }

    @Override
    public int getItemCount() {
        return Database.string.length;
    }

}
