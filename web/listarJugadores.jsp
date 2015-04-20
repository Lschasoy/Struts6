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
            <th> <bean:message key="literal.jugador_cod"/> </th>
            <th> <bean:message key="literal.nombre"/></th> 
            <th> <bean:message key="literal.apellido"/></th> 

        </tr> 
         <logic:iterate name="datosJugadores" id="equipos">
            <tr>
                <td>
                    <bean:write name="equipos" property="jugador_cod" />   
                </td>
                <td>
                    <a href="equipos.do?method=Habilidad&cod_jug=<bean:write name="equipos" property="jugador_cod" />" >
                    <bean:write name="equipos" property="nombre" />   
                    </a>
                </td>
                <td>
                    <bean:write name="equipos" property="apellido" />   
                </td>                                               
            </tr>
        </logic:iterate>              
        </table>
        
    </body>
</html:html>
