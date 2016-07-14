package tallerweb.sangucheto.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.TipoIngrediente;

@Controller
public class ControladorSanguchetto {	
//////////////////////////
/////////////////INDEX
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index()  {
	    return new ModelAndView("sanguchetto");
	}
	
	
	@RequestMapping("/mi_sanguchetto")
	public ModelAndView armarMiSanguchetto(){
	
	ModelAndView modeloStock = new ModelAndView();
	List<Ingrediente> misIngredientesSanguchetto = Sanguchetto.getInstance().verIngredientes();
	List<Ingrediente> misCondimentosSanguchetto = Sanguchetto.getInstance().verCondimentos();
	Set<Ingrediente> listaIngredientes = Stock.getInstance().listarIngredientesDisponibles();
	ArrayList<Ingrediente> misCondimentosStock  = new ArrayList<Ingrediente>();
	ArrayList<Ingrediente> misIngredientesStock = new ArrayList<Ingrediente>();
	
	Iterator<Ingrediente> it = listaIngredientes.iterator();
		
		while(it.hasNext()){
			Ingrediente actual = it.next();
			if(actual.getTipo() == TipoIngrediente.CONDIMENTO){
				misCondimentosStock.add(actual);
			} else if(actual.getTipo() == TipoIngrediente.INGREDIENTE){
				misIngredientesStock.add(actual);
			} 
		}
		modeloStock.addObject("misIngredientesSanguchetto", misIngredientesSanguchetto);
		modeloStock.addObject("misCondimentosSanguchetto", misCondimentosSanguchetto);
		modeloStock.addObject("misIngredientesStock", misIngredientesStock);
		modeloStock.addObject("misCondimentosStock", misCondimentosStock);
		modeloStock.setViewName("mi_sanguchetto");
		return modeloStock;
	}
	
////////////////////////////////////////////	
//////////////////////AGREGAR INGREDIENTE
	
	@RequestMapping(value = "/agregar_ingrediente_sanguchetto", method = RequestMethod.POST)
	public ModelAndView agregarIngredienteMiSanguchetto(){
	
	ModelAndView modeloStock = new ModelAndView();
	List<Ingrediente> misIngredientesSanguchetto = Sanguchetto.getInstance().verIngredientes();
	List<Ingrediente> misCondimentosSanguchetto = Sanguchetto.getInstance().verCondimentos();
	Set<Ingrediente> listaIngredientes = Stock.getInstance().listarIngredientesDisponibles();
	ArrayList<Ingrediente> misCondimentosStock  = new ArrayList<Ingrediente>();
	ArrayList<Ingrediente> misIngredientesStock = new ArrayList<Ingrediente>();
	
	Iterator<Ingrediente> it = listaIngredientes.iterator();
		
		while(it.hasNext()){
			Ingrediente actual = it.next();
			if(actual.getTipo() == TipoIngrediente.CONDIMENTO){
				misCondimentosStock.add(actual);
			} else if(actual.getTipo() == TipoIngrediente.INGREDIENTE){
				misIngredientesStock.add(actual);
			} 
		}
		modeloStock.addObject("misIngredientesSanguchetto", misIngredientesSanguchetto);
		modeloStock.addObject("misCondimentosSanguchetto", misCondimentosSanguchetto);
		modeloStock.addObject("misIngredientesStock", misIngredientesStock);
		modeloStock.addObject("misCondimentosStock", misCondimentosStock);
		modeloStock.setViewName("mi_sanguchetto");
		return modeloStock;
	}
}
