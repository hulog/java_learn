package classTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by norman on 16-11-29.
 */
public class ClassTest {


    public static void main(String[] args)  {
        Class clazz = null;
        try {
            clazz = Class.forName("classTest.test");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] fields = clazz.getFields();
        Constructor[] constructors = clazz.getConstructors();
        Method[] methods = clazz.getMethods();

//        clazz.newInstance();

        for (Field f : fields) {
            System.out.println(f.getName());
        }

    }

}
