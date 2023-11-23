package com.discordbot.lw;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class Main {
    public static void main(String[] args) throws LoginException {
        Dotenv dotenv = null;
        dotenv = Dotenv.configure().load();
        JDA jda = JDABuilder.createDefault(dotenv.get("BOT_TOKEN"))
                            .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                            .setActivity(Activity.watching("Gameplay duvidosa"))
                            .addEventListeners(new Listeners())
                            .addEventListeners(new UserLogger())
                            .build();
    }
}