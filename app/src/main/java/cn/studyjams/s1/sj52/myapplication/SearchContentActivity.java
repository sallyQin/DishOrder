package cn.studyjams.s1.sj52.myapplication;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.studyjams.s1.sj52.myapplication.database.Database;
import cn.studyjams.s1.sj52.myapplication.database.DishDatabase;

public class SearchContentActivity extends AppCompatActivity {

    ImageView return_home;
    EditText search_context;
    ImageView cancel_action;
    ImageView search_go;
    public static String StrSearch_content;
    public static int search_num = 0;
    RecyclerView search_result_recyclerV;
    public static Map<String,DishDatabase> map_search = new HashMap<>();

    TagFlowLayout  mFlowLayout;
    private TagAdapter<String> mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_content);

        return_home = (ImageView) findViewById(R.id.return_home);
        search_context = (EditText) findViewById(R.id.search_context);
        cancel_action = (ImageView) findViewById(R.id.cancel_action);
        search_go= (ImageView) findViewById(R.id.search_go);

        return_home.setOnClickListener(new View.OnClickListener() { //设置“返回主界面”的监听器
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchContentActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        search_context.setOnClickListener(new View.OnClickListener() { //设置 “编辑框”监听器
            @Override
            public void onClick(View v) {
                cancel_action.setVisibility(View.VISIBLE);
                cancel_action.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(search_context.getText() != null) {
                            search_context.setText("");
                            cancel_action.setVisibility(View.INVISIBLE);

                        }
                    }
                });
            }
        });




        search_go.setOnClickListener(new View.OnClickListener() {  //搜索"GO"事件监听


            @Override
            public void onClick(View v) {

                map_search.clear();
                search_num = 0;

                if(search_context.getText() != null){
                    StrSearch_content = search_context.getText().toString().trim();
                    StrSearch_content = StrSearch_content.replaceAll("[\\p{Punct}\\p{Space}\\p{XDigit}\\p{Lower}\\p{Upper}]+", "");//去除字符串中的数字、标点、英文字母、空格等。
                    if(!StrSearch_content.isEmpty()){
                        if(Database.searchHistoryList.size()>= 1){
                            for (Iterator<String> iterator = Database.searchHistoryList.iterator(); iterator.hasNext(); ) {
                                if(StrSearch_content.equals(iterator.next())){
                                    iterator.remove();
                                    break;
                                }                            }
                            Database.searchHistoryList.add(0, StrSearch_content);
                            mAdapter.notifyDataChanged();//通知历史搜索框视图更新}
                        }else{
                            Database.searchHistoryList.add(0, StrSearch_content);
                            mAdapter.notifyDataChanged();//通知历史搜索框视图更新
                        }



                        for (int i = 0;i<DishDatabase.dish_name.length;i++){
                            for (int j = 0;j<DishDatabase.dish_name[i].length;j++){
                                if((DishDatabase.dish_name[i][j].contains(StrSearch_content))){
                                    DishDatabase.dishDatabase_search = DishDatabase.getMenuData().get("["+i+"]["+j+"]");
                                    map_search.put(""+search_num,DishDatabase.dishDatabase_search);
                                    search_num +=1;
                                }
                            }
                        }


                    }
                    else if(map_search.isEmpty()) {
                        Toast.makeText(SearchContentActivity.this,"没有找到该菜名，请重新搜索！",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SearchContentActivity.this,"请不要输入非法字符，请重新输入中文！",Toast.LENGTH_SHORT).show();
                    }


                    search_result_recyclerV = (RecyclerView) findViewById(R.id.search_result);
                    assert search_result_recyclerV != null;
                    search_result_recyclerV.setHasFixedSize(true);
                    final SearchResultAdapter searchResultAdapter = new SearchResultAdapter();
                    search_result_recyclerV.setAdapter(searchResultAdapter);
                    searchResultAdapter.searchResult = SearchContentActivity.this;

                }else  { Toast.makeText(SearchContentActivity.this,"请输入要搜索的菜名！",Toast.LENGTH_SHORT).show();

                }
               }
        });

        mFlowLayout = (TagFlowLayout) findViewById(R.id.flowlayout);

        mAdapter = new TagAdapter<String>(Database.searchHistoryList) { //搜索历史的框的显示
            @Override
            public View getView(FlowLayout parent, int position, String str) {
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.history_result_recyclerview, parent, false);
                tv.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG ); //下划线
                tv.getPaint().setAntiAlias(true);//抗锯齿
                tv.setText(str);
                return tv;
            }
        };
        mFlowLayout.setAdapter(mAdapter);


    }
}
