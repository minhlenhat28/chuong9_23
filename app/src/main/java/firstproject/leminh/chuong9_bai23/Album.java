package firstproject.leminh.chuong9_bai23;

public class Album {
    private int stt;
    private String maalbum;
    private String tenalbum;
    public Album(int stt,String maalbum,String tenalbum){
        this.stt = stt;
        this.maalbum = maalbum;
        this.tenalbum = tenalbum;
    }
    public int getStt(){
        return stt;
    }

    public String getTenalbum() {
        return tenalbum;
    }

    public void setTenalbum(String tenalbum) {
        this.tenalbum = tenalbum;
    }

    public String getMaalbum() {
        return maalbum;
    }
    public void setMaalbum(String maalbum){
        this.maalbum = maalbum;
    }
}
