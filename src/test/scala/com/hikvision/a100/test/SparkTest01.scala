/*
 * Copyright 2014 The Hikvision CO.Ltd
 * site: http://www.hikvision.com
 * Prject: a100-spark
 * Description: SparkTest01.scala
 * created at: 2014年12月1日
 */
package com.hikvision.a100.test

import org.junit.Test
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import scala.io.Source

/**
 * @author: <a href="mailto:hbxffj@163.com">方杰</a>
 * @Date: 2014年12月1日 下午3:53:40
 * @version: $Rev$
 */
class SparkTest01 {

  @Test
  def testSimple() {
    val conf = new SparkConf().setAppName("a100").setMaster("local")
    val sc = new SparkContext(conf)
    val data = Array(1, 2, 3, 4, 5)
    // distributed dataset
    val distData = sc.parallelize(data)
    val result = distData.reduce((a, b) => a + b)
    println(result)
  }

  @Test
  def testReadFile() {
    /*
     * Spark can create distributed datasets from any storage source supported by Hadoop, 
     * including your local file system, HDFS, Cassandra,
     * HBase, Amazon S3, etc. Spark supports text files,
     * SequenceFiles, and any other Hadoop InputFormat.
     */
    val conf = new SparkConf().setAppName("a100").setMaster("local")
    val sc = new SparkContext(conf)
    /*
     * Text file RDDs can be created using SparkContext’s textFile method. 
     * This method takes an URI for the file (either a local path on the machine, 
     * or a hdfs://, s3n://, etc URI) and reads it as a collection of lines. 
     * Here is an example invocation:
     */
    val location = this.getClass().getResource("/data.txt")
    val fullPath = location.getPath();
    val distFile = sc.textFile(fullPath)
    // distFile.saveAsObjectFile("aa")

    val result = distFile.map(s => s.length).reduce((a, b) => a + b)
    distFile.persist
    println(result)
  }

}