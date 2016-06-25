package tallerweb.sangucheto.controladores;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.TipoIngrediente;

@Controller
public class ControladorStock {
		
	@RequestMapping("/stock_actual")
	public ModelAndView verStockActual(){
		ModelAndView modeloStock = new ModelAndView();
		Map<Ingrediente, Integer> miStock = Stock.getInstance().obtenerStock();
		modeloStock.addObject("miStock", miStock);
		modeloStock.setViewName("stock_actual");
		return modeloStock;
	}
	
	@RequestMapping("/nuevo_ingrediente")
	public ModelAndView crearIngrediente(){
		return new ModelAndView("nuevo_ingrediente");
	}
	
	@RequestMapping("/agregar_ingrediente")
	public ModelAndView agregarIngrediente(@ModelAttribute("ingrediente") Ingrediente miIngrediente){
		ModelMap modeloIngredientes = new ModelMap();
		Stock miStock = Stock.getInstance();
		miStock.agregarIngrediente(miIngrediente);
		Map<Ingrediente, Integer> listaDeIngredientes = Stock.getInstance().obtenerStock();
		modeloIngredientes.put("miStock",listaDeIngredientes);
		return new ModelAndView("stock_actual",modeloIngredientes);
	}
	
	@RequestMapping(value = "/agregar_stock/{ingrediente}",  method = RequestMethod.GET)
	public ModelAndView agregarStock(@PathVariable Ingrediente ingredienteAModificar){
		ModelMap modeloIngredientes = new ModelMap();
		modeloIngredientes.put("ingredienteAModificar",ingredienteAModificar);
		return new ModelAndView("agregar_stock",modeloIngredientes);
	}
	
//	@RequestMapping(value = "/eliminar_stock/{ingrediente}", method = RequestMethod.GET)
//	public ModelAndView eliminarUsuario(@PathVariable Ingrediente ingredienteAModificar){
//		ModelMap modeloUsuario = new ModelMap();
//		TablaPersonas listaPersonas = TablaPersonas.getInstance();
//		listaPersonas.eliminarUsuario(email);
//		modeloUsuario.put("listado", listaPersonas.listarTodas());
//		return new ModelAndView("usuarios", modeloUsuario);
//	};
}
