<jsp:include page="header.jsp" ></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Productos</title>
</head>
<style>

.btn-rounded {
height:30px;
  font-family: Raleway;
  font-size: 23px;
  color: rgba(255, 255, 255);
  letter-spacing: 1px;
  line-height: 18px;
  border: 1px solid #f9fafd;
  border-radius: 40px;
  background: #000000;
  transition: all 0.3s ease 0s;
}

.btn-rounded:hover {
  color: rgb(255, 255, 255);
  background: #f2080b;
  border: 1px solid rgba(242,8,11,255);
}
.btn-rounded-1 {
	height:40px;
	weight:100px;
  font-family: Sans-Serif;
  font-size: 25px;
  color: rgba(255, 255, 255);
  letter-spacing: 1px;
  line-height: 18px;
  border: 2px solid #f2080b;
  border-radius: 10px;
  background: #f2080b;
  transition: all 0.3s ease 0s;
}

.btn-rounded-1:hover {
  color: rgb(255, 255, 255);
  background: #a5161f;
  border: 1px solid #a5161f;
}

</style>
<body>
  <h1 style="text-align:center">Productos</h1>
<table id="product-table" class="table" style="width:100%">
    <thead style=" background-color: #333;
    color: #fdfdfd;">
        <tr>
            <th id="header-row">Código</th>
            <th id="header-row">Unidades</th>
            <th id="header-row">Precio/UD</th>
            <th id="header-row">Importe</th>
			<th id="header-row">% Valor</th>
			<th id="header-row">% Valor Acumulado</th>
			<th id="header-row">% De Producto sobre Inventario</th>
			<th id="header-row">% Inventario Acumulado</th>
			<th id="header-row">TIPO DE PRODUCTO</th>
				            
        </tr>
    </thead>
    <tbody  style= "background-color: #d0eaf9;">
    </tbody>
     <tfoot>
        <tr>
            <th colspan="1">Total:</th>
            <th id="cantidad-total"></th>
            <th ></th>
            <th id="monto-total"></th>
            <th id="porcentaje-total"></th>
            <th></th>
            <th id="porcentaje-producto-sobre-inventario-total"></th>
        </tr>
    </tfoot>
</table>
<div style="padding-left:450px;">
<button class="btn-rounded-1"onclick="calcularImporte()">Calcular Importe</button>

  <button class="btn-rounded-1"id="ordenar-por-importe">Ordenar por Importe</button>
  <button class="btn-rounded-1"id="calcular-total">Calcular Total</button>
  <button class="btn-rounded-1"id="asignar-categorias">Asignar Categorías</button>
</div>  
  
  <div style="height:80px">
  
  </div>
  <div>
  <h1 style="text-align:center"> Graficos</h1>
  </div>
  <canvas id="grafico-de-barras"></canvas>
  
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  
<script>
cargarProductos();

function cargarProductos() {
    $.get("ServletProductosJSON", function(response) {
        $.each(response, function(index, item) {
            $("#product-table").append("<tr><td>" + item.Codigo + "</td>" +
                "<td class='cantidad'>" + item.CantidadEnStock + "</td>" +
                "<td>" + item.PrecioUnitario + "</td>" +
                "<td class='importe'></td>" +
                "<td class='valor'></td>" +
                "<td class='valorA'></td>" +
                "<td class='prodSobInv'></td>" +
                "<td class='InvAc'></td>" +
                "<td class='TipoProd'></td>" +
                "<td><button class='btn-rounded actualizar-categoria' data-codigo='" + item.Codigo + "'>Actualizar</button></td>"
            );
        });
        productosJSON = response;
    });
}


function calcularImporte() {
    const filas = document.querySelectorAll('#product-table tbody tr');
    
    filas.forEach(fila => {
        const unidadesCell = fila.querySelector('td:nth-child(2)');
        const precioCell = fila.querySelector('td:nth-child(3)');
        const importeCell = fila.querySelector('.importe');
	console.log(unidadesCell);
        if (unidadesCell && precioCell && importeCell) {
            const unidades = parseInt(unidadesCell.textContent);
            const precioUnitario = parseFloat(precioCell.textContent);
            const importe = unidades * precioUnitario;

            importeCell.textContent = importe.toFixed(2); // Redondear a 2 decimales
        }
    });
}

