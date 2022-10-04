import java.util.concurrent.Semaphore;
class ReaderWritersProblem {

    static Semaphore readLock = new Semaphore(1);
    static Semaphore writeLock = new Semaphore(1);
    volatile static int readCount = 0;

    static class Read implements Runnable {
        @Override
        public void run() {
            try {
                readLock.acquire();
                synchronized(ReaderWritersProblem.class) {
                    readCount++;
                }
                if (readCount == 1) {
                    writeLock.acquire();
                }
                readLock.release();

                System.out.println("Thread "+Thread.currentThread().getName() + " is READING");
                Thread.sleep(1500);
                System.out.println("Thread "+Thread.currentThread().getName() + " has FINISHED READING");

                readLock.acquire();
                synchronized(ReaderWritersProblem.class) {
                    readCount--;
                }
                if(readCount == 0) {
                    writeLock.release();
                }
                readLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Write implements Runnable {
        @Override
        public void run() {
            try {
                writeLock.acquire();
                System.out.println("Thread "+ Thread.currentThread().getName() + " is WRITING");
                Thread.sleep(2500);
                System.out.println("Thread "+ Thread.currentThread().getName() + " has finished WRITING");
                writeLock.release();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
