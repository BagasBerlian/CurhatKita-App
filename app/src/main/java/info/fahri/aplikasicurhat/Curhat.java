package info.fahri.aplikasicurhat;

import java.io.Serializable;

public class Curhat implements Serializable {
    public String uid;
    public String userid;
    public String email;
    public String konten;

    public Curhat(){

    }

    public Curhat(String userid, String email, String konten) {
        this.userid = userid;
        this.email = email;
        this.konten = konten;
    }

}
