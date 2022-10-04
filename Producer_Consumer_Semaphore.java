import java.util.concurrent.Semaphore;
class Producer_Consumer {
	int item;
	static Semaphore sem_Consumer = new Semaphore(0);
	static Semaphore sem_Producer = new Semaphore(1);

	void get(){
		try {
			sem_Consumer.acquire();
		}
		catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		System.out.println("Item consumed by Consumer : " + item);
		sem_Producer.release();
	}

	void put(int item){
		try {
			sem_Producer.acquire();
		}
		catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}
		this.item = item;

		System.out.println("Item produced by Producer : " + item);
		sem_Consumer.release();
	}
}
