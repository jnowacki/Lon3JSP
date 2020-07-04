package pl.jnowacki;

import java.io.Serializable;

public class Person implements Serializable {

    private String myName;
    private String pwd;

    public Person() {
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
