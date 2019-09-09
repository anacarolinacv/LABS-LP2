package prova1;

import java.util.Objects;

public class Cliente {
    private int id;
    private String nome;
    private String endereco;

    public Cliente(int id, String nome, String end) {
        this.id = id;
        this.nome = nome;
        this.endereco = end;

    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return String.format("%s - %s - %s", getNome(),getEndereco(),getId());
    }
}
