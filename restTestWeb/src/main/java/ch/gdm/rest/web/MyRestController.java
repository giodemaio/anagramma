package ch.gdm.rest.web;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.gdm.rest.service.IMyRestService;

@RestController
@RequestMapping("/rest")
public class MyRestController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyRestController.class);
	private IMyRestService myRestService;

	@Autowired
	public MyRestController(IMyRestService myRestService) {
		this.myRestService = myRestService;
	}

	@RequestMapping(value = "/testGet", method = RequestMethod.GET)
	@ResponseBody
	public RestTestDto testGet() {

		return new RestTestDto("mio Test", Long.valueOf(434L), new BigDecimal(
				"23"));
	}

	@RequestMapping(value = "/testViewInput", method = RequestMethod.POST)
	@ResponseBody
	public RestTestDto testViewGetInput(@RequestBody RestTestDto restTestDto) {
		restTestDto.setTestString(restTestDto.getTestString() + "-OK");
		return restTestDto;
	}

	@RequestMapping(value = "/calculePow", method = RequestMethod.POST)
	@ResponseBody
	public Pow2InputDto calculePow(@RequestBody Pow2InputDto pow2InputDto) {

		return myRestService.calculePow(pow2InputDto);
	}

}
