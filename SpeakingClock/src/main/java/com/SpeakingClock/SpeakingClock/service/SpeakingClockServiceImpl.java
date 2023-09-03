package com.SpeakingClock.SpeakingClock.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.SpeakingClock.SpeakingClock.Exception.WrongTimeException;
import com.SpeakingClock.SpeakingClock.dto.SpeakingClockDTO;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService{

	@Override
	public SpeakingClockDTO getwordsByTime(SpeakingClockDTO clkdto) throws NumberFormatException, WrongTimeException {
		SpeakingClockDTO dto=new SpeakingClockDTO();
		
         LocalTime currentTime = LocalTime.now();
		
		String[] timeSplit=clkdto.getTime().split(":");

		// Convert the time to words
		String timeInWords = convertToWords(Integer.parseInt(timeSplit[0].toString()), Integer.parseInt(timeSplit[1].toString()));

		dto.setTimeInWords(timeInWords);
		
		return dto;
	}

	private String convertToWords(int hours, int minutes) throws WrongTimeException {
		String timeInWords = "";
		if (hours > 24) {
			throw new WrongTimeException("Wrong Time Exception");
		}

		  LocalTime currentTime = LocalTime.of(hours, minutes);
		  if(currentTime.equals(LocalTime.MIDNIGHT)) {
			  timeInWords="It's Mid Night";
		  }else {
			  int tenWords;
				if (minutes / 10 == 0) {
					tenWords = 0;
				} else {
					tenWords = minutes / 10;
				}

				int oneWords;
				if (minutes % 10 == 0) {
					oneWords = 0;
				} else {
					oneWords = minutes % 10;
				}

				String[] hourWords = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
						"eleven", "twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "NineTeen",
						"Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four" };

				String[] Tens = { "", "Ten", "twenty", "Thirty", "fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
						"Hundred" };

				String[] minuteWords = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
						"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
						"twenty" };

				

				if (minutes == 0) {
					timeInWords = hourWords[hours] + " o'clock";
				} else if (minutes == 15) {
					timeInWords = "quarter past " + hourWords[hours];
				} else if (minutes == 30) {
					timeInWords = "half past " + hourWords[hours];
				} else if (minutes == 45) {
					timeInWords = "quarter to " + hourWords[hours + 1];
				} else if (minutes <= 20) {
					timeInWords = minuteWords[minutes] + " past " + hourWords[hours];
				} else {
					timeInWords = "It's " + hourWords[hours] + " " + Tens[tenWords] + " " + hourWords[oneWords];
				}

		  }
		  
		return timeInWords;
		
		
	}

}
