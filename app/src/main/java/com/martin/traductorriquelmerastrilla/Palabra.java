package com.martin.traductorriquelmerastrilla;

import java.io.Serializable;

public class Palabra implements Serializable {
    private String palabraEsp;
    private String palabraEng;
    private int img;

    public Palabra(String palabraEsp, String palabraEng, int img) {
        this.palabraEsp = palabraEsp;
        this.palabraEng = palabraEng;
        this.img = img;
    }

    public String getPalabraEsp() {
        return palabraEsp;
    }

    public void setPalabraEsp(String palabraEsp) {
        this.palabraEsp = palabraEsp;
    }

    public String getPalabraEng() {
        return palabraEng;
    }

    public void setPalabraEng(String palabraEng) {
        this.palabraEng = palabraEng;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
