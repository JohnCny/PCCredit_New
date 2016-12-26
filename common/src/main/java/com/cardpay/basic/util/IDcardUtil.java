package com.cardpay.basic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rankai .
 * Date 2016/8/24 .
 */
public class IDcardUtil {

    private static IDcardUtil dcard = new IDcardUtil();

    final int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
    final int[] vi = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
    private int[] ai = new int[18];

    private IDcardUtil() {

    }

    /**
     * 验证身份证格式是正确
     *
     * @param idCard 身份证号
     * @return 格式是否正确
     */
    public static boolean verify(String idCard) {
        if (idCard == null) {
            return false;
        }
        idCard = idCard.trim();
        if (idCard.length() == 15) {
            idCard = dcard.uptoeighteen(idCard);
        }
        if (idCard.length() != 18) {
            return false;
        }
        String verify = idCard.substring(17, 18);
        if (verify.equals(dcard.getVerify(idCard))) {
            return true;
        }
        return false;
    }

    public static Date getBirthdayByIDcard(String idcard) {
        if (verify(idcard)) {
            String birthday = idcard.substring(6, 14);
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getAgeByIDcard(String idcard) {
        if (verify(idcard)) {
            Calendar _cal = Calendar.getInstance();
            Calendar today = Calendar.getInstance();
            _cal.set(Integer.parseInt(idcard.substring(6, 10)), Integer.parseInt(idcard.substring(10, 12)),
                    Integer.parseInt(idcard.substring(12, 14)));
            return dcard.getYearDiff(today, _cal);
        }
        return 0;
    }

    public static String getSexByIDcard(String idcard) {
        if (verify(idcard)) {
            String lastValue = idcard.substring(idcard.length() - 1, idcard.length());
            int sex;
            if (lastValue.trim().toLowerCase().equals("x") || lastValue.trim().toLowerCase().equals("e")) {
                return "男";
            } else {
                sex = Integer.parseInt(lastValue) % 2;
                return sex == 0 ? "女" : "男";
            }
        }
        return "";
    }

    private int getYearDiff(Calendar cal, Calendar _cal) {
        int m = (cal.get(cal.MONTH)) - (_cal.get(_cal.MONTH));
        int y = (cal.get(cal.YEAR)) - (_cal.get(_cal.YEAR));
        return (y * 12 + m) / 12;
    }

    private String getVerify(String eightcardid) {
        int remaining = 0;
        if (eightcardid.length() == 18) {
            eightcardid = eightcardid.substring(0, 17);
        }
        if (eightcardid.length() == 17) {
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                String k = eightcardid.substring(i, i + 1);
                ai[i] = Integer.parseInt(k);
            }
            for (int i = 0; i < 17; i++) {
                sum = sum + wi[i] * ai[i];
            }
            remaining = sum % 11;
        }
        return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
    }

    private String uptoeighteen(String fifteencardid) {
        String eightcardid = fifteencardid.substring(0, 6);
        eightcardid = eightcardid + "19";
        eightcardid = eightcardid + fifteencardid.substring(6, 15);
        eightcardid = eightcardid + getVerify(eightcardid);
        return eightcardid;
    }
}