package io.github.andresgois.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {

	@Bean
	public Job arquivoLarguraFixaJob(JobRepository jobRepository, Step leituraArquivoLarguraFixaStep) {
		return new JobBuilder("arquivoLarguraFixaJob", jobRepository)
				.start(leituraArquivoLarguraFixaStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}

	
	
}
