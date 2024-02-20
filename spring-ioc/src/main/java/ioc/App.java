package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		ProductService productService = ctx.getBean(ProductService.class);
		
		productService.신규상품등록();
		productService.상품상세조회();
		productService.상품정보수정();
	}
}
