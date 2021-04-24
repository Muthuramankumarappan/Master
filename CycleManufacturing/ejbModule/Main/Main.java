package Main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("xmlConfig/Config.xml");
		System.out.println(context.getBean("handleBar"));
		context.close();
	}

}
