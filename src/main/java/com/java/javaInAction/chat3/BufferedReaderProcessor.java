package com.java.javaInAction.chat3;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @创建人 tengcc
 * @创建时间 2019/4/28
 * @描述
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader  b)throws IOException;
}
