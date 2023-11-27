<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <title>TERMINACIONES DE CONEXION</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .header {
            background-color: #8da1cc;
            color: white;
            margin-bottom: 0;
            text-align: left;
        }

        .form-container {
            display: grid;
            grid-template-columns: max-content auto;
            gap: 10px;
        }

        .form-group {
            display: flex;
            align-items: center;
        }

        .label {
            text-align: right;
            margin-right: 20px;
            width: 100px;
        }

        .input-wrapper {
            flex: 1;
            margin-left: 20px;
        }

        .modify-button {
            margin-top: 20px;
            grid-column: span 5;
            /* Estira el botón en dos columnas */
        }

        /* Estilos para la franja horizontal azul */
        .blue-stripe {
            background-color: #8da1cc;
            height: 5px;
            width: 100%;
            margin-top: 30px;
            margin-bottom: 30px;
        }
        .grey-stripe {
            background-color: #c2c2c2;
            height: 5px;
            width: 100%;
            margin-top: 30px;
            margin-bottom: 30px;
        }

        .anadirVal {
            margin-bottom: 30px;
        }


        .form-row {
            display: flex;
            align-items: center;
            margin-right: 20px;
            /* Espacio entre cada par de etiqueta e input */
        }

        .form-container {
            margin-bottom: 20px;
        }

        label {
            margin-right: 10px;
            /* Espacio entre la etiqueta y el input */
        }
    </style>
</head>

<body>
    <div class="header">
        <h1>TERMINACIONES DE CONEXION / 90011788</h1>
    </div>
    <h5>Usted puede modificar la terminacion de conexion de su Plan Inicial:</h5>
    <form>
        <div class="form-container">
            <div class="form-group">
                <label for="planInicial">Plan Inicial</label>
                <div class="input-wrapper">
                    <input type="text" id="planInicial">
                </div>
            </div>
            <div class="form-group">
                <label for="grabacion">Grabacion</label>
                <div class="input-wrapper">
                    <select id="grabacion">
                        <option value="siempre">SIEMRE</option>
                        <option value="dirigida">DIRIGIDA</option>
                        <option value="inactiva">INACTIVA</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="encuesta">Encuesta</label>
                <div class="input-wrapper">
                    <select id="encuesta">
                        <option value="automatica">AUTOMATICA</option>
                        <option value="manual">MANUAL</option>
                        <option value="inactiva">INACTIVA</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="desvio">Desvio</label>
                <div class="input-wrapper">
                    <select id="desvio">
                        <option value="si">SI</option>
                        <option value="no">NO</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="supervision">Supervision</label>
                <div class="input-wrapper">
                    <select id="supervision">
                        <option value="si">SI</option>
                        <option value="no">NO</option>
                    </select>
                </div>
            </div>
            <button type="button" class="modify-button">Modificar >></button>
        </div>
    </form>

    <div class="blue-stripe"></div>
    <div class="anadirVal">
        <h5>Tiene ${numTerminaciones} terminaciones de conexion activas </h5>
        <h5> El limite maximo de terminaciones puede modificar en una unica solicitud es 100.</h5>
        
		<form id="miFormulario" action="terminaciones?action=anadirTerminacion" method="POST">
		    <label for="etiqueta">Etiqueta</label>
		    <input type="text" name="etiqueta" id="etiqueta">  
		    <label for="valor">Valor</label>
		    <input type="text" name="valor" id="valor">
		        <input type="hidden" name="terminacionesList" id="terminacionesList" value="">
		    <button type="submit" class="modify-button">Añadir >></button>
		</form>

    </div>

    <div class="grey-stripe"></div>

    <style>
        table {
            border-collapse: separate;
            border-spacing: 4px;
            width: 100%;
        }

        td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }

        .edited {
            background-color: rgb(110, 182, 3);
        }

        .empty {
            background-color: rgb(245, 193, 80);
        }
    </style>
    <script>
    
   
    // Función para detectar cambios en los campos de entrada
    function detectarCambios(inputElement) {
        inputElement.style.backgroundColor = 'lightgreen';
    }

    // Obtener todos los campos de entrada en la tabla
    const inputElements = document.querySelectorAll("input[type='text']");

    // Agregar un controlador de eventos para cada campo de entrada
    inputElements.forEach(inputElement => {
        inputElement.addEventListener('input', function () {
            detectarCambios(inputElement);
        });
    });
    </script>

<div class="terminations-info">
    <style>
        #miTabla {
            width: 100%;
            border-collapse: collapse;
        }
        #miTabla th, #miTabla td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        #miTabla tr:nth-child(even){background-color: #f2f2f2;}
        #miTabla tr:hover {background-color: #ddd;}
        #miTabla th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: auto;
        }
        #botonModificar {
        	align-items: center;
        }
    </style>
    <table id="miTabla">
        <thead>
            <tr>
                <th>Etiqueta</th>
                <th>Valor</th>
            </tr>
        </thead>
        <tbody>
            <form action="guardarCambios" method="POST">
                <c:forEach items="${terminaciones}" var="terminacion">
                    <tr>
                        <td><input type="text" name="etiqueta" value="${terminacion.etiqueta}"></td>
                        <td><input type="text" name="valor" value="${terminacion.valor}"></td>
                    </tr>
                </c:forEach>
                <td colspan="2"><button id="botonModificar" type="submit">Modificar >></button></td>
           </form>
        </tbody>
    </table>
</div>

<script>
  window.onload = function() {
	    var tabla = document.getElementById("miTabla");
	    var celdas = tabla.getElementsByTagName("td");

	    for (var i = 0; i < celdas.length; i++) {
	        var input = celdas[i].getElementsByTagName("input")[0];

	        input.addEventListener("input", function() {
	            var fila = this.parentNode.parentNode;
	            var celdasFila = fila.getElementsByTagName("td");
	            var input1 = celdasFila[0].getElementsByTagName("input")[0];
	            var input2 = celdasFila[1].getElementsByTagName("input")[0];

	            if (input1.value && input2.value) {
	                fila.style.backgroundColor = "green";
	            } else if (!input1.value && !input2.value) {
	                fila.style.backgroundColor = "orange";
	            } else {
	                fila.style.backgroundColor = "";
	            }
	        });
	    }
	    
	    document.getElementById("miFormulario").addEventListener("submit", function (event) {
            event.preventDefault(); // Previene el envío del formulario por defecto

            // Obtener todas las filas de la tabla
            const filas = document.querySelectorAll("#miTabla tbody tr");

            // Crear una lista para almacenar los datos de la tabla
            const terminacionesList = [];

            filas.forEach((fila) => {
                const celdas = fila.getElementsByTagName("td");
                const etiqueta = celdas[0].getElementsByTagName("input")[0].value;
                const valor = celdas[1].getElementsByTagName("input")[0].value;
                
                if (etiqueta && valor) {
                    terminacionesList.push({ etiqueta, valor });
                }
            });

            // Actualizar el campo oculto con la lista en formato JSON
            document.getElementById("terminacionesList").value = JSON.stringify(terminacionesList);

            // Enviar el formulario
            this.submit();
        });
	};

    </script>
</body>

</html>





