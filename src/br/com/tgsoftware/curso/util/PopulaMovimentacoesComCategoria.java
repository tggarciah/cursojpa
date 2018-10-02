package br.com.tgsoftware.curso.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Categoria;
import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.modelo.enumeration.TipoMovimentacao;

public class PopulaMovimentacoesComCategoria {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("Essencial");
		Categoria cat2 = new Categoria("Investimentos");

		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		
		Conta conta = new Conta();
		conta.setId(5);

		Movimentacao m1 = new Movimentacao();
		m1.setConta(conta);
		m1.setData(amanha);
		m1.setDescricao("Aplicação Tesouro Direto");
		m1.setTipo(TipoMovimentacao.SAIDA);
		m1.setValor(new BigDecimal("560.98"));
		m1.setCategorias(Arrays.asList(cat2));

		Movimentacao m2 = new Movimentacao();
		m2.setConta(conta);
		m2.setData(amanha);
		m2.setDescricao("Aluguel");
		m2.setTipo(TipoMovimentacao.SAIDA);
		m2.setValor(new BigDecimal("759.00"));
		m2.setCategorias(Arrays.asList(cat1));

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(cat1);
		em.persist(cat2);

		em.persist(m1);
		em.persist(m2);

		em.getTransaction().commit();
		em.close();
	}
}