package tool.jsoup;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestJsout {

	static String url = "http://www.tekkenzaibatsu.com/tekken6/movelist.php?id=kuma";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		String html = "<html><head><title> 开源中国社区 </title></head>"
//				+ "<body><p> 这里是 jsoup 项目的相关文章 </p></body></html>";
//		Document doc1 = Jsoup.parse(html);
//		System.out.println(doc1.body());

		try {
			//Document doc1 = Jsoup.connect(url).get();
			
			File in = new File("F:/移动/t6/movelist/Kuma Tekken 6 Move List - Tekken Zaibatsu.html");
			Document doc = Jsoup.parse(in, "UTF-8", ""); 
			//System.err.println(doc.body());
			 Elements title = doc.select("h1");
			 // <div id="rightcol">
			 //System.err.println(title);
			 
//			 
//			 MoveList moveList = new MoveList();
//			 moveList.setName(nameRole);
			 
			 Map<String, String> mapRemark = new HashMap<String, String>();
			 String properties;
			 
			 Elements ElementsFootnotes = doc.select("div#rightcol > div#footnote");
			 System.err.println(ElementsFootnotes);
			 
			 // 取得arts名
			 MoveList moveList = new MoveList();
			 String arts = "";
			
			 List<MoveList> listMove = new ArrayList<MoveList>();
			 
			 Elements contentNameRole = doc.select("div#crumbs > * > *:eq(3)");
			 String nameRole = contentNameRole.text();
			 
			 Elements elements = doc.select("div#rightcol > div");
//			 Elements elements = doc.select("div#rightcol > div.outerbox");
			 for (int i = 0; i < elements.size(); i++) {
				 Element element = elements.get(i);
				 Elements elementArts = element.select("h2");
				 
				 Elements elementsDivById = element.select("div#footnote");
				 Elements elementsDivByClass = element.select("div.outerbox");
				 if (elementsDivByClass.size() == 1) {
					 System.err.println(elementsDivByClass);
					 arts = elementArts.text();
					 
//				 moveList.setNameRole(nameRole);
//				 System.err.println(nameRole);
					 Elements elementsTableRow = element.select("tr");
					 for (int j = 1; j < elementsTableRow.size(); j++) {
						 Element elementTableRow = elementsTableRow.get(j);
//					Elements elementsTableDate = elementTableRow.select("td");
						 Elements elementsTableDateCommand = elementTableRow.select("td:eq(0)");
						 Elements elementsTableDateMoveName = elementTableRow.select("td:eq(1)");
						 Elements elementsTableDateStance = elementTableRow.select("td:eq(2)");
						 Elements elementsTableDateDamage = elementTableRow.select("td:eq(3)");
						 Elements elementsTableDateHitRange = elementTableRow.select("td:eq(4)");
						 Elements elementsTableDateProperties = elementTableRow.select("td:eq(5)");
						 
						 moveList = new MoveList();
						 moveList.setNameRole(nameRole);
						 moveList.setArts(arts);
						 moveList.setCommand(elementsTableDateCommand.text());
						 moveList.setName(elementsTableDateMoveName.text());
						 moveList.setStance(elementsTableDateStance.text());
						 moveList.setDamage(elementsTableDateDamage.text());
						 moveList.setHitRange(elementsTableDateHitRange.text());
						 moveList.setProperties(elementsTableDateProperties.text());
						 
						 listMove.add(moveList);
						 System.err.println(moveList);
						 /*for (int k = 0; k < elementsTableDate.size(); k++) {
						Element elementTableDate = elementsTableDate.get(k);
						System.err.println(elementTableDate);
						
					}*/
					 }
					 
				 } 
				 // 当循环为备注时,把本次的备注加入到之前的list的bean中
				 if (elementsDivById.size() == 1) {
					 // 取得list中的最后一个bean
					 MoveList moveListTemp = new MoveList();
					 moveListTemp = listMove.get(listMove.size() - 1);
					 System.err.println(moveListTemp);
					 System.err.println(elementsDivById);
				 }
				 
			 }
			 
			 //System.err.println(nameRole);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
