## Steps
- **docker-compose up -d**
- **docker ps** - get container id for kafka
- **docker exec -it [containerId] /bin/bash**
- **cd /opt/bitnami/kafka/** - go to kafka folder with .sh files
- **bin/kafka-topics.sh --create --topic test --bootstrap-server localhost:9092** - create topic
- **bin/kafka-topics.sh --list --zookeeper zookeeper:2181** - get list of topics
- **bin/kafka-topics.sh --describe --zookeeper zookeeper:2181 --topic test** - describe topic
- **bin/kafka-console-producer.sh --topic test --bootstrap-server localhost:9092** - start producer
- **bin/kafka-console-consumer.sh --topic test --from-beginning --bootstrap-server localhost:9092 --consumer-property group.id=1** - start consumer