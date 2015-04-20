import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelos.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.config.ModuleConfig;

public class JugadoresAction extends org.apache.struts.actions.DispatchAction 
implements org.apache.struts.action.PlugIn {
    
    private Connection cn;
    
    public JugadoresAction() throws SQLException{
        DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
        cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","javaoracle");
    }   

    public ActionForward Habilidad(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         try 
        {
            ArrayList<Jugadores> listaHabilidad = new ArrayList<Jugadores>();
                        
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM JUGADORES WHERE JUGADOR_COD =?");
            pst.setString(1, request.getParameter("cod_jug"));            
            ResultSet rs = pst.executeQuery();
                        
            while (rs.next())
            {                    
                Jugadores hab = new Jugadores(); 
                hab.setJugador_cod(rs.getString("JUGADOR_COD"));
                hab.setNombre(rs.getString("NOMBRE"));
                hab.setCalidad(rs.getString("CALIDAD"));                                
                hab.setVelocidad(rs.getString("VELOCIDAD"));                                
                hab.setVision(rs.getString("VISION"));                                                
                listaHabilidad.add(hab);
            }                        
            servlet.getServletContext().setAttribute("habilidadJugadores",listaHabilidad);  
          
        } catch (SQLException ex) {
            System.out.println("[Error: listarJugadores] " + ex.toString());
        }
                        
        return mapping.findForward("mostrar_habilidad");
    }
    
    public ActionForward listarJugadores(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         try 
        {
            ArrayList<Jugadores> listaJugadores = new ArrayList<Jugadores>();           
            
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM JUGADORES WHERE EQUIPO_COD =?");
            pst.setString(1, request.getParameter("codigo"));            
            ResultSet rs = pst.executeQuery();
                        
            while (rs.next())
            {                    
                Jugadores j = new Jugadores(); 
                j.setJugador_cod(rs.getString("JUGADOR_COD"));
                j.setNombre(rs.getString("NOMBRE"));
                j.setApellido(rs.getString("APELLIDOS"));                                
                listaJugadores.add(j);
            }                        
            servlet.getServletContext().setAttribute("datosJugadores",listaJugadores);  
          
        } catch (SQLException ex) {
            System.out.println("[Error: listarJugadores] " + ex.toString());
        }
                        
        return mapping.findForward("listar_jugadores");
    }
    
     @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException 
    {
        try 
        {
            ArrayList<Equipos> listaEquipo = new ArrayList<Equipos>();         
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM EQUIPOS");
            while (rs.next())
            {
                Equipos dept = new Equipos(); 
                dept.setEquipo_cod(rs.getString("EQUIPO_COD"));
                dept.setNombre(rs.getString("NOMBRE"));
                dept.setFundacion(rs.getString("FUNDACION"));
                dept.setPresidente(rs.getString("PRESIDENTE"));
                dept.setPresupuesto(rs.getString("PRESUPUESTO"));
                dept.setEquipacion(rs.getString("EQUIPACION"));
                dept.setFoto_equipo(rs.getString("FOTO_EQUIPO"));
                dept.setFoto_escudo(rs.getString("FOTO_ESCUDO"));
                dept.setPaginaweb(rs.getString("PAGINAWEB"));
                
                listaEquipo.add(dept);
            }
            
            
            servlet.getServletContext().setAttribute("datosEquipos",listaEquipo);  
            //servlet.getServletContext().setAttribute("departamento",listadepartamentos);              
        } catch (SQLException ex) {
            System.out.println("Excepcion " + ex.toString());
        }
        
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
