/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hiscat.chapter02;

/*
* 有static 非 final字段会产生clinit方法
* 从上至下执行
* */
public class Clinit {
  public static int a = 1;

  static {
    b = 10;
    //    System.out.println(b);//Illegal forward reference
    // 0 iconst_1
    // 1 putstatic #5 <com/hiscat/chapter02/Clinit.a>
    // 4 bipush 10
    // 6 putstatic #3 <com/hiscat/chapter02/Clinit.b>
    // 9 iconst_2
    //10 putstatic #3 <com/hiscat/chapter02/Clinit.b>
    //13 return
  }

  public static int b = 2;


  public static void main(String[] args) {
    System.out.println(Clinit.b);
  }
}
