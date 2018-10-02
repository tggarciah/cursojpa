package br.com.tgsoftware.curso.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteJPQL1 {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(5);
		String strJpql = "select m from Movimentacao m where m.conta = :pConta";
		
		em.getTransaction().begin();
		
		Query query = em.createQuery(strJpql);
		query.setParameter("pConta", conta);
		List<Movimentacao> movimentacoes = query.getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao);
		}
	}
}