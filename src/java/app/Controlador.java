package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Controlador extends HttpServlet {
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            if(!Datos.isSW()){Datos.cargarDatos();}
            String option=request.getParameter("option");
            String  id=request.getParameter("txtid");
            String  nombre=request.getParameter("txtnombre");
            String  edad=request.getParameter("txtedad");
            String  sex=request.getParameter("sex");
            if(sex==null){sex="m";}
            String raza=request.getParameter("cboxraza");
            boolean vacunado=false;
            if(request.getParameter("vacunado")!=null){vacunado=true;}
            
            String foto=request.getParameter("txtfoto");
        
        switch(option){
        
            case "LISTAR":
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultados</title>");            
                out.println("</head>");
                out.println("<body>");
                for(Mascota x:Datos.listar()){
                out.println(x+ "<br>"+ "<br>"+ "<br>");}
                out.println("</body>");
                out.println("</html>");
                out.println("<br><br>");
                out.println("<a href=index.jsp> Volver</a>");
                }break;
                
            case "BUSCAR":
                Mascota a=Datos.buscar(id);
                try (PrintWriter out = response.getWriter()) {
                if(a!=null){
                out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                "        <title>CrudMascotas</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1><center>Bienvenido!</center></h1><br>\n" +
                "        <form method=\"post\" action=\"Controlador\">\n" +
                "            <table  style=\"width:100%\">\n" +
                "        \n" +
                "                <tr>    \n");
                out.println("<th>Id: <input type=\"text\" name=\"txtid\" value="+a.getId()+" ></th>\n" +
                "<th>Nombre: <input type=\"text\" name=\"txtnombre\" value="+a.getNombre()+" ></th>\n" +
                "</tr>\n" +
                "\n" +
                "<tr>\n");
                if(a.getSexo()=='m'){
                out.println("<th>Edad: <input type=\"text\" name=\"txtedad\" value="+a.getEdad()+" ></th>\n" +
                "<th>Sexo:\n" +
                "<input  type=\"radio\" name=\"sex\"  value=\"m\" checked >Macho\n" +
                "<input  type=\"radio\" name=\"sex\"  value=\"h\" >Hembra</th>\n" +
                "</tr>\n");
                }else{
                out.println("<th>Edad: <input type=\"text\" name=\"txtedad\" value="+a.getEdad()+" ></th>\n" +
                "<th>Sexo:\n" +
                "<input  type=\"radio\" name=\"sex\"  value=\"m\" >Macho\n" +
                "<input  type=\"radio\" name=\"sex\"  value=\"h\" checked >Hembra</th>\n" +
                "</tr>\n");
                }
                out.println(                
                "<tr>" +
                "<th>Raza:" +
                "<select  name=cboxraza selected="+a.getRaza()+">" +
                "<option value=Pitbull>Pitbull</option>"+
                "<option value=Pastor Aleman>Pastor Aleman</option>"+
                "<option value=Siberiano>Siberiano</option>"+
                "<option value=Boyero>Boyero</option>"+
                "<option value=Otro>Otro</option>"+
                "<option selected="+a.getRaza()+">"+"</option>"+
                "</select></th>");
                if(a.isVacunado()){
                out.println("<th>Vacunado:<input type=\"checkbox\" name=\"vacunado\" value=\"Vacunado\" checked disabled></th>\n");}
                else{
                out.println("<th>Vacunado:<input type=\"checkbox\" name=\"vacunado\" value=\"Vacunado\" disabled></th>\n");}
                out.println(
                "</tr>\n" +
                "<tr>\n" +
                "<th>Foto:<img src=fotos/"+a.getFoto()+"></th>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<th>\n" +
                "<br><br>\n" +
                "<p align=\"right\">\n" +
                "<a href=index.jsp>Volver</a></p>\n" +
                "</th>\n" +
                "</tr>\n" +
                "</table>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");}
                else{
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1> Mascota no encontrada </h1>");
                out.println("<a href=index.jsp>Volver</a>");
                out.println("</body>");
                out.println("</html>");
                }
                }break;
                
            case "AGREGAR":
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                if(Datos.agregar(new Mascota(id,nombre,(byte)Integer.parseInt(edad),sex.charAt(0),raza,vacunado,foto))){
                out.println("<h1> Mascota ingresada </h1>");}
                else{
                out.println("<h1> Error, no se puedo agregar </h1>");}
                out.println("<a href=index.jsp>Volver</a>");
                out.println("</body>");
                out.println("</html>");
                }
                break;
            case "ELIMINAR":
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                if(Datos.eliminar(id)){
                out.println("<h1> Mascota eliminado</h1>");}
                else{out.println("<h1>Mascota NO se pudo eliminar</h1>");}
                out.println("<a href=index.jsp>Volver</a>");
                out.println("</body>");
                out.println("</html>");
                }
                ;break;
            case "MODIFICAR":
                if(edad.isEmpty()){edad="0";}
                
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultados</title>");            
                out.println("</head>");
                out.println("<body>");
                if(Datos.modificar(new Mascota(id,nombre,(byte)Integer.parseInt(edad),sex.charAt(0),raza,vacunado,foto))){
                out.println("Mascota modificado");
                }else{
                
                    out.println("no se pudo modificar");
                }
                out.println("<a href=index.jsp>Volver</a>");
                out.println("</body>");
                out.println("</html>");
                }break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
