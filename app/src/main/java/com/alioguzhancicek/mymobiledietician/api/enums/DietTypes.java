package com.alioguzhancicek.mymobiledietician.api.enums;

public enum DietTypes {
    KCAL1200(1),
    KCAL1300(2),
    KCAL1400(3),
    KCAL1500(4),
    KCAL1600(5),
    KCAL1700(6),
    KCAL1800(7),
    KCAL1900(8),
    KCAL2000(9),
    KCAL2100(10),
    KCAL2200(11),
    KCAL2300(12),
    KCAL2400(13),
    KCAL2500(14),
    KCAL2600(15),
    KCAL2700(16),
    KCAL2800(17),
    KCAL2900(18),
    KCAL3000(19),
    KCAL3100(20),
    KCAL3200(21),
    KCAL3300(22),
    KCAL3400(23),
    KCAL3500(24),
    KCAL3600(25),
    KCAL3700(26),
    KCAL3800(27),
    KCAL3900(28),
    KCAL4000(29),
    NOTPROPER(30);

    private final int value;

    private DietTypes(int value) {
        this.value = value;
    }
}
