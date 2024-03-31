package br.com.cronos.msclients.application;

import br.com.cronos.msclients.domain.entity.Client;
import br.com.cronos.msclients.infrastructure.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getByCPF(String cpf) {
        return clientRepository.findByCpf(cpf);
    }


}
