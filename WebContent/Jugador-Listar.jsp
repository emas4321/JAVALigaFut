<%@page import="Entidades.Jugador"%>
<%@page import="Data.DataJugador"%>
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
  <title>Jugadores</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
<%@ include file="/Include/Head.html" %>
    <br>
<div>
<form action="JugadorControl" method=post>
	<select class="form-select" aria-label="Default select example" name="filtro">
		<option selected value="todos">Todas las Pocisiones</option>
        <option value="Arquero">Arquero</option>
        <option value="Defensor">Defensor</option>
        <option value="mediocampista">Mediocampista</option>
        <option value="Delantero">Delantero</option>
     </select>

     <button type="submit" name="accion" value="filtro" class="btn btn-primary"><i class="bi bi-search"></i> Buscar</button>
</form>
    
</div>
.<div class="container-fluid">
    <br>
    <table id="tableEquipo" class="table table-bordered ">
        <tr>
        <th>Nombre </th>
        <th>Apellido</th>
        <th>Fecha Nacimiento</th>
        <th>Posicion</th>
        <th>Goles</th>
        <th>Asistencias</th>
        <th>Tarjetas Amarillas</th>
        <th>Tarjetas Rojas</th>
        <th>Partidos Jugados</th>
        </tr>
        <%
        	LinkedList<Jugador>list=(LinkedList<Jugador>)session.getAttribute("lista");
			for(Jugador listJ : list) {
			
        %>
        <tr>
            <th><%=listJ.getNombre() %></th>
            <th><%=listJ.getApellido() %></th>
            <th><%=listJ.getFecha_nacimiento() %></th>
            <th><%=listJ.getPosicion() %></th>
            <th><%=listJ.getGoles() %></th>
            <th><%=listJ.getAsistencias() %></th>
            <th><%=listJ.getTarjetasA()%></th>
            <th><%=listJ.getTarjetasR() %></th>
            <th><%=listJ.getPartidosJugados() %></th>
        </tr> 
        <%}%>
    </table>
</div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
      crossorigin="anonymous"></script>

</body>

</html>