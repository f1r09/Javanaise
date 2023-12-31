package irc;

import jvn.annotation.JvnLockMethod;
import jvn.annotation.JvnLockType;

import java.io.Serializable;

public interface Sentence extends Serializable {

	@JvnLockMethod(lockType = JvnLockType.WRITE)
	void write(String text);

	@JvnLockMethod(lockType = JvnLockType.READ)
	String read();
}
