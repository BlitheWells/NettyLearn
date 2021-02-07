package spring.service;

import org.springframework.stereotype.Service;
import spring.aspect.anotation.TestAspect;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SpringRelatedServiceImpl implements SpringRelatedService {

    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    @Override
    @TestAspect
    public String formatDate(Date date) {
        System.out.println("formatDate method body itself!");
        return dateFormatThreadLocal.get().format(date);
    }
}
