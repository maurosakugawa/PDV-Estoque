<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>
    <title>Relatório de Compra</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type= "text/css" href="css/main.css">
</head>
<div>
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
</div>
<div>
    <label>Relatório de Compra</label>
</div>
<div>
    <table>
        <tr>
            <th> Código</th>
            <th> Nome</th>
            <th> Marca</th>
            <th> Unidade</th>
            <th> Preço R$ unitário</th>
            <th> Quantidade</th>
            <th> Total item</th>
        </tr>

        <tr>
            <td> 0</td>
            <td> Caderno</td>
            <td> Tilibra</td>
            <td> Unit</td>
            <td> 15.90</td>
            <td> 2</td>
            <td> 31.80</td>
        </tr>

        <tr>
            <td> 1</td>
            <td> Lápis</td>
            <td> Faber Castel</td>
            <td> Unit</td>
            <td> 2.30</td>
            <td> 3</td>
            <td> 6.90</td>
        </tr>
    </table>
    <div>
        <label><b>Total da Compra: </b></label>
        <label>38.70</label>
    </div>
</div>
    