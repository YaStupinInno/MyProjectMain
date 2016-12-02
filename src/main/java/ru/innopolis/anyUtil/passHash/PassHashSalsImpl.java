package ru.innopolis.anyUtil.passHash;

/**
 * Created by ADMIN on 02.12.2016.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.innopolis.anyUtil.conectBD.ConnectBDImpl;

/**
 * Класс сервисный для методов связанных с паролем Хешем и солью
 */
@Component
public class PassHashSalsImpl implements PassHashSals {
    private final static Logger logger = LoggerFactory.getLogger(PassHashSalsImpl.class);
    /**
     * Метод генерации соли
     * и return строку соли
     * @return
     */
    @Override
    public String getSals() {
            String symbols = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder randString = new StringBuilder();
            int count = (int)(Math.random()*20);
            logger.info("sals generatoin size "+count);
            for(int i=0;i<count;i++)
                randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
            logger.info("sals generatoin   "+String.valueOf(randString));
            return String.valueOf(randString);

    }
}
