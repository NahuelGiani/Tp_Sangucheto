package tallerweb.sangucheto.controladores;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorSanguchetto {	
//////////////////////////
/////////////////Ver stock
	@RequestMapping("/mi_sanguchetto")
	public ModelAndView armarMiSanguchetto(){
		ModelAndView modeloStock = new ModelAndView();
		Map<Ingrediente, Integer> miStock = Stock.getInstance().obtenerStock();
		modeloStock.addObject("miStock", miStock);
		modeloStock.setViewName("mi_sanguchetto");
		return modeloStock;
	}
}
