package attacks;

import BattleSystem.BattleBuffHolder;
import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffWeather extends BuffEffect{

	private static final long serialVersionUID = 2610919093428759592L;
	boolean weatherProof;
	int weatherProofCounter;
	
	public BuffWeather(int chance, boolean weatherProof,
			int weatherProofCounter) {
		super(chance);
		this.weatherProof = weatherProof;
		this.weatherProofCounter = weatherProofCounter;
		this.keyword = "weather";
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleBuffHolder bbHolder, BattleLog log) {
		BattleStats stats = target.getBattleStats();
		if (this.weatherProofCounter != 0) {
			stats.setWeatherProof(this.weatherProof);
			if (this.weatherProofCounter > stats.getWeatherProofCounter() && stats.isWeatherProof()) {
				stats.setWeatherProofCounter(this.weatherProofCounter);
			}
			if (!stats.isWeatherProof()) {
				stats.setWeatherProofCounter(0);
			}
		}
		
	}

	@Override
	public String toString() {
		return "BuffWeather [weatherProof=" + weatherProof + "\nweatherProofCounter=" + weatherProofCounter
				+ "\nchance=" + chance + "\nkeyword=" + keyword + "]";
	}
	
	
}
