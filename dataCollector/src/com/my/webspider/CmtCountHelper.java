package com.my.webspider;

public class CmtCountHelper {
	public static String getNewsCommentsApi(String productKey, String docId) {
		return "http://comment.news.163.com/api/v1/products/"+productKey+"/threads/"+docId;
	}
}
