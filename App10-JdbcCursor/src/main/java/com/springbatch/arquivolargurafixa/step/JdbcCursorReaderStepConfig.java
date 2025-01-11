package com.springbatch.arquivolargurafixa.step;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class JdbcCursorReaderStepConfig {

	private final JobRepository jobRepository;
	private final PlatformTransactionManager transactionManager;

	public JdbcCursorReaderStepConfig(JobRepository jobRepository, PlatformTransactionManager transactionManager){
		this.jobRepository = jobRepository;
		this.transactionManager = transactionManager;
	}

	@Bean
	public Step jdbcCursorReaderStep(ItemReader<Cliente> jdbcCursorReader, ItemWriter<Cliente> jdbcCursorWriter) {
		return new StepBuilder("jdbcCursorReaderStep", jobRepository)
				.<Cliente, Cliente>chunk(1, transactionManager)
				.reader(jdbcCursorReader)
				.writer(jdbcCursorWriter)
				.build();
	}
}
