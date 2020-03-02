<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <title>Gerenciamento de Estoque</title>
    <meta charset="UTF-8">
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
            <div>
                <form method='get' action="buscarCodigo.action">
                    <input class="tamanhominimo2" type='number' placeholder="Código da mercadoria" min='0' name="buscaCodigo">
                    <input class="tamanhominimo2" type="submit" value="Buscar Código">
                </form>
            </div>
        </div>
        <div>
            <table>
                <thead>
                    <tr>
                        <th> Código</th>
                        <th> Nome</th>
                        <th> Unidade</th>
                        <th> Preço R$</th>
                        <th> Quantidade no Estoque</th>
                        <th> Descrição</th>
                        <th> Atualizar</th>
                        <th> Excluir</th>
                    </tr>
                </thead>
                <%
                    Produto produto = (Produto) request.getAttribute("Produto"); 
                    Integer produtoCodigo = 0;
                    if(produto != null){ 
                        produtoCodigo = produto.getCodigo();
                    }
                %>
                <%
                    if(produto != null){
                            out.print("<tr>");
                                    out.print("<td>" + produto.getCodigo() + "</td>");
                                    out.print("<td>" + produto.getNome() + "</td>");
                                    out.print("<td>" + produto.getUnidade() + "</td>");
                                    out.print("<td>" + produto.getPreco() + "</td>");
                                    out.print("<td>" + produto.getQuantidade() + "</td>");
                                    out.print("<td>" + produto.getDescricao() + "</td>");
                                    out.print("<td> <button  id ='atualizarP' onclick=atualizar("+produto.getCodigo()+") > Atualizar</button> </td>");
                                    out.print("<td> <button id='excluir' onclick=remover("+produto.getCodigo()+") > Excluir</button></td>");
                            out.print("</tr>");
                    }
                %>
            </table>
            <div>
                <%
                    String mensagem = (String) request.getAttribute("mensagem"); 
                    if(mensagem != null){
                        out.print("<label> " + mensagem + " </label>");
                    }
                %>
            </div>
        </div>


        <script type="text/javascript">
            function atualizar(id){
                console.log('atualizar?id='+ id)
                window.location.href = 'atualizar?id='+ id;
            }

            function remover(id){
                console.log('excluir.action?id='+ id)
                window.location.href = 'excluir.action?id='+ id;
            }
        </script> 
    </div>
</body>