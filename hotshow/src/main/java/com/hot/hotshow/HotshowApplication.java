package com.hot.hotshow;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hot.hotshow.mapper")
public class HotshowApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotshowApplication.class, args);
	}

}
