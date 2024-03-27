package springidol.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
@Component("hank")
public class OneManBand implements Performer {

	@Autowired
	@Qualifier("hank")
	private Collection<Instrument> instruments;

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}

	public void perform() throws PerformanceException {
		for(Instrument instrument : instruments) {
			instrument.play();
		}
	}
}
