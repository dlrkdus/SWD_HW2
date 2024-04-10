package springidol.javaconf1;

import org.springframework.context.annotation. AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import springidol.TalentCompetition;

public class SpringIdolMain_javaconf1 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = 
				new AnnotationConfigApplicationContext(SpringConfig.class);

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);
		competition.run();
		
		ctx.close();
	}
}
