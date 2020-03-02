<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page import="model.Produto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
        <title>Gerenciamento de Estoque</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type= "text/css" href="css/main.css">
</head>
<body>
    <div class="container">
        <div class="menu">
            <a href='mercadoria'>
                <label class="espaco"> Mercadorias </label>
            </a>
            <a href='estoque'>
                <label class="espaco"> Estoque </label>
            </a>
            <a href='estoque'>
                <label class="espaco"> Gerenciamento </label>
            </a>
            <a href='cadastrar'>
                <label class="espaco"> Cadastrar </label>
            </a>
            <a href='relatorioestoque'>
                <label> Relatório </label>
            </a>
        </div>
        <div>
            <form action="relatorioestoque.action" method="get">
                    <div >
                            <input class="gerarRelatorio" type="submit" value="Gerar Relatório Estoque" class="submitButton"> 
                        </div>
                    <label class="labelestoque">Total estocado</label>
                    <div>
                        <% 
                            Integer quantidade = (Integer) request.getAttribute("quantidadeEstoque"); 
                            
                            if(quantidade != null){
                                out.print("<label>" + quantidade + "</label>");
                            } else{
                                out.print("<label>" + 0 + "</label>");
                            }
                        %>  
                    </div>
                    
                    <table>
                            <tr class="trcinza">
                                <th> Código</th>
                                <th> Nome</th>
                                <th> Unidade</th>
                                <th> Preço R$</th>
                                <th> Quantidade no Estoque</th>
                                <th> Descrição</th>
                            </tr>
                            
                            <%
                                String gerarRelatorio = (String) request.getAttribute("gerarRelatorio");

                                if(gerarRelatorio != null){
                                    List<Produto> items = (List) request.getAttribute("ListaProdutos");

                                    if(items != null){
                                        for(Produto p : items){
                                            out.print("<tr>");
                                                out.print("<td>" + p.getCodigo() + "</td>");
                                                out.print("<td>" + p.getNome() + "</td>");
                                                out.print("<td>" + p.getUnidade() + "</td>");
                                                out.print("<td>" + p.getPreco() + "</td>");
                                                out.print("<td>" + p.getQuantidade() + "</td>");
                                                out.print("<td>" + p.getDescricao() + "</td>");
                                            out.print("</tr>");
                                        }
                                    }
                                } else{
                                    String m = (String) request.getAttribute("mensagem"); 
                                    if(m != null){
                                        out.print(m);
                                    }
                                }
                            %>
                        </table>
            </form>
            
        </div>
    </div>
</body>