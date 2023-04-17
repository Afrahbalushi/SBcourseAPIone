package com.example.firstDemo.Slack;

import org.springframework.stereotype.Component;

@Component
public class SlackClient {


    public String sendMessage(String text) {
        return "Done";
/*        return WebClient.create().post()
                .uri("https://generalcodeli-jgc8446.slack.com/archives/D04EGTUULG1")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new SlackPayload(text))
                .retrieve()
                .bodyToMono(String.class)
                .block();*/
    }


}

