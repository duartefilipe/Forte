<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="icon" href="index" type="image/x-icon" sizes="16x16"/>
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

<jsp:useBean id="users" class="br.forte.DAO.UsuarioDao" />
<c:set var="users" value="${users.getUsers()}" />

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
                Usuarios
                <small>Usuarios</small>
            </h1>

        </section>


        <section class="content">
            <div class="box box-default collapsed-box">
                <div class="box-header with-border">
                    <h3 class="box-title btn btn-box-tool button" data-widget="collapse" style="color: black">Cadastrar Cliente</h3>

                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-remove"></i></button>
                    </div>
                </div>

                <div class="box-body">
                    <form action="CadastrarUsuario" method="post">
                    <div class="row">

                        <div class="col-md-4">
                            <div class="form-group">
                                <label type="text">Nome</label>
                                <input type="text" class="form-control" name="nome" placeholder="Nome">
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <label type="text">Sobrenome</label>
                                <input type="text" class="form-control" name="sobrenome"placeholder="Sobrenome">
                            </div>
                        </div>

                        <div class="col-md-4">
                            <label type="text">Email</label>
                            <input type="text" class="form-control" name="email" placeholder="Email">
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-md-2"></div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label>Telefone:</label>

                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="fa fa-phone"></i>
                                    </div>
                                    <input type="text" name="telefone" class="form-control" data-inputmask="&quot;mask&quot;: &quot;(99) 99999-9999&quot;" data-mask="">
                                </div>
                            </div>
                        </div>

                        <div class="col-md-4">
                            <div class="form-group">
                                <label type="text">Endereco</label>
                                <input type="text" class="form-control"  name="endereco" placeholder="Endereco">
                            </div>
                        </div>
                        <div class="col-md-2"></div>
                    </div>

                    <div class="row">
                        <div class="col-md-5">
                            <div class="form-group">
                                <label type="text">Senha</label>
                                <input type="password" class="form-control" name="senha" placeholder="Senha">
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="form-group">
                                <label>Perfil</label>
                                <select name="tipo" class="form-control select2" style="width: 100%;">
                                    <option></option>
                                    <option value="2">Administrator</option>
                                    <option value="3">Super Administrator</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-2"><br>
                            <button type="submit" class="btn btn-info btn-sm">Cadastrar</button>
                            <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
                        </div>


                        </div>
                    </form>
                </div>
            </div>


            <div class="container-fluid">
                <div class="row">
                        <section class="content">
                            <div class="row">
                                <div class="box box-default">
                                    <div class="box-header with-border">
                                        <h3 class="box-title btn btn-box-tool button" data-widget="collapse" style="color: black">Usuarios</h3>

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
                                                <th>Alias</th>
                                                <th>Nome</th>
                                                <th>Sobrenome</th>
                                                <th>email</th>
                                                <th>Enviar email</th>
                                                <th>Excluir</th>
                                            </tr>
                                            </thead>
                                            <tbody>

                                            <c:forEach var="list" items="${users}">
                                                <tr>
                                                    <td>${list.user.alias}</td>
                                                    <td>${list.user.name}</td>
                                                    <td>${list.user.surname}</td>
                                                    <td>${list.media.sendto}</td>
                                                    <td>
                                                        <a href="#" data-toggle="modal" data-target="#modalemail"  onclick="setaDadosModal('${list.media.sendto}')" style="color: #0a0a0a">
                                                        Enviar email
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <a href="RemoverUsuario?idUsuario=${list.user.userid}&&nameuser=${list.user.name}&&tipo=${list.user.type}">
                                                            <i class="glyphicon glyphicon-remove" style="color: black"></i> </a>
                                                    </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                            <tfoot>
                                            <tr>
                                                <th>Alias</th>
                                                <th>Nome</th>
                                                <th>Sobrenome</th>
                                                <th>email</th>
                                                <th>Enviar email</th>
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
        </section>
    </div>




    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0
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
    <script>
        function modalalterausu(iduser, name, surname) {
            document.getElementById('iduser').value = idUsuario;
            document.getElementById('nome').value = nome;
            document.getElementById('sobrenome').value = sobrenome;
        }
    </script>

    <div class="modal fade" id="modalalterausu" tabindex="-1" role="dialog" aria-labelledby="mymodalalterausu">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="mymodalalterausu">Realizar Alteraçao no anuncio</h4>

                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <form class="form-horizontal" action="AlterarUsuario" method="post">
                            <input type="hidden" name="iduser" id="iduser" >
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="control-label" >Name</label>
                                        <input class="form-control" name="name" id="name" value="name"/>
                                    </div>
                                </div>

                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="control-label" >Sobrenome</label>
                                        <input class="form-control" name="surname" id="surname" value="surname"/>
                                    </div>
                                </div>

                            </div>





                            <div class="row">
                                <button type="submit" class="btn btn-info btn-sm">Alterar</button>
                                <button type="submit" class="btn btn-danger btn-sm">Cancelar</button>
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

    <!-- modal email inicio -->
    <script>
        function setaDadosModal(sendto) {
            document.getElementById('sendto').value = sendto;
        }
    </script>

    <div class="modal fade" id="modalemail" tabindex="-1" role="dialog" aria-labelledby="myModalEmail">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalEmail">Enviar email</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="mandarEmail" method="post">

                        <!--<input type="text" name="campo" id="campo" value="campo">-->
                        <div class="form-group">
                            <label class="control-label col-sm-2" >Destinatario:</label>
                            <div class="col-sm-10">
                                <input type="email" class="form-control" name="sendto" id="sendto" value="sendto">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Assunto:</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" name="assunto" id="assunto">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Texto:</label>
                            <div class="col-sm-10">
                                <textarea class="form-control" rows="5" name="mensagem"  placeholder="Digite aqui sua mensagem"></textarea>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-success" style="background-color: #3F80BD" id="enviar">Enviar</button>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">

                </div>
            </div>
        </div>
    </div>

    <!-- modal email fim -->


</c:if>

<c:if  test="${sessionScope['usuario'] == null}">
    <%
        response.sendRedirect("logout");
    %>
</c:if>


</body>
</html>
