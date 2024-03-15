package br.com.inter.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.inter.model.Conta;

public class ContaDAO {
	private static List<Conta> contas = new ArrayList<>();

	static {
		Conta conta1 = new Conta(1, "Conta1");
		Conta conta2 = new Conta(2, "Conta2");

		contas.add(conta1);
		contas.add(conta2);
	}

	public List<Conta> listarContas() {
		return ContaDAO.contas;
	}

	public Optional<Conta> buscaPorId(Integer numeroConta) {
		return ContaDAO.contas.stream()
				.filter(conta -> conta.getNumeroConta().compareTo(numeroConta) == 0)
				.findFirst();
	}

	public void criarConta(Conta inter) {
		ContaDAO.contas.add(inter);
	}

	public void atualizarConta(Conta contaAtualizada) {
		Optional<Conta> contaExistente = buscaPorId(contaAtualizada.getNumeroConta());

		contaExistente.ifPresent(conta -> {
			conta.setNomeCliente(contaAtualizada.getNomeCliente());
		});
	}
	
	public void removerConta(Integer numeroConta) {
		Optional<Conta> contaExistente = buscaPorId(numeroConta);

		contaExistente.ifPresent(conta -> {
			contas.remove(conta);
		});
	}
}
