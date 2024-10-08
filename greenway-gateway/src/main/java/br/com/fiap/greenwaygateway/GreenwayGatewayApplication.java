package br.com.fiap.greenwaygateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GreenwayGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenwayGatewayApplication.class, args);
	}

}
