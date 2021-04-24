package Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Config.Config;
import parts.Processor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);
		Processor process = context.getBean("chip",Processor.class);
		process.makingProcessor();
		context.close();
	}

}
