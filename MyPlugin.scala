// MyPlugin.scala
import java.util
 
import org.elasticsearch.common.collect.Lists
import org.elasticsearch.common.inject.Module
import org.elasticsearch.plugins.AbstractPlugin
 
class MyPlugin extends AbstractPlugin {
  override def name = "MyPlugin" // this important for installing / removing the plugin
  override def description = "scala rules"
 
  override def modules: util.Collection[Class[_ <: Module]] = {
    val modules = Lists.newArrayList.asInstanceOf[util.Collection[Class[_ <: Module]]]
    modules.add(classOf[MyModule])
 
    modules
  }
}