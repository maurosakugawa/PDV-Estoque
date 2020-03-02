<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page import="model.Produto"%>

<head>
    <title>Cadastro/Atualizar Mercadoria</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type= "text/css" href="css/main.css">
</head>
<body>
    <div class="container">
        <div>
            <div>
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
                    <label> Relatório   </label>
                </a>
            </div>
        </div>
        <div>
            <% Produto produto = (Produto) request.getAttribute("Produto"); 
            Integer atualizar = (Integer) request.getAttribute("Atualizar"); 
            Integer codigo = 0;
            String nome = "";
            String unidade = "";
            Double preco = 0 * 1.0;
            Integer quantidade = 0;
            String descricao = "";

            if(produto != null){
                codigo = produto.getCodigo();
                nome = produto.getNome();
                unidade = produto.getUnidade();
                preco = produto.getPreco();
                quantidade = produto.getQuantidade();
                descricao = produto.getDescricao();
            }

            if(atualizar == 1){%>
            <form action="atualizarProduto.action" method="post">
            <%} else{%>
            <form action="cadastro.action" method="post">
            <%} 
            %>

                <div id="grid">
                    <label class="tamanhominimo2">Código</label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="number" placeholder="Código" min="0" name="codigo" value="<%=codigo%>" readonly>
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="number" placeholder="Código do Produto" min="0" name="codigo">
                    <%} 
                    %>

                </div>
                <div id="grid">
                    <label class="tamanhominimo2">Nome</label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="text" placeholder="Nome da Mercadoria" name="nome" value="<%=nome%>">
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="text" placeholder="Nome da Mercadoria" name="nome">
                    <%} 
                    %>

                </div>
                <div id="grid">
                    <label class="tamanhominimo2">Unidade</label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="text" placeholder="Unidade da Mercadoria" name="unidade" value="<%=unidade%>">
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="text" placeholder="Unidade da Mercadoria" name="unidade">
                    <%} 
                    %>

                </div>
                <div id="grid">
                    <label class="tamanhominimo2">Preço R$</label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="number" placeholder="Preço Unitário do Produto" min="0.0" name="preco" step="any" value="<%=preco%>">
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="number" placeholder="Preço Unitário do Produto" min="0.0" name="preco" step="any">
                    <%} 
                    %>

                </div>
                <div id="grid">
                    <label class="tamanhominimo2">Quantidade no Estoque</label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="number" placeholder="Quantidade da Mercadoria no Estoque" min="1" name="quantidade" value="<%=quantidade%>">
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="number" placeholder="Quantidade da Mercadoria no Estoque" min="1" name="quantidade">
                    <%} 
                    %>
                   
                </div>
                <div id="grid">
                    <label class="tamanhominimo2">Descrição</label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="text" placeholder="Descrição da Mercadoria" name="descricao" value="<%=descricao%>">
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="text" placeholder="Descrição da Mercadoria" name="descricao">
                    <%} 
                    %>

                </div>
                <div id="grid">
                    <label></label>
                    <%
                    if(atualizar == 1){%>
                    <input class="tamanhominimo" type="submit" value="Atualizar" class="submitButton">
                    <%
                    } else{%>
                    <input class="tamanhominimo" type="submit" value="Salvar" class="submitButton">
                    <%} 
                    %>
                </div>
            </form>
        </div>
    </div>
</body>