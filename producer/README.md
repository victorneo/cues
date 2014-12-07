## Producer (Python-based)

This directory contains a Python-based RabbitMQ producer which uses the
[Pika](https://pika.readthedocs.org/en/) library to send messages.

### Installation

Install Python on your system first if it is not already installed, then
install the `pika` library and other required dependencies:

    pip install -r requirements.txt


### Sending messages

You can send a custom message if you want, otherwise the script will default to "Hello World!"

    python pikaproducer.py [optional message]
