<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">
                      
        
        <table border="1" style="color:blue; background-color: lightskyblue;"> 
        <tr>    
            <th> <bean:message key="literal.equipo_cod"/> </th>
            <th> <bean:message key="literal.nombre"/></th> 
            <th> <bean:message key="literal.fundacion"/></th> 
            <th> <bean:message key="literal.presidente"/></th> 
            <th> <bean:message key="literal.presupuesto"/></th> 
            <th> <bean:message key="literal.equipacion"/></th> 
            <th> <bean:message key="literal.foto_equipo"/></th> 
            <th> <bean:message key="literal.foto_escudo"/></th> 
            <th> <bean:message key="literal.paginaweb"/></th> 
        </tr> 
         <logic:iterate name="datosEquipos" id="equipos">
            <tr>
                <td>
                    <bean:write name="equipos" property="equipo_cod" />   
                </td>
                <td>
                    <bean:write name="equipos" property="nombre" />   
                </td>
                <td>
                    <bean:write name="equipos" property="fundacion" />   
                </td>                
                <td>
                    <bean:write name="equipos" property="presidente" />   
                </td>
                <td>
                    <bean:write name="equipos" property="presupuesto" />   
                </td>
                <td>
                    <bean:write name="equipos" property="equipacion" />   
                </td>
                <td>
                    <bean:write name="equipos" property="foto_equipo" />   
                </td>                
                <td><a href="equipos.do?method=listarJugadores&codigo=<bean:write name="equipos" property="equipo_cod" />" >
                    <bean:write name="equipos" property="foto_escudo" />   
                    </a>
                </td>
                <td>
                    <bean:write name="equipos" property="paginaweb" />   
                </td>                
            </tr>
        </logic:iterate>              
        </table>
        
    </body>
</html:html>
