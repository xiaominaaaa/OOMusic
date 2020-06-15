package cn.OOMusic.pojo;

public class Massage {
    private int code;
    private String massage;

    public int getCode() {
        return code;
    }

    public Massage(int code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
