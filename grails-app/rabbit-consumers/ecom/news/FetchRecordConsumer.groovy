package ecom.news

import com.budjb.rabbitmq.consumer.MessageContext

class FetchRecordConsumer {

    static rabbitConfig = [
            queue: "testqueue"
    ]

    def handleMessage(def body, MessageContext context) {
        println body
        return "Hello to you, too!"
    }
}