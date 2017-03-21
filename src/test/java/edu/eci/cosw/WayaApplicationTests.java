package edu.eci.cosw;

import edu.eci.cosw.entities.Bar;
import edu.eci.cosw.repository.BarsRepository;
import edu.eci.cosw.repository.MultimediaRepository;
import edu.eci.cosw.services.BaresServices;
import edu.eci.cosw.services.MultimediaServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class WayaApplicationTests {
	/**
	 * Estan son las pruebas de la logica , haría falta los repositorios cuando este la base de datos
	 */
	/*@Autowired
	MultimediaServices multimediaServices;

	@Autowired
	MultimediaRepository multimediaRepository;
	@Autowired
	BaresServices baresServices;

	@Autowired
	BarsRepository barsRepository;*/

	List<Bar>bares=new LinkedList<>();
	@Test
	public void deberiaAgregarBar(){

		Bar a=new Bar();
		a.setLogo("http://scontent.cdninstagram.com/t51.2885-15/s480x480/e35/11264746_1010256902342571_958083788_n.jpg?ig_cache_key=MTA3NDE3MzYxNDg3MjE0NzIyNg%3D%3D.2");
		a.setId(6);
		a.setName("BBC");
		a.setDescripcion("Este bar y restaurante es ideal para tomar y pasar un rato agradable.");
		a.setDireccion("cll falsa #123");
		a.setTipo("freebar");
		a.setGenero("Metal");
		a.setLatitud(4.669070);
		a.setLongitud(-74.055216);
		bares.add(a);
		Bar b=new Bar();
		b.setLogo("http://rumbabogota.com/media/photos/images/events/operafeb_0_maxs.jpg");
		b.setId(8);
		b.setName("Opera Bar");
		b.setDescripcion("ideal para ir a rumbear");
		b.setDireccion("Cra.15a No. 83 – 49");
		b.setTipo("normal");
		b.setGenero("Crossover");
		b.setLatitud(4.668912);
		b.setLongitud(-74.055302);
		bares.add(b);
		Assert.assertEquals("no agrego el bar",bares.get(1).getId(),8);

	}
	@Test
	public void deberiaTraerTodosLosBares(){
		bares=new LinkedList<>();
		Bar a=new Bar();
		a.setLogo("http://scontent.cdninstagram.com/t51.2885-15/s480x480/e35/11264746_1010256902342571_958083788_n.jpg?ig_cache_key=MTA3NDE3MzYxNDg3MjE0NzIyNg%3D%3D.2");
		a.setId(6);
		a.setName("BBC");
		a.setDescripcion("Este bar y restaurante es ideal para tomar y pasar un rato agradable.");
		a.setDireccion("cll falsa #123");
		a.setTipo("freebar");
		a.setGenero("Metal");
		a.setLatitud(4.669070);
		a.setLongitud(-74.055216);
		bares.add(a);
		Bar b=new Bar();
		b.setLogo("http://rumbabogota.com/media/photos/images/events/operafeb_0_maxs.jpg");
		b.setId(8);
		b.setName("Opera Bar");
		b.setDescripcion("ideal para ir a rumbear");
		b.setDireccion("Cra.15a No. 83 – 49");
		b.setTipo("normal");
		b.setGenero("Crossover");
		b.setLatitud(4.668912);
		b.setLongitud(-74.055302);
		bares.add(b);
		Assert.assertEquals("no agrego el bar",bares.size(),2);

	}






}
