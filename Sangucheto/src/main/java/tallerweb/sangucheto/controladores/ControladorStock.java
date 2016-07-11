package tallerweb.sangucheto.controladores;

import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;

@Controller
@RequestMapping("/stock")
public class ControladorStock {
	
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public ModelAndView index()  {
	    return new ModelAndView("stock_actual");
	}
	
//////////////////////////
/////////////////Ver stock	
	@RequestMapping("/stock_actual")
	public ModelAndView verStockActual(){
		ModelAndView modeloStock = new ModelAndView();
		Map<Ingrediente, Integer> miStock = Stock.getInstance().obtenerStock();
		modeloStock.addObject("miStock", miStock);
		modeloStock.setViewName("stock_actual");
		return modeloStock;
	}
	
//////////////////////////
/////////Crear ingrediente
	@RequestMapping("/nuevo_ingrediente")
	public ModelAndView crearIngrediente(){
		return new ModelAndView("nuevo_ingrediente");
	}
//////////////////////////
/////////Agregar ingrediente	
	@RequestMapping("/agregar_ingrediente")
	public ModelAndView agregarIngrediente(@ModelAttribute("ingrediente") Ingrediente miIngrediente){
		if(miIngrediente.getNombre() != null){
		ModelMap modeloIngredientes = new ModelMap();
		System.out.println(miIngrediente.getTipo());
		Stock miStock = Stock.getInstance();
		miStock.agregarIngrediente(miIngrediente);
		Map<Ingrediente, Integer> listaDeIngredientes = Stock.getInstance().obtenerStock();
		modeloIngredientes.put("miStock",listaDeIngredientes);
		return new ModelAndView("stock_actual",modeloIngredientes);
		}else{
			return new ModelAndView("error");
		}
	}
//////////////////////////
/////////////Sumar stock	
	@RequestMapping(value = "/agregar_stock/{nombreIngrediente}",  method = RequestMethod.GET)
	public ModelAndView agregarStock(@PathVariable("nombreIngrediente") String nombreIngrediente){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombreIngrediente);
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				modeloIngredientes.put("miIngrediente", miIngrediente);
				modeloIngredientes.put("miStock", miStock);
				return new ModelAndView("agregar_stock",modeloIngredientes);
			}
		}
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "/sumando_stock", params = {"nombre", "stock_a_sumar"}, method = RequestMethod.GET)
	public ModelAndView sumarleStockAlIngrediente(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "stock_a_sumar") Integer stock_a_sumar){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombre);
		
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				miStock.agregarStock(miIngrediente, stock_a_sumar);
				Map<Ingrediente, Integer> stockQueEnvio = miStock.obtenerStock();
				modeloIngredientes.addAttribute("miStock", stockQueEnvio);
				return new ModelAndView("stock_actual",modeloIngredientes);
			}
		}
		return new ModelAndView("error");
	}
	
//////////////////////////
//////////////Restar stock	
	@RequestMapping(value = "/restar_stock/{nombreIngrediente}",  method = RequestMethod.GET)
	public ModelAndView restarStock(@PathVariable("nombreIngrediente") String nombreIngrediente){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombreIngrediente);
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				modeloIngredientes.put("miIngrediente", miIngrediente);
				modeloIngredientes.put("miStock", miStock);
				return new ModelAndView("restar_stock",modeloIngredientes);
			}
		}
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "/restando_stock", params = {"nombre", "stock_actual","stock_a_restar"}, method = RequestMethod.GET)
	public ModelAndView restarleStockAlIngrediente(@RequestParam(value = "nombre") String nombre, @RequestParam(value = "stock_actual") Integer stock_actual, @RequestParam(value = "stock_a_restar") Integer stock_a_restar){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombre);
		
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				miIngrediente.setTipo(actual.getTipo());
				miIngrediente.setPrecio(actual.getPrecio());
				if((stock_actual-stock_a_restar) >= 0){
					miStock.agregarStock(miIngrediente, (-stock_a_restar));
					Map<Ingrediente, Integer> stockQueEnvio = miStock.obtenerStock();
					modeloIngredientes.addAttribute("miStock", stockQueEnvio);
					return new ModelAndView("stock_actual",modeloIngredientes);		
				} else {
					String mensajeError = "ERROR: No se puede restar mas cantidad de la que hay";
					Map<Ingrediente, Integer> stockQueEnvio = miStock.obtenerStock();
					modeloIngredientes.addAttribute("miStock", stockQueEnvio);
					modeloIngredientes.addAttribute("mensajeError", mensajeError);
					return new ModelAndView("stock_actual",modeloIngredientes);	
				}

			}
		}
		return new ModelAndView("error");
	}
	
//////////////////////////////////
//////////////Eliminar ingrediente
		
	@RequestMapping(value = "/confirmar_eliminar_ingrediente/{nombreIngrediente}",  method = RequestMethod.GET)
	public ModelAndView confirmarEliminacionIngrediente(@PathVariable("nombreIngrediente") String nombreIngrediente){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombreIngrediente);
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
				modeloIngredientes.put("miIngrediente", miIngrediente);
				modeloIngredientes.put("miStock", miStock);
				return new ModelAndView("confirmar_eliminar_ingrediente",modeloIngredientes);
			}
		}
		return new ModelAndView("error");
	}
	
	@RequestMapping(value = "/eliminar_ingrediente", params = {"nombre"}, method = RequestMethod.GET)
	public ModelAndView eliminarIngrediente(@RequestParam(value = "nombre") String nombre){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		Set<Ingrediente> miListaIngredientes = miStock.listarIngredientesDisponibles();
		Ingrediente miIngrediente = new Ingrediente();
		miIngrediente.setNombre(nombre);
		for(Ingrediente actual:miListaIngredientes){
			if(actual.equals(miIngrediente)){
					miStock.eliminarIngrediente(miIngrediente);
					Map<Ingrediente, Integer> stockQueEnvio = miStock.obtenerStock();
					modeloIngredientes.addAttribute("miStock", stockQueEnvio);
					return new ModelAndView("stock_actual",modeloIngredientes);	
				}
			}
		return new ModelAndView("error");
		}		
}
