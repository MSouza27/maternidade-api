package br.com.maternidades.bebe.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@Table(name = "tb_bebe")
public class Bebe {

    private static final String TAMANHO_NOME_MENSAGEM = "O nome do precisa ter entre 5 e 30 caracteres.";
    private static final String TAMANHO_PESO_ALTURA_MENSAGEM = "O peso e a altura são obrigatórios.";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registro_bebe", nullable = false, length = 30)
    @NotBlank(message = "O nome do bebê é obrigatório.")
    @Size(min = 5, max = 30, message = TAMANHO_NOME_MENSAGEM)
    private String nomeBebe;

    @Column(name = "nome_mae", nullable = false, length = 30)
    @NotBlank(message = "O nome da mãe é obrigatório.")
    @Size(min = 5, max = 30, message = TAMANHO_NOME_MENSAGEM)
    private String nomeMae;

    @Column(name = "nome_pai", nullable = false, length = 30)
    @NotBlank(message = "O nome do pai é obrigatório.")
    @Size(min = 5, max = 30, message = TAMANHO_NOME_MENSAGEM)
    private String nomePai;

    @Column(name = "peso_bebe", nullable = false, precision = 5, scale = 2)
    @NotNull(message = TAMANHO_PESO_ALTURA_MENSAGEM)
    @Digits(integer = 3, fraction = 2, message = "O peso deve ser um número com até 3 dígitos e 2 casas decimais.")
    private BigDecimal peso;

    @Column(name = "altura_bebe", nullable = false, precision = 4, scale = 2)
    @NotNull(message = TAMANHO_PESO_ALTURA_MENSAGEM)
    @Digits(integer = 3, fraction = 2, message = "A altura deve ser um número com até 3 dígitos e 2 casa decimais.")
    private BigDecimal altura;

    public Bebe() {
    }

    public Bebe(Long id, String nomeBebe, String nomeMae, String nomePai, BigDecimal peso, BigDecimal altura) {
        this.id = id;
        this.nomeBebe = nomeBebe;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
        this.peso = peso;
        this.altura = altura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeBebe() {
        return nomeBebe;
    }

    public void setNomeBebe(String nomeBebe) {
        this.nomeBebe = nomeBebe;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bebe bebe = (Bebe) o;
        return Objects.equals(id, bebe.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}