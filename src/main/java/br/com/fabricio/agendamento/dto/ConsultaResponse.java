package br.com.fabricio.agendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

/*
 * Pacote DTO - Dados que trafegam entre cliente e servidor
 * Response - Dados enviados para o Front-end
 */

public class ConsultaResponse {
	
	private Long id;
	private String paciente;
	private String especialidade;
	private String medico;
	private LocalDate dataConsulta;
	private LocalTime horaConsulta;
	
	public ConsultaResponse() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPaciente() {
		return paciente;
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public LocalTime getHoraConsulta() {
		return horaConsulta;
	}

	public void setHoraConsulta(LocalTime horaConsulta) {
		this.horaConsulta = horaConsulta;
	}

	@Override
	public String toString() {
		return "ConsultaResponse [id=" + id + ", paciente=" + paciente + ", especialidade=" + especialidade
				+ ", medico=" + medico + ", dataConsulta=" + dataConsulta + ", horaConsulta=" + horaConsulta + "]";
	}
	
	

	
}
