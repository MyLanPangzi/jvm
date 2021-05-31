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

package com.hiscat;

public class SlotTest {


  /**
   * 0	0	  21	0	cp_info #11 this cp_info #12
   * 1	3	  18	1	cp_info #14	cp_info #15
   * 2	13	8	2	cp_info #16	cp_info #15
   */
  public void m() {
    int a = 10;
    System.out.println(a);
    int b = 20;
    System.out.println(b);
  }

  /**
   * 0	2	  7	  1	cp_info #14	a cp_info #15
   * 1	0	  20	0	cp_info #11 this	cp_info #12
   * 2	12	8	  1	cp_info #16	b cp_info #15
   */
  public void m2() {
    {
      int a = 0;
      System.out.println(a);
    }
    int b = 10;
    System.out.println(b);
  }
}
