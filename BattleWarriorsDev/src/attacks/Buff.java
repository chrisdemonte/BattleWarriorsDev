package attacks;

import models.BattleStats;
import models.Player;

public abstract class Buff {
	
	BuffEffect intial;
	BuffEffect periodic;
	BuffEffect end;
	int duration;
	int counter;
	
	public Buff(BuffEffect intial, BuffEffect periodic, BuffEffect end, int duration, int counter) {
		super();
		this.intial = intial;
		this.periodic = periodic;
		this.end = end;
		this.duration = duration;
		this.counter = counter;
	}

	public void doIntialBuff(Player target, Player self) {
		if (this.intial != null) {
			this.intial.doBuffEffect(target, self);
		}
	}
	public void doPeriodicBuff(Player target, Player self) {
		if (this.counter == 1 && this.end != null) {
			this.end.doBuffEffect(target, self);
			this.counter -= 1;
		}
		else if (this.counter == 1 && this.end == null && this.periodic != null) {
			this.periodic.doBuffEffect(target, self);
			this.counter -= 1;
		}
		else if (this.counter > 1 && this.periodic != null) {
			this.end.doBuffEffect(target, self);
			this.counter -= 1;
		}
		else {
			this.counter -= 1;
		}
	}
}
