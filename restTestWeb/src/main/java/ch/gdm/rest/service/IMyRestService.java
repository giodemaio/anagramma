package ch.gdm.rest.service;

import ch.gdm.rest.web.AnagramDto;
import ch.gdm.rest.web.Pow2InputDto;

public interface IMyRestService {
	public Pow2InputDto calculePow( Pow2InputDto pow2InputDto) ;

	public AnagramDto anagram(AnagramDto pow2InputDto);
}
