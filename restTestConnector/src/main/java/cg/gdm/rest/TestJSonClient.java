package cg.gdm.rest;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

import org.hibernate.validator.internal.xml.GetterType;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class TestJSonClient {
	private static final String SERVER_URL = "http://localhost:8080/restTestWeb-0.0.1-SNAPSHOT/remoting/rest/";
	private RestTemplate restTemplate;

	public TestJSonClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RestClientException,
			URISyntaxException {
		testAnagram();
	}

	private static void testAnagram() throws URISyntaxException {
		AnagramDto dto = new AnagramDto();
		dto.setWord("saca");
		HttpEntity<AnagramDto> httpEntity = new HttpEntity<>(dto);
		TestJSonClient client = new TestJSonClient();
		ResponseEntity<? extends AnagramDto> future = client
				.anagram(httpEntity);
		if (future.getBody().getResult() != null) {
			for (String word : future.getBody().getResult()) {
				System.out.println(word);
			}
		}else{
			System.out.println("Pas de resultat");
		}

	}

	private static void testPow() throws URISyntaxException {
		Pow2InputDto dto = new Pow2InputDto(BigDecimal.TEN, 3);
		HttpEntity<Pow2InputDto> httpEntity = new HttpEntity<>(dto);
		TestJSonClient client = new TestJSonClient();
		ResponseEntity<? extends Pow2InputDto> future = client
				.calculePow(httpEntity);

		System.out.println(future.getBody().getResult().toPlainString());

	}

	private static void testSimple() throws URISyntaxException {
		RestTestDto wrappedTransactions = new RestTestDto("Io sono Giuseppe",
				7777L, BigDecimal.TEN);
		HttpEntity<RestTestDto> payload = new HttpEntity<>(wrappedTransactions);
		TestJSonClient client = new TestJSonClient();
		ResponseEntity<? extends RestTestDto> future = client.methode1(payload);

		System.out.println(future.getBody().getTestString());

		RestTestDto result = client.methodeGet();
		System.out.println(result.getTestString());
	}

	private RestTestDto methodeGet() throws RestClientException,
			URISyntaxException {
		ResponseEntity<RestTestDto> result = getRestTemplate().getForEntity(
				getTestGetEndpoint(), RestTestDto.class);
		return result.getBody();
	}

	private ResponseEntity<? extends RestTestDto> methode1(
			HttpEntity<RestTestDto> payload) throws URISyntaxException {

		ResponseEntity<? extends RestTestDto> future = getRestTemplate()
				.postForEntity(getShutStatisticsServiceEndpoint(), payload,
						RestTestDto.class);
		return future;
	}

	private static RestTestDto methode2(HttpEntity<RestTestDto> payload)
			throws URISyntaxException {

		RestTemplate template = new RestTemplate();
		RestTestDto future = template.getForObject(
				getShutStatisticsServiceEndpoint(),

				RestTestDto.class);
		return future;
	}

	private ResponseEntity<? extends Pow2InputDto> calculePow(
			HttpEntity<Pow2InputDto> powInputDto) throws URISyntaxException {

		ResponseEntity<? extends Pow2InputDto> future = getRestTemplate()
				.postForEntity(getServiceEndpoint("calculePow"), powInputDto,
						Pow2InputDto.class);
		return future;
	}

	private ResponseEntity<? extends AnagramDto> anagram(
			HttpEntity<AnagramDto> powInputDto) throws URISyntaxException {

		ResponseEntity<? extends AnagramDto> future = getRestTemplate()
				.postForEntity(getServiceEndpoint("anagram"), powInputDto,
						AnagramDto.class);
		return future;
	}

	private static URI getShutStatisticsServiceEndpoint()
			throws URISyntaxException {
		return new URI(SERVER_URL + "testViewInput");
	}

	private static URI getServiceEndpoint(String serviceUrl)
			throws URISyntaxException {
		return new URI(SERVER_URL + serviceUrl);
	}

	private static URI getTestGetEndpoint() throws URISyntaxException {

		return new URI(SERVER_URL + "testGet");
	}

	public RestTemplate getRestTemplate() {
		// TODO: Fix the RestTemplate to be a singleton instance.
		restTemplate = (this.restTemplate == null) ? new RestTemplate()
				: restTemplate;

		// Set the request factory.
		// IMPORTANT: This section I had to add for POST request. Not needed for
		// GET
		restTemplate
				.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

		// Add converters
		// Note I use the Jackson Converter, I removed the http form converter
		// because it is not needed when posting String, used for multipart
		// forms.
		restTemplate.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());

		return restTemplate;
	}
}
