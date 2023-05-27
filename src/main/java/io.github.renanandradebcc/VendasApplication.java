package io.github.renanandradebcc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

// Não é obrigatorio usar o ComponentScan para fazer ele avistar repositorio ou service,
// ele serve mais para casos de mapeamento de lib externas para que o metodo possa ter acesso
// a um env ou algo relacionado ao retorno de um metodo externo
@ComponentScan(basePackages = {
        "io.github.renanandradebcc.repository",
        "io.github.renanandradebcc.service"}
)
@RestController
public class VendasApplication {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;
    @GetMapping("/hello-world")
    public String helloWorld() {
        return applicationName;
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
