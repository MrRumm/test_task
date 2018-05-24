package org.work.test.NetAddressClass;

/**
 * Класс для преобразования IP адреса из строки в long и обратно.
 */
public class Address implements Comparable<Address>{
    private long addressAsLong;

    /**
     * Конструктор класса, принимает строку преобразованную в long
     * @param stringAddress IP адрес введённый пользователем
     */
    public Address(String stringAddress) {
        if(validateCheck(stringAddress) == false) {
            throw new IllegalArgumentException(stringAddress + " не является допустимым адресом!!!");
        }

        addressAsLong = ipToLong(stringAddress);
    }

    /**
     * Проверяет введённый пользователем IP адрес на соответствие стандарту
     * @param val1 IP адрес введённый пользователем
     * @return логическое значение true/false
     */
    private static boolean validateCheck(String val1) {
        boolean returnValue = false;
        String pattern = "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";

        if(val1.matches(pattern)){
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * Проверяет не превышает ли адрес в long, указанный диапазон
     * @return логическое значение true/false
     */
    public boolean checkRange() {
        boolean returnValue = false;
        if(addressAsLong > 0L && addressAsLong < 0xffffffffL) {
            returnValue = true;
        }
        return returnValue;
    }

    /**
     * Преобразует строчное значение (IP адрес) в long
     * @param ip строчное (IP адрес) значение
     * @return значение (IP адрес) типа long
     */
    private long ipToLong(String ip) {
        String[] ipSplit = ip.split("\\.");
        long longIp = 0;
        for (int i = 0; i < ipSplit.length; i++) {
            longIp += Integer.parseInt(ipSplit[i]) * Math.pow(256, 3 - i);
        }
        return longIp;
    }

    /**
     * Возвращает IP адрес в представлении long
     * @return переменная типа long
     */
    public long getAsLong() {
        return addressAsLong;
    }

    /**
     * Переводит значение типа long в строку и возвращает в виде адреса
     * @param longIp значение (IP адрес) типа long
     * @return строковое представление адреса
     */
    public String longToIp(long longIp) {
        return ((longIp >> 24) & 0xFF) + "." +
                ((longIp >> 16) & 0xFF) + "." +
                ((longIp >> 8) & 0xFF) + "." +
                (longIp & 0xFF);
    }

    /**
     * Увеличивает адрес на 1
     */
    public void incrementIp() {
        addressAsLong++;
    }

    /**
     * Уменьшает адрес на единицу
     */
    public void decrementIp() {
        addressAsLong--;
    }

    /**
     * Сравнивает два объекта (адреса) между собой
     * @param o экземпляр класса Address
     * @return -1 если первый объект больше второго, 1 если меньше, 0 если равны
     */
    @Override
    public int compareTo(Address o) {
        return (addressAsLong > o.getAsLong() ? -1 : (addressAsLong < o.getAsLong()) ? 1 : 0);
    }
}
