package tallerweb.sanguchetto.modelo;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.TipoIngrediente;

/* CONSULTAR A PROFESOR:
 * 1) TESTEAR UN SINGLETON (GET PRECIO)
 * 2) AVISAR LAS MODIFICACIONES EN EL SANGUCHETO-CONTEXT
 * 3) MOSTRAR STOCK Y CONTROLADOR HECHO. CONSULTAR SI SURGE ALGUNA DUDA
 * */

	
public class SanguchettoTest {
	
	@Before
	public void crearSanguchetoEIngredientes() throws Exception{
		Sanguchetto miSanguchetto = Sanguchetto.getInstance();
        Ingrediente miIngrediente = new Ingrediente("Salsa golf",3.0,TipoIngrediente.CONDIMENTO);
        Ingrediente miIngrediente2 = new Ingrediente("Carne",15.0,TipoIngrediente.INGREDIENTE);
        Ingrediente miIngrediente3 = new Ingrediente("Tomate",10.0,TipoIngrediente.INGREDIENTE);
        Ingrediente miIngrediente4 = new Ingrediente("Mayonesa",3.0,TipoIngrediente.CONDIMENTO);
        Ingrediente miIngrediente5 = new Ingrediente("Lechuga",10.0,TipoIngrediente.INGREDIENTE);
        Ingrediente miIngrediente6 = new Ingrediente("Ketchup",5.0,TipoIngrediente.CONDIMENTO);
		miSanguchetto.agregarIngrediente(miIngrediente);
        miSanguchetto.agregarIngrediente(miIngrediente2);
        miSanguchetto.agregarIngrediente(miIngrediente3);
        miSanguchetto.agregarIngrediente(miIngrediente4);
        miSanguchetto.agregarIngrediente(miIngrediente5);
        miSanguchetto.agregarIngrediente(miIngrediente6);
	}	
	
    @Test
    public void testVaciar() {
        // Implementar
    }

    @Test
    public void testAgregarIngrediente() {
        // Implementar
    }
    @Test
    public void testVerIngredientes() throws Exception{
    	Sanguchetto miSanguchetto = Sanguchetto.getInstance();
        List<Ingrediente> misIngredientes = miSanguchetto.verIngredientes();
        Assert.assertEquals("Carne",misIngredientes.get(0).getNombre());
        Assert.assertEquals("Tomate",misIngredientes.get(1).getNombre());
        Assert.assertEquals("Lechuga",misIngredientes.get(2).getNombre());
    }

    @Test
    public void testVerCondimentos() throws Exception {  
      	Sanguchetto miSanguchetto = Sanguchetto.getInstance();
        List<Ingrediente> misCondimentos = miSanguchetto.verCondimentos();
        Assert.assertEquals("Salsa golf",misCondimentos.get(0).getNombre());
        Assert.assertEquals("Mayonesa",misCondimentos.get(1).getNombre());
        Assert.assertEquals("Ketchup",misCondimentos.get(2).getNombre());
    }
	
    @Test
    public void testGetPrecio() {
      	Sanguchetto miSanguchetto = Sanguchetto.getInstance();
      	Double totalAPagar = miSanguchetto.getPrecio();
      	Assert.assertEquals(46, totalAPagar,0.0);
    }
}
