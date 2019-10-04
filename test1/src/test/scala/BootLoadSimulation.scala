import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BootLoadSimulation extends Simulation {

  private val baseUrl = "http://localhost:8080"
  private val endpoint = "/entities"
  private val contentType = "application/json"
  private val requestCount = 50
  private val simUsers = 1000

  private val httpConf = http
    .baseUrl(baseUrl)
    .acceptHeader("application/json;charset=UTF-8")

  private val addPersonTest = repeat(requestCount) {
    exec(http("createEntityTest")
      .post(endpoint)
      .header("Content-Type", contentType)
      .header("X-MyHeader", "test")
      .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJpc3MiOiJjb20uZXhhbXBsZSJ9.8yA1CQCWoZ26MZpvnnBErSZC6xkkZEndyGD4Gv11aQA")
      .body(StringBody(
        s"""
           | {
           |  "name": "test-name",
           |  "data": "test-data",
           |  "value": 0
           | }
         """.stripMargin
      ))
      .check(status.in(200, 400, 403))
    )
  }
  private val scn = scenario("BootLoadSimulation")
    .exec(addPersonTest)

  setUp(scn.inject(atOnceUsers(simUsers))).protocols(httpConf)
}
