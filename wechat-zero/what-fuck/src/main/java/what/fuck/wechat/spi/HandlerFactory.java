package what.fuck.wechat.spi;


import what.fuck.wechat.config.Configuration;

/**
 * 输入消息处理器工具类
 *
 * @version 1.0
 */
public class HandlerFactory {

    private static IMessageHandler messageHandler = null;
    private static String defaultHandler = "what.fuck.wechat.spi.DefaultNormalMessageHandler";

    public static IMessageHandler getMessageHandler() {
        if (messageHandler == null) {
            //获取
			defaultHandler = Configuration.getProperty("weixin.handler", defaultHandler);
			if (Configuration.isDebug()) {
			    System.out.println("微信输入消息处理Hanler:" + defaultHandler);
			}
			// 加载处理器
          //   Class<?> clazz = Class.forName(defaultHandler);
			try {
			 //   messageHandler = (IMessageHandler) clazz.newInstance();
				messageHandler=(IMessageHandler) new HandlerFactory();
			} catch (Exception ex) {
			    System.out.println("初始化 IMessageHandler 异常：");
			    ex.printStackTrace();
			}
        }
        return messageHandler;
    }

    private static INormalMessageHandler normalMessageHandler = null;
    private static String defaultNormalHandler = "what.fuck.wechat.spi.DefaultNormalMessageHandler";

    public static INormalMessageHandler getNormalMessageHandler() {
        if (normalMessageHandler == null) {
            try {
                //获取
                defaultNormalHandler = Configuration.getProperty("wechat.message.handler.normal", defaultNormalHandler);
                if (Configuration.isDebug()) {
                    System.out.println("微信接受消息处理Hanler:" + defaultNormalHandler);
                }
                // 加载处理器
                Class<?> clazz = Class.forName(defaultNormalHandler);
                try {
                    normalMessageHandler = (INormalMessageHandler) clazz.newInstance();
                } catch (Exception ex) {
                    System.out.println("初始化 INormalMessageHandler 异常：");
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("找不到: " + defaultNormalHandler + " 类!");
                ex.printStackTrace();
            }
        }
        return normalMessageHandler;
    }

    private static IEventMessageHandler eventMessageHandler = null;
    private static String defaultEventHandler = "what.fuck.wechat.spi.DefaultEventMessageHandler";

    public static IEventMessageHandler getEventMessageHandler() {
        if (eventMessageHandler == null) {
            try {
                //获取
                defaultEventHandler = Configuration.getProperty("wechat.message.handler.event", defaultEventHandler);
                if (Configuration.isDebug()) {
                    System.out.println("微信接受消息处理Hanler:" + defaultEventHandler);
                }
                // 加载处理器
                Class<?> clazz = Class.forName(defaultEventHandler);
                try {
                    eventMessageHandler = (IEventMessageHandler) clazz.newInstance();
                } catch (Exception ex) {
                    System.out.println("初始化 IEventMessageHandler 异常：");
                    ex.printStackTrace();
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("找不到: " + defaultEventHandler + " 类!");
                ex.printStackTrace();
            }
        }
        return eventMessageHandler;
    }
}
