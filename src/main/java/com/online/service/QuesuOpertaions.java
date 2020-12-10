package com.online.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.online.model.Queue;

@Component
public class QuesuOpertaions {

	@Autowired
	private Queue queue;

	List<Long> all = new ArrayList<Long>();

	protected static SecureRandom random = new SecureRandom();

	public List<Long> getAllTokens() {

		List<Long> token = new ArrayList<Long>();

		for (int i = 0; i < queue.SIZE; i++) {
			long generateToken = generateToken();

			long genToken = enQueue(generateToken);
			token.add(genToken);

		}

		return token;

	}

	public static long generateToken() {
		long longToken = Math.abs(random.nextLong());
		String random = Long.toString(longToken, 16);
		return (longToken);
	}

	public List<Long> removeQueueElements() {

		for (int i = 0; i <= 1; i++) {

			deQueue();
		}

		List<Long> display = display();
		return display;
	}

	/*
	 * This Method Helps To Insert Element in Queue.
	 * 
	 */
	public long enQueue(long generateToken) {
		queue.items = new long[queue.SIZE];

		// if queue is full
		if (queue.isFull()) {
			System.out.println("Queue is full");
		} else {
			if (queue.front == -1) {
				// mark front denote first element of queue
				queue.front = 0;
			}

			queue.rear++;
			// insert element at the rear
			queue.items[queue.rear] = generateToken;
			System.out.println("Insert " + generateToken);

		}
		return generateToken;
	}

	/*
	 * 
	 * This Method Helps to Remove Elements From Queue
	 * 
	 */
	public long deQueue() {
		long element = 0;

		// if queue is empty
		if (queue.isEmpty()) {
			System.out.println("Queue is empty");

		} else {
			// remove element from the front of queue
			element = queue.items[queue.front];

			// if the queue has only one element
			if (queue.front >= queue.rear) {
				queue.front = -1;
				queue.rear = -1;
			} else {
				// mark next element as the front
				queue.front++;
			}
			System.out.println(element + " Deleted");
			return (element);
		}

		return element;

	}

	/*
	 * 
	 * Display the Elements in Queue
	 * 
	 */
	public List<Long> display() {
		int i;

		if (queue.isEmpty()) {
			System.out.println("Empty Queue");
		} else {
			// display the front of the queue
			System.out.println("\nFront index-> " + queue.front);

			// display element of the queue
			System.out.println("Items -> ");
			for (i = queue.front; i <= queue.rear; i++) {
				System.out.print(queue.items[i] + "  ");

				all.add(queue.items[i]);
			}

			queue.items = new long[queue.SIZE];
			if (all.size() <= queue.min_size) {

				for (int j = 0; j < queue.SIZE - all.size(); j++) {

					queue.items[j] = all.get(j);
					queue.front = 0;
					queue.rear = 1;

					break;

				}

				for (int k = 1; k < queue.SIZE; k++) {
					long generateToken = generateToken();
					queue.items[queue.rear++] = generateToken;
					// queue.rear++;

					all.add(generateToken);

				}

			}
		}

		return all;
	}

}
