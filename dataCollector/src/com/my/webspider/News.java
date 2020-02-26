/**   
 *@Description:   新闻类网站新闻内容  
 */   
package com.my.webspider;    
  
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.httpclient.HttpException;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

    
public class News extends CrawlBase{  
	
	  private static Logger log = Logger.getLogger(News.class);  
	  
/** 
 * 添加相关头信息，对请求进行伪装 
 */  
  private static HashMap<String, String> params;  
  static {  
      params = new HashMap<String, String>();  
      params.put("Referer", "http://news.163.com");  
      params.put("Host", "news.163.com");  
      params.put("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36");  
      params.put("Cookie", "_ntes_nuid=1961512a9aee71d3a210dccb37ead58d; __utma=187553192.1431541210.1506701704.1506709358.1506712766.4; _ga=GA1.2.1431541210.1506701704; _ntes_nnid=1961512a9aee71d3a210dccb37ead58d,1548182898834; __gads=ID=57f7ced4e38b9652:T=1548182900:S=ALNI_MYyWYPiD_8SDLU5QyfecuoFrOju1A; __oc_uuid=b015bab0-6b5f-11e9-985a-31f150ae55f6; ne_analysis_trace_id=1566682180960; _antanalysis_s_id=1566682181842; UM_distinctid=16cc588f173af0-0389c7d5e773fd-178123e-144000-16cc588f17446b; CNZZDATA5664242=cnzz_eid%3D2008988634-1566678163-https%253A%252F%252Fnews.163.com%252F%26ntime%3D1566678163; CNZZDATA1253166323=782253856-1566682173-%7C1566682173; CNZZDATA1253186237=659519763-1566677817-%7C1566677817; CNZZDATA5896544=cnzz_eid%3D824774518-1566679650-%26ntime%3D1566679650; CNZZDATA1271027176=938224891-1566680745-%7C1566680745; CNZZDATA5850731=cnzz_eid%3D781625199-1566681910-%26ntime%3D1566681910; NNSSPID=1a7570162fa24cc79bb554034e3cd8da; CNZZDATA5683791=cnzz_eid%3D478873985-1566677507-%26ntime%3D1566677507; CNZZDATA1257114097=737228749-1566677957-%7C1566677957; CNZZDATA5654468=cnzz_eid%3D1987794114-1566678647-%26ntime%3D1566678647; Province=0; City=0; WM_NI=yAsPIzGr9K0evp7FI1agYMAqbZLpjJJiRXJes6Ac0izaqMln12rkmdSQDFIjyne%2BeutQdq1lzJGIN5htUfH%2BF3qF%2B7Tss4se8cc3hO%2FVDLdpmV1iFbvmpbtYx37QB64GSUc%3D; WM_NIKE=9ca17ae2e6ffcda170e2e6eeb7aa4497a6f784ca53a1868ba3c55f929a9aafb8408d9aa288e2528698baa3db2af0fea7c3b92abb9fbdb1cc7285aef7acb36fb6b0f9a7cc3ba3b997aec47ba2868491e9428ab79eb9c96fb1ea8f84b363babfbfaeef66f3eebe8cf070918f8ca7cc62bbb2abcce87fb88fac92b468ba9689aacd3facac9b87cb2186edbfa7aa3d98adbdd5f26ffcbdadd4eb45ed8a8cade77caf8aff8ac56ab6b3c083f753bcedf9b2c13ef8999db6e237e2a3; WM_TID=3YTnRvjT3u9BQQEVUFN48ORngMIAT%2FQX; CNZZDATA5954595=cnzz_eid%3D2001987119-1566681875-%26ntime%3D1566681875; CNZZDATA5955239=cnzz_eid%3D559609292-1566677959-%26ntime%3D1566677959; vinfo_n_f_l_n3=2de52c61db743cf1.1.2.1548182898844.1566682231806.1566685840457; s_n_f_l_n3=2de52c61db743cf11566685840457");
  }  
	private String title;
	private String type;  
    private String comment;  
    private String time;  
    private String publish;  
    private String url;

