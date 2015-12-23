package com.example.zhangbin.pulltorefreshing;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by zhangbin on 2015/12/22.
 */
public class PullToRefreshUtil {
    private MainActivity mainActivity;
    private Context mContext;
    private String tag="subMenuClickListener";
    public PullToRefreshUtil(MainActivity mainActivity, Context mContext) {
        this.mainActivity = mainActivity;
        this.mContext = mContext;
    }
    public SubMenuClickListener getSubMenuClickListener() {
        return new SubMenuClickListener() {

            @Override
            public void onShareClick(DirItemBean item) {
                Toast.makeText(mContext, "share", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDownLoadClick(DirItemBean item) {
                Toast.makeText(mContext, "download", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRenameClick(DirItemBean item) {
                Toast.makeText(mContext, "rename", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMoveClick(DirItemBean item) {
                Toast.makeText(mContext, "move", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDeleteClick(final DirItemBean item) {
                Toast.makeText(mContext, "delete", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
