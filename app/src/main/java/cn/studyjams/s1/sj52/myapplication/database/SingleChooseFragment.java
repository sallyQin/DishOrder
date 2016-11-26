package cn.studyjams.s1.sj52.myapplication.database;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Set;

import cn.studyjams.s1.sj52.myapplication.R;

/**
 * Created by 1 on 2016/11/23.
 */

public class SingleChooseFragment extends Fragment {

        private String[] mVals = new String[]
                {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                        "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                        "Android", "Weclome Hello", "Button Text", "TextView"};

        private TagFlowLayout mFlowLayout;

        @Nullable
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState)
        {
            return inflater.inflate(R.layout.fragment_single_choose, container, false);
        }

        @Override
        public void onViewCreated (View view, @Nullable Bundle savedInstanceState)
        {
            final LayoutInflater mInflater = LayoutInflater.from(getActivity());
            mFlowLayout = (TagFlowLayout) view.findViewById(R.id.flowlayout);
            //mFlowLayout.setMaxSelectCount(3);
            mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {

                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) mInflater.inflate(R.layout.history_result_recyclerview,
                            mFlowLayout, false);
                    tv.setText(s);
                    return tv;
                }
            });

            mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    Toast.makeText(getActivity(), mVals[position], Toast.LENGTH_SHORT).show();
                    //view.setVisibility(View.GONE);
                    return true;
                }
            });


            mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {

                @Override
                public void onSelected(Set<Integer> selectPosSet) {
                    getActivity().setTitle("choose:" + selectPosSet.toString());
                }
            });
        }

    }
