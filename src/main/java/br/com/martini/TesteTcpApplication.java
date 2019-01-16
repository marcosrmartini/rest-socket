package br.com.martini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.martini.socket.Server;

@SpringBootApplication
public class TesteTcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteTcpApplication.class, args);
	}

	@Bean
	public void init() {
		Server server = new Server();
		server.start();
	}
	
}

