package co.com.spn.cun3.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author joslopez
 *
 */

@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public @Data class Cun3Exception extends RuntimeException {

	private static final long serialVersionUID = -991730016462930931L;

	private HttpStatus status;
	private String message;
	private List<String> errors;
	private Throwable cause;

	public Cun3Exception(final HttpStatus status, final String message, final String error) {
		this(status, message, Arrays.asList(error), new Exception());
	}

	public Cun3Exception(final HttpStatus status, final String message, final List<String> error) {
		this(status, message, error, new Exception());
	}

	public Cun3Exception(Throwable cause, final String message, final String... error) {
		this(HttpStatus.BAD_REQUEST, message, Arrays.asList(error), cause);
	}

	public String getCompleteMessage() {
		StringBuffer msg = new StringBuffer(message);
		for (String error : errors) {
			msg.append(error);
			msg.append("\n");
		}
		return msg.toString();
	}

}