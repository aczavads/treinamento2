package br.zapix.conta_contabil;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.zapix.base.BaseController;

@RestController
@RequestMapping("/contascontabeis")
public class ContaContabilController extends BaseController<ContaContabil, ContaContabilRepository, ContaContabilService>{

	@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED)
	public String put(ContaContabil entity, String id) {
		return null;
	}
	
}
