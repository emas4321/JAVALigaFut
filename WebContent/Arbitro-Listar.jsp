
<%@ page import="Data.DataArbitro"
	import="java.util.LinkedList"
	import="Entidades.Arbitro"
	import="java.util.Iterator"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Arbitro</title>
  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
<%@ include file="/Include/Head.html" %>
    <br>
<div>
    
</div>
.<div class="container-fluid">
    <br>
    <table id="tableEntreador" class="table table-bordered ">
        <tr>
        <th>Nombre </th>
        <th>Apellido</th>
        <th>Fecha Nacimiento</th>
        </tr>
        <%
        	LinkedList<Arbitro>list=(LinkedList<Arbitro>)session.getAttribute("lista");
       
			for(Arbitro listA : list) {
			
        %>
        <tr>
            <th><%=listA.getNombre() %></th>
            <th><%=listA.getApellido() %></th>
            <th><%=listA.getFecha_nacimiento() %></th>
        </tr> 
        <%}%>
    </table>
</div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ"
      crossorigin="anonymous"></script>

</body>

</html>