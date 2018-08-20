<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/Images/Forte16x16.png'/>">
    <title> ForteSecurity</title>

    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/bootstrap/dist/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/font-awesome/css/font-awesome.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/Ionicons/css/ionicons.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/jvectormap/jquery-jvectormap.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/dist/css/AdminLTE.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/dist/css/skins/_all-skins.min.css'/>">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <script src="<c:url value='https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js'/>"></script>
    <script src="<c:url value='https://oss.maxcdn.com/respond/1.4.2/respond.min.js'/>"></script>
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/select2/dist/css/select2.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/resources/AdminLTE/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css'/>">


</head>
<body class="hold-transition skin-blue sidebar-mini">

<c:out value="${requestScope.usuario}" />

<jsp:useBean id="hosts" class="br.forte.DAO.HostDao" />
<c:set var="host" value="${hosts.getHosts()}" />

<jsp:useBean id="usuarios" class="br.forte.DAO.UsuarioDao" />
<c:set var="user" value="${usuarios.getUsuarios()}" />

<c:if  test="${usuario != null}">



    <div class="wrapper">

        <header class="main-header">

            <!-- Logo -->
            <a href="index" class="logo">

                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini">
                <!--<b>Forte</b>-->
                <img src="resources/Images/logo.png" class="img-responsive"/>
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

                    <%--<li>--%>
                        <%--<a href="Hosts">--%>
                            <%--<i class="fa fa-book"></i>--%>
                            <%--<span>Hosts</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>

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
                    Hosts
                    <small>Hosts</small>
                </h1>

            </section>


            <section class="content">
                <div class="box box-default collapsed-box">
                    <div class="box-header with-border">
                        <h3 class="box-title btn btn-box-tool button" data-widget="collapse" style="color: black">Cadastrar Host</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                        </div>
                    </div>

                    <div class="box-body">
                        <form action="CadastrarHost" method="post">
                            <div class="row">

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Nome</label>
                                        <input type="text" class="form-control" name="nome" placeholder="Nome">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">CPU</label>
                                        <input type="text" class="form-control" name="cpu"placeholder="CPU">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Memoria</label>
                                        <input type="text" class="form-control" name="memoria" placeholder="Memoria">
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Disco</label>
                                        <input type="text" class="form-control" name="disco" placeholder="Disco">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Interfaces</label>
                                        <input type="text" class="form-control" name="interfaces" placeholder="Interfaces">
                                    </div>
                                </div>

                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Disponibilidade</label>
                                        <input type="text" class="form-control" name="disponibilidade" placeholder="Disponibilidade">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Numero de Sessoes</label>
                                        <input type="text" class="form-control" name="n_sessoes" placeholder="numero de Sessoes">
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Numero de ips na rede</label>
                                        <input type="text" class="form-control" name="n_ips_rede" placeholder="Numero de ips na rede">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Numero de regras de firewall</label>
                                        <input type="text" class="form-control" name="n_regras_firewall" placeholder="Numero de regras de firewall">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Tamanho do Log</label>
                                        <input type="text" class="form-control" name="tamanho_log" placeholder="Tamanho do Log">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Quantidade de ataques</label>
                                        <input type="text" class="form-control" name="quant_ataques" placeholder="Quantidade de ataques">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Contas de email</label>
                                        <input type="text" class="form-control" name="contas_email" placeholder="Contas de email">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group"><br>
                                        <button type="submit" class="btn btn-info btn-sm">Cadastrar</button>
                                        <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
                                    </div>
                                </div>
                             </div>
                        </form>
                    </div>
                </div>

                <div class="box box-default collapsed-box">
                    <div class="box-header with-border">
                        <h3 class="box-title btn btn-box-tool button" data-widget="collapse" style="color: black">Cliente Host</h3>

                        <div class="box-tools pull-right">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                        </div>
                    </div>

                    <div class="box-body">
                        <form action="CadastrarUsuHost" method="post">
                            <div class="row">

                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Cliente</label>
                                        <select class="form-control select2" style="width: 100%;">
                                            <option class="disabled"></option>
                                            <c:forEach var="user" items="${user}">
                                                <option name="nomeuser">${user.nome}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="col-md-5">
                                    <div class="form-group">
                                        <label>Hosts</label>

                                        <select class="form-control select2" style="width: 100%;">
                                            <option class="disabled"></option>
                                            <c:forEach var="host" items="${host}">
                                                <option name="nomehost">${host.nome}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                </div>

                                <div class="col-md-2">
                                    <div class="form-group"><br>
                                        <button type="submit" class="btn btn-info btn-sm">Cadastrar</button>
                                        <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
                                    </div>
                                </div>



                            </div>

                        </form>
                    </div>
                </div>



                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-7">
                        <section class="content">
                            <div class="row">
                                <div class="box box-default">
                                    <div class="box-header with-border">
                                        <h3 class="box-title btn btn-box-tool button" data-widget="collapse" style="color: black">Hosts</h3>

                                        <div class="box-tools pull-right">
                                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                            <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                                        </div>

                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <table id="example1" class="table table-bordered table-striped">
                                            <thead>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Disponibilidade</th>
                                                <th>Alterar</th>
                                                <th>Excluir</th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach var="host" items="${host}">
                                                <tr>
                                                    <td>${host.nome}</td>
                                                    <td>${host.disponibilidade}</td>
                                                    <td>
                                                        <a href="#" data-toggle="modal" data-target="#modalalterahost" onclick="modalalterahost('${host.idHost}', '${host.nome}', '${host.cpu}', '${host.memoria}', '${host.disco}', '${host.interfaces}', '${host.disponibilidade}', '${host.n_sessoes}', '${host.n_ips_rede}', '${host.n_regras_firewall}', '${host.tamanho_log}', '${host.quant_ataques}', '${host.contas_email}')">
                                                            <i class="glyphicon glyphicon-pencil" style="color: black"></i>
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <a href="RemoverHost?idHost=${host.idHost}">
                                                            <i class="glyphicon glyphicon-remove" style="color: black"></i> </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>Nome</th>
                                                <th>Disponibilidade</th>
                                                <th>Alterar</th>
                                                <th>Excluir</th>
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
                        <div class="col-md-5">
                            <section class="content">
                                <div class="row">
                                    <div class="box box-default">
                                        <div class="box-header with-border">
                                            <h3 class="box-title btn btn-box-tool button" data-widget="collapse" style="color: black">Hosts por usuarios</h3>

                                            <div class="box-tools pull-right">
                                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                                            </div>

                                        </div>

                                        <div class="box-body">
                                            <table id="example2" class="table table-bordered table-striped">
                                                <thead>
                                                <tr>
                                                    <th>Cliente</th>
                                                    <th>Host</th>
                                                    <th>Alterar</th>
                                                    <th>Excluir</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>teste</td>
                                                        <td>teste</td>
                                                        <td>Alterar</td>
                                                        <td>Excluir</td>
                                                    </tr>
                                                    <tr>
                                                        <td>teste</td>
                                                        <td>teste</td>
                                                        <td>Alterar</td>
                                                        <td>Excluir</td>
                                                    </tr>

                                                </tbody>
                                                <tfoot>
                                                <tr>
                                                    <th>Cliente</th>
                                                    <th>Host</th>
                                                    <th>Alterar</th>
                                                    <th>Excluir</th>
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
            </section>
        </div>




        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Alpha Version</b> 1.0
            </div>
            <strong>Copyright &copy; 2018-2018
                <a href="#">Forte Security</a>.
            </strong> All rights reserved.
        </footer>
    </div>
    <div class="control-sidebar-bg"></div>

    </div>

    <script src="<c:url value='/resources/AdminLTE/bower_components/jquery/dist/jquery.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/fastclick/lib/fastclick.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/dist/js/demo.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/select2/dist/js/select2.full.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/dist/js/adminlte.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/plugins/input-mask/jquery.inputmask.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/plugins/input-mask/jquery.inputmask.date.extensions.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/plugins/input-mask/jquery.inputmask.extensions.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/datatables.net/js/jquery.dataTables.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js'/>"></script>
    <script src="<c:url value='/resources/AdminLTE/bower_components/jquery-slimscroll/jquery.slimscroll.min.js'/>"></script>




    <script>
        $(function () {
            $('#example1').DataTable()
            $('#example2').DataTable({
                'paging'      : true,
                'lengthChange': false,
                'searching'   : false,
                'ordering'    : true,
                'info'        : true,
                'autoWidth'   : false
            })
        })
    </script>

    <script>
        $(function () {
            //Initialize Select2 Elements
            $('.select2').select2()

            //Datemask dd/mm/yyyy
            $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
            //Datemask2 mm/dd/yyyy
            $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
            //Money Euro
            $('[data-mask]').inputmask()

            //Date range picker
            $('#reservation').daterangepicker()
            //Date range picker with time picker
            $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' })
            //Date range as a button
            $('#daterange-btn').daterangepicker(
                {
                    ranges   : {
                        'Today'       : [moment(), moment()],
                        'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month'  : [moment().startOf('month'), moment().endOf('month')],
                        'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate  : moment()
                },
                function (start, end) {
                    $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
                }
            )

            //Date picker
            $('#datepicker').datepicker({
                autoclose: true
            })

            //iCheck for checkbox and radio inputs
            $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
                radioClass   : 'iradio_minimal-blue'
            })
            //Red color scheme for iCheck
            $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
                checkboxClass: 'icheckbox_minimal-red',
                radioClass   : 'iradio_minimal-red'
            })
            //Flat red color scheme for iCheck
            $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                checkboxClass: 'icheckbox_flat-green',
                radioClass   : 'iradio_flat-green'
            })

            //Colorpicker
            $('.my-colorpicker1').colorpicker()
            //color picker with addon
            $('.my-colorpicker2').colorpicker()

            //Timepicker
            $('.timepicker').timepicker({
                showInputs: false
            })
        })
    </script>

    <script>
        $(function () {
            //Initialize Select2 Elements
            $('.select2').select2()

            //Datemask dd/mm/yyyy
            $('#datemask').inputmask('dd/mm/yyyy', { 'placeholder': 'dd/mm/yyyy' })
            //Datemask2 mm/dd/yyyy
            $('#datemask2').inputmask('mm/dd/yyyy', { 'placeholder': 'mm/dd/yyyy' })
            //Money Euro
            $('[data-mask]').inputmask()

            //Date range picker
            $('#reservation').daterangepicker()
            //Date range picker with time picker
            $('#reservationtime').daterangepicker({ timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A' })
            //Date range as a button
            $('#daterange-btn').daterangepicker(
                {
                    ranges   : {
                        'Today'       : [moment(), moment()],
                        'Yesterday'   : [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
                        'Last 7 Days' : [moment().subtract(6, 'days'), moment()],
                        'Last 30 Days': [moment().subtract(29, 'days'), moment()],
                        'This Month'  : [moment().startOf('month'), moment().endOf('month')],
                        'Last Month'  : [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
                    },
                    startDate: moment().subtract(29, 'days'),
                    endDate  : moment()
                },
                function (start, end) {
                    $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
                }
            )

            //Date picker
            $('#datepicker').datepicker({
                autoclose: true
            })

            //iCheck for checkbox and radio inputs
            $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
                radioClass   : 'iradio_minimal-blue'
            })
            //Red color scheme for iCheck
            $('input[type="checkbox"].minimal-red, input[type="radio"].minimal-red').iCheck({
                checkboxClass: 'icheckbox_minimal-red',
                radioClass   : 'iradio_minimal-red'
            })
            //Flat red color scheme for iCheck
            $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
                checkboxClass: 'icheckbox_flat-green',
                radioClass   : 'iradio_flat-green'
            })

            //Colorpicker
            $('.my-colorpicker1').colorpicker()
            //color picker with addon
            $('.my-colorpicker2').colorpicker()

            //Timepicker
            $('.timepicker').timepicker({
                showInputs: false
            })
        })
    </script>

    <!--modal alterar inicio-->

    <!--
    idHost, nome, cpu, memoria, disco, interfaces, disponibilidade, n_sessoes, n_ips_rede, n_regras_firewall, tamanho_log, quant_ataques, contas_email

    document.getElementById('idHost').value = idHost;
    document.getElementById('nome').value = nome;
    document.getElementById('cpu').value = cpu;
    document.getElementById('memoria').value = memoria;
    document.getElementById('disco').value = disco;
    document.getElementById('interfaces').value = interfaces;
    document.getElementById('disponibilidade').value = disponibilidade;
    document.getElementById('n_sessoes').value = n_sessoes;
    document.getElementById('n_ips_rede').value = n_ips_rede;
    document.getElementById('n_regras_firewall').value = n_regras_firewall;
    document.getElementById('tamanho_log').value = tamanho_log;
    document.getElementById('quant_ataques').value = quant_ataques;
    document.getElementById('contas_email').value = contas_email;

    -->

    <script>
        function modalalterahost(idHost, nome, cpu, memoria, disco, interfaces, disponibilidade, n_sessoes, n_ips_rede, n_regras_firewall, tamanho_log, quant_ataques, contas_email) {
            document.getElementById('idHost').value = idHost;
            document.getElementById('nome').value = nome;
            document.getElementById('cpu').value = cpu;
            document.getElementById('memoria').value = memoria;
            document.getElementById('disco').value = disco;
            document.getElementById('interfaces').value = interfaces;
            document.getElementById('disponibilidade').value = disponibilidade;
            document.getElementById('n_sessoes').value = n_sessoes;
            document.getElementById('n_ips_rede').value = n_ips_rede;
            document.getElementById('n_regras_firewall').value = n_regras_firewall;
            document.getElementById('tamanho_log').value = tamanho_log;
            document.getElementById('quant_ataques').value = quant_ataques;
            document.getElementById('contas_email').value = contas_email;
        }
    </script>

    <div class="modal fade" id="modalalterahost" tabindex="-1" role="dialog" aria-labelledby="mymodalalterahost">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="mymodalalterahost">Realizar Alteraçao do Host</h4>

                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <form class="form-horizontal" action="AlterarHost" method="post">
                            <div class="row">
                                <input type="hidden" name="idHost" id="idHost" >
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Nome</label>
                                        <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">CPU</label>
                                        <input type="text" class="form-control" id="cpu" name="cpu"placeholder="CPU">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Memoria</label>
                                        <input type="text" class="form-control" id="memoria" name="memoria" placeholder="Memoria">
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Disco</label>
                                        <input type="text" class="form-control" id="disco" name="disco" placeholder="Disco">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Interfaces</label>
                                        <input type="text" class="form-control" id="interfaces" name="interfaces" placeholder="Interfaces">
                                    </div>
                                </div>

                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Disponibilidade</label>
                                        <input type="text" class="form-control" id="disponibilidade" name="disponibilidade" placeholder="Disponibilidade">
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label type="text">Numero de Sessoes</label>
                                        <input type="text" class="form-control" id="n_sessoes" name="n_sessoes" placeholder="numero de Sessoes">
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Numero de ips na rede</label>
                                        <input type="text" class="form-control" id="n_ips_rede" name="n_ips_rede" placeholder="Numero de ips na rede">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Numero de regras de firewall</label>
                                        <input type="text" class="form-control" id="n_regras_firewall" name="n_regras_firewall" placeholder="Numero de regras de firewall">
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Tamanho do Log</label>
                                        <input type="text" class="form-control" id="tamanho_log" name="tamanho_log" placeholder="Tamanho do Log">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-2"></div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Quantidade de ataques</label>
                                        <input type="text" class="form-control" id="quant_ataques" name="quant_ataques" placeholder="Quantidade de ataques">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label type="text">Contas de email</label>
                                        <input type="text" class="form-control" id="contas_email" name="contas_email" placeholder="Contas de email">
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group"><br>
                                        <button type="submit" class="btn btn-info btn-sm">Alterar</button>
                                        <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
                                    </div>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <p>Editando</p>
                </div>
            </div>
        </div>
    </div>
    <!--modal alterar fim-->
    <!--modal alterar fim-->



</c:if>

<c:if  test="${sessionScope['usuario'] == null}">
    <%
        response.sendRedirect("logout");
    %>
</c:if>



</body>
</html>
