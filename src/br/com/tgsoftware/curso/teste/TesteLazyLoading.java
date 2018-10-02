package br.com.tgsoftware.curso.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.util.JPAUtil;

/**
 * 
 * @author thiag
 * Por padrão relacionamentos [...]ToMany são Lazy, ou seja, serão carregados no momento
 * que se precisam deles.
 * Para resolver isso vamos trazer as movimentações no momento que buscamos as contas, colocando o comando
 * join fetch
 */
public class TesteLazyLoading {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String jpql = "select c from Conta c join fetch c.movimentacoes";

		Query query = em.createQuery(jpql);
		List<Conta> contas = query.getResultList();
		
		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		em.getTransaction().commit();
		em.close();
	}
}