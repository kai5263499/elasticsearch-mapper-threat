// MyRestHandler.scala
import org.elasticsearch.common.inject.Inject
import org.elasticsearch.rest.RestRequest.Method
import org.elasticsearch.rest._
 
class MyRestHandler @Inject() (restController: RestController) extends RestHandler {
 
  restController.registerHandler(Method.GET, "/_hello", this)
 
  override def handleRequest(request: RestRequest, channel: RestChannel): Unit = {
    val name  = request.param("name")
    val message = s"Hello ${name}!!!"
 
    channel.sendResponse(new StringRestResponse(RestStatus.OK, message))
  }
}