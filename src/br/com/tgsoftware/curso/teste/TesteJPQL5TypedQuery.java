package br.com.tgsoftware.curso.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteJPQL5TypedQuery {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(5);

		String strJpqlMedia = "select avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ " group by day(m.data)";

		TypedQuery<Double> query = em.createQuery(strJpqlMedia, Double.class);
		query.setParameter("pConta", conta);

		List<Double> medias = query.getResultList();
		
		em.close();
		
		System.out.println("A média (1) é: " + medias.get(0));
		System.out.println("A média (2) é: " + medias.get(1));
	}
}