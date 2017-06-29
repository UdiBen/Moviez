package bootstrap

import com.google.inject.{AbstractModule, Singleton}
import net.codingwell.scalaguice.ScalaModule
import utils.{ApiCaller, IApiCaller}

/**
  * Created by udi on 6/29/2017.
  */
class ioc {

}

object MoviezModule extends AbstractModule with ScalaModule {
	override def configure(): Unit = {
		bind[IApiCaller].to[ApiCaller].in[Singleton]
	}
}
