package what.fuck.wechat.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessControlException;
import java.util.Properties;

/**
 * 微信平台调用基础配置
 *
 * <p>
 * 如果存在weixin.properties,则加载属性文件中配置的参数
 * </p>
 *
 */
public class Configuration {

    private static Properties defaultProperty;

    static {
        init();
    }

    static void init() {
        //初始化默认配置
        defaultProperty = new Properties();
        defaultProperty.setProperty("wechat.debug", "true");
        defaultProperty.setProperty("wechat.token", "JinGuo");
        defaultProperty.setProperty("wechat.http.connectionTimeout", "20000");
        defaultProperty.setProperty("wechat.http.readTimeout", "120000");
        defaultProperty.setProperty("wechat.http.retryCount", "3");
        //读取自定义配置
        String t4jProps = "i18n/wechat.properties";
        boolean loaded = loadProperties(defaultProperty, "." + File.separatorChar + t4jProps)
                || loadProperties(defaultProperty, Configuration.class.getResourceAsStream("/WEB-INF/" + t4jProps))
                || loadProperties(defaultProperty, Configuration.class.getClassLoader().getResourceAsStream(t4jProps));
        if (!loaded) {
            System.out.println("wechat:没有加载到wechat.properties属性文件!");
        }
    }

    /**
     * 加载属性文件
     *
     * @param props 属性文件实例
     * @param path 属性文件路径
     * @return 是否加载成功
     */
    private static boolean loadProperties(Properties props, String path) {
        try {
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                props.load(new FileInputStream(file));
                return true;
            }
        } catch (IOException ignore) {
            //异常忽略
            ignore.printStackTrace();
        }
        return false;
    }

    /**
     * 加载属性文件
     *
     * @param props 属性文件实例
     * @param is 属性文件流
     * @return 是否加载成功
     */
    private static boolean loadProperties(Properties props, InputStream is) {
        try {
            if (is != null) {
                props.load(is);
                return true;
            }
        } catch (IOException ignore) {
            //异常忽略
            ignore.printStackTrace();
        }
        return false;
    }

    /**
     * 获取开发者第三方用户唯一凭证
     *
     * @return 第三方用户唯一凭证
     */
    public static String getOAuthAppId() {
        return getProperty("wechat.oauth.appid");
    }

    /**
     * 获取开发者第三方用户唯一凭证
     *
     * @param appid 默认第三方用户唯一凭证
     * @return 第三方用户唯一凭证
     */
    public static String getOAuthAppId(String appid) {
        return getProperty("wechat.oauth.appid", appid);
    }

    /**
     * 获取开发者第三方用户唯一凭证密钥
     *
     * @return 第三方用户唯一凭证密钥
     */
    public static String getOAuthSecret() {
        return getProperty("wechat.oauth.secret");
    }

    /**
     * 获取开发者第三方用户唯一凭证密钥
     *
     * @param secret 默认第三方用户唯一凭证密钥
     * @return 第三方用户唯一凭证密钥
     */
    public static String getOAuthSecret(String secret) {
        return getProperty("wechat.oauth.secret", secret);
    }

    /**
     * 获取 连接超时时间
     *
     * @return 连接超时时间
     */
    public static int getConnectionTimeout() {
        return getIntProperty("wechat.http.connectionTimeout");
    }

    /**
     * 获取 连接超时时间
     *
     * @param connectionTimeout 默认连接超时时间
     * @return 连接超时时间
     */
    public static int getConnectionTimeout(int connectionTimeout) {
        return getIntProperty("wechat.http.connectionTimeout", connectionTimeout);
    }

    /**
     * 获取 请求超时时间
     *
     * @return 请求超时时间
     */
    public static int getReadTimeout() {
        return getIntProperty("wechat.http.readTimeout");
    }

    /**
     * 获取 请求超时时间
     *
     * @param readTimeout 默认请求超时时间
     * @return 请求超时时间
     */
    public static int getReadTimeout(int readTimeout) {
        return getIntProperty("wechat.http.readTimeout", readTimeout);
    }

    /**
     * 获取 是否为调试模式
     *
     * @return 是否为调试模式
     */
    public static boolean isDebug() {
        return getBoolean("wechat.debug");
    }

    public static boolean getBoolean(String name) {
        String value = getProperty(name);
        return Boolean.valueOf(value);
    }

    public static int getIntProperty(String name) {
        String value = getProperty(name);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    public static int getIntProperty(String name, int fallbackValue) {
        String value = getProperty(name, String.valueOf(fallbackValue));
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            return -1;
        }
    }

    /**
     * 获取属性值
     *
     * @param name 属性名称
     * @return 属性值
     */
    public static String getProperty(String name) {
        return getProperty(name, null);
    }

    /**
     * 获取属性值
     *
     * @param name 属性名
     * @param fallbackValue 默认返回值
     * @return 属性值
     */
    public static String getProperty(String name, String fallbackValue) {
        String value;
        try {
            //从全局系统获取
            value = System.getProperty(name, null);
            if (null == value) {
                //先从系统配置文件获取
                value = defaultProperty.getProperty(name, fallbackValue);
            }
        } catch (AccessControlException ace) {
            // Unsigned applet cannot access System properties
            value = fallbackValue;
        }
        return value;
    }
}
