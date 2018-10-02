package br.com.tgsoftware.curso.teste;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

/**
 * 
 * @author thiag Classe para teste de relacionamento bidirecional no aspecto OO
 */
public class TesteContaMovimentacao {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		Movimentacao movimentacao = em.find(Movimentacao.class, 1);
		
		System.out.println(movimentacao.getConta().getTitular());
		Conta conta = movimentacao.getConta();
		
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();
	}
}