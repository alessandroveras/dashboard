package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.CaloriasPorMinutoInvalidException;
import br.edu.infnet.dashboard.model.exceptions.DuracaoMinutosInvalidException;
import br.edu.infnet.dashboard.model.exceptions.IntensidadeInvalidException;

public class Aerobico extends Atividade {

	private String equipamento;
	private Integer coolDownMinutos;
	private Boolean usarCarga;
	private Integer caloriasPorMinuto;

	public Aerobico() {

	}

	public Aerobico(Integer duracaoMinutos, String descricao, String intensidade, Boolean supervisionada) throws DuracaoMinutosInvalidException, IntensidadeInvalidException {
		super(duracaoMinutos, descricao, intensidade, supervisionada);
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public Integer getCoolDownMinutos() {
		return coolDownMinutos;
	}

	public void setCoolDownMinutos(Integer coolDownMinutos) {
		this.coolDownMinutos = coolDownMinutos;
	}

	public Boolean getUsarCarga() {
		return usarCarga;
	}

	public void setUsarCarga(Boolean usarCarga) {
		this.usarCarga = usarCarga;
	}

	public Integer getCaloriasPorMinuto() {
		return caloriasPorMinuto;
	}

	public void setCaloriasPorMinuto(Integer caloriasPorMinuto) throws CaloriasPorMinutoInvalidException {

		if (caloriasPorMinuto <= 0) {
			throw new CaloriasPorMinutoInvalidException("O valor definido para caloriasPorMinuto na classe Aerobico é invalido (<=0)!");
		}
		this.caloriasPorMinuto = caloriasPorMinuto;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(";");
		sb.append(equipamento);
		sb.append(";");
		sb.append(coolDownMinutos);
		sb.append(";");
		sb.append(usarCarga);
		sb.append(";");
		sb.append(caloriasPorMinuto);
		sb.append(";");

		return sb.toString();
	}

	@Override
	public Integer calcularCaloriasQueimadas() {

		Integer caloriasQueimadas = this.getDuracaoMinutos() * caloriasPorMinuto;
		if (usarCarga) {
			caloriasQueimadas = caloriasQueimadas * 2;
		}

		return caloriasQueimadas;
	}
}
