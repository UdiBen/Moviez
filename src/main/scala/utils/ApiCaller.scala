package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

import scalaj.http.Http

/**
  * Created by udi on 6/29/2017.
  */
trait IApiCaller {
	def call[T](url: String, params: (String, String)*)(implicit m: Manifest[T]): T
}

class ApiCaller extends IApiCaller {

	private var mapper: ObjectMapper = _

	init()

	def init(): Unit = {
		mapper = new ObjectMapper() with ScalaObjectMapper
		mapper.registerModule(DefaultScalaModule)
	}

	def call[T](url: String, params: (String, String)*)(implicit m: Manifest[T]): T = {
		val rawValue = Http(url).params(params).asString
		JsonUtil.fromJson[T](rawValue.body)
	}
}
