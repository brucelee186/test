package com.mtf.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mtf.framework.model.User;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.UserInforImpl;

public class CommonUtil {
	
	@Autowired
	private HttpSession session;

	@Autowired
	public HttpSession getSession() {
		return session;
	}

	@Autowired
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * 字符串的加减乘除计算,加:add,减:subtract,乘:multiply,除:divide
	 * @param parameter(加:add,减:subtract,乘:multiply,除:divide)
	 * @param number1
	 * @param number2
	 * @return
	 * @author yinquanlin
	 */
	public static String calculate(String parameter,String number1,String number2){
		BigDecimal result = new BigDecimal("0");
		BigDecimal decimal1 = new BigDecimal(number1);
		BigDecimal decimal2 = new BigDecimal(number2);
		if(parameter.equals("+")){
			result = decimal1.add(decimal2);
		}
		if(parameter.equals("-")){
			result = decimal1.subtract(decimal2);
		}
		if(parameter.equals("*")){
			result = decimal1.multiply(decimal2);
		}
		if(parameter.equals("/")){
			result = decimal1.divide(decimal2,2,BigDecimal.ROUND_HALF_UP);
		}
		return result.toString();
	}
	
	public static void setCommonField(Object object, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Class<?> clazz = object.getClass();
		Class<?> clazzSuper = clazz.getSuperclass();
		Class<?> clazzGrand = clazzSuper.getSuperclass();
		// 取得用户id和ip
		String userId = sessionInfo.getUserId();
		String userIp = sessionInfo.getIp();
		try {
			Field sessionInfofField = clazzGrand.getDeclaredField("object");
			sessionInfofField.setAccessible(true);
			Field userIdField = clazzGrand.getDeclaredField("userId");
			userIdField.setAccessible(true);
			Field modifiedUserField = clazzSuper.getDeclaredField("modifiedUser");
			modifiedUserField.setAccessible(true);
			Field modifiedDateField = clazzSuper.getDeclaredField("modifiedDate");
			modifiedDateField.setAccessible(true);
			Field addDateField = clazzSuper.getDeclaredField("addDate");
			addDateField.setAccessible(true);
			Field addUserField = clazzSuper.getDeclaredField("addUser");
			addUserField.setAccessible(true);
			Field addIpField = clazzSuper.getDeclaredField("addIp");
			addIpField.setAccessible(true);
			Field modifyIpfField = clazzSuper.getDeclaredField("modifiedIp");
			modifyIpfField.setAccessible(true);
			Date date = new Date();
			sessionInfofField.set(object, sessionInfo);
			userIdField.set(object, userId);
			modifiedUserField.set(object, userId);
			modifiedDateField.set(object, date);
			addDateField.set(object, date);
			addUserField.set(object, userId);
			addIpField.set(object,userIp);
			modifyIpfField.set(object, userIp);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setCommonField(Object object) {
		HttpSession session = getHttpSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Class<?> clazz = object.getClass();
		Class<?> clazzSuper = clazz.getSuperclass();
		Class<?> clazzGrand = clazzSuper.getSuperclass();
		// 取得用户id和ip
		String userId = sessionInfo.getUserId();
		String userIp = sessionInfo.getIp();
		try {
			Field sessionInfofField = clazzGrand.getDeclaredField("object");
			sessionInfofField.setAccessible(true);
			Field userIdField = clazzGrand.getDeclaredField("userId");
			userIdField.setAccessible(true);
			Field modifiedUserField = clazzSuper.getDeclaredField("modifiedUser");
			modifiedUserField.setAccessible(true);
			Field modifiedDateField = clazzSuper.getDeclaredField("modifiedDate");
			modifiedDateField.setAccessible(true);
			Field addDateField = clazzSuper.getDeclaredField("addDate");
			addDateField.setAccessible(true);
			Field addUserField = clazzSuper.getDeclaredField("addUser");
			addUserField.setAccessible(true);
			Field addIpField = clazzSuper.getDeclaredField("addIp");
			addIpField.setAccessible(true);
			Field modifyIpfField = clazzSuper.getDeclaredField("modifiedIp");
			modifyIpfField.setAccessible(true);
			Date date = new Date();
			sessionInfofField.set(object, sessionInfo);
			userIdField.set(object, userId);
			modifiedUserField.set(object, userId);
			modifiedDateField.set(object, date);
			addDateField.set(object, date);
			addUserField.set(object, userId);
			addIpField.set(object,userIp);
			modifyIpfField.set(object, userIp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置添加更新时共同bean字段
	 * @param object
	 */
	public static void setCommonModifyField(Object object) {
		HttpSession session = getHttpSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Class<?> clazz = object.getClass();
		Class<?> clazzSuper = clazz.getSuperclass();
		Class<?> clazzGrand = clazzSuper.getSuperclass();
		// 取得用户id和ip
		String userId = sessionInfo.getUserId();
		String userIp = sessionInfo.getIp();
		try {
			Field fieldEditState =  clazzGrand.getDeclaredField("editState");
			fieldEditState.setAccessible(true);
			String editState = (String) fieldEditState.get(object);
			Field userIdField = clazzGrand.getDeclaredField("userId");
			userIdField.setAccessible(true);
			Date date = new Date();
			if (null != editState && "i".equals(editState)) {
				Field addDateField = clazzSuper.getDeclaredField("addDate");
				addDateField.setAccessible(true);
				Field addUserField = clazzSuper.getDeclaredField("addUser");
				addUserField.setAccessible(true);
				Field addIpField = clazzSuper.getDeclaredField("addIp");
				addIpField.setAccessible(true);
				addDateField.set(object, date);
				addUserField.set(object, userId);
				addIpField.set(object,userIp);
			}
			Field modifiedUserField = clazzSuper.getDeclaredField("modifiedUser");
			modifiedUserField.setAccessible(true);
			Field modifiedDateField = clazzSuper.getDeclaredField("modifiedDate");
			modifiedDateField.setAccessible(true);
			Field sessionInfofField = clazzGrand.getDeclaredField("object");
			sessionInfofField.setAccessible(true);
			Field modifyIpfField = clazzSuper.getDeclaredField("modifiedIp");
			modifyIpfField.setAccessible(true);
			sessionInfofField.set(object, sessionInfo);
			userIdField.set(object, userId);
			modifiedUserField.set(object, userId);
			modifiedDateField.set(object, date);
			modifyIpfField.set(object, userIp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 全球唯一码生成器
	 * 
	 * @return 全球唯一码
	 */
	public static String getGUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 加载共同配置文件中key对应的value
	 * 
	 * @param key
	 *            config.proerties文件中的key
	 * @return value config.proerties文件中的key对应的值
	 */
	public static String getConfig(String key) {
		String value = "";
		try {
			Properties properties = new Properties();
			URL propsUrl = ResourceUtils.getURL("classpath:config.properties");
			URLConnection connection = (URLConnection) propsUrl
					.openConnection();
			properties.load(connection.getInputStream());
			value = properties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * 取得系统状态,真实系统返回true,测试系统返回false
	 * @param key
	 * @return
	 */
	public static boolean getTrueSys() {
		boolean value = false;
		// 判断是否为服务器
		String tagTest = CommonUtil.getConfig("tagTest");
		String macServer = CommonUtil.getConfig("macServer");
		boolean judgeServer = NetworkUtil.checkMac(macServer);
		// # 是否为测试系统 t:test测试系统,r:real 真实系统
		if ("r".equals(tagTest) && judgeServer) {
			value = true;
		}
		return value;
	}
	/**
	 * 字符串加密
	 * @param plainText
	 * @return
	 */
	public static String encodeStr(String plainText) {
		byte[] b = plainText.getBytes();
		Base64 base64 = new Base64();
		Base32 base32 = new Base32();
		b = base64.encode(b);
		b = base32.encode(b);
		String s = new String(b);
		return s;
	}
	
	/**
	 * 字符串解密
	 * @param encodeStr
	 * @return
	 */
	public static String decodeStr(String encodeStr) {
		byte[] b = encodeStr.getBytes();
		Base64 base64 = new Base64();
		Base32 base32 = new Base32();
		b = base32.decode(b);
		b = base64.decode(b);
		String s = new String(b);
		return s;
	}

	/**
	 * 判断权限是否存在
	 * @param code
	 * @return
	 */
	static public boolean checkCode(String code, HttpServletRequest request) {
		HttpSession session = request.getSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Map<String, String> mapRolePermission = sessionInfo.getMapRolePermission();
		Set<String> setKey = mapRolePermission.keySet();
		boolean checkResult = setKey.contains(code);
		return checkResult;
	}
	
	static public boolean checkCode(String code) {
		HttpSession session = getHttpSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		// 取得用户等级如果为系统内置管理员的话 全部显示(返回值为true)
		Integer userLevel = sessionInfo.getUserLever();
		boolean checkResult = false;
		if (userLevel.equals(9)) {
			checkResult = true;
		} else {
			checkResult = checkCodeExist(sessionInfo, code);
		}
		return checkResult;
	}
	
	/**
	 * 判断是否包含权限集合中的一个
	 * @param code
	 * @return
	 */
	static public boolean containCode(String codes) {
		HttpSession session = getHttpSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		// 取得用户等级如果为系统内置管理员的话 全部显示(返回值为true)
		Integer userLevel = sessionInfo.getUserLever();
		boolean checkResult = false;
		if (userLevel.equals(9)) {
			checkResult = true;
		} else {
			String[] arrayCode = codes.split(",");
			for (String code : arrayCode) {
				checkResult = checkCodeExist(sessionInfo, code);
				if (checkResult) {
					break;
				}
			}
		}
		return checkResult;
	}
	
	/**
	 * 判断权限是否存在与会话中
	 * @param sessionInfo
	 * @param code
	 * @return
	 */
	public static boolean checkCodeExist(SessionInfo sessionInfo, String code) {
		boolean checkResult = false;
			Map<String, String> mapRolePermission = sessionInfo.getMapRolePermission();
			Set<String> setKey = mapRolePermission.keySet();
			checkResult = setKey.contains(code);
		return checkResult;
	}
	
	
	/**
	 * 静态类中取得session
	 * @return
	 */
	public static HttpSession getHttpSession() {
		ServletRequestAttributes requestAttrributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttrributes.getRequest();
		HttpSession session = request.getSession();
		return session;
		
	}
	
	/**
	 * 静态类中取得session
	 * @return
	 */
	public static SessionInfo getSessionInfo() {
		HttpSession session = getHttpSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		return sessionInfo;
	}
	
	/**
	 * 取得判断是否为服务器标记
	 * @return
	 */
	public static boolean getTagSys() {
		boolean tagSys = false;
		HttpSession session = getHttpSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		try {
			tagSys = sessionInfo.getTagSys();
		} catch (Exception e) {
			e.printStackTrace();
			tagSys = false;
		}
		return tagSys;
	}
	
	/**
	 * 静态类中取得session中的用户类
	 * @return
	 */
	public static User getUser() {
		SessionInfo sessionInfo = getSessionInfo();
		User user = sessionInfo.getUser();
		return user;
		
	}
	
	/**
	 * 取得服务器ip
	 * @return
	 */
	public static String getContextPath() {
		SessionInfo sessionInfo = getSessionInfo();
		String contextPath = sessionInfo.getContextPath();
		return contextPath;
		
	}
	
	/**
	 * 取得服务器ip
	 * @return
	 */
	public static String getIpServer() {
		String ipServer = CommonUtil.getConfig("ipLocalhost");
		boolean trueSys = getTrueSys();
		if(trueSys){
			ipServer = CommonUtil.getConfig("ipServer");
		}
		return ipServer;
		
	}
	
	/**
	 * 取得员工卡号
	 * @return
	 */
	public static String getCardNo() {
		User user = getUser();
		String cardNo = user.getCardNo();
		return cardNo;
		
	}
	
	/**
	 * 取得员工卡号
	 * @return
	 */
	public static String getBadgenumber() {
		User user = getUser();
		String badgenumber = user.getBadgenumber();
		return badgenumber;
		
	}
	/**
	 * 取得员工卡号
	 * @return
	 */
	public static String getUserName() {
		User user = getUser();
		String userName = user.getDisplayName();
		return userName;
		
	}
	
	/**
	 * 取得员工卡号
	 * @return
	 */
	public static String getUserId() {
		User user = getUser();
		String userId = user.getId();
		return userId;
		
	}
	
	
	
	/**
	 * 加载环境变量
	 */
	public static final ApplicationContext ac = new ClassPathXmlApplicationContext(
			new String[] {
					"spring.xml",
					"spring-mybatis.xml" });
	
	public static String readTextContent(String url) {
		String tempContent = "";// 用于临时保存每次读取的内容
		String judgeReadLine = null;
		try {
			//FileReader fr = new FileReader(url);
			File file = new File(url);
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
			BufferedReader br = new BufferedReader(inputStreamReader);
			while ((judgeReadLine = br.readLine()) != null) {
				tempContent += judgeReadLine ;
			}
			fileInputStream.close();
			inputStreamReader.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return tempContent;
	}

    
    /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
      
	/**
	 * 字符串的日期格式的计算   
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }  
    
    /**
     * 检测邮箱地址是否合法
     * @param email
     * @return true合法 false不合法
     */
	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		// Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}"); //简单匹配
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");// 复杂匹配
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 取得用户下拉列表
	 * @param userInfo
	 * @return
	 */
	public static List<UserInforImpl> doDropList(UserInforImpl userInfo){
		return null;
	}
	
	/**
	 * json转bean
	 * @param jsonListString
	 * @param obj
	 * @return
	 */
	public static List<?> JSON2List(JSONArray jsonListString, Object obj) {
		List<?> json2List = (List<?>) JSONArray.toList(jsonListString, obj, new JsonConfig());
		return json2List;
	}
}
