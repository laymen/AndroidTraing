package com.mouse.sell;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * http://blog.csdn.net/androidstudioo/article/details/51868223
 * Created by Mouse on 2017/2/22.
 * http://blog.csdn.net/as_jon/article/details/51149688
 */
public class GoodActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener
{
    private List<Good> data;

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private RefershAdapter refershAdapter;
    int lastVisibleItem;
    private LinearLayoutManager mLinearLayoutManager;
    private GoodDao dao;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewlist);

        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        swipeRefreshLayout.setOnRefreshListener(this);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_SETTLING && lastVisibleItem + 1 == refershAdapter.getItemCount()) {

                    refershAdapter.changeMoreStatus(RefershAdapter.LOADING_MORE);
                    //此处实现网络请求
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<Good> newDatas = new ArrayList<>();
                            for (int index = 0; index < 5; index++) {
                                Good g = new Good();
                                g.setGname("more item" + index);
                                g.setGprice(100 + index);
                                newDatas.add(g);
                            }
                            refershAdapter.addMoreItem(newDatas);
                            refershAdapter.changeMoreStatus(RefershAdapter.PULLUP_LOAD_MORE);

                        }
                    }, 2000);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();

            }
        });
        recyclerView.setHasFixedSize(true);

        dao=new GoodDao(this);
        data=dao.showAllGoods();
        refershAdapter = new RefershAdapter(this,data,dao);
        recyclerView.setAdapter(refershAdapter);
    }




    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Good> newDatas = new ArrayList<>();
                for (int i = 0; i <5; i++) {
                    int index = i + 1;
                    Good g=new Good();
                    g.setGname("new item"+index);
                    g.setGprice(100+index);
                    newDatas.add(g);
                }
                refershAdapter.addItem(newDatas);
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(GoodActivity.this, "更新了五条数据...", Toast.LENGTH_SHORT).show();
            }
        }, 1000);

    }
}
