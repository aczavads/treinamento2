package br.zapix.plano_de_contas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.zapix.base.BaseService;
import br.zapix.base.ServiceTransactional;
import br.zapix.conta_contabil.ContaContabil;
import br.zapix.conta_contabil.ContaContabilRepository;

@ServiceTransactional
public class PlanoDeContasService extends BaseService<PlanoDeContas, PlanoDeContasRepository>{
	@Autowired
	private ContaDoPlanoDeContasRepository repoContaDoPlano;

	@Autowired
	private ContaContabilRepository repoContaContabil;

	public List<ContaContabil> getContas(String id) {
		return repoContaContabil.findContasDoPlano(id);
	}

	public void addContas(String id, List<String> idsDasContas) {
		idsDasContas.forEach((idDaConta) ->  {
			repoContaDoPlano.save(new ContaDoPlanoDeContas(idDaConta,id));
		});
	}

}
