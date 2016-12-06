package classTest;

/**
 * Created by norman on 16-11-29.
 */
public class test {

    private String aaa;
    private Integer bbb;
    public test(){}

    public test(String aaa, Integer bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
    }

    @Override
    public String toString() {
        return "test{" +
                "aaa='" + aaa + '\'' +
                ", bbb=" + bbb +
                '}';
    }
}
