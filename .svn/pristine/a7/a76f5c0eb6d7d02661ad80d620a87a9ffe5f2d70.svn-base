package framework.struts2.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.neo.framework.bean.BeaSenDht11;
import com.neo.framework.dao.jdbc.DaoSenDht11;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


// http://blog.csdn.net/thinkscape/article/details/7467153
public class ActSensor extends ActionSupport {

	private static final long serialVersionUID = 1L; 
	
    private Double temperature;
    
    private Double humidity;
    
    private Date date;
    
    private String dateStr;
    
	private BeaSenDht11 beaSenDht11;
	
	public String getDateStr() {
		return dateStr;
	}

	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public BeaSenDht11 getBeaSenDht11() {
		return beaSenDht11;
	}

	public void setBeaSenDht11(BeaSenDht11 beaSenDht11) {
		this.beaSenDht11 = beaSenDht11;
	}

	public String getSensor() {  
		BeaSenDht11 beaSenDht11 = DaoSenDht11.getSenDht11();
		Double temperature = beaSenDht11.getTemperature();
		Double humidity = beaSenDht11.getHumidity();
		Date date = beaSenDht11.getDate();
		//System.out.println("temperature: " + temperature);
		//System.out.println("humidity: " + humidity);
		this.temperature = temperature;
		this.humidity = humidity;
		this.date = date;
		this.dateStr = new SimpleDateFormat("HH:mm:ss").format(date);
    	this.beaSenDht11 = beaSenDht11;
        // 返回结果  
        return "hel";  
    }  
}