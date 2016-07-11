package tallerweb.sangucheto.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.TipoIngrediente;

@Controller
public class ControladorSanguchetto {	
//////////////////////////
/////////////////Ver stock
	@RequestMapping("/mi_sanguchetto")
	public ModelAndView armarMiSanguchetto(){
	
	ModelAndView modeloStock = new ModelAndView();
	Map<Ingrediente, Integer> miStock = Stock.getInstance().obtenerStock();
	Set<Ingrediente> listaIngredientes = Stock.getInstance().listarIngredientesDisponibles();
	ArrayList<Ingrediente> misIngredientes =  new ArrayList<Ingrediente>();
	ArrayList<Ingrediente> misCondimentos =  new ArrayList<Ingrediente>();
	Iterator<Ingrediente> it = listaIngredientes.iterator();
		
		while(it.hasNext()){
			Ingrediente actual = it.next();
			if(actual.getTipo() == TipoIngrediente.CONDIMENTO){
				misCondimentos.add(actual);
			} else if(actual.getTipo() == TipoIngrediente.INGREDIENTE){
				misIngredientes.add(actual);
			} 
		}
		modeloStock.addObject("miStock", miStock);
		modeloStock.addObject("misIngredientes", misIngredientes);
		modeloStock.addObject("misCondimentos", misCondimentos);
		modeloStock.setViewName("mi_sanguchetto");
		return modeloStock;
	}
}
