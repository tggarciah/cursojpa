package br.com.tgsoftware.curso.teste;

import javax.persistence.EntityManager;

import br.com.tgsoftware.curso.modelo.Cliente;
import br.com.tgsoftware.curso.modelo.Conta;
import br.com.tgsoftware.curso.util.JPAUtil;

public class TesteContaCliente {
	public static void main(String[] args) {
		Conta conta1 = new Conta();
		conta1.setId(2);
		Conta conta2 = new Conta();
		conta2.setId(1);
		
		Cliente cliente1 = new Cliente();
		cliente1.setEndereco("Avenida Loreto, nº 85, Jd. Santo André");
		cliente1.setNome("Thiago Gonçalves Garcia");
		cliente1.setProfissao("Analista de Sistemas");
		
		cliente1.setConta(conta1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setEndereco("Rua 18, nº 2423, Fortaleza");
		cliente2.setNome("Denyse Moraes Garcia Jardim");
		cliente2.setProfissao("Engenheira de Alimentos");
		
		cliente2.setConta(conta2);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente1);
		em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
	}
}