public class Main implements Runnable {
    @Override
    public void run() {
        print(Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        new Thread(new Main()).start();
        new Thread(new Main()).start();
    }

    synchronized void print(long id) {
        System.out.println(id + "a");
        System.out.println(id + "b");
    }
}

// Вывод 7а 7b 8a 8b и 7а 8a 7b 8b возможен, потому что System.out не потокобезопасен.
// Вывод 7а 8b 7b 8а невозможен, потому что print синхронизирован