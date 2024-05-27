package Pesquisa;
import java.util.Map;
import java.util.HashMap;

public class EstoqueProdutos {
    private Map<Long, Produto> estoqueProdutoMap;

    public EstoqueProdutos() {
        this.estoqueProdutoMap = new HashMap<>(){};
    }
    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutoMap.put(cod, new Produto(nome, preco, quantidade));
    }
    public void exibirProdutos(){
        System.out.println(estoqueProdutoMap);
    }
    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if(!estoqueProdutoMap.isEmpty()){
          for(Produto p : estoqueProdutoMap.values()){
            valorTotalEstoque += p.getQuantidade() * p.getPreco();
          }
        }
        return valorTotalEstoque;
    }
    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = Double.MIN_VALUE;
        if(!estoqueProdutoMap.isEmpty()){
            for(Produto p : estoqueProdutoMap.values()){
                if(p.getPreco() > maiorPreco){
                    produtoMaisCaro = p;
                }
            }
        }
        return produtoMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoque = new EstoqueProdutos();
        estoque.exibirProdutos();

        estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
        estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
        estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
        estoque.adicionarProduto(4L, "Teclado", 2, 40.0);


        estoque.exibirProdutos();

    // Calcula e exibe o valor total do estoque
    System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

    // Obtém e exibe o produto mais caro
    Produto produtoMaisCaro = estoque.obterProdutoMaisCaro();
    System.out.println("Produto mais caro: " + produtoMaisCaro);

    // Obtém e exibe o produto mais barato
    Produto produtoMaisBarato = estoque.obterProdutoMaisCaro();
    System.out.println("Produto mais barato: " + produtoMaisBarato);

    // Obtém e exibe o produto com a maior quantidade em valor no estoque
    Produto produtoMaiorQuantidadeValorTotal = estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque();
    System.out.println("Produto com maior quantidade em valor no estoque: " + produtoMaiorQuantidadeValorTotal);
    }
    private Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque() {
        
        throw new UnsupportedOperationException("Unimplemented method 'obterProdutoMaiorQuantidadeValorTotalNoEstoque'");
    }
    
}
