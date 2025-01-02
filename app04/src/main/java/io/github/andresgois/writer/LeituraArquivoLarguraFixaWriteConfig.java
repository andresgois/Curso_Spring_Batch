package io.github.andresgois.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.andresgois.domain.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaWriteConfig {

	@Bean
	public ItemWriter<Cliente> leituraArquivoLarguraFixaWrite() {
		return itens -> itens.forEach(System.out::println);
	}
}
