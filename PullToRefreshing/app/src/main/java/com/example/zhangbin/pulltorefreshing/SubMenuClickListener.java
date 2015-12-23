package com.example.zhangbin.pulltorefreshing;

/**
 * Created by zhangbin on 2015/12/22.
 */

public interface SubMenuClickListener {

    /**
     * @Title: onShareClick
     * @Description: 分享
     * @author: leobert.lan
     * @param item
     */
    void onShareClick(DirItemBean item);

    /**
     * @Title: onDownLoadClick
     * @Description: 下载
     * @author: leobert.lan
     * @param item
     */
    void onDownLoadClick(DirItemBean item);

    /**
     * @Title: onRenameClick
     * @Description: 重命名
     * @author: leobert.lan
     * @param item
     */
    void onRenameClick(DirItemBean item);

    /**
     * @Title: onMoveClick
     * @Description: 移动
     * @author: leobert.lan
     * @param item
     */
    void onMoveClick(DirItemBean item);

    /**
     * @Title: onDeleteClick
     * @Description: 删除
     * @author: leobert.lan
     * @param item
     */
    void onDeleteClick(DirItemBean item);

}
