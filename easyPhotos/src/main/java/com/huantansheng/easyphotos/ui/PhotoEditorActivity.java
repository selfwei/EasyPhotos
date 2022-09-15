package com.huantansheng.easyphotos.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.huantansheng.easyphotos.emoji.Emoji;
import com.huantansheng.easyphotos.emoji.EmojiDrawer;
import com.huantansheng.easyphotos.emoji.IEmojiCallback;
import com.process.editor.PictureEditActivity;
import com.process.editor.bean.StickerText;
import com.process.editor.util.Utils;

/**
 * 说明：
 * <p>
 * 创建人：homecy
 * 创建时间：2022-09-15
 * <p>
 * 操作列表 编号 | 操作时间 | 操作人员 | 操作说明 （Create、Modify、Deprecated）
 * 操作列表 (1) | 2022-09-15 | homecy | Create
 */
public class PhotoEditorActivity extends PictureEditActivity implements IEmojiCallback
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData()
    {
        mSupportEmoji = true;
    }

    @Override
    public View getStickerLayout()
    {
        return new EmojiDrawer(this).bindCallback(this);
    }

    @Override
    public void onEmojiClick(String emoji)
    {
        StickerText stickerText = new StickerText(emoji, Color.WHITE);
        onText(stickerText, false);
        Utils.dismissDialog(mStickerImageDialog);
    }

    @Override
    public void onBackClick()
    {
        mStickerImageDialog.dismiss();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Emoji.recycleAllEmoji();
    }

    @Override
    public void onSaveSuccess(String savePath)
    {
        finish();
    }
}
