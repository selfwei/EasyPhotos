package com.huantansheng.easyphotos.utils;

import android.app.Activity;
import android.content.Context;

import com.lxj.xpopup.XPopup;

import com.huantansheng.easyphotos.R;

/**
 * 说明：提示信息工具类
 * <p>
 * 创建人：homecy
 * 创建时间：2021/9/21
 * <p>
 * 操作列表 编号 | 操作时间 | 操作人员 | 操作说明 （Create、Modify、Deprecated）
 * 操作列表 (1) | 2021/9/21 | homecy | Create
 */
public final class TipUtil
{
    /**
     * 中间选择框
     *
     * @param context        Context
     * @param title          标题
     * @param data           数据
     * @param chooseCallBack 回调接口
     */
    public static void centerList(Context context, String title, String[] data, ChooseCallBack chooseCallBack)
    {
        new XPopup.Builder(context)
                .asCenterList(title, data, null, -1,
                        chooseCallBack::callBack, R.layout.xpopup_center_list, R.layout.xpopup_center_item)
                .show();
    }

    public interface ChooseCallBack
    {
        public void callBack(int position, String text);
    }
}
