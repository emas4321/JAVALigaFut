<%@ page import="Data.DataEquipo"
	import="java.util.LinkedList"
	import="Entidades.Equipo"
	import="java.util.Iterator"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Inicio</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
<%@ include file="/Include/Head.html" %>
    <br>

.<div class="container-fluid">
    <br>
    <table id="tableEquipo" class="table table-bordered ">
        <tr>
        <th>Id Equipo</th>
        <th>Nombre Equipo</th>
        <th>Localidad</th>
        <th>Accion</th>
        </tr>
        <%
        	DataEquipo equipo=new DataEquipo();
       		LinkedList<Equipo>list=equipo.getall();
			Equipo equi=null;
			for(Equipo listE : list) {
			
        %>
        <tr>
        	<th><%=listE.getIdEquipo()%></th>
            <th><%=listE.getNombre() %></th>
            <th><%=listE.getLocalidad() %></th>
            <th><form action="Controlador" method=post>
            	<input type="hidden" name="id" class="form-control" value="<%=listE.getIdEquipo() %>">	
            	<button type="submit" class="btn btn-primary" name="accion" value="editar">Editar</button>
            	<button type="submit" class="btn btn-primary" name="accion" value="eliminar">Eliminar</button>
           		</form>
            </th>
        </tr> 
        <%}%>
    </table>
   
</div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
      crossorigin="anonymous"></script>

</body>

</html>