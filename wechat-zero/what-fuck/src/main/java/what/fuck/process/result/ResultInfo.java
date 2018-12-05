package what.fuck.process.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统提示信息消息封装 包括 提示信息类型和信息内容
 */
public class ResultInfo {

	/** 失败 */
	public static final int TYPE_RESULT_FAIL = 0;
	/** 成功 */
	public static final int TYPE_RESULT_SUCCESS = 1;
	/** 警告 */
	public static final int TYPE_RESULT_WARN = 2;
	/** 一般提示信息 */
	public static final int TYPE_RESULT_INFO = 3;

	/** 提示的信息类型 */
	private int type;

	/** 提示的信息代码 */
	private int messageCode;

	/** 提示的具体信息 */
	private String message;

	/** 信息提示明细列表 */
	private List<ResultInfo> detailsInfo;

	/** 提示消息对应操作的序号，方便查找问题，通常用于在批量提示信息中标识记录序号 */
	private int index;

	/** 提交后得到到业务数据信息从而返回给页面 */
	private Map<String, Object> sysData = new HashMap<String, Object>();

	public ResultInfo() {
		super();
	}

	public ResultInfo(int type, int messageCode, String message) {
		super();
		this.type = type;
		this.messageCode = messageCode;
		this.message = message;
	}

	public boolean isSuccess() {
		if (this.type == TYPE_RESULT_SUCCESS) {
			return true;
		}
		return false;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(int messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ResultInfo> getDetailsInfo() {
		return detailsInfo;
	}

	public void setDetailsInfo(List<ResultInfo> detailsInfo) {
		this.detailsInfo = detailsInfo;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Map<String, Object> getSysData() {
		return sysData;
	}

	public void setSysData(Map<String, Object> sysData) {
		this.sysData = sysData;
	}

}
