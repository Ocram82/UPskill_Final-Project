<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../components/head.jsp" %>
</head>

<body>

<c:if test="${user_logged.getAccount().equals('Recepcionista')}">
    <%@ include file="../components/sidenav-receptionist.jsp" %>
</c:if>
<c:if test="${user_logged.getAccount().equals('Utente')}">
    <%@ include file="../components/sidenav-utente.jsp" %>
</c:if>

<div class="main">
    <!--menu da direita-->
    <div class="white_box box-align-left">
        <div class="row first_row">
            <div class="row first_row invoiceimg">
                <div class="col-4">
                    <img src="/imagens/draw_invoice.png" alt="" class="icon1" />
                </div>
                <div class="col-8 intro">
                    <h3 class="title_next_appt">Factura</h3>
                </div>
            </div>
        </div>
        <div class="invoice-box">
            <table cellpadding="0" cellspacing="0">
                <tr class="top">
                    <td colspan="4">
                        <table>
                            <tr>
                                <td class="title">
                                    <img src="/imagens/noun_centro_hospitalar_logo.svg"
                                         class="invoice_img">
                                </td>

                                <td>
                                    Factura # <span>${invoice.getShortId()}</span>
                                    <br>
                                    <br>
                                    Emissão: <span>${invoice.getDueDateStr()}</span>
                                    <br>
                                    Vencimento: <span>${invoice.getIssuedDateStr()}</span>
                                    <br>
                                    <c:if test="${invoice.isPaid()}">
                                   <span>  Pagamento: ${invoice.getPaidDateStr()}</span>
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr class="information">
                    <td colspan="4">
                        <table>
                            <tr>
                                <td>
                                    R. Retiro dos Pacatos 50
                                    <br>
                                    Edifício Startup,
                                    <br>
                                    2635-224 Rio de Mouro
                                </td>

                                <td>
                                        ${appointment.getPatient().getFirstAndLastName()}
                                    <br>
                                        ${appointment.getPatient().getNif()}
                                    <br>
                                        ${appointment.getPatient().getEmail()}                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr class="heading">
                    <td colspan="3">Item</td>
                    <td>Valor (€)</td>
                </tr>

                <tr class="details">
                    <td colspan="3">Consulta de ${appointment.getSlot().getDoctor().getSpeciality().getName()}</td>
                    <td>${invoice.getValue()}</td>
                </tr>

                <tr class="total">
                    <td colspan="3"></td>
                    <td>Total: ${invoice.getValue()}€</td>
                </tr>
            </table>
        </div>
        <c:if test="${user_logged.getAccount().equals('Recepcionista')}">
            <c:if test="${!appointment.getInvoice().isPaid()}">
                <br/>
                <a type="button" href="/patient-receptionist/invoice/pay/${appointment.getInvoice().getInvoiceId()}" class="btn btn-green" > Pagar </a> </td>
            </c:if>
        <c:if test="${appointment.getInvoice().isPaid()}">
            <br/>
            <p class="invoice-paid"> Factura Paga</p>
        </c:if>
        </c:if>
    </div>
</div>


</body>

</html>