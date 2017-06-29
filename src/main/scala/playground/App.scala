package playground

import bootstrap.MoviezModule
import com.google.inject.Guice
import net.codingwell.scalaguice.InjectorExtensions._

/**
  * @author udi
  */
object App {

	def main(args: Array[String]) {
		val injector = Guice.createInjector(MoviezModule)

		val suggestor = injector.instance[MovieSuggestor]
		val movie = suggestor.Suggest()
		println(movie.title)
		println(movie.overview)
		println(movie.voteCount)
	}

}
