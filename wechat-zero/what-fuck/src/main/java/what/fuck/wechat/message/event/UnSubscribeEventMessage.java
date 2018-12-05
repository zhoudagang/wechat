package what.fuck.wechat.message.event;

import what.fuck.wechat.message.EventType;

/**
 * 取消关注事件
 *
 * @author qsyang
 * @version 1.0
 */
public class UnSubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Unsubscribe.toString();
    }

}
