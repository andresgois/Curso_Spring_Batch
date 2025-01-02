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
public class LeituraArquivoLarguraFixaStepConfig {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager manager;

	public LeituraArquivoLarguraFixaStepConfig(JobRepository jobRepository,
			PlatformTransactionManager transactionManager) {
		this.jobRepository = jobRepository;
		this.manager = transactionManager;
	}
	
	@Bean
	public Step leituraArquivoLarguraFixaStep(ItemReader<Cliente> leituraArquivoLarguraFixaReader,
			ItemWriter<Cliente> leituraArquivoLarguraFixaWrite) {
		return new StepBuilder("leituraArquivoLarguraFixaStep", jobRepository)
				.<Cliente, Cliente>chunk(1, manager)
				.reader(leituraArquivoLarguraFixaReader)
				.writer(leituraArquivoLarguraFixaWrite)
				.build();
	}
}
