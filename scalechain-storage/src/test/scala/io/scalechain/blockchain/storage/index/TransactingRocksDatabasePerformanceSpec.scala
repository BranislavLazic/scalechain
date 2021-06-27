package io.scalechain.blockchain.storage.index

import java.io.File

import io.scalechain.blockchain.storage.Storage
import org.apache.commons.io.FileUtils
import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TransactingRocksDatabasePerformanceSpec extends AnyFlatSpec with KeyValueDatabasePerformanceTrait with Matchers with BeforeAndAfterEach {
  this: Suite =>

  Storage.initialize()

  var db : KeyValueDatabase = null
  var transactingDB : TransactingRocksDatabase = null

  override def beforeEach() {

    val testPath = new File("./target/unittests-RocksDatabasePerformanceSpec")
    FileUtils.deleteDirectory( testPath )
    transactingDB = new TransactingRocksDatabase( new RocksDatabase( testPath ) )
    transactingDB.beginTransaction()
    db = transactingDB

    super.beforeEach()
  }

  override def afterEach() {
    super.afterEach()

    transactingDB.commitTransaction()
    db.close()
  }
}
