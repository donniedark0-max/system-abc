<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	<style>
		body{
			font-family:verdana;
			font-size:12px;
		}
			.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 20px;
	}
	
	.form-control {
	height:30px!important;
	font-size:12px;
	  /*padding-left: 40px!important;*/
	}
	fieldset, legend {
   all: revert;
}
.reset {
    all: revert;
}
.btn-danger{
	margin:0px!important;
	height:30px!important;
	padding-top:3px!important;	
}
.btn-info{
	margin:0px!important;
	height:30px!important;
	padding-top:3px!important;	
}


.colorBloqueado{
	background:#F7EEC5;	
}
.form-control:focus {
background:#F7EEC5;	
}
	</style>
	<script src="https://kit.fontawesome.com/1da5200486.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.12.1/css/all.css" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
  </head>
  <body>
	<div class="container">
		<h3 class="text-center mt-4">LISTA DE REQUERIMIENTOS</h3>
		
	    <!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modalRequerimiento">
		  Nuevo Requerimiento
		</button>
		<div class=" mt-2">
	
				<table class="table table-striped table-bordered mt-5" id="tableBoletas">
							  <thead>
							   <tr>
					                <th>Número</th>
					                <th>Empleado</th>
					                <th>Fecha</th>
					                <th>Estado</th>
					                <th></th>
					                <th></th>
					            </tr>
							  </thead>
							  <tbody>	
									<tr>
								      <td></td>
								      <td></td>
								      <td></td>
								      <td></td>
								      <td><a class="btn btn-info btn-editar"  data-bs-toggle="modal" data-bs-target="#modalRequerimiento"><i class="far fa-edit"></i></a></td>
								      <td><a class="btn btn-danger btn-reporte"><i class="far fa-trash-alt"></i></a></td>
								    </tr> 
							  </tbody>
				</table>
			</div>
		
		
		
		
			<!-- Modal -->
			<div class="modal fade" id="modalRequerimiento" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog modal-xl">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">Requerimiento</h1>
			      </div>
			      <div class="modal-body">
						<form action="" method="POST">
							<div class="row">
							  <div class="col-2">
								<label for="inputPassword6" class="col-form-label"><b>Número</b></label>
								<input type="text" class="form-control colorBloqueado" name="numero" readonly>
							  </div>
							  <div class="col-3">
								<label for="inputPassword6" class="col-form-label"><b>Empleado</b></label>
								<input type="text" class="form-control colorBloqueado" name="empleado" id="id-empleado" readonly>
							  </div>
							  <div class="col-2">
								<label for="inputPassword6" class="col-form-label"><b>Cargo</b></label>
								<input type="text" class="form-control colorBloqueado" name="cargo" readonly>
							  </div>
							  <div class="form-group has-feedback col-3">	
								<label for="exampleInputEmail1" class="col-form-label"><b>Estado</b></label><br>
								<select class="form-control" id="idTipo" name="tipo">
									<option value=" ">[Seleccione Estado]</option>
									
								</select>
							 </div>
							  <div class="col-2">
								<label for="inputPassword6" class="col-form-label"><b>Fecha</b></label>
								<input type="date" class="form-control" name="fecha">
							  </div>
							 
							</div>
							<hr/>
							<div class="row">
								<div class="form-group has-feedback col-md-12">
									<label for="exampleInputEmail1"><b>Nombre Requerimiento(Detalle)</b></label><br>
									<textarea class="form-control" id="idDescripcion" rows="10"  name="descripcion" style="height:90px!important"
																						   placeholder="Ingresar detalle" style="padding-left: 5px!important;"></textarea>												
								</div>		
							</div>
							
								<div class="row mt-3">
										<div class="col-lg-6">
											<fieldset class="reset">
											  <legend class="reset">Consulta Bienes</legend>
												<div class="row mt-3">
													<label for="inputEmail3" class="col-sm-2">Tipo Bien</label>
													<div class="form-group col-sm-6">
													  <select class="form-control" id="idBien" name="bien">
													      <option value=" ">[Seleccione Bien]</option>
													  </select>
													</div>
													<div class="col-sm-4">
														<button id="btn-consulta-bien" type="button" class="btn btn-info">
															<i class="fas fa-search"></i>
													
														</button>
													</div>
												</div>	
												<table id="tableBienes" class="table table-striped mt-4" style="width:100%">
													<thead>
														<tr >
															<th>Código</th>
															<th>Nombre</th>
															<th>Tipo</th>
															<th></th>
														</tr>
													</thead>
													<tbody>
														
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td>
																<button type="button" class="btn btn-warning">
																	</i><i class="fa-solid fa-plus"></i>
																</button>
															</td>
														</tr>
														
													</tbody>
												</table>
											</fieldset>	
										</div>
										<div class="col-lg-6">
											<fieldset class="reset">
											  <legend class="reset">Bienes/Solicitados</legend>
												<table id="tableSolicitados" class="table table-striped mt-4" style="width:100%">
													<thead>
														<tr>
															<th>Código</th>
															<th>Nombre</th>
															<th>Tipo</th>
															<th>Cantidad</th>
															<th></th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td></td>
															<td></td>
															<td></td>
															<td></td>
															<td>
																<button type="button" class="btn btn-danger" id="btn-eliminar-biean">
																	<i class="fas fa-trash-alt"></i>
																</button>
															
															</td>
														</tr>
														
													</tbody>
												</table>
											</fieldset>	
										</div>
								</div>
								<hr>
								
							    <div class="modal-footer">
									<button type="submit" class="btn btn-primary"><i class="fas fa-save"></i></button>
									<button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fa-regular fa-folder-closed"></i></button>
								</div>
						</form>
			    </div>
			  </div>
			</div>
	</div> 		
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
	<script>
		let msg;
		msg="";
		toastr.success(msg, toastr.options = {
			"timeOut": "2000",
			"positionClass " : " toast-top-right ",
		});
	</script>
	
	<script>
		$('#tableMedicamento').dataTable( {
				  "searching": false,
				  "lengthChange": false,
				  responsive: true,
		});
		$('#tableClientes').dataTable( {
				  "searching": false,
				  "lengthChange": false,
				  responsive: true,		  
		} );
				
		$(document).on("click","#consultar-medicamento",function(){
		
		})
		$(document).on("click","#consultar-cliente",function(){
			
		})

		//asignar evento clic al botón con clase  "btn-datos-medicamento"
		$(document).on("click",".btn-datos-medicamento",function(){
			
		})
		//asignar evento clic al botón con clase  "btn-adicionar"
		$(document).on("click",".btn-eliminar-detalle",function(){
			
		})	
	</script>
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	
  </body>
</html>