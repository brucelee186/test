package tool.getpr;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class GooglePageRank {

	// google pagerank������ip��ַ�б?���googleС���˺ܶ࣬������ѯһ����ip��
	final static String[] GoogleServiceIP = new String[] { "64.233.161.100",
			"64.233.161.101", "64.233.183.91", "64.233.189.44", "66.102.1.103",
			"66.102.9.115", "66.249.89.83", "66.249.91.99", "66.249.93.190" };

	// google��ʶ����
	final static private int GOOGLE_MAGIC = 0xE6359A60;

	// ch��ֵ�����
	private class CHMix {

		int a;

		int b;

		int c;

		public CHMix() {
			this(0, 0, 0);
		}

		public CHMix(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	/**
	 * ��googleҪ���ϳ�ch���
	 * 
	 * @param mix
	 */
	private static void mix(final CHMix mix) {
		mix.a -= mix.b;
		mix.a -= mix.c;
		mix.a ^= mix.c >> 13;
		mix.b -= mix.c;
		mix.b -= mix.a;
		mix.b ^= mix.a << 8;
		mix.c -= mix.a;
		mix.c -= mix.b;
		mix.c ^= mix.b >> 13;
		mix.a -= mix.b;
		mix.a -= mix.c;
		mix.a ^= mix.c >> 12;
		mix.b -= mix.c;
		mix.b -= mix.a;
		mix.b ^= mix.a << 16;
		mix.c -= mix.a;
		mix.c -= mix.b;
		mix.c ^= mix.b >> 5;
		mix.a -= mix.b;
		mix.a -= mix.c;
		mix.a ^= mix.c >> 3;
		mix.b -= mix.c;
		mix.b -= mix.a;
		mix.b ^= mix.a << 10;
		mix.c -= mix.a;
		mix.c -= mix.b;
		mix.c ^= mix.b >> 15;
	}

	/**
	 * ���ch��ֵ�����
	 * 
	 * @return
	 */
	public static CHMix getInnerCHMix() {
		return new GooglePageRank().new CHMix();
	}

	/**
	 * ͨ��url���googlech(google��ݿ����ҳ���ȫ��Ψһ��ʶ)
	 * 
	 * @param url
	 * @return
	 */
	public static String GoogleCH(final String url) {
		// ��ʽ��ΪgoogleҪ���info:urlģʽ
		String nUrl = String.format("info:%s", new Object[] { url });
		// �����url�ַ��ʽ
		char[] urls = nUrl.toCharArray();
		// �����url����
		int length = urls.length;

		// ���һ��ch��ֵ�����
		CHMix chMix = GooglePageRank.getInnerCHMix();
		// Ϊcע��googleʶ���ʶ
		chMix.c = GOOGLE_MAGIC;

		// Ϊa��b��ע��googleҪ��ĳ�ʼ��ʶ
		chMix.a = chMix.b = 0x9E3779B9;

		int k = 0;

		int len = length;

		while (len >= 12) {

			chMix.a += (int) (urls[k + 0] + (urls[k + 1] << 8)
					+ (urls[k + 2] << 16) + (urls[k + 3] << 24));
			chMix.b += (int) (urls[k + 4] + (urls[k + 5] << 8)
					+ (urls[k + 6] << 16) + (urls[k + 7] << 24));
			chMix.c += (int) (urls[k + 8] + (urls[k + 9] << 8)
					+ (urls[k + 10] << 16) + (urls[k + 11] << 24));
			// ��û�����������
			GooglePageRank.mix(chMix);
			k += 12;
			len -= 12;
		}
		chMix.c += length;

		// ����googlech��11λ��ʶ
		switch (len) {
		case 11:
			chMix.c += (int) (urls[k + 10] << 24);
		case 10:
			chMix.c += (int) (urls[k + 9] << 16);
		case 9:
			chMix.c += (int) (urls[k + 8] << 8);
		case 8:
			chMix.b += (int) (urls[k + 7] << 24);
		case 7:
			chMix.b += (int) (urls[k + 6] << 16);
		case 6:
			chMix.b += (int) (urls[k + 5] << 8);
		case 5:
			chMix.b += (int) (urls[k + 4]);
		case 4:
			chMix.a += (int) (urls[k + 3] << 24);
		case 3:
			chMix.a += (int) (urls[k + 2] << 16);
		case 2:
			chMix.a += (int) (urls[k + 1] << 8);
		case 1:
			chMix.a += (int) (urls[k + 0]);
			break;
		default:
			break;
		}
		// ��û�����������
		GooglePageRank.mix(chMix);
		// ���δ�޶���CH
		String tch = String.valueOf(chMix.c);
		// �����ֵ������ȷCH
		return String
				.format("6%s", new Object[] { tch.length() < 10 ? ("-" + tch)
						.intern() : tch });
	}

	/**
	 * ����ƥ��pagerank���
	 * 
	 * @param value
	 * @return
	 */
	private static String MatchRank(final String value) {
		Pattern pattern = Pattern.compile("Rank_1:[0-9]:([0-9]+)");
		Matcher matcher = pattern.matcher(value);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return "0";
	}

	/**
	 * ���ָ��ҳ���google pagerankֵ
	 * 
	 * @param url
	 * @return
	 */
	public static String GooglePR(final String url) {
		String rip = GoogleServiceIP[new Random()
				.nextInt(GoogleServiceIP.length)];
		return GooglePR(url, rip);
	}

	/**
	 * ��ָ����google���������ָ��ҳ���google pagerankֵ
	 * 
	 * @param url
	 * @param ip
	 * @return
	 */
	public static String GooglePR(final String url, final String ip) {
		// �����ѯ��Ψһ��ʶ
		String checksum = GoogleCH(url);
		// �����ѯ��url
		String queryUrl = String
				.format(
						"http://%s/search?client=navclient-auto&ch=%s&features=Rank&q=info:%s",
						new Object[] { ip, checksum, url });

		String response;
		try {
			response = SimpleWebClient.getRequestHttp(queryUrl);
		} catch (IOException e) {
			response = "";
		}
		if (response.length() == 0) {
			return "0";
		} else {
			return GooglePageRank.MatchRank(response);
		}
	}

}
