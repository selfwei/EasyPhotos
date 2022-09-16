package com.huantansheng.easyphotos.event;

/**
 * 说明：
 * <p>
 * 创建人：homecy
 * 创建时间：2022-09-15
 * <p>
 * 操作列表 编号 | 操作时间 | 操作人员 | 操作说明 （Create、Modify、Deprecated）
 * 操作列表 (1) | 2022-09-15 | homecy | Create
 */
public class Event
{
    /**
     * 重载事件消息
     */
    public static class ReloadEvent
    {
        private String path;

        public ReloadEvent(String path)
        {
            this.path = path;
        }

        public String getPath()
        {
            return path;
        }
    }
}
