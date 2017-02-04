package cn.studyjams.s1.sj52.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class TabbedMenuActivity extends AppCompatActivity {  //“菜单”界面

    RecyclerView categoryRecyclerView;
    RecyclerView itemsRecyclerView;
    CategoryAdapter categoryAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_menu);

        /** setting & initialized 2 recyclerViews.
         */
        categoryRecyclerView = (RecyclerView) findViewById(R.id.rv);
        itemsRecyclerView = (RecyclerView) findViewById(R.id.rv1);

        assert categoryRecyclerView != null;
        categoryRecyclerView.setHasFixedSize(true);
        categoryAdapter = new CategoryAdapter(MainActivity.index);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryRecyclerView.smoothScrollToPosition(MainActivity.index);//实现滑动到被点击的item上。

        itemsRecyclerView.setHasFixedSize(true);
        ItemAdapter itemAdapter = new ItemAdapter();
        categoryAdapter.bottomAdapter = itemAdapter;
        itemsRecyclerView.setAdapter(itemAdapter);
        itemAdapter.tabbedMenuActivity =this;

    }

}
