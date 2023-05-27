package io.github.renanandradebcc.service;

import io.github.renanandradebcc.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    //Estancie desta forma, onde você cria uma referência da instância e crie um constructor onde vai injetar o repository
    private ClientRepository repository;

    //Use o Autowired para o container do spring boot criar a instancia deste repositorio
    @Autowired
    public ClientService( ClientRepository repository ) {
        this.repository = repository;
    }

    public void saveClient(Object client) {
        validateClient(client);

        //ClientRepository clientRepository = new ClientRepository();
        //Não estancie o repositorio dessa forma, pois quando for utilizado com mais volume pode gerar gargalo.

        this.repository.save(client);
    }

    public void validateClient(Object client) {
        //aplica validações
    }
}
