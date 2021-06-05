package com.atguigu.java;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * jdk6/7中：
 * -XX:PermSize=10m -XX:MaxPermSize=10m
 *
 * jdk8中：
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 * UseCompressedClassPointers UseCompressedOops
 *
 * mac os
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+PrintFlagsFinal
 * Exception in thread "main" java.lang.OutOfMemoryError: Compressed class space
 * 	at java.lang.ClassLoader.defineClass1(Native Method)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:635)
 * 	at com.atguigu.java.OOMTest.main(OOMTest.java:29)
 *
 * mac os
 * 临界值
 * -XX:MetaspaceSize=19m -XX:MaxMetaspaceSize=19m -XX:+PrintFlagsFinal
 * -XX:MetaspaceSize=100m -XX:MaxMetaspaceSize=100m -XX:+PrintFlagsFinal
 * or -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+PrintFlagsFinal -XX:-UseCompressedClassPointers -XX:-UseCompressedOops
 * or -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m -XX:+PrintFlagsFinal -Xms32g -Xmx32g
 * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
 * 	at java.lang.ClassLoader.defineClass1(Native Method)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:756)
 * 	at java.lang.ClassLoader.defineClass(ClassLoader.java:635)
 * 	at com.atguigu.java.OOMTest.main(OOMTest.java:36)
 *
 * @author shkstart  shkstart@126.com
 * @create 2020  22:24
 */
public class OOMTest extends ClassLoader {
    public static void main(String[] args) {
        int j = 0;
        try {
            OOMTest test = new OOMTest();
            for (int i = 0; i < 1000000; i++) {
                //创建ClassWriter对象，用于生成类的二进制字节码
                ClassWriter classWriter = new ClassWriter(0);
                //指明版本号，修饰符，类名，包名，父类，接口
                classWriter.visit(Opcodes.V1_6, Opcodes.ACC_PUBLIC, "Class" + i, null, "java/lang/Object", null);
                //返回byte[]
                byte[] code = classWriter.toByteArray();
                //类的加载
                test.defineClass("Class" + i, code, 0, code.length);//Class对象
                j++;
            }
        } finally {
            System.out.println(j);
        }
    }
}
