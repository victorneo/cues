(ns cues.core
  (:gen-class)
  (require [langohr.core :as rmq]
           [langohr.channel :as lch]
           [langohr.queue :as lq]
           [langohr.basic :as lb]
           [langohr.consumers :as lcons]))

;; Task handler for new messages received.
(defn handle-task [ch {:keys [headers delivery-tag redelivery?]} ^bytes payload]
  (println (String. payload))
  (lb/ack ch delivery-tag))

;; Connects to localhost RabbitMQ instance using default
;; settings and start consuming messages.
(defn -main
  [& args]
  (let [conn     (rmq/connect)
        ch       (lch/open conn)
        queue    "tasks"
        exchange "cues"
        consumer (lcons/create-default ch {:handle-delivery-fn handle-task
                                           :handle-consume-ok-fn (fn [consumer-tag]
                                                                   (println "Consumer registered"))})]
  (lq/bind ch queue exchange)     ; bind queue to exchange
  (lb/consume ch queue consumer))); start consuming messages in the queue
