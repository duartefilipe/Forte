<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="https" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>ForteSecurity</title>
    <!-- for responsive -->
    <!-- <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"> -->
    <meta content="width=device-width" name="viewport">


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
    <%--<script type="text/javascript" charset="UTF-8"--%>
    <%--src="<c:url value='https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js'/>"></script>--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>--%>
</head>

<body class="skin-blue sidebar-mini login-page">

<c:out value="${requestScope.usuario}"/>

<jsp:useBean id="hostinterfaces" class="br.forte.DAO.ZabbixDao"/>
<c:set var="hostinterfaces" value="${hostinterfaces.getHostInterface()}"/>

<jsp:useBean id="hosts" class="br.forte.DAO.ZabbixDao"/>
<c:set var="host" value="${hosts.getHost()}"/>

<jsp:useBean id="usuarios" class="br.forte.DAO.UsuarioDao"/>
<c:set var="user" value="${usuarios.getUsuarios()}"/>

<c:if test="${usuario != null}">

    <script type="text/javascript">
        window.onload = function () {
            var enviar = document.getElementById('submit_login');
            enviar.click();
            console.log("document is ready");
        };
    </script>

    <%--<script>--%>
    <%--function ready() {--%>
    <%--var enviar =document.getElementById('submit_login');--%>
    <%--enviar.click();--%>
    <%--}--%>
    <%--</script>--%>


    <div id="top_login">
        <h1 align="center">CARREGANDO</h1>
        <div class="col-md-5"></div>

        <div class="col-md-4">
            <img src="/resources/Images/loading.gif" alt=""/>
                <%--<img src="https://tenor.com/PwmK.gif" alt=""/>--%>

            <input type="hidden" id="inputUser" value="${usuario.userzabbix}"/>
            <input type="hidden" id="inputPasswd" value="${usuario.senhazabbix}"/>
            <input type="hidden" id="submit_login"/>
        </div>

        <div class="col-md-3"></div>
    </div>
    <!-- /.login-box -->

    <div id="top_contents" style="display: none;">
        <div class="wrapper">
            <!-- header -->
            <header class="main-header">
                <div href="" class="logo">
                    ForteSecurity
                </div>

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
            <!-- end header -->

            <!-- sidebar -->
            <aside class="main-sidebar">
                <section class="sidebar" style="height: auto;">
                    <ul class="sidebar-menu">
                        <li class="header">
                            MENU
                        </li>
                        <c:if test="${usuario.tipo == 3}">
                            <li>
                                <a href="index"><i class="fa fa-dashboard"></i> <span>Home</span> </a>
                            </li>
                        </c:if>


                        <li>
                            <a href="" id="menu_dashboard"><i class="fa fa-dashboard"></i> <span>DashBoard</span> </a>
                        </li>

                        <li>
                            <a href="#"><i class="fa fa-history"></i> <span>Eventos</span> <i
                                    class="fa fa-angle-left pull-right"></i></a>
                            <ul class="treeview-menu">
                                <li>
                                    <a href="#" id="menu_histogram"><i class="fa fa-bar-chart"></i> Histograma</a>
                                </li>
                                <li>
                                    <a href="#" id="menu_pivottable"><i class="fa fa-table"></i>
                                        Tabela Dinâmica</a>
                                </li>
                                <li>
                                    <a href="#" id="menu_treemap"><i class="fa fa-tree"></i> Tabela Cores</a>
                                </li>
                                <li>
                                    <a href="#" id="menu_free"><i class="fa fa-circle-o"></i> Tabela livre</a>
                                </li>
                            </ul>
                        </li>

                        <li class="treeview">
                            <a href="#"> <i class="fa fa-line-chart"></i> <span>Graficos</span> <i
                                    class="fa fa-angle-left pull-right"></i> </a>
                            <ul class="treeview-menu">
                                <li>
                                    <a href="#"><i class="fa fa-circle-o"></i>Groupos<i
                                            class="fa fa-angle-left pull-right"></i></a>
                                    <ul class="treeview-menu" id="menu_group_top"></ul>
                                </li>
                                <li>
                                    <a href="#"><i class="fa fa-circle-o"></i> Itens por Grupo <i
                                            class="fa fa-angle-left pull-right"></i></a>

                                    <ul class="treeview-menu" id="menu_item_top"></ul>
                                </li>
                            </ul>
                        </li>

                        <li>
                            <a href="#" id="menu_setting"><i class="fa fa-gears"></i> <span>Configuraçoes</span></a>
                        </li>
                    </ul>
                </section>
            </aside>
            <!-- end sidebar -->

            <!-- content -->
            <div class="content-wrapper">

                <!-- for dashboard -->
                <div id="base_dashboard">

                    <section class="content-header">
                        <h1>DashBoard</h1>
                    </section>

                    <section class="content">

                        <!-- Alert Information -->
                        <div class="row">
                            <div class="col-xs-12 col-sm-12 col-md-5 col-lg-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-red"><i class="fa fa-exclamation-triangle"></i></span>

                                    <div class="info-box-content">
                                        <span class="info-box-text">Problemas <!-- Problem Triggers --></span><span
                                            class="info-box-number"
                                            id="infobox_alertTrigger">--</span>
                                    </div>
                                    <!-- /.info-box-content -->
                                </div>
                                <!-- /.info-box -->
                            </div>
                            <!-- /.col -->
                            <div class="col-xs-12 col-sm-12 col-md-5 col-lg-3">
                                <div class="info-box">
                                    <span class="info-box-icon bg-yellow"><i
                                            class="fa fa-exclamation-circle"></i></span>

                                    <div class="info-box-content">
                                        <span class="info-box-text">Eventos não reconhecidos</span><span
                                            class="info-box-number" id="unAcknowledgedEvents">--</span>
                                    </div>
                                    <!-- /.info-box-content -->
                                </div>
                                <!-- /.info-box -->
                            </div>
                            <!-- /.col -->

                            <!-- fix for small devices only -->
                            <!-- <div class="clearfix visible-sm-block"></div> -->

                            <div class="col-xs-3 col-sm-2 col-md-2 col-lg-1 form-group pull-right" style="float: left;">
                                <select id="reload_dashboard_selecter" class="form-control pull-right">
                                    <option value="0">Manual</option>
                                    <option value="3">3s</option>
                                    <option value="30">30s</option>
                                    <option value="60">60s</option>
                                    >
                                </select>
                            </div>
                            <div>
                                <button id="reload_dashboard" type="button" class="btn  btn-default pull-right">
                                    <i class="glyphicon glyphicon-refresh"></i>
                                    <text id="countDownTimer"></text>
                                </button>
                            </div>

                            <div class="col-xs-1 pull-right"></div>
                            <div class="pull-right" style="clear: left;">
                                <b>Ultima Atualizaçao: </b>
                                <text id="lastUpdateDashboard"></text>
                            </div>

                        </div>
                        <!-- /.row -->

                        <div class="box box-info">
                            <div class="box-header with-border">
                                <%--<h3 class="box-title">Problem Triggers Summary</h3>--%>
                                <h3 class="box-title">Sumario de problemas</h3>

                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                        <i class="fa fa-minus"></i>
                                    </button>

                                </div>
                            </div>
                            <!-- /.box-header -->

                            <!-- aqui e o quadro que mostra o grafico em pizza (erro da cor  sempre azul -->

                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                                        <div id="chart_severity">
                                            <p>
                                                Severidade
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                                        <div id="chart_hostGroup">
                                            <p>
                                                Grupo de Hosts
                                            </p>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                                        <div id="chart_host">
                                            <p>
                                                Host
                                            </p>
                                        </div>
                                    </div>
                                </div>

                            </div>
                                <%--<!-- /.box-body -->--%>

                        </div>
                        <!-- /.box -->

                        <div class="row">
                            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3" style="display: none;">
                                <div class="box box-info">

                                    <div class="box-header with-border">
                                            <%--<h3 class="box-title">Problem Events History</h3>--%>
                                        <h3 class="box-title">Historico de Problemas</h3>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                                <i class="fa fa-minus"></i>
                                            </button>
                                        </div>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <div class="row"></div>
                                    </div>
                                    <!-- /.box-body -->
                                </div>
                                <!-- /.box -->
                            </div>
                        </div>

                        <!-- TABLE: LATEST ORDERS -->
                        <div class="box box-info">
                            <div class="box-header with-border">
                                    <%--<h3 class="box-title">Problem Triggers List</h3>--%>
                                <h3 class="box-title">Lista de Problemas</h3>
                                <div class="box-tools pull-right">
                                    <button type="button" class="btn btn-box-tool" data-widget="collapse">
                                        <i class="fa fa-minus"></i>
                                    </button>
                                </div>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="table-responsive">
                                    <table class="table no-margin table-condensed table-hover table-striped"
                                           id="eventList">
                                        <thead>
                                        <tr>
                                            <th>Gravidade</th>
                                            <th>Status</th>
                                            <th>Ultima Atualizaçao</th>
                                            <th>Tempo</th>
                                                <%--<th>Acknowledged</th>--%>
                                            <th>Host</th>
                                            <th>Descriçao</th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                        </div>
                        <!-- /.box -->
                    </section>
                </div>
                <!-- end dashboard -->

                <!-- for event -->
                <div id="base_event" style="display: none;">
                    <section class="content-header">
                        <h1>Eventos</h1>
                    </section>
                    <section class="content">

                        <div id="base_histogram" style="display: none;">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Histograma</h3>
                                </div>

                                <div class="box-body">
                                    <button type="submit" class="btn btn-primary" id="save_event_histogram">
                                        Salvar
                                    </button>
                                    <button type="submit" class="btn btn-default" id="clear_event_histogram">
                                        Limpar
                                    </button>
                                    <span class="label" id="label_event_histogram"></span><span
                                        class="alert alert-success" id="alert_event_histogram">Sucesso</span>
                                    <div id="event_histogram" style="margin: 30px;"></div>
                                </div>
                            </div>
                        </div>

                        <div id="base_pivottable" style="display: none;">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">
                                        Tabela Dinâmica</h3>
                                </div>

                                <div class="box-body">
                                    <button type="submit" class="btn btn-primary" id="save_event_pivot">
                                        Salvar
                                    </button>
                                    <button type="submit" class="btn btn-default" id="clear_event_pivot">
                                        Limpar
                                    </button>
                                    <span class="label" id="label_event_pivot"></span><span class="alert alert-success"
                                                                                            id="alert_event_pivot">Sucesso</span>
                                    <div id="event_pivot" style="margin: 30px;"></div>
                                </div>
                            </div>
                        </div>

                        <div id="base_treemap" style="display: none;">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">TreeMap</h3>
                                </div>

                                <div class="box-body">
                                    <button type="submit" class="btn btn-primary" id="save_event_treemap">
                                        Salvar
                                    </button>
                                    <button type="submit" class="btn btn-default" id="clear_event_treemap">
                                        Limpar
                                    </button>
                                    <span class="label" id="label_event_treemap"></span><span
                                        class="alert alert-success" id="alert_event_treemap">Sucesso</span>
                                    <div id="event_treemap" style="margin: 30px;"></div>
                                </div>
                            </div>
                        </div>

                        <div id="base_free" style="display: none;">
                            <div class="box box-primary">
                                <div class="box-header with-border">
                                    <h3 class="box-title">Livre</h3>
                                </div>

                                <div class="box-body">
                                    <button type="submit" class="btn btn-primary" id="save_event_free">
                                        Salvar
                                    </button>
                                    <button type="submit" class="btn btn-default" id="clear_event_free">
                                        Limpar
                                    </button>
                                    <span class="label" id="label_event_free"></span><span class="alert alert-success"
                                                                                           id="alert_event_free">Sucesso</span>
                                    <div id="event_free" style="margin: 30px;"></div>
                                </div>
                            </div>
                        </div>
                    </section>

                </div>
                <!-- end event -->

                <!-- for report  -->
                <div id="base_graph" style="display: none;">
                    <section class="content-header">
                        <h1>Graficos</h1>
                        <div id="reportName" class="bg-success text-center"></div>
                        <div id="graphCount" class="pull-right"></div>
                    </section>
                    <section class="content">
                        <div class="panel panel-info">
                            <div class="panel-body">
                                <div class="form-inline">
                                    <div id="periodSelect" class="btn-group" style="float:left;">
                                        <button type="button" class="btn btn-primary btn-sm active" id="period0">
                                            1h
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period1">
                                            2h
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period2">
                                            3h
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period3">
                                            6h
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period4">
                                            12h
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period5">
                                            1d
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period6">
                                            3d
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period7">
                                            7d
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period8">
                                            14d
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period9">
                                            1m
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period10">
                                            3m
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period11">
                                            6m
                                        </button>
                                        <button type="button" class="btn btn-primary btn-sm" id="period12">
                                            1y
                                        </button>
                                    </div>

                                    <!-- TODO: time picker -->

                                    <button id="reflesh_graph" type="button" class="btn  btn-default pull-right">
                                        <i class="glyphicon glyphicon-refresh"></i>
                                    </button>
                                </div>

                                <p></p><br>
                                <div id="table_base"><br>
                                    <div class="row" id="table"></div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <!-- end graph -->

                <!-- for setting -->
                <div id="base_setting" style="display: none;">

                    <section class="content-header">
                        <h1>Configuraçoes</h1>
                    </section>
                    <section class="content">

                        <ul class="nav nav-tabs">
                            <li class="active">
                                <a href="#tab_event_setting" data-toggle="tab">Eventos</a>
                            </li>
                            <li>
                                <a href="#tab_graph_setting" data-toggle="tab">Graficos</a>
                            </li>
                            <li>
                                <a href="#tab_etc_setting" data-toggle="tab">Reset</a>
                            </li>

                        </ul>

                        <div id="settingTabContent" class="tab-content">

                            <div class="tab-pane fade in active" id="tab_event_setting">
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <h6 class="panel-title">Periodo dos Eventos</h6>
                                    </div>
                                    <div class="panel-body">

                                        <form role="form">
                                            <div class="form-group">
                                                <div class="col-xs-12 col-sm-12 col-md-5 col-lg-3">
                                                    <label class="control-label settingInfoLabel">Escolha quantos dias
                                                        deseja visualizar</label>
                                                </div>
                                                <div class="col-xs-4 col-sm-4 col-md-4 col-lg-3">
                                                    <input type="text" class="form-control" id="form_beforeDay">
                                                </div>
                                            </div>
                                        </form>

                                    </div>
                                </div>

                                <button type="submit" class="btn btn-primary" id="submit_form_beforeDay">
                                    Enviar
                                </button>
                                <button type="submit" class="btn btn-default" id="cancel_form_beforeDay">
                                    Cancelar
                                </button>
                                <span class="alert alert-success" id="alert_form_beforeDay">Sucesso</span>

                            </div>

                            <div class="tab-pane fade" id="tab_graph_setting">
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <h6 class="panel-title">Chave de item do Zabbix
                                        </h6>
                                    </div>
                                    <div class="panel-body">

                                        <td style="width: 210px; word-break: break-all;">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-3">

                                                <div class="settingInfoLabel">
                                                    Selecione a chave do item Zabbix de destino
                                                </div>

                                            </div>
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-8">
                                                <form name="myForm">
                                                    <table id="graph_setting-table"
                                                           class="table table-striped table-responsive">
                                                        <thead>
                                                        <tr>
                                                            <th></th>
                                                            <th class="text-center">Nome da chave do item</th>
                                                            <th></th>
                                                            <th class="text-center">split</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody id="graph_setting-tbody">
                                                        <tr>
                                                            <td>
                                                                <p class="ui-state-default ui-corner-all">
                                                                    <span class="ui-icon ui-icon-arrowthick-2-n-s graph_setting-icon"></span>
                                                                </p></td>
                                                            <td>
                                                                <input type="text" size="60px"
                                                                       class="form-control input_zbx_key">
                                                            </td>
                                                            <td>
                                                                <button type="button" class="btn btn-info addList">
                                                                    Add
                                                                </button>
                                                                <button type="button" class="btn btn-danger removeList"
                                                                        disabled>
                                                                    Delete
                                                                </button>
                                                            </td>
                                                            <td></td>
                                                            <td>
                                                                <div class="checkbox">
                                                                    <input class="input_zbx_split" type="checkbox"
                                                                           value="1" checked="checked">
                                                                </div>
                                                            </td>
                                                        </tr>
                                                        </tbody>
                                                    </table>
                                                </form>
                                            </div>
                                    </div>
                                </div>

                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <h6 class="panel-title">Grupo Zabbix</h6>
                                    </div>
                                    <div class="panel-body">

                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-3">
                                            <div class="settingInfoLabel">
                                                Selecione o grupo do Zabbix
                                            </div>
                                        </div>
                                        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-9">
                                            <select id='zbxGroup' multiple='multiple'></select>
                                            <br>
                                            <a href='#' id='select-all-zbxGroup'>Selecionar Todos</a> / <a href='#'
                                            </a>
                                        </div>

                                    </div>
                                </div>

                                <button type="submit" class="btn btn-primary" id="submit_graph_setting">
                                    Enviar
                                </button>
                                <button type="submit" class="btn btn-default" id="cancel_graph_setting">
                                    Cancelar
                                </button>
                                <span class="alert alert-success" id="alert_graph_setting">Sucesso</span>
                                <div></div>

                            </div>

                            <div class="tab-pane fade" id="tab_etc_setting">
                                <div class="panel panel-info">
                                    <div class="panel-heading">
                                        <h6 class="panel-title">Configuraçoes</h6>
                                    </div>
                                    <div class="panel-body">

                                        <button id="allClear" type="button" class="btn btn-default">
                                            Limpar todas configuraçoes
                                        </button>
                                        <!-- <button id="export" type="button" class="btn btn-default">
                                        Setting Export
                                        </button>
                                        <button id="import" type="button" class="btn btn-default">
                                        Setting Import
                                        </button> -->

                                    </div>

                                    <div id="timeSelect"></div>
                                </div>
                            </div>

                        </div>
                    </section>
                </div>
                <!-- end setting -->

            </div>
            <!-- end content -->

            <!-- footer -->
            <footer class="main-footer">
                <div class="row>">
                    <div class="pull-right hidden-xs">
                        <b>Version</b> 1.0
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
        </div>
        <!-- end wrapper -->
    </div>
    </div>
    <!-- alert modal -->
    <div class="modal fade" id="modal-alert" tabindex="-1">
        <div class="modal-dialog modal-danger modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="modal-label">Alert</h4>
                </div>
                <div class="modal-body" id="modal-alert-text"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        Close
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- end alert modal -->

    <div class="modal fade" id="modal-info" tabindex="-1">
        <div class="modal-dialog modal-info modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="modal-label1">Info</h4>
                </div>
                <div class="modal-body" id="modal-info-text"></div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        Close
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- end alert modal -->

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
    <%--<script type="text/javascript" charset="UTF-8" src="<c:url value='/WEB-INF/views/Index/ZabiRepo.jsp'/>"></script>--%>
    <script type="text/javascript"
            src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>

</c:if>

<c:if test="${sessionScope['usuario'] == null}">
    <% response.sendRedirect("logout"); %>
</c:if>

</body>
</html>