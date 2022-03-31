package com.fapa.salessystem.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fapa.salessystem.domain.Categoria;
import com.fapa.salessystem.domain.Cidade;
import com.fapa.salessystem.domain.Cliente;
import com.fapa.salessystem.domain.Endereco;
import com.fapa.salessystem.domain.Estado;
import com.fapa.salessystem.domain.ItemPedido;
import com.fapa.salessystem.domain.Pagamento;
import com.fapa.salessystem.domain.PagamentoComBoleto;
import com.fapa.salessystem.domain.PagamentoComCartao;
import com.fapa.salessystem.domain.Pedido;
import com.fapa.salessystem.domain.Produto;
import com.fapa.salessystem.domain.enums.EstadoPagamento;
import com.fapa.salessystem.domain.enums.Perfil;
import com.fapa.salessystem.domain.enums.TipoCliente;
import com.fapa.salessystem.repositories.CategoriaRepository;
import com.fapa.salessystem.repositories.CidadeRepository;
import com.fapa.salessystem.repositories.ClienteRepository;
import com.fapa.salessystem.repositories.EnderecoRepository;
import com.fapa.salessystem.repositories.EstadoRepository;
import com.fapa.salessystem.repositories.ItemPedidoRepository;
import com.fapa.salessystem.repositories.PagamentoRepository;
import com.fapa.salessystem.repositories.PedidoRepository;
import com.fapa.salessystem.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository prod;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Telefonia");
		Categoria cat4 = new Categoria(null, "Acessórios");
		Categoria cat5 = new Categoria(null, "Cozinha");
		Categoria cat6 = new Categoria(null, "Jardinagem");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		Categoria cat8 = new Categoria(null, "Decoração");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.0);
		Produto p2 = new Produto(null, "Impressora", 800.0);
		Produto p3 = new Produto(null, "Mouse", 80.0);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.0);
		Produto p5 = new Produto(null, "Toalha", 50.0);
		Produto p6 = new Produto(null, "Colcha", 200.0);
		Produto p7 = new Produto(null, "TV true color", 1200.0);
		Produto p8 = new Produto(null, "Roçadeira", 800.0);
		Produto p9 = new Produto(null, "Abajour", 100.0);
		Produto p10 = new Produto(null, "Pendente", 180.0);
		Produto p11 = new Produto(null, "Shampoo", 90.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().addAll(Arrays.asList(p8));
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().addAll(Arrays.asList(p11));
		
		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		repo.saveAll(Arrays.asList(cat2, cat1, cat3, cat4, cat5, cat6, cat7, cat8));
		prod.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Ceará");
		
		Cidade c1 = new Cidade(null, "Uberlândoa", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		Cidade c4 = new Cidade(null, "Itapipoca", est3);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est2.getCidades().addAll(Arrays.asList(c4));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "alexfapa32@gmail.com", "36378912377", TipoCliente.PESSOAFISICA, pe.encode("123"));
		Cliente cli2 = new Cliente(null, "Alex Pinto", "alexfapa32@outlook.com", "000.000.000-00", TipoCliente.PESSOAFISICA, pe.encode("321"));
		Cliente cli3 = new Cliente(null, "Duda", "duda@gmail.com", "000.000.000-01", TipoCliente.PESSOAFISICA, pe.encode("123"));
		
		cli2.addPerfil(Perfil.ADMIN);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		cli2.getTelefones().addAll(Arrays.asList("(88)997776277", "(85)995583020"));
		cli3.getTelefones().addAll(Arrays.asList("(85)998718768", "(85)995583020"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto. 20", "Jardim", "38228024", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "3877732", cli1, c2);
		Endereco e3 = new Endereco(null, "Rua Êubia Barroso", "2313", "-", "Boa Vista", "60730115", cli2, c3);
		Endereco e4 = new Endereco(null, "Rua Êubia Barroso", "2313", "-", "Boa Vista", "60730115", cli3, c4);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));
		cli3.getEnderecos().addAll(Arrays.asList(e3, e4));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("03/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		Pedido ped3 = new Pedido(null, sdf.parse("16/06/2021 10:35"), cli3, e4);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		Pagamento pagto3 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped3, sdf.parse("16/06/2021 10:35"), null);
		ped3.setPagamento(pagto3);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		cli3.getPedidos().addAll(Arrays.asList(ped3));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2, pagto3));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 200.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		ItemPedido ip4 = new ItemPedido(ped3, p5, 0.00, 2, 50.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip3));
		ped2.getItens().addAll(Arrays.asList(ip3));
		ped3.getItens().addAll(Arrays.asList(ip4));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3, ip4));

	}
}
