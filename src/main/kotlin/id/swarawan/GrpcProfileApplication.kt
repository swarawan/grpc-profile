package id.swarawan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GrpcProfileApplication

fun main(args: Array<String>) {
	runApplication<GrpcProfileApplication>(*args)
}
