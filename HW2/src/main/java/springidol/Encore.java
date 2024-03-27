package springidol;

public class Encore {
	private Performer encorePerformer;

	public void setEncorePerformer(Performer performer) {
		this.encorePerformer = performer;
	}

	public void execute() {
		System.out.println("Encore Performance");
		encorePerformer.perform();
	}
}
