class Utility {
	boolean running=true;
	public void setbool(boolean running) {
		this.running=running;
	}
	public boolean getbool() {
		return running;
	}
}

class Hare extends Utility implements Runnable {

	public void run() {

		for (int i = 1; i <= 100; i++) {
			running=getbool();
			if (running)
				System.out.println("hare: " + (i));
			else {
				break;
			}
			if (i == 60) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}

			if (i == 100) {
				setbool(false);
				System.exit(0);
			}

		}
	}
}

class Tortoise extends Utility implements Runnable {

	public void run() {

		for (int i = 1; i <= 100; i++) {
			running=getbool();
			if (running)
				System.out.println("tortoise: " + (i));
			else {
				break;
			}
		
			if (i == 100) {
				setbool(false);
				System.exit(0);
			}

		}

	}
}

public class Source {
	public static void main(String[] args) {

		Hare obj1 = new Hare();
		Tortoise obj2 = new Tortoise();

		Thread hare = new Thread(obj1);
		Thread tortoise = new Thread(obj2);
		hare.setPriority(Thread.MAX_PRIORITY);
		tortoise.setPriority(Thread.MIN_PRIORITY);
		hare.start();
		tortoise.start();
	}
}
