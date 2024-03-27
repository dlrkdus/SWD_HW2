package springidol;

import java.util.Properties;
import java.util.Map;

public class OneManBand implements Performer {

	//instruments 속성 Map 으로 변경
	private Map<String, Instrument> instruments;

	public OneManBand() {
	}

	// setter 속성도 Map 으로 변경
	public void setInstruments(Map<String, Instrument> instruments) {
		this.instruments = instruments;
	}

	//String, Instrument 타입에 각각 맞게 변경 (36,37 참고)
	@Override
	public void perform() throws PerformanceException {
		for (String key : instruments.keySet()) {
			System.out.println(key + " : ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}

}
