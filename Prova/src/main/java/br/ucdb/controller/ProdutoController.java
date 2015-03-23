package br.ucdb.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucdb.utils.Produto;

@WebServlet( "/ProdutoController") 
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		
		//esclusao
		String acao = request.getParameter("acao");
		GerenciadorProduto gp = new GerenciadorProduto();
		
		if (acao.equals("listar")){
			
			List<Produto> produtos =  gp.getProduto();
			
			request.setAttribute("prod", produtos);
			
			RequestDispatcher view = request.getRequestDispatcher("ViewProduto.jsp");
			view.forward(request, response);
			
		}else if (acao.equals("excluir")){
			
			String pos = request.getParameter("pos");
			gp.excluir(Integer.parseInt(pos));
			
			response.setContentType("text/html");
			response.getWriter().print("<script> window.alert('Excluido com sucesso'); location.href='ProdutoController?acao=listar' </script>");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String descricao   = request.getParameter("descricao");
		String valor  	   = request.getParameter("valor");

		Produto produto = new Produto();
		produto.setDescricao(descricao);
		produto.setValor(valor);
		
		request.setAttribute("descricao", produto.getDescricao());
		request.setAttribute("valor", produto.getValor());
		
		GerenciadorProduto gp = new GerenciadorProduto();
		gp.salvar(produto);
		
		response.setContentType("text/html");
		response.getWriter().print("<script> window.alert('Salvo com Sucesso'); location.href='ProdutoController?acao=listar' </script>");
	
		
	
		

	}

}
