package br.com.tgsoftware.curso.teste;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TestaContaDetachedParaManaged {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		conta.setTitular("João");
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		em.close();
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();

		conta.setTitular("Novo Titular para Testar o Estado Detached para Merge");
		em2.merge(conta);
		
		em2.getTransaction().commit();
		em2.close();		
	}
}