
import monix.eval.Task
import monix.execution.Scheduler
import monix.kafka.{KafkaProducer, KafkaProducerConfig}
import org.apache.kafka.clients.producer.RecordMetadata


class Producer(bootstrapServers: List[String], topic: String)(implicit scheduler: Scheduler) {

  val producerCfg: KafkaProducerConfig = KafkaProducerConfig.default.copy(
    bootstrapServers = bootstrapServers
  )

  val producer: KafkaProducer[String, String] = KafkaProducer[String, String](producerCfg, scheduler)


  def send(message: String): Task[Option[RecordMetadata]] =
    producer.send(topic, message)

}
