package tallerweb.sangucheto.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.TipoIngrediente;

	@Controller
	public class ControladorSanguchetto {
	
//////////////////////////
///////////////// INDEX

@RequestMapping(value = "index", method = RequestMethod.GET)
public ModelAndView index() {
	return new ModelAndView("mi_sanguchetto");
}
	
////////////////////////////////////////
//////////////////SANGUCHETTO FINAL

@RequestMapping("/sanguchetto_final")
public ModelAndView sanguchettoFinal(){
	ModelAndView modeloIngredientes = new ModelAndView();
	Sanguchetto miSanguchetto = Sanguchetto.getInstance();
	Double precioAPagar = miSanguchetto.getPrecio();
	Set<Ingrediente> miListaIngredientes = Stock.getInstance().listarIngredientesDisponibles();
	Iterator<Ingrediente> it = miListaIngredientes.iterator();

	List<Ingrediente> misIngredientesSanguchetto = Sanguchetto.getInstance().verIngredientes();
	List<Ingrediente> misCondimentosSanguchetto = Sanguchetto.getInstance().verCondimentos();
	modeloIngredientes.addObject("misIngredientesSanguchetto", misIngredientesSanguchetto);
	modeloIngredientes.addObject("misCondimentosSanguchetto", misCondimentosSanguchetto);
	modeloIngredientes.addObject("precioAPagar",precioAPagar);
	modeloIngredientes.setViewName("sanguchetto_final");
	return modeloIngredientes;
	}


////////////////////////////////////////
//////////////////CANCELAR SANGUCHETTO

		@RequestMapping("/cancelar_sanguchetto")
		public ModelAndView cancelarSanguchetto(){
			ModelAndView modeloIngredientes = new ModelAndView();
			Stock miStock = Stock.getInstance();
			Sanguchetto miSanguchetto = Sanguchetto.getInstance();		
			List<Ingrediente> misCondimentos  = miSanguchetto.verCondimentos();
			List<Ingrediente> misIngredientes = miSanguchetto.verIngredientes();
			//CONDIMENTOS
			Iterator<Ingrediente> itCondimentos = misCondimentos.iterator();
			while(itCondimentos.hasNext()){
				Ingrediente actual = itCondimentos.next();
				miStock.agregarStock(actual, 1);
			}
			//INGREDIENTES
			Iterator<Ingrediente> itIngredientes = misIngredientes.iterator();
			while(itIngredientes.hasNext()){
				Ingrediente actual = itIngredientes.next();
				miStock.agregarStock(actual, 1);
			}
			//VACIAR
			miSanguchetto.vaciar();
			return new ModelAndView("mi_sanguchetto");
		}

//////////////////////////////
/////////////////ARMAR SANGUCHETTO
	@RequestMapping("/mi_sanguchetto")
	public ModelAndView armarMiSanguchetto() {

		ModelAndView modeloStock = new ModelAndView();
		List<Ingrediente> misIngredientesSanguchetto = Sanguchetto.getInstance().verIngredientes();
		List<Ingrediente> misCondimentosSanguchetto = Sanguchetto.getInstance().verCondimentos();
		Set<Ingrediente> listaIngredientes = Stock.getInstance().listarIngredientesDisponibles();
		Double precioAPagar = Sanguchetto.getInstance().getPrecio();
		ArrayList<Ingrediente> misCondimentosStock = new ArrayList<Ingrediente>();
		ArrayList<Ingrediente> misIngredientesStock = new ArrayList<Ingrediente>();
		Iterator<Ingrediente> it = listaIngredientes.iterator();

		while (it.hasNext()) {
			Ingrediente actual = it.next();
			if (actual.getTipo() == TipoIngrediente.CONDIMENTO) {
				misCondimentosStock.add(actual);
			} else if (actual.getTipo() == TipoIngrediente.INGREDIENTE) {
				misIngredientesStock.add(actual);
			}
		}
		modeloStock.addObject("misIngredientesSanguchetto", misIngredientesSanguchetto);
		modeloStock.addObject("misCondimentosSanguchetto", misCondimentosSanguchetto);
		modeloStock.addObject("misIngredientesStock", misIngredientesStock);
		modeloStock.addObject("misCondimentosStock", misCondimentosStock);
		modeloStock.addObject("precioAPagar",precioAPagar);
		modeloStock.setViewName("mi_sanguchetto");
		return modeloStock;
	}

////////////////////////////////////////////
////////////////////// AGREGAR INGREDIENTE

	@RequestMapping(value = "/agregar_ingrediente_sanguchetto", method = RequestMethod.POST)
	public ModelAndView agregarIngredienteMiSanguchetto(@RequestParam("ingrediente_elegido") String ingrediente_elegido) {
		@SuppressWarnings("unused")
		ModelAndView modeloStock = new ModelAndView();
		ModelMap modeloIngrediente = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(ingrediente_elegido);
		for (Ingrediente actual : miListaIngredientes) {
			if (actual.equals(miIngrediente)) {
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				if (miStock.obtenerStockDisponible(miIngrediente) >= 1) {
					modeloIngrediente.put("miIngrediente", miIngrediente);
					return new ModelAndView("sanguchetto_agregar_ingrediente", modeloIngrediente);
				} else {
					String mensajeError = "ERROR: No hay stock del producto seleccionado";
					modeloIngrediente.addAttribute("mensajeError", mensajeError);
					return new ModelAndView("error", modeloIngrediente);
				}
			}
		}
		return new ModelAndView("error");
	}

////////////////////////////////////////////
////////////////////// AGREGAR CONDIMENTO

	@RequestMapping(value = "/agregar_condimento_sanguchetto", method = RequestMethod.POST)
	public ModelAndView agregarCondimentoMiSanguchetto(@RequestParam("condimento_elegido") String condimento_elegido) {
		@SuppressWarnings("unused")
		ModelAndView modeloStock = new ModelAndView();
		ModelMap modeloIngrediente = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miCondimento = new Ingrediente();
		miCondimento.setNombre(condimento_elegido);
		for (Ingrediente actual : miListaIngredientes) {
			if (actual.equals(miCondimento)) {
				miCondimento.setTipo(actual.getTipo());
				miCondimento.setPrecio(actual.getPrecio());
				if (miStock.obtenerStockDisponible(miCondimento) >= 1) {
					modeloIngrediente.put("miCondimento", miCondimento);
					return new ModelAndView("sanguchetto_agregar_condimento", modeloIngrediente);
				} else {
					String mensajeError = "ERROR: No hay stock del producto seleccionado";
					modeloIngrediente.addAttribute("mensajeError", mensajeError);
					return new ModelAndView("error", modeloIngrediente);
				}
			}
		}
		return new ModelAndView("error");
	}
	
/////////////////////////////////////////
//////////////////CONFIRMAR INGREDIENTE
	
	
	@RequestMapping(value = "/confirmar_agregar_ingrediente", params = {"nombre"}, method = RequestMethod.GET)
	public ModelAndView confirmarIngredienteMiSanguchetto(@RequestParam("nombre") String nombre_ingrediente){
		ModelAndView modeloIngredientes = new ModelAndView();
		Stock miStock = Stock.getInstance();
		Sanguchetto miSanguchetto = Sanguchetto.getInstance();
		Double precioAPagar = Sanguchetto.getInstance().getPrecio();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		ArrayList<Ingrediente> misCondimentosStock = new ArrayList<Ingrediente>();
		ArrayList<Ingrediente> misIngredientesStock = new ArrayList<Ingrediente>();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombre_ingrediente);
		Iterator<Ingrediente> it = miListaIngredientes.iterator();
		
		while (it.hasNext()) {
			Ingrediente actualIngrediente = it.next();
			if (actualIngrediente.getTipo() == TipoIngrediente.CONDIMENTO) {
				misCondimentosStock.add(actualIngrediente);
			} else if (actualIngrediente.getTipo() == TipoIngrediente.INGREDIENTE) {
				misIngredientesStock.add(actualIngrediente);
			}
		}
		
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				miStock.comprarIngrediente(miIngrediente, 1);
				miSanguchetto.agregarIngrediente(miIngrediente);
				List<Ingrediente> misIngredientesSanguchetto = Sanguchetto.getInstance().verIngredientes();
				List<Ingrediente> misCondimentosSanguchetto = Sanguchetto.getInstance().verCondimentos();
				modeloIngredientes.addObject("misIngredientesSanguchetto", misIngredientesSanguchetto);
				modeloIngredientes.addObject("misCondimentosSanguchetto", misCondimentosSanguchetto);
				modeloIngredientes.addObject("misIngredientesStock", misIngredientesStock);
				modeloIngredientes.addObject("misCondimentosStock", misCondimentosStock);
				modeloIngredientes.addObject("precioAPagar",precioAPagar);
				modeloIngredientes.setViewName("mi_sanguchetto");
				return modeloIngredientes;
			}
		}
		return new ModelAndView("error");	
	}
	
