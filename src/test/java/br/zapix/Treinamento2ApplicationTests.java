package br.zapix;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import br.zapix.conta_contabil.CodigoContabil;
import br.zapix.conta_contabil.ContaContabil;
import br.zapix.conta_contabil.ContaContabilRepository;
import br.zapix.conta_contabil.ContaContabilService;

@SpringBootTest
class Treinamento2ApplicationTests {

	@Autowired
	private ContaContabilService service;
	@MockBean
	private ContaContabilRepository repo;
	
	@BeforeEach
	public void setup() {
		String id = UUID.randomUUID().toString();
		CodigoContabil codigoUm = new CodigoContabil("1");
				
		ContaContabil ativo = new ContaContabil( "Ativo", "1", null);
				
		Mockito.when(repo.save(ativo)).thenReturn(ativo);
	}
	
//	@TestConfiguration
//	static class TestConfigurationImpl {
//		@Bean
//		public ContaContabilService contaContabilService() {
//			return new ContaContabilService();
//		}
//	}
//	
	@Test
	void testarSave() {
		String id = UUID.randomUUID().toString();
		CodigoContabil codigoUm = new CodigoContabil("1");
				
		ContaContabil ativo = new ContaContabil( "Ativo", "1", null);
		service.save(ativo);
		verify(repo, times(1)).save(ativo);
	}
	@Test
	void loadContext() {
		
	}

}
