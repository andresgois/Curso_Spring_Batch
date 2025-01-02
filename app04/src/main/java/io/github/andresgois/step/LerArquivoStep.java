package io.github.andresgois.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import io.github.andresgois.domain.Cliente;

@Configuration
public class LerArquivoStep {

	@Bean
	public Step leituraArquivoLarguraFixaStep(JobRepository jobRepository,ItemReader<Cliente> leituraArquivoLarguraFixaReader,
			ItemWriter<Cliente> leituraArquivoLarguraFixaWrite,
			PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("leituraArquivoLarguraFixaStep", jobRepository)
				.<Cliente, Cliente>chunk(1,platformTransactionManager)
				.reader(leituraArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWrite)
				.build();
	}
}
