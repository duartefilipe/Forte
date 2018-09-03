<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/Images/Forte16x16.png'/>">
    <title> ForteSecurity</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet"
          href="<c:url value='/resources/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/Ionicons/css/ionicons.min.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/resources/AdminLTE/bower_components/jvectormap/jquery-jvectormap.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/dist/css/AdminLTE.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/dist/css/skins/_all-skins.min.css'/>">
    <link rel="stylesheet"
          href="<c:url value='/resources/AdminLTE/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/jquery-ui/jquery-ui.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/plugins/bootstrap-multiselect/bootstrap-multiselect.css'/>">
    <link rel="stylesheet" type="text/css"
          href="<c:url value='/resources/plugins/Font-Awesome/css/font-awesome.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/ionicons/ionicons.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/adminLTE/AdminLTE.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/adminLTE/skin-blue.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/c3.js/c3.min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/pivot.js/pivot.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/zoomjs/zoom.css'/>">
    <link type="text/css" media="screen" rel="stylesheet"
          href="<c:url value='/resources/plugins/jquery.multi-select.js/multi-select.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/dc.js/dc.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/plugins/jQRangeSlider/css/iThing-min.css'/>">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/dist/css/index.css'/>">


</head>
<body class="hold-transition skin-blue sidebar-mini">

<c:out value="${requestScope.usuario}"/>

<%--<jsp:useBean id="hosts" class="br.forte.DAO.ZabbixDao" />--%>
<%--<c:set var="hosts" value="${hosts.getHost()}" />--%>

<jsp:useBean id="hosts" class="br.forte.DAO.ZabbixDao"/>
<c:set var="hosts" value="${hosts.getHostsAdmin(usuario.idUsuario, usuario.tipo)}"/>

<jsp:useBean id="users" class="br.forte.DAO.UsuarioDao"/>
<c:set var="users" value="${users.getUsers()}"/>

<c:if test="${usuario != null}">

<c:if test="${usuario.tipo == 3}">

