package br.com.cronos.msclients.application;

import br.com.cronos.msclients.application.representation.ClientSaveRequest;
import br.com.cronos.msclients.domain.entity.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("clients")
public class ClientResource {

    private final  ClientService clienteService;

    @GetMapping
    public String status() {
        return "0k";
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ClientSaveRequest request) {
        Client client = request.toModel();
        clienteService.save(client);

        URI headerLocation = ServletUriComponentsBuilder.fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity getClientByCpf(@RequestParam("cpf") String cpf) {
        var client = clienteService.getByCPF(cpf);

        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }
}
