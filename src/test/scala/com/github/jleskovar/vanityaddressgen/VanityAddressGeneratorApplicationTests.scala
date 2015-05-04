package com.github.jleskovar.vanityaddressgen

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[VanityAddressGeneratorApplication]))
class VanityAddressGeneratorApplicationTests {

  @Test
  def contextLoads: Unit = {
  }

}
