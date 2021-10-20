package Test;

public class Printer {
	boolean isOdd = false;
	
	synchronized void printEven(int number) {
		while(isOdd == false) {
			try {
				wait();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Even : "+ number);
		isOdd = false;
		notifyAll();
	}
	
	synchronized void printOdd(int number) {
		while(isOdd == true) {
			try {
				wait();
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("Odd : "+ number);
		isOdd = true;
		notifyAll();
	}

}
