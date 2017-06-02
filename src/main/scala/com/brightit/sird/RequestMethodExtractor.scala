/*
 * Copyright (C) 2009-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package com.brightit.sird

/**
 * An extractor that extracts requests by method.
 */
class RequestMethodExtractor private[sird] (method: String) {
  def unapply[T](t: T)(implicit sc: IsSirdMethodCompatible[T]): Option[T] =
    Some(t).filter(sc.method(_).equalsIgnoreCase(method))
}

/**
 * Extractors that extract requests by method.
 */
trait RequestMethodExtractors {

  /**
   * Extracts a GET request.
   */
  val GET = new RequestMethodExtractor("GET")

  /**
   * Extracts a POST request.
   */
  val POST = new RequestMethodExtractor("POST")

  /**
   * Extracts a PUT request.
   */
  val PUT = new RequestMethodExtractor("PUT")

  /**
   * Extracts a DELETE request.
   */
  val DELETE = new RequestMethodExtractor("DELETE")

  /**
   * Extracts a PATCH request.
   */
  val PATCH = new RequestMethodExtractor("PATCH")

  /**
   * Extracts an OPTIONS request.
   */
  val OPTIONS = new RequestMethodExtractor("OPTIONS")

  /**
   * Extracts a HEAD request.
   */
  val HEAD = new RequestMethodExtractor("HEAD")
}
