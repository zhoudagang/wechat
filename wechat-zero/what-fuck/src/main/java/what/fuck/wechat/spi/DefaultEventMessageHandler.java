package what.fuck.wechat.spi;

import what.fuck.wechat.message.OutputMessage;
import what.fuck.wechat.message.event.ClickEventMessage;
import what.fuck.wechat.message.event.EventMessage;
import what.fuck.wechat.message.event.LocationEventMessage;
import what.fuck.wechat.message.event.LocationSelectEventMessage;
import what.fuck.wechat.message.event.PicPhotoOrAlbumEventMessage;
import what.fuck.wechat.message.event.PicSysPhotoEventMessage;
import what.fuck.wechat.message.event.PicWeixinEventMessage;
import what.fuck.wechat.message.event.QrsceneScanEventMessage;
import what.fuck.wechat.message.event.QrsceneSubscribeEventMessage;
import what.fuck.wechat.message.event.ScanCodePushEventMessage;
import what.fuck.wechat.message.event.ScanCodeWaitMsgEventMessage;
import what.fuck.wechat.message.event.SubscribeEventMessage;
import what.fuck.wechat.message.event.UnSubscribeEventMessage;
import what.fuck.wechat.message.event.ViewEventMessage;
import what.fuck.wechat.message.output.TextOutputMessage;

/**
 * DefaultEventMessageHandler业务
 *
 * @author qsyang
 * @version 1.0
 */
public class DefaultEventMessageHandler implements IEventMessageHandler {

    private OutputMessage allType(EventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        return allType(msg);
    }

}
