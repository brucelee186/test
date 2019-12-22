package framework.struts2.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.neo.framework.bean.BeaSenDht11;
import com.neo.framework.dao.jdbc.DaoSenDht11;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestStruts2Action2 extends ActionSupport {

	private static final long serialVersionUID = 1L;  
    
    private Map<String,Object> dataMap;  
    private String key = "Just see see";  
      
    public String json() {  
        // dataMap中的数据将会被Struts2转换成JSON字符串，所以这里要先清空其中的数据  
        dataMap = new HashMap<String, Object>();  
        BeaSenDht11 dht11 = new BeaSenDht11();
        dht11.setUid("张三");  
        dht11.setHumidity(123.00);  
        dataMap.put("user", dht11);  
        // 放入一个是否操作成功的标识  
        dataMap.put("success", true);  
        // 返回结果  
        return "hel";  
    }  
  
    public Map<String, Object> getDataMap() {  
        return dataMap;  
    }  
  
    //设置key属性不作为json的内容返回  
    @JSON(serialize=false)  
    public String getKey() {  
        return key;  
    }  
}
