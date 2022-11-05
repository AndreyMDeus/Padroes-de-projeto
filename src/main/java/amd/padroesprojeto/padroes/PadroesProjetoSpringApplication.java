package amd.padroesprojeto.padroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Módulos selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign (Client REST declarativo para criar um client http para consumir APIs externas
 *
 * @author Andrey
 */
@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoSpringApplication.class, args);
	}

}
