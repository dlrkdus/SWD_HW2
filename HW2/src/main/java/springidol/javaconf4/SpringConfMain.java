package springidol.javaconf4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springidol.*;

@Configuration
@Import(SpringConfSub.class)			// SpringConfSub 클래스에 설정된 bean들을 import
public class SpringConfMain {
	@Autowired
	private PoeticJuggler duke;			// PoeticJuggler 타입 객체가 자동 주입됨
	@Autowired
	private Instrumentalist instr;		// Instrumentalist 타입 객체가 자동 주입됨
	@Autowired
	private OneManBand hank;			// OneManBand 타입 객체가 자동 주입됨

	@Autowired
	private Singer lena;

	@Autowired
	private Singer suhyun;



	@Bean
	public SpringIdol springIdol() {
		SpringIdol si = new SpringIdol();
		si.setPerformers(new Performer[]{duke, instr, hank, lena, suhyun});	// 위 필드를 통해 객체 참조
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