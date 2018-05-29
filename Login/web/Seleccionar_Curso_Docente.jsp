<!DOCTYPE html>
<!-- write your code here -->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Mouldifi - A fully responsive, HTML5 based admin theme">
<meta name="keywords" content="Responsive, HTML5, admin theme, business, professional, Mouldifi, web design, CSS3">
<title>EEAcad | Examen</title>
<!-- Site favicon -->
<!-- /site favicon -->

<!-- Entypo font stylesheet -->
<link href="css/entypo.css" rel="stylesheet">
<!-- /entypo font stylesheet -->

<!-- Font awesome stylesheet -->
<link href="css/font-awesome.min.css" rel="stylesheet">
<!-- /font awesome stylesheet -->

<!-- CSS3 Animate It Plugin Stylesheet -->
<link href="css/plugins/css3-animate-it-plugin/animations.css" rel="stylesheet">
<!-- /css3 animate it plugin stylesheet -->

<!-- Bootstrap stylesheet min version -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- /bootstrap stylesheet min version -->

<!-- Mouldifi core stylesheet -->
<link href="css/mouldifi-core.css" rel="stylesheet">
<!-- /mouldifi core stylesheet -->

<link href="css/plugins/select2/select2.css" rel="stylesheet">
<link href="css/mouldifi-forms.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
<![endif]-->

</head>
<body onload="init();" style="margin:0px">
<jsp:useBean id="Asignatura" scope="request" class="Modelo.Auv_Asignatura"/>
<div class="page-container">

  
  <div class="main-container">

	<!-- Main header -->
    <div class="main-header row gray-bg">
        <div class="col-sm-6 col-xs-7">

                    <!-- User info -->
            <ul class="user-info pull-left">
              <li class="profile-info dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false"> <img width="44" class="img-circle avatar" alt="" src="images/man-3.jpg"> <span class="caret"></span></a>

                            <!-- User action menu -->
                <ul class="dropdown-menu">

                           <li><a href="logout.php" ><i class="icon-logout"></i>Logout</a></li>
                </ul>
                            <!-- /user action menu -->

              </li>
            </ul>

        </div>
    </div>
      <div class="col-sm-6 col-xs-5">
	  <h1 class="page-title">Lista de Usuarios</h1>
<!-- Breadcrumb -->
<div class="row">
	<div class="col-lg-12 animatedParent animateOnce z-index-50">
		<div class="panel panel-default animated fadeInUp">
			<div class="panel-heading clearfix">
				<ul class="panel-tool-options">
					<li><a data-rel="collapse" href="#"><i class="icon-down-open"></i></a></li>
					<li><a data-rel="reload" href="#"><i class="icon-arrows-ccw"></i></a></li>
					<li><a data-rel="close" href="#"><i class="icon-cancel"></i></a></li>
				</ul>
			</div>
			<div class="panel-body">
				
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover dataTables-example" >
						<thead>
							<tr>
								<th>Nrc</th>
								<th>Nombre Asignatura</th>
							</tr>
						</thead>
						<tbody>
                                                <h1></h1> 
                                                <jsp:getProperty name="Asignaturas" property="lista_asignaturas"/>
							
                                                        <tr>
							<td><% Asignatura.getCOD_ASIGNATURA(); %></td>;
							<td><% Asignatura.getDESCRIPCION(); %></td>';
							</tr>;

	          			

	</tbody>
	<tfoot>
	<tr>

	<th>Nrc</th>
	<th>Nombre Asignatura</th>
	</tr>
	</tfoot>
	</table>
	</div>
	</div>
	</div>
	</div>
	</div>	
      </div>
</div>
	<!-- /main header -->

	
      

<script>
	
</script>


</body>

</html>
