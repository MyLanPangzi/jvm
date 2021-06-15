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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DrinkerTest {

  static class Drinker {
    private final int price;
    private final int bottleConversionRate;
    private final int capConversionRate;

    private int amount;
    private int bottle;
    private int cap;
    private int count;

    public Drinker(int amount, int bottle, int cap, int price, int bottleConversionRate, int capConversionRate) {
      this.amount = amount;
      this.bottle = bottle;
      this.cap = cap;
      this.price = price;
      this.bottleConversionRate = bottleConversionRate;
      this.capConversionRate = capConversionRate;
      this.count = 0;
    }

    public int drink() {
      while (amount > 0) {
        int buy = amount / price;
        count += buy;
        bottle += buy;
        cap += buy;
        amount = 0;
      }

      while (bottle / bottleConversionRate > 0 || cap / capConversionRate > 0) {
        int bottleConversion = this.bottle / bottleConversionRate;
        this.bottle = bottleConversion + this.bottle % bottleConversionRate;
        count += bottleConversion;
        cap += bottleConversion;

        int capConversion = this.cap / capConversionRate;
        this.cap = capConversion + this.cap % capConversionRate;
        count += capConversion;
        this.bottle += capConversion;
      }
//      System.out.printf("%d %d %d %d \n", amount, bottle, cap, count);
      return count;
    }

    public int drinkRecursive() {

      drink0(amount, bottle, cap);

      return this.count;
    }

    private void drink0(int amount, int bottle, int cap) {
//      System.out.printf("%d %d %d\n", bottle, cap, count);
      if (amount > 0) {
        count++;
        drink0(amount - price, bottle + 1, cap + 1);
        return;
      }

      if (bottle / bottleConversionRate > 0) {
        count++;
        drink0(amount, bottle - bottleConversionRate + 1, cap + 1);
        return;
      }

      if (cap / capConversionRate > 0) {
        count++;
        drink0(amount, bottle + 1, cap - capConversionRate + 1);
      }
    }
  }


  @Test
  void testDrink() {
    assertEquals(1, new Drinker(2, 0, 0, 2, 3, 5).drink());
    assertEquals(4, new Drinker(6, 0, 0, 2, 3, 5).drink());
    assertEquals(7, new Drinker(8, 0, 0, 2, 3, 5).drink());
    System.out.println(new Drinker(100, 0, 0, 2, 3, 5).drink());
  }

  @Test
  void testDrinkRecursive() {
    assertEquals(1, new Drinker(2, 0, 0, 2, 3, 5).drinkRecursive());
    assertEquals(4, new Drinker(6, 0, 0, 2, 3, 5).drinkRecursive());
    assertEquals(7, new Drinker(8, 0, 0, 2, 3, 5).drinkRecursive());
    System.out.println(new Drinker(100, 0, 0, 2, 3, 5).drinkRecursive());
  }


}
