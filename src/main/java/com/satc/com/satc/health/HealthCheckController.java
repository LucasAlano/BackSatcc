package com.satc.com.satc.health;

import com.satc.com.satc.Model.*;
import com.satc.com.satc.repository.ClienteRepository;
import com.satc.com.satc.repository.ProdutoRepository;
import com.satc.com.satc.repository.ServicoRepository;
import com.satc.com.satc.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;

@RestController
public class HealthCheckController {


        @Autowired
        public ProdutoRepository produtoRepository;

         @Autowired
        public ServicoRepository servicoRepository;

         @Autowired
         public ClienteRepository clienteRepostiroy;

         @Autowired
         public VendaRepository vendaRepository;

        @GetMapping("/health")
        public String healthCheck() {
            return "OK";
        }


        @GetMapping("/teste")
        public String healthCheck2() {

            Produto produto = new Produto();
            produto.setDescricao("Intel MILHOOOO i5");
            produto.setNome("PC NPC CAFÉEEEE");
            produto.setValorUnitario(1000.00);
            produto.setDataPrazo(LocalDate.now());
            produto.setDataValidade(LocalDate.now());
            produto.setPrecoCompra(850.00);
            produto.setStatus(Status.DISPONIVEL);
            produto.setEstocavel(Boolean.TRUE);

            produtoRepository.save(produto);

            Servico servico = new Servico();
            servico.setQuantidadeHoras(20.00);
            servico.setDescricao("MILHOO");
            servico.setEstocavel(Boolean.TRUE);
            servico.setValorUnitario(150.00);

            servico = servicoRepository.save(servico);

            Cliente cliente = new Cliente();
            cliente.setCpf("rosa");
            cliente.setRg("Café");
            cliente.setNome("ITÀLIA NPC");
            cliente.setEmail("ITALIANPC@GMAIL.MILHO");
            cliente.setEndereco("Rua do Milho");
            cliente.setTelefone("48 99Milho65");

            cliente = clienteRepostiroy.save(cliente);

            Venda venda = new Venda();
            venda.setCliente(cliente);
            venda.setDataVenda(LocalDate.now());
            venda.setObservacao("MIlhoooOO");
            venda.setFormaPagamento(FormaPagamento.BITCOIN);

            ItemVenda itemVenda = new ItemVenda(produto, 666.66, 1.0, 10.00);
            ItemVenda itemVenda02 = new ItemVenda(servico, 999.99, 1.0, 10.00);

            venda.addItemVenda(itemVenda);
            venda.addItemVenda(itemVenda02);

            vendaRepository.save(venda);

            return "Comando Executado" + " ID produto: " + produto.getId() + " ID Serviço: " + servico.getId() + " Id do cliente: " + cliente.getId();
        }

}
