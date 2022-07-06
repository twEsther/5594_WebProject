package wefly.entity;

public class WeflyException extends Exception {

	public WeflyException() {
		super();
	}

	public WeflyException(String message, Throwable cause) {
		super(message, cause);
	}

	public WeflyException(String message) {
		super(message);
	}

}