$(document).ready(function() {
    // Función para ordenar la tabla por importe
    function ordenarPorImporte() {
        const importeCells = $(".importe");
        const rows = [];

        // Recopila datos de importe y filas
        importeCells.each(function(index, cell) {
            const importe = parseFloat($(cell).text());
            rows.push({ row: $(cell).closest("tr"), importe });
        });

        // Ordena las filas en función del importe
        rows.sort(function(a, b) {
            return b.importe - a.importe;
        });

        // Vacia la tabla y agrega las filas en el nuevo orden
        importeCells.each(function(index, cell) {
            $(cell).closest("tr").detach();
        });

        $.each(rows, function(index, row) {
            $("#product-table tbody").append(row.row);
        });
    }

    // Agrega un controlador de clic al botón para ordenar por importe
    $("#ordenar-por-importe").on("click", ordenarPorImporte);
    
    function calcularMontoTotalYPorcentajes() {
        const importeCells = $(".importe");
        const montoTotalElement = $("#monto-total");
        const porcentajeTotalElement = $("#porcentaje-total");

        let montoTotal = 0;
        let porcentajeAcumulado = 0;

        // Calcular el monto total
        importeCells.each(function(index, cell) {
            const importe = parseFloat($(cell).text());
            montoTotal += importe;
        });

        montoTotalElement.text(montoTotal.toFixed(2));

        // Calcular y mostrar los porcentajes de valor y valor acumulado
        importeCells.each(function(index, cell) {
            const importe = parseFloat($(cell).text());
            const porcentaje = (importe / montoTotal) * 100;
            porcentajeAcumulado += porcentaje;
            $(cell).closest("tr").find(".valor").text(porcentaje.toFixed(2) + "%");
            $(cell).closest("tr").find(".valorA").text(porcentajeAcumulado.toFixed(2) + "%");
        });

        porcentajeTotalElement.text("100%");

        // Calcular el monto total de cantidad
        const cantidadCells = $(".cantidad");
        const cantidadTotalElement = $("#cantidad-total");
        let cantidadTotal = 0;

        cantidadCells.each(function(index, cell) {
            const cantidad = parseInt($(cell).text());
            cantidadTotal += cantidad;
        });

        cantidadTotalElement.text(cantidadTotal);

        // Calcular y mostrar los porcentajes de producto sobre inventario
        cantidadCells.each(function(index, cell) {
            const cantidad = parseInt($(cell).text());
            const porcentajeProductoSobreInventario = (cantidad / cantidadTotal) * 100;
            $(cell).closest("tr").find(".prodSobInv").text(porcentajeProductoSobreInventario.toFixed(2) + "%");
        });
    }
    function calcularPorcentajeInventarioAcumulado() {
    	 const prodSobInvCells = $(".prodSobInv");
    	    const invAcumuladoCells = $(".InvAc");
    	    let porcentajeInventarioAcumulado = 0;
    	    let porcentajeProductoSobreInventarioTotal = 0; // Suma total de los porcentajes de Producto sobre Inventario

    	    prodSobInvCells.each(function(index, cell) {
    	        const porcentaje = parseFloat($(cell).text().replace("%", ""));
    	        porcentajeInventarioAcumulado += porcentaje;
    	        invAcumuladoCells.eq(index).text(porcentajeInventarioAcumulado.toFixed(2) + "%");
    	        porcentajeProductoSobreInventarioTotal += porcentaje;
    	    });

    	    // Calcular la diferencia para ajustar a 100%
    	    const ajuste = 100 - porcentajeInventarioAcumulado;
    	    porcentajeInventarioAcumulado += ajuste;
    	    invAcumuladoCells.last().text(porcentajeInventarioAcumulado.toFixed(2) + "%");

    	    // Mostrar la suma total de % de Producto sobre Inventario
    	    const porcentajeProductoSobreInventarioTotalCell = $("#porcentaje-producto-sobre-inventario-total");
    	    porcentajeProductoSobreInventarioTotal += ajuste;
    	    porcentajeProductoSobreInventarioTotalCell.text(porcentajeProductoSobreInventarioTotal.toFixed(2) + "%");
    }


    $("#calcular-total").on("click", function() {
        calcularMontoTotalYPorcentajes();
        calcularPorcentajeInventarioAcumulado();
    });
    function asignarCategorias() {
        const valorAcumuladoCells = $(".valorA");
        const inventarioAcumuladoCells = $(".InvAc");
        const tipoProductoCells = $(".TipoProd");

        valorAcumuladoCells.each(function(index, cell) {
            const valorAcumulado = parseFloat($(cell).text().replace("%", ""));
            const inventarioAcumulado = parseFloat(inventarioAcumuladoCells.eq(index).text().replace("%", ""));

            let categoria = "";

            if (valorAcumulado >= 80 && valorAcumulado <= 95 && inventarioAcumulado >= 20) {
                categoria = "B";
            } else if (valorAcumulado >= 0 && valorAcumulado <= 80 && inventarioAcumulado >= 0 && inventarioAcumulado <= 20) {
                categoria = "A";
            } else {
                categoria = "C";
            }

            tipoProductoCells.eq(index).text(categoria);
        });
    }

    $("#asignar-categorias").on("click", asignarCategorias);
    
    

});












