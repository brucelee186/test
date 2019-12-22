package JSON;



// 需要加 ezmorph-1.0.6.jar 和 json-lib-2.3-jdk15.jar

/*
 * json-lib-2.3-jdk15.jar
ezmorph-1.0.6.jar
commons-logging-1.1.jar
commons-lang-2.3.jar
commons-collections-3.2.1-bin.jar
commons-beanutils-1.7.0.jar
 * */
// json与bean转换
public class Test {
	public static void main(String[] args) {
		String str = "[{\"id\":\"\",\"num\":\"\",\"dt\":\"2010-07-21T17:29:28\",\"consignee\":\"aaaa\",\"bank\":\"001\",\"ems\":\"0\"}]";
		JSONArray jsonArray = JSONArray.fromObject(str);
		System.err.println(jsonArray);
		
		/* 前台通过var rows = $('#tt').datagrid('getRows')对象转为json var json = JOON.stringify(rows);
		 * 后过取得json字符串后转换为json数组 JSONArray.fromObject(json) 通过方法jsonObect.toBean(jsonObect, Items.class);生成对象
		 * 
		 */
		/*String strJson = "[{\"id\":\"\",\"num\":\"\",\"dt\":\"2010-07-21T17:29:28\",\"consignee\":\"aaaa\",\"bank\":\"001\",\"ems\":\"0\"}]";
		JSONArray jsonArray = JSONArray.fromObject(strJson);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Items items = (Items) JSONObject.toBean(jsonObject, Items.class);
			System.err.println(items);
		}*/
	}
}
