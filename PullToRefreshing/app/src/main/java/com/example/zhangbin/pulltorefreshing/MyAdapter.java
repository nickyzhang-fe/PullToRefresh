package com.example.zhangbin.pulltorefreshing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangbin on 2015/12/21.
 */
public class MyAdapter extends BaseAdapter {
    private List<DirItemBean> data = new ArrayList<>();
    private List<DirItemBean> list = new ArrayList<>();
    private LayoutInflater minflater;
    private Context mContext;
    boolean isOver = true;
    public MyAdapter(Context context, List<DirItemBean> data){
        this.mContext = context;
        minflater = LayoutInflater.from(context);
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public DirItemBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = minflater.inflate(R.layout.item, null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
            viewHolder.selection = (LinearLayout) convertView.findViewById(R.id.cloudbox_list_ll_sub);
            convertView.setTag(viewHolder);
            bindSubView(convertView, viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        setSubView(viewHolder, position);

        viewHolder.title.setText(data.get(position).getName());
        viewHolder.content.setText(data.get(position).getOwner());

        viewHolder.title.setTag(position);
        viewHolder.title.setOnClickListener(mClickListener);

        final ViewHolder finalViewHolder = viewHolder;
        viewHolder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOver == true){
                    finalViewHolder.selection.setVisibility(View.GONE);
                    isOver = false;
                }else{
                    finalViewHolder.selection.setVisibility(View.VISIBLE);
                    isOver = true;
                }
            }
        });
        return convertView;
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.title:
                    click((Integer) v.getTag());
                    break;
                default:
                    break;
            }
        }
    };

    private void bindSubView(View convertView, ViewHolder holder) {
        holder.bt_share = (LinearLayout) convertView
                .findViewById(R.id.cloudbox_list_child_share);
        holder.bt_download = (LinearLayout) convertView
                .findViewById(R.id.cloudbox_list_child_download);
        holder.bt_rename = (LinearLayout) convertView
                .findViewById(R.id.cloudbox_list_child_rename);
        holder.bt_move = (LinearLayout) convertView
                .findViewById(R.id.cloudbox_list_child_move);
        holder.bt_delete = (LinearLayout) convertView
                .findViewById(R.id.cloudbox_list_child_delete);
    }
    private void setSubView(ViewHolder holder, int position) {
        holder.bt_share.setTag(position);
        holder.bt_download.setTag(position);
        holder.bt_rename.setTag(position);
        holder.bt_move.setTag(position);
        holder.bt_delete.setTag(position);

        holder.bt_share.setOnClickListener(subMenuClickListener);
        holder.bt_download.setOnClickListener(subMenuClickListener);
        holder.bt_rename.setOnClickListener(subMenuClickListener);
        holder.bt_move.setOnClickListener(subMenuClickListener);
        holder.bt_delete.setOnClickListener(subMenuClickListener);
    }

    private SubMenuClickListener mSubMenuClickListener = null;

    public void setSubMenuClickListener(SubMenuClickListener l) {
        this.mSubMenuClickListener = l;
    }

    private View.OnClickListener subMenuClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            DirItemBean item = getItem((Integer) v.getTag());
            switch (v.getId()) {
                case R.id.cloudbox_list_child_share:
                    mSubMenuClickListener.onShareClick(item);
                    break;
                case R.id.cloudbox_list_child_download:
                    mSubMenuClickListener.onDownLoadClick(item);
                    break;
                case R.id.cloudbox_list_child_rename:
                    mSubMenuClickListener.onRenameClick(item);
                    break;
                case R.id.cloudbox_list_child_move:
                    mSubMenuClickListener.onMoveClick(item);
                    break;
                case R.id.cloudbox_list_child_delete:
                    mSubMenuClickListener.onDeleteClick(item);
                    break;
                default:
                    break;
            }

        }
    };
    //item事件监听
    protected void click(int position){
        Toast.makeText(mContext, ""+position, Toast.LENGTH_SHORT).show();
    }
    public class ViewHolder{
        public TextView title;
        public TextView content;
        public LinearLayout selection;
        public LinearLayout bt_share;
        public LinearLayout bt_download;
        public LinearLayout bt_rename;
        public LinearLayout bt_move;
        public LinearLayout bt_delete;
    }
}
