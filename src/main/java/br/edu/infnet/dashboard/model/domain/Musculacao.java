package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.CaloriasPorMinutoInvalidException;
import br.edu.infnet.dashboard.model.exceptions.DuracaoMinutosInvalidException;
import br.edu.infnet.dashboard.model.exceptions.IntensidadeInvalidException;

public class Musculacao extends Atividade {

    private String grupamentoMuscular;
    private String aparelho;
    private Float carga;
    private Integer caloriasPorMinuto;

    public Musculacao() {

    }

    public Musculacao(Integer duracaoMinutos, String descricao, String intensidade, Boolean supervisionada) throws DuracaoMinutosInvalidException, IntensidadeInvalidException {
        super(duracaoMinutos, descricao, intensidade, supervisionada);
    }

    public String getGrupamentoMuscular() {
        return grupamentoMuscular;
    }

    public void setGrupamentoMuscular(String grupamentoMuscular) {
        this.grupamentoMuscular = grupamentoMuscular;
    }

    public String getAparelho() {
        return aparelho;
    }

    public void setAparelho(String aparelho) {
        this.aparelho = aparelho;
    }

    public Float getCarga() {
        return carga;
    }

    public void setCarga(Float carga) {
        this.carga = carga;
    }

    public Integer getCaloriasPorMinuto() {
        return caloriasPorMinuto;
    }

    public void setCaloriasPorMinuto(Integer caloriasPorMinuto) throws CaloriasPorMinutoInvalidException {

        if (caloriasPorMinuto <= 0) {
            throw new CaloriasPorMinutoInvalidException("O valor definido para caloriasPorMinuto na classe Musculacao é invalido (<=0)!");
        }

        this.caloriasPorMinuto = caloriasPorMinuto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(";");
        sb.append(";");
        sb.append(grupamentoMuscular);
        sb.append(";");
        sb.append(aparelho);
        sb.append(";");
        sb.append(carga);
        sb.append(";");

        return sb.toString();
    }

    @Override
    public Integer calcularCaloriasQueimadas() {

        Integer intensidadeFactor = 0;

        switch (this.getIntensidade()) {
            case "Alta":
                intensidadeFactor = 3;
                break;
            case "Media":
                intensidadeFactor = 2;
                break;
            case "Baixa":
                intensidadeFactor = 1;
        }

        Integer caloriasQueimadas = this.getDuracaoMinutos() * this.getCaloriasPorMinuto();
        caloriasQueimadas = caloriasQueimadas * intensidadeFactor;

        return caloriasQueimadas;
    }
}