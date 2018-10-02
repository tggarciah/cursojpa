package br.com.tgsoftware.curso.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.modelo.Movimentacao;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteExercicioDesafio1 {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();

		Conta conta = em.find(Conta.class, 1);
		
		List<Movimentacao> movimentacoes = conta.getMovimentacoes();

		em.close();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("Movimentação: " + movimentacao.getDescricao());
		}
	}
}