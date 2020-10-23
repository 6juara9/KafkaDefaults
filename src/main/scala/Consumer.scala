import monix.eval.Task
import monix.kafka.{KafkaConsumerConfig, KafkaConsumerObservable}

class Consumer(bootstrapServers: List[String], groupId: String, topic: String) {

  val consumerCfg: KafkaConsumerConfig = KafkaConsumerConfig.default.copy(
    bootstrapServers = bootstrapServers,
    groupId = groupId
  )

  val stream: Task[Unit] =
    KafkaConsumerObservable[String,String](consumerCfg, List(topic)).foreachL(println)

}
