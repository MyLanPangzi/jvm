/*
 *
 *  * Licensed to the Apache Software Foundation (ASF) under one
 *  * or more contributor license agreements.  See the NOTICE file
 *  * distributed with this work for additional information
 *  * regarding copyright ownership.  The ASF licenses this file
 *  * to you under the Apache License, Version 2.0 (the
 *  * "License"); you may not use this file except in compliance
 *  * with the License.  You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.hiscat.chapter02;


import sun.misc.Launcher;

import java.util.Arrays;

public class ClassloaderTest {
  public static void main(String[] args) throws ClassNotFoundException {
    ClassLoader app = ClassLoader.getSystemClassLoader();
    System.out.println(app);

    ClassLoader ext = app.getParent();
    System.out.println(ext);

    ClassLoader boot = ext.getParent();
    System.out.println(boot);

    ClassLoader app1 = ClassloaderTest.class.getClassLoader();
    System.out.println(app1);

    System.out.println(String.class.getClassLoader());

    System.out.println("\n boot dirs");
    Arrays.stream(Launcher.getBootstrapClassPath().getURLs()).forEach(System.out::println);

    System.out.println("\n ext dirs: ");
    Arrays.stream(System.getProperty("java.ext.dirs").split(":")).forEach(System.out::println);

    System.out.println(Class.forName("java.lang.String").getClassLoader());
    System.out.println(Thread.currentThread().getContextClassLoader());
    System.out.println(ClassLoader.getSystemClassLoader());
  }
}
