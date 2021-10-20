package Test;

import java.util.UUID;

public class UUIDExample {
	
	public static void main(String[] args) {
		UUID uUuid = UUID.randomUUID();
		System.out.println(uUuid);
		uUuid = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");
		UUID uUuid1 = UUID.fromString("5289df73-7df5-3326-bcdd-22597afb1fac");
		System.out.println(uUuid.version());
		System.out.println(uUuid1.version());
		System.out.println(uUuid.variant());
		System.out.println(uUuid1.node());
		
		
	}

}
