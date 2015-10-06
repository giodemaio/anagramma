package ch.gdm.rest.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import ch.gdm.rest.service.IMyRestService;
import ch.gdm.rest.web.AnagramDto;
import ch.gdm.rest.web.Pow2InputDto;

@Service
public class MyRestServiceImpl implements IMyRestService {

	@Override
	public Pow2InputDto calculePow(Pow2InputDto pow2InputDto) {
		validate(pow2InputDto);
		BigDecimal num = pow2InputDto.getNumber();
		BigDecimal result = num.pow(pow2InputDto.getPow().intValue());
		pow2InputDto.setResult(result);
		return pow2InputDto;
	}

	private void validate(Pow2InputDto pow2InputDto) {
		if (pow2InputDto.getPow() == null || pow2InputDto.getNumber() == null) {
			throw new IllegalArgumentException(
					"Les valeurs d'input ne sont pas rempli");
		}

	}

	@Override
	public AnagramDto anagram(AnagramDto anagramDto) {
		try {
			
			
			if(StringUtils.isEmpty(anagramDto.getWord()) && !VocabolaryReader.containsOnlyLetter(anagramDto.getWord().trim())){
				
				return anagramDto;
			}
			anagramDto.setWord(VocabolaryReader.formatWord(anagramDto.getWord()));
			Map<String, List<String>> map = VocabolaryReader.createMap();
			List<String> result = map.get(VocabolaryReader.sort(anagramDto.getWord()));
			result = VocabolaryReader.removeWordFromList(result,anagramDto.getWord());
			anagramDto.setResult(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return anagramDto;
	}
}
