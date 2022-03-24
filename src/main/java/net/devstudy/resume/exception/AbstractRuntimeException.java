package net.devstudy.resume.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractRuntimeException extends RuntimeException{
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
}
