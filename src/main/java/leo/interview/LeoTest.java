package leo.interview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class LeoTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Logger logger = LoggerFactory.getLogger(LeoTest.class);
        logger.info(new String(Base64.getDecoder().decode("ZHN3ZWkxOTg5"), "UTF-8"));
        System.out.println(new String(Base64.getDecoder().decode("ZHN3ZWkxOTg5"), "UTF-8"));
        logger.error("hello world");
    }
}
