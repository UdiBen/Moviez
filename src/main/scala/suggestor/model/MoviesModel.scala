package suggestor.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
  * Created by udi on 6/29/2017.
  */
case class DiscoverResponse(@JsonProperty("total_results") totalResults: Int,
                           @JsonProperty("results")movies: Array[Movie])

case class Movie(@JsonProperty("vote_count")voteCount: Int,
                 @JsonProperty("poster_path")poster: String,
                 @JsonProperty("title")title: String,
                 @JsonProperty("overview")overview: String)