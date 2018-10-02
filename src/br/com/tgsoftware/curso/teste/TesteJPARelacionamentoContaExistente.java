package br.com.tgsoftware.curso.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.modelo.enumeration.TipoMovimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteJPARelacionamentoContaExistente {
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(5);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Pagamento");
		movimentacao.setTipo(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal("2500.00"));
		movimentacao.setConta(conta);

		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();

		manager.persist(movimentacao);

		manager.getTransaction().commit();
		manager.close();
	}
}