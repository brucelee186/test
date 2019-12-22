package tool.jsoup;

import common.bean.BaseBean;

public class MoveList extends BaseBean{
	
	// 角色名称
	private String nameRole;
	
	// 类型
	private String arts;
	
	// 
	private String command;
	
	// 名称
	private String name;
	
	// 
	private String type;
	
	// 位置
	private String stance;
	
	// 
	private String damage;
	
	// 
	private String escape;
	
	// 
	private String hitRange;
	
	// 
	private String properties;
	private String remark;
	
	public String getHitRange() {
		return hitRange;
	}
	public void setHitRange(String hitRange) {
		this.hitRange = hitRange;
	}
	public String getNameRole() {
		return nameRole;
	}
	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}
	public String getArts() {
		return arts;
	}
	public void setArts(String arts) {
		this.arts = arts;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStance() {
		return stance;
	}
	public void setStance(String stance) {
		this.stance = stance;
	}
	public String getDamage() {
		return damage;
	}
	public void setDamage(String damage) {
		this.damage = damage;
	}
	public String getEscape() {
		return escape;
	}
	public void setEscape(String escape) {
		this.escape = escape;
	}
	public String getProperties() {
		return properties;
	}
	public void setProperties(String properties) {
		this.properties = properties;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
