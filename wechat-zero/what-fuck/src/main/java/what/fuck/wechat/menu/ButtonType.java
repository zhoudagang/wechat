package what.fuck.wechat.menu;

/**
 * 自定义菜单类型
 *
 */
public enum ButtonType {

    /**
     * 点击推事件
     */
    Click("click"),
    /**
     * 跳转URL
     */
    View("view"),
    /**
     * 扫码推事件
     */
    Scancode_Push("scancode_push"),
    /**
     * 扫码推事件且弹出“消息接收中”提示框
     */
    Scancode_Waitmsg("scancode_waitmsg"),
    /**
     * 弹出系统拍照发图
     */
    Pic_SysPhoto("pic_sysphoto"),
    /**
     * 弹出拍照或者相册发图
     */
    Pic_Photo_OR_Album("pic_photo_or_album"),
    /**
     * 弹出微信相册发图器
     */
    Pic_Weixin("pic_weixin"),
    /**
     * 弹出地理位置选择器
     */
    Location_Select("location_select"),
    /**
     * 下发消息（除文本消息）
     */
    Media_Id("media_id"),
    /**
     * 跳转图文消息URL
     */
    View_Limited("view_limited");
    
    private String value = "";

    ButtonType(String value) {
        this.value = value;
    }

    /**
     * @return the msgType
     */
    @Override
    public String toString() {
        return value;
    }
}
