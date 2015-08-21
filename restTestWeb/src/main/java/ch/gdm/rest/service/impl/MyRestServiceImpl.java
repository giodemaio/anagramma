package ch.gdm.rest.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import ch.gdm.rest.service.IMyRestService;
import ch.gdm.rest.web.Pow2InputDto;
@Service
public class MyRestServiceImpl implements IMyRestService {

	@Override
	public Pow2InputDto calculePow(Pow2InputDto pow2InputDto) {
		 validate(pow2InputDto);
		 BigDecimal num=pow2InputDto.getNumber();
		 BigDecimal result =num.pow(pow2InputDto.getPow().intValue());
		 pow2InputDto.setResult(result);
		return pow2InputDto;
	}
	private void validate(Pow2InputDto pow2InputDto) {
		if(pow2InputDto.getPow()==null || pow2InputDto.getNumber()==null){
			throw new IllegalArgumentException("Les valeurs d'input ne sont pas rempli");
		}
		
	}
}
