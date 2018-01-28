package ch.valueminer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableRabbit
@EnableScheduling
@SpringBootApplication
public class ValueminerAdapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValueminerAdapterApplication.class, args);
	}

}
