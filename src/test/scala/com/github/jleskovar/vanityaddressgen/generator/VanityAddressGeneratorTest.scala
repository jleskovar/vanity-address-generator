package com.github.jleskovar.vanityaddressgen.generator

import org.bitcoinj.core.{Address, NetworkParameters}
import org.scalatest.{Matchers, FunSuite}

/**
 * Created by james on 6/05/15.
 */
class VanityAddressGeneratorTest extends FunSuite with Matchers {

  val networkParameters: NetworkParameters = NetworkParameters.fromID(NetworkParameters.ID_MAINNET)
  val addressGenerator = new VanityAddressGenerator(networkParameters)

  test("vanity address generation actually works") {
    val (address, key) = addressGenerator.generateAddress("1Ty")
    address.toString should startWith ("1Ty")

    val addressFromPubKeyHash = new Address(networkParameters, key.getPubKeyHash)
    address.toString shouldBe addressFromPubKeyHash.toString
  }

}
