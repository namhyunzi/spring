package com.sample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.service.UserService;
import com.sample.vo.User;

public class App {
	
	public static void main(String[] args) {
		// 스프링 컨테이너 생성
		// connectionPool, JdbcTemplate, UserDao, UserService 객체가 생성되었다.
		// UserService <-- UserDao <--JdbcTempate <-- ConnectionPool 가 조립이 완료되었다.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		UserService userService = ctx.getBean(UserService.class);
		userService.registerUser(new User("Kang", "zxcv1234", "강감찬", "010-1111-1111", "kang@gmail.com"));
	}
}
