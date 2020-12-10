package com.online.model;

import org.springframework.stereotype.Component;

@Component
public class Queue {

	public int SIZE = 3;
	public int min_size = 1;
	public long[] items;
	public int front, rear, rearrest;

	Queue() {
		front = -1;
		rear = -1;
		rearrest = -1;
	}

	// check if the queue is full
	public boolean isFull() {
		if (front == 0 && rear == SIZE - 1) {
			return true;
		}
		return false;
	}

	// check if the queue is empty
	public boolean isEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

}
