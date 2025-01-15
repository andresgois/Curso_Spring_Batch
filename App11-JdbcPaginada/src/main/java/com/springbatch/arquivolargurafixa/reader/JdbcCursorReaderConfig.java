package com.springbatch.arquivolargurafixa.reader;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class JdbcCursorReaderConfig {

	@Bean
	public JdbcPagingItemReader<Cliente> jdbcCursorReader(
			@Qualifier("appDataSource") DataSource dataSource,
			PagingQueryProvider provider
	) {
		return new JdbcPagingItemReaderBuilder<Cliente>()
				.name("JdbcPagingItemReader")
				.dataSource(dataSource)
				.queryProvider(provider)
				.pageSize(1)
				.rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
				.build();
	}

	@Bean
	public SqlPagingQueryProviderFactoryBean provider(
			@Qualifier("appDataSource") DataSource dataSource
	){
		SqlPagingQueryProviderFactoryBean queryFactory = new SqlPagingQueryProviderFactoryBean();
		queryFactory.setDataSource(dataSource);
		queryFactory.setSelectClause("select *");
		queryFactory.setFromClause("from Cliente");
		queryFactory.setWhereClause("1 = 1");
		queryFactory.setSortKey("email");
		return queryFactory;
	}

}