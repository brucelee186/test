package 线程.线程池;

public abstract class Task {

	public enum State {
		NEW, 
		RUNNING,
		FINISH
	}
	
	private State state = State.NEW;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public abstract void deal();
}