</script>
<script>
$.get("ServletProductosJSON", function(response) {
    // Asigna la respuesta del servlet a la variable productosJSON
    productosJSON = response;

    // Verifica si se proporcionó una función de devolución de llamada
    if (typeof callback === 'function') {
        callback();
    }

$(document).on('click', '.actualizar-categoria', function() {
    // Obtén el código del producto desde el atributo de datos
    const codigoProducto = $(this).data('codigo');

    // Obtén la categoría directamente de la fila de la tabla
    const categoria = $(this).closest('tr').find('.TipoProd').text();

    // Realiza una solicitud AJAX para enviar los datos al servlet
    $.ajax({
        type: 'POST',
        url: 'ServletProductos', // Reemplaza 'TuServlet' con la URL de tu servlet
        data: {
			accion : "setCat", 
            codigo: codigoProducto,
            categoria: categoria
        },
        success: function(response) {
            // Maneja la respuesta del servlet aquí (por ejemplo, mostrar un mensaje)
            alert('Categoría actualizada exitosamente');
        },
        error: function() {
            // Maneja los errores si la solicitud al servlet falla
            alert('Error al actualizar la categoría');
        }
    });
    generarGraficoDeBarras();
});
generarGraficoDeBarras();




//Datos para el gráfico de barras
function generarGraficoDeBarras() {
    // Recopila los datos de las categorías y la cantidad de unidades en cada categoría
    const categoria = ['Categoría A', 'Categoría B', 'Categoría C', 'Productos sin asignar']; // Define tus categorías
    const unidadesPorCategoria = [0, 0, 0, 0]; // Inicializa el contador de unidades
    // Recorre los productos y suma las unidades a las categorías correspondientes
    productosJSON.forEach(function(producto) {
    	

        const categoria = producto.Nombre_Categoria; // Ajusta esta propiedad según tu JSON
        const unidades = producto.CantidadEnStock; // Ajusta esta propiedad según tu JSON

        if (categoria === 'A') {
            unidadesPorCategoria[0] += unidades;
        } else if (categoria === 'B') {
            unidadesPorCategoria[1] += unidades;
        } else if (categoria === 'C') {
            unidadesPorCategoria[2] += unidades;
        }else {
            // Si la categoría no es A, B ni C, asume "Sin categoría"
            unidadesPorCategoria[3] += unidades;
        }
    });
    // Datos para el gráfico de barras
    var data = {
        labels: categoria,
        datasets: [{
            label: 'Unidades por categoría',
            data: unidadesPorCategoria,
            backgroundColor: [
                'rgba(255, 99, 132, 0.5)',
                'rgba(54, 162, 235, 0.5)',
                'rgba(255, 206, 86, 0.5)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)'
            ],
            borderWidth: 1
        }]
    };

    // Configuración del gráfico
    var options = {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    };

    // Obtener el contexto del canvas
    var ctx = document.getElementById('grafico-de-barras').getContext('2d');

    // Crear el gráfico de barras
    var myBarChart = new Chart(ctx, {
        type: 'bar',
        data: data,
        options: options
    });
} 	
});


</script>	


</body>
</html>

