package com.jq.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义封装返回工具类
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class SysResult implements Serializable{
	private static final long serialVersionUID = 1L;

	// 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    /*
     *  0	成功
     *  1	失败
     */
    private Integer returnCode;

    // 具体的错误信息
    private String returnMsg;

    // 响应中的数据
    private Object data;

    public static SysResult build(Integer returnCode, String returnMsg, Object data) {
        return new SysResult(returnCode, returnMsg, data);
    }

    public static SysResult success(Object data) {
        return new SysResult(data);
    }

    public static SysResult Success() {
        return new SysResult(null);
    }

    public SysResult() {

    }

    public static SysResult build(Integer returnCode, String returnMsg) {
        return new SysResult(returnCode, returnMsg, null);
    }

    public SysResult(Integer returnCode, String returnMsg, Object data) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.data = data;
    }

    public SysResult(Object data) {
        this.returnCode = 0;
        this.returnMsg = "";
        this.data = data;
    }

    
    public Boolean isSuccess() {
        return this.returnCode == 0;
    }
  

    public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	/**
     * 将json结果集转化为SysResult对象
     * 
     * @param jsonData json数据
     * @param clazz SysResult中的object类型
     * @return
     */
    public static SysResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, SysResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("returnCode").intValue(), jsonNode.get("returnMsg").asText(), obj);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

    /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static SysResult format(String json) {
        try {
            return MAPPER.readValue(json, SysResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static SysResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("returnCode").intValue(), jsonNode.get("returnMsg").asText(), obj);
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

}
