package Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import parts.GateInterface;
import parts.NotGate;
import parts.Processor;

@Configuration
@ComponentScan("parts")
public class Config {
	
	@Bean("one")
	public NotGate getNot() {
		return new NotGate();
	}
	
	@Bean("two")
	public NotGate getSecondNot() {
		return new NotGate();
	}

	@Bean("simpleProcessor")
	@Autowired
	@Qualifier("two")
	public Processor simpleProcessor(NotGate notGate) {
		return new Processor(notGate);
	}
}
