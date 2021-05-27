[1mdiff --git a/src/main/java/com/fapa/salessystem/SalesSystemApplication.java b/src/main/java/com/fapa/salessystem/SalesSystemApplication.java[m
[1mindex 18ce874..31bb77a 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/SalesSystemApplication.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/SalesSystemApplication.java[m
[36m@@ -32,8 +32,6 @@[m [mimport com.fapa.salessystem.repositories.PagamentoRepository;[m
 import com.fapa.salessystem.repositories.PedidoRepository;[m
 import com.fapa.salessystem.repositories.ProdutoRepository;[m
 [m
[31m-[m
[31m-//adicionada brach pc-ideapad[m
 @SpringBootApplication[m
 public class SalesSystemApplication implements CommandLineRunner{[m
 [m
[1mdiff --git a/src/main/java/com/fapa/salessystem/domain/ItemPedido.java b/src/main/java/com/fapa/salessystem/domain/ItemPedido.java[m
[1mindex 739367d..9f3f97f 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/domain/ItemPedido.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/domain/ItemPedido.java[m
[36m@@ -31,27 +31,18 @@[m [mpublic class ItemPedido implements Serializable{[m
 		this.preco = preco;[m
 	}[m
 	[m
[31m-	[m
[31m-	public double getSubtotal() {[m
[31m-		return (preco - desconto) * quantidade;[m
[31m-	}[m
[31m-	[m
 	@JsonIgnore // esta anotação ignora a serialização[m
 	public Pedido getPedido() {[m
 		return id.getPedido();[m
 	}[m
 	[m
[31m-	public void setPedido(Pedido pedido) {[m
[31m-		id.setPedido(pedido);[m
[32m+[m	[32mpublic double getSubtotal() {[m
[32m+[m		[32mreturn (preco - desconto) * quantidade;[m
 	}[m
 	[m
 	public Produto getProduto() {[m
 		return id.getProduto();[m
 	}[m
[31m-	[m
[31m-	public void setProduto(Produto produto) {[m
[31m-		id.setProduto(produto);[m
[31m-	}[m
 [m
 	public ItemPeditoPk getId() {[m
 		return id;[m
[1mdiff --git a/src/main/java/com/fapa/salessystem/domain/Pagamento.java b/src/main/java/com/fapa/salessystem/domain/Pagamento.java[m
[1mindex 9494a60..dbcf1ee 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/domain/Pagamento.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/domain/Pagamento.java[m
[36m@@ -12,13 +12,10 @@[m [mimport javax.persistence.OneToOne;[m
 [m
 import com.fapa.salessystem.domain.enums.EstadoPagamento;[m
 import com.fasterxml.jackson.annotation.JsonIgnore;[m
[31m-import com.fasterxml.jackson.annotation.JsonTypeInfo;[m
[31m-import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;[m
 [m
 @Entity[m
 @Inheritance(strategy = InheritanceType.JOINED) //para gerar um tabelão contendo os campos das duas tabelas herdeiras[m
[31m-@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type") //esta anotação serve para indicar que a classe pagamento terá um campo adicional chamado @type[m
[31m-public abstract class Pagamento implements Serializable{                                          //a mesma se referencia ao tipo de pagamento (com boleto ou cartão)[m
[32m+[m[32mpublic abstract class Pagamento implements Serializable{[m
 	[m
 	private static final long serialVersionUID = 1L;[m
 	[m
[1mdiff --git a/src/main/java/com/fapa/salessystem/domain/PagamentoComBoleto.java b/src/main/java/com/fapa/salessystem/domain/PagamentoComBoleto.java[m
[1mindex a04f795..434ae81 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/domain/PagamentoComBoleto.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/domain/PagamentoComBoleto.java[m
[36m@@ -6,10 +6,8 @@[m [mimport javax.persistence.Entity;[m
 [m
 import com.fapa.salessystem.domain.enums.EstadoPagamento;[m
 import com.fasterxml.jackson.annotation.JsonFormat;[m
[31m-import com.fasterxml.jackson.annotation.JsonTypeName;[m
 [m
 @Entity[m
[31m-@JsonTypeName("pagamentoComBoleto") //esta anotação serve para definir o conteúdo do campo @type que está na classe pai[m
 public class PagamentoComBoleto extends Pagamento{[m
 	[m
 	private static final long serialVersionUID = 1L;[m
[1mdiff --git a/src/main/java/com/fapa/salessystem/domain/PagamentoComCartao.java b/src/main/java/com/fapa/salessystem/domain/PagamentoComCartao.java[m
[1mindex 1df7d4f..9817414 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/domain/PagamentoComCartao.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/domain/PagamentoComCartao.java[m
[36m@@ -3,10 +3,8 @@[m [mpackage com.fapa.salessystem.domain;[m
 import javax.persistence.Entity;[m
 [m
 import com.fapa.salessystem.domain.enums.EstadoPagamento;[m
[31m-import com.fasterxml.jackson.annotation.JsonTypeName;[m
 [m
 @Entity[m
[31m-@JsonTypeName("pagamentoComCartao") //esta anotação serve para definir o conteúdo do campo @type que está na classe pai[m
 public class PagamentoComCartao extends Pagamento{[m
 	[m
 	private static final long serialVersionUID = 1L;[m
[1mdiff --git a/src/main/java/com/fapa/salessystem/resources/PedidoResource.java b/src/main/java/com/fapa/salessystem/resources/PedidoResource.java[m
[1mindex 222be03..6b9d450 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/resources/PedidoResource.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/resources/PedidoResource.java[m
[36m@@ -1,22 +1,14 @@[m
 package com.fapa.salessystem.resources;[m
 [m
 [m
[31m-import java.net.URI;[m
[31m-[m
[31m-import javax.validation.Valid;[m
[31m-[m
 import org.springframework.beans.factory.annotation.Autowired;[m
 import org.springframework.http.ResponseEntity;[m
 import org.springframework.web.bind.annotation.PathVariable;[m
[31m-import org.springframework.web.bind.annotation.RequestBody;[m
 import org.springframework.web.bind.annotation.RequestMapping;[m
 import org.springframework.web.bind.annotation.RequestMethod;[m
 import org.springframework.web.bind.annotation.RestController;[m
[31m-import org.springframework.web.servlet.support.ServletUriComponentsBuilder;[m
 [m
[31m-import com.fapa.salessystem.domain.Categoria;[m
 import com.fapa.salessystem.domain.Pedido;[m
[31m-import com.fapa.salessystem.dto.CategoriaDTO;[m
 import com.fapa.salessystem.services.PedidoService;[m
 [m
 @RestController[m
[36m@@ -31,13 +23,4 @@[m [mpublic class PedidoResource {[m
 		Pedido obj = service.find(id);[m
 		return ResponseEntity.ok().body(obj);[m
 	}[m
[31m-	[m
[31m-	@RequestMapping(method = RequestMethod.POST)[m
[31m-	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido obj){[m
[31m-		obj = service.insert(obj);[m
[31m-		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()[m
[31m-				.path("/{id}").buildAndExpand(obj.getId()).toUri();[m
[31m-		return ResponseEntity.created(uri).build();[m
[31m-	}[m
[31m-	[m
 }[m
[1mdiff --git a/src/main/java/com/fapa/salessystem/services/PedidoService.java b/src/main/java/com/fapa/salessystem/services/PedidoService.java[m
[1mindex 6b1097d..14f4609 100644[m
[1m--- a/src/main/java/com/fapa/salessystem/services/PedidoService.java[m
[1m+++ b/src/main/java/com/fapa/salessystem/services/PedidoService.java[m
[36m@@ -1,39 +1,19 @@[m
 package com.fapa.salessystem.services;[m
 [m
[31m-import java.util.Date;[m
 import java.util.Optional;[m
 [m
 import org.springframework.beans.factory.annotation.Autowired;[m
 import org.springframework.stereotype.Service;[m
 [m
[31m-import com.fapa.salessystem.domain.ItemPedido;[m
[31m-import com.fapa.salessystem.domain.PagamentoComBoleto;[m
 import com.fapa.salessystem.domain.Pedido;[m
[31m-import com.fapa.salessystem.domain.Produto;[m
[31m-import com.fapa.salessystem.domain.enums.EstadoPagamento;[m
[31m-import com.fapa.salessystem.repositories.ItemPedidoRepository;[m
[31m-import com.fapa.salessystem.repositories.PagamentoRepository;[m
 import com.fapa.salessystem.repositories.PedidoRepository;[m
[31m-import com.fapa.salessystem.repositories.ProdutoRepository;[m
 import com.fapa.salessystem.services.exceptions.ObjectNotFoundException;[m
 [m
 @Service[m
 public class PedidoService {[m
 	[m
 	@Autowired[m
[31m-	private PedidoRepository repo;[m
[31m-	[m
[31m-	@Autowired[m
[31m-	private BoletoService boletoService;[m
[31m-	[m
[31m-	@Autowired[m
[31m-	private PagamentoRepository pagamentoRepository;[m
[31m-	[m
[31m-	@Autowired[m
[31m-	private ProdutoRepository produtoRepository;[m
[31m-	[m
[31m-	@Autowired[m
[31m-	private ItemPedidoRepository itemPedidoRepository;[m
[32m+[m	[32mPedidoRepository repo;[m
 	[m
 	public Pedido find(Integer id) {[m
 		Optional<Pedido> obj = repo.findById(id);[m
[36m@@ -41,28 +21,4 @@[m [mpublic class PedidoService {[m
 				"Objeto não encontrado! Id: " + id + ", Tipo: "+ Pedido.class.getName()));[m
 	}[m
 	[m
[31m-	public Pedido insert(Pedido obj) {[m
[31m-		obj.setId(null);[m
[31m-		obj.setInstante(new Date());[m
[31m-		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);	[m
[31m-		obj.getPagamento().setPedido(obj);[m
[31m-		if (obj.getPagamento() instanceof PagamentoComBoleto) {[m
[31m-			PagamentoComBoleto pgto = (PagamentoComBoleto) obj.getPagamento();[m
[31m-			boletoService.preencherPagamentoComBoleto(pgto, obj.getInstante());[m
[31m-		}[m
[31m-		[m
[31m-		obj = repo.save(obj);[m
[31m-		pagamentoRepository.save(obj.getPagamento());[m
[31m-		for (ItemPedido ip : obj.getItens()) {[m
[31m-			Optional<Produto> prod = produtoRepository.findById(ip.getProduto().getId());[m
[31m-			ip.setDesconto(0.0);[m
[31m-			ip.setPreco(prod.get().getPreco());[m
[31m-			ip.setPedido(obj);[m
[31m-		}[m
[31m-		[m
[31m-		itemPedidoRepository.saveAll(obj.getItens());[m
[31m-		return obj;[m
[31m-		[m
[31m-	}[m
[31m-	[m
 }[m
