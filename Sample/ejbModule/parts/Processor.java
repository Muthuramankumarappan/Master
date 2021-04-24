package parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Processor {

	
	GateInterface logicGates;
	
	public GateInterface getLogicGates() {
		return logicGates;
	}
	
	@Autowired
	public Processor(
			@Qualifier("notGate") GateInterface logicGates) {
		this.logicGates = logicGates;
	}


	public Resistor getResistor() {
		return resistor;
	}

	@Autowired
	public void setResistor(Resistor resistor) {
		this.resistor = resistor;
	}

	
	Resistor resistor;
	
	public void makingProcessor() {
		System.out.println("Assembling processor with "+
				logicGates.getALogicGate() + " and an " +
				resistor.getResistor()
				);
	}
	
//	@PreDestroy
//	public void initializer() {
//		System.out.println("The Processor Manufacturing process is started");
//	}
//	
//	@PostConstruct
//	public void destroyer() {
//		System.out.println("Manufacturing is completed now cleaning process is initiated");
//	}
	
	
}
