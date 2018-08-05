
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class FloodSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8081")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (X11; Linux x86_64; rv:61.0) Gecko/20100101 Firefox/61.0")

	val headers = Map(
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")


	var scn = scenario("FloodSimulation")

	for (i <- 1 to 10) {
		scn = scn.exec(http("request_"+String.valueOf(i))
			.get("/"+String.valueOf(i))
			.headers(headers))
	}

	setUp(scn.inject(atOnceUsers(10000))).protocols(httpProtocol)
}
