package br.edu.infnet.dashboard.model.domain;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.dashboard.model.exceptions.DuracaoMinutosInvalidException;
import br.edu.infnet.dashboard.model.exceptions.IntensidadeInvalidException;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Musculacao.class, name = "Musculacao"),
	@JsonSubTypes.Type(value = Aerobico.class, name = "Aerobico")
})
public abstract class Atividade {

	private Integer id;

	private String descricao;
	private Integer duracaoMinutos;
	private String intensidade;
	private Boolean supervisionada;

	private List<Aula> aulas;

	private Usuario usuario;
	
	public Atividade() {
		
	}

	public Atividade(Integer duracaoMinutos, String descricao, String intensidade, Boolean supervisionada) throws DuracaoMinutosInvalidException, IntensidadeInvalidException {

		if (duracaoMinutos <= 0) {
			throw new DuracaoMinutosInvalidException("Impossivel criar atividade com duracao invalida [<=0]");
		}
		List<String> listaIntensidade = new ArrayList<String>();
		listaIntensidade.add("Baixa");
		listaIntensidade.add("Alta");
		listaIntensidade.add("Media");

		if (!listaIntensidade.contains(intensidade)) {
			throw new IntensidadeInvalidException("Intensidade possui um valor designado invalido, favor selecionar um valor dentre a lista [Baixa, Media, Alta]");
		}
		this.descricao = descricao;
		this.duracaoMinutos = duracaoMinutos;
		this.intensidade = intensidade;
		this.supervisionada = supervisionada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getDuracaoMinutos() {
		return duracaoMinutos;
	}

	public void setDuracaoMinutos(Integer duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	public String getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(String intensidade) {
		this.intensidade = intensidade;
	}

	public Boolean getSupervisionada() {
		return supervisionada;
	}

	public void setSupervisionada(Boolean supervisionada) {
		this.supervisionada = supervisionada;
	}

	public List<Aula> getAulas() {
		return aulas;
	}

	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public abstract Integer calcularCaloriasQueimadas();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(";");
		sb.append(duracaoMinutos);
		sb.append(";");
		sb.append(descricao);
		sb.append(";");
		sb.append(intensidade);
		sb.append(";");
		sb.append(supervisionada);
		sb.append(";");
		sb.append(this.calcularCaloriasQueimadas());
		sb.append(";");

		return sb.toString();
	}


}