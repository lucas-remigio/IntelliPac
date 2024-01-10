package pt.ipleiria.estg.dei.ei.dae.backend.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Table(name = "sensor"
        , uniqueConstraints = @UniqueConstraint(columnNames = {"id", "idSensor"})
)
@NamedQueries({
        @NamedQuery(
                name = "getAllSensor",
                query = "SELECT s FROM Sensor s ORDER BY s.id" // JPQL
        )
})
@Entity
public class Sensor {

    // id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // id_sensor (razao ainda por esclarecer, mas será necessario)
    private long idSensor;
    // timestamp
    // tipo (temperatura, humidade, etc)
    private String tipo;
    // unidade (ºC, %, etc)
    private String unidade;
    // id_embalagem
    // id_encomenda

    // o sensor vai ter uma lista de observaçoes numa relaçao de one to many
    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY)
    private List<Observacao> observacoes;

    // relação com embalagem de many to many e vice versa
    @ManyToMany(mappedBy = "sensores", fetch = FetchType.LAZY)
    private List<Embalagem> embalagens;
    // relação de oneToMany com Observação e ManyToOne ao contrario

    public Sensor() {
        this.observacoes = new ArrayList<>();
        this.embalagens = new ArrayList<>();
    }

    public Sensor(long idSensor, String tipo, String unidade) {
        this.idSensor = idSensor;
        this.tipo = tipo;
        this.unidade = unidade;
        this.observacoes = new ArrayList<>();
        this.embalagens = new ArrayList<>();
    }


    public List<Embalagem> getEmbalagens() {
        return embalagens;
    }

    public void setEmbalagens(List<Embalagem> embalagens) {
        this.embalagens = embalagens;
    }

    public List<Observacao> getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(List<Observacao> observacoes) {
        this.observacoes = observacoes;
    }

    public void addObservacao(Observacao observacao) {
        observacoes.add(observacao);
    }

    public void addEmbalagem(Embalagem embalagem) {
        embalagens.add(embalagem);
    }

    public void removeEmbalagem(Embalagem embalagem) {
        embalagens.remove(embalagem);
    }

    public void removeObservacao(Observacao observacao) {
        observacoes.remove(observacao);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdSensor() {
        return idSensor;
    }

    public void setIdSensor(long idSensor) {
        this.idSensor = idSensor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
}
