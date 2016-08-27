package ecom.news

import com.budjb.rabbitmq.consumer.MessageContext

class FetchRecordConsumer {

    def feedService

    static rabbitConfig = [
            queue: "testqueue"
    ]

    def handleMessage(def body, MessageContext context) {
        feedService.refreshRecord()
        return "Hello to you, too!"
    }
}