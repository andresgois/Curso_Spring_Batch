package com.springbatch.arquivolargurafixa.reader;

import com.springbatch.arquivolargurafixa.dominio.Cliente;
import com.springbatch.arquivolargurafixa.dominio.Transacao;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

public class ArquivoClienteTransacaoReader implements ItemStreamReader<Cliente> {

	private Object objetoAtual;
	private ItemStreamReader<Object> delegate;

	public ArquivoClienteTransacaoReader(ItemStreamReader<Object> delegate) {
		this.delegate = delegate;
	}

	@Override
	public Cliente read() throws Exception{
		if(objetoAtual == null){//ainda não foi carregado
			objetoAtual = delegate.read();//ler objeto
		}
		Cliente cliente = (Cliente) objetoAtual;
		objetoAtual = null;
		if(cliente != null){
			while (peek() instanceof Transacao){
				cliente.getTransacaos().add((Transacao) objetoAtual);
			}
		}
		return cliente;
	}

	private Object peek() throws Exception {
		objetoAtual = delegate.read();; // leitura do próximo item
		return objetoAtual;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		delegate.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		delegate.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		delegate.close();
	}
}
