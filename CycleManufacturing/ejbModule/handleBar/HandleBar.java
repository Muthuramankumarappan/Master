package handleBar;

import bell.Bell;
import raw.HandleBarRawMaterial;
import raw.Iron;

public class HandleBar {

	HandleBarRawMaterial iron;
	
	Bell bell;
	
	public Bell getBell() {
		return bell;
	}

	public void setBell(Bell bell) {
		this.bell = bell;
	}

	// constructor injection
	public HandleBar(HandleBarRawMaterial iron) {
		System.out.println("Constructor...");
		this.iron = iron;
	}
	
	
	public void createHandleBar() {
		System.out.println("Handle Bar is maded of Iron");
	}
	
	public void init() {
		System.out.println("After constructor is initialized");
	}
	
	public void destroy() {
		System.out.println("Destroyed...");
	}
	
}
