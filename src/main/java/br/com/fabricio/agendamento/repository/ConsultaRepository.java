package br.com.fabricio.agendamento.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricio.agendamento.entity.Consulta;

/*
 * Pacote Repository - Persistência dos dados. Sem regras de negócio. Somente acesso ao bd.
	findAll()
	findById()
	save()
	deleteById()
	existsById()
 */

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	boolean existsByMedicoAndDataConsultaAndHoraConsulta(
	        String medico,
	        LocalDate dataConsulta,
	        LocalTime horaConsulta);
	
}
