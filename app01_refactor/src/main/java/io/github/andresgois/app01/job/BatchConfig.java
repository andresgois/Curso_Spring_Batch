package io.github.andresgois.app01.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Bean
	public Job imprimeOlaJob(JobRepository jobRepository, Step imprimeOlaStep) {
		return new JobBuilder("imprimeOlaJob", jobRepository)
				.start(imprimeOlaStep)
				.build();
	}

}
