package com.practice.java8;

/*
Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization 
of CPU. Each part of such program is called a thread. So, threads are light-weight processes within a process.

Threads can be created by using two mechanisms : 

Extending the Thread class :- 
Implementing the Runnable Interface
Thread creation by extending the Thread class
We create a class that extends the java.lang.Thread class. This class overrides the run() method available in the Thread class. 
A thread begins its life inside run() method. We create an object of our new class and call start() method to start the execution 
of a thread. Start() invokes the run() method on the Thread object.

Thread creation by implementing the Runnable Interface :-
We create a new class which implements java.lang.Runnable interface and override run() method. Then we instantiate a Thread object 
and call start() method on this object. 
*/

class ExtendThreadDemo extends Thread {
	
	@Override
	public void run() {
		try {
			synchronized(ExtendThreadDemo.class) {
				System.out.println("Thread " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName() + " is running.");
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			System.out.println("Exception caught at " + Thread.currentThread().getId());
		}
	}
}

class RunnableDemoImpl implements Runnable {

	@Override
	public void run() {
		try {
			synchronized(RunnableDemoImpl.class) {
				System.out.println("Thread " + Thread.currentThread().getId() + "/" + Thread.currentThread().getName() + " is running.");
				Thread.sleep(1000);
			}
		} catch (Exception ex) {
			System.out.println("Exception caught at " + Thread.currentThread().getId());
		}
	}
}

class DeadlockDemo1 implements Runnable {

	@Override
	public void run() {
		synchronized (String.class) {
			System.out.println("String class locked at thread :: " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
				synchronized (Integer.class ) {
					System.out.println("Integer class locked at thread :: " + Thread.currentThread().getName());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class DeadlockDemo2 implements Runnable {

	@Override
	public void run() {
		synchronized (Integer.class) {
			System.out.println("Integer class locked at thread :: " + Thread.currentThread().getName());
			synchronized (String.class ) {
				System.out.println("String class locked at thread :: " + Thread.currentThread().getName());
			}
		}
	}
}

public class Multithreads {

	public static void main(String[] args) throws InterruptedException {
		new ExtendThreadDemo().start();
		
		Thread runnableThread = new Thread(new RunnableDemoImpl());
		runnableThread.start();
		
		// Deadlock demo; execution will need to be aborted manually
		Thread thread1 = new Thread(new DeadlockDemo1());
		Thread thread2 = new Thread(new DeadlockDemo2());
		thread1.start();
		thread2.start();
	}

}
