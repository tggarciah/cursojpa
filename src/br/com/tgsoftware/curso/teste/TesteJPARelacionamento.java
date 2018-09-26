package br.com.tgsoftware.curso.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.modelo.enumeration.TipoMovimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteJPARelacionamento {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(2);
		conta.setAgencia("0571");
		conta.setBanco("BANCO DO BRASIL");
		conta.setNumero("46094-X");
		conta.setTitular("Thiago G Garcia");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Almoço no Shopping");
		movimentacao.setTipo(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200.00"));
		movimentacao.setConta(conta);
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		manager.persist(conta);
		manager.persist(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
	}
}