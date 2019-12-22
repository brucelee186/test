package framework.struts2.action;

import java.util.Map;

import com.neo.framework.bean.BeaSenDht11;
import com.neo.framework.dao.jdbc.DaoSenDht11;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestStruts2Action extends ActionSupport {

	private static final long serialVersionUID = 3728766060167696493L;

	private Double temperature;
	private Double humidity;
	
	private String name;
	private String password;
	
	private BeaSenDht11 beaSenDht11;
	
	public BeaSenDht11 getBeaSenDht11() {
		return beaSenDht11;
	}
	public void setBeaSenDht11(BeaSenDht11 beaSenDht11) {
		this.beaSenDht11 = beaSenDht11;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		System.err.println(name);
		System.err.println(password);
		
		BeaSenDht11 beaSenDht11 = DaoSenDht11.getSenDht11();
		Double temperature = beaSenDht11.getTemperature();
		Double humidity = beaSenDht11.getHumidity();
		System.out.println("temperature: " + temperature);
		System.out.println("humidity: " + humidity);
		
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("beaSenDht11", beaSenDht11);
		return "success";
	}
}
