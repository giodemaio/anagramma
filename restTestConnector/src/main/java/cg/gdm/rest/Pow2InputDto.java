package cg.gdm.rest;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pow2InputDto implements Serializable {
	private BigDecimal number;
	private Integer pow;

	private BigDecimal result;

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

	public Pow2InputDto() {
		super();
		
	}

	public BigDecimal getNumber() {
		return number;
	}

	public Pow2InputDto(BigDecimal number, Integer pow) {
		super();
		this.number = number;
		this.pow = pow;
	}

	public void setNumber(BigDecimal number) {
		this.number = number;
	}

	public Integer getPow() {
		return pow;
	}

	public void setPow(Integer pow) {
		this.pow = pow;
	}
}
