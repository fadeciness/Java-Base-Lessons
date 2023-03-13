package com.github.fadeciness.lesson6.homework.refactored;

public class ParallelThreadImplementation extends AbstractThreadImplementation {

    @Override
    public void execute() {
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        halfsOfArr(a1, a2);

        Thread th1 = createLeftHalfThread(a1);
        Thread th2 = createRightHalfThread(a2);
        th1.start();
        th2.start();
        join(th1, th2);

        mergeHalfsOfArr(a1, a2);
    }

    private void halfsOfArr(float[] dst1, float[] dst2) {
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, dst1, 0, HALF);
        System.arraycopy(arr, HALF, dst2, 0, HALF);
        long end = System.currentTimeMillis();
        System.out.println("Время разбивки массива arr: " + (end - start) + " ms");
    }

    private Thread createLeftHalfThread(float[] a1) {
        return new Thread(() -> {
            long startTh1 = System.currentTimeMillis();
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5.0f) * Math.cos(0.2f + i / 5.0f) *
                        Math.cos(0.4f + i / 2.0f));
            }
            long endTh1 = System.currentTimeMillis();
            System.out.println("Время выполнения первого потока: " + (endTh1 - startTh1) + " ms");
        });
    }

    private Thread createRightHalfThread(float[] a2) {
        return new Thread(() -> {
            long startTh2 = System.currentTimeMillis();
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + HALF) / 5.0f) * Math.cos(0.2f + (i + HALF) / 5.0f) *
                        Math.cos(0.4f + (i + HALF) / 2.0f));
            }
            long endTh2 = System.currentTimeMillis();
            System.out.println("Время выполнения первого потока: " + (endTh2 - startTh2) + " ms");
        });
    }

    private void join(Thread... threads) {
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void mergeHalfsOfArr(float[] src1, float[] src2) {
        long start = System.currentTimeMillis();
        System.arraycopy(src1, 0, arr, 0, HALF);
        System.arraycopy(src2, 0, arr, HALF, HALF);
        long end = System.currentTimeMillis();
        System.out.println("Время обратной склейки массивов: " + (end - start) + " ms");
    }

}