////////////////////////////////////////
//////////////////CONFIRMAR CONDIMENTO
	
	@RequestMapping(value = "/confirmar_agregar_condimento", params = {"nombre"}, method = RequestMethod.GET)
	public ModelAndView confirmarCondimentoMiSanguchetto(@RequestParam("nombre") String nombre_condimento){
		ModelAndView modeloIngredientes = new ModelAndView();
		Stock miStock = Stock.getInstance();
		Sanguchetto miSanguchetto = Sanguchetto.getInstance();
		Double precioAPagar = Sanguchetto.getInstance().getPrecio();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		ArrayList<Ingrediente> misCondimentosStock = new ArrayList<Ingrediente>();
		ArrayList<Ingrediente> misIngredientesStock = new ArrayList<Ingrediente>();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombre_condimento);
		Iterator<Ingrediente> it = miListaIngredientes.iterator();
		
		while (it.hasNext()) {
			Ingrediente actualIngrediente = it.next();
			if (actualIngrediente.getTipo() == TipoIngrediente.CONDIMENTO) {
				misCondimentosStock.add(actualIngrediente);
			} else if (actualIngrediente.getTipo() == TipoIngrediente.INGREDIENTE) {
				misIngredientesStock.add(actualIngrediente);
			}
		}
		
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				miStock.comprarIngrediente(miIngrediente, 1);
				miSanguchetto.agregarIngrediente(miIngrediente);
				List<Ingrediente> misIngredientesSanguchetto = Sanguchetto.getInstance().verIngredientes();
				List<Ingrediente> misCondimentosSanguchetto = Sanguchetto.getInstance().verCondimentos();
				modeloIngredientes.addObject("misIngredientesSanguchetto", misIngredientesSanguchetto);
				modeloIngredientes.addObject("misCondimentosSanguchetto", misCondimentosSanguchetto);
				modeloIngredientes.addObject("misIngredientesStock", misIngredientesStock);
				modeloIngredientes.addObject("misCondimentosStock", misCondimentosStock);
				modeloIngredientes.addObject("precioAPagar",precioAPagar);
				modeloIngredientes.setViewName("mi_sanguchetto");
				return modeloIngredientes;
			}
		}
		return new ModelAndView("error");	
	}
	
}
