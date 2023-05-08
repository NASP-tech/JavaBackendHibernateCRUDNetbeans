<%-- 
    Document   : index
    Created on : May 7, 2023, 12:31:25 PM
    Author     : Nathy
--%>

<%@page import="modelo.util.HibernateUtil"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="org.hibernate.Session"%>
<%@page import="modelo.entidad.Detfact"%>
<%@page import="modelo.entidad.Factura"%>
<%@page import="modelo.entidad.Producto"%>
<%@page import="modelo.entidad.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factura</title>
    </head>
    <body>
        <h1>Factura</h1>

        <%
            Cliente cli = new Cliente("Nat", "Sol");
            Producto p1 = new Producto("ProductoX");
            Producto p2 = new Producto("ProductoY");

            Factura fact = new Factura();
            fact.setNoFactura("2");
            fact.setCliente(cli);
            fact.setDescripcion("Segunda factura");

            Set<Detfact> Detalle = new HashSet<>();
            Detalle.add(new Detfact(fact, p1, 1));
            Detalle.add(new Detfact(fact, p2, 2));

            fact.setDetfacts(Detalle);

            
            try {
                Session sesion = HibernateUtil.getSessionFactory().openSession();
                sesion.getTransaction().begin();
                sesion.save(fact);
                sesion.getTransaction().commit();
                sesion.close();
            } catch (Exception e) {
                out.println(e.getMessage());
            }
            

        %>

    </body>
</html>
