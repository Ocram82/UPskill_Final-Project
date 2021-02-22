<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="main">
        <div class="white_box vista_perfil">
            
            <img class="logo_small" src="/imagens/noun_centro_hospitalar_logo.svg" alt="Logo do centro hospitalar">
            <div class="user-type">
                <p id="user_name">Pedro Romano</p>
                <p id="user_category">Funcionário</p>
            </div>
            <div class="perfil-main-col">
                <div class="perfil-row">
                    <div class="cell-row">Sexo</div>
                    <div class="cell-row">Masculino</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Data de nascimento</div>
                    <div class="cell-row">01/01/1990</div>
                </div>

                <div class="perfil-row">
                    <div class="cell-row">Morada</div>
                    <div class="cell-row">Rua das Flores</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Código Postal</div>
                    <div class="cell-row">1100-100 Lisboa</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nacionalidade</div>
                    <div class="cell-row">Portuguesa</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Documento de identificação</div>
                    <div class="cell-row">Cartão do cidadão</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº do documento</div>
                    <div class="cell-row">1665616 q 161</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">NIF</div>
                    <div class="cell-row"> 456 851 974</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Nº de Utente</div>
                    <div class="cell-row"> 151 515 151</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">Telemóvel</div>
                    <div class="cell-row">915 452 657</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">E-mail</div>
                    <div class="cell-row">promano@upskill.pt</div>
                </div>
                <div class="perfil-row">
                    <div class="cell-row">
                        <form action="/alterar_registo" method="get">
                            <button class="btn-blue btn-w65">Alterar Registo</button>
                        </form>
                    </div>
                    <div class="cell-row">
                        <form action="/userToMain" method="get">
                            <button class="btn-green btn-w65">Página Principal</button>
                        </form>
                    </div>
                </div>
            </div>
        </>
    </div>

</body>

</html>