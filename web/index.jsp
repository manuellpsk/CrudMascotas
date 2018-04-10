<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CrudMascotas</title>
    </head>
    <body>
        <h1><center>Bienvenido!</center></h1><br>
        <form method="post" action="Controlador">
            <table  style="width:100%">
        
                <tr>    
                    <th>Id: <input type="text" name="txtid" value=""></th>
                    <th>Nombre: <input type="text" name="txtnombre" value=""></th>
                </tr>
                
                <tr>
                    <th>Edad: <input type="text" name="txtedad" value=""></th>
                    <th>Sexo:
                        <input  type="radio" name="sex"  value="m" >Macho
                    <input  type="radio" name="sex"  value="h">Hembra</th>
                </tr>
                
                <tr>
                    <th>Raza:
                    <select name="cboxraza">
                        <option value="Pitbull">Pitbull</option>
                        <option value="Pastor Aleman">Pastor Aleman</option>
                        <option value="Siberiano">Siberiano</option>
                        <option value="Boyero">Boyero</option>
                        <option value="Otro"    selected>Otro</option>
                    </select></th>
                    <th>Vacunado:<input type="checkbox" name="vacunado" value="Vacunado"></th>

                </tr>
                
                <tr>
                    <th>Foto:<input type="text" name="txtfoto"  value=""></th>
                    
                </tr>
                
                <tr>
                    <th>
                        <br><br>
                        <p align="right">
                        <input type="submit" name="option" value="AGREGAR">
                        <input type="submit" name="option" value="ELIMINAR">
                        <input type="submit" name="option" value="MODIFICAR"></p>
                    </th>
                    <th>
                        <br><br>
                        <p  align="left">
                        <input type="submit" name="option" value="BUSCAR">
                        <input type="submit" name="option" value="LISTAR">
                        <input  type="reset"    name="reset"    value="RESET">
                        </p>
                    </th>
                </tr>
                
        
            </table>
        </form>
    </body>
</html>
