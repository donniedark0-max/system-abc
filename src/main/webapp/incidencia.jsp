<jsp:include page="header.jsp"></jsp:include>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Incidencias | Coca-Cola Company</title>
<link rel="stylesheet" href="assets/css/terms.css">

  <script src="https://cdn.tailwindcss.com"></script>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.1.4/dist/sweetalert2.min.css">
</head>
<style>

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
<body >
<div  class="bg-img">
<section id="cta" class="Hoja estilo7">
      <div class="contacto">
        <div class="padre">
          <div class="hijo">
            <h2 id="titulo6">
              Por favor, escribe el ID del producto con el que ocurre la incidencia y escribe una descipción precisa para solucionarlo lo antes posible.
            </h2>
            <div class="tel">
              <svg class="telicon" height="23" width="24" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M18.6765 14.3355L18.6791 14.3362C19.5257 14.5843 20.4024 14.7609 21.2865 14.8568C22.2788 14.9647 22.985 15.7624 22.985 16.671V20.2977C22.985 20.7976 22.7649 21.2859 22.3687 21.6341L22.3669 21.6358C21.9703 21.9864 21.4246 22.1657 20.8704 22.1172C18.2694 21.8864 15.7592 21.2216 13.4099 20.1422L13.4094 20.142C11.1243 19.0936 9.05628 17.6854 7.26279 15.9553C5.46866 14.2245 4.00893 12.2349 2.92454 10.039L2.92433 10.0385C1.80845 7.78195 1.12316 5.37411 0.883044 2.87751C0.877642 2.81524 0.875 2.76072 0.875 2.70945C0.875 2.26175 1.04807 1.82133 1.36916 1.48221L1.36944 1.48192C1.72982 1.10097 2.25255 0.875 2.80215 0.875H6.56467C7.57807 0.875 8.3767 1.59794 8.4801 2.49033L8.48036 2.4926C8.58181 3.34858 8.76441 4.19881 9.02541 5.02134L9.02545 5.02145C9.22945 5.66404 9.05555 6.35482 8.56109 6.83164C8.56105 6.83168 8.561 6.83172 8.56096 6.83176C8.5609 6.83182 8.56084 6.83188 8.56078 6.83193L7.03503 8.3012L6.54564 8.77248L6.88099 9.36336C8.563 12.3271 11.1221 14.7902 14.1857 16.4065L14.7455 16.7018L15.2012 16.2625L16.7258 14.793C17.2254 14.3114 17.9723 14.1268 18.6765 14.3355Z" stroke="#22211D" stroke-width="1.75"></path>
              </svg><a class="telefono" rel="" target="" href="tel:+51917669788">+51 917-669-788</a>
            </div>
            <div class="corr">
              <svg class="corricon" height="21" width="28" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path class="stroke-current" d="M26.9316 1.07471L16.3734 12.7758C15.6117 13.62 14.3003 13.6601 13.4884 12.8641L1.46289 1.07471" stroke="#22211D" stroke-width="1.5"></path>
                <rect class="stroke-current" height="18.8826" width="26.0062" rx="1.25" stroke="#22211D" stroke-width="1.5" x="1.19336" y="0.805664"></rect>
              </svg><a class="correo" rel="" target="_blank" href="https://pranx.com/static-tv-noise/">@CocaColaSupport</a>
            </div>
          </div>

          <div class="padre1">
            <div aria-label="Consulta-Medios" id="FormularioInicioSesion">
                 
              <form id="FormularioInicioSesion"  action="ServletIncidencia?accion=GUARDAR" method="POST">
                <div>
                  <div class="mb-3 form-group">
                    <div>
                      <div class="flex flex-col"><label class="form-label" for="nombre">Nombre</label>
                        <div class=" caja">
                          <input type="text" class="form-control w-full py-3 px-2 text-xl border-b border-teal-500 " id="firstname" name="nombre">
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="mb-3 form-group">
                    <div>
                      <div class="flex flex-col"><label class="form-label" for="apellido">ProductoID</label>
                        <div class="caja">
                          <input type="text" class="form-control w-full py-3 px-2 text-xl  border-b border-teal-500" id="producto" name="producto">
                        </div>
                      </div>
                    </div>
                  </div>
                  <div>
                    <div>
                      <div class="flex flex-col form-group"><label class="form-label"  for="mensaje">Descripción de la incidencia...</label>
                        <textarea aria-required="true" class=" form-control py-1 px-2 border-b resize-none" id="mensaje" name="mensaje" spellcheck="false" data-ms-editor="true"></textarea>
                      </div>
                    </div>
                  </div>
                  <button id="submit" class="mt-10  group font-display-sm border rounded-3xl text-center transition-colors duration-500 inline-block leading1 uppercase focus:outline-none focus:ring-2 focus:ring-slate-400 focus:ring-offset-2 focus:ring-offset-slate-50 text-black border-black hover:bg-black hover:text-white text-xl py-3 px-5 md:py-4 md:px-11  tracking" type="submit">enviar</button>
                </div>  
              </form>
            </div>

          </div>
        </div>
      </div>
    </section>
    </div>
  
</body>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.0/js/bootstrapValidator.js"></script>

  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
   <script>	
   $(document).ready(function() {
		 $('#FormularioInicioSesion').bootstrapValidator({      
	    	 fields:{
	            mensaje: {
	                validators: {
	                	notEmpty : {
							message : 'El campo descripcion es obligatorio'
						},
	                }
	            },
	            firstname: {
	                validators: {
	                    notEmpty: {
	                        message: 'el nombre es obligatorio'
	                    },
	                }
	            },
	           
			 
		 }
	});   
		
	});    
	</script>
</html>