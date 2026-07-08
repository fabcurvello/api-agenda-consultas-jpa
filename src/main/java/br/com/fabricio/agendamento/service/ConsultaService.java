package br.com.fabricio.agendamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fabricio.agendamento.dto.ConsultaRequest;
import br.com.fabricio.agendamento.dto.ConsultaResponse;
import br.com.fabricio.agendamento.entity.Consulta;
import br.com.fabricio.agendamento.exception.RecursoNaoEncontradoException;
import br.com.fabricio.agendamento.exception.RegraNegocioException;
import br.com.fabricio.agendamento.repository.ConsultaRepository;

/*
 * Pacote Service - Regras do negócio
 * Única Regra: O médico não pode ter 2 agendamentos ao mesmo tempo
 * 
 * Responsabilidades Service:

	* Receber a requisição do Controller;
	* Validar a regra de negócio;
	* Converter DTO → Entity;
	* Salvar no banco;
	* Converter Entity → DTO;
	* Retornar o resultado.
 */

@Service
public class ConsultaService {

	private final ConsultaRepository repository;

	// injeção por construtor favorece a imutabilidade e facilita testes unitários.
	public ConsultaService(ConsultaRepository repository) {
		this.repository = repository;
	}

	public List<ConsultaResponse> listar() {

		return repository.findAll().stream().map(this::toResponse).toList();

	}
	

	public ConsultaResponse agendar(ConsultaRequest request) {

		boolean horarioOcupado = repository.existsByMedicoAndDataConsultaAndHoraConsulta(request.getMedico(),
				request.getDataConsulta(), request.getHoraConsulta());

		if (horarioOcupado) {
			throw new RegraNegocioException("O médico já possui uma consulta agendada nesse horário.");
		}

		Consulta consulta = toEntity(request);
		consulta = repository.save(consulta);
		return toResponse(consulta);
	}
	

	public void excluir(Long id) {

		if (!repository.existsById(id)) {
			throw new RecursoNaoEncontradoException("Consulta não encontrada.");
		}
		repository.deleteById(id);
	}
	

	private Consulta toEntity(ConsultaRequest request) {

		Consulta consulta = new Consulta();
		consulta.setPaciente(request.getPaciente());
		consulta.setEspecialidade(request.getEspecialidade());
		consulta.setMedico(request.getMedico());
		consulta.setDataConsulta(request.getDataConsulta());
		consulta.setHoraConsulta(request.getHoraConsulta());

		return consulta;
	}
	

	private ConsultaResponse toResponse(Consulta consulta) {

		ConsultaResponse response = new ConsultaResponse();
		response.setId(consulta.getId());
		response.setPaciente(consulta.getPaciente());
		response.setEspecialidade(consulta.getEspecialidade());
		response.setMedico(consulta.getMedico());
		response.setDataConsulta(consulta.getDataConsulta());
		response.setHoraConsulta(consulta.getHoraConsulta());

		return response;
	}

}
