package io.github.andresgois.app01;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.job.builder.JobBuilder;
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
	public Job imprimeOlaJob(JobRepository jobRepository, Step imprimeOlaStep) {
		return new JobBuilder("imprimeOlaJob", jobRepository)
				.start(imprimeOlaStep)
				.build();
	}

	@Bean
	public Step imprimeOlaStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
		return new StepBuilder("imprimeOlaStep", jobRepository)
				.tasklet(new Tasklet() {
				@Override
				public RepeatStatus execute(StepContribution contribution, 
						ChunkContext chunkContext) throws Exception {
					System.out.println("Olá, mundo!");
					return RepeatStatus.FINISHED;
				}
				}, platformTransactionManager)
				.build();
	}
	
	/*@Bean
	public JobRepository jobRepositoryOla() throws Exception {
        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
        factory.setDataSource(dataSource()); // DataSource pode ser configurado aqui ou com o banco de dados.
        factory.setTransactionManager(transactionManager());
        factory.setDatabaseType("H2");
        return factory.getObject();
    }

	
	 * @Bean public DataSource dataSource() { // Aqui você pode configurar o banco
	 * de dados, por exemplo, um banco H2 em memória DriverManagerDataSource
	 * dataSource = new DriverManagerDataSource();
	 * dataSource.setDriverClassName("org.h2.Driver"); dataSource.setUrl(
	 * "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
	 * dataSource.setUsername("sa"); dataSource.setPassword(""); return dataSource;
	 * }
	 * 
	 * @Bean public PlatformTransactionManager transactionManager() { return new
	 * DataSourceTransactionManager(dataSource()); }
	 */
}
