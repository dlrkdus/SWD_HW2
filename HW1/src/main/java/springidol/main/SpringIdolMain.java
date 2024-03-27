package springidol.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import springidol.TalentCompetition;
import springidol.Encore;


public class SpringIdolMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springIdol.xml");

		TalentCompetition competition = ctx.getBean("springIdol", TalentCompetition.class);

		competition.run();

		//참가자들의 공연이 모두 끝난 후 Encore bean 을 이용하여 앵콜 공연을 실시하도록
		//SpringIdolMain#main() 메소드를 수정한다.
		Encore encore = ctx.getBean("encore", Encore.class);

		encore.execute();
		ctx.close();
	}
}
