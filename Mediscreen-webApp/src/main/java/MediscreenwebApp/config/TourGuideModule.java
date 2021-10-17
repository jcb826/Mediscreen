package MediscreenwebApp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class TourGuideModule {


	@Bean
	public RestTemplate getRestemplate() {
		return new RestTemplate();
	}


	
}