    public News(String type, String url) {  
    	this.time = "";
    	this.comment = "0";
    	this.publish = "";
    	this.title = "";
        this.type= type;  
        this.url = url;
        try {   
	       	readPageByGet(url, "utf-8", params);  
	        parse(getPageSourceCode());
	        //setContent();  
	        persistToFile(this);  
        } catch (Exception e) {
        	log.info(e);
        }
    }   
     
    private void persistToFile(News news) throws Exception {
    	File file = new File(FileOutPathHelper.fileOutPath); // 相对路径，如果没有则要建立一个新的output。txt文件
		if(!file.exists())
			file.createNewFile(); // 创建新文件
	    // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件   
        FileWriter writer = new FileWriter(file, true);  
        //writer.write(news.toString()+"\n");  
        //writer.close();   
        new WritingToHDFS().putFileToHDFS(file); 
	}

	private void parse(String htmlSource) throws HttpException, IOException {
    	Document html = Jsoup.parse(htmlSource);
    	
    	Elements divEles = html.getElementsByClass("post_content_main");
    	if (divEles.size() == 1) { // if it is not empty (it is exist)
	    	Element bigdivEle = divEles.get(0); // bigdiv element contains title time and source of publish
	    	Elements title_h1_eles = bigdivEle.getElementsByTag("h1");
	    	
	    	if (title_h1_eles.size() == 1) {
	    		setTitle(title_h1_eles.get(0).text());
	    	}
	    	
	    	Elements time_source_divEles = bigdivEle.getElementsByClass("post_time_source");
	    	if (time_source_divEles.size() == 1) {
	    		Element time_source_divEle = time_source_divEles.get(0);
		    	String innerHTML = time_source_divEle.text();
		    	String [] time_ = innerHTML.split("来源");
		    	setTime(time_[0]);
		    	
		    	Element sourceEle= time_source_divEle.getElementById("ne_article_source");
		    	setPublish(sourceEle.text());
	    	}
	    }
		setComment(htmlSource);
    }
    
    private void setTitle(String titile) {
    	this.title = titile;
    }
    
    private void setComment(String htmlSource) throws HttpException, IOException {
    	int start_i_PK = htmlSource.indexOf("productKey"); // start index of productKey
    	int index_eol_PK = htmlSource.indexOf(",", start_i_PK);
    	String lineOfPK = htmlSource.substring(start_i_PK, index_eol_PK);
    	
    	int start_i_ID= htmlSource.indexOf("docId",index_eol_PK); // start index of news id / document id
    	int index_eol_ID = htmlSource.indexOf(",", start_i_ID);
    	String lineOfID = htmlSource.substring(start_i_ID, index_eol_ID);
    	
    	String docId = getStringFromQuatation(lineOfID.split(":")[1]); 
    	String productKey = getStringFromQuatation(lineOfPK.split(":")[1]);
    	
    	params.put("ContentType", "application/json");  
    	//// page source have changed! within this if-statement!
    	if (!readPageByGet(CmtCountHelper.getNewsCommentsApi(productKey, docId), "utf-8")) { // if failed to get comment, give zero as result
    		this.comment = "0";
    	} else {
    		String jsons = getPageSourceCode();
    		JsonObject json = (JsonObject) new JsonParser().parse(jsons);
			Object cmt = json.get("cmtCount");
			this.comment = ""+cmt;
    	}
	}
    
  
    private String getStringFromQuatation(String docId_) {
    	int start_q = docId_.indexOf("\"");
    	int end_q = docId_.lastIndexOf("\"");
    	return docId_.substring(start_q+1,end_q); 
    }
    
	private void setTime(String time) {
		int index_co = time.indexOf(":");
		int end = time.lastIndexOf(":");
		if (index_co == -1) { // no : 
			// do nothing
		}  else if (index_co == end) { // 12:12
			this.time = time;
		}  else if (index_co != end) { // 12:12:23
			this.time = time.substring(0,end);
		} 
	}


	private void setPublish(String publish) {
		this.publish = publish;
	}
	
	@Override
	public String toString() {
		return title+","+type+","+comment+","+time+",,"+publish+","+url;
	}

    /** 
     * @Description: test case 
    @Test  
    public static void main(String[] args) throws HttpException, IOException {  
        // TODO Auto-generated method stub    
        News news = new News("guo","https://news.163.com/19/0823/09/EN8LOM0P0001899N.html");  
    }  
  */ 
}  