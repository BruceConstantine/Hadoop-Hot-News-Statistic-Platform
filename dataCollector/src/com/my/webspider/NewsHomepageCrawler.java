package com.my.webspider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.junit.Test;

public class NewsHomepageCrawler extends CrawlBase {

	private ArrayList<String> type = new ArrayList<String>();
	
    /**
     * @author zhikang tian
     * @return void. Here should defined the business logic for processing the 163 news home page.
     * @throws IOException
     */
    public void run() throws IOException {
    	String pageurl = "http://news.163.com/rank/";  
        if ( readPageByGet(pageurl, "utf-8", null) ) {  
	        /*
	        write(pageSourceCode);
	        read();  
	        */ 
	        String htmlSource = getPageSourceCode();
	        getTypes(htmlSource);
	        parse(htmlSource);
        }
        
    }  

    /**
     * @return void Defined the process for paring raw HTML code for getting the news type on the home page
     * @param htmlSource
     */
    private void getTypes(String htmlSource) {
    	//int count = 0;
    	Document html = Jsoup.parse(htmlSource);
    	Elements types_divEles = html.getElementsByClass("titleBar");
    	int length = types_divEles.size();
    	for(int i=0; i<length; i++) {			
    		Element divEle = types_divEles.get(i);
    		Elements h2Eles = divEle.getElementsByTag("h2"); // obviously only one type tage here
    		if ( !h2Eles.isEmpty()) {	
    			Element type_h2 = h2Eles.get(0);
    			if (i<TypeConst.type_boundary_index_start || i>=TypeConst.type_boundary_index_end) {	// 0-全站   1-新闻//17(length-2)-视频 18(length-1)-移动 -> do not handle this type of news / will get down those news  
    				type.add("");
    			} else {
    				type.add(type_h2.text());
				}
    			//System.out.println(type.get(count++));
    		}
    	}
    }

    /**
     * @return void. Defining the details for getting all type of news link URLs on the news homepage
     * @param htmlSource
     */
    private void parse(String htmlSource) {
    	Document html = Jsoup.parse(htmlSource);
    	Elements types_divEles = html.getElementsByClass("titleBar");
    	int length = types_divEles.size();
    	for(int i=TypeConst.type_boundary_index_start ; i<TypeConst.type_boundary_index_end; i++) {	
    		if(type.get(i).equals("女人")) {} //do nothing
    		else {
	    		String [] urlList = getNewsLinksArr(types_divEles.get(i));
	    		for (String url : urlList) {
	    			try {
						News aNews = new News(type.get(i), url);
					} catch (Exception e) {
						e.printStackTrace();
					} 
	    			//System.out.println(url);
	    		}
			}
		}
    }
    
    /**
     * @param String[] URLStringArray. return the URLs on one type of table
     * @return
     */
    private String[] getNewsLinksArr(Element div) {
    	ArrayList<String> urls = new ArrayList<String>();

    	Element bigdiv = div.nextElementSibling().nextElementSibling(); //月排行
    	Elements aEles = bigdiv.select("div>div>div>table>tbody>tr>td>a");
    	for (Element a : aEles) {
    		String url = a.attr("href");
    		urls.add(url);
    	}
    	
    	return urls.toArray(new String[urls.size()]);
    }
        
}
