package com.online.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.service.QuesuOpertaions;

import sun.util.logging.resources.logging;

@RestController
@RequestMapping("queue")
public class QueueController {

	@Autowired
	private QuesuOpertaions quesuOpertaions;

	/**
	 *  this Method Insert Elements in Queue And Return
	 * @return
	 */
	@RequestMapping("/fetch")
	public List<Long> insertQueue() {
		

		List<Long> allTokens = quesuOpertaions.getAllTokens();

		return allTokens;
	}
	
	/**
	 * This method remove Elements From queue And insert
	 * @return
	 */
	@RequestMapping("/remove")
	public List<Long> removingElementQueue() {

		List<Long> allTokens = quesuOpertaions.removeQueueElements();

		return allTokens;
	}

}
