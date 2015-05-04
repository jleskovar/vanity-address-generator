package com.github.jleskovar.vanityaddressgen

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
class VanityAddressGeneratorApplication

object VanityAddressGeneratorApplication extends App {
  SpringApplication.run(classOf[VanityAddressGeneratorApplication])
}
