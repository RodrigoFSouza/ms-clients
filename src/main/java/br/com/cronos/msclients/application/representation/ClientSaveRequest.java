package br.com.cronos.msclients.application.representation;

import br.com.cronos.msclients.domain.entity.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Client toModel() {
        return new Client(this.cpf, this.name, this.age);
    }
}
