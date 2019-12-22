package tool.getpr;

/**
 * Copyright 2008
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * @project loonframework
 * @author chenpeng
 * @email��ceponline@yahoo.com.cn
 * @version 0.1
 */
public class Test {

	public static void main(String[] args) {

		WebAppraise appraise = new WebAppraise("www.taobao.com");

		 System.out.println("GooglePagerRankֵ��" + appraise.getGooglePR());
		 System.out.println("google��¼��" + appraise.getGoogleSite());
		 System.out.println("google������¼��" + appraise.getGoogleSite(true));
		 System.out.println("yahoo��¼��" + appraise.getYahooSite());
		 System.out.println("yahoo������¼��" + appraise.getYahooSite(true));
		 System.out.println("baidu��¼��" + appraise.getBaiduSite());
		 System.out.println("baidu������¼��" + appraise.getBaiduSite(true));
		 System.out.println("msn��¼��" + appraise.getMsnSite());
		 System.out.println("msn������¼��" + appraise.getMsnSite(true));
		 System.out.println("AllTheWeb��¼��" + appraise.getAllTheWebSite());
		 System.out.println("AllTheWeb������¼��" + appraise.getAllTheWebSite(true));
		 System.out.println("AltaVista��¼��" + appraise.getAltaVistaSite());
		 System.out.println("AltaVista������¼��" + appraise.getAltaVistaSite(true));
		 
	}
}
