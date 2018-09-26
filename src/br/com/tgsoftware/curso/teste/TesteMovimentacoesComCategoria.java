package br.com.tgsoftware.curso.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Categoria;
import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.modelo.enumeration.TipoMovimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteMovimentacoesComCategoria {
	public static void main(String[] args) {
		Categoria cat1 = new Categoria("Viagem");
		Categoria cat2 = new Categoria("Negócios");

		Conta conta = new Conta();
		conta.setId(5);

		Movimentacao m1 = new Movimentacao();
		m1.setConta(conta);
		m1.setData(Calendar.getInstance());
		m1.setDescricao("Viagem ao MT");
		m1.setTipo(TipoMovimentacao.SAIDA);
		m1.setValor(new BigDecimal("560.98"));
		m1.setCategorias(Arrays.asList(cat1, cat2));

		Movimentacao m2 = new Movimentacao();
		m2.setConta(conta);
		m2.setData(Calendar.getInstance());
		m2.setDescricao("Viagem ao Goiás");
		m2.setTipo(TipoMovimentacao.SAIDA);
		m2.setValor(new BigDecimal("759.00"));
		m2.setCategorias(Arrays.asList(cat1, cat2));
		
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