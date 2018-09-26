package br.com.tgsoftware.curso.teste;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteConta {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setBanco("Caixa Economica");
		conta.setAgencia("123");
		conta.setNumero("456");

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();

		em.close();
	}
}