<div class="wrapper">

    <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo">

            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini">
                <b>Forte</b>
                <!--<img src="resources/Images/logo.png" class="img-responsive"/>-->
            </span>


            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">   <!--<img src="resources/Images/logo.png" class="img-responsive"/> -->
                <b>ForteSecurity</b>
            </span>
        </a>


        <nav class="navbar navbar-static-top" role="navigation">

            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"></a>

            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="logout"><i class="fa fa-sign-out"></i>Logout</a>
                    </li>
                </ul>
            </div>

        </nav>
    </header>

    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu">
                <li class="header">
                    MENU
                </li>

                <li>
                    <a href="index">
                        <i class="fa fa-dashboard"></i>
                        <span>Home</span>
                    </a>
                </li>

                <li>
                    <a href="Usuario">
                        <i class="fa fa-user"></i>
                        <span>Usuarios</span>
                    </a>
                </li>

                <li>
                    <a href="Trigger">
                        <i class="fa fa-book"></i>
                        <span>Triggers</span>
                    </a>
                </li>

                <li>
                    <a href="APIs">
                        <i class="fa fa-book"></i>
                        <span>APIs</span>
                    </a>
                </li>

                <li>
                    <a href="ZabiRepo">
                        <i class="fa fa-bar-chart"></i>
                        <span>Graphs</span>
                    </a>
                </li>


            </ul>
        </section>
    </aside>

    <div class="content-wrapper">
        <section class="content-header">
            <h1>
                Painel
                <small>principal</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">Painel</li>
            </ol>
        </section>
        <c:if test="${usuario.tipo == 3}">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        <section class="content">
                            <div class="row">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">Hosts</h3>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th>IP</th>
                                                <th>NOME</th>
                                                <th>Acessar</th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach var="listaHost" items="${hosts}">
                                                <tr>
                                                    <td><a href="#" data-toggle="modal" data-target="#modalhost"
                                                           style="color: black"><b>${listaHost.hostInterface.ip} ${listaHost.hostInterface.dns}</b></a>
                                                    </td>
                                                    <td>${listaHost.host.host}</td>
                                                    <td>
                                                        <a href="https://${listaHost.hostInterface.ip}${listaHost.hostInterface.dns}:4488"
                                                           target="_blank" style="color: #0a0a0a">Acessar</a></td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>IP</th>
                                                <th>NOME</th>
                                                <th>Acessar</th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <!-- /.box-body -->
                                </div>
                                <!-- /.box -->
                            </div>

                        </section>
                    </div>


                    <div class="col-md-6">
                        <section class="content">
                            <div class="row">
                                <div class="box">
                                    <div class="box-header">
                                        <h3 class="box-title">Usuarios</h3>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example2" class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th>Alias</th>
                                                <th>Nome</th>
                                                <th>email</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="list" items="${users}">
                                                <tr>
                                                    <td>${list.user.alias}</td>
                                                    <td>${list.user.name}</td>
                                                    <td>${list.media.sendto}</td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>Alias</th>
                                                <th>Nome</th>
                                                <th>email</th>
                                            </tr>
                                            </tfoot>
                                        </table>
                                    </div>
                                    <!-- /.box-body -->
                                </div>
                                <!-- /.box -->
                            </div>

                        </section>
                    </div>

                </div>
            </div>
        </c:if>
        <c:if test="${usuario.tipo == 2}">

            <div class="container-fluid">
                <section class="content">
                    <div class="row">
                        <div class="box">
                            <div class="box-header">
                                <h3 class="box-title">Hosts</h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <table id="example3" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>IP</th>
                                        <th>NOME</th>
                                        <th>Acessar</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    <c:forEach var="listaHost" items="${hosts}">
                                        <tr>
                                            <td><a href="#" data-toggle="modal" data-target="#modalhost"
                                                   style="color: black"><b>${listaHost.hostInterface.ip} ${listaHost.hostInterface.dns}</b></a>
                                            </td>
                                            <td>${listaHost.host.host}</td>
                                            <td>
                                                <a href="https://${listaHost.hostInterface.ip}${listaHost.hostInterface.dns}:4488"
                                                   target="_blank" style="color: #0a0a0a">Acessar</a></td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>IP</th>
                                        <th>NOME</th>
                                        <th>Acessar</th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>

                </section>

            </div>

        </c:if>
    </div>

    <footer class="main-footer">
        <div class="row>">
            <div class="pull-right hidden-xs">
                <b>Alpha Version</b> 1.0
                <button id="google_translate_element"></button>
            </div>

                <%--<div id="google_translate_element"></div>--%>
            <script type="text/javascript">
                function googleTranslateElementInit() {
                    new google.translate.TranslateElement({
                        pageLanguage: 'pt',
                        includedLanguages: 'en,es,pt',
                        layout: google.translate.TranslateElement.InlineLayout.SIMPLE,
                        multilanguagePage: true
                    }, 'google_translate_element');
                }
            </script>


            <strong>Copyright &copy; 2018-2018
                <a href="#">Forte Security</a>.
            </strong> All rights reserved.
        </div>
    </footer>


    <script>
        $(function () {
            $('#example1').DataTable()
            $('#example2').DataTable({
                'paging': true,
                'lengthChange': false,
                'searching': false,
                'ordering': true,
                'info': true,
                'autoWidth': false
            })
            $('#example3').DataTable()
            $('#example4').DataTable()
        })
    </script>

    <style>
        .example-modal .modal {
            position: relative;
            top: auto;
            bottom: auto;
            right: auto;
            left: auto;
            display: block;
            z-index: 1;
        }

        .example-modal .modal {
            background: transparent !important;
        }
    </style>

    <!-- Modal Host Inicio -->
    <div class="modal fade" id="modalhost">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Informaçoes sobre o host</h4>
                </div>
                <div class="modal-body">
                    <p>One fine body&hellip;</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal host FIM-->


    <!-- Modal cliente Inicio -->
    <div class="modal fade" id="modalcliente">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">Informaçoes sobre o cliente</h4>
                </div>

                <div class="box-body">
                    <table id="example4" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="user" items="${user}">
                            <tr>
                                <td><a href="#" data-toggle="modal" data-target="#modalhost"
                                       style="color: black"><b>${user.nome}</b></a></td>
                                <td>${user.email}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                        <tfoot>
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                        </tr>
                        </tfoot>
                    </table>
                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal cliente FIM-->

    </c:if>
    </c:if>
    <c:if test="${usuario.tipo == 2}">
    <script type="text/javascript">
        window.onload = function () {
            var vai = document.getElementById('ZabixGraphs');
            vai.click();
        };
    </script>

    <a href="ZabiRepo" id="ZabixGraphs"/>

        <%--<script type="text/javascript">--%>
        <%--function googleTranslateElementInit() {--%>
        <%--new google.translate.TranslateElement({--%>
        <%--pageLanguage: 'pt',--%>
        <%--includedLanguages: 'en,es,pt',--%>
        <%--layout: google.translate.TranslateElement.InlineLayout.SIMPLE,--%>
        <%--multilanguagePage: true--%>
        <%--}, 'google_translate_element');--%>
        <%--}--%>
        <%--</script>--%>

    </c:if>

    <%--<c:if test="${usuario.tipo == 2}">--%>
    <%--<% response.sendRedirect("ZabiRepo"); %>--%>
    <%--</c:if>--%>

    <c:if test="${sessionScope['usuario'] == null}">
            <% response.sendRedirect("logout"); %>
    </c:if>
    <script src="<c:url value='/resources/AdminLTE/bower_components/jquery/dist/jquery.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/fastclick/lib/fastclick.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/dist/js/adminlte.min.js'/>"></script>
    <%--<script src="<c:url value='/resources/AdminLTE/dist/js/demo.js'/>"></script>--%>
    <script src="<c:url value='https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js'/>"></script>
    <script src="<c:url value='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'/>"></script>

    <!-- JS -->
    <script type="text/javascript"
            src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js'/>"></script>
    <script type="text/javascript"
            src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/jquery/jquery-2.2.4.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/jquery-ui/jquery-ui.min.js'/>"></script>
    <script type="text/javascript"
            src="<c:url value='/resources/plugins/jQueryPlugin/jquery.ui.touch-punch.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/jQueryPlugin/js.cookie.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/jquery-csv.js/jquery.csv.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/pathseg/pathseg.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/bootstrap/js/bootstrap.min.js'/>"></script>
    <script type="text/javascript"
            src="<c:url value='/resources/plugins/bootstrap-multiselect/bootstrap-multiselect.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/adminLTE/app.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/d3.js/d3.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/c3.js/c3.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/pivot.js/pivot.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/pivot.js/c3_renderers.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/pivot.js/d3_renderers.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/zoomjs/zoom.js'/>"></script>
    <script type="text/javascript"
            src="<c:url value='/resources/plugins/jquery.multi-select.js/jquery.multi-select.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/jquery.blockUI/jquery.blockUI.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/crossfilter/crossfilter.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/dc.js/dc.js'/>"></script>
    <script type="text/javascript"
            src="<c:url value='/resources/plugins/jQRangeSlider/jQRangeSlider-min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/plugins/jqzabbix.js/jqzabbix.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/dist/js/zabirepo-param.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/resources/dist/js/zabirepo.js'/>"></script>
    <%--<script type="text/javascript" src="<c:url value='/resources/AdminLTE/dist/js/demo.js'/>"></script>--%>

    <script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>


</body>
</html>
