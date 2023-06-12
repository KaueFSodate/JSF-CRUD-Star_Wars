package br.com.backend.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

@Entity
@Table(name = "planeta")
public class Planeta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;
    @Column
    private String clima;
    @Column
    private String terreno;
    @Column
    private int aparicoes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public int getAparicoes() {
        return aparicoes;
    }

    public void setAparicoes(int aparicoes) {
        this.aparicoes = aparicoes;
    }

    // Método para atualizar a quantidade de aparições dos planetas
    public void atualizarAparicoes() {
        try {
            String url = "https://swapi.dev/api/planets/?search=" + this.nome;
            ObjectMapper mapper = new ObjectMapper();
            JsonNode response = mapper.readTree(new URL(url));

            JsonNode results = response.get("results");
            int aparicoes = 0; // Valor padrão

            if (results != null && results.isArray() && results.size() > 0) {
                JsonNode filmes = results.get(0).get("films");
                // Aparições vai ser igual ao tamanho da arrays de filmes que o planeta participou
                aparicoes = filmes.size();
            }
            setAparicoes(aparicoes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
