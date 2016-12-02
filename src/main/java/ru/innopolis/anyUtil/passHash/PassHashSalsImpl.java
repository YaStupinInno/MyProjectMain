package ru.innopolis.anyUtil.passHash;

/**
 * Created by ADMIN on 02.12.2016.
 */
public class PassHashSalsImpl implements PassHashSals {
    @Override
    public String getSals() {

            String symbols = "abcdefghijklmnopqrstuvwxyzABCEDFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder randString = new StringBuilder();
            int count = (int)(Math.random()*20);
            for(int i=0;i<count;i++)
                randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
            return String.valueOf(randString);

    }
}
