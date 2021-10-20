package Test;

public class TaskEvenOdd implements Runnable {

	private int max;
	private Printer printer;
	private boolean isEvenNumber;
	
	public TaskEvenOdd(Printer printer,int max, boolean isEvenNumber) {
		// TODO Auto-generated constructor stub
		this.printer = printer;
		this.max = max;
		this.isEvenNumber = isEvenNumber;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int number = isEvenNumber ? 2: 1;
		
		while(number <= max) {
			if(isEvenNumber) {
				printer.printEven(number);
			}else {
				printer.printOdd(number);
			}
			number+=2;
		}

	}

}
