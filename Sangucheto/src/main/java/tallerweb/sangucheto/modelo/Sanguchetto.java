package tallerweb.sangucheto.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<Ingrediente>();
	
	private Sanguchetto(){}
	
	public static Sanguchetto getInstance(){
		return instance;
	}
	
////////////////
	
	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar(){
		ingredientes.clear();
	}
	
////////////////
	
	/**
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente){
		this.ingredientes.add(ingrediente);
	}

////////////////
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientes(){
        List<Ingrediente> listaIngredientes = new ArrayList<Ingrediente>();

        for(Ingrediente ingredienteActual:ingredientes){
        	if(ingredienteActual.getTipo()==TipoIngrediente.INGREDIENTE){
        		listaIngredientes.add(ingredienteActual);
        	}
        }
        return listaIngredientes;
    }

////////////////
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
    public List<Ingrediente> verCondimentos(){
        List<Ingrediente> listaCondimentos = new ArrayList<Ingrediente>();

        for(Ingrediente ingredienteActual:ingredientes){
        	if(ingredienteActual.getTipo()==TipoIngrediente.CONDIMENTO){
        		listaCondimentos.add(ingredienteActual);
        	}
        }
        return listaCondimentos;
    }
	
////////////////
    
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		Double precioTotal = 0.0;
		
        for(Ingrediente ingredienteActual:ingredientes){
        	precioTotal += ingredienteActual.getPrecio();
        }
		return precioTotal;
	}
}
