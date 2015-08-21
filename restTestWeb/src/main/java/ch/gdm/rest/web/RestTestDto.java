package ch.gdm.rest.web;

import java.io.Serializable;
import java.math.BigDecimal;

public class RestTestDto implements Serializable{
	private String testString;
	private Long testLong;
	private BigDecimal testBigDecimal;
	public RestTestDto() {
		super();
	}
	public RestTestDto(String testString, Long testLong,
			BigDecimal testBigDecimal) {
		super();
		this.testString = testString;
		this.testLong = testLong;
		this.testBigDecimal = testBigDecimal;
	}
	
	
	public String getTestString() {
		return testString;
	}
	public void setTestString(String testString) {
		this.testString = testString;
	}
	public Long getTestLong() {
		return testLong;
	}
	public void setTestLong(Long testLong) {
		this.testLong = testLong;
	}
	public BigDecimal getTestBigDecimal() {
		return testBigDecimal;
	}
	public void setTestBigDecimal(BigDecimal testBigDecimal) {
		this.testBigDecimal = testBigDecimal;
	}
	
	
}
