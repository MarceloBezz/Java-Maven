package br.com.alura;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import br.com.alura.model.Produto;
import br.com.alura.service.TraduzProdutoService;

public class Main {
    public static void main(String[] args) throws IllegalStateException, FileNotFoundException{
        List<Produto> beans = new CsvToBeanBuilder(new FileReader("src/main/resources/products.csv"))
                    .withType(Produto.class).build().parse();

        for (Produto produto : beans) {
            System.out.println(produto);
        }

        TraduzProdutoService traducaoService = new TraduzProdutoService();

        for (Produto produto : beans) {
            traducaoService.traduzir(produto);
            System.out.println(produto);
        }
    }
}