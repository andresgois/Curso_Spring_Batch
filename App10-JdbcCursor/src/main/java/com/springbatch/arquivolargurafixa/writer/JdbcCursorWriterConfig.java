package com.springbatch.arquivolargurafixa.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdbcCursorWriterConfig {
	@Bean
	public ItemWriter leituraArquivoLarguraFixaWriter() {
		return items -> items.forEach(System.out::println);
	}
}
