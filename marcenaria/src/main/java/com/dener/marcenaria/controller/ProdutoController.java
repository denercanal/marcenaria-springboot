package com.dener.marcenaria.controller;

import com.dener.marcenaria.model.Produto;
import com.dener.marcenaria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoRepository pr;

    @RequestMapping(value = "/cadastrarProduto", method = RequestMethod.GET)
    public String formulario() {
        return "produto/formProduto";
    }

    @RequestMapping(value = "/cadastrarProduto", method = RequestMethod.POST)
    public String formulario(Produto produto) {

        pr.save(produto);

        return "redirect:/cadastrarProduto";
    }

    @RequestMapping("/produtos")
    public ModelAndView listaProdutos() {
        ModelAndView mv = new ModelAndView("index");
        Iterable<Produto> produtos = pr.findAll();
        mv.addObject("produtos", produtos);
        return mv;
    }
}
