package com.dzapata.entity;

public class DivisaDTO {
    private String result;
    private String documentation;
    private String terms_of_use;
    private int time_last_update_unix;
    private String time_last_update_utc;
    private int time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private String target_code;
    private double conversion_rate;

    // Constructor
    public DivisaDTO() {}

    public DivisaDTO(String result, String documentation, String terms_of_use, int time_last_update_unix, String time_last_update_utc, int time_next_update_unix, String time_next_update_utc, String base_code, String target_code, double conversion_rate) {
        this.result = result;
        this.documentation = documentation;
        this.terms_of_use = terms_of_use;
        this.time_last_update_unix = time_last_update_unix;
        this.time_last_update_utc = time_last_update_utc;
        this.time_next_update_unix = time_next_update_unix;
        this.time_next_update_utc = time_next_update_utc;
        this.base_code = base_code;
        this.target_code = target_code;
        this.conversion_rate = conversion_rate;
    }

    // Getters y Setters
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getTermsOfUse() {
        return terms_of_use;
    }

    public void setTermsOfUse(String terms_of_use) {
        this.terms_of_use = terms_of_use;
    }

    public int getTimeLastUpdateUnix() {
        return time_last_update_unix;
    }

    public void setTimeLastUpdateUnix(int time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getTimeLastUpdateUtc() {
        return time_last_update_utc;
    }

    public void setTimeLastUpdateUtc(String time_last_update_utc) {
        this.time_last_update_utc = time_last_update_utc;
    }

    public int getTimeNextUpdateUnix() {
        return time_next_update_unix;
    }

    public void setTimeNextUpdateUnix(int time_next_update_unix) {
        this.time_next_update_unix = time_next_update_unix;
    }

    public String getTimeNextUpdateUtc() {
        return time_next_update_utc;
    }

    public void setTimeNextUpdateUtc(String time_next_update_utc) {
        this.time_next_update_utc = time_next_update_utc;
    }

    public String getBaseCode() {
        return base_code;
    }

    public void setBaseCode(String base_code) {
        this.base_code = base_code;
    }

    public String getTargetCode() {
        return target_code;
    }

    public void setTargetCode(String target_code) {
        this.target_code = target_code;
    }

    public double getConversionRate() {
        return conversion_rate;
    }

    public void setConversionRate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }
}
