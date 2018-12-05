package what.fuck.wechat.message.event;

import what.fuck.wechat.message.EventType;

/**
 * 关注事件
 *
 * @author qsyang
 * @version 1.0
 */
public class SubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Subscribe.toString();
    }

}
