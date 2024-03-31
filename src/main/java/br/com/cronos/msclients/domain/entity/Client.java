package br.com.cronos.msclients.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;
    private Integer age;

    public Client(String cpf, String name, Integer age) {
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }
}
