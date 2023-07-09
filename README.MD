C:\Kafka\bin\windows

start zookeeper-server-start.bat c:\kafka\config\zookeeper.properties

start kafka-server-start.bat c:\kafka\config\server.properties (В случае ошибок zookeeper-server-stop.bat и kafka-server-stop.bat)

kafka-topics.bat --create --bootstrap-server 127.0.0.1:9092 --partitions 1 --replication-factor 1 --topic nero2

 В приложении два продюсера и два потребителя, которые отправляют сообщения в разные топики.
 В одном случае используется кастомный ключ