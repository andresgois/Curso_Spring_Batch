package com.springbatch.arquivolargurafixa.step;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import com.springbatch.arquivolargurafixa.reader.ArquivoClienteTransacaoReader;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class LeituraArquivoLarguraFixaStepConfig {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager transactionManager;

	public LeituraArquivoLarguraFixaStepConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager){
		this.jobRepository = jobRepository;
		this.transactionManager = transactionManager;
	}

	@Bean
	public Step leituraArquivoLarguraFixaStep(
			FlatFileItemReader leituraArquivoLarguraFixaReader,
			ItemWriter<Cliente> leituraArquivoLarguraFixaWriter) {
		return new StepBuilder("leituraArquivoLarguraFixaStep", jobRepository)
				.<Cliente, Cliente>chunk(1, transactionManager)
				.reader(new ArquivoClienteTransacaoReader(leituraArquivoLarguraFixaReader))
				.writer(leituraArquivoLarguraFixaWriter)
				.build();
	}
}
