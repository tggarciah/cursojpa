package br.com.tgsoftware.curso.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.enumeration.TipoMovimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteJPQL4Funcoes {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		Conta conta = new Conta();
		conta.setId(5);

		String strJpqlSoma = "select sum(m.valor) from Movimentacao m where m.conta = :pConta and"
				+ " tipo = :pTipo order by m.valor desc";
		String strJpqlMedia = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and"
				+ " tipo = :pTipo order by m.valor desc";
		String strJpqlMaior = "select max(m.valor) from Movimentacao m where m.conta = :pConta and"
				+ " tipo = :pTipo order by m.valor desc";
		String strJpqlCount = "select count(m) from Movimentacao m where m.conta = :pConta";

		Query query = em.createQuery(strJpqlSoma);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		BigDecimal soma = (BigDecimal) query.getSingleResult();

		query = em.createQuery(strJpqlMedia);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		Double media = (Double) query.getSingleResult();

		query = em.createQuery(strJpqlMaior);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		BigDecimal maiorValor = (BigDecimal) query.getSingleResult();

		query = em.createQuery(strJpqlCount);
		query.setParameter("pConta", conta);

		Long count = (Long) query.getSingleResult();
		
		em.close();

		System.out.println("A soma é: " + soma);
		System.out.println("A média é: " + media);
		System.out.println("O maior valor é: " + maiorValor);
		System.out.println("O count é: " + count);
	}
}