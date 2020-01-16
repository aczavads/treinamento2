package br.zapix.plano_de_contas;

import java.util.UUID;

import javax.persistence.Entity;

import br.zapix.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ContaDoPlanoDeContas extends BaseEntity {
	private String contaContabilId;
	private String planoDeContasId;

}
