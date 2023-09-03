package com.SpeakingClock.SpeakingClock.service;

import com.SpeakingClock.SpeakingClock.Exception.WrongTimeException;
import com.SpeakingClock.SpeakingClock.dto.SpeakingClockDTO;

public interface SpeakingClockService {

	SpeakingClockDTO getwordsByTime(SpeakingClockDTO dto) throws NumberFormatException, WrongTimeException;
}
