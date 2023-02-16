package br.com.jasaas.util;

/**
 *
 * @author willian
 */
public enum ScheduleOffset {
    N_0("0"),//Enviar no dia do vencimento
    N_5("5"),//Enviar 5 dias antes do vencimento
    N_10("10"),//Enviar 10 dias antes do vencimento
    N_15("15");//Enviar 15 dias antes do vencimento 

    private final String value;

    ScheduleOffset(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ScheduleOffset fromValue(String v) {
        for (ScheduleOffset c : ScheduleOffset.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
