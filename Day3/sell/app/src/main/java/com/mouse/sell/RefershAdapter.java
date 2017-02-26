package com.mouse.sell;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mouse on 2017/2/23.
 */
public class RefershAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mInflater;
    private List<Good> list = null;
    private Context context;
    private GoodDao dao;

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE = 1;
    //上拉加载更多状态-默认为0
    private int load_more_status = 0;

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    public RefershAdapter(Context context, List<Good> data,GoodDao dao) {
        this.context=context;
        this.mInflater = LayoutInflater.from(context);
        this.list = data;
        this.dao=dao;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            final View view = mInflater.inflate(R.layout.adapter, parent, false);
            ItemViewHolder viewHolder = new ItemViewHolder(view);
            //这边可以做一些属性设置，甚至事件监听绑定
            return viewHolder;

        } else if (viewType == TYPE_FOOTER) {
            View foot_view = mInflater.inflate(R.layout.listview_footer, parent, false);
            FooteViewHolder footeViewHolder = new FooteViewHolder(foot_view);
            return footeViewHolder;
        }
        return null;
    }

    /**
     * 数据绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final int position) {
        if(holder instanceof  ItemViewHolder){
            ((ItemViewHolder) holder).gname.setText(String.valueOf(list.get(position).getGname()));
            ((ItemViewHolder) holder).gprice.setText(String.valueOf(list.get(position).getGprice()));
            ((ItemViewHolder) holder).Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DailogShow(position);
                }
            });
        }else if(holder instanceof  FooteViewHolder){
            FooteViewHolder footeViewHolder = (FooteViewHolder) holder;
            switch(load_more_status){
                case PULLUP_LOAD_MORE:
                    footeViewHolder.tv_load.setText("上拉加载更多....");
                    break;
                case LOADING_MORE:
                    footeViewHolder.tv_load.setText("正在加载....");
                    break;
            }
        }



    }

    @Override
    public int getItemCount() {
        return list.size()+1;//加上footerview
    }

    @Override
    public int getItemViewType(int position) {
        //最后一个item设置为footerview
        //最后一个item设置为footerview
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_ITEM;
        }

    }
    public  void addItem(List<Good> newDatas){
        newDatas.addAll(list);
        list.removeAll(list);
        list.addAll(newDatas);
        notifyDataSetChanged();
    }
    public void addMoreItem(List<Good> newDatas){
        list.addAll(newDatas);
        notifyDataSetChanged();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout Layout;
        private TextView gname;
        private TextView gprice;
        public ItemViewHolder(View itemView) {
            super(itemView);
            Layout=(LinearLayout)itemView.findViewById(R.id.Layout);
            gname = (TextView) itemView.findViewById(R.id.gname);
            gprice=(TextView)itemView.findViewById(R.id.gprice);
        }
    }

    class FooteViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_load;
        public FooteViewHolder(View itemView) {
            super(itemView);
            tv_load = (TextView) itemView.findViewById(R.id.foot_view_item_tv);
        }
    }

    /**
     * //上拉加载更多
     * PULLUP_LOAD_MORE=0;
     * //正在加载中
     * LOADING_MORE=1;
     * //加载完成已经没有更多数据了
     * NO_MORE_DATA=2;
     * @param status
     */
    public void changeMoreStatus(int status){
        load_more_status = status;
        notifyDataSetChanged();
    }


    public  void DailogShow(final int id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("你确定要删除商品吗？");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,id+"------",Toast.LENGTH_SHORT).show();
                //确定的事件
                dao.deleteFood(id);
            }
        });
        builder.setNegativeButton("取消", null);
        builder.create();
        builder.show();
    }
}
