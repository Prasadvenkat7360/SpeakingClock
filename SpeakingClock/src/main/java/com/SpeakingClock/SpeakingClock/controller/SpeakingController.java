package com.SpeakingClock.SpeakingClock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpeakingClock.SpeakingClock.Exception.WrongTimeException;
import com.SpeakingClock.SpeakingClock.dto.SpeakingClockDTO;
import com.SpeakingClock.SpeakingClock.service.SpeakingClockServiceImpl;

@RestController
public class SpeakingController {

	@Autowired
	private SpeakingClockServiceImpl service;
	
	
	@PostMapping("/getWordsByTime")
	public SpeakingClockDTO fetchCompletionByTime(@RequestBody SpeakingClockDTO dto ) throws NumberFormatException, WrongTimeException {
		return service.getwordsByTime(dto);
		
	}
}
