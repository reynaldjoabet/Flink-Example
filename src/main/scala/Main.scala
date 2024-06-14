import scala.jdk.CollectionConverters._

import org.apache.flink.api.java.aggregation
import org.apache.flink.streaming
import org.apache.flink.streaming.api.checkpoint
import org.apache.flink.streaming.api.datastream
import org.apache.flink.streaming.api.environment
import org.apache.flink.streaming.api.functions
import org.apache.flink.streaming.api.graph
import org.apache.flink.streaming.api.operators
import org.apache.flink.streaming.api.transformations
import org.apache.flink.streaming.api.watermark
import org.apache.flink.streaming.api.windowing
import org.apache.flink.streaming.api.CheckpointingMode
import org.apache.flink.FlinkVersion

object Main extends App {

  println(s"Hello, World! ${FlinkVersion.v1_19}")

  val env = environment.StreamExecutionEnvironment.getExecutionEnvironment()

  env.fromSequence(1L, 1000L).executeAndCollect().forEachRemaining(println)

}
