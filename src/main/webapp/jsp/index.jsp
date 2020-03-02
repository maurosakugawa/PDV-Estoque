<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="js/jquery-3.3.1.min.js"></script>
        <link rel="stylesheet" type= "text/css" href="css/main.css">
        <script src="js/app-ajax.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/codigo.js"></script>
        <script>
            var listaTabela = [];
            var listaCodigo2 = [];

            $(document).ready(function(){
                $("#pesquisarCodigo").click(function(){
                    if(listaTabela.indexOf($('#codigoCompra').val()) === -1){
                        listaTabela.push($('#codigoCompra').val());
                        listaCodigo2.push($('#codigoCompra').val());
                        $.ajax({
                            url : 'buscarCodigoCompra.action',
                            data : {
                                codigo : $('#codigoCompra').val()
                            },
                            success : function(result) {
                                $("#tabelaCompra").find('tbody').append(result);
                            }
                        });
                    } else{
                        alert("O Produto já está no carrinho!");
                    }
                });

                $("#compraFinal").click(function(){
                    if(listaTabela.length > 0){
                        console.log(listaCodigo2);
                        for(var i = 0; i < listaTabela.length; i++){
                            listaCodigo2.push($("#quantidade"+listaTabela[i]).val());
                            console.log(listaCodigo2);
                        }
                        $.ajax({
                            url : 'relatorioCompra.action',
                            data:{
                                listaCodigo: JSON.stringify(listaCodigo2),
                            },
                            success : function(result) {
                                $("#relatorioFinal").find('tbody').append(result);
                            },
                            error: function(erro){
                                alert("Erro ao finalizar Compra!");
                            }
                        });
                    } else{
                        alert("Não Existe Produto no carrinho!");
                    }
                });

            });
        </script>
        <title>Mercadorias</title>
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
                    <span class="spanminimo"  id='barra'> Código </span>
                    <input class="tamanhominimo3" type='number' placeholder="Código da mercadoria" min='0' id="codigoCompra">
                    <button type='button' style="width:90px" id="pesquisarCodigo"> 
                        <label> Buscar </label>
                    </button>
                </div>
            </div>
            <div>
                <table id='tabelaCompra'>

                        <tr>
                            <th> Código</th>
                            <th> Nome</th>
                            <th> Unidade</th>
                            <th> Preço R$</th>
                            <th> Quantidade</th>
                        </tr>
                </table>
                <button  type="button" style="width:90px" id="compraFinal"> Comprar </button>
            </div>
            <div>
                <table id="relatorioFinal">
                    <tr>
                        <th style="display:none;">A</th>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>