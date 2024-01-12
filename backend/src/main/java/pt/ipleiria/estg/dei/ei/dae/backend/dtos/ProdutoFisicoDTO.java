package pt.ipleiria.estg.dei.ei.dae.backend.dtos;

import pt.ipleiria.estg.dei.ei.dae.backend.entities.ProdutoCatalogo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoFisicoDTO {
    private long id;
    private String nome;
    private String fabricanteUsername;
    private long produtoCatalogoId;

    private  long encomendaId;

    public ProdutoFisicoDTO() {
    }

    public ProdutoFisicoDTO(long id, String nome, String fabricanteUsername, long produtoCatalogoId, long encomendaId) {
        this.id = id;
        this.nome = nome;
        this.fabricanteUsername = fabricanteUsername;
        this.produtoCatalogoId = produtoCatalogoId;
        this.encomendaId = encomendaId;
    }

    public ProdutoFisicoDTO(long id, String nome, String fabricanteUsername, long produtoCatalogoId) {
        this.id = id;
        this.nome = nome;
        this.fabricanteUsername = fabricanteUsername;
        this.produtoCatalogoId = produtoCatalogoId;
    }

    public ProdutoFisicoDTO(long id, String nome, String fabricanteUsername) {
        this.id = id;
        this.nome = nome;
        this.fabricanteUsername = fabricanteUsername;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricanteUsername() {
        return fabricanteUsername;
    }

    public void setFabricanteUsername(String fabricanteUsername) {
        this.fabricanteUsername = fabricanteUsername;
    }

    public long getProdutoCatalogoId() {
        return produtoCatalogoId;
    }

    public void setProdutoCatalogoId(long produtoCatalogoId) {
        this.produtoCatalogoId = produtoCatalogoId;
    }

    public long getEncomendaId() {
        return encomendaId;
    }

    public void setEncomendaId(long encomendaId) {
        this.encomendaId = encomendaId;
    }
}
