package com.springbatch.arquivolargurafixa.reader;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import com.springbatch.arquivolargurafixa.dominio.Transacao;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapperConfig {
	@Bean
	public PatternMatchingCompositeLineMapper LineMapper(){
		PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper();
		lineMapper.setTokenizers(tokenizers());
		lineMapper.setFieldSetMappers(filedSetMappers());
		return lineMapper;
	}

	private Map<String, FieldSetMapper> filedSetMappers() {
		Map<String, FieldSetMapper> filedSetMappers = new HashMap<>();
		filedSetMappers.put("0*", fieldSetMapper(Cliente.class));
		filedSetMappers.put("1*", fieldSetMapper(Transacao.class));
		return filedSetMappers;
	}

	private FieldSetMapper fieldSetMapper(Class c) {
		BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
		fieldSetMapper.setTargetType(c);
		return fieldSetMapper;
	}

	private Map<String, LineTokenizer> tokenizers() {
		Map<String, LineTokenizer> tokenizerMap = new HashMap<String, LineTokenizer>();
		tokenizerMap.put("0*", clienteTokenizer());
		tokenizerMap.put("1*", transacaoTokenizer());
		return tokenizerMap;
	}

	private LineTokenizer clienteTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("nome","sobreNome","idade","email");
		lineTokenizer.setIncludedFields(1,2,3,4);
		return lineTokenizer;
	}

	private LineTokenizer transacaoTokenizer() {
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames("id","descricao","valor");
		lineTokenizer.setIncludedFields(1,2,3);
		return lineTokenizer;
	}

}
