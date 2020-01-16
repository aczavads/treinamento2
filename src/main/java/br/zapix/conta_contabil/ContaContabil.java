package br.zapix.conta_contabil;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.zapix.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ContaContabil extends BaseEntity {
	private String nome;

//	@Embedded
//	@AttributeOverride(column = @Column(name = "codigo"), name = "valor")
//	private CodigoContabil codigo;
	private String codigo;

//	@ManyToOne
//	private ContaContabil contaSuperior;
	private String contaSuperiorId;

	public ContaContabil(String id, String nome, String codigo, String contaSuperiorId) {
		super(id);
		this.nome = nome;
		this.codigo = codigo;
		this.contaSuperiorId = contaSuperiorId;
	}

}
