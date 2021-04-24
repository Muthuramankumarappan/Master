package parts;

import org.springframework.stereotype.Component;

@Component
public class AndGates implements GateInterface{

	
	public String getALogicGate() {
		return "AndGate";
	}
}
