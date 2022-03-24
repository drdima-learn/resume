package net.devstudy.resume.exception;

public class CantCompleteClientRequestException extends AbstractRuntimeException {
    public CantCompleteClientRequestException(String s) {
        LOGGER.debug(s);
    }
}
