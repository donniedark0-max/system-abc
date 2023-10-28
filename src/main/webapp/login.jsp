<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Login</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="assets/css/style.css">
     <link rel="icon" href="assets/css/images/coca-cola-logo.svg">

  </head>
  <body>

 <div class="w-96 rounded-full sm:w-auto md:w-full">
    <h1 class="logo  text-center  pb-5">Sistema Coca Cola</h1>
   

    <form id="FormularioInicioSesion" class="bg-white  px-8 pt-6 pb-8 mb-4 lg:w-96 rounded-3xl sm:w-96 md:w-full mx-auto my-auto" action="ServletEmpleados?accion=INICIAR" method="POST">
      <div class="mb-4 ">
              <div class="text-center">
              <p class="text-black pt-3 pb-8 text-center  sm:text-xl"> Ingresa para poder gestionar el inventario </p>
              </div>
      <input class="shadow appearance-none rounded-lg w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline text-center" id="login" name="login" type="text" placeholder="Ingresa tu email">
      </div>
       <div class="mb-4">
      <input class="shadow appearance-none  rounded-lg w-full py-2 px-3  text-gray-700 leading-tight text-sm focus:outline-none focus:shadow-outline font-bold mb-2 pt-3 text-center" id="contrasena" name="contrasena" type="password" placeholder="Ingresa tu contraseña">
      </div>
       <div class="flex  items-center justify-center">
      <input class="bg-blue-500 hover:bg-blue-900 text-white font-bold py-2 px-4 rounded-3xl focus:outline-none focus:shadow-outline flex  mx-auto cursor-pointer" type="submit" value="INICIAR">
      </div>
    </form>
 <div class="flex  items-center justify-center">
  <p className="my-4 text-sm flex justify-between px-3 text-black w-96 mx-auto my-auto">
        ¿No tiene una cuenta?
    <span><a class="text-blue-700 hover:text-blue-900 no-underline" href="signup.php">Regístrate</a></span>
 </div>
    </div>


    <script>	
  document.getElementById("FormularioInicioSesion").addEventListener("submit", function(event) {
    event.preventDefault(); // Evita que se envíe el formulario por defecto

    var emailInput = document.getElementById("login");
    var passwordInput = document.getElementById("contrasena");

    // Verifica que los campos no estén vacíos
    if (emailInput.value.trim() === "" || passwordInput.value.trim() === "") {
      Swal.fire({
        title: 'Error',
        text: 'Complete todos los campos.',
        imageUrl: 'https://media4.giphy.com/media/cgW5iwX0e37qg/giphy.gif?cid=ecf05e47d86fp2x24436016sxy84imioejrxpp25g2loayan&ep=v1_gifs_search&rid=giphy.gif&ct=g',
        imageWidth: 500,
        imageHeight: 250,
        imageAlt: 'rest',
        })
      return;
    }

    // Verifica que el campo de correo electrónico tenga un formato válido
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(emailInput.value)) {
       Swal.fire({
        title: 'Por favor',
        text: 'Ingrese un email valido.',
        imageUrl: 'https://media2.giphy.com/media/dFtUjX7shZqvK/giphy.gif?cid=ecf05e47i9yvq3v4bzxcpf8xdj5xjvwx7bsn244l6pfpfmvf&ep=v1_gifs_search&rid=giphy.gif&ct=g',
        imageWidth: 500,
        imageHeight: 300,
        imageAlt: 'rest',
        })
      return;
    }

    // Si se pasa la validación, puedes enviar el formulario
    this.submit();
  });
</script>





  </body>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</html>
    