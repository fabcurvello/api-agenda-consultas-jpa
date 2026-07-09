package br.com.fabricio.agendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * Pacote DTO - Dados que trafegam entre cliente e servidor
 * Request - Dados recebidos do Front-end
 */
public class ConsultaRequest {
	
	@NotBlank(message = "O paciente é obrigatório.")
	private String paciente;

	@NotBlank(message = "A especialidade é obrigatória.")
	private String especialidade;

	@NotBlank(message = "O médico é obrigatório.")
	private String medico;

	@NotNull(message = "A data da consulta é obrigatória.")
	private LocalDate dataConsulta;

	@NotNull(message = "O horário da consulta é obrigatório.")
	private LocalTime horaConsulta;

	public ConsultaRequest() {
		super();
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
		return "ConsultaRequest [paciente=" + paciente + ", especialidade=" + especialidade + ", medico=" + medico
				+ ", dataConsulta=" + dataConsulta + ", horaConsulta=" + horaConsulta + "]";
	}
	
	

}
