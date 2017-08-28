package com.k.suggestion

import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

trait JsonSupport extends PlayJsonSupport {
  import play.api.libs.json._

  implicit def suggestionJsonFormat = Json.format[Suggestion]
}
