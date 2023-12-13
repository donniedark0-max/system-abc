<jsp:include page="header.jsp"></jsp:include>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Productos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<link
	href="https://cdn.datatables.net/1.13.6/css/dataTables.bootstrap5.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-bulma/bulma.css"
	rel="stylesheet">
	<link rel="stylesheet" href="assets/css/table.css">
	
<style>
@import
	url("https://fonts.googleapis.com/css?family=Open+Sans:400,400italic,600,600italic,800,800italic,Inter")
	;

body {
	height: 125vh;
	align-items: center;
	background: linear-gradient(to bottom, #d4d4d4bd, #dedada5e, #ffffff, #ffffff);
	font-family: 'Inter';
	cursor: url(assets/css/images/arrow.png) 6 0, auto !important;
}

td {
	font-size: 17px
}

th {
	font-size: 20px
}

.modal-header {
	color: #fff;
	background: #428bca;
	display: flex;
	justify-content: center;
}

.help-block {
	color: red;
}

.form-group.has-error .form-control-label {
	color: red;
}

.form-group.has-error .form-control {
	border: 1px solid red;
	box-shadow: 0 0 0 0.2rem rgba(250, 16, 0, 0.18);
}
</style>

</head>
<body>

	<div class="container">
		<h1 class="mt-5 text-center">Productos</h1>
		<hr class="my-4 pb-2">
		<!-- Button trigger modal -->
		<button type="button" class="c__cta btn btn-rounded" data-bs-toggle="modal"
			data-bs-target="#exampleModal">Nuevo Producto</button>
			
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="modalEmpleadoLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title form-head text-bold fs-5" id="modalEmpleadoLabel">Agregar Producto</h1>
					</div>
					<div class="modal-body">
						<!-- GRABAR -->

						<form id="FormularioEmpleado" method="post"
							action="ServletProductos?accion=guardar">

									<div class="form-group">
										<label for="" class="form-label">ProductoID</label> <input
											type="text" class="form-control" name="id" id="id-codigo"
											value="0" readonly>
									</div>
									<div class="form-group">
										<label for="nombre" class="form-label">Nombre</label> <input
											type="text" class="form-control" name="nombre" id="id-nombre">
									</div>
									<div class="form-group">
										<label for="login" class="form-label">Codigo</label> <input
											type="text" class="form-control" name="codigo" id="id-codigop">
									</div>
									<div class="form-group">
										<label for="login" class="form-label">Descripcion</label> <input
											type="text" class="form-control" name="descripcion" id="id-descripcion">
									</div>
									<div class="form-group">
												<label for="especialidad" class="label-form text-secondary" readonly>Categoria</label>
												<select class="form-select" name="categoria"
													id="id-categoria" >
													<option value=" ">[Categoria]</option>
													<option value="6">X</option>
													
												</select>
											</div>
									<div class="form-group">
										<label for="precio" class="form-label">PrecioUnitario</label> <input
											type="text" class="form-control" name="precio" id="id-precio">
									</div>	
									<div class="form-group">
										<label for="cantidad" class="form-label">Cantidad en Stock</label> <input
											type="text" class="form-control" name="cantidad" id="id-cantidad">
									</div>	

							<div class="modal-footer">
								<button type="submit" class="btn btn-rounded-ed">Guardar</button>
								<button type="button" class="btn btn-cerrar"
									data-bs-dismiss="modal" id="btn-cerrar">Cerrar</button>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>

		<div class="mt-3">
			<!-- CREAR TABLA -->
			<table id="TablaEmpleados" class="table table-striped"
				style="width: 100%">
				<thead>
					<tr>
						<th>ProductoID</th>
						<th>Codigo</th>
						<th>Nombre</th>
						<th>Descripcion</th>
						<th>Categoria</th>
						<th>PrecioUnitario</th>
						<th>Cantidad En Stock</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</body>
<!-- libreria principal de JQUERY -->
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<!-- libreria JS de bootstrap -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
	crossorigin="anonymous"></script>

<!-- libreria JS de la tabla -->
<script
	src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>

<!-- libreria para validar (bootstrap validator) -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.js"></script>

<!-- validar si existe el atrubuto MENSAJE -->
<c:if test="${sessionScope.MENSAJE!=null}">
	<script>
		var tipoMensaje = "${sessionScope.TIPO_MENSAJE}";
		toastr[tipoMensaje]("${sessionScope.MENSAJE}", toastr.options = {
			"timeOut" : "2000",
			"positionClass " : " toast-top-right ",
		});
	</script>
</c:if>

<!-- eliminar atributo de tipo sesión MENSAJE -->
<c:remove var="MENSAJE" scope="session" />
<script>
    cargarEmpleados();

    

    
    function cargarEmpleados() {
        $.get("ServletProductosJSON", function(response) {
            let botonEditar = "<button type='button' class='c__cta btn btn-rounded-ed btn-editar' data-bs-toggle='modal' data-bs-target='#exampleModal'>Editar</button>";
            let botonEliminar = "<button type='button' class='c__cta font-weight-bold btn btn-rounded-el btn-eliminar'>Eliminar</button>";
            $.each(response, function(index, item) {
            	console.log(response);
                $("#TablaEmpleados").append("<tr><td>" + item.ProductoID + "</td>" +
                		 "<td>" + item.Codigo + "</td>" +
                        "<td>" + item.Nombre + "</td>" +
                        "<td>" + item.Descripcion + "</td>" +
                        "<td>" + item.Nombre_Categoria + "</td>" +
                        "<td>" + item.PrecioUnitario + "</td>" +
                        "<td>" + item.CantidadEnStock+ "</td>" +
                        "<td>" + botonEditar + "</td><td>" + botonEliminar + "</td></tr>");
            });

            $(document).ready(function() {
                $('#TablaEmpleados').DataTable({
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ registros por página",
                        "zeroRecords": "No se encontraron registros",
                        "info": "Mostrando _START_ a _END_ de _TOTAL_ registros",
                        "infoEmpty": "Mostrando 0 a 0 de 0 registros",
                        "infoFiltered": "(filtrados de un total de _MAX_ registros)",
                        "search": "Buscar:",
                        "paginate": {
                            "first": "Primero",
                            "previous": "Anterior",
                            "next": "Siguiente",
                            "last": "Último"
                        }
                    }
                });
            });
        });
    }

    
    $(document).on("click", ".btn-editar", function() {
        var id;
        id = $(this).parents("tr").find("td")[0].innerHTML;
        $.get("ServletFindProductosJSON?id=" + id, function(response) {
        	console.log(response);
            $("#id-codigo").val(response.ProductoID);
            $("#id-nombre").val(response.Nombre);
            $("#id-descripcion").val(response.Descripcion);
            $("#id-codigop").val(response.Codigo);
            $("#id-categoria").val(response.Nombre_Categoria);
            $("#id-precio").val(response.PrecioUnitario);
            $("#id-cantidad").val(response.CantidadEnStock);

        });
    });
    
    $(document).on("click", ".btn-eliminar", function() {
    	var id;
        var nombre;
        id= $(this).parents("tr").find("td")[0].innerHTML;
        nombre = $(this).parents("tr").find("td")[1].innerHTML; 
    
        Swal.fire({
            title: '¿Seguro de eliminar?',
            text: '¿Desea eliminar al producto "' + nombre + '"con ID: ' + id + '"?', 
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Aceptar',
            cancelButtonText: 'Cancelar'
        }).then((result) => {
            if (result.isConfirmed) {
                window.location = "http://localhost:8080/system-abc/ServletProductos?accion=eliminar&id=" + id;
            }
        });
    });
    
    $(document).on("click", "#btn-cerrar", function() {
        $("#FormularioEmpleado").trigger("reset");
        $("#FormularioEmpleado").data("bootstrapValidator").resetForm(true);
        $("#id-codigo").val("0");
    });
</script>

<script>
$(document).ready(function() {
	 $('#FormularioEmpleado').bootstrapValidator({      
    	 fields:{
            nombre: {
                validators: {
                	notEmpty : {
						message : 'El campo nombre es obligatorio'
					},
                },
            },
            codigo: {
                validators: {
                    notEmpty: {
                        message: 'El codigo es obligatorio'
                    },

                }
       
 			
		 		},
		 		descripcion: {
	                validators: {
	                    notEmpty: {
	                        message: 'La descripcion es obligatorio'
	                    },

	                }
	       
	 			
			 		},
			 		especialidad: {
		                validators: {
		                    notEmpty: {
		                        message: 'La categoria es obligatorio'
		                    },

		                }
		       
		 			
				 		},
				 		precio: {
			                validators: {
			                    notEmpty: {
			                        message: 'El precio es obligatorio'
			                    },

			                }
					 		}
					 		
		 	}
		 
	 
});   
});    

</script>




</html>