package playground

import com.google.inject.Inject
import suggestor.model.{DiscoverResponse, Movie}
import utils.IApiCaller

/**
  * Created by udi on 6/29/2017.
  */
class MovieSuggestor @Inject()(apiCaller: IApiCaller) {
	private val appKey: String = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NTlmNjJkNGIyYmZjNWZhODUyODNiZmJmY2Y3ODFlMSIsInN1YiI6IjU5NTI1ZDE3OTI1MTQxMmIzMTAyMzdkZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.tTeSfE1ffPQOiFZqfSl-t6oIaJu0uSJ3vEif4B0airA"
	private val apiKey: String = "659f62d4b2bfc5fa85283bfbfcf781e1"
	private val url: String = "https://api.themoviedb.org/3/discover/movie"

	def Suggest(): Movie = {
		apiCaller.call[DiscoverResponse](url, ("api_key", apiKey))
				.movies.headOption.orNull
	}
}
