package io.github.andresgois.app01;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ParImparBatchConfig {

	@Bean
	public Job parImparJob(JobRepository jobRepository, Step imprimirParImparStep) {
		return new JobBuilder("ParImpar", jobRepository)
				.start(imprimirParImparStep)
				.incrementer(new RunIdIncrementer())
				.build();
	}

	@Bean
	public Step imprimirParImparStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("imprimirParImparStep", jobRepository)
				.<Integer, String>chunk(1, platformTransactionManager)
				.reader(contaAteDezReader())
				.processor(parOuImparPrecessor())
				.writer(imprimirWriter())
				.build();
	}

	private IteratorItemReader<Integer> contaAteDezReader() {
		List<Integer> numerosDeUmDez = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		return new IteratorItemReader<Integer>(numerosDeUmDez.iterator());
	}
	
	private FunctionItemProcessor<Integer, String> parOuImparPrecessor() {
		return new FunctionItemProcessor<Integer, String>(
				item -> item % 2 == 0 ? String.format("Item %s é par", item)
						: String.format("Item %s é impar", item)
						);
	}
	
	private ItemWriter<String> imprimirWriter() {
		return itens -> itens.forEach(System.out::println);
	}
}
