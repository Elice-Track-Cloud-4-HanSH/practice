package d01;

import java.util.*;

public class Eratostenes {
    private final static int MAX_NUM = 99999;
    private final static int THREAD_NUM = 16;
    private final static int MAX_RANDOM_NUMS = 8000;

    public static class EratostenesResult {
        public boolean[] isPrime;
        public long realCounter;
        public long counter;

        EratostenesResult(boolean[] isNotPrime, long realCounter, long counter) {
            this.isPrime = isNotPrime;
            this.realCounter = realCounter;
            this.counter = counter;
        }
    }

    public static class DevideResult {
        public long counter;
        public boolean isPrime;

        public DevideResult(long counter, boolean isPrime) {
            this.counter = counter;
            this.isPrime = isPrime;
        }
    }
    public static void main(String[] args) {
        EratostenesResult eratostenes = eratostenesCalculator(THREAD_NUM);
        long devideCounter = 0;
        long eratostenesCounter = 0;
        int diffCounter = 0;
        int counter = 0;

        for (int num : generateRandom10000()) {
            counter++;
            DevideResult devideResult = devideCalculator(num);
            if (devideResult.isPrime != eratostenes.isPrime[num]) {
                diffCounter++;
            }
            eratostenesCounter++;
            devideCounter += devideResult.counter;
        }

        System.out.println(diffCounter);

        System.out.printf("만들어진 표를 이용하여 소수 계산: %,d\n", counter);

        System.out.printf("에라토스테네스의 체 계산: %,d\n", eratostenesCounter + eratostenes.counter);
        System.out.printf("에라토스테네스의 체 계산(real): %,d\n", eratostenesCounter + eratostenes.realCounter);

        System.out.printf("나머지로 계산한 경우: %,d\n", devideCounter + counter);
    }

    static class EratostenesThreadTask extends Thread {
        private final boolean[] isPrime;
        private final int start;
        private final int end;
        private final int sqrtN;
        private long realCounter = 0;
        private long counter = 0;

        public EratostenesThreadTask(boolean[] isPrime, int start, int end, int sqrtN) {
            this.isPrime = isPrime;
            this.start = start;
            this.end = end;
            this.sqrtN = sqrtN;
        }

        @Override
        public void run() {
            for (int i = 2; i <= sqrtN; i++) {
                realCounter++;
                if (!isPrime[i]) continue;
                for (int j = Math.max(i * 2, start + (i - start % i) % i); j <= end; j += i) {
                    isPrime[j] = false;
                    counter++;
                }
            }
        }

        public long getRealCounter() { return realCounter; }
        public long getCounter() { return counter; }
    }

    public static EratostenesResult eratostenesCalculator(int threadNum) {
        boolean[] isPrime = new boolean[MAX_NUM+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        long totalRealCounter = 0;
        long totalCounter = 0;

        int sqrtN = (int) Math.sqrt(MAX_NUM);
        EratostenesThreadTask[] tasks = new EratostenesThreadTask[threadNum];
        int range = MAX_NUM / threadNum;

        for (int i = 0; i < threadNum; i++) {
            int start = i * range + 1;
            int end = (i == threadNum - 1) ? MAX_NUM : (i + 1) * range;

            tasks[i] = new EratostenesThreadTask(isPrime, start, end, sqrtN);
            tasks[i].start();
            System.out.println("eratostenes task[" + i + "] started");
        }

        for (EratostenesThreadTask task: tasks) {
            try {
                task.join();
                totalRealCounter += task.getRealCounter();
                totalCounter += task.getCounter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("all eratostenes tasks ended");

        return new EratostenesResult(isPrime, totalRealCounter + totalCounter, totalCounter);
    }

    public static DevideResult devideCalculator(int N) {
        if (N == 0 || N == 1) return new DevideResult(0, false);

        int sqrtN = (int) Math.sqrt(N);
        boolean isPrime = true;
        int counter = 1;
        for (int i = 2; i <= sqrtN; i++) {
            counter++;
            if (N % i == 0) {
                isPrime = false;
                break;
            }
        }

        return new DevideResult(counter, isPrime);
    }

    public static List<Integer> generateRandom10000() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Random random = new Random();

        while (uniqueNumbers.size() < MAX_RANDOM_NUMS) {
            int randomNumber = random.nextInt(MAX_NUM) + 1;
            uniqueNumbers.add(randomNumber);
        }

        return uniqueNumbers.stream().toList();
    }
}
