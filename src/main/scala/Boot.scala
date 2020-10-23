import cats.effect.ExitCode
import monix.eval.{Task, TaskApp}
import monix.execution.Scheduler.Implicits.global

object Boot extends TaskApp {

  val bootstrapServers = List("localhost:9092")
  val topic = "test2"
  val groupId = "3"

  val producer = new Producer(bootstrapServers, topic)
  val consumer = new Consumer(bootstrapServers, groupId, topic)

  override def run(
    args: List[String]
  ): Task[ExitCode] =
    producer.send("Test").map(_ => ExitCode.Success)
}
