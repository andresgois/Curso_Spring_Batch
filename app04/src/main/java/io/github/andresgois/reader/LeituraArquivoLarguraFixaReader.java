package io.github.andresgois.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import io.github.andresgois.domain.Cliente;

@Configuration
public class LeituraArquivoLarguraFixaReader {

	@StepScope
	@Bean
	public FlatFileItemReader<Cliente> leituraArquivoLarguraFixaReader(
			@Value("#{jobParameters['arquivoCliente']}") Resource arquivoCliente){
		return new FlatFileItemReaderBuilder<Cliente>()
				.name("leituraArquivoLarguraFixaReader")
				.resource(arquivoCliente)
				.fixedLength()
				.columns(new Range[] {new Range(1,10),new Range(11,21),new Range(22,26),new Range(27,48)})
				.names(new String[] {"nome","sobreNome","idade","email"})
				.targetType(Cliente.class)
				.build();
	}
}
