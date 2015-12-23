package com.example.zhangbin.pulltorefreshing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshListView;


public class MainActivity extends Activity {


    static final int MENU_MANUAL_REFRESH = 0;
    static final int MENU_DISABLE_SCROLL = 1;
    static final int MENU_SET_MODE = 2;
    static final int MENU_DEMO = 3;

    private List<DirItemBean> data = new ArrayList<>();
    private HashMap<String, List<PullBean>> mListItems = new HashMap<>();
    private PullToRefreshListView mPullRefreshListView;

    private PullToRefreshUtil pullToRefreshUtil ;
    private MyAdapter mAdapter;
    private DirItemBean pullBean = new DirItemBean();
    private MyAdapter myAdapter;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
        mContext = this;
        pullToRefreshUtil= new PullToRefreshUtil(this, mContext);
        /**
         * 实现 接口  OnRefreshListener2<ListView>  以便与监听  滚动条到顶部和到底部
         */
        mPullRefreshListView.setOnRefreshListener(new OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(MainActivity.this, "onPullDownToRefresh", Toast.LENGTH_SHORT).show();
                updateLastFreshTime(refreshView);
                new GetDataTask().execute();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(MainActivity.this, "onPullUpToRefresh", Toast.LENGTH_SHORT).show();
                updateLastFreshTime(refreshView);
                new GetDataTask().execute();
            }
        });

        // 加载到最底部时
        mPullRefreshListView.setOnLastItemVisibleListener(new PullToRefreshBase.OnLastItemVisibleListener() {
            @Override
            public void onLastItemVisible() {
                Toast.makeText(MainActivity.this, "End of List!", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }
        });
//        ListView actualListView = mPullRefreshListView.getRefreshableView();

        // Need to use the Actual ListView when registering for Context Menu
//        registerForContextMenu(actualListView);

        for (int i = 0; i<19; i++){
            pullBean.setName("测试");
            pullBean.setOwner("" + i);
            data.add(pullBean);
        }
        mAdapter = new MyAdapter(MainActivity.this , data);

        mAdapter.setSubMenuClickListener(pullToRefreshUtil
                .getSubMenuClickListener());

        mPullRefreshListView.setAdapter(mAdapter);
    }

    //添加时间设置
    protected void updateLastFreshTime(PullToRefreshBase<ListView> refreshView) {
        String label = DateUtils.formatDateTime(
                getApplicationContext(),System.currentTimeMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);
        refreshView.getLoadingLayoutProxy(true,true)
                .setLastUpdatedLabel(label);
    }
    //模拟网络加载数据的   异步请求类
    //
    private class GetDataTask extends AsyncTask<Void, Void, List<DirItemBean>> {

        //子线程请求数据
        @Override
        protected List<DirItemBean> doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return data;
        }

        //主线程更新UI
        @Override
        protected void onPostExecute(List<DirItemBean> result) {

            //向RefreshListView Item 添加一行数据  并刷新ListView
            for (int i = 0; i<20; i++) {
                pullBean.setName("测试");
                pullBean.setOwner("" + i);
                data.add(pullBean);
            }
            mAdapter.notifyDataSetChanged();
            mPullRefreshListView.onRefreshComplete();
            super.onPostExecute(result);
        }
    }

}