package br.zapix.plano_de_contas;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.zapix.base.BaseController;
import br.zapix.conta_contabil.ContaContabil;

@RestController
@RequestMapping("/planosdecontas")
public class PlanoDeContasController extends BaseController<PlanoDeContas, PlanoDeContasRepository, PlanoDeContasService>{
	
	@GetMapping("/{id}/contas")
	public List<ContaContabil> getContas(@PathVariable("id") String id) {
		return getService().getContas(id);
	}
	
	@PostMapping("/{id}/contas")
	public void postContas(@PathVariable("id") String id, @RequestBody List<String> idsDasContas) {
		getService().addContas(id, idsDasContas);
	}

}
