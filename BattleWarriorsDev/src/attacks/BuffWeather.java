package attacks;

import models.BattleStats;
import models.Player;
import utilities.BattleLog;

public class BuffWeather extends BuffEffect{

	boolean weatherProof;
	int weatherProofCounter;
	
	public BuffWeather(String name, String description, String keyword, int chance, boolean weatherProof,
			int weatherProofCounter) {
		super(name, description, keyword, chance);
		this.weatherProof = weatherProof;
		this.weatherProofCounter = weatherProofCounter;
	}

	@Override
	public void doBuffEffect(Player target, Player self, BattleLog log) {
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
	
	
}
