package com.github.jleskovar.vanityaddressgen.generator

import org.scalatest.{Matchers, FunSuite}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGeneratorTest extends FunSuite with Matchers {

  val addressGenerator = new VanityAddressGenerator

  test("vanity address generation actually works") {
    val (address, key) = addressGenerator.generateAddress("1Ty")
    address.toString should startWith ("1Ty")
  }

}
