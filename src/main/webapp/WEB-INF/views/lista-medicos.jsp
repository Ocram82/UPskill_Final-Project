<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="components/head.jsp" %>

</head>

<body>
<%@ include file="components/sidenav-main.jsp" %>


<div class="main">
    <!--menu da direita-->

    <div class="white_box2 box-align-left">

        <div class="perfil-row">

            <img src="imagens/draw_patient.svg" alt="doctorsPage" class="img-fill-form"/>
            <h3 class="utente_title">Lista de Médicos</h3>
            <div class=search_patient>
                <form class="form-inline">
                    <input class="form-control mr-sm-2" type="search" placeholder="Nome do médico"
                           aria-label="Search">
                    <button class="btn-search" type="submit">Pesquisar</button>
                </form>
                <div class="choose_spec">
                    <select id="speciality_id" class="form-control" name="speciality">
                        <option value="" disabled selected>Pesquisar por Especialidade</option>
                        <option value="1">Cardiologia</option>
                        <option value="2">Osteopatia</option>
                    </select>
                </div>
            </div>
        </div>


        <div class="row">

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>

            <div class="card_list_doctor patient_data">
                <div class="user_photo w-50">
                    <img src="imagens/draw_avatar.svg" alt="avatar">
                </div>
                <h1 class="patient_name">Miguel Pereira</h1>
                <p class="spec_title">Especialidades:</p>
                <ul class="spec_list">
                    <li>
                        Cardiologia
                    </li>
                    <li>
                        Osteopatia
                    </li>
                </ul>
                <p>
                    <button type="button" class="btn-blue btn-w80"> Consultar Perfil
                    </button>
                </p>
            </div>


        </div>
    </div>

</div>
</body>

</html>