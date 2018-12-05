package what.fuck.wechat.pojo;

/**
 * 微信平台关注者对象
 *
 * <p>通过<tt>Weixin</tt>产生一个请求对象，通过<code>getWeixinUser()</code>生成一个<tt>WeixinUser</tt>，
 * 然后调用<tt>getUserList()</tt>，得到本对象.</p>
 *
 */
public class Followers {

    private int total;  //关注该公众账号的总用户数
    private int count;  //拉取的OPENID个数，最大值为10000
    private Data data;  //列表数据，OPENID的列表
    private String next_openid; //拉取列表的后一个用户的OPENID

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the next_openid
     */
    public String getNext_openid() {
        return next_openid;
    }

    /**
     * @param next_openid the next_openid to set
     */
    public void setNext_openid(String next_openid) {
        this.next_openid = next_openid;
    }

    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }
}
