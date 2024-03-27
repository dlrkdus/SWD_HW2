package springidol.javaconf4;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springidol.*;

@Configuration
public class SpringConfSub {
	
	@Bean
	public Saxophone saxophone() {	  	// method 이름을 bean의 ID로 사용 ("saxophone") 
		return new Saxophone();			// Saxophone type bean 생성  
	}
	
	@Bean
	public Piano piano() {	    
		return new Piano();		
	}

	@Bean
	public Harmonica harmonica() {
		return new Harmonica();
	}

	@Bean
	public Cymbal cymbal() {
		return new Cymbal();
	}
		
	@Bean
	public Poem sonnet29() {
		return new Sonnet29();
	}
	
	@Bean
	public PoeticJuggler duke() {
		return new PoeticJuggler(5, sonnet29());
	}

	@Bean
	public Singer singer(){return new Singer();} // Singer Bean 생성

	@Bean
	public Singer lena() {
		return new Singer("Lena Park", someone());
	}

	@Bean
	public Singer suhyun(){
		return new Singer("Suhyun",lena().getSong(),piano());
	}


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
		instr.setInstrument(saxophone());
		return instr;
	}

	@Bean		
	public OneManBand hank() {
		Map<String, Instrument> instrMap = new HashMap<String, Instrument>();
		instrMap.put("SAXOPHONE", saxophone());
		instrMap.put("HARMONICA", harmonica());
		instrMap.put("CYMBAL", cymbal());
		OneManBand omb = new OneManBand();		
		omb.setInstruments(instrMap);
		return omb;
	}	
}