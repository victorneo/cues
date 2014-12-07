import json
import pika
import sys


connection = pika.BlockingConnection(pika.ConnectionParameters(
        host='localhost'))
channel = connection.channel()

channel.queue_declare(queue='tasks', durable=True)

message = ' '.join(sys.argv[1:]) or "Hello World!"
channel.basic_publish(exchange='cues',
                      routing_key='task_queue',
                      body=json.dumps({'message': message}),
                      properties=pika.BasicProperties(
                         delivery_mode = 2, # make message persistent
                      ))
print " [x] Sent %r" % (message,)
connection.close()
