package springidol.javaconf1;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.*;

@Configuration
public class SpringConfig {

	//Instruments Bean
	@Bean
	public Saxophone saxophone() {return new Saxophone(); }
	
	@Bean
	public Harmonica harmonica() {
		return new Harmonica();
	}

	@Bean
	public Cymbal cymbal() {
		return new Cymbal();
	}

	@Bean
	public Piano piano() {
		return new Piano();
	}
		
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler duke() {
		return new PoeticJuggler(5, sonnet29());
	}

	//Song Bean
	@Bean
	public Song someone() {
		Song someone = new Song();
		someone.setTitle("Someone Like You");
		someone.setArtist("Adele");
		return someone;
	}

	@Bean
	public Song payphone() {
		Song payphone = new Song();
		payphone.setTitle("Payphone");
		payphone.setArtist("Maroon5");
		return payphone;
	}

	@Bean(name="kenny")				// name 속성을 통해 bean ID 지정 가능 
	public Instrumentalist instr() {
		Instrumentalist instr = new Instrumentalist();
		instr.setSong("Jingle Bells");
		instr.setInstrument(saxophone());		// Setter-based DI
		return instr;
	}

	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instrMap = new HashMap<String, Instrument>();
		instrMap.put("HARMONICA:", harmonica());
		instrMap.put("CYMBAL:", cymbal());
		instrMap.put("SAXOPHONE", saxophone());
		OneManBand omb = new OneManBand();
		omb.setInstruments(instrMap);
		return omb;
	}

	// Singer Bean 추가
	@Bean
	public Singer lena() {
		return new Singer("Lena Park", someone());
	}

	public Singer suhyun(){
		return new Singer("Suhyun",lena().getSong(),piano());
	}

	@Bean
	public SpringIdol springIdol() {
		SpringIdol si = new SpringIdol();
		si.setPerformers(new Performer[]{duke(), instr(), hank(), lena(), suhyun()}); // 공연자 추가(Singer, Instrumentalist)
		return si;
	}

	@Bean
	public Encore encore() {
		Encore encore = new Encore();
		Performer [] performers = springIdol().getPerformers();
		encore.setEncorePerformer(performers[(int)(Math.random()*performers.length)]); // 랜덤 앵콜 공연자
		return encore;
	}


}