package org.example;

public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        var thread = Thread.startVirtualThread(() -> {
            System.out.println("Inside virtual thread: " + Thread.currentThread());
            Thread newThread = new Thread(() -> {
                System.out.println("Inside new thread: " + Thread.currentThread());
            });
            newThread.start();
        });
        thread.join();
    }
}