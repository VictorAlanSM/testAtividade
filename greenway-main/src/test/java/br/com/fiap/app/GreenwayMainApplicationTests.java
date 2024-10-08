package br.com.fiap.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class GreenwayMainApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void bcryptTest() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		var pass = encoder.encode("admin");
		System.out.println(pass);
	}

}
