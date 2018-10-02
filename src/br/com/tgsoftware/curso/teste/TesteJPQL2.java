package br.com.tgsoftware.curso.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tgsoftware.curso.modelo.Categoria;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteJPQL2 {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Categoria categoria = new Categoria();
		categoria.setId(1);
		String strJpql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";

		em.getTransaction().begin();
		Query query = em.createQuery(strJpql);
		query.setParameter("pCategoria", categoria);

		List<Movimentacao> movimentacoes = query.getResultList();

		em.getTransaction().commit();
		em.close();

		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao);
		}
	}
}