package com.my.webspider;

import java.io.IOException;

public class Run {
    public static void main(String[] args) throws IOException {     
    	NewsHomepageCrawler webSpider = new NewsHomepageCrawler();
    	webSpider.run();
    }
}
