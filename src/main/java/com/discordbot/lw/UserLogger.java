package com.discordbot.lw;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserLogger extends ListenerAdapter {
    private User user;

    public UserLogger() {
        this.user = user;
    }
    private User getUser(JDA api) {
        // Acquire a reference to the User instance through the id
        User newUser = api.getUserById(this.user.getIdLong());
        if (newUser != null)
            this.user = newUser;
        return this.user;
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        JDA api = event.getJDA();
        User user = getUser(api);
        user.openPrivateChannel().queue((channel) -> {
            channel.sendMessageFormat("Você acabou de entrar na guild: **%s**", event.getGuild().getName()).queue();
        });
    }
}
