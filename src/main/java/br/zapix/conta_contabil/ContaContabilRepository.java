package br.zapix.conta_contabil;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.zapix.base.BaseRepository;


public interface ContaContabilRepository extends BaseRepository<ContaContabil>{
	 
	@Query(nativeQuery = true, value = "select * from v_conta_do_plano_de_contas v where v.plano_de_contas_id = :id")
	List<ContaContabil> findContasDoPlano(String id);

}
