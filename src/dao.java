public class dao {
    private int uid;
    private String uname;
    private int age;

    public dao(int uid, String uname, int age) {
        this.uid = uid;
        this.uname = uname;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", age=" + age +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
