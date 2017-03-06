import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RoutesSpec extends MixedPlaySpecWithNoDefaultApp
{
  "send OK on router test" in new Server((new MyApplicationBuilder()).build()) {
    implicit val ec = app.materializer.executionContext

    wsUrl("/").get().map { response =>
      response.status mustBe 200
    }
  }

}