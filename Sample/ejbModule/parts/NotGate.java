package parts;

import org.springframework.stereotype.Component;

@Component
public class NotGate implements GateInterface {

	@Override
	public String getALogicGate() {
		// TODO Auto-generated method stub
		return "Not Gate";
	}

}
